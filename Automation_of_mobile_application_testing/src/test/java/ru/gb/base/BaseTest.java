package ru.gb.base;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import ru.gb.pages.MainPage;

import java.net.MalformedURLException;
import java.net.URL;

public class BaseTest {

    // метод, который будет открывать наше приложение на телефоне
    public MainPage openApp() {
        WebDriver driver = null;
        try {
            driver = getAndroidDriver();
        } catch (MalformedURLException e) {
            e.printStackTrace();
            System.out.println("Opps, we have problems with URL for driver!");
        }
        // устанавливаем драйвер для selenide
        WebDriverRunner.setWebDriver(driver);
        // возвращаем главную страницу для будущей работы с ней в тесте
        return new MainPage();
    }

    public static WebDriver getAndroidDriver() throws MalformedURLException {
        // устанавливаем capabilities
        DesiredCapabilities capabilities = new DesiredCapabilities();

        capabilities.setCapability("deviceName", "ASUS_Z017D_1");
        capabilities.setCapability("udid", "G8AZCY0528065H5");
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("platformVersion", "8");
        capabilities.setCapability("automationName", "UiAutomator2");
        capabilities.setCapability("app", "C:\\\\Users\\\\tjuri\\\\OneDrive\\\\Рабочий стол\\\\Automation_of_mobile_application_testing\\\\Android-NativeDemoApp-0.2.1.apk");
        // папка для сохранения скриншотов selenide
        Configuration.reportsFolder = "screenshots/actual";
        // устанавливаем и открываем приложение
        return new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
    }

    @AfterClass
    public void setDown(){
        Selenide.close();
    }
}
