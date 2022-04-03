package ru.gb.locators.Android;

import io.appium.java_client.MobileBy;
import org.openqa.selenium.By;
import ru.gb.locators.interfaces.LoginPageLocators;

public class AndroidLoginPageLocators implements LoginPageLocators {

    @Override
    public By inputEmail () {
        return MobileBy.AccessibilityId("input-email");
    }

    @Override
    public By inputPassword () {
        return MobileBy.AccessibilityId("input-password");
    }

    @Override
    public By clickButtonLogin () {
        return MobileBy.AccessibilityId("button-LOGIN");
    }

    @Override
    public By errorTextLocator () {
        return By.xpath("//android.widget.ScrollView[@content-desc=\"Login-screen\"]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[4]/android.widget.TextView");
    }

    @Override
    public By errorTextLocatorWithoutEmail () {
        return By.xpath("//android.widget.ScrollView[@content-desc=\"Login-screen\"]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[4]/android.widget.TextView[2]");
    }
}
