import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ua.ukrposhta.Pages.HomePage;
import ua.ukrposhta.Pages.LogInPage;
import ua.ukrposhta.Pages.PersonalAccountPage;
import utils.TestData;
import utils.Waiter;
import utils.WebDriverFactory;

import static com.codeborne.selenide.Selenide.open;

public class PersonalAccountPageTests extends TestData {

    @BeforeMethod
    public void setUp () {
        HomePage homePage = new HomePage();
        LogInPage logInPage = new LogInPage();
        Waiter waiter = new Waiter();
        WebDriverFactory driver = new WebDriverFactory();
        driver.GetDriver("FIREFOX");

        open(UKR_POSHTA_LINK);
        if(cookiesButton.isDisplayed())
        {cookiesButton.click();}
        homePage.clickOnTheRegistrationButton();
        waiter.waitForVisibility(logInPage.getPersonalAccountHeader());
    }

    @Test (priority = 1)
    public void sidebarNavigation () {
        PersonalAccountPage personalAccountPage = new PersonalAccountPage();
        Waiter waiter = new Waiter();

        Assert.assertEquals(personalAccountPage.getSideBarList(), personalAccountPage.getSideBarListExpected());
        personalAccountPage.clickOnTheExpandButton();
        waiter.waitForVisibility(personalAccountPage.getExpandedSection());
        Assert.assertEquals(personalAccountPage.getExpressList(), personalAccountPage.getExpressListExpected());
        personalAccountPage.clickOnTheFAQLink();
        waiter.waitForVisibility(personalAccountPage.getContactCenterHeader());
        Assert.assertEquals(personalAccountPage.getContactCenterHeaderText(), CONTACT_CENTER_EXPECTED_HEADER);
    }
}
