package training.weather.clients;

import static org.junit.Assert.assertNotNull;
import org.junit.Assert;
import org.junit.Test;

public class RequestClientTest {

    @Test
    public void GetTest() {
        try {
            RequestClient client = new RequestClient();
            assertNotNull(client.Get("https://fakerapi.it/api/v1/places?_quantity=1"));
        }catch (Exception ex){
            Assert.fail();
        }
    }

}

