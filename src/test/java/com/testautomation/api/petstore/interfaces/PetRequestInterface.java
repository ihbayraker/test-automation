package com.testautomation.api.petstore.interfaces;


import com.testautomation.pojo.ApiResponse;
import com.testautomation.pojo.Category;
import com.testautomation.pojo.Pet;
import com.testautomation.pojo.Tag;

import java.io.File;
import java.util.List;

public interface PetRequestInterface extends RequestInterface {

    Pet createPet(int id, String name, String status, List<String> photoUrls, Category category, List<Tag> tags) throws Exception;

    ApiResponse uploadImage(int id, String additionalMetadata, File file) throws Exception;

    Pet getPet(int id, int x) throws Exception;

    ApiResponse updatePet(int id, String name, String status, int x) throws Exception;

    boolean deletePet(int id, int x) throws Exception;
}
