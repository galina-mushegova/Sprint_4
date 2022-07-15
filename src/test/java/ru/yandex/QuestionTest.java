package ru.yandex;
import org.junit.Before;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.junit.Test;
import org.junit.After;
import org.openqa.selenium.By;
import ru.yandex.discription.QuestionPage;

public class QuestionTest {
    private WebDriver driver;

    @Before
    public void beforeAll() {
        System.setProperty("webdriver.chrome.driver", "C:/WebDriver/bin/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://qa-scooter.praktikum-services.ru/");
        scrollToBlock();
    }

    public void scrollToBlock() {
        WebElement block = driver.findElement(By.xpath("//*[@data-accordion-component='Accordion']"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", block);
    }

    @Test
    public void questionTest() {
        QuestionPage objQuestionPage = new QuestionPage(driver);
        objQuestionPage.checkQuestionOne();
        objQuestionPage.checkQuestionTwo();
        objQuestionPage.checkQuestionThree();
        objQuestionPage.checkQuestionFour();
        objQuestionPage.checkQuestionFive();
        objQuestionPage.checkQuestionSix();
        objQuestionPage.checkQuestionSeven();
        objQuestionPage.checkQuestionEight();
    }

    @After
    public void afterAll() {
        driver.quit();
    }
}
