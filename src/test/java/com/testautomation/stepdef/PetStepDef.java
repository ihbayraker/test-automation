package com.testautomation.stepdef;

import com.testautomation.api.petstore.requests.OrderRequest;
import com.testautomation.api.petstore.requests.PetRequest;
import com.testautomation.pojo.*;
import com.testautomation.utils.Helper;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;

import java.io.File;
import java.nio.file.FileSystems;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class PetStepDef {

    private final PetRequest petRequest;
    private final OrderRequest orderRequest;
    private final int id;
    private final int orderId;
    private final List<String> photoUrls = new ArrayList<>();
    private final Category category = new Category();
    private final Tag tag = new Tag();

    private String name;
    private String status;

    public PetStepDef() throws Exception {
        petRequest = new PetRequest();
        orderRequest = new OrderRequest();
        orderId = Helper.generateInteger(8);
        id = Helper.generateInteger(8);
    }

    @Given("I create a new pet with name:{string}, category:{string}, tag:{string}")
    public void iCreateANewPetWithNameCategoryTag(String petName, String categoryName, String tagName) throws Exception {
        name = petName;
        status = "available";

        photoUrls.add("https://image.com/example.jpeg");
        photoUrls.add("https://image.com/example2.jpeg");

        category.setId(Helper.generateInteger(2));
        category.setName(categoryName);

        List<Tag> tags = new ArrayList<>();

        Tag newborn = new Tag();
        newborn.setId(1);;
        newborn.setName("newborn");
        tags.add(newborn);

        tag.setId(Helper.generateInteger(2));;
        tag.setName(tagName);
        tags.add(tag);

        Pet pet = petRequest.createPet(id,name,status,photoUrls,category,tags);
        Assert.assertEquals("User creation was a failure", 200, pet.getCode());

    }
    @Then("I check the pet")
    public void iCheckThePet() throws Exception {
        Pet pet = petRequest.getPet(id, 10);

        Assert.assertEquals("Could not find the pet", 200, pet.getCode());
        Assert.assertEquals("name of the user was wrong", name, pet.getName());
        Assert.assertEquals("Category name of the pet was wrong", category.getName(), pet.getCategory().getName());
        Assert.assertEquals("photoUrls of the pet was wrong", photoUrls, pet.getPhotoUrls());
        Assert.assertEquals("tags of the pet was wrong", tag.getName(), pet.getTags().get(1).getName());
        Assert.assertEquals("status of the pet was wrong", status, pet.getStatus());
    }

    @And("I upload an image for the pet")
    public void iUploadAnImageForThePet() throws Exception {
        Helper.generateDummyImage(500,500,"pet");
        String metadata = Helper.generateString(8);

        String targetPath = FileSystems.getDefault().getPath("").toAbsolutePath() + File.separator + "target";
        String filePath = targetPath + File.separator + "pet.jpg";
        File file = new File(filePath);

        ApiResponse apiResponse = petRequest.uploadImage(id,metadata,file);
        file.delete();

        Assert.assertTrue("Image upload was a failure", apiResponse.getMessage().contains("File uploaded"));
    }

    @Then("I update the pet")
    public void iUpdateThePet() throws Exception {
        name = name+"Updated";
        status = "sold";

        ApiResponse apiResponse = petRequest.updatePet(id,name,status,10);
        Assert.assertEquals("Pet update was a failure", 200, apiResponse.getCode());
    }

    @Then("I delete the pet")
    public void iDeleteThePet() throws Exception {
        Assert.assertTrue("Could not delete the pet",petRequest.deletePet(id,10));
    }

    @Then("I check that pet is deleted")
    public void iCheckThatPetIsDeleted() throws Exception {
        Pet pet = petRequest.getPet(id, 1);

        Assert.assertNotEquals("The pet was still available", 200, pet.getCode());
    }

    @Then("I place an order for the created pet")
    public void iPlaceAnOrderForTheCreatedPet() throws Exception {
        Order order = orderRequest.placeOrder(orderId, id, 1, LocalDate.now().toString(), "placed", false);
        Assert.assertEquals("Could not place an order", 200, order.getCode());
    }

    @And("I validate my order is registered")
    public void iValidateMyOrderIsRegistered() throws Exception {
        Order order = orderRequest.getOrder(orderId, 10);

        Assert.assertEquals("Could not find the order", 200, order.getCode());
        Assert.assertEquals("The quantity in the order was wrong", 1, order.getQuantity());
        Assert.assertEquals("The status of the order was wrong", "placed", order.getStatus());
        Assert.assertFalse("The order is showing complete when its brand new", order.isComplete());
    }

    @Then("I delete the order I put")
    public void iDeleteTheOrderIPut() throws Exception {
        Assert.assertTrue("Could not delete the pet",orderRequest.deleteOrder(orderId,10));
    }

    @And("I check that order is not available")
    public void iCheckThatOrderIsNotAvailable() throws Exception {
        Order order = orderRequest.getOrder(id, 1);

        Assert.assertNotEquals("The order was still available", 200, order.getCode());
    }
}
