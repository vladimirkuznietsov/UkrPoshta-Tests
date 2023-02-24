package ua.ukrposhta.Pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import utils.TestData;

import java.util.ArrayList;

import static com.codeborne.selenide.Selenide.*;

public class UkrPoshtaStandartPage extends TestData {

    private final ElementsCollection receiverInputFields = $$(By.xpath("//input[@id=\"last-name\" or @id=\"first-name\" or @id=\"patronymic\" or @id=\"phone\"]"));
    private final ElementsCollection receiverAddressDropdownValues = $$(By.xpath("//option[@label=\"Вінницька\" or @label=\"Вінницький\" or @label=\"Агрономічне\"]"));
    private final ElementsCollection receiverAddressDropdowns = $$(By.xpath("//select[@id=\"region\" or @id=\"district\" or @id=\"city\"]"));
    private final ElementsCollection deliveryMethodDropdownList = $$(By.xpath("//option[@data-ng-repeat=\"(key,type) in deliveryTypes\"]"));

    private final SelenideElement standartCreateBtn = $("#standardCreate");
    private final SelenideElement streetInput = $("#street");
    private final SelenideElement houseInput = $("#house");
    private final SelenideElement weightInput = $("#weight");
    private final SelenideElement lengthInput = $("#length");
    private final SelenideElement submitButton = $("#submit-button");
    private final SelenideElement deliveryMethodDropdown = $("#delivery-method");
    private final SelenideElement deliveryMethodOption = $x("//option[@value=\"W2W\"]");

    private final SelenideElement despatchCard = $x("//div[@class=\"tab-content\"]");
    private final SelenideElement despatchMoreInfoButton = $x("//button[@title=\"Більше інформації\"]");
    private final SelenideElement despatchMoreInfoReceiverName = $x("//div[@class=\"tab-content\"]/div[1]/div[2]/div/div/div[2]/table/tbody/tr[3]/td");
    private final SelenideElement despatchMoreInfoReceiverPhone = $x("//div[@class=\"tab-content\"]/div[1]/div[2]/div/div/div[2]/table/tbody/tr[4]/td");
    private final SelenideElement modifyButton = $x("//button[@id=\" standardChange\"]");
    private final SelenideElement phoneInputModifyPage = $("#phone");
    private final SelenideElement deleteDespatchButton = $("#standardRemove");
    private final SelenideElement deleteMessageBox = $x("//div[@class=\"modal-footer\"]/div[3]");
    private final SelenideElement deleteMessage = $x("//div[@class=\"modal-footer\"]/div[3]/h4");
    private final SelenideElement deleteButton = $x("//div[@class=\"modal-footer\"]/div[3]/div[1]/button[1]");
    private final SelenideElement cancelButton = $x("//div[@class=\"modal-footer\"]/div[3]/div[1]/button[2]");
    private final SelenideElement noDespatchesMessageBox = $x("//div[@class=\"alert alert-danger ng-scope\"]");
    private final SelenideElement stopSessionButton = $x("//a[@class=\"your-account\"]");

    /**
     * Click on the "Створити" button
     */
    public void clickOnTheStandartCreateBtn() {
        standartCreateBtn.click();
    }

    /**
     * Click on the "Завершити Сеанс" button
     */
    public void clickOnTheStopSessionButton () {
        stopSessionButton.click();
    }

    /**
     * Add first set of data to the list
     */
    public ArrayList<String> setReceiverData () {
        ArrayList<String> data = new ArrayList<>();
        data.add("Іванов");
        data.add("Іван");
        data.add("Іванович");
        data.add("+380960121385");
        return data;
    }

    /**
     * Add all delivery methods to the list
     */
    public ArrayList<String> deliveryMethods () {
        ArrayList<String> values = new ArrayList<>();
        values.add("склад – склад");
        values.add("двері – двері");
        values.add("склад – двері");
        values.add("двері – склад");
        return values;
    }

    /**
     * Fill the receiver section inputs with proper data
     */
    public void fillReceiverSection () {
        for(int i = 0; i < receiverInputFields.size(); i++){
            receiverInputFields.get(i).sendKeys(setReceiverData().get(i));
        }
    }

    /**
     * Click on the "Спосіб доставки" dropdown
     */
    public void clickOnTheDeliveryDropdown () {
        deliveryMethodDropdown.click();
    }

    /**
     * Fill the receiver address section dropdowns with proper data
     */
    public void fillReceiverAddressDropdowns () {
        for(int i = 0; i < receiverAddressDropdowns.size(); i++){
            receiverAddressDropdowns.get(i).click();
            receiverAddressDropdownValues.get(i).click();
        }
    }

    /**
     * Click on the "Створити" button
     */
    public void clickOnSubmitButton () {
        submitButton.click();
    }

    /**
     * Get the despatch card block
     */
    public SelenideElement getDespatchCard() {
        return despatchCard;
    }

    /**
     * Click on the "Більше інформації" button
     */
    public void clickOnTheMoreInfoButton () {
        despatchMoreInfoButton.click();
    }

    /**
     * Verify that the receiver's name used on despatch creation is displayed in the despatch
     */
    public boolean isReceiverNameProper () {
        return despatchMoreInfoReceiverName.getText().equals("Іванов Іван Іванович");
    }

    /**
     * Click on the "Редагувати" button
     */
    public void clickOnModifyButton () {
        modifyButton.click();
    }

    /**
     * Remove data from the "Телефон" input
     */
    public void clearPhoneInput () {
        phoneInputModifyPage.clear();
    }

    /**
     * Fill the "Телефон" input with the new data
     */
    public void fillPhoneInput () {
        phoneInputModifyPage.sendKeys("+380970121385");
    }

    /**
     * Verify that the new phone number is displayed in the despatch
     */
    public boolean isNumberProper () {
        return despatchMoreInfoReceiverPhone.getText().equals("+380970121385");
    }

    /**
     * Click on the "Видалити" button
     */
    public void clickOnTheDeleteDespatchButton () {
        deleteDespatchButton.click();
    }

    /**
     * Get the delete message block
     */
    public SelenideElement getDeleteMessageBox () {
        return deleteMessageBox;
    }

    /**
     * Verify that the "Confirm Delete" box contains valid message and buttons
     */
    public boolean isConfirmDeleteBoxProper () {
        return (deleteMessage.getText().equals(DELETE_MESSAGE) ||
                deleteButton.getText().equals(DELETE_BUTTON_NAME) ||
                    cancelButton.getText().equals(CANCEL_BUTTON_NAME));
    }

    /**
     * Click on the "Видалити" button
     */
    public void clickOnDeleteButton () {
        deleteButton.click();
    }

    /**
     * Verify that the despatch is deleted
     */
    public boolean isDespatchDeleted() {
        return noDespatchesMessageBox.getText().equals(NO_DESPATCHES_MESSAGE);
    }

    /**
     * Verify that the "Спосіб доставки" dropdown-list values are proper
     */
    public boolean isDeliveryOptionsProper() {
        boolean verify = true;
        for (SelenideElement selenideElement : deliveryMethodDropdownList) {

            for (String text : deliveryMethods()) {
                if (!selenideElement.getText().equals(text)) {
                    verify = false;
                } return verify;
            }
        }
        return verify;
    }

    /**
     * Get first input from the receiver section
     */
    public SelenideElement getFirstReceiverInputField () {
        return receiverInputFields.get(0);
    }

    /**
     * Get "Створити" button
     */
    public SelenideElement getSubmitButton () {
        return submitButton;
    }

    /**
     * Get receiver name from the despatch
     */
    public SelenideElement getDespatchMoreInfoReceiverName () {
        return despatchMoreInfoReceiverName;
    }

    /**
     * Get the phone input on the modify page
     */
    public SelenideElement getPhoneInputModifyPage () {
        return phoneInputModifyPage;
    }

    /**
     * Get "Видалити" button
     */
    public SelenideElement getDeleteDespatchButton () {
        return deleteDespatchButton;
    }

    /**
     * Get first value from the "Спосіб доставки" dropdown-list
     */
    public SelenideElement getDeliveryMethodDropdownList () {
        return deliveryMethodDropdownList.get(0);
    }

    /**
     * Get "Більше інформації" button
     */
    public SelenideElement getDespatchMoreInfoButton () {
        return despatchMoreInfoButton;
    }

    /**
     * Get "Створити" button
     */
    public SelenideElement getStandartCreateBtn () {
        return standartCreateBtn;
     }

    /**
     * Fill all mandatory fields with proper data
     */
     public void fillMandatoryFields () {
        fillReceiverSection();
        deliveryMethodDropdown.click();
        deliveryMethodOption.click();
        fillReceiverAddressDropdowns();
        streetInput.sendKeys("вул. Будівельників");
        houseInput.sendKeys("1");
        weightInput.sendKeys("1000");
        lengthInput.sendKeys("15");
     }
}

