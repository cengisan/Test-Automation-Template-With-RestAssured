package assertion;

import io.restassured.response.Response;
import org.testng.Assert;

public class Assertions {
    public void Status200Assertion(Response response) {
        Assert.assertEquals(response.statusCode(), 200);
    }

    public void Status201Assertion(Response response) {
        Assert.assertEquals(response.statusCode(), 201);
    }

    public void NotNullAssertion(Response response) {
        Assert.assertNotNull(response.jsonPath().get());
    }

    public void CreatedAssertion(Response response) {
        Assert.assertEquals(response.getBody(),"Created");
    }

}
