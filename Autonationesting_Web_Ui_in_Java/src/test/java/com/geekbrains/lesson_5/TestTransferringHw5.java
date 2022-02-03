package com.geekbrains.lesson_5;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class TestTransferringHw5 {
    WebDriver driver;
    WebDriverWait webDriverWait;
    Actions actions;
    private final static String ONLINETRADE_URL = "https://m.onlinetrade.ru/";

    @BeforeAll
    static void registerDriver() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeEach
    void initDriver() {
        driver = new ChromeDriver();
        webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(7));
        actions = new Actions(driver);

        driver.get(ONLINETRADE_URL);
//        driver.manage().window().maximize();
    }

    @Test
    @DisplayName("Добавление и удаление рандомного товара")
    void randomAddProductAndRemoveUnauthorizedUser() throws InterruptedException {
        driver.findElement(By.xpath("//span[text()='Каталог']")).click();
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@class='js__mCM_linkClose']/ancestor::a[@title='Товары для дома']")));
        driver.findElement(By.xpath("//span[@class='js__mCM_linkClose']/ancestor::a[@title='Товары для дома']")).click();
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[text()='Новогодние товары ']")));
        driver.findElement(By.xpath("//a[text()='Новогодние товары ']")).click();
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class= 'drawCats drawCats__dummyes']//a[contains(@href, 'novogodnie_f')]")));
        driver.findElement(By.xpath("//div[@class= 'drawCats drawCats__dummyes']//a[contains(@href, 'novogodnie_f')]")).click();
        List<WebElement> productCard = driver.findElements(By.xpath("//div[@class= 'multicart__item__image']//img"));
        productCard.get((int) (Math.random() * (productCard.size()))).click();
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class= 'catalog__displayedItem__buttonCover']//a[.= 'Купить']")));
        driver.findElement(By.xpath("//div[@class= 'catalog__displayedItem__buttonCover']//a[.= 'Купить']")).click();
        Thread.sleep(4500);
        //Проверяем что товар добавлен в корзину
        assertThat(driver.findElement(By.xpath("//h5[contains(., 'Товар добавлен')]")).getText()
                .contains("Товар добавлен ")).isTrue();

        driver.get(ONLINETRADE_URL);
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(@class, 'header__icons header')]")));
        driver.findElement(By.xpath("//div[contains(@class, 'header__icons header')]")).click();
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class= 'headline__bar js__headline__bar active']//span[.= 'Основная']")));
        driver.findElement(By.xpath("//div[@class= 'headline__bar js__headline__bar active']//span[.= 'Основная']")).click();
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[.= 'Продолжить без регистрации']")));
        driver.findElement(By.xpath("//a[.= 'Продолжить без регистрации']")).click();
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[.= 'Удалить']")));
        driver.findElement(By.xpath("//a[.= 'Удалить']")).click();
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id= 'popup_message']//a[.= 'Удалить']")));
        driver.findElement(By.xpath("//div[@id= 'popup_message']//a[.= 'Удалить']")).click();
        Thread.sleep(4500);
        assertThat(driver.findElement(By.xpath("//div[@class= 'header__icons header__icons__cart js__headline__menuLink js__header__basketCover ']//span[@class= 'itemCount' and @style= 'display: none;']"))
                .getText().isEmpty()).isTrue();
    }

    @Test
    @DisplayName("Поиск товара с использованием фильтров")
    void productSearchUsingFilters() throws InterruptedException {
        driver.findElement(By.xpath("//div[@class= 'header__icon']/ancestor::a[@href= '/sitesearch.html']")).click();
        driver.findElement(By.xpath("//input[@type= 'text' and @name= 'query']")).sendKeys("Лошадь");
        driver.findElement(By.xpath("//input[@value= 'Найти']")).click();
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.id("searchCategorySelect")));
        driver.findElement(By.id("searchCategorySelect")).click();
        List<WebElement> listCategoryProduct = driver.findElements(By.xpath("//select[@id= 'searchCategorySelect']/option"));
        listCategoryProduct.get((int) (Math.random() * (listCategoryProduct.size()))).click();
//        WebElement scrollTo = driver.findElement(By.xpath("//option[@title= 'Статуэтки и фигурки']"));
//        ((JavascriptExecutor)driver).executeAsyncScript("arguments[0].scrollIntoView(true);", scrollTo);
//        Thread.sleep(4500);
//        scrollTo.click();
        driver.findElement(By.id("js__listingSort_ID")).click();
        driver.findElement(By.xpath("//select[@id= 'js__listingSort_ID']/option[text()= 'много мнений']")).click();
        List<WebElement> listProduct = driver.findElements(By.xpath("//div[@class= 'goods__items minilisting js__goods__items']//a[.='Купить']"));
        listProduct.get((int) (Math.random() * (listProduct.size()))).click();
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h5[contains(., 'Товар добавлен')]")));
        assertThat(driver.findElement(By.xpath("//h5[contains(., 'Товар добавлен')]")).getText().contains("Товар добавлен")).isTrue();
    }

    @AfterEach
    void tearDown() {
        driver.quit();
    }

}
