import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ua.ukrposhta.Pages.FindAddressPage;
import ua.ukrposhta.Pages.FindPostalIndexPage;
import ua.ukrposhta.Pages.HomePage;
import utils.TestData;
import utils.Waiter;
import utils.WebDriverFactory;

import static com.codeborne.selenide.Selenide.open;

public class FindAddressPageTests extends TestData {
    @BeforeMethod
    public void setUp () {
        WebDriverFactory driver = new WebDriverFactory();
        driver.GetDriver("FIREFOX");

        open(UKR_POSHTA_LINK);
        if(cookiesButton.isDisplayed())
        {cookiesButton.click();}
    }

    @Test
    public void findAddressByIndex () {
        HomePage homePage = new HomePage();
        FindAddressPage findAddress = new FindAddressPage();
        FindPostalIndexPage findIndex = new FindPostalIndexPage();
        Waiter waiter = new Waiter();

        homePage.clickOnTheIndexSearchButton();
        waiter.waitForVisibility(homePage.getIndexPageHeader());
        findIndex.clickOnSearchAddressByIndexNavLink();
        waiter.waitForVisibility(findAddress.getPageHeader());
        Assert.assertEquals(findAddress.getPageHeaderText(), FIND_ADDRESS_PAGE_HEADER);
        findAddress.fillInputField();
        findAddress.clickOnSearchButton();
        waiter.waitForVisibility(findAddress.getResponseBlock());
        Assert.assertEquals(findAddress.getAddressText(), ADDRESS);
    }
}
