package utils;

import org.json.JSONObject;

public class ApiConstants extends TestData {

    /**
     * Get full url for requests
     */
    public String getURL () {
        return URL;
    }

    /**
     * Initial counterparty JSON
     */
    public JSONObject getCounterpartyDataInitial () {

        JSONObject userData = new JSONObject();
        userData.put("apiKey", "637d5af3866f332ced48448e4a2c22e8");
        userData.put("modelName", "Counterparty");
        userData.put("calledMethod", "save");

        JSONObject propertiesData = new JSONObject();
        propertiesData.put("FirstName", "Іван");
        propertiesData.put("MiddleName", "Іванович");
        propertiesData.put("LastName", "Іванов");
        propertiesData.put("Phone", "+380970191682");
        propertiesData.put("Email", "test@i.com");
        propertiesData.put("CounterpartyType", "PrivatePerson");
        propertiesData.put("CounterpartyProperty", "Recipient");

        userData.put("methodProperties", propertiesData);
        return userData;
    }

    /**
     * JSON file to create contact person
     */
    public JSONObject getContactPersonDataInitial () {

        JSONObject userData = new JSONObject();
        userData.put("apiKey", "637d5af3866f332ced48448e4a2c22e8");
        userData.put("modelName", "ContactPerson");
        userData.put("calledMethod", "save");

        JSONObject propertiesData = new JSONObject();
        propertiesData.put("CounterpartyRef","c983247e-36b7-11ed-a60f-48df37b921db" );
        propertiesData.put("FirstName", "Іван");

        propertiesData.put("LastName", "Іванов");
        propertiesData.put("MiddleName", "Іванович");
        propertiesData.put("Phone", "+380970191683");

        userData.put("methodProperties", propertiesData);
        return userData;
    }

    /**
     * JSON file to update contact person
     */
    public JSONObject getContactPersonDataUpdate (String ref) {

        JSONObject userData = new JSONObject();
        userData.put("apiKey", "637d5af3866f332ced48448e4a2c22e8");
        userData.put("modelName", "ContactPerson");
        userData.put("calledMethod", "update");

        JSONObject propertiesData = new JSONObject();
        propertiesData.put("CounterpartyRef","c983247e-36b7-11ed-a60f-48df37b921db" );
        propertiesData.put("Ref",ref );
        propertiesData.put("FirstName", "Іван");

        propertiesData.put("LastName", "Петров");
        propertiesData.put("MiddleName", "Іванович");
        propertiesData.put("Phone", "+380970191683");

        userData.put("methodProperties", propertiesData);
        return userData;
    }

    /**
     * JSON file to delete contact person
     */
    public JSONObject getContactPersonDataDelete (String ref2) {

        JSONObject userData = new JSONObject();
        userData.put("apiKey", "637d5af3866f332ced48448e4a2c22e8");
        userData.put("modelName", "ContactPerson");
        userData.put("calledMethod", "delete");

        JSONObject propertiesData = new JSONObject();
        propertiesData.put("Ref",ref2 );

        userData.put("methodProperties", propertiesData);
        return userData;
    }
}
