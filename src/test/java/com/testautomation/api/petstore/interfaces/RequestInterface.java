package com.testautomation.api.petstore.interfaces;

import java.net.http.HttpResponse;

public interface RequestInterface {

    HttpResponse<String> getRequest(String url) throws Exception;

    HttpResponse<String> deleteRequest(String url) throws Exception;

    HttpResponse<String> postRequest(String url, String post) throws Exception;

    HttpResponse<String> putRequest(String url, String post) throws Exception;
}
