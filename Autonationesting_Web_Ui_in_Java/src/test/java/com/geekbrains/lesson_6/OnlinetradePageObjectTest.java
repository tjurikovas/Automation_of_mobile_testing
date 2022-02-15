package com.geekbrains.lesson_6;

import com.geekbrains.lesson_7.CustomLogger;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Allure;
import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.support.events.EventFiringDecorator;

import java.util.Iterator;

@Story("Основные сценарии не зарегистрированного пользователя")
public class OnlinetradePageObjectTest {
    WebDriver driver;
    private final static String ONLINETRADE_URL = "https://m.onlinetrade.ru/";

    @BeforeAll
    static void registerDriver() {
        WebDriverManager.chromedriver().setup();
    }


    @BeforeEach
    void initDriver() {
//        driver = new ChromeDriver();
        driver = new EventFiringDecorator(new CustomLogger()).decorate(new ChromeDriver());
        driver.get(ONLINETRADE_URL);
    }

    @Test
    @Feature("Корзина")
    @Description("Рандомное добавление товара из категории \"Новогодние фигурки и сувениры\" и дальнейшее удаление из Корзины")
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
    @Feature("Поиск")
    @Description("Добавление товара в \"Корзину\" через поиск")
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
        LogEntries logEntries = driver.manage().logs().get(LogType.BROWSER);
        Iterator<LogEntry> iterator = logEntries.iterator();

        for(LogEntry log: logEntries) {
            Allure.addAttachment("Лог браузера: ", log.getMessage());
        }
        driver.quit();
    }
}

