package ru.gb.tests.forms;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import ru.gb.base.BaseTest;
import ru.gb.listeners.AllureListeners;

@Listeners(AllureListeners.class)
public class CheckTextInForms extends BaseTest {

    @Test
    public void checkText () {
        openApp().clickFormsMenuButton()
                .inputText()
                .resultText();
    }
}
