package ru.yandex.discription;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.WebDriverWait;

public class OrderPage {
    private final WebDriver driver;

    //локатор поля ввода имени
    private final By nameField = By.xpath(".//input[@placeholder='* Имя']");
    //локатор поля ввода фамилии
    private final By secondNameField = By.xpath(".//input[@placeholder='* Фамилия']");
    //локатор поля ввода адреса
    private final By addressField = By.xpath(".//input[@placeholder='* Адрес: куда привезти заказ']");
    //локатор поля ввода номера телефона
    private final By telephoneNumberField = By.xpath(".//input[@placeholder='* Телефон: на него позвонит курьер']");
    //локатор поля ввода станции метро
    private final By metroStationField = By.className("select-search__input");
    private final By selectMetroStation = By.xpath("//*[contains(@class, 'select-search__option')]");
    //локатор для кнопки Далее
    private final By nextButton = By.className("Button_Middle__1CSJM");


    //конструктор класса
    public OrderPage(WebDriver driver){
        this.driver = driver;
    }

    //метод заполняет поле ввода имени
    public void setUsername(String username) {
        driver.findElement(nameField).sendKeys(username);
    }
    //метод заполненяет поле ввода фамилии
    public void setSecondName(String secondName) {
        driver.findElement(secondNameField).sendKeys(secondName);
    }

    //метод заполняет поле ввода адреса
    public void setAddress(String address) {
        driver.findElement(addressField).sendKeys(address);
    }
    //метод заполняет поле ввода номера телефона
    public void setTelephoneNumber(String telephoneNumber) {
        driver.findElement(telephoneNumberField).sendKeys(telephoneNumber);
    }
    //метод заполняет поле ввода станции метро
    public void clickMetroField() {
        driver.findElement(metroStationField).click();
        new WebDriverWait(driver, 10);
       }
    public void setSelectMetroStation() {
        driver.findElement(selectMetroStation).click();}
    //метод кликает по кнопке Далее
     public void clickNextButton() {
       driver.findElement(nextButton).click();}
    //метод заказа самоката
    public void order(String username, String secondName, String address, String telephoneNumber){
        setUsername(username);
        setSecondName(secondName);
        setAddress(address);
        clickMetroField();
        setSelectMetroStation();
        setTelephoneNumber(telephoneNumber);
        clickNextButton();
    }
}
