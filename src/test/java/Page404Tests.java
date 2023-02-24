import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ua.ukrposhta.Pages.HomePage;
import ua.ukrposhta.Pages.Page404;
import utils.TestData;
import utils.Waiter;
import utils.WebDriverFactory;

import static com.codeborne.selenide.Selenide.open;

public class Page404Tests extends TestData {

    @BeforeMethod
    public void setUp () {
        WebDriverFactory driver = new WebDriverFactory();
        driver.GetDriver("FIREFOX");
        open(PAGE_404_URL);
    }

    @Test (priority = 1)
    public void check404Page () {
        Page404 page = new Page404();
        Waiter waiter = new Waiter();

        waiter.waitForVisibility(page.getPageHeader());
        Assert.assertEquals(page.getHeaderText(), TEXT_404);
        Assert.assertEquals(page.getErrorText(), TEXT_ERROR);
        Assert.assertTrue(page.getToTheHomePageBtn().isDisplayed());
    }

    @Test (priority = 2)
    public void navigateToHomePage () {
        Page404 page = new Page404();
        HomePage homePage = new HomePage();
        Waiter waiter = new Waiter();

        waiter.waitForVisibility(page.getPageHeader());
        Assert.assertTrue(page.getToTheHomePageBtn().isDisplayed());
        page.getToTheHomePageBtn().click();
        waiter.waitForVisibility(homePage.getBottomHeader());
    }
}
