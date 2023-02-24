import com.codeborne.selenide.Selenide;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ua.ukrposhta.Pages.HomePage;
import ua.ukrposhta.Pages.LogInPage;
import ua.ukrposhta.Pages.PersonalAccountPage;
import ua.ukrposhta.Pages.UkrPoshtaStandartPage;
import utils.TestData;
import utils.Waiter;
import utils.WebDriverFactory;

import static com.codeborne.selenide.Selenide.open;

public class StandartCreateTests extends TestData {

    @BeforeMethod
    public void setUp () {
        WebDriverFactory driver = new WebDriverFactory();

        driver.GetDriver("firefox");
        open(UKR_POSHTA_LINK);
    }

    @Test (priority = 1)
    public void createNewDespatch () throws InterruptedException {
        Waiter waiter = new Waiter();
        UkrPoshtaStandartPage standartPage = new UkrPoshtaStandartPage();
        HomePage homePage  = new HomePage();
        LogInPage logInPage = new LogInPage();
        PersonalAccountPage personalAccountPage = new PersonalAccountPage();

        if (cookiesButton.isDisplayed()) {cookiesButton.click();}
        homePage.clickOnTheRegistrationButton();

        waiter.waitForVisibility(logInPage.getPersonalAccountHeader());
        logInPage.clickOnTheLogInButton();
        waiter.waitForVisibility(logInPage.getAuthorizationHeader());
        logInPage.logInWithValidCreds();
        waiter.waitForVisibility(logInPage.getStopSessionButton());
        personalAccountPage.clickOnTheUkrPoshtaStandartLink();
        waiter.waitForVisibility(standartPage.getStandartCreateBtn());
        standartPage.clickOnTheStandartCreateBtn();
        waiter.waitForVisibility(standartPage.getFirstReceiverInputField());
        standartPage.fillMandatoryFields();
        standartPage.getSubmitButton().scrollTo();
        Selenide.sleep(2000);
        standartPage.clickOnSubmitButton();
        Thread.sleep(2000);
        Assert.assertTrue(standartPage.getDespatchCard().isDisplayed());
    }

    @Test (priority = 3)
    public void modifyDespatch () {
        UkrPoshtaStandartPage standartPage = new UkrPoshtaStandartPage();
        Waiter waiter = new Waiter();
        HomePage homePage  = new HomePage();
        PersonalAccountPage personalAccountPage = new PersonalAccountPage();

        homePage.clickOnTheRegistrationButton();
        personalAccountPage.clickOnTheUkrPoshtaStandartLink();
        waiter.waitForVisibility(standartPage.getDespatchCard());
        standartPage.clickOnTheMoreInfoButton();
        waiter.waitForVisibility(standartPage.getDespatchMoreInfoReceiverName());
        Assert.assertTrue(standartPage.isReceiverNameProper());
        standartPage.clickOnModifyButton();
        waiter.waitForVisibility(standartPage.getPhoneInputModifyPage());
        standartPage.clearPhoneInput();
        Selenide.sleep(2000);
        standartPage.fillPhoneInput();
        standartPage.getSubmitButton().scrollTo();
        Selenide.sleep(2000);
        standartPage.clickOnSubmitButton();
        Selenide.sleep(2000);
        standartPage.getDespatchMoreInfoButton().scrollTo();
        standartPage.clickOnTheMoreInfoButton();
        Assert.assertTrue(standartPage.isNumberProper());
    }

    @Test (priority = 4)
    public void deleteDespatch () {
        UkrPoshtaStandartPage standartPage = new UkrPoshtaStandartPage();
        Waiter waiter = new Waiter();
        HomePage homePage  = new HomePage();
        PersonalAccountPage personalAccountPage = new PersonalAccountPage();

        homePage.clickOnTheRegistrationButton();
        personalAccountPage.clickOnTheUkrPoshtaStandartLink();
        waiter.waitForVisibility(standartPage.getDespatchCard());
        standartPage.clickOnTheMoreInfoButton();
        waiter.waitForVisibility(standartPage.getDeleteDespatchButton());
        standartPage.clickOnTheDeleteDespatchButton();
        waiter.waitForVisibility(standartPage.getDeleteMessageBox());
        Assert.assertTrue(standartPage.isConfirmDeleteBoxProper());
        standartPage.clickOnDeleteButton();
        Selenide.sleep(2000);
        Assert.assertTrue(standartPage.isDespatchDeleted());
        standartPage.clickOnTheStopSessionButton();
    }

    @Test (priority = 2)
    public void checkDeliveryMethodsValues () {
        UkrPoshtaStandartPage standartPage = new UkrPoshtaStandartPage();
        Waiter waiter = new Waiter();
        HomePage homePage  = new HomePage();
        PersonalAccountPage personalAccountPage = new PersonalAccountPage();

        homePage.clickOnTheRegistrationButton();
        personalAccountPage.clickOnTheUkrPoshtaStandartLink();
        waiter.waitForVisibility(standartPage.getStandartCreateBtn());
        standartPage.clickOnTheStandartCreateBtn();
        waiter.waitForVisibility(standartPage.getFirstReceiverInputField());
        standartPage.clickOnTheDeliveryDropdown();
        waiter.waitForVisibility(standartPage.getDeliveryMethodDropdownList());
        Assert.assertTrue(standartPage.isDeliveryOptionsProper());
    }

}
