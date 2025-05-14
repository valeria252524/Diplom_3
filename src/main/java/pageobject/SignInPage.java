package pageobject;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.time.Duration;

public class SignInPage {
    private WebDriver driver;
    private WebDriverWait wait;
    private By emailField = By.xpath("//label[contains(text(),'Email')]/parent::div//input");
    private By passwordField = By.xpath("//label[contains(text(),'Пароль')]/parent::div//input");
    private By signInButton = By.xpath("//button[text()='Войти']");
    private By signUpButton = By.xpath("//a[text()='Зарегистрироваться']");
    private By forgotPasswordButton = By.xpath("//a[@href='/forgot-password']");

    public SignInPage(WebDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(3));
    }
    @Step("Заполнение поля 'Email'")
    public void setEmail(String email) {
        driver.findElement(emailField).click();
        driver.findElement(emailField).clear();
        driver.findElement(emailField).sendKeys(email);
    }
    @Step("Заполнение поля 'Пароль'")
    public void setPassword(String password) {
        driver.findElement(passwordField).click();
        driver.findElement(passwordField).clear();
        driver.findElement(passwordField).sendKeys(password);
    }
    @Step("Нажатие на кнопку 'Войти'")
    public void clickSignInButton() {
        driver.findElement(signInButton).click();
    }
    @Step("Авторизация по заданным email и паролю")
    public void signIn(String email, String password){
        setEmail(email);
        setPassword(password);
        clickSignInButton();
    }
    @Step("Нажатие на кнопку 'Восстановить пароль'")
    public void forgotPasswordButton() {
        driver.findElement(forgotPasswordButton).click();
    }

    @Step("Проверка отображения кнопки 'Вход'")
    public boolean isSignInButtonVisible() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(signInButton));
        return driver.findElement(signInButton).isDisplayed();
    }
    @Step("Нажатие на кнопку 'Зарегистрироваться'")
    public void clickOnSignUpButton(){
        driver.findElement(signUpButton).click();
    }
}
