package ua.ukrposhta.Pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import java.util.ArrayList;

import static com.codeborne.selenide.Selenide.$$;
import static com.codeborne.selenide.Selenide.$x;

public class PersonalAccountPage {

    private final SelenideElement expressPoshtaExpand = $x("//a[@href=\"#expressLink\"]");
    private final SelenideElement contactCenterHeader = $x("//div[@class=\"container\"]/h3");
    private final SelenideElement ukrPoshtaStandartLink = $x("//ul[@id=\"accordion\"]/li[4]/div[1]/a");
    private final SelenideElement expandedSection = $x("//div[@class=\"accordion-inner collapse in\"]");
    private final ElementsCollection actualValues = $$("li.panel.sidebar-item");
    private final ElementsCollection expressListValues = $$(By.xpath("//*[@id=\"expressLink\"]/ul/li"));
    ArrayList<String> expressListText = new ArrayList<>();
    ArrayList<String> actualValuesText = new ArrayList<>();

    /**
     * List of expected values
     */
    public ArrayList<String> getExpressListExpected() {
        ArrayList<String> values = new ArrayList<>();

        values.add("Інструкція");
        values.add("Питання-відповіді");
        values.add("Тарифи");
        values.add("Терміни");
        values.add("Місця приймання");
        values.add("Упакування");
        return values;
    }

    /**
     * List of expected values
     */
    public ArrayList<String> getSideBarListExpected() {
        ArrayList<String> ExpectedValues = new ArrayList<>();
        ExpectedValues.add("Профіль користувача");
        ExpectedValues.add("Програма лояльності");
        ExpectedValues.add("Укрпошта Експрес");
        ExpectedValues.add("Укрпошта Стандарт");
        ExpectedValues.add("Укрпошта Документи");
        ExpectedValues.add("Лист");
        ExpectedValues.add("Міжнародні відправлення");
        ExpectedValues.add("Виклик кур’єра");
        return ExpectedValues;
    }

    /**
     * Click on the Expand button
     */
    public void clickOnTheExpandButton () {
        expressPoshtaExpand.click();
    }

    /**
     * Convert elements collection to String list
     */
    public ArrayList<String> getExpressList() {
        for (SelenideElement expressListValue : expressListValues) {
            expressListText.add(expressListValue.getText());
        }
        return expressListText;
    }

    /**
     * Convert elements collection to String list
     */
    public ArrayList<String> getSideBarList() {
        for (SelenideElement actualValue : actualValues) {
            actualValuesText.add(actualValue.getText());
        } return actualValuesText;
    }

    /**
     * Click on the "Питання-Відповіді" navigation link
     */
    public void clickOnTheFAQLink() {
        expressListValues.get(1).click();
    }

    /**
     * Get "Питання-Відповіді" page header text
     */
    public String getContactCenterHeaderText () {
        return contactCenterHeader.getText();
    }

    /**
     * Get "Питання-Відповіді" page header
     */
    public SelenideElement getContactCenterHeader () {
        return contactCenterHeader;
    }

    /**
     * Click on the "УкрПошта Стандарт" navigation link
     */
    public void clickOnTheUkrPoshtaStandartLink() {
        ukrPoshtaStandartLink.click();
    }

    /**
     * Get expanded section
     */
    public SelenideElement getExpandedSection () {
        return expandedSection;
    }
}
