package com.testautomation.api.petstore.requests;

import com.google.gson.GsonBuilder;
import com.testautomation.api.petstore.interfaces.OrderRequestInterface;
import com.testautomation.pojo.Order;
import com.testautomation.stepdef.Hooks;
import com.testautomation.utils.Helper;
import com.testautomation.utils.PropertiesUtils;

import java.net.http.HttpResponse;

public class OrderRequest extends Request implements OrderRequestInterface {

    public OrderRequest() throws Exception {
        PropertiesUtils.setEnvironment("petstore");
    }

    @Override
    public Order placeOrder(int id, int petId, int quantity, String shipDate, String status, boolean complete) throws Exception {
        Order order = new Order();

        order.setId(id);
        order.setPetId(petId);
        order.setQuantity(quantity);
        order.setShipDate(shipDate);
        order.setStatus(status);
        order.setComplete(complete);

        String post = new GsonBuilder().create().toJson(order);

        HttpResponse<String> response = postRequest(PropertiesUtils.getEnvironmentProperty("petstoreOrderApi"),post);
        Helper.scenarioWrite(Hooks.getScenario(),response.body(),"Response");

        Order orderResponse = new GsonBuilder().create().fromJson(response.body(), Order.class);
        orderResponse.setCode(response.statusCode());

        return orderResponse;
    }

    @Override
    public Order getOrder(int id, int x) throws Exception {
        Order order;
        HttpResponse<String> response = null;

        for(int i = 0; i < x; i++){
            response = getRequest(PropertiesUtils.getEnvironmentProperty("petstoreOrderApi")+"/"+id);
            if(response.statusCode()==200){
                break;
            }
        }
        Helper.scenarioWrite(Hooks.getScenario(),response.body(),"Response");
        order = new GsonBuilder().create().fromJson(response.body(), Order.class);
        order.setCode(response.statusCode());

        return order;
    }

    @Override
    public boolean deleteOrder(int id, int x) throws Exception {
        for(int i = 0; i < x; i++){
            HttpResponse<String> response = deleteRequest(PropertiesUtils.getEnvironmentProperty("petstoreOrderApi")+"/"+id);
            if(response.statusCode()==200){
                Helper.scenarioWrite(Hooks.getScenario(), response.body(), "Response");
                return true;
            }
        }
        Helper.scenarioWrite(Hooks.getScenario(), "{\"code\":404 Not Found}", "Response");
        return false;

    }

}
