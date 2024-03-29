package endpoints;

import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import reporter.ExtentReporterListener;
import specifications.Specifications;


import static io.restassured.RestAssured.given;
import static util.TestBaseClass.captor;
import static util.TestBaseClass.writer;

public class BookerEndpoint {

    public Response Post(String path, Object payload) {

        ExtentReporterListener extentReporterListener = new ExtentReporterListener();
        Specifications specifications = new Specifications();

        Response response = given(specifications.BookerRequestSpec())
                .filter(new RequestLoggingFilter(captor))
                .contentType(ContentType.JSON)
                .when()
                .body(payload)
                .post(path)
                .then().spec(specifications.BookerResponseSpec())
                .extract()
                .response();

        extentReporterListener.requestAndResponseReporter(writer.toString(), response.prettyPrint());
        return response;
    }
    public Response Get(String path) {

        ExtentReporterListener extentReporterListener = new ExtentReporterListener();
        Specifications specifications = new Specifications();
        Response response = given(specifications.BookerRequestSpec())
                .filter(new RequestLoggingFilter(captor))
                .contentType(ContentType.JSON)
                .when()
                .get(path)
                .then().spec(specifications.BookerResponseSpec())
                .extract()
                .response();

        extentReporterListener.requestAndResponseReporter(writer.toString(), response.prettyPrint());
        return response;
    }

    public Response Put(String path, Object payload, String token) {

        ExtentReporterListener extentReporterListener = new ExtentReporterListener();
        Specifications specifications = new Specifications();

        Response response = given(specifications.BookerRequestSpec())
                .filter(new RequestLoggingFilter(captor))
                .contentType(ContentType.JSON)
                .header("Cookie","token="+token)
                .when()
                .body(payload)
                .put(path)
                .then().spec(specifications.BookerResponseSpec())
                .extract()
                .response();

        extentReporterListener.requestAndResponseReporter(writer.toString(), response.prettyPrint());
        return response;
    }
    public Response Patch(String path, Object payload, String token) {

        ExtentReporterListener extentReporterListener = new ExtentReporterListener();
        Specifications specifications = new Specifications();

        Response response = given(specifications.BookerRequestSpec())
                .filter(new RequestLoggingFilter(captor))
                .contentType(ContentType.JSON)
                .header("Cookie","token="+token)
                .when()
                .body(payload)
                .patch(path)
                .then().spec(specifications.BookerResponseSpec())
                .extract()
                .response();

        extentReporterListener.requestAndResponseReporter(writer.toString(), response.prettyPrint());
        return response;
    }
    public Response Delete(String path,String token) {

        ExtentReporterListener extentReporterListener = new ExtentReporterListener();
        Specifications specifications = new Specifications();

        Response response = given(specifications.BookerRequestSpec())
                .filter(new RequestLoggingFilter(captor))
                .contentType(ContentType.JSON)
                .header("Cookie","token="+token)
                .when()
                .delete(path)
                .then().spec(specifications.BookerResponseSpec())
                .extract()
                .response();

        extentReporterListener.requestAndResponseReporter(writer.toString(), response.prettyPrint());
        return response;
    }
}
