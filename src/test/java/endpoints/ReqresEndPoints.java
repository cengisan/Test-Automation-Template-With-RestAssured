package endpoints;

import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import reports.ExtentReporterListener;
import specifications.Specifications;

import java.io.StringWriter;
import java.util.HashMap;

import static io.restassured.RestAssured.given;

public interface ReqresEndPoints {

    default Response reqresPost(String path, HashMap payload) {

        ExtentReporterListener detail = new ExtentReporterListener();
        Specifications specifications = new Specifications();

        Response response = given(specifications.ReqresRequestSpec())
                .filter(new RequestLoggingFilter(detail.captor))
                .contentType(ContentType.JSON)
                .when()
                .body(payload)
                .post(path)
                .then().spec(specifications.ReqresResponseSpec())
                .extract()
                .response();

        detail.requestAndResponseReporter(detail.writer.toString(), response.prettyPrint());
        return response;
    }
    default Response reqresGet(String path) {

        ExtentReporterListener detail = new ExtentReporterListener();
        Specifications specifications = new Specifications();

        Response response = given(specifications.ReqresRequestSpec())
                .filter(new RequestLoggingFilter(detail.captor))
                .contentType(ContentType.JSON)
                .when()
                .get(path)
                .then().spec(specifications.ReqresResponseSpec())
                .extract()
                .response();

        detail.requestAndResponseReporter(detail.writer.toString(), response.prettyPrint());
        return response;
    }

    default Response reqresGet(String path,String param, int id) {

        ExtentReporterListener detail = new ExtentReporterListener();
        Specifications specifications = new Specifications();

        Response response = given(specifications.ReqresRequestSpec())
                .filter(new RequestLoggingFilter(detail.captor))
                .contentType(ContentType.JSON)
                .when()
                .param(param, id)
                .get(path)
                .then().spec(specifications.ReqresResponseSpec())
                .extract()
                .response();

        detail.requestAndResponseReporter(detail.writer.toString(), response.prettyPrint());
        return response;
    }

    default Response reqresPut(String path, HashMap payload) {

        ExtentReporterListener detail = new ExtentReporterListener();
        Specifications specifications = new Specifications();

        Response response = given(specifications.ReqresRequestSpec())
                .filter(new RequestLoggingFilter(detail.captor))
                .contentType(ContentType.JSON)
                .when()
                .body(payload)
                .put(path)
                .then().spec(specifications.ReqresResponseSpec())
                .extract()
                .response();
        detail.requestAndResponseReporter(detail.writer.toString(), response.prettyPrint());
        return response;
    }
    default Response reqresPatch(String path, HashMap payload) {

        ExtentReporterListener detail = new ExtentReporterListener();
        Specifications specifications = new Specifications();

        Response response = given(specifications.ReqresRequestSpec())
                .filter(new RequestLoggingFilter(detail.captor))
                .contentType(ContentType.JSON)
                .when()
                .body(payload)
                .patch(path)
                .then().spec(specifications.ReqresResponseSpec())
                .extract()
                .response();

        detail.requestAndResponseReporter(detail.writer.toString(), response.prettyPrint());
        return response;
    }
    default Response reqresDelete(String path) {

        ExtentReporterListener detail = new ExtentReporterListener();
        Specifications specifications = new Specifications();

        Response response = given(specifications.ReqresRequestSpec())
                .filter(new RequestLoggingFilter(detail.captor))
                .contentType(ContentType.JSON)
                .when()
                .delete(path)
                .then().spec(specifications.ReqresResponseSpec())
                .extract()
                .response();

        detail.requestAndResponseReporter(detail.writer.toString(), response.prettyPrint());
        return response;
    }
}
