package com.testautomation.api.petstore.requests;

import com.github.mizosoft.methanol.MultipartBodyPublisher;
import com.google.gson.GsonBuilder;
import com.testautomation.api.petstore.interfaces.PetRequestInterface;
import com.testautomation.pojo.*;
import com.testautomation.stepdef.Hooks;
import com.testautomation.utils.Helper;
import com.testautomation.utils.PropertiesUtils;

import java.io.File;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;

public class PetRequest extends Request implements PetRequestInterface {

    public PetRequest() throws Exception {
        PropertiesUtils.setEnvironment("petstore");
    }

    @Override
    public Pet createPet(int id, String name, String status, List<String> photoUrls, Category category, List<Tag> tags) throws Exception {
        Pet pet = new Pet();
        pet.setId(id);
        pet.setName(name);
        pet.setStatus(status);
        pet.setPhotoUrls(photoUrls);
        pet.setCategory(category);
        pet.setTags(tags);

        String post = new GsonBuilder().create().toJson(pet);

        HttpResponse<String> response = postRequest(PropertiesUtils.getEnvironmentProperty("petstorePetApi"),post);
        Helper.scenarioWrite(Hooks.getScenario(),response.body(),"Response");

        Pet petResponse = new GsonBuilder().create().fromJson(response.body(), Pet.class);
        petResponse.setCode(response.statusCode());

        return petResponse;
    }

    @Override
    public ApiResponse uploadImage(int id, String additionalMetadata, File file) throws Exception {
        MultipartBodyPublisher multipartBody = MultipartBodyPublisher.newBuilder()
                .formPart("additionalMetadata", HttpRequest.BodyPublishers.ofString(additionalMetadata))
                .filePart("file",file.toPath())
                .build();

        HttpResponse<String> response = formRequest(PropertiesUtils.getEnvironmentProperty("petstorePetApi")+"/"+id+"/uploadImage",multipartBody);
        Helper.scenarioWrite(Hooks.getScenario(),response.body(),"Response");

        return new GsonBuilder().create().fromJson(response.body(), ApiResponse.class);
    }

    @Override
    public Pet getPet(int id, int x) throws Exception {
        Pet pet;
        HttpResponse<String> response = null;

        for(int i = 0; i < x; i++){
            response = getRequest(PropertiesUtils.getEnvironmentProperty("petstorePetApi")+"/"+id);
            if(response.statusCode()==200){
                break;
            }
        }
        Helper.scenarioWrite(Hooks.getScenario(),response.body(),"Response");
        pet = new GsonBuilder().create().fromJson(response.body(), Pet.class);
        pet.setCode(response.statusCode());

        return pet;
    }

    @Override
    public ApiResponse updatePet(int id, String name, String status, int x) throws Exception {
        ApiResponse apiResponse;
        HttpResponse<String> response = null;

        StringBuilder post = new StringBuilder();
        post.append("petId=").append(id).append("&name=").append(name).append("&status=").append(status);



        for(int i = 0; i < x; i++){
            response = urlencodedRequest(PropertiesUtils.getEnvironmentProperty("petstorePetApi")+"/"+id, post.toString());
            if(response.statusCode()==200){
                break;
            }
        }
        Helper.scenarioWrite(Hooks.getScenario(),response.body(),"Response");
        apiResponse = new GsonBuilder().create().fromJson(response.body(), ApiResponse.class);
        apiResponse.setCode(response.statusCode());

        return apiResponse;
    }

    @Override
    public boolean deletePet(int id, int x) throws Exception {

        for(int i = 0; i < x; i++){
            HttpResponse<String> response = deleteRequest(PropertiesUtils.getEnvironmentProperty("petstorePetApi")+"/"+id);
            if(response.statusCode()==200){
                Helper.scenarioWrite(Hooks.getScenario(), response.body(), "Response");
                return true;
            }
        }
        Helper.scenarioWrite(Hooks.getScenario(), "{\"code\":404 Not Found}", "Response");
        return false;

    }
}
