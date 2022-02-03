package com.geekbrains.lesson_6;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class HomePage extends BasePage {

    public HomePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//span[text()='Каталог']")
    private WebElement buttonCatalog;

    public HomePage buttonCatalogClick() {
        buttonCatalog.click();
        return this;
    }

    private final static String HOME_PRODUCT_LOCATOR_BY_XPATH = "//span[@class='js__mCM_linkClose']/ancestor::a[@title='Товары для дома']";
    @FindBy(xpath = HOME_PRODUCT_LOCATOR_BY_XPATH)
    private WebElement sectionHomeProduct;

    public HomePage sectionHomeProductClick() {
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(HOME_PRODUCT_LOCATOR_BY_XPATH)));
        sectionHomeProduct.click();
        return this;
    }

    private final static String NEW_YEAR_PRODUCT_LOCATOR_BY_XPATH = "//a[text()='Новогодние товары ']";
    @FindBy(xpath = NEW_YEAR_PRODUCT_LOCATOR_BY_XPATH)
    private WebElement sectionNewYearProduct;

    public NewYearPage sectionNewYearProductClick() {
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(NEW_YEAR_PRODUCT_LOCATOR_BY_XPATH)));
        sectionNewYearProduct.click();
        return new NewYearPage(driver);
    }

    private final static String BASKET_LOCATOR_BY_XPATH = "//div[contains(@class, 'header__icons header')]";
    @FindBy(xpath = BASKET_LOCATOR_BY_XPATH)
    private WebElement basket;

    public HomePage basketClick() {
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(BASKET_LOCATOR_BY_XPATH)));
        basket.click();
        return this;
    }

    private final static String MAIN_BASKET_LOCATOR_BY_XPATH = "//div[@class= 'headline__bar js__headline__bar active']//span[.= 'Основная']";
    @FindBy(xpath = MAIN_BASKET_LOCATOR_BY_XPATH)
    private WebElement mainBasket;

    public RegistrationPage mainBasketClick() {
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(MAIN_BASKET_LOCATOR_BY_XPATH)));
        mainBasket.click();
        return new RegistrationPage(driver);
    }

    @FindBy(xpath = "//div[@class= 'header__icon']/ancestor::a[@href= '/sitesearch.html']")
    private WebElement search;

    public HomePage searchClick() {
        search.click();
        return this;
    }

    @FindBy(xpath = "//input[@type= 'text' and @name= 'query']")
    private WebElement searchText;

    public HomePage searchTextInput(String text) {
        searchText.sendKeys(text);
        return new HomePage(driver);
    }

    @FindBy(xpath = "//input[@value= 'Найти' and @type= 'submit']")
    private WebElement buttonSearch;

    public SearchPage buttonSearchClick() {
        buttonSearch.click();
        return new SearchPage(driver);
    }

}