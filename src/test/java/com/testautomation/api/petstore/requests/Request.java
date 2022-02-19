package com.testautomation.api.petstore.requests;


import com.github.mizosoft.methanol.MultipartBodyPublisher;
import com.testautomation.api.petstore.interfaces.RequestInterface;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;

public class Request implements RequestInterface {

    @Override
    public HttpResponse<String> getRequest(String url) throws Exception {
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .GET()
                .uri(URI.create(url))
                .header("Content-Type","application/json")
                .timeout(Duration.ofSeconds(10))
                .version(HttpClient.Version.HTTP_1_1)
                .build();

        return client.send(request, HttpResponse.BodyHandlers.ofString());
    }

    @Override
    public HttpResponse<String> deleteRequest(String url) throws Exception {
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .DELETE()
                .uri(URI.create(url))
                .header("Content-Type","application/json")
                .timeout(Duration.ofSeconds(10))
                .version(HttpClient.Version.HTTP_1_1)
                .build();

        return client.send(request, HttpResponse.BodyHandlers.ofString());
    }

    @Override
    public HttpResponse<String> postRequest(String url, String post) throws Exception {
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .POST(HttpRequest.BodyPublishers.ofString(post))
                .uri(URI.create(url))
                .header("Content-Type","application/json")
                .timeout(Duration.ofSeconds(10))
                .version(HttpClient.Version.HTTP_1_1)
                .build();

        return client.send(request, HttpResponse.BodyHandlers.ofString());
    }

    @Override
    public HttpResponse<String> urlencodedRequest(String url, String post) throws Exception {
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .POST(HttpRequest.BodyPublishers.ofString(post))
                .uri(URI.create(url))
                .header("Content-Type","application/x-www-form-urlencoded")
                .timeout(Duration.ofSeconds(10))
                .version(HttpClient.Version.HTTP_1_1)
                .build();

        return client.send(request, HttpResponse.BodyHandlers.ofString());
    }


    @Override
    public HttpResponse<String> formRequest(String url, MultipartBodyPublisher multipartBody) throws Exception {
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .POST(multipartBody)
                .uri(URI.create(url))
                .header("Content-Type", "multipart/form-data; boundary=" + multipartBody.boundary())
                .timeout(Duration.ofSeconds(10))
                .version(HttpClient.Version.HTTP_1_1)
                .build();

        return client.send(request, HttpResponse.BodyHandlers.ofString());
    }

    @Override
    public HttpResponse<String> putRequest(String url, String post) throws Exception {
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .PUT(HttpRequest.BodyPublishers.ofString(post))
                .uri(URI.create(url))
                .header("Content-Type","application/json")
                .timeout(Duration.ofSeconds(10))
                .version(HttpClient.Version.HTTP_1_1)
                .build();

        return client.send(request, HttpResponse.BodyHandlers.ofString());
    }
}
