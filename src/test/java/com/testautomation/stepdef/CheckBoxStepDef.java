package com.testautomation.stepdef;

import com.testautomation.pageobjects.web.DemoqaElementsPageObjects;
import com.testautomation.pageobjects.web.DemoqaHomePageObjects;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.junit.Assert;

import java.util.ArrayList;

public class CheckBoxStepDef {

    private final DemoqaHomePageObjects demoqaHomePageObjects;
    private final DemoqaElementsPageObjects demoqaElementsPageObjects;
    private ArrayList<String> nodes = new ArrayList<>();

    public CheckBoxStepDef() throws Exception {
        demoqaHomePageObjects = new DemoqaHomePageObjects();
        demoqaElementsPageObjects = new DemoqaElementsPageObjects();
    }

    @And("I click Check box")
    public void iClickCheckBox(){
        demoqaHomePageObjects.selectItem(2);
    }

    @And("I unwind tree nodes")
    public void iUnwindTreeNodes(){
        demoqaElementsPageObjects.unwindNodes(1);
        demoqaElementsPageObjects.unwindNodes(2);
        demoqaElementsPageObjects.unwindNodes(4);
        demoqaElementsPageObjects.unwindNodes(3);
        demoqaElementsPageObjects.unwindNodes(4);
        demoqaElementsPageObjects.unwindNodes(5);
    }

    @Then("I toggle few nodes")
    public void iToggleFewNodes(){
        nodes.add(demoqaElementsPageObjects.toggleNodes(7));
        nodes.add(demoqaElementsPageObjects.toggleNodes(13));

    }

    @Then("I validate the checked nodes")
    public void iValidateTheCheckedNodes(){
        String Output = demoqaElementsPageObjects.checkSelectedNodes();
        Assert.assertTrue((nodes.get(0))+" was supposed to be toggled",Output.contains(nodes.get(0)));
        Assert.assertTrue((nodes.get(1))+" was supposed to be toggled",Output.contains(nodes.get(1)));
    }

}
