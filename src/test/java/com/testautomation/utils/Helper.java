package com.testautomation.utils;

import io.cucumber.java.Scenario;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.time.Duration;

public class Helper {

    final static int timeout = 10;
    final static int polling = 1;

    private static FluentWait<WebDriver> initWait(WebDriver driver){
        FluentWait<WebDriver> wait = new FluentWait<>(driver);
        wait.withTimeout(Duration.ofSeconds(timeout));
        wait.pollingEvery(Duration.ofSeconds(polling));
        wait.ignoring(NoSuchElementException.class);
        return wait;
    }

    private static WebElement findElementByXpath(String xpath, WebDriver driver){
        return driver.findElement(By.xpath(xpath));
    }

    public static void WaitForElementPresentByXpath(String xpath, WebDriver driver){
        FluentWait<WebDriver> wait = initWait(driver);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
    }

    public static void clickByXpath(String xpath, WebDriver driver){
        findElementByXpath(xpath, driver).click();
    }

    public static void sendKeysByXpath(String xpath, WebDriver driver, String keys){
        findElementByXpath(xpath, driver).sendKeys(keys);
    }

    public static String getTextByXpath(String xpath, WebDriver driver){
        return findElementByXpath(xpath, driver).getText();
    }

    public static void scenarioWrite(Scenario scenario, String text, String name) {
        scenario.attach(text,"text/plain",name);
    }

}
