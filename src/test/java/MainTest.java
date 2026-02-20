import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.By;
import page.MainPage;
import java.util.Arrays;
import java.util.Collection;


@RunWith(Parameterized.class)
public class MainTest extends BaseTest{
    private MainPage mainPage;

    private final String browser;
    private final By question;
    private final String expectedAnswer;

    // Конструктор для параметризованного теста
    public MainTest(String browser, By question, String expectedAnswer) {
        this.browser = browser;
        this.question = question;
        this.expectedAnswer = expectedAnswer;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][] {
                // chrome
                {"chrome", By.id("accordion__heading-0"), "Сутки — 400 рублей. Оплата курьеру — наличными или картой."},
                {"chrome", By.id("accordion__heading-1"), "Пока что у нас так: один заказ — один самокат. Если хотите покататься с друзьями, можете просто сделать несколько заказов — один за другим."},
                {"chrome", By.id("accordion__heading-2"), "Допустим, вы оформляете заказ на 8 мая. Мы привозим самокат 8 мая в течение дня. Отсчёт времени аренды начинается с момента, когда вы оплатите заказ курьеру. Если мы привезли самокат 8 мая в 20:30, суточная аренда закончится 9 мая в 20:30."},
                {"chrome", By.id("accordion__heading-3"), "Только начиная с завтрашнего дня. Но скоро станем расторопнее."},
                {"chrome", By.id("accordion__heading-4"), "Пока что нет! Но если что-то срочное — всегда можно позвонить в поддержку по красивому номеру 1010."},
                {"chrome", By.id("accordion__heading-5"), "Самокат приезжает к вам с полной зарядкой. Этого хватает на восемь суток — даже если будете кататься без передышек и во сне. Зарядка не понадобится."},
                {"chrome", By.id("accordion__heading-6"), "Да, пока самокат не привезли. Штрафа не будет, объяснительной записки тоже не попросим. Все же свои."},
                {"chrome", By.id("accordion__heading-7"), "Да, обязательно. Всем самокатов! И Москве, и Московской области."},
                // firefox
                {"firefox", By.id("accordion__heading-0"), "Сутки — 400 рублей. Оплата курьеру — наличными или картой."},
                {"firefox", By.id("accordion__heading-1"), "Пока что у нас так: один заказ — один самокат. Если хотите покататься с друзьями, можете просто сделать несколько заказов — один за другим."},
                {"firefox", By.id("accordion__heading-2"), "Допустим, вы оформляете заказ на 8 мая. Мы привозим самокат 8 мая в течение дня. Отсчёт времени аренды начинается с момента, когда вы оплатите заказ курьеру. Если мы привезли самокат 8 мая в 20:30, суточная аренда закончится 9 мая в 20:30."},
                {"firefox", By.id("accordion__heading-3"), "Только начиная с завтрашнего дня. Но скоро станем расторопнее."},
                {"firefox", By.id("accordion__heading-4"), "Пока что нет! Но если что-то срочное — всегда можно позвонить в поддержку по красивому номеру 1010."},
                {"firefox", By.id("accordion__heading-5"), "Самокат приезжает к вам с полной зарядкой. Этого хватает на восемь суток — даже если будете кататься без передышек и во сне. Зарядка не понадобится."},
                {"firefox", By.id("accordion__heading-6"), "Да, пока самокат не привезли. Штрафа не будет, объяснительной записки тоже не попросим. Все же свои."},
                {"firefox", By.id("accordion__heading-7"), "Да, обязательно. Всем самокатов! И Москве, и Московской области."},

        });
    }

    @Before
    public void setUp() {
        startBrowser(browser);
        driver.get("https://qa-scooter.praktikum-services.ru/");
        mainPage = new MainPage(driver, wait);
        mainPage.acceptCookies();
    }

    @Test
    public void testFaqQuestionsAndAnswers() {
        mainPage.scrollToFaqSection();
        mainPage.waitForFaqSection();
        mainPage.clickQuestion(question);

        By answerLocator = mainPage.getAnswerLocatorFromQuestion(question);
        String actualAnswer = mainPage.getAnswerText(answerLocator);

        if (!actualAnswer.contains(expectedAnswer)) {
            throw new AssertionError(
                    String.format(
                            "Текст ответа не соответствует ожидаемому.\n" +
                                    "Ожидаемый: '%s'\n" +
                                    "Фактический: '%s'",
                            expectedAnswer, actualAnswer)
            );
        }
    }
}