import utils.ApiConstants;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class ApiTest {

    private String contactRef;

    @Test (priority = 1)
    public void createContactPerson () throws IOException {
        ApiConstants constants = new ApiConstants();

        HttpPost createContactPerson = new HttpPost(constants.getURL());
        HttpEntity body = new StringEntity(String.valueOf(constants.getContactPersonDataInitial()), "utf-8");
        createContactPerson.setEntity(body);
        HttpResponse response = HttpClientBuilder.create().build().execute(createContactPerson);
        HttpEntity entity = response.getEntity();
        String value = EntityUtils.toString(entity);
        contactRef = value.substring(32,68);
        Assert.assertEquals(value.substring(11,15), "true");
    }

    @Test (priority = 2)
    public void updateContactPerson () throws IOException {
        ApiConstants constants = new ApiConstants();

        HttpPost updateContactPerson = new HttpPost(constants.getURL());
        HttpEntity body = new StringEntity(String.valueOf(constants.getContactPersonDataUpdate(contactRef)), "utf-8");
        updateContactPerson.setEntity(body);
        HttpResponse response = HttpClientBuilder.create().build().execute(updateContactPerson);
        HttpEntity entity = response.getEntity();
        String value = EntityUtils.toString(entity);
        Assert.assertEquals(value.substring(11,15), "true");
    }

    @Test (priority = 3)
    public void deleteContactPerson () throws IOException {
        ApiConstants constants = new ApiConstants();

        HttpPost deleteContactPerson = new HttpPost(constants.getURL());
        HttpEntity body = new StringEntity(String.valueOf(constants.getContactPersonDataDelete(contactRef)), "utf-8");
        deleteContactPerson.setEntity(body);
        HttpResponse response = HttpClientBuilder.create().build().execute(deleteContactPerson);
        HttpEntity entity = response.getEntity();
        String value = EntityUtils.toString(entity);
        Assert.assertEquals(value.substring(11,15), "true");
    }
}
