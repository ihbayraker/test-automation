package com.testautomation.utils;

import com.testautomation.drivers.DriverFactory;
import com.testautomation.drivers.DriverManager;
import com.testautomation.stepdef.Hooks;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.time.Duration;

public class WebDriverUtils {

    private static WebDriver browser = null;

    public static WebDriver startDriver() throws Exception {
        if(browser==null){
            DriverManager driverManager = DriverFactory.getDriverManager();
            browser = driverManager.getWebDriver();
            manageDriver(20,10);
        }
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
            try{
                browser.quit();
            }catch (WebDriverException ignored){
                browser.quit();
            }
            browser = null;
        }
    }
    public static void takeScreenshot(Scenario scenario, String name) throws Exception {
        if(Hooks.getScenarioTags().contains("@web")){

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

    public static void killDrivers() throws Exception {
        String browser = PropertiesUtils.getPomProperty("browser");
        switch (browser) {
            case "chrome" -> Runtime.getRuntime().exec("taskkill /F /IM chromedriver.exe");
            case "firefox" -> Runtime.getRuntime().exec("taskkill /F /IM geckodriver.exe");
            case "opera" -> Runtime.getRuntime().exec("taskkill /F /IM operadriver.exe");
            case "edge" -> Runtime.getRuntime().exec("taskkill /F /IM msedgedriver.exe");
        }
    }
}
