import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
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



    public void startBrowser(String browser) {
        if (browser.equals("chrome")) {
            startBrowserChrome();
        } else if (browser.equals("firefox")) {
            startBrowserFirefox();
        }
        wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        mainPage = new MainPage(driver, wait);
        orderPage = new OrderPage(driver, wait);
        orderPageSteps = new OrderPageSteps(driver, wait);
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



