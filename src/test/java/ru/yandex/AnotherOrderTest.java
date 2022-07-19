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

public class AnotherOrderTest {
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

        objMainPage.scrollToBigOrderButton();
        objMainPage.clickToBigOrderButton();
    }

    @Test
    public void clickBigOrderButton () {
        objOrderPage.order("апролрлодлододо", "рррпвкенгроршгщзодлшзлжлзщзщзшщгшшршгрорлдощгщшшгшдоблолдошгшгшщр", "55-76", "+77775557788");
        objOderRentPage.checkOrderFlow("к");
    }

    @Test
    public void clickBigOrderButtonTwo () {
        objOrderPage.order("дункан", "макклауд", "просто дом", "77775557788");
        objOderRentPage.checkOrderFlow("123");
    }

    @After
    public void afterAll() {
        driver.quit();
    }
}
