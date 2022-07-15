package ru.yandex.discription;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;

public class QuestionPage {
    private final WebDriver driver;

    //локатор для клика на первый вопрос
   private final By firstQuestion = By.id("accordion__panel-0");
    //локатор для клика на второй вопрос
    private final By secondQuestion = By.id("accordion__panel-1");
    //локатор для клика на третий вопрос
    private final By threeQuestion = By.id("accordion__panel-2");
    //локатор для клика на четвертый вопрос
    private final By fourQuestion = By.id("accordion__panel-3");
    //локатор для клика на пятый вопрос
    private final By fiveQuestion = By.id("accordion__panel-4");
    //локатор для клика на шестой вопрос
    private final By sixQuestion = By.id("accordion__panel-5");
    //локатор для клика на седьмой вопрос
    private final By sevenQuestion = By.id("accordion__panel-6");
    //локатор для клика на восьмой вопрос
    private final By eightQuestion = By.id("accordion__panel-7");

    public QuestionPage(WebDriver driver){
        this.driver = driver;
   }
    //метод проверяет текст ответа на первый вопрос
   public void checkQuestionOne() {
       String text = driver.findElement(firstQuestion).getAttribute("textContent");
       Assert.assertEquals("Сутки — 400 рублей. Оплата курьеру — наличными или картой.", text);
   }
    //метод проверяет текст ответа на второй вопрос
    public void checkQuestionTwo() {
        String text = driver.findElement(secondQuestion).getAttribute("textContent");
        Assert.assertEquals("Пока что у нас так: один заказ — один самокат. Если хотите покататься с друзьями, можете просто сделать несколько заказов — один за другим.", text);
    }
    //метод проверяет текст ответа на третий вопрос
    public void checkQuestionThree() {
        String text = driver.findElement(threeQuestion).getAttribute("textContent");
        Assert.assertEquals("Допустим, вы оформляете заказ на 8 мая. Мы привозим самокат 8 мая в течение дня. Отсчёт времени аренды начинается с момента, когда вы оплатите заказ курьеру. Если мы привезли самокат 8 мая в 20:30, суточная аренда закончится 9 мая в 20:30.", text);
    }
    //метод проверяет текст ответа на четвертый вопрос
    public void checkQuestionFour() {
        String text = driver.findElement(fourQuestion).getAttribute("textContent");
        Assert.assertEquals("Только начиная с завтрашнего дня. Но скоро станем расторопнее.", text);
    }
    public void checkQuestionFive() {
        String text = driver.findElement(fiveQuestion).getAttribute("textContent");
        Assert.assertEquals("Пока что нет! Но если что-то срочное — всегда можно позвонить в поддержку по красивому номеру 1010.", text);
    }
    public void checkQuestionSix() {
        String text = driver.findElement(sixQuestion).getAttribute("textContent");
        Assert.assertEquals("Самокат приезжает к вам с полной зарядкой. Этого хватает на восемь суток — даже если будете кататься без передышек и во сне. Зарядка не понадобится.", text);
    }
    public void checkQuestionSeven() {
        String text = driver.findElement(sevenQuestion).getAttribute("textContent");
        Assert.assertEquals("Да, пока самокат не привезли. Штрафа не будет, объяснительной записки тоже не попросим. Все же свои.", text);
    }
    public void checkQuestionEight() {
        String text = driver.findElement(eightQuestion).getAttribute("textContent");
        Assert.assertEquals("Да, обязательно. Всем самокатов! И Москве, и Московской области.", text);
    }
}
