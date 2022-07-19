package ru.yandex;
import org.junit.Assert;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import ru.yandex.description.MainPage;

import org.junit.Test;
import org.junit.After;

public class QuestionTest {
    private WebDriver driver;
    private MainPage objMainPage;

    @Before
    public void beforeAll() {
        System.setProperty("webdriver.chrome.driver", "C:/WebDriver/bin/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://qa-scooter.praktikum-services.ru/");

        objMainPage = new MainPage(driver);
        objMainPage.scrollToBlock();
    }

    @Test
    public void checkQuestionAboutPrice() {
        String question = objMainPage.getQuestionByIndex(1);
        String answer = objMainPage.getAnswerByIndex(1);

        Assert.assertEquals("Сколько это стоит? И как оплатить?", question);
        Assert.assertEquals("Сутки — 400 рублей. Оплата курьеру — наличными или картой.", answer);
    }

    @Test
    public void checkSeveralScooters() {
        String question = objMainPage.getQuestionByIndex(2);
        String answer = objMainPage.getAnswerByIndex(2);

        Assert.assertEquals("Хочу сразу несколько самокатов! Так можно?", question);
        Assert.assertEquals("Пока что у нас так: один заказ — один самокат. Если хотите покататься с друзьями, можете просто сделать несколько заказов — один за другим.", answer);
    }

    @Test
    public void checkRentCalculation() {
        String question = objMainPage.getQuestionByIndex(3);
        String answer = objMainPage.getAnswerByIndex(3);

        Assert.assertEquals("Как рассчитывается время аренды?", question);
        Assert.assertEquals("Допустим, вы оформляете заказ на 8 мая. Мы привозим самокат 8 мая в течение дня. Отсчёт времени аренды начинается с момента, когда вы оплатите заказ курьеру. Если мы привезли самокат 8 мая в 20:30, суточная аренда закончится 9 мая в 20:30.", answer);
    }

    @Test
    public void checkOrderForToday() {
        String question = objMainPage.getQuestionByIndex(4);
        String answer = objMainPage.getAnswerByIndex(4);

        Assert.assertEquals("Можно ли заказать самокат прямо на сегодня?", question);
        Assert.assertEquals("Только начиная с завтрашнего дня. Но скоро станем расторопнее.", answer);
    }

    @Test
    public void checkScooterReturn() {
        String question = objMainPage.getQuestionByIndex(5);
        String answer = objMainPage.getAnswerByIndex(5);

        Assert.assertEquals("Можно ли продлить заказ или вернуть самокат раньше?", question);
        Assert.assertEquals("Пока что нет! Но если что-то срочное — всегда можно позвонить в поддержку по красивому номеру 1010.", answer);
    }

    @Test
    public void checkChargerForScooter() {
        String question = objMainPage.getQuestionByIndex(6);
        String answer = objMainPage.getAnswerByIndex(6);

        Assert.assertEquals("Вы привозите зарядку вместе с самокатом?", question);
        Assert.assertEquals("Самокат приезжает к вам с полной зарядкой. Этого хватает на восемь суток — даже если будете кататься без передышек и во сне. Зарядка не понадобится.", answer);
    }

    @Test
    public void checkOrderCancel() {
        String question = objMainPage.getQuestionByIndex(7);
        String answer = objMainPage.getAnswerByIndex(7);

        Assert.assertEquals("Можно ли отменить заказ?", question);
        Assert.assertEquals("Да, пока самокат не привезли. Штрафа не будет, объяснительной записки тоже не попросим. Все же свои.", answer);
    }

    @Test
    public void checkDeliveryArea() {
        String question = objMainPage.getQuestionByIndex(8);
        String answer = objMainPage.getAnswerByIndex(8);

        Assert.assertEquals("Я жизу за МКАДом, привезёте?", question);
        Assert.assertEquals("Да, обязательно. Всем самокатов! И Москве, и Московской области.", answer);
    }

    @After
    public void afterAll() {
        driver.quit();
    }
}
