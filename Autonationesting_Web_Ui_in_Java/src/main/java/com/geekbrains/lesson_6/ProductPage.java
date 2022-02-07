package com.geekbrains.lesson_6;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;


public class ProductPage extends BasePage {

    protected ProductPage(WebDriver driver) {
        super(driver);
    }

    private final static String BUY_LOCATOR_BY_XPATH = "//div[@class= 'catalog__displayedItem__buttonCover']//a[.= 'Купить']";
    @FindBy(xpath = BUY_LOCATOR_BY_XPATH)
    private WebElement buttonBuy;

    @Step("Клик на кнопку \"Купить\" на странице товара")
    public ProductPage buttonBuyClick() {
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(BUY_LOCATOR_BY_XPATH)));
        buttonBuy.click();
        return this;
    }

    public final static String ADDED_PRODUCT_LICATOR_BY_XPATH = "//h5[contains(., 'Товар добавлен')]";
    @FindBy(xpath = ADDED_PRODUCT_LICATOR_BY_XPATH)
    private WebElement addedProduct;

    @Step("Проверка добавления товара после клика на кнопку \"Купить\" на странице товара")
    public ProductPage checkAddedProduct() {
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(ADDED_PRODUCT_LICATOR_BY_XPATH)));
        assertThat(driver.findElement(By.xpath(ADDED_PRODUCT_LICATOR_BY_XPATH)).getText().contains("Товар добавлен "))
                .isTrue();
        return this;
    }

}
