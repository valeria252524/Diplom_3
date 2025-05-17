package webdriver;

import config.ConfigReader;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class WebDriverCreator {

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
        String chromeDriverPath = ConfigReader.get("chrome.driver.path");
        System.setProperty("webdriver.chrome.driver", chromeDriverPath);
        ChromeOptions options = new ChromeOptions();
        return new ChromeDriver(options);
    }

    private static WebDriver createYandexDriver() {
        String yandexDriverPath = ConfigReader.get("yandex.driver.path");
        String yandexBinaryPath = ConfigReader.get("yandex.binary.path");
        System.setProperty("webdriver.chrome.driver", yandexDriverPath);
        ChromeOptions options = new ChromeOptions();
        options.setBinary(yandexBinaryPath);
        return new ChromeDriver(options);
    }
}
