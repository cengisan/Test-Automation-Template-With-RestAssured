package endpoints;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import specifications.Specifications;

import java.util.HashMap;

import static io.restassured.RestAssured.given;

public interface ReqresEndPoints {

    default Response reqresPost(String path, HashMap payload) {
        Specifications specifications = new Specifications();
        return given(specifications.ReqresRequestSpec())
                .contentType(ContentType.JSON)
                .when()
                .body(payload)
                .post(path)
                .then().spec(specifications.ReqresResponseSpec())
                .extract()
                .response();
    }
    default Response reqresGet(String path) {
        Specifications specifications = new Specifications();
        return given(specifications.ReqresRequestSpec())
                .contentType(ContentType.JSON)
                .when()
                .get(path)
                .then().spec(specifications.ReqresResponseSpec())
                .extract()
                .response();
    }

    default Response reqresGet(String path,String param, int id) {
        Specifications specifications = new Specifications();
        return given(specifications.ReqresRequestSpec())
                .contentType(ContentType.JSON)
                .when()
                .param(param, id)
                .get(path)
                .then().spec(specifications.ReqresResponseSpec())
                .extract()
                .response();
    }

    default Response reqresPut(String path, HashMap payload) {
        Specifications specifications = new Specifications();
        return given(specifications.ReqresRequestSpec())
                .contentType(ContentType.JSON)
                .when()
                .body(payload)
                .put(path)
                .then().spec(specifications.ReqresResponseSpec())
                .extract()
                .response();
    }
    default Response reqresPatch(String path, HashMap payload) {
        Specifications specifications = new Specifications();
        return given(specifications.ReqresRequestSpec())
                .contentType(ContentType.JSON)
                .when()
                .body(payload)
                .patch(path)
                .then().spec(specifications.ReqresResponseSpec())
                .extract()
                .response();
    }
    default Response reqresDelete(String path) {
        Specifications specifications = new Specifications();
        return given(specifications.ReqresRequestSpec())
                .contentType(ContentType.JSON)
                .when()
                .delete(path)
                .then().spec(specifications.ReqresResponseSpec())
                .extract()
                .response();
    }
}
