package ua.ukrposhta.Pages;

import com.codeborne.selenide.SelenideElement;
import utils.TestData;

import static com.codeborne.selenide.Selenide.$x;

public class LogInPage extends TestData {

    private final SelenideElement personalAccountHeader = $x("//div[@class=\"well well-md\"]/h3");
    private final SelenideElement logInButton = $x("//a[@rel=\"login-form\"]");
    private final SelenideElement authorizationHeader = $x("//div[@class=\"well well-lg\"]/h3");
    private final SelenideElement emailInputField = $x("//input[@name=\"login-user\"]");
    private final SelenideElement passwordField = $x("//input[@name=\"pass-user\"]");
    private final SelenideElement enterButton = $x("//input[@type=\"submit\"]");
    private final SelenideElement stopSessionButton = $x("//a[@class=\"your-account\"]");
    private final SelenideElement errorMessageOnLogin = $x("//div[@class=\"text-center alert alert-danger\"]");

    /**
     * Get "Завершити Сеанс" button
     */
    public SelenideElement getStopSessionButton () {
        return stopSessionButton;
    }

    /**
     * Get header of the "Особистий кабінет" page
     */
    public  SelenideElement getPersonalAccountHeader() {
        return personalAccountHeader;
    }

    /**
     * Get error message box on the "Авторизація" page
     */
    public SelenideElement getErrorMessageOnLogin () {
        return errorMessageOnLogin;
    }

    /**
     * Get header of the "Авторизація" page
     */
    public SelenideElement getAuthorizationHeader () {
        return authorizationHeader;
    }

    /**
     * Click on the "Увійти" button
     */
    public void clickOnTheLogInButton () {
        logInButton.click();
    }

    /**
     * Verify Authorization block header
     */
    public boolean isAuthorizationSectionOpened() {
        return authorizationHeader.
                getText().
                equals("Авторизація");
    }

    /**
     * Verify "Wrong password" message
     */
    public boolean isVerifyErrorMessagePass() {
        return errorMessageOnLogin.
                getText().
                equals("Пароль недійсний або користувач не має пароля.");
    }

    /**
     * Verify "Wrong E-mail" message
     */
    public boolean isVerifyErrorMessageMail() {
        return errorMessageOnLogin.
                getText().
                equals("Немає запису користувача, що відповідає цьому ідентифікатору. Користувач може бути видалено.");
    }

    /**
     * Click on the "Зайти" button
     */
    public void clickOnTheEnterButton () {
        enterButton.click();
    }

    /**
     * Verify that the user is logged in
     */
    public boolean isVerifyLogIn() {
        return stopSessionButton.
                getText().
                equals("ЗАВЕРШИТИ СЕАНС");
    }

    /**
     * Log in with valid credentials
     */
    public void logInWithValidCreds() {
        emailInputField.sendKeys(VALID_EMAIL);
        passwordField.sendKeys(VALID_PASS);
        enterButton.click();
    }

    /**
     * Log in with invalid credentials
     */
    public void logInWithInvalidCreds(String type) {
        if(type.equalsIgnoreCase("Email")){
            emailInputField.sendKeys(INVALID_EMAIL);
            passwordField.sendKeys(VALID_PASS);
            enterButton.click();
        } else if (type.equalsIgnoreCase("Password")) {
            emailInputField.sendKeys(VALID_EMAIL);
            passwordField.sendKeys(INVALID_PASS);
            enterButton.click();
        }
    }
}
