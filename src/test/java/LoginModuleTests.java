import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ua.ukrposhta.Pages.HomePage;
import ua.ukrposhta.Pages.LogInPage;
import utils.TestData;
import utils.Waiter;
import utils.WebDriverFactory;

import static com.codeborne.selenide.Selenide.open;

public class LoginModuleTests extends TestData {

    @BeforeMethod
    public void setUp() {
        WebDriverFactory driver = new WebDriverFactory();
        driver.GetDriver("FIREFOX");
        open(UKR_POSHTA_LINK);
        if(cookiesButton.isDisplayed())
        {cookiesButton.click();}
    }


    @Test (priority = 1)
    public void loginWithValidCreds () {
        HomePage homePage = new HomePage();
        LogInPage logInPage = new LogInPage();
        Waiter waiter = new Waiter();

        homePage.clickOnTheRegistrationButton();
        waiter.waitForVisibility(logInPage.getPersonalAccountHeader());
        logInPage.clickOnTheLogInButton();
        logInPage.logInWithValidCreds();
        waiter.waitForVisibility(logInPage.getStopSessionButton());
        Assert.assertTrue(logInPage.isVerifyLogIn());
        logInPage.getStopSessionButton().click();
    }

    @Test (priority = 2)
    public void loginWithInvalidEmail () {
        HomePage homePage = new HomePage();
        LogInPage logInPage = new LogInPage();
        Waiter waiter = new Waiter();

        homePage.clickOnTheRegistrationButton();
        waiter.waitForVisibility(logInPage.getPersonalAccountHeader());
        logInPage.clickOnTheLogInButton();
        logInPage.logInWithInvalidCreds("Email");
        waiter.waitForVisibility(logInPage.getErrorMessageOnLogin());
        Assert.assertTrue(logInPage.isVerifyErrorMessageMail());
    }

    @Test (priority = 3)
    public void loginWithInvalidPassword () {
        HomePage homePage = new HomePage();
        LogInPage logInPage = new LogInPage();
        Waiter waiter = new Waiter();

        homePage.clickOnTheRegistrationButton();
        waiter.waitForVisibility(logInPage.getPersonalAccountHeader());
        logInPage.clickOnTheLogInButton();
        logInPage.logInWithInvalidCreds("Password");
        waiter.waitForVisibility(logInPage.getErrorMessageOnLogin());
        Assert.assertTrue(logInPage.isVerifyErrorMessagePass());
    }

    @Test (priority = 4)
    public void loginWithNoData () {
        HomePage homePage = new HomePage();
        LogInPage logInPage = new LogInPage();
        Waiter waiter = new Waiter();

        homePage.clickOnTheRegistrationButton();
        waiter.waitForVisibility(logInPage.getPersonalAccountHeader());
        logInPage.clickOnTheLogInButton();
        waiter.waitForVisibility(logInPage.getAuthorizationHeader());
        logInPage.clickOnTheEnterButton();
        Assert.assertTrue(logInPage.isAuthorizationSectionOpened());
    }
}
