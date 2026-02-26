import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import page.MainPage;
import page.OrderPage;
import page.OrderPageSteps;
import java.time.Duration;


public class BaseTest {
    protected WebDriver driver;
    protected WebDriverWait wait;
    protected MainPage mainPage;
    protected OrderPage orderPage;
    protected OrderPageSteps orderPageSteps;
    protected String browser;

    // Константа URL
    protected  static final String BASE_URL = "https://qa-scooter.praktikum-services.ru/";

    public BaseTest(String browser) {
        this.browser = browser;
    }

    public void startBrowser(String browser) {
        if (browser.equals("chrome")) {
            startBrowserChrome();
        } else if (browser.equals("firefox")) {
            startBrowserFirefox();
        }

        driver.get(BASE_URL);
        wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        mainPage = new MainPage(driver, wait);
        orderPage = new OrderPage(driver, wait);
        orderPageSteps = new OrderPageSteps(driver, wait);

    }

    @Before
    public void startBrowser() {
        startBrowser(browser);
        driver.get(BASE_URL);
        mainPage = new MainPage(driver, wait);
    }


    private void startBrowserFirefox() {
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
    }

    private void startBrowserChrome() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }

    // Закрыть браузер
    @After
    public void tearDown() {
        driver.quit();
    }
}



