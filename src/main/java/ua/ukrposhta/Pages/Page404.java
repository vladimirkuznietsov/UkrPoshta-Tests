package ua.ukrposhta.Pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class Page404 {

    private final SelenideElement pageHeader = $x("//h1[@class=\"lg-heading\"]");
    private final SelenideElement errorExp = $x("//div[@class=\"title-block-container text-center\"]/p");
    private final SelenideElement toTheHomePageButton = $x("//div[@class=\"title-block-container text-center\"]/a");

    /**
     * Get "404" page header
     */
    public SelenideElement getPageHeader () {
        return pageHeader;
    }

    /**
     * Get "На головну" button
     */
    public SelenideElement getToTheHomePageBtn () {
        return toTheHomePageButton;
    }

    /**
     * Get text of the "404" page header
     */
    public String getHeaderText () {
        return pageHeader.getText();
    }

    /**
     * Get text of the error explanation
     */
    public String getErrorText () {
        return errorExp.getText();
    }

}
