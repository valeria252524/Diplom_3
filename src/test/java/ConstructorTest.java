import io.qameta.allure.Step;
import org.junit.Test;
import pageobject.MainPage;

import static org.junit.Assert.assertTrue;

public class ConstructorTest extends BaseTestForSetUp {
    public ConstructorTest(){
        super();
    }
    @Test
    @Step("Переход к разделу 'Булки'")
    public void isBunsSectionDisplayedTest(){
        MainPage objMainPage = new MainPage(driver);
        assertTrue(objMainPage.goToBunsSection());
    }
    @Test
    @Step("Переход к разделу 'Соусы'")
    public void isSaucesSectionDisplayedTest(){
        MainPage objMainPage = new MainPage(driver);
        assertTrue(objMainPage.goToSaucesSection());
    }
    @Test
    @Step("Переход к разделу 'Начинки'")
    public void isFillingSectionDisplayedTest(){
        MainPage objMainPage = new MainPage(driver);
        assertTrue(objMainPage.goToFillingsSection());
    }

}
