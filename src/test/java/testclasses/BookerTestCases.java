package testclasses;

import assertion.Assertions;
import dto.bookerApiRequests.AuthReqeust;
import dto.bookerApiRequests.CreatingBookingRequest;
import dto.bookerApiRequests.PartialUpdateBookingRequest;
import endpoints.BookerEndpoint;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import reporter.annotations.Link.Link;
import util.TestBaseClass;
import util.routes.BookerRoute;

public class BookerTestCases extends TestBaseClass {
    Assertions assertions = new Assertions();
    BookerEndpoint bookerEndpoint = new BookerEndpoint();
    Integer bookingId;
    String token;

    @Link(name = "AUTH", url = "https://restful-booker.herokuapp.com/apidoc/index.html")
    @Link(name = "AUTH2", url = "https://restful-booker.herokuapp.com/apidoc")
    @Test(priority = 1)
    public void Auth_Test() {

        AuthReqeust authReqeust = new AuthReqeust();
        authReqeust.setUsername("admin");
        authReqeust.setPassword("password123");

        Response response = bookerEndpoint.Post(BookerRoute.AUTH, authReqeust);
        token = response.jsonPath().get("token");
        assertions.Status200Assertion(response);
    }

    @Link(name = "GET BOOKING IDS", url = "https://restful-booker.herokuapp.com/apidoc/index.html")
    @Test(priority = 2)
    public void GetBookingIds_Test() {
        Response response = bookerEndpoint.Get(BookerRoute.BOOKING);
        assertions.Status200Assertion(response);
        assertions.NotNullAssertion(response);
    }

    @Link(name = "CREATE BOOKING", url = "https://restful-booker.herokuapp.com/apidoc/index.html")
    @Test(priority = 3)
    public void CreateBooking_Test() {

        CreatingBookingRequest creatingBookingRequest = new CreatingBookingRequest();
        creatingBookingRequest.setFirstname("Jim");
        creatingBookingRequest.setLastname("Brown");
        creatingBookingRequest.setTotalprice(111);
        creatingBookingRequest.setDepositpaid(true);
        creatingBookingRequest.setAdditionalneeds("Breakfast");

        CreatingBookingRequest.Bookingdates bookingdates = new CreatingBookingRequest.Bookingdates();
        bookingdates.setCheckin("2018-01-01");
        bookingdates.setCheckout("2019-01-01");

        creatingBookingRequest.setBookingdates(bookingdates);

        Response response = bookerEndpoint.Post(BookerRoute.BOOKING, creatingBookingRequest);
        bookingId = response.jsonPath().get("bookingid");
        assertions.Status200Assertion(response);
        assertions.NotNullAssertion(response);
    }

    @Link(name = "GET BOOKING", url = "https://restful-booker.herokuapp.com/apidoc/index.html")
    @Test(priority = 4)
    public void GetBooking_Test() {

        Response response = bookerEndpoint.Get(BookerRoute.BOOKING + bookingId);
        assertions.Status200Assertion(response);
        assertions.NotNullAssertion(response);
    }

    @Link(name = "UPDATE BOOKING", url = "https://restful-booker.herokuapp.com/apidoc/index.html")
    @Test(priority = 5)
    public void UpdateBooking_Test() {

        CreatingBookingRequest UpdateBookingRequest = new CreatingBookingRequest();
        UpdateBookingRequest.setFirstname("James");
        UpdateBookingRequest.setLastname("Green");
        UpdateBookingRequest.setTotalprice(111);
        UpdateBookingRequest.setDepositpaid(true);
        UpdateBookingRequest.setAdditionalneeds("Lunch");

        CreatingBookingRequest.Bookingdates bookingdates = new CreatingBookingRequest.Bookingdates();
        bookingdates.setCheckin("2018-01-01");
        bookingdates.setCheckout("2019-01-01");

        UpdateBookingRequest.setBookingdates(bookingdates);


        Response response = bookerEndpoint.Put(BookerRoute.BOOKING + bookingId, UpdateBookingRequest, token);
        assertions.Status200Assertion(response);
        assertions.NotNullAssertion(response);
    }

    @Link(name = "PARTIAL UPDATE BOOKING", url = "https://restful-booker.herokuapp.com/apidoc/index.html")
    @Test(priority = 6)
    public void PartialUpdateBooking_Test() {

        PartialUpdateBookingRequest partialUpdateBookingRequest = new PartialUpdateBookingRequest();
        partialUpdateBookingRequest.setFirstname("James");
        partialUpdateBookingRequest.setLastname("Green");

        Response response = bookerEndpoint.Patch(BookerRoute.BOOKING + bookingId, partialUpdateBookingRequest, token );
        assertions.Status200Assertion(response);
        assertions.NotNullAssertion(response);
    }

    @Link(name = "DELETE BOOKING", url = "https://restful-booker.herokuapp.com/apidoc/index.html")
    @Test(priority = 7)
    public void DeleteBooking_Test() {

        Response response = bookerEndpoint.Delete(BookerRoute.BOOKING + bookingId, token);
        assertions.Status201Assertion(response);
        assertions.CreatedAssertion(response);
    }

    @Test(priority = 8)
    public void HealthCheck_Test() {

        Response response = bookerEndpoint.Get(BookerRoute.PING);
        assertions.Status201Assertion(response);
    }
}