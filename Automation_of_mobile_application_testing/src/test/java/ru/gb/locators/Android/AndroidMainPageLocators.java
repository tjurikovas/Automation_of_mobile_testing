package ru.gb.locators.Android;

import io.appium.java_client.MobileBy;
import org.openqa.selenium.By;
import ru.gb.locators.interfaces.MainPageLocators;

public class AndroidMainPageLocators implements MainPageLocators {

    @Override
    public By loginMenuButton() {
        return MobileBy.AccessibilityId("Login");
    }

    @Override
    public By webViewButton() {
        return By.xpath("//android.view.ViewGroup[@content-desc=\"WebView\"]/android.view.ViewGroup/android.widget.TextView");
    }

    @Override
    public By homeScreen() {
        return MobileBy.AccessibilityId("Home-screen");
    }

    @Override
    public By formsMenuButton() {
        return By.xpath("//android.view.ViewGroup[@content-desc=\"Forms\"]/android.view.ViewGroup/android.widget.TextView");
    }
}
