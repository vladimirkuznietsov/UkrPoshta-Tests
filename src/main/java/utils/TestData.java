package utils;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class TestData {

    public final String UKR_POSHTA_LINK = "https://ukrposhta.ua/";
    public final String STANDART_CREATE_LINK = "https://ok.ukrposhta.ua/ua/lk/standart";
    public final String POSTAL_INDEX = "49086";
    public final String ADDRESS = "вул. Підгірна, 19.";
    public final String FIND_ADDRESS_PAGE_HEADER = "Знайти адресу";
    public final String CITY_NAME = "Дніпро";
    public final String CONTACT_CENTER_RU = "контакт-центр";
    public final String CONTACT_CENTER_EN = "contact center";
    public final String FIND_POSTAL_INDEX = "Знайти поштовий індекс";
    public final String VALID_PASS = "Qwerty123";
    public final String INVALID_PASS = "Qwerty143";
    public final String VALID_EMAIL = "testemail1@gmail.com";
    public final String INVALID_EMAIL = "kuznietso.qatask@gmail.com";
    public final String CONTACT_CENTER_EXPECTED_HEADER = "Контакт-центр";
    public final String DELETE_BUTTON_NAME = "Видалити";
    public final String CANCEL_BUTTON_NAME = "Скасувати";
    public final String DELETE_MESSAGE = "Ви дійсно бажаєте видалити відправлення?";
    public final String NO_DESPATCHES_MESSAGE = "Увага! Відправлення відсутні. Для початку роботи натисніть кнопку Створити відправлення.";
    public final String URL = "https://api.novaposhta.ua/v2.0/json/";
    public final String PAGE_404_URL = "https://ok.ukrposhta.ua/ua/lk/standartt";
    public final String TEXT_404 = "404!";
    public final String TEXT_ERROR = "На жаль, таку сторінку не знайдено.";

    public SelenideElement cookiesButton = $x("//*[@id=\"masseg_cookie\"]");
}
