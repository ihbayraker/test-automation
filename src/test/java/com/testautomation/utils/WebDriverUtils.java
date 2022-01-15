package com.testautomation.utils;

import com.testautomation.drivers.DriverFactory;
import com.testautomation.drivers.DriverManager;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.time.Duration;

public class WebDriverUtils {

    private static WebDriver browser = null;

    public static WebDriver startDriver() throws Exception {
        DriverManager driverManager = DriverFactory.getDriverManager();
        browser = driverManager.getWebDriver();
        return browser;
    }

    public static void manageDriver(int pageLoadTimeout, int implictWait) {
        browser.manage().deleteAllCookies();
        browser.manage().window().maximize();
        browser.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(pageLoadTimeout));
        browser.manage().timeouts().implicitlyWait(Duration.ofSeconds(implictWait));
    }

    public static void quitWebDriver(){
        if (null != browser){
            browser.quit();
        }
    }
    public static void takeScreenshot(Scenario scenario, String name) throws Exception {
        File screenshot = ((TakesScreenshot)browser).getScreenshotAs(OutputType.FILE);
        BufferedImage img = ImageIO.read(screenshot);

        BufferedImage jpeg = new BufferedImage(img.getWidth(), img.getHeight(), BufferedImage.TYPE_INT_RGB);
        jpeg.createGraphics().drawImage(img, 0, 0, Color.WHITE, null);

        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        ImageIO.write(jpeg, "jpg", bos);
        byte[] image = bos.toByteArray();

        scenario.attach(image,"image/jpeg",name);
    }
}