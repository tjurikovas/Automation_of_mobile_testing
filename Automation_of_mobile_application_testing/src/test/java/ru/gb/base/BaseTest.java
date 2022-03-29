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

// базовый класс для всех будующий тестов.
public class BaseTest {

    // метод который будет открывать наше приложение на телефоне.
    // добавили значение String device
    public MainPage openApp(String device) {
        WebDriver driver = null;
        try {
            // передаем значение device в создание драйвера
            driver = getAndroidDriver(device);
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

    // добавили значение String device
    public  AndroidDriver getAndroidDriver(String device) throws MalformedURLException {
        // устанавливаем capabilities.
        DesiredCapabilities capabilities = new DesiredCapabilities();

        capabilities.setCapability("platformName", "Android");
        // указываем для appium на каком девайсе хотим запускать тест.
        switch (device){
            case "ASUS_Z017D_1":
                capabilities.setCapability("udid", "G8AZCY0528065H5");
                break;
            case "pixel 11":
                capabilities.setCapability("udid", "emulator-5554");
                break;
        }
        capabilities.setCapability("app", "C:\\Users\\tjuri\\OneDrive\\Рабочий стол\\Automation_of_mobile_application_testing\\Android-NativeDemoApp-0.2.1.apk");

        // папка для сохранения скриншотов selenide.
        Configuration.reportsFolder = "screenshots/actual";

        // устанавливаем и открываем приложение. !!! Указываем URL Grid !!!
        return new AndroidDriver(new URL("http://192.168.0.104:4444/wd/hub"), capabilities);
    }
}
