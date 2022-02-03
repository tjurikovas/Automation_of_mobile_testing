package com.geekbrains.lesson_6;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class NewYearPage extends BasePage {
    public NewYearPage(WebDriver driver) {
        super(driver);
    }

    private final static String FIGURINES_CLICK_LOCATOR_BY_XPATH = "//div[@class= 'drawCats drawCats__dummyes']//a[contains(@href, 'novogodnie_f')]";
    @FindBy(xpath = FIGURINES_CLICK_LOCATOR_BY_XPATH)
    private WebElement sectionFigurines;

    public SectionFigurinesPage sectionFigurinesClick() {
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(FIGURINES_CLICK_LOCATOR_BY_XPATH)));
        sectionFigurines.click();
        return new SectionFigurinesPage(driver);
    }
}
