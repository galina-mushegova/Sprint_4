package ru.yandex;
import org.junit.Before;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.junit.Test;
import org.junit.After;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.yandex.discription.OderRentPage;
import ru.yandex.discription.OrderPage;

public class OrderTest {
    private WebDriver driver;

    @Before
    public void beforeAll() {
        System.setProperty("webdriver.chrome.driver", "C:/WebDriver/bin/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://qa-scooter.praktikum-services.ru/");
        new WebDriverWait(driver, 10).until(
                webDriver -> ((JavascriptExecutor) webDriver).executeScript("return document.readyState").equals("complete"));
    }
    @Test
    public void clickOrderButton() {
        driver.findElement(By.className("Button_Button__ra12g")).click();
        driver.get("https://qa-scooter.praktikum-services.ru/order");
        OrderPage objOrderPage = new OrderPage(driver);
        objOrderPage.order("Галина", "Мушегова", "Мирная, 37", "87001112233");

        OderRentPage objOderRentPage = new OderRentPage(driver);
        objOderRentPage.orderFinal("Оставить на улице");

    }
    @Test
    public void clickOrderButtonTwo() {
        driver.findElement(By.className("Button_Button__ra12g")).click();
        driver.get("https://qa-scooter.praktikum-services.ru/order");
        OrderPage objOrderPage = new OrderPage(driver);
        objOrderPage.order("ун", "ли", "астана", "87771111110");

        OderRentPage objOderRentPage = new OderRentPage(driver);
        objOderRentPage.orderFinal(" ");
    }

    @After
    public void afterAll() {
        driver.quit();
    }
}
