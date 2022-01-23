package com.geekbrains.lesson_3;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class SeleniumHW3 {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--disable-notifications");
        WebDriver driver = new ChromeDriver(chromeOptions);
        WebDriverWait webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(6));

        // Рандомное добавление новогоднего товара неавторизованным пользователем
        driver.get("https://m.onlinetrade.ru/");
//        WebElement catalog = driver.findElement(By.xpath("//span[text()='Каталог']"));
//        catalog.click();
        driver.findElement(By.xpath("//span[text()='Каталог']")).click();
//        driver.switchTo().frame(driver.findElement(By.xpath("//iframe...."))); // Переключение по iframe
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@class='js__mCM_linkClose']/ancestor::a[@title='Товары для дома']")));
        driver.findElement(By.xpath("//span[@class='js__mCM_linkClose']/ancestor::a[@title='Товары для дома']")).click();
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[text()='Новогодние товары ']")));
        driver.findElement(By.xpath("//a[text()='Новогодние товары ']")).click();
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class= 'drawCats drawCats__dummyes']//a[contains(@href, 'novogodnie_f')]")));
        driver.findElement(By.xpath("//div[@class= 'drawCats drawCats__dummyes']//a[contains(@href, 'novogodnie_f')]")).click();
        List<WebElement> productCard = driver.findElements(By.xpath("//div[@class= 'multicart__item__image']//img"));
        productCard.get((int) (Math.random() * 15)).click();
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class= 'catalog__displayedItem__buttonCover']//a[.= 'Купить']")));
        driver.findElement(By.xpath("//div[@class= 'catalog__displayedItem__buttonCover']//a[.= 'Купить']")).click();

        //Удаление товара из корзины неавторизованным пользователем
        driver.get("https://m.onlinetrade.ru");
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


        Thread.sleep(8000);

        driver.quit();

    }
}
