package config;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

public class AndroidDriverProvider {
    private static AndroidDriver driver;

    public static void setDriver(AndroidDriver androidDriver) {
        driver = androidDriver;
    }

    public static AndroidDriver getDriver() {
            createDriver();
        return driver;
    }
    private static void createDriver() {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("app","C:\\RepositórioNHG\\apps\\homolog-container\\1.1.36\\app-indique-sdk.apk");
        capabilities.setCapability("deviceName","ZF5245R8X4");
        capabilities.setCapability("platformName", "Android");

        try {
            URL appiumServerUrl = new URL("http://localhost:4723/wd/hub");
            driver = new AndroidDriver(appiumServerUrl, capabilities);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }
}