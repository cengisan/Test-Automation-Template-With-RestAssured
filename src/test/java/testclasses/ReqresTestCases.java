package testclasses;

import assertion.Assertions;
import endpoints.ReqresEndpoint;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import reporter.annotations.Link.Link;
import util.TestBaseClass;
import util.routes.ReqresRoute;

import java.util.HashMap;

public class ReqresTestCases extends TestBaseClass {
    Assertions assertions = new Assertions();
    ReqresEndpoint reqresEndpoint = new ReqresEndpoint();
    String id;

    @Link(name = "REGISTER SUCCESS",url = "https://reqres.in/")
    @Test(priority = 1)
    public void Register_Success_Test() {
        HashMap<String, String> payload = new HashMap<>();
        payload.put("email", "eve.holt@reqres.in");
        payload.put("password", "pistol");
        Response response = reqresEndpoint.Post(ReqresRoute.REGISTER, payload);
        assertions.Status200Assertion(response);
    }

    @Link(name = "REGISTER UNSUCCESS",url = "https://reqres.in/")
    @Test(priority = 2)
    public void Register_Unsuccess_Test() {
        HashMap<String, String> payload = new HashMap<>();
        payload.put("email", "eve.holt@reqres.in");
        Response response = reqresEndpoint.Post(ReqresRoute.REGISTER, payload);
        assertions.Status400Assertion(response);
    }
    @Link(name = "LOGIN SUCCESS",url = "https://reqres.in/")
    @Test(priority = 3)
    public void Login_Success_Test() {
        HashMap<String, String> payload = new HashMap<>();
        payload.put("email", "eve.holt@reqres.in");
        payload.put("password", "cityslicka");
        Response response = reqresEndpoint.Post(ReqresRoute.LOGIN, payload);
        assertions.Status200Assertion(response);
    }
    @Link(name = "LOGIN UNSUCCESS",url = "https://reqres.in/")
    @Test(priority = 4)
    public void Login_Unsuccess_Test() {
        HashMap<String, String> payload = new HashMap<>();
        payload.put("email", "peter@klaven");
        Response response = reqresEndpoint.Post(ReqresRoute.LOGIN, payload);
        assertions.Status400Assertion(response);
    }
    @Link(name = "LIST USERS",url = "https://reqres.in/")
    @Test(priority = 5)
    public void List_Users_Test() {
        Response response = reqresEndpoint.Get(ReqresRoute.USERS, "page", 2);
        assertions.Status200Assertion(response);
        assertions.NotNullAssertion(response);
    }
    @Link(name = "SINGLE USER",url = "https://reqres.in/")
    @Test(priority = 6)
    public void Single_User_Test() {
        Response response = reqresEndpoint.Get(ReqresRoute.LOGIN + "2");
        assertions.Status200Assertion(response);
        assertions.NotNullAssertion(response);
    }
    @Link(name = "SINGLE USER NOT FOUND",url = "https://reqres.in/")
    @Test(priority = 7)
    public void Single_User_Not_Found_Test() {
        Response response = reqresEndpoint.Get(ReqresRoute.USERS + "23");
        assertions.Status404Assertion(response);
    }
    @Link(name = "LIST RESOURCE",url = "https://reqres.in/")
    @Test(priority = 8)
    public void List_Resource_Test() {
        Response response = reqresEndpoint.Get(ReqresRoute.UNKNOWN);
        assertions.Status200Assertion(response);
        assertions.NotNullAssertion(response);
    }
    @Link(name = "SINGLE RESOURCE",url = "https://reqres.in/")
    @Test(priority = 9)
    public void Single_Resource_Test() {
        Response response = reqresEndpoint.Get(ReqresRoute.UNKNOWN + "2");
        assertions.Status200Assertion(response);
        assertions.NotNullAssertion(response);
    }

    @Link(name = "SINGLE RESOURCE NOT FOUND",url = "https://reqres.in/")
    @Test(priority = 10)
    public void Single_Resource_Not_Found_Test() {
        Response response = reqresEndpoint.Get(ReqresRoute.UNKNOWN + "2");
        assertions.Status404Assertion(response);
    }

    @Link(name = "CREATE",url = "https://reqres.in/")
    @Test(priority = 11)
    public void Create_Test() {
        HashMap<String, String> payload = new HashMap<>();
        payload.put("name", "morpheus");
        payload.put("job", "leader");
        Response response = reqresEndpoint.Post(ReqresRoute.USERS, payload);
        id = response.jsonPath().get("id");
        assertions.Status201Assertion(response);
        assertions.NotNullAssertion(response);
    }

    @Link(name = "UPDATE",url = "https://reqres.in/")
    @Test(priority = 12)
    public void Update_Test() {
        HashMap<String, String> payload = new HashMap<>();
        payload.put("name", "morpheus");
        payload.put("job", "zion resident");
        Response response = reqresEndpoint.Put(ReqresRoute.USERS + id, payload);
        assertions.Status200Assertion(response);
        assertions.NotNullAssertion(response);
    }

    @Link(name = "PATCH",url = "https://reqres.in/")
    @Test(priority = 13)
    public void Patch_Test() {
        HashMap<String, String> payload = new HashMap<>();
        payload.put("name", "morpheus");
        payload.put("job", "zion resident");
        Response response = reqresEndpoint.Patch(ReqresRoute.USERS + id, payload);
        assertions.Status200Assertion(response);
        assertions.NotNullAssertion(response);
    }

    @Link(name = "DELETE",url = "https://reqres.in/")
    @Test(priority = 14)
    public void Delete_Test() {
        Response response = reqresEndpoint.Delete(ReqresRoute.USERS + id);
        assertions.Status204Assertion(response);
    }

    @Link(name = "DELAY",url = "https://reqres.in/")
    @Test(priority = 15)
    public void Delay_Test() {
        Response response = reqresEndpoint.Get(ReqresRoute.USERS, "delay", 3);
        assertions.Status200Assertion(response);
    }
}
