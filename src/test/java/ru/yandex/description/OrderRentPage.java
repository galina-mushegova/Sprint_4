package ru.yandex.description;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class OrderRentPage {
    private final WebDriver driver;

    //локатор для поля "Когда привезти самокат"
    private final By whenCome = By.xpath(".//div[@class ='react-datepicker__input-container']/input[@class='Input_Input__1iN_Z Input_Responsible__1jDKN']");
    //локатор для выбора даты в календаре (15/07/2022)
    private final By date = By.xpath(".//div/div[text()='15']");
    //локатор для поля Срок аренды
    private final By rentTime = By.className("Dropdown-control");
    //локатор для выбора срока аренды
    private final By selectRentTime = By.xpath("//*[contains(@class, 'Dropdown-option')]");
    //локатор для поля "Цвет самоката"(для серого цвета)
    private final By colorGrey = By.id("grey");
    //локатор поля для ввода комментария
    private final By comment = By.className("Input_Responsible__1jDKN");
    //локатор для кнопки "Заказать"
    private final By orderButton = By.xpath("//*[contains(@class, 'Order_Buttons__1xGrp')]/button[text()='Заказать']");
    //локатор для кнопки "Да"
    private final By confirmButton = By.xpath("//*[contains(@class, 'Order_Buttons__1xGrp')]/button[text()='Да']");
    //локатор окна с сообщением о создании заказа
    private final By successModal = By.xpath("//*[contains(@class, 'Order_Modal__YZ-d3')]/*[text()[contains(.,'Заказ оформлен')]]");

    //конструктор класса
    public OrderRentPage(WebDriver driver){
        this.driver = driver;
    }

    //метод заполняет поле "Когда привезти самокат"
    public void clickWhenCome() {
        driver.findElement(whenCome).click();
        new WebDriverWait(driver, 10)
                .until(ExpectedConditions.visibilityOfElementLocated(By.className("react-datepicker__month-container")));
    }
    public void setDate() {
        driver.findElement(date).click();
    }
    //метод выбирает срок аренды и заполняет поле "Срок аренды"
    public void clickRentTime() {
        driver.findElement(rentTime).click();
    }
    public void setSelectRentTime() {
        driver.findElement(selectRentTime).click();
    }
    //метод выбирает серый цвет в поле "Цвет самоката"
    public void setColor() {
        driver.findElement(colorGrey).click();
    }
    //метод заполняет поле "Комментарий"
    public void setComment(String text) {
        driver.findElement(comment).sendKeys(text);
    }
    //метод нажимает кнопку "Заказать"
    public void clickOrderButton() {
        driver.findElement(orderButton).click();
    }
    //метод нажимает кнопку "Да"
    public void clickConfirmButton() {
        driver.findElement(confirmButton).click();

    }
    //метод проверяет текст модального окна
    public void getSuccessModal() {
        WebElement el = driver.findElement(successModal);
        Assert.assertTrue(el.isDisplayed());
    }

    //метод заполняет поля для страницы "Про аренду" и нажимает кнопку "Заказать"
    public void checkOrderFlow(String text) {
        clickWhenCome();
        setDate();
        clickRentTime();
        setSelectRentTime();
        setColor();
        setComment(text);
        clickOrderButton();
        clickConfirmButton();
        getSuccessModal();
    }
}
