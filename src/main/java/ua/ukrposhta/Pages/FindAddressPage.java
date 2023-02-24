package ua.ukrposhta.Pages;

import com.codeborne.selenide.SelenideElement;
import utils.TestData;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;


public class FindAddressPage extends TestData {

    private final SelenideElement pageHeader = $x("//div[@class=\"container\"]/h3");
    private final SelenideElement searchInputField = $("#postIndex");
    private final SelenideElement searchButton = $x("//button[@type=\"submit\"]");
    private final SelenideElement responseBlock = $x("//response-address-loader");
    private final SelenideElement address = $x("//response-address-loader/div[1]/p[4]");

    /**
     * Get page header
     */
    public SelenideElement getPageHeader () {
        return pageHeader;
    }

    /**
     * Get text of the page header
     */
    public String getPageHeaderText () {
        return pageHeader.getText();
    }

    /**
     * Fill the search field with the postal index
     */
    public void fillInputField () {
        searchInputField.sendKeys(POSTAL_INDEX);
    }

    /**
     * Click on the "Знайти" button
     */
    public void clickOnSearchButton () {
        searchButton.click();
    }

    /**
     * Get response block
     */
    public SelenideElement getResponseBlock () {
        return responseBlock;
    }

    /**
     * Get address from the response block
     */
    public String getAddressText() {
        return address.getText();
    }
}
