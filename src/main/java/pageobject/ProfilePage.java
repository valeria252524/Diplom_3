package pageobject;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;


public class ProfilePage {
    private WebDriver driver;
    private WebDriverWait wait;
    private By logOutButton = By.xpath("//button[text()='Выход']");
    private By profileSection = By.xpath("//a[contains(@class, 'Account_link') and @href='/account/profile']");


    public ProfilePage(WebDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(3));
    }


        @Step("Клик на кнопку 'Выход'")
        public void logOut() {
            wait.until(ExpectedConditions.visibilityOfElementLocated(logOutButton));
            driver.findElement(logOutButton).click();
    }
    @Step("Проверка отображения раздела 'Профиль' в личном кабинете у авторизованного пользователя")
    public boolean isProfileSectionVisible() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(profileSection));
        return driver.findElement(profileSection).isDisplayed();

    }

}
