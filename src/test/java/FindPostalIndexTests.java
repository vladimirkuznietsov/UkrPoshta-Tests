import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ua.ukrposhta.Pages.FindPostalIndexPage;
import ua.ukrposhta.Pages.HomePage;
import utils.TestData;
import utils.Waiter;
import utils.WebDriverFactory;

import static com.codeborne.selenide.Selenide.open;

public class FindPostalIndexTests extends TestData {

    @BeforeMethod
    public void setUp () {
        WebDriverFactory driver = new WebDriverFactory();
        driver.GetDriver("FIREFOX");
        open(UKR_POSHTA_LINK);
        if(cookiesButton.isDisplayed())
        {cookiesButton.click();}
    }

    @Test
    public void FindPostalIndex () {
        HomePage homePage = new HomePage();
        FindPostalIndexPage postalPage = new FindPostalIndexPage();
        Waiter waiter = new Waiter();

        homePage.scrollToIndexSearchInput();
        homePage.sendKeysToIndexSearchInput();
        waiter.waitForVisibility(homePage.getIndexPageHeader());
        postalPage.clickOnCityDropdownListFirstOption();
        waiter.waitForVisibility(postalPage.getStreetDropdownList());
        postalPage.clickOnStreetDropdownListFirstOption();
        waiter.waitForVisibility(postalPage.getHouseDropdownList());
        postalPage.clickOnHouseDropdownListFirstOption();
        waiter.waitForVisibility(postalPage.getSubmitButton());
        postalPage.clickOnSubmitButton();
        waiter.waitForVisibility(postalPage.getIndexResponseBlock());
        Assert.assertEquals(postalPage.getIndexResponseBlockHeaderText(), POSTAL_INDEX);
    }
}
