import org.junit.Before;
import org.junit.Test;
import org.junit.Assert;
import org.openqa.selenium.support.ui.WebDriverWait;
import page.MainPage;
import data.TestData;

import java.time.Duration;

public class OrderTest extends BaseTest {


    @Before
    public void setUp() {
        startBrowser("firefox"); // или "firefox" или "chrome"
        driver.get("https://qa-scooter.praktikum-services.ru/");
        mainPage = new MainPage(driver, wait);
        mainPage.acceptCookies();
    }

    @Test
    public void testOrderFlowOrderButtonHeader() {
        // Кликнуть на кнопку «Заказать» на главной странице
        mainPage.clickOrderButtonHeader();

        // Заполнить форму «Для кого самокат»
        String[] personData = TestData.PERSON_DATA_SET_1[0];
        orderPage.fillName(personData[0]);
        orderPage.fillSurname(personData[1]);
        orderPage.fillAddress(personData[2]);
        orderPage.fillMetro(personData[3]);
        orderPage.fillPhone(personData[4]);

        // Кликнуть на кнопку «Далее»
        orderPage.clickNextButton();

        // Заполнить форму «Про аренду»
        String[] rentalData = TestData.RENTAL_DATA_SET_1;
        orderPageSteps.fillRentalDate(rentalData[0]);// Дата доставки
        wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        orderPageSteps.selectRentalPeriod(rentalData[1]);// Срок аренды
        wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        orderPageSteps.selectScooterColor(rentalData[2]);// Цвет самоката
        wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        orderPageSteps.fillComment(rentalData[3]);// Комментарий для курьера
        wait = new WebDriverWait(driver, Duration.ofSeconds(15));

        // Кликнуть по кнопке «Заказать» в блоке «Про аренду»
        orderPageSteps.clickOrderInRentalForm();

        // Проверить, что открылось всплывающее окно «Хотите оформить заказ?»
        boolean isConfirmModalDisplayed = orderPageSteps.isConfirmOrderModalDisplayed();
        Assert.assertTrue("Всплывающее окно 'Хотите оформить заказ?' не появилось", isConfirmModalDisplayed);

        // Кликнуть по кнопке «ДА» в этом окне
        orderPageSteps.clickConfirmOrderButton();

        // Проверить, что вышло всплывающее окно «Заказ оформлен»
        boolean isOrderPlacedDisplayed = orderPageSteps.isOrderPlacedModalDisplayed();
        Assert.assertTrue("Всплывающее окно 'Заказ оформлен' не появилось", isOrderPlacedDisplayed);
    }

    @Test
    public void testOrderFlowButtonOrderMiddle() {
        // Прокрутка до кнопки "Заказать" в середине сайта
        mainPage.scrollToButtonOrderMiddle();

        // Кликнуть по кнопке "Заказать" в середине сайта
        mainPage.clickButtonOrderMiddle();

        // Заполнить форму «Для кого самокат»
        String[] personData = TestData.PERSON_DATA_SET_2[0];
        orderPage.fillName(personData[0]);
        orderPage.fillSurname(personData[1]);
        orderPage.fillAddress(personData[2]);
        orderPage.fillMetro(personData[3]);
        orderPage.fillPhone(personData[4]);

        // Кликнуть на кнопку «Далее»
        orderPage.clickNextButton();

        // Заполнить форму «Про аренду»
        String[] rentalData = TestData.RENTAL_DATA_SET_2;
        orderPageSteps.fillRentalDate(rentalData[0]);// Дата доставки
        wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        orderPageSteps.selectRentalPeriod(rentalData[1]);// Срок аренды
        wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        orderPageSteps.selectScooterColor(rentalData[2]);// Цвет самоката
        wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        orderPageSteps.fillComment(rentalData[3]);// Комментарий для курьера
        wait = new WebDriverWait(driver, Duration.ofSeconds(15));

        // Кликнуть по кнопке «Заказать» в блоке «Про аренду»
        orderPageSteps.clickOrderInRentalForm();

        // Проверить, что открылось всплывающее окно «Хотите оформить заказ?»
        boolean isConfirmModalDisplayed = orderPageSteps.isConfirmOrderModalDisplayed();
        Assert.assertTrue("Всплывающее окно 'Хотите оформить заказ?' не появилось", isConfirmModalDisplayed);

        // Кликнуть по кнопке «ДА» в этом окне
        orderPageSteps.clickConfirmOrderButton();

        // Проверить, что вышло всплывающее окно «Заказ оформлен»
        boolean isOrderPlacedDisplayed = orderPageSteps.isOrderPlacedModalDisplayed();
        Assert.assertTrue("Всплывающее окно 'Заказ оформлен' не появилось", isOrderPlacedDisplayed);
    }



}
