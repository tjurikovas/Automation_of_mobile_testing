package ru.gb.tests.main;

import io.appium.java_client.MobileDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import ru.gb.base.BaseTest;
import ru.gb.listeners.AllureListeners;

import java.net.URL;

@Listeners(AllureListeners.class)
public class MyFirstTest  extends BaseTest {

    MobileDriver driver;
    private final static String APPLICATION_URL = "http://0.0.0.0:4723/wd/hub";


    @Test
    public void checkEmptyEmail() {
        openApp("ASUS_Z017D_1")
                .clickLoginMenuButton()
                .clickLoginButton()
                .checkErrorTextWithoutEmail("Please enter at least 8 characters");

//        // Устанавливаем capabilities.
//        DesiredCapabilities capabilities = new DesiredCapabilities();
//
//        capabilities.setCapability("deviceName", "ASUS_Z017D_1");
//        capabilities.setCapability("udid", "G8AZCY0528065H5");
//        capabilities.setCapability("platformName", "Android");
//        capabilities.setCapability("platformVersion", "8");
//        capabilities.setCapability("app", "C:\\Users\\tjuri\\OneDrive\\Рабочий стол\\Automation_of_mobile_application_testing\\Android-NativeDemoApp-0.2.1.apk");
//        //      Проверьте актуальность пути до приложения на своём компьютере.
//        capabilities.setCapability("automationName", "UiAutomator2");
//
//        driver = new AndroidDriver(new URL(APPLICATION_URL), capabilities);
//
//        Thread.sleep(2000);
//        MobileElement loginMenuButton = (MobileElement) driver.findElementByAccessibilityId("Login");
//        loginMenuButton.click();
//        Thread.sleep(2000);
////      Нажимаем Login на странице логин/пароль.
//        MobileElement loginButton = (MobileElement) driver.findElementByAccessibilityId("button-LOGIN");
//        loginButton.click();
//        Thread.sleep(2000);
////      Проверяем текст ошибки.
//        MobileElement errorText = (MobileElement) driver.findElementByXPath("//android.widget.ScrollView[@content-desc=\"Login-screen\"]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[4]/android.widget.TextView[1]");
//        Assert.assertEquals(errorText.getText(), "Please enter a valid email address");
    }
}
