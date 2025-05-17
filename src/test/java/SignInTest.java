import api.UserApiClient;
import io.qameta.allure.Step;
import models.User;
import org.junit.Before;
import org.junit.Test;
import pageobject.ForgotPasswordPage;
import pageobject.MainPage;
import pageobject.SignInPage;
import pageobject.SignUpPage;
import utils.RandomEmail;
import utils.RandomName;

import static org.junit.Assert.assertTrue;

public class SignInTest extends BaseTestForSetUp {
    private String email;
    private String password;
    private String userName;
    private MainPage objMainPage;
    private UserApiClient userApiClient;

    public SignInTest() {
        super();
    }

    @Before
    public void setUpForNewUser() {
        this.objMainPage = new MainPage(driver);
        userName = new RandomName().randomUserName();
        email = new RandomEmail().randomEmail();
        password = "1234567";

        User user = new User(email, password, userName);
        userApiClient = new UserApiClient();
        userApiClient.createUser(user);
        objMainPage = new MainPage(driver);
        objMainPage.openMainPage();
    }

    @Test
    @Step("Вход в аккаунт по кнопке 'Войти в аккаунт' на главной")
    public void signInFromMainPageTest() {
        objMainPage.clickSignInButton();
        SignInPage signInPage = new SignInPage(driver);
        signInPage.signIn(email, password);
        assertTrue(objMainPage.isOrderButtonVisible());

    }

    @Test
    @Step("Вход через кнопку 'Личный кабинет'")
    public void signInFromProfileTest() {
        objMainPage.clickPersonalAccountButton();
        SignInPage objSignInPage = new SignInPage(driver);
        objSignInPage.signIn(email, password);
        assertTrue(objMainPage.isOrderButtonVisible());
    }

    @Test
    @Step("Вход через кнопку в форме регистрации")
    public void signInFromSignUpPageTest() {
        objMainPage.clickSignInButton();
        SignInPage objSignInPage = new SignInPage(driver);
        objSignInPage.clickOnSignUpButton();
        SignUpPage objSignUpPage = new SignUpPage(driver);
        objSignUpPage.clickSignInButton();
        objSignInPage.signIn(email, password);
        assertTrue(objMainPage.isOrderButtonVisible());
    }

    @Test
    @Step("Вход через кнопку в форме восстановления пароля")
    public void signInFromForgotPasswordPageTest() {
        objMainPage.clickSignInButton();
        SignInPage objSignInPage = new SignInPage(driver);
        objSignInPage.forgotPasswordButton();
        ForgotPasswordPage objForgotPasswordPage = new ForgotPasswordPage(driver);
        objForgotPasswordPage.waitForLoadForgotPasswordPage();
        objForgotPasswordPage.clickSignInButton();
        objSignInPage.signIn(email, password);
        assertTrue(objMainPage.isOrderButtonVisible());
    }
}
