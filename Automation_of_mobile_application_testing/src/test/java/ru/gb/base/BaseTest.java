package ru.gb.base;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import ru.gb.pages.MainPage;

import java.net.MalformedURLException;
import java.net.URL;

// базовый класс для всех будущих тестов.
public class BaseTest {

    // метод который будет открывать наше приложение на телефоне.
    public MainPage openApp() {
        WebDriver driver = null;
        try {
            driver = getDriver();
        } catch (MalformedURLException e) {
            e.printStackTrace();
            System.out.println("Opps, we have problems with URL for driver!");
        }
        // устанавливаем драйвер для selenide.
        WebDriverRunner.setWebDriver(driver);
        // возвращаем главную страницу для будущей работы с ней в тесте.
        return new MainPage();
    }

    @AfterClass
    public void setDown(){
        Selenide.close();
    }


    public static WebDriver getDriver() throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();

        switch (System.getProperty("platform")) {
            case "Android":
                // устанавливаем capabilities.
                capabilities.setCapability("platformName", "Android");
                capabilities.setCapability("deviceName", "ASUS_Z017D_1");
                capabilities.setCapability("platformVersion", "8");
                capabilities.setCapability("udid", "G8AZCY0528065H5");
                capabilities.setCapability("automationName", "UiAutomator2");
                capabilities.setCapability("app", "C:\\Users\\tjuri\\OneDrive\\Рабочий стол\\Automation_of_mobile_application_testing\\Android-NativeDemoApp-0.2.1.apk");
                break;
            case "iOS":
                // устанавливаем capabilities.
                capabilities.setCapability("platformName", "iOS");
                capabilities.setCapability("deviceName", "iPhone");
                capabilities.setCapability("platformVersion", "15");
                capabilities.setCapability("udid", "2E20F3A4-ACC1-4799-A4F5-83358E56AB2E");
                capabilities.setCapability("automationName", "XCUITest");
                capabilities.setCapability("app", "C:\\Users\\tjuri\\OneDrive\\Рабочий стол\\Automation_of_mobile_application_testing\\Android-NativeDemoApp-0.2.1.apk");
                break;
        }

        // Папка для сохранения скриншотов selenide.
        Configuration.reportsFolder = "screenshots/actual";

        // Устанавливаем и открываем приложение.
        return new AppiumDriver<>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
    }

//    public  AndroidDriver getAndroidDriver() throws MalformedURLException {
//        // устанавливаем capabilities.
//        DesiredCapabilities capabilities = new DesiredCapabilities();
//
//        capabilities.setCapability("platformName", "Android");
//        // указываем для appium на каком девайсе хотим запускать тест.
//        switch (){
//            case "ASUS_Z017D_1":
//                capabilities.setCapability("udid", "G8AZCY0528065H5");
//                break;
//            case "pixel 11":
//                capabilities.setCapability("udid", "emulator-5554");
//                break;
//        }
//        capabilities.setCapability("app", "C:\\Users\\tjuri\\OneDrive\\Рабочий стол\\Automation_of_mobile_application_testing\\Android-NativeDemoApp-0.2.1.apk");
//
//        // папка для сохранения скриншотов selenide.
//        Configuration.reportsFolder = "screenshots/actual";
//
//        // устанавливаем и открываем приложение. !!! Указываем URL Grid !!!
//        return new AndroidDriver(new URL("http://192.168.0.104:4444/wd/hub"), capabilities);
//    }
}
