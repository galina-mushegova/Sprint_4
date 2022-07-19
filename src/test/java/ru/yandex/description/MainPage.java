package ru.yandex.description;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class MainPage {
    private final WebDriver driver;
    public MainPage(WebDriver driver){
        this.driver = driver;
    }

    //метод возвращает текст вопроса
    public String getQuestionByIndex(Integer index) {    
        return driver
            .findElements(By.xpath("//*[@data-accordion-component='AccordionItemButton']"))
            .get(index - 1)
            .getAttribute("textContent");
    }

    //метод возвращает текст ответа
    public String getAnswerByIndex(Integer index) {
        return driver
            .findElements(By.xpath("//*[@data-accordion-component='AccordionItemPanel']"))
            .get(index - 1)
            .getAttribute("textContent");
    }

    //метод для скролла до блока с вопросами
    public void scrollToBlock() {
        WebElement block = driver.findElement(By.xpath("//*[@data-accordion-component='Accordion']"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", block);
    }
    //локатор для кнопки "Заказать" вверху страницы
    private final By upperOrderButton = By.className("Button_Button__ra12g");
    //метод кликает по верхней кноке "Заказать"
    public void clickUpperOrderButton(){
        driver.findElement(upperOrderButton).click();
    }
    //локатор кнопки "Заказать" внизу страницы
    private final By bigOrderButton = By.className("Home_FinishButton__1_cWm");
    //метод скроллит до нижней кнопки "Заказать"
    public void scrollToBigOrderButton() {
        WebElement button = driver.findElement(bigOrderButton);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", button);
    }
    //метод кликает по кнопке "Заказать" внизу страницы
    public void clickToBigOrderButton() {
        driver.findElement(bigOrderButton).click();
    }
}
