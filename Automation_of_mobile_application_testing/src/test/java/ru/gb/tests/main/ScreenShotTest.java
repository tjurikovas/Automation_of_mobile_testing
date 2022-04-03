package ru.gb.tests.main;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import ru.gb.base.BaseTest;
import ru.gb.listeners.AllureListeners;

@Listeners(AllureListeners.class)
public class ScreenShotTest extends BaseTest {
    @Test
    public void checkMainPageScreen () {
        openApp()
                .checkScreenshot();
    }
}
