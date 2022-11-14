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
    public void Status204Assertion(Response response) {
        Assert.assertEquals(response.statusCode(), 204);
    }
    public void Status400Assertion(Response response) {
        Assert.assertEquals(response.statusCode(), 400);
    }
    public void Status404Assertion(Response response) {
        Assert.assertEquals(response.statusCode(), 404);
    }

    public void NotNullAssertion(Response response) {
        Assert.assertNotNull(response.jsonPath().get());
    }

    public void CreatedAssertion(Response response) {
        Assert.assertEquals(response.getBody().prettyPrint(),"Created");
    }

}
