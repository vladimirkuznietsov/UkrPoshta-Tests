package ua.ukrposhta.Pages;

import com.codeborne.selenide.SelenideElement;
import utils.TestData;

import static com.codeborne.selenide.Selenide.$x;

public class FindPostalIndexPage extends TestData {

    private final SelenideElement cityDropdownListFirstOption = $x("//button[@id=\"3641\"]");
    private final SelenideElement streetDropdownList = $x("//ul[@class=\"street-dropdown-menu show ng-star-inserted\"]");
    private final SelenideElement streetDropdownListFirstOption = $x("//button[@id=\"S175741\"]");
    private final SelenideElement houseDropdownList = $x("//ul[@class=\"houses-dropdown-menu ng-star-inserted show\"]");
    private final SelenideElement houseDropdownListFirstOption = $x("//button[@id=\"H1\"]");
    private final SelenideElement submitButton = $x("//button[@type=\"submit\"]");
    private final SelenideElement indexResponseBlock = $x("//response-index-loader");
    private final SelenideElement indexResponseBlockHeader = $x("//response-index-loader/div[1]/p[1]");
    private final SelenideElement searchAddressByIndexNavLink = $x("//form/a[1]");

    /**
     * Get "Вулиця" dropdown-list
     */
    public SelenideElement getStreetDropdownList () {
        return streetDropdownList;
    }

    /**
     * Get "Будинок" dropdown-list
     */
    public SelenideElement getHouseDropdownList () {
        return houseDropdownList;
    }

    /**
     * Get index response block
     */
    public SelenideElement getIndexResponseBlock () {
        return indexResponseBlock;
    }

    /**
     * Get "Знайти" button
     */
    public SelenideElement getSubmitButton() {
        return submitButton;
    }

    /**
     * Get text of the index response block header
     */
    public String getIndexResponseBlockHeaderText() {
        return indexResponseBlockHeader.getText();
    }

    /**
     * Click on the first option of the "Місто" dropdown-list
     */
    public void clickOnCityDropdownListFirstOption () {
        cityDropdownListFirstOption.click();
    }

    /**
     * Click on the first option of the "Вулиця" dropdown-list
     */
    public void clickOnStreetDropdownListFirstOption () {
        streetDropdownListFirstOption.click();
    }

    /**
     * Click on the first option of the "Будинок" dropdown-list
     */
    public void clickOnHouseDropdownListFirstOption () {
        houseDropdownListFirstOption.click();
    }

    /**
     * Click on the "Знайти" button
     */
    public void clickOnSubmitButton () {
        submitButton.click();
    }

    /**
     * Click on the "Знайти адресу за індексом" navigation link
     */
    public void clickOnSearchAddressByIndexNavLink () {
        searchAddressByIndexNavLink.click();
    }
}
