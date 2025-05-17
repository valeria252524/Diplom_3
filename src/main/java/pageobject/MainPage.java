package pageobject;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class MainPage {
    private WebDriver driver;
    private WebDriverWait wait;
    private By personalAccountButton = By.xpath("//a[contains(@class, 'AppHeader_header__link') and @href='/account']");
    private By logoButton = By.xpath("//div[@class='AppHeader_header__logo__2D0X2']");
    private By constructorButton = By.xpath("//p[text()='Конструктор']");
    private By signInButton = By.xpath("//button[text()='Войти в аккаунт']");
    private By orderButton = By.xpath("//button[text()='Оформить заказ']");
    private final By bunsSection = By.xpath("//div[contains(@class, 'tab_tab__1SPyG') and .//span[text()='Булки']]");

    private final By saucesSection = By.xpath("//div[contains(@class, 'tab_tab__1SPyG') and .//span[text()='Соусы']]");

    private final By fillingsSection = By.xpath("//div[contains(@class, 'tab_tab__1SPyG') and .//span[text()='Начинки']]");
    private final String activeTabClass = "tab_tab_type_current__2BEPc";

    public MainPage(WebDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }
    @Step("Открытие и ожидание загрузки главной страницы")
    public void openMainPage() {
        driver.get("https://stellarburgers.nomoreparties.site/");
        wait.until(ExpectedConditions.visibilityOfElementLocated(constructorButton));
    }
    @Step("Нажатие на кнопку 'Личный кабинет'")
    public void clickPersonalAccountButton() {
        driver.findElement(personalAccountButton).click();
    }
    @Step("Нажатие на кнопку 'Войти в аккаунт'")
    public void clickSignInButton() {
        driver.findElement(signInButton).click();
    }

    @Step("Нажатие на логотип")
    public void clickLogoButton() {
        driver.findElement(logoButton).click();
    }
    @Step("Нажатие на кнопку 'Конструктор'")
    public void clickConstructorButton() {
        driver.findElement(constructorButton).click();
    }
    @Step("Клик по секции и проверка её активности")
    private boolean clickSection(By section) {
        driver.findElement(section).click();
        wait.until(ExpectedConditions.attributeContains(section, "class", activeTabClass));
        return driver.findElement(section).getAttribute("class").contains(activeTabClass);
    }

    @Step("Проверка отображения выбранной секции 'Булки'")
    public boolean goToBunsSection() {
        driver.findElement(saucesSection).click();
        return clickSection(bunsSection);
    }
    @Step("Проверка отображения выбранной секции 'Соусы'")
    public boolean goToSaucesSection() {
        return clickSection(saucesSection);
    }
    @Step("Проверка отображения выбранной секции 'Начинки'")
    public boolean goToFillingsSection() {
        return clickSection(fillingsSection);
    }
    @Step("Проверка отображения кнопки 'Оформить заказ' у авторизованного пользователя")
    public boolean isOrderButtonVisible() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(orderButton));
        return driver.findElement(orderButton).isDisplayed();


    }
}
