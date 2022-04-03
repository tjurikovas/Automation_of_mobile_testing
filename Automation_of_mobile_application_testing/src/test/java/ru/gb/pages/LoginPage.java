package ru.gb.pages;

import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;
import ru.gb.locators.LocatorService;
import ru.gb.locators.interfaces.LoginPageLocators;

import static com.codeborne.selenide.Selenide.$;

public class LoginPage {

    private LoginPageLocators locator() {
        return LocatorService.LOGIN_PAGE_LOCATORS;
    }

    @Step("Вводим корректный Email")
    public LoginPage inputEmailCorrected() {
        $(locator().inputEmail()).sendKeys("email@domain.com");
        return new LoginPage();
    }

    @Step("Вводим корректный пароль")
    public LoginPage inputPasswordCorrected() {
        $(locator().inputPassword()).sendKeys("5626r");
        return new LoginPage();
    }

    @Step("Нажимаем кнопку Login")
    public LoginPage clickLoginButton() {
        $(locator().clickButtonLogin()).click();
        return new LoginPage();  // под вопросом!
    }

    @Step("Проверяем текст ошибки")
    public LoginPage checkErrorText(String text) {
        $(locator().errorTextLocator()).shouldHave(Condition.text(text));
        return new LoginPage();
    }

    @Step("Проверяем текст ошибки при проверке без email")
    public LoginPage checkErrorTextWithoutEmail(String text) {
        $(locator().errorTextLocatorWithoutEmail()).shouldHave(Condition.text(text));
        return new LoginPage();
    }
}
