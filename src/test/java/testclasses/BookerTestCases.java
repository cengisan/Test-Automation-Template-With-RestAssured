package testclasses;

import assertion.Assertions;
import endpoints.Endpoints;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.util.HashMap;

public class BookerTestCases implements Endpoints {
    Assertions assertions = new Assertions();
    Integer bookingId;
    String token;

    @Test(priority = 1)
    public void Auth_test() {

        HashMap<String, String> payload = new HashMap();
        payload.put("username", "admin");
        payload.put("password", "password123");

        Response response = bookerPost("auth", payload);
        token = response.jsonPath().get("token");
        assertions.Status200Assertion(response);
    }

    @Test(priority = 2)
    public void GetBookingIds_Test() {
        Response response = bookerGet("booking");
        assertions.Status200Assertion(response);
        assertions.NotNullAssertion(response);
    }

    @Test(priority = 3)
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

        Response response = bookerPost("booking", payload);
        bookingId = response.jsonPath().get("bookingid");
        assertions.Status200Assertion(response);
        assertions.NotNullAssertion(response);
    }
    @Test(priority = 4)
    public void GetBooking_Test() {

        Response response = bookerGet("booking/" + bookingId);
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

        Response response = bookerPut("booking/" + bookingId, payload, token);
        assertions.Status200Assertion(response);
        assertions.NotNullAssertion(response);
    }

    @Test(priority = 6)
    public void PartialUpdateBooking_Test() {

        HashMap<String, Object> payload = new HashMap();
        payload.put("firstname", "James");
        payload.put("lastname", "Brown");

        Response response = bookerPatch("booking/" + bookingId, payload, token);
        assertions.Status200Assertion(response);
        assertions.NotNullAssertion(response);
    }

    @Test(priority = 7)
    public void DeleteBooking_Test() {

        Response response = bookerDelete("booking/" + bookingId, token);
        assertions.Status201Assertion(response);
        assertions.CreatedAssertion(response);
    }

    @Test(priority = 8)
    public void HealthCheck_Test() {

        Response response = bookerGet("ping");
        assertions.Status201Assertion(response);
    }
}