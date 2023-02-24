package ua.ukrposhta.Pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.Keys;
import utils.TestData;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class HomePage extends TestData {

    private final SelenideElement contactCenter = $x("//div[@class=\"header-call-center\"]/p[2]/a");
    private final SelenideElement languageDropdownButton = $("#language-menu-trigger-header");
    private final SelenideElement firstLanguageButton = $x("//div[@id=\"language-menu-block-header\"]/div[1]/a[1]");
    private final SelenideElement secondLanguageButton = $x("//div[@id=\"language-menu-block-header\"]/div[1]/a[2]");
    private final SelenideElement indexSearchButton = $("#find_index1");
    private final SelenideElement indexPageHeader = $x("//div[@class=\"container\"]/h3");
    private  final SelenideElement searchIndexInput = $x("//input[@name=\"city-name\"]");
    private final SelenideElement registrationButton = $x("//div[@class=\"user-account col-auto desctop\"]/a[2]/span");
    private final SelenideElement bottomHeader = $("#bottom-header");

    /**
     * Get language change dropdown-button
     */
    public SelenideElement getLanguageDropdownButton() {
        return languageDropdownButton;
    }

    /**
     * Get "Знайти індекс за адресою" input field
     */
    public SelenideElement getSearchIndexInput() {
        return searchIndexInput;
    }

    /**
     * Get first option of the language change dropdown
     */
    public SelenideElement getFirstLanguageButton() {
        return firstLanguageButton;
    }

    /**
     * Get header of the "Знайти індекс" page
     */
    public SelenideElement getIndexPageHeader () {
        return indexPageHeader;
    }

    /**
     * Get bottom section of the header
     */
    public SelenideElement getBottomHeader () {
        return bottomHeader;
    }

    /**
     * Comparing actual and expected values provided in the language selection dropdown
     */
    public boolean isLanguageDropdownValuesEqual(String valueOne, String valueTwo){
        String firstValue = firstLanguageButton.getText();
        String secondValue = secondLanguageButton.getText();

        return firstValue.equals(valueOne) && secondValue.equals(valueTwo);
    }

    /**
     * Click on the "RU" button of the dropdown-list
     */
    public void selectRuLanguage () {
        firstLanguageButton.click();
    }

    /**
     * Click on the "EN" button of the dropdown-list
     */
    public void selectEnLanguage () {
        secondLanguageButton.click();
    }

    /**
     * Check if the website language changed to RU
     */
    public boolean isRuLanguageApplied () {
        return contactCenter.getText().equals(CONTACT_CENTER_RU);
    }

    /**
     * Check if the website language changed to En
     */
    public boolean isEnLanguageApplied () {
        return contactCenter.getText().equals(CONTACT_CENTER_EN);
    }

    /**
     * Click on the indexSearchButton
     */
    public void clickOnTheIndexSearchButton () {
        indexSearchButton.click();
    }

    /**
     * Verify that the Index search page is opened
     */
    public boolean isIndexSearchPageOpened () {
        return indexPageHeader.getText().equals(FIND_POSTAL_INDEX);
    }

    /**
     * Scroll to the index search input field
     */
    public void scrollToIndexSearchInput () {
        searchIndexInput.scrollTo();
    }

    /**
     * Send keys to the index search input
     */
    public void sendKeysToIndexSearchInput () {
        searchIndexInput.sendKeys(CITY_NAME, Keys.ENTER);
    }

    /**
     * Click on the Registration button
     */
    public void clickOnTheRegistrationButton () {
        registrationButton.click();
    }

    /**
     * Click on the language dropdown button
     */
    public void clickOnTheLanguageDropdownButton () {
        languageDropdownButton.click();
    }
}

