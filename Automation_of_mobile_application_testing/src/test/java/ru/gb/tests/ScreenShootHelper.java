package ru.gb.tests;

import io.appium.java_client.MobileBy;
import org.testng.annotations.Test;
import ru.gb.base.BaseTest;

import java.io.File;

import static com.codeborne.selenide.Selenide.$;

public class ScreenShootHelper extends BaseTest {

    @Test
    public void createScreen() {
        openApp("ASUS_Z017D_1");
        File actualScreenshot = $(MobileBy.AccessibilityId("Home-screen")).screenshot();
    }



}
