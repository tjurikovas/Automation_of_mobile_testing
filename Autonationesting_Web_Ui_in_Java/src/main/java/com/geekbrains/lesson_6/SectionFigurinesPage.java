package com.geekbrains.lesson_6;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class SectionFigurinesPage extends BasePage{
    protected SectionFigurinesPage(WebDriver driver) {
        super(driver);
    }

    private final static String LIST_PRODUCT_LICATOR_BY_XPATH = "//div[@class= 'multicart__item__image']//img";
    @FindBy(xpath = LIST_PRODUCT_LICATOR_BY_XPATH)
    private List<WebElement> listProduct;

    public ProductPage listProductRandomClick() {
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(LIST_PRODUCT_LICATOR_BY_XPATH)));
        listProduct.get((int) (Math.random() * (listProduct.size()))).click();
        return new ProductPage(driver);
    }

}
