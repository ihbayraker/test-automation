package com.testautomation.api.petstore.interfaces;

import com.github.mizosoft.methanol.MultipartBodyPublisher;

import java.net.http.HttpResponse;

public interface RequestInterface {

    HttpResponse<String> getRequest(String url) throws Exception;

    HttpResponse<String> deleteRequest(String url) throws Exception;

    HttpResponse<String> postRequest(String url, String post) throws Exception;

    HttpResponse<String> urlencodedRequest(String url, String post) throws Exception;

    HttpResponse<String> formRequest(String url, MultipartBodyPublisher multipartBody) throws Exception;

    HttpResponse<String> putRequest(String url, String post) throws Exception;
}
