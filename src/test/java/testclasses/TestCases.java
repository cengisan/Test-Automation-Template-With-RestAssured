package testclasses;

import assertion.Assertions;
import endpoints.BookerEndPoints;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.util.HashMap;

public class TestCases implements BookerEndPoints {
    Assertions assertions = new Assertions();
    Integer bookingId;
    String token;

    @Test(priority = 1)
    public void Auth_test() {

        HashMap<String, String> payload = new HashMap();
        payload.put("username", "admin");
        payload.put("password", "password123");

        Response response = post("auth", payload);
        token = response.jsonPath().get("token");
        assertions.Status200Assertion(response);
    }

    @Test(priority = 2)
    public void GetBookingIds_Test() {
        Response response = get("booking");
        assertions.Status200Assertion(response);
        assertions.NotNullAssertion(response);
    }

    @Test(priority = 3)
    public void GetBooking_Test() {

        Response response = get("booking/11962");
        assertions.Status200Assertion(response);
        assertions.NotNullAssertion(response);
    }

    @Test(priority = 4)
    public void CreateBooking_Test() {
        HashMap<String, String> bookingdates = new HashMap<>();
        bookingdates.put("checkin", "2018-01-01");
        bookingdates.put("checkout", "2019-01-01");

        HashMap<String, Object> payload = new HashMap();
        payload.put("firstname", "Jim");
        payload.put("lastname", "Brown");
        payload.put("totalprice", 111);
        payload.put("depositpaid", true);
        payload.put("bookingdates", bookingdates);
        payload.put("additionalneeds", "Breakfast");

        Response response = post("booking", payload);
        bookingId = response.jsonPath().get("bookingid");
        assertions.Status200Assertion(response);
        assertions.NotNullAssertion(response);
    }

    @Test(priority = 5)
    public void UpdateBooking_Test() {
        HashMap<String, String> bookingdates = new HashMap<>();
        bookingdates.put("checkin", "2018-01-01");
        bookingdates.put("checkout", "2019-01-01");

        HashMap<String, Object> payload = new HashMap();
        payload.put("firstname", "James");
        payload.put("lastname", "Green");
        payload.put("totalprice", 111);
        payload.put("depositpaid", true);
        payload.put("bookingdates", bookingdates);
        payload.put("additionalneeds", "Breakfast");

        Response response = put("booking/" + bookingId, payload, token);
        assertions.Status200Assertion(response);
        assertions.NotNullAssertion(response);
    }

    @Test(priority = 6)
    public void PartialUpdateBooking_Test() {

        HashMap<String, Object> payload = new HashMap();
        payload.put("firstname", "James");
        payload.put("lastname", "Brown");

        Response response = patch("booking/" + bookingId, payload, token);
        assertions.Status200Assertion(response);
        assertions.NotNullAssertion(response);
    }

    @Test(priority = 7)
    public void DeleteBooking_Test() {

        Response response = delete("booking/" + bookingId, token);
        assertions.Status201Assertion(response);
        assertions.CreatedAssertion(response);
    }

    @Test(priority = 8)
    public void HealthCheck_Test() {

        Response response = get("ping");
        assertions.Status201Assertion(response);
    }
}