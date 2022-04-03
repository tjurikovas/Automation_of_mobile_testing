package ru.gb.pages;

import io.qameta.allure.Step;
import ru.gb.locators.LocatorService;
import ru.gb.locators.interfaces.FormsPageLocators;

import static com.codeborne.selenide.Selenide.$;

public class FormsPage {
    private FormsPageLocators locator() {
        return LocatorService.FORMS_PAGE_LOCATORS;
    }

    @Step ("Вводим текст")
    public FormsPage inputText() {
        $(locator().inputText())
                .sendKeys("pdf");
        return this;
    }

    @Step ("Проверка введённого текста")
    public FormsPage resultText() {
        $(locator().resultText())
                .getText()
                .equals("pdf");
        return this;
    }
}
