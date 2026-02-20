package page;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class MainPage {
    private final WebDriver driver;
    private final WebDriverWait wait;

    // Локаторы
    // Локатор кнопки куки "Да все привыкли"
    public final By cookieButton = By.id("rcc-confirm-button");
    // блок FAQ
    public final By faqSection = By.className("Home_FAQ__3uVm4");

    // Локатор кнопки "Заказать" в заголовке сайта
    public final By buttonOrderHeader = By.xpath(".//div[@class='Header_Nav__AGCXC']//button[text()='Заказать']");

    // Локатор кнопки "Заказать" в середине сайта
    public final By buttonOrderMiddle = By.xpath(".//div[@class='Home_FinishButton__1_cWm']//button[text()='Заказать']");

    public MainPage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }

    // Метод принимаем куки
    public void acceptCookies() {
        try {
            WebElement cookieBtn = wait.until(ExpectedConditions.elementToBeClickable(cookieButton));
            cookieBtn.click();
        } catch (Exception e) {
            // Кнопка куки не найдена — продолжаем
        }
    }

    // Метод кликнуть по кнопке заказа вверху сайта
    public void clickOrderButtonHeader() {
        driver.findElement(buttonOrderHeader).isDisplayed();
        driver.findElement(buttonOrderHeader).click();
    }

    // Метод кликнуть по кнопке заказа в середине сайта
    public void clickButtonOrderMiddle() {
        driver.findElement(buttonOrderMiddle).isDisplayed();
        driver.findElement(buttonOrderMiddle).click();
    }

    // Прокрутка до кнопки "Заказать" в середине сайта
    public void scrollToButtonOrderMiddle() {
        WebElement middleElement = driver.findElement(buttonOrderMiddle);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", middleElement);
    }

    // Прокрутка до блока Вопросы о важном
    public void scrollToFaqSection() {
        WebElement faqElement = driver.findElement(faqSection);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", faqElement);
    }

    // Метод ожидания видимости блока Вопросы о важном
    public void waitForFaqSection() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(faqSection));
    }

    // Метод клика по вопросу
    public void clickQuestion(By questionLocator) {
        WebElement questionButton = wait.until(
                ExpectedConditions.elementToBeClickable(questionLocator)
        );
        questionButton.click();
    }

    // Метод получения ответа на вопрос
    public String getAnswerText(By answerLocator) {
        WebElement answerElement = wait.until
                (ExpectedConditions.visibilityOfElementLocated(answerLocator)
                );
        return answerElement.getText().trim();
    }

    public By getAnswerLocatorFromQuestion(By questionLocator) {
        String answerId = questionLocator.toString().replace("accordion__heading", "accordion__panel");
        return By.id(answerId.split(" ")[1]);
    }
}

