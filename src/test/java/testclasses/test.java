package testclasses;

import endpoints.EndPoints;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import java.util.HashMap;

public class test {
    EndPoints endPoints = new EndPoints();
    Response response;

    @Test
    public void Auth_test() {

         HashMap<String, String> payload = new HashMap();
         payload.put("username", "admin");
         payload.put("password", "password123");
         endPoints.Auth("auth", payload);

    }

}

