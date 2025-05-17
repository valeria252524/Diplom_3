package pageobject;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class SignUpPage  {
    private WebDriver driver;
    private WebDriverWait wait;
    private By userNameField = By.xpath("//label[text()='Имя']/following-sibling::input");
    private By emailField = By.xpath("//label[text()='Email']/following-sibling::input");
    private By passwordField = By.xpath("//label[text()='Пароль']/following-sibling::input[@type='password']");
    private By signUpButton = By.xpath("//button[text()='Зарегистрироваться']");
    private By incorrectPasswordError = By.xpath("//p[@class='input__error text_type_main-default' and text()='Некорректный пароль']");
    private By signInButton = By.xpath("//a[contains(text(),'Войти')]");

    public SignUpPage(WebDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    @Step("Ввод имени")
    public void setUserName(String userName){
        driver.findElement(userNameField).click();
        driver.findElement(userNameField).clear();
        driver.findElement(userNameField).sendKeys(userName);
    }
    @Step("Ввод email")
    public void setEmail(String email) {
        driver.findElement(emailField).click();
        driver.findElement(emailField).clear();
        driver.findElement(emailField).sendKeys(email);
    }
    @Step("Ввод пароля")
    public void setPassword(String password) {
        driver.findElement(passwordField).click();
        driver.findElement(passwordField).clear();
        driver.findElement(passwordField).sendKeys(password);
    }
    @Step("Нажатие на кнопку 'Зарегистрироваться'")
    public void clickSignUpButton() {
        driver.findElement(signUpButton).click();
    }

    @Step("Регистрация с вводом имени, email, пароля и кликом на кнопку'Зарегистрироваться'")
    public void signUp(String userName, String email, String password){
        setUserName(userName);
        setEmail(email);
        setPassword(password);
        clickSignUpButton();
    }
    @Step("Проверка отображения ошибки 'Некорректный пароль'")
    public boolean isIncorrectPasswordErrorMessage() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(incorrectPasswordError));
        return driver.findElement(incorrectPasswordError).isDisplayed();
    }

    @Step("Нажатие на кнопку 'Войти' со страницы регистрации")
    public void clickSignInButton(){
        driver.findElement(signInButton).click();
    }

}

