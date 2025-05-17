import io.qameta.allure.Step;
import org.junit.Test;
import pageobject.MainPage;
import pageobject.SignInPage;
import pageobject.SignUpPage;
import utils.RandomEmail;
import utils.RandomName;
import utils.RandomPassword;


import static org.junit.Assert.*;


public class SignUpTest extends BaseTestForSetUp {

    public SignUpTest() {
        super(); // Вызов конструктора родительского класса
    }

    @Test
    @Step("Проверка на успешную регистрацию")
    public void successSignUpTest() {
        MainPage objMainPage = new MainPage(driver);
        objMainPage.clickSignInButton();
        SignInPage objSignInPage = new SignInPage(driver);
        objSignInPage.clickOnSignUpButton();
        SignUpPage objSignUpPage = new SignUpPage(driver);
        String userName = new RandomName().randomUserName();
        String email = new RandomEmail().randomEmail();
        String password = new RandomPassword().randomPassword();
        objSignUpPage.signUp(userName,email,password);

        assertTrue(objSignInPage.isSignInButtonVisible());
    }
    @Test
    @Step("Проверка на появление сообщения об ошибке при вводе 5 символов в поле 'Пароль'")
    public void signUpAndEnter5NumbersInPasswordFieldTest() {
        MainPage objMainPage = new MainPage(driver);
        objMainPage.clickSignInButton();
        SignInPage objSignInPage = new SignInPage(driver);
        objSignInPage.clickOnSignUpButton();
        SignUpPage objSignUpPage = new SignUpPage(driver);
        objSignUpPage.clickSignUpButton();
        String userName = new RandomName().randomUserName();
        String email = new RandomEmail().randomEmail();
        String password = "12345";
        objSignUpPage.signUp(userName,email,password);
        assertTrue(objSignUpPage.isIncorrectPasswordErrorMessage());
    }

}
