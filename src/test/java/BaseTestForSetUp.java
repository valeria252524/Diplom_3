import api.UserApiClient;
import org.openqa.selenium.WebDriver;
import webdriver.WebDriverCreator;
import org.junit.After;
import org.junit.Before;
import pageobject.MainPage;

public class BaseTestForSetUp {
    protected WebDriver driver;
    protected MainPage mainPage;
    private final String browser;


    public BaseTestForSetUp() {
        // Получаем браузер из системных свойств, если параметр не передан, используем "chrome" по умолчанию
        this.browser = System.getProperty("browser", "chrome");
    }

    @Before
    public void setUp() {
        driver = WebDriverCreator.getWebDriver(browser); // Используем браузер, переданный через параметры
        mainPage = new MainPage(driver); // Инициализируем страницу
        mainPage.openMainPage(); // Открываем главную страницу
    }

    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }

    }
}
