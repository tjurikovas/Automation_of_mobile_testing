package com.geekbrains.lesson_6;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class OnlinetradePageObjectTest {
    WebDriver driver;
    private final static String ONLINETRADE_URL = "https://m.onlinetrade.ru/";

    @BeforeAll
    static void registerDriver() {
        WebDriverManager.chromedriver().setup();
    }


    @BeforeEach
    void initDriver() {
        driver = new ChromeDriver();
        driver.get(ONLINETRADE_URL);
    }

    @Test
    void RandomAddProductAndRemoveUnauthorizedUser() throws InterruptedException {
        HomePage homePage = new HomePage(driver);
        homePage.buttonCatalogClick()
                .sectionHomeProductClick()
                .sectionNewYearProductClick()
                .sectionFigurinesClick()
                .listProductRandomClick()
                .buttonBuyClick()
                .checkAddedProduct()  //Проверка на добавление продукта в корзину
                .driver.get(ONLINETRADE_URL);
        homePage.basketClick()
                .mainBasketClick()
                .continueWithoutRegistrationClick()
                .removeOneProductClick()
                .confirmationOfDeletionClick()
                .checkIsBasketEmpty();
        Thread.sleep(3000);
    }

    @Test
    void productSearchWithUsingFilters() throws InterruptedException {
        HomePage homePage = new HomePage(driver);
        homePage.searchClick()
                .searchTextInput("Лошадь")
                .buttonSearchClick()
                .categoryFieldClick()
                .categoryRandomClick()
                .sortingClick()
                .sortingManyOpinionsClick()
                .productRandomClick()
                .checkHeadingAddProduct();

        Thread.sleep(3000);

    }

    @AfterEach
    void tearDown() {
        driver.quit();
    }
}

