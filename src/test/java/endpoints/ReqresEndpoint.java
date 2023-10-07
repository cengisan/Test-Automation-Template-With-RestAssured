package endpoints;

import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import reporter.ExtentReporterListener;
import specifications.Specifications;


import static io.restassured.RestAssured.given;
import static util.TestBaseClass.captor;
import static util.TestBaseClass.writer;

public class ReqresEndpoint {

    public Response Post(String path, Object payload) {

        ExtentReporterListener extentReporterListener = new ExtentReporterListener();
        Specifications specifications = new Specifications();

        Response response = given(specifications.ReqresRequestSpec())
                .filter(new RequestLoggingFilter(captor))
                .contentType(ContentType.JSON)
                .when()
                .body(payload)
                .post(path)
                .then().spec(specifications.ReqresResponseSpec())
                .extract()
                .response();

        extentReporterListener.requestAndResponseReporter(writer.toString(), response.prettyPrint());
        return response;
    }
    public Response Get(String path) {

        ExtentReporterListener extentReporterListener = new ExtentReporterListener();
        Specifications specifications = new Specifications();

        Response response = given(specifications.ReqresRequestSpec())
                .filter(new RequestLoggingFilter(captor))
                .contentType(ContentType.JSON)
                .when()
                .get(path)
                .then().spec(specifications.ReqresResponseSpec())
                .extract()
                .response();

        extentReporterListener.requestAndResponseReporter(writer.toString(), response.prettyPrint());
        return response;
    }

    public Response Get(String path,String param, int id) {

        ExtentReporterListener detail = new ExtentReporterListener();
        Specifications specifications = new Specifications();

        Response response = given(specifications.ReqresRequestSpec())
                .filter(new RequestLoggingFilter(captor))
                .contentType(ContentType.JSON)
                .when()
                .param(param, id)
                .get(path)
                .then().spec(specifications.ReqresResponseSpec())
                .extract()
                .response();

        detail.requestAndResponseReporter(writer.toString(), response.prettyPrint());
        return response;
    }

    public Response Put(String path, Object payload) {

        ExtentReporterListener extentReporterListener = new ExtentReporterListener();
        Specifications specifications = new Specifications();

        Response response = given(specifications.ReqresRequestSpec())
                .filter(new RequestLoggingFilter(captor))
                .contentType(ContentType.JSON)
                .when()
                .body(payload)
                .put(path)
                .then().spec(specifications.ReqresResponseSpec())
                .extract()
                .response();
        extentReporterListener.requestAndResponseReporter(writer.toString(), response.prettyPrint());
        return response;
    }
    public Response Patch(String path, Object payload) {

        ExtentReporterListener extentReporterListener = new ExtentReporterListener();
        Specifications specifications = new Specifications();

        Response response = given(specifications.ReqresRequestSpec())
                .filter(new RequestLoggingFilter(captor))
                .contentType(ContentType.JSON)
                .when()
                .body(payload)
                .patch(path)
                .then().spec(specifications.ReqresResponseSpec())
                .extract()
                .response();

        extentReporterListener.requestAndResponseReporter(writer.toString(), response.prettyPrint());
        return response;
    }
    public Response Delete(String path) {

        ExtentReporterListener extentReporterListener = new ExtentReporterListener();
        Specifications specifications = new Specifications();

        Response response = given(specifications.ReqresRequestSpec())
                .filter(new RequestLoggingFilter(captor))
                .contentType(ContentType.JSON)
                .when()
                .delete(path)
                .then().spec(specifications.ReqresResponseSpec())
                .extract()
                .response();

        extentReporterListener.requestAndResponseReporter(writer.toString(), response.prettyPrint());
        return response;
    }

}
