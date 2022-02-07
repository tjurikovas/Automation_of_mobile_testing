package com.geekbrains.lesson_6;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class BasketPage extends BasePage{
    public BasketPage(WebDriver driver) {
        super(driver);
    }

    private final static String REMOVE_LOCATOR_BY_XPATH = "//a[.= 'Удалить']";
    @FindBy(xpath = REMOVE_LOCATOR_BY_XPATH)
    private WebElement removeOneElement;

    @Step("Удаление первого товара в корзине")
    public BasketPage removeOneProductClick() {
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(REMOVE_LOCATOR_BY_XPATH)));
        removeOneElement.click();
        return this;
    }

    private final static String CONFIRMATION_OF_DELETION_LOCATOR_BY_XPATH = "//div[@id= 'popup_message']//a[.= 'Удалить']";
    @FindBy(xpath = CONFIRMATION_OF_DELETION_LOCATOR_BY_XPATH)
    private WebElement confirmationOfDeletion;

    @Step("Клик на кнопку удалить в поп-ап \"Подтверждение удаления\"")
    public BasketPage confirmationOfDeletionClick() {
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(CONFIRMATION_OF_DELETION_LOCATOR_BY_XPATH)));
        confirmationOfDeletion.click();
        return this;
    }

    private final static String BASKET_EMPTY_LOCATOR_BY_XPATH = "//div[@class= 'header__icons header__icons__cart js__headline__menuLink js__header__basketCover ']//span[@class= 'itemCount' and @style= 'display: none;']";
    @FindBy(xpath = BASKET_EMPTY_LOCATOR_BY_XPATH)
    private WebElement basketEmpty;

    @Step("Проверка корзины на отсутствие в ней товаров")
    public BasketPage checkIsBasketEmpty() {
        assertThat(driver.findElement(By.xpath(BASKET_EMPTY_LOCATOR_BY_XPATH)).getText().isEmpty()).isTrue();
        return this;
    }
}
