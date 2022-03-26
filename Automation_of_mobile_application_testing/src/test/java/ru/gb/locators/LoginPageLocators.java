package ru.gb.locators;

import io.appium.java_client.MobileBy;
import org.openqa.selenium.By;

public class LoginPageLocators {

    public By inputEmail () {
        return MobileBy.AccessibilityId("input-email");
    }

    public By inputPassword () {
        return MobileBy.AccessibilityId("input-password");
    }

    public By clickButtonLogin () {
        return MobileBy.AccessibilityId("button-LOGIN");
    }

    public By errorTextLocator () {
        return By.xpath("//android.widget.ScrollView[@content-desc=\"Login-screen\"]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[4]/android.widget.TextView");
    }

    public By errorTextLocatorWithoutEmail () {
        return By.xpath("//android.widget.ScrollView[@content-desc=\"Login-screen\"]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[4]/android.widget.TextView[2]");
    }
}
