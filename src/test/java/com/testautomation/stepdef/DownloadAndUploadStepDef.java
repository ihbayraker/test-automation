package com.testautomation.stepdef;

import com.testautomation.pageobjects.web.DemoqaElementsPageObjects;
import com.testautomation.pageobjects.web.DemoqaHomePageObjects;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.junit.Assert;

public class DownloadAndUploadStepDef {

    private final DemoqaHomePageObjects demoqaHomePageObjects;
    private final DemoqaElementsPageObjects demoqaElementsPageObjects;

    public DownloadAndUploadStepDef() throws Exception {
        demoqaHomePageObjects = new DemoqaHomePageObjects();
        demoqaElementsPageObjects = new DemoqaElementsPageObjects();
    }

    @And("I click Download and Upload")
    public void iClickDownloadAndUpload() throws Exception {
        demoqaHomePageObjects.selectItem(8);
    }

    @Then("I press download button")
    public void iPressDownloadButton() {
        demoqaElementsPageObjects.pressDownloadFile();
    }

    @And("I validate that i downloaded the file")
    public void iValidateThatIDownloadedTheFile() throws Exception {
        Assert.assertTrue("Couldn't find the downloaded file",demoqaElementsPageObjects.checkFileDownloaded("sampleFile.jpeg"));
    }

    @Then("I upload the downloaded file back")
    public void iUploadTheDownloadedFileBack() throws Exception {
        demoqaElementsPageObjects.uploadDownloadedFile("sampleFile.jpeg");
    }

    @And("I validate that i uploaded the file")
    public void iValidateThatIUploadedTheFile() throws Exception {
        demoqaElementsPageObjects.checkFileUploadedAndErase("sampleFile.jpeg");
    }
}
