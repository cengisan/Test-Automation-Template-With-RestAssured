package testclasses;

import endpoints.EndPoints;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.util.HashMap;

public class test {
    EndPoints endPoints = new EndPoints();
    @Test
    public void Auth_test() {

         HashMap<String, String> payload = new HashMap();
         payload.put("username", "admin");
         payload.put("password", "password123");
         Response response = endPoints.Auth("auth", payload);
         Assert.assertEquals(response.statusCode(),200);
    }
}