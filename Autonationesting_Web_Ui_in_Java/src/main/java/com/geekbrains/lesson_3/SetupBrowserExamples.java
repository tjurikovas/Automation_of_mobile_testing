package com.geekbrains.lesson_3;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;

public class SetupBrowserExamples {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--disable-notifications");
        chromeOptions.addArguments("--headless"); //Запуск браузера без интерфейса
        chromeOptions.addArguments("user-agent=Googlebot/2.1 (+http://www.google.com/bot.html)"); //Запуск браузера так как видит его поисковой бот
        WebDriver driver = new ChromeDriver(chromeOptions);

        driver.get("https://onlinetrade.ru/");
        Thread.sleep(5000);
        driver.quit();
    }
}
