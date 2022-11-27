package endpoints;

import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import reports.ExtentReporterListener;
import specifications.Specifications;

import java.io.PrintStream;
import java.io.StringWriter;
import java.io.Writer;
import java.util.HashMap;

import static io.restassured.RestAssured.*;

public interface BookerEndPoints {


    default Response bookerPost(String path, HashMap payload) {

        ExtentReporterListener detail = new ExtentReporterListener();
        Specifications specifications = new Specifications();

        Response response = given(specifications.BookerRequestSpec())
                .filter(new RequestLoggingFilter(detail.captor))
                .contentType(ContentType.JSON)
                .when()
                .body(payload)
                .post(path)
                .then().spec(specifications.BookerResponseSpec())
                .extract()
                .response();

        detail.requestAndResponseReporter(detail.writer.toString(), response.prettyPrint());
        return response;
    }
    default Response bookerGet(String path) {

        ExtentReporterListener detail = new ExtentReporterListener();
        Specifications specifications = new Specifications();
        Response response = given(specifications.BookerRequestSpec())
                .filter(new RequestLoggingFilter(detail.captor))
                .contentType(ContentType.JSON)
                .when()
                .get(path)
                .then().spec(specifications.BookerResponseSpec())
                .extract()
                .response();

        detail.requestAndResponseReporter(detail.writer.toString(), response.prettyPrint());
        return response;
    }

    default Response bookerPut(String path, HashMap payload, String token) {

        ExtentReporterListener detail = new ExtentReporterListener();
        Specifications specifications = new Specifications();

        Response response = given(specifications.BookerRequestSpec())
                .filter(new RequestLoggingFilter(detail.captor))
                .contentType(ContentType.JSON)
                .header("Cookie","token="+token)
                .when()
                .body(payload)
                .put(path)
                .then().spec(specifications.BookerResponseSpec())
                .extract()
                .response();

        detail.requestAndResponseReporter(detail.writer.toString(), response.prettyPrint());
        return response;
    }
    default Response bookerPatch(String path, HashMap payload, String token) {

        ExtentReporterListener detail = new ExtentReporterListener();
        Specifications specifications = new Specifications();

        Response response = given(specifications.BookerRequestSpec())
                .filter(new RequestLoggingFilter(detail.captor))
                .contentType(ContentType.JSON)
                .header("Cookie","token="+token)
                .when()
                .body(payload)
                .patch(path)
                .then().spec(specifications.BookerResponseSpec())
                .extract()
                .response();

        detail.requestAndResponseReporter(detail.writer.toString(), response.prettyPrint());
        return response;
    }
    default Response bookerDelete(String path,String token) {

        ExtentReporterListener detail = new ExtentReporterListener();
        Specifications specifications = new Specifications();

        Response response = given(specifications.BookerRequestSpec())
                .filter(new RequestLoggingFilter(detail.captor))
                .contentType(ContentType.JSON)
                .header("Cookie","token="+token)
                .when()
                .delete(path)
                .then().spec(specifications.BookerResponseSpec())
                .extract()
                .response();

        detail.requestAndResponseReporter(detail.writer.toString(), response.prettyPrint());
        return response;
    }
}
