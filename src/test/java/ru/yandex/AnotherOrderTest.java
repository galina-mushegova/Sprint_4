package ru.yandex;
import org.junit.Before;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.junit.Test;
import org.junit.After;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.yandex.discription.OderRentPage;
import ru.yandex.discription.OrderPage;

public class AnotherOrderTest {
    private WebDriver driver;

    @Before
    public void beforeAll() {
        System.setProperty("webdriver.chrome.driver", "C:/WebDriver/bin/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://qa-scooter.praktikum-services.ru/");
        new WebDriverWait(driver, 10).until(
                webDriver -> ((JavascriptExecutor) webDriver).executeScript("return document.readyState").equals("complete"));
        scrollToButton();
    }
    public void scrollToButton() {
        WebElement button = driver.findElement(By.className("Home_FinishButton__1_cWm"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", button);
    }
    @Test
    public void clickBigOrderButton () {
        WebElement button = driver.findElement(By.className("Home_FinishButton__1_cWm"));
        button.click();
        driver.get("https://qa-scooter.praktikum-services.ru/order");
        OrderPage objOrderPage = new OrderPage(driver);
        objOrderPage.order("апролрлодлододо", "рррпвкенгроршгщзодлшзлжлзщзщзшщгшшршгрорлдощгщшшгшдоблолдошгшгшщр", "55-76", "+77775557788");

        OderRentPage objOderRentPage = new OderRentPage(driver);
        objOderRentPage.orderFinal("к");
    }
    @Test
    public void clickBigOrderButtonTwo () {
        WebElement button = driver.findElement(By.className("Home_FinishButton__1_cWm"));
        button.click();
        driver.get("https://qa-scooter.praktikum-services.ru/order");
        OrderPage objOrderPage = new OrderPage(driver);
        objOrderPage.order("дункан", "макклауд", "просто дом", "77775557788");

        OderRentPage objOderRentPage = new OderRentPage(driver);
        objOderRentPage.orderFinal("123");
    }
    @After
    public void afterAll() {
        driver.quit();
    }

}
