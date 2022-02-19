package com.testautomation.utils;

import io.cucumber.java.Scenario;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.nio.file.FileSystems;
import java.time.Duration;
import java.util.ArrayList;

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

    private static void scrollElement(String xpath, WebDriver driver) {
        WebElement webElement = findElementByXpath(xpath,driver);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView()", webElement);
    }

    private static void clearText(String xpath, WebDriver driver) {
        WebElement webElement = findElementByXpath(xpath,driver);
        webElement.clear();
    }

    public static void WaitForElementPresentByXpath(String xpath, WebDriver driver){
        FluentWait<WebDriver> wait = initWait(driver);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
    }

    public static void clickByXpath(String xpath, WebDriver driver){
        scrollElement(xpath, driver);
        findElementByXpath(xpath, driver).click();
    }

    public static void doubleClickByXpath(String xpath, WebDriver driver){
        Actions actions = new Actions(driver);

        scrollElement(xpath, driver);
        actions.doubleClick(findElementByXpath(xpath,driver)).perform();
    }

    public static void rightClickByXpath(String xpath, WebDriver driver){
        Actions actions = new Actions(driver);

        scrollElement(xpath, driver);
        actions.contextClick(findElementByXpath(xpath,driver)).perform();
    }

    public static void sendKeysByXpath(String xpath, WebDriver driver, String keys, boolean clear){
        scrollElement(xpath, driver);

        if(clear){
            clearText(xpath,driver);
        }

        findElementByXpath(xpath, driver).sendKeys(keys);
    }

    public static int getElementCount(String xpath, WebDriver driver){
        return driver.findElements(By.xpath(xpath)).size();

    }

    public static String getUrl(WebDriver driver){
        return driver.getCurrentUrl();
    }

    public static String getTextByXpath(String xpath, WebDriver driver){
        return findElementByXpath(xpath, driver).getText();
    }

    public static void scenarioWrite(Scenario scenario, String text, String name) {
        scenario.attach(text,"text/plain",name);
    }

    public static void generateDummyImage(int width, int height, String name) throws Exception {
        String targetPath = FileSystems.getDefault().getPath("").toAbsolutePath() + File.separator + "target";

        BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_BYTE_GRAY);
        ImageIO.write(image, "jpg", new FileOutputStream(targetPath + File.separator + name+".jpg"));
    }

    public static ArrayList<String> getWindowHandlers(WebDriver driver) throws Exception {
        ArrayList<String> windowHandles = null;
        for (int i = 0; i < 10; i++) {
            if (driver.getWindowHandles().size() > 1) {
                windowHandles = new ArrayList<String>(driver.getWindowHandles());
                break;
            } else {
                Thread.sleep(100);
            }
        }
        return windowHandles;
    }
    public static boolean isAlertPresent(WebDriver driver) throws Exception {
        for (int i = 0; i < 10; i++) {
            try{
                driver.switchTo().alert();
                return true;
            }catch (NoAlertPresentException ignored){
                Thread.sleep(100);
            }
        }
        return false;
    }

    public static void checkAlertThenAccept(WebDriver driver) throws Exception {
        isAlertPresent(driver);
        acceptAlert(driver);
    }

    public static void acceptAlert(WebDriver driver){
        driver.switchTo().alert().accept();
    }

    public static void cancelAlert(WebDriver driver){
        driver.switchTo().alert().dismiss();
    }

    public static void typeInAlert(String text, WebDriver driver){
        driver.switchTo().alert().sendKeys(text);
        driver.switchTo().alert().accept();
    }

    public static void SwitchTab(int tab, WebDriver driver) throws Exception {
        ArrayList<String> windowHandles = getWindowHandlers(driver);
        driver.switchTo().window(windowHandles.get(tab));
    }

    public static String generateString(int i){
        return RandomStringUtils.randomAlphanumeric(i);
    }

    public static int generateInteger(int i){
        return Integer.parseInt(RandomStringUtils.randomNumeric(i));
    }
}
