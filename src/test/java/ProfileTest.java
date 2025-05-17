import api.UserApiClient;
import io.qameta.allure.Step;
import models.User;
import org.junit.Before;
import org.junit.Test;
import pageobject.MainPage;
import pageobject.ProfilePage;
import pageobject.SignInPage;
import utils.RandomEmail;
import utils.RandomName;

    public class ProfileTest extends BaseTestForSetUp {
        private String email;
        private String password;
        private String userName;
        private MainPage objMainPage;
        private UserApiClient userApiClient;

        public ProfileTest() {
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
        @Step("Переход по клику на 'Личный кабинет'")
        public void clickOnProfileTest() {
            objMainPage.clickSignInButton();
            SignInPage signInPage = new SignInPage(driver);
            signInPage.signIn(email, password);
            objMainPage.clickPersonalAccountButton();
            ProfilePage objProfilePage = new ProfilePage(driver);
            objProfilePage.isProfileSectionVisible();
        }

        @Test
        @Step("Переход из личного кабинета в конструктор")
        public void clickOnConstructorButtonFromProfileTest() {
            objMainPage.clickSignInButton();
            SignInPage signInPage = new SignInPage(driver);
            signInPage.signIn(email, password);
            objMainPage.clickPersonalAccountButton();
            objMainPage.clickConstructorButton();
            objMainPage.isOrderButtonVisible();

        }

        @Test
        @Step("Переход из личного кабинета на главную страницу по логотипу")
        public void clickOnLogoButtonFromProfileTest() {
            objMainPage.clickSignInButton();
            SignInPage signInPage = new SignInPage(driver);
            signInPage.signIn(email, password);
            objMainPage.clickPersonalAccountButton();
            objMainPage.clickLogoButton();
            objMainPage.isOrderButtonVisible();
        }

        @Test
        @Step("Выход из личного кабинета")
        public void LogOutTest() {
            objMainPage.clickSignInButton();
            SignInPage signInPage = new SignInPage(driver);
            signInPage.signIn(email, password);
            objMainPage.clickPersonalAccountButton();
            ProfilePage objProfilePage = new ProfilePage(driver);
            objProfilePage.logOut();
            signInPage.isSignInButtonVisible();
        }
    }

