package page;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class OrderPage  {
    private final WebDriver driver;
    private final WebDriverWait wait;


    // Локаторы для формы заказа
    // Поле "Имя"
    public final By nameField = By.cssSelector("input[placeholder=\"* Имя\"]");

    // Поле "Фамилия"
    public final By surnameField = By.cssSelector("input[placeholder=\"* Фамилия\"]");

    // Поле "Адрес: куда привезти заказ"
    public final By addressField = By.cssSelector("input[placeholder=\"* Адрес: куда привезти заказ\"]");

    // Поле "Станция метро"
    public final By metroField = By.cssSelector("input[placeholder=\"* Станция метро\"]");

    // Поле "Телефон"
    public final By phoneField = By.cssSelector("input[placeholder=\"* Телефон: на него позвонит курьер\"]");

    // Кнопка "Далее"
    public final By nextButton = By.className("Button_Middle__1CSJM");


    public OrderPage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }

    // Методы заполнения формы "Для кого самокат"
    // Заполнить поле "Имя"
    public void fillName(String name) {
        WebElement naimInput = wait.until(ExpectedConditions.elementToBeClickable(nameField));
        naimInput.clear();
        naimInput.sendKeys(name);
    }

    // Заполнить поле "Фамилия"
    public void fillSurname(String surname) {
        WebElement surnameInput = wait.until(ExpectedConditions.elementToBeClickable(surnameField));
        surnameInput.clear();
        surnameInput.sendKeys(surname);
    }

    // Заполнить поле "Адрес"
    public void fillAddress(String address) {
        WebElement addressInput = wait.until(ExpectedConditions.elementToBeClickable(addressField));
        addressInput.clear();
        addressInput.sendKeys(address);
    }

    // Заполнить поле "Станция метро"
    public void fillMetro(String metroStation) {
        WebElement metroInput = wait.until(ExpectedConditions.elementToBeClickable(metroField));
        metroInput.click();
        metroInput.sendKeys(metroStation);
        metroInput.sendKeys(Keys.DOWN, Keys.ENTER);
    }

    // Заполнить поле "Телефон"
    public void fillPhone(String phone) {
        WebElement phoneInput = wait.until(ExpectedConditions.elementToBeClickable(phoneField));
        phoneInput.clear();
        phoneInput.sendKeys(phone);
    }

    // Кликнуть на кнопку Далее в окне Для кого самокат
    public void clickNextButton() {
        WebElement nextBtn = wait.until(ExpectedConditions.elementToBeClickable(nextButton));
        nextBtn.click();
    }
}


