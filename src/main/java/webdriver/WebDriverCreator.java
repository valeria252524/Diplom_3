package webdriver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class WebDriverCreator {

    private static final String CHROMEDRIVER_PATH = "/Users/valeriamalygina/chromedriver/chromedriver";
    private static final String YANDEX_BROWSER_PATH = "/Applications/Yandex.app/Contents/MacOS/Yandex";
    private static final String YANDEX_DRIVER_PATH = "/Users/valeriamalygina/chromeyandexdriver/chromedriver-134"; // тот же chromedriver

    public static WebDriver getWebDriver(String browserName) {
        switch (browserName.toLowerCase()) {
            case "chrome":
                return createChromeDriver();
            case "yandex":
                return createYandexDriver();
            default:
                throw new RuntimeException("Incorrect browser name: " + browserName);
        }
    }

    private static WebDriver createChromeDriver() {
        System.setProperty("webdriver.chrome.driver", CHROMEDRIVER_PATH);
        ChromeOptions options = new ChromeOptions();
        return new ChromeDriver(options);
    }

    private static WebDriver createYandexDriver() {
        System.setProperty("webdriver.chrome.driver", YANDEX_DRIVER_PATH);
        ChromeOptions options = new ChromeOptions();
        options.setBinary(YANDEX_BROWSER_PATH);
        return new ChromeDriver(options);
    }
}
