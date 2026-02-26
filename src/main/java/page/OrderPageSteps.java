package page;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class OrderPageSteps {
    protected WebDriver driver;
    private final WebDriverWait wait;


    // Локаторы формы "Про аренду"
    // Локатор поля "Когда привезти самокат"
    public final By whenBringScooter = By.cssSelector("input[placeholder=\"* Когда привезти самокат\"]");

    // Локатор поля "Срок аренды"
    public final By rentalPeriodField = By.xpath(".//div[@class='Dropdown-placeholder']");

    // Локатор чекбокса черного самоката
    public final By blackScooter = By.id("black");

    // Локатор чекбокса серого самоката
    public final By greyScooter = By.id("grey");

    // Локатор поля "Комментарий для курьера"
    public final By massageForCourier = By.cssSelector("input[placeholder=\"Комментарий для курьера\"]");

    // Локатор кнопки "Заказать" в форме "Про аренду"
    public final By buttonOrderRentalForm = By.xpath(".//button[@class='Button_Button__ra12g Button_Middle__1CSJM' and text()='Заказать']");

    // Локатор формы "Хотите оформить заказ"
    public final By confirmOrder = By.className("Order_ModalHeader__3FDaJ");

    // Локатор кнопки "Да" во всплывающем окне "Хотите оформить заказ"
    public final By confirmOrderButton = By.xpath(".//button[@class='Button_Button__ra12g Button_Middle__1CSJM' and text()='Да']");

    // Локатор всплывающего окно "Заказ оформлен"  class="Order_ModalHeader__3FDaJ"
    public final By orderPlaced = By.xpath(".//div[@class='Order_ModalHeader__3FDaJ' and text()='Заказ оформлен']");

    public OrderPageSteps(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }

    // Метод заполнения когда привезти самокат
    public void fillRentalDate(String date) {
        WebElement dateInput = wait.until(ExpectedConditions.elementToBeClickable(whenBringScooter));
        dateInput.clear();
        dateInput.sendKeys(date);
        dateInput.sendKeys(Keys.ENTER);
    }

    // Метод заполнения срок аренды
    public void selectRentalPeriod(String period) {
        WebElement periodDropdown = wait.until(ExpectedConditions.elementToBeClickable(rentalPeriodField));
        periodDropdown.click();
        By periodOption = By.xpath("//div[@role='option' and text()='" + period + "']");
        WebElement option = wait.until(ExpectedConditions.elementToBeClickable(periodOption));
        option.click();
    }

    // Метод заполнения цвета самоката
    public void selectScooterColor(String color) {
        if ("black".equals(color)) {
            WebElement blackColor = wait.until(ExpectedConditions.elementToBeClickable(blackScooter));
            blackColor.click();
        } else if ("grey".equals(color)) {
            WebElement greyColor = wait.until(ExpectedConditions.elementToBeClickable(greyScooter));
            greyColor.click();
        }
    }

    // Метод заполнения комментария для курьера
    public void fillComment(String comment) {
        WebElement commentInput = wait.until(ExpectedConditions.elementToBeClickable(massageForCourier));
        commentInput.clear();
        commentInput.sendKeys(comment);
    }

    public void rentalData(String date, String period, String color, String comment) {
        fillRentalDate(date);
        selectRentalPeriod(period);
        selectScooterColor(color);
        fillComment(comment);
    }

    // Метод кликнуть по кнопке Заказать в форме Про аренду clickOrderInRentalForm
    public void clickOrderInRentalForm() {
        WebElement orderBtn = wait.until(ExpectedConditions.elementToBeClickable(buttonOrderRentalForm));
        orderBtn.click();
    }

    // Проверяем видимость модального окна Хотите оформить заказ?
    public boolean isConfirmOrderModalDisplayed() {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(confirmOrder));
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    // Метод кликнуть по кнопке Да в окне Хотите оформить заказ?
    public void clickConfirmOrderButton() {
        WebElement confirmBtn = wait.until(ExpectedConditions.elementToBeClickable(confirmOrderButton));
        confirmBtn.click();
    }

    // Проверяем видимость модального окна о Заказ оформлен
    public boolean isOrderPlacedModalDisplayed() {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(orderPlaced));
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}


