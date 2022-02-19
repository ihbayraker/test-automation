package com.testautomation.api.petstore.interfaces;


import com.testautomation.pojo.Order;

public interface OrderRequestInterface extends RequestInterface {

    Order placeOrder(int id, int petId, int quantity, String shipDate, String status, boolean complete) throws Exception;

    Order getOrder(int id, int x) throws Exception;

    boolean deleteOrder(int id, int x) throws Exception;
}
