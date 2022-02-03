package com.geekbrains.lesson_6;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class RegistrationPage extends BasePage{
    public RegistrationPage(WebDriver driver) {
        super(driver);
    }

    private final static String CONTINUE_WITHOUT_REGISTRATION_LOCATOR_BY_XPATH = "//a[.= 'Продолжить без регистрации']";
    @FindBy(xpath = CONTINUE_WITHOUT_REGISTRATION_LOCATOR_BY_XPATH)
    private WebElement continueWithoutRegistration;

    public BasketPage continueWithoutRegistrationClick() {
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(CONTINUE_WITHOUT_REGISTRATION_LOCATOR_BY_XPATH)));
        continueWithoutRegistration.click();
        return new BasketPage(driver);
    }
}
