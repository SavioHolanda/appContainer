package modulos.driver;

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
       // if (driver == null) {
            createDriver();
       // }
        return driver;
    }

    private static void createDriver() {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("app","D:\\Prestação de serviço\\Atividades\\homolog-container\\1.1.35\\app-homol-login-new.apk");
        //capabilities.setCapability("deviceName","emulator-5554");
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