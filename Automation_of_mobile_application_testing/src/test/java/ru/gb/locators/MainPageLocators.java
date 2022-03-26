package ru.gb.locators;

import io.appium.java_client.MobileBy;
import org.openqa.selenium.By;

public class MainPageLocators {
    public By loginMenuButton() {
        return MobileBy.AccessibilityId("Login");
    }

    public By webViewButton() {
        return By.xpath("//android.view.ViewGroup[@content-desc=\"WebView\"]/android.view.ViewGroup/android.widget.TextView");
    }

    public By homeScreen() {
        return MobileBy.AccessibilityId("Home-screen");
    }
}
