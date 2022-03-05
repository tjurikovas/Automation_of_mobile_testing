package ru.gb;

import io.appium.java_client.MobileDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.net.URL;

public class MySecondTest {

    MobileDriver driver;
    private final static String APPLICATION_URL = "http://0.0.0.0:4723/wd/hub";


    @Test
    public void checkEmptyEmail() throws Exception {

        DesiredCapabilities capabilities = new DesiredCapabilities();

        capabilities.setCapability("deviceName", "ASUS_Z017D_1");
        capabilities.setCapability("udid", "G8AZCY0528065H5");
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("platformVersion", "8");
        capabilities.setCapability("app", "C:\\Users\\tjuri\\OneDrive\\Рабочий стол\\Automation_of_mobile_application_testing\\Android-NativeDemoApp-0.2.1.apk");
        capabilities.setCapability("automationName", "UiAutomator2");

        driver = new AndroidDriver(new URL(APPLICATION_URL), capabilities);

        Thread.sleep(2000);
        //Клик по WebView
        MobileElement webViewButton = (MobileElement) driver.findElement(By.xpath("//android.view.ViewGroup[@content-desc=\"WebView\"]/android.view.ViewGroup/android.widget.TextView"));
        webViewButton.click();
        Thread.sleep(15000);
        //Клик по меню
        MobileElement menuButton = (MobileElement) driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup[1]/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View[2]/android.widget.Button"));
        menuButton.click();
        Thread.sleep(3000);
        //Клик по Docs
        MobileElement docsButton = (MobileElement) driver.findElement(By.xpath("//android.view.View[@content-desc=\"Docs\"]/android.widget.TextView"));
        docsButton.click();
        Thread.sleep(2000);
//      Проверяем текст.
        MobileElement docsText = (MobileElement) driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup[1]/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View[3]/android.view.View/android.view.View[1]/android.widget.TextView"));
        Assert.assertEquals(docsText.getText(), "Getting Started");
    }
}
