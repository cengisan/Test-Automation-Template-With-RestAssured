package endpoints;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import specifications.Specifications;

import java.util.HashMap;

import static io.restassured.RestAssured.*;

public interface BookerEndPoints {

    default Response post(String path, HashMap payload) {
        Specifications specifications = new Specifications();
        return given(specifications.RequestSpec())
                .contentType(ContentType.JSON)
                .when()
                .body(payload)
                .post(path)
                .then().spec(specifications.ResponseSpec())
                .extract()
                .response();
    }
    default Response get(String path) {
        Specifications specifications = new Specifications();
        return given(specifications.RequestSpec())
                .contentType(ContentType.JSON)
                .when()
                .get(path)
                .then().spec(specifications.ResponseSpec())
                .extract()
                .response();
    }

    default Response put(String path, HashMap payload, String token) {
        Specifications specifications = new Specifications();
        return given(specifications.RequestSpec())
                .contentType(ContentType.JSON)
                .header("Cookie","token="+token)
                .when()
                .body(payload)
                .put(path)
                .then().spec(specifications.ResponseSpec())
                .extract()
                .response();
    }
    default Response patch(String path, HashMap payload, String token) {
        Specifications specifications = new Specifications();
        return given(specifications.RequestSpec())
                .contentType(ContentType.JSON)
                .header("Cookie","token="+token)
                .when()
                .body(payload)
                .patch(path)
                .then().spec(specifications.ResponseSpec())
                .extract()
                .response();
    }
    default Response delete(String path,String token) {
        Specifications specifications = new Specifications();
        return given(specifications.RequestSpec())
                .contentType(ContentType.JSON)
                .header("Cookie","token="+token)
                .when()
                .delete(path)
                .then().spec(specifications.ResponseSpec())
                .extract()
                .response();
    }
}
