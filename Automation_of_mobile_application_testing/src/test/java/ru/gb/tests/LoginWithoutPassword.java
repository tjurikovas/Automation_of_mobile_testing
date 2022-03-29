package ru.gb.tests;

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
public class LoginWithoutPassword extends BaseTest {

    @Test
    public void loginWithoutPassword () {
        openApp("ASUS_Z017D_1").clickLoginMenuButton()
                .inputEmailCorrected()
                .clickLoginButton()
                .checkErrorText("Please enter at least 8 characters");
    }

//    MobileDriver driver;
//    private final static String APPLICATION_URL = "http://0.0.0.0:4723/wd/hub";
//
//    @Test
//    public void checkEmptyEmail() throws Exception {
//
//        DesiredCapabilities capabilities = new DesiredCapabilities();
//
//        capabilities.setCapability("deviceName", "ASUS_Z017D_1");
//        capabilities.setCapability("udid", "G8AZCY0528065H5");
//        capabilities.setCapability("platformName", "Android");
//        capabilities.setCapability("platformVersion", "8");
//        capabilities.setCapability("app", "C:\\Users\\tjuri\\OneDrive\\Рабочий стол\\Automation_of_mobile_application_testing\\Android-NativeDemoApp-0.2.1.apk");
//        capabilities.setCapability("automationName", "UiAutomator2");
//
//        driver = new AndroidDriver(new URL(APPLICATION_URL), capabilities);
//
//        Thread.sleep(2000);
//        //Клик по Login
//        MobileElement loginMenuButton = (MobileElement) driver.findElementByAccessibilityId("Login");
//        loginMenuButton.click();
//        Thread.sleep(2000);
//        //Send Keys
//        MobileElement inputEmail = (MobileElement) driver.findElementByAccessibilityId("input-email");
//        inputEmail.sendKeys("email@domain.com");
//        Thread.sleep(500);
//        //Клик Login
//        MobileElement loginButton = (MobileElement) driver.findElementByAccessibilityId("button-LOGIN");
//        loginButton.click();
//        Thread.sleep(2000);
////      Проверяем текст ошибки.
//        MobileElement errorText = (MobileElement) driver.findElementByXPath("//android.widget.ScrollView[@content-desc=\"Login-screen\"]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[4]/android.widget.TextView");
//        Assert.assertEquals(errorText.getText(), "Please enter at least 8 characters");
//    }
}
