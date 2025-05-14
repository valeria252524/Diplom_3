package pageobject;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


public class ForgotPasswordPage {
    private WebDriver driver;
    private By signInButtonOnForgotPasswordPage= By.xpath("//a[@href='/login']");

    private By signInButton = By.xpath("//button[text()='Войти']");

    public ForgotPasswordPage(WebDriver driver){
        this.driver = driver;
    }
    @Step("Ожидание загрузки страницы 'Восстановить пароль'")
    public void waitForLoadForgotPasswordPage() {
        new WebDriverWait(driver, Duration.ofSeconds(3))
                .until(ExpectedConditions.visibilityOfElementLocated(signInButtonOnForgotPasswordPage));
    }
    @Step("Нажатие на кнопку 'Войти' со страницы 'Восстановить пароль'")
    public void clickSignInButton() {
        driver.findElement(signInButtonOnForgotPasswordPage).click();
    }

}
