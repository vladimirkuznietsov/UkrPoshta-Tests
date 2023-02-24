import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ua.ukrposhta.Pages.HomePage;
import utils.TestData;
import utils.Waiter;
import utils.WebDriverFactory;

import static com.codeborne.selenide.Selenide.open;

public class HomePageTests extends TestData {

    @BeforeMethod
    public void setUp() {
        WebDriverFactory driver = new WebDriverFactory();
        driver.GetDriver("FIREFOX");
        open(UKR_POSHTA_LINK);
    }

    @Test (priority = 1)
    public void changeLanguageToRu () {
        HomePage homePage = new HomePage();
        Waiter waiter = new Waiter();

        waiter.waitForVisibility(homePage.getLanguageDropdownButton());
        homePage.clickOnTheLanguageDropdownButton();
        waiter.waitForVisibility(homePage.getFirstLanguageButton());
        Assert.assertTrue(homePage.isLanguageDropdownValuesEqual("RU", "EN"));
        homePage.selectRuLanguage();
        Assert.assertTrue(homePage.isRuLanguageApplied());
        waiter.waitForVisibility(homePage.getLanguageDropdownButton());
        homePage.clickOnTheLanguageDropdownButton();
        waiter.waitForVisibility(homePage.getFirstLanguageButton());
        Assert.assertTrue(homePage.isLanguageDropdownValuesEqual("UA", "EN"));
    }

    @Test (priority = 2)
    public void changeLanguageToEn () {
        HomePage homePage = new HomePage();
        Waiter waiter = new Waiter();

        homePage.clickOnTheLanguageDropdownButton();
        waiter.waitForVisibility(homePage.getFirstLanguageButton());
        Assert.assertTrue(homePage.isLanguageDropdownValuesEqual("RU", "EN"));
        homePage.selectEnLanguage();
        Assert.assertTrue(homePage.isEnLanguageApplied());
        homePage.clickOnTheLanguageDropdownButton();
        waiter.waitForVisibility(homePage.getFirstLanguageButton());
        Assert.assertTrue(homePage.isLanguageDropdownValuesEqual("UA", "RU"));
    }

    @Test (priority = 3)
    public void openIndexSearchPage () {
        HomePage homePage = new HomePage();

        homePage.clickOnTheIndexSearchButton();
        Assert.assertTrue(homePage.isIndexSearchPageOpened());
    }

    @Test (priority = 4)
    public void openIndexSearchPageFromInput () {
        HomePage homepage = new HomePage();
        Waiter waiter = new Waiter();

        homepage.scrollToIndexSearchInput();
        waiter.waitForVisibility(homepage.getSearchIndexInput());
        homepage.sendKeysToIndexSearchInput();
        Assert.assertTrue(homepage.isIndexSearchPageOpened());
    }
}
