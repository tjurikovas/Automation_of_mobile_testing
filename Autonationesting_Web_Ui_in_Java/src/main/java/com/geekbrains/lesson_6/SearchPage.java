package com.geekbrains.lesson_6;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class SearchPage extends BasePage{
    public SearchPage(WebDriver driver) {
        super(driver);
    }

    private final static String CATEGORY_FIELD_LOCATOR_BY_ID = "searchCategorySelect";
    @FindBy(id = CATEGORY_FIELD_LOCATOR_BY_ID)
    private WebElement categoryField;

    public SearchPage categoryFieldClick() {
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.id(CATEGORY_FIELD_LOCATOR_BY_ID)));
        categoryField.click();
        return this;
    }

    @FindBy(xpath = "//select[@id= 'searchCategorySelect']/option")
    private List<WebElement> category;

    public SearchPage categoryRandomClick() {
        category.get((int) (Math.random() * (category.size()))).click();
        return new SearchPage(driver);
    }

    @FindBy(id = "js__listingSort_ID")
    private WebElement sorting;

    public SearchPage sortingClick() {
        sorting.click();
        return this;
    }

    @FindBy(xpath = "//select[@id= 'js__listingSort_ID']/option[text()= 'много мнений']")
    private WebElement sortingManyOpinions;

    public SearchPage sortingManyOpinionsClick() {
        sortingManyOpinions.click();
        return this;
    }

    @FindBy(xpath = "//div[@class= 'goods__items minilisting js__goods__items']//a[.='Купить']")
    private List<WebElement> product;

    public SearchPage productRandomClick() {
        product.get((int) (Math.random() * (product.size()))).click();
        return this;
    }

    private final static String HEADING_ADD_PRODUCT_LOCATOR_BY_XPATH = "//h5[contains(., 'Товар добавлен')]";
    @FindBy(xpath = HEADING_ADD_PRODUCT_LOCATOR_BY_XPATH)
    private WebElement headingAddProduct;

    public SearchPage checkHeadingAddProduct() throws InterruptedException {
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(HEADING_ADD_PRODUCT_LOCATOR_BY_XPATH)));
        assertThat(driver.findElement(By.xpath(HEADING_ADD_PRODUCT_LOCATOR_BY_XPATH)).getText().contains("Товар добавлен"))
                .isTrue();
        return this;
    }

}
