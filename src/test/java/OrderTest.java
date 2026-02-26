import org.junit.Test;
import org.junit.Assert;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;


@RunWith(Parameterized.class)
public class OrderTest extends BaseTest {
    private final String name;
    private final String surname;
    private final String address;
    private final String metroStation;
    private final String phone;
    private final String date;
    private final String period;
    private final String color;
    private final String comment;


    public OrderTest(String browser, String name, String surname, String address, String metroStation, String phone, String date, String period, String color, String comment) {
        super(browser);
        this.name = name;
        this.surname = surname;
        this.address = address;
        this.metroStation = metroStation;
        this.phone = phone;
        this.date = date;
        this.period = period;
        this.color = color;
        this.comment = comment;
    }

    @Parameterized.Parameters(name = "{0}: {1} {2} {3} {4} {5} {6} {7} {8}")
    public static Object[][] getDate() {
        return new Object[][] {
                {"chrome", "Иван", "Петров", "ул. Ленина, 15", "Тверская", "+79991234567", "20.02.2026", "трое суток", "black", "Оставьте у двери"},
                {"chrome", "Мария", "Сидорова", "пр. Мира, 20", "Комсомольская", "+79119876543", "21.02.2026", "пятеро суток", "grey", "Позвоните за час"},
                {"firefox", "Иван", "Петров", "ул. Ленина, 15", "Тверская", "+79991234567", "20.02.2026", "трое суток", "black", "Оставьте у двери"},
                {"firefox", "Мария", "Сидорова", "пр. Мира, 20", "Комсомольская", "+79119876543", "21.02.2026", "пятеро суток", "grey", "Позвоните за час"}
        };
    }


    @Test
    public void testOrderFlowOrderButtonHeader() {
        mainPage.acceptCookies();
        // Кликнуть на кнопку «Заказать» на главной странице
        mainPage.clickOrderButtonHeader();

        // Заполнить форму «Для кого самокат»
        // Заполнить форму «Для кого самокат»
        orderPage.personData(name, surname, address, metroStation, phone);

        // Кликнуть на кнопку «Далее»
        orderPage.clickNextButton();

        // Заполнить форму «Про аренду»
        orderPageSteps.rentalData(date, period, color, comment);

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
        mainPage.acceptCookies();
        // Прокрутка до кнопки "Заказать" в середине сайта
        mainPage.scrollToButtonOrderMiddle();

        // Кликнуть по кнопке "Заказать" в середине сайта
        mainPage.clickButtonOrderMiddle();

        // Заполнить форму «Для кого самокат»
        orderPage.personData(name, surname, address, metroStation, phone);

        // Кликнуть на кнопку «Далее»
        orderPage.clickNextButton();

        // Заполнить форму «Про аренду»
        orderPageSteps.rentalData(date, period, color, comment);

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
