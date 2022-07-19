package ru.yandex;
import org.junit.Before;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.junit.Test;
import org.junit.After;
import org.openqa.selenium.support.ui.WebDriverWait;

import ru.yandex.description.MainPage;
import ru.yandex.description.OrderPage;
import ru.yandex.description.OrderRentPage;

public class OrderTest {
    private WebDriver driver;
    private MainPage objMainPage;
    private OrderPage objOrderPage;
    private OrderRentPage objOderRentPage;

    @Before
    public void beforeAll() {
        System.setProperty("webdriver.chrome.driver", "C:/WebDriver/bin/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://qa-scooter.praktikum-services.ru/");
        new WebDriverWait(driver, 10).until(
                webDriver -> ((JavascriptExecutor) webDriver).executeScript("return document.readyState").equals("complete"));

        objMainPage = new MainPage(driver);
        objOrderPage = new OrderPage(driver);
        objOderRentPage = new OrderRentPage(driver);

        objMainPage.clickUpperOrderButton();
    }
    
    @Test
    public void clickOrderButton() {
        objOrderPage.order("Галина", "Мушегова", "Мирная, 37", "87001112233");
        objOderRentPage.checkOrderFlow("Оставить на улице");
    }

    @Test
    public void clickOrderButtonTwo() {
        objOrderPage.order("ун", "ли", "астана", "87771111110");
        objOderRentPage.checkOrderFlow(" ");
    }

    @After
    public void afterAll() {
        driver.quit();
    }
}
