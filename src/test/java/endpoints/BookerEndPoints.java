package endpoints;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import specifications.Specifications;

import java.util.HashMap;

import static io.restassured.RestAssured.*;

public interface BookerEndPoints {

    default Response bookerPost(String path, HashMap payload) {
        Specifications specifications = new Specifications();
        return given(specifications.BookerRequestSpec())
                .contentType(ContentType.JSON)
                .when()
                .body(payload)
                .post(path)
                .then().spec(specifications.BookerResponseSpec())
                .extract()
                .response();
    }
    default Response bookerGet(String path) {
        Specifications specifications = new Specifications();
        return given(specifications.BookerRequestSpec())
                .contentType(ContentType.JSON)
                .when()
                .get(path)
                .then().spec(specifications.BookerResponseSpec())
                .extract()
                .response();
    }

    default Response bookerPut(String path, HashMap payload, String token) {
        Specifications specifications = new Specifications();
        return given(specifications.BookerRequestSpec())
                .contentType(ContentType.JSON)
                .header("Cookie","token="+token)
                .when()
                .body(payload)
                .put(path)
                .then().spec(specifications.BookerResponseSpec())
                .extract()
                .response();
    }
    default Response bookerPatch(String path, HashMap payload, String token) {
        Specifications specifications = new Specifications();
        return given(specifications.BookerRequestSpec())
                .contentType(ContentType.JSON)
                .header("Cookie","token="+token)
                .when()
                .body(payload)
                .patch(path)
                .then().spec(specifications.BookerResponseSpec())
                .extract()
                .response();
    }
    default Response bookerDelete(String path,String token) {
        Specifications specifications = new Specifications();
        return given(specifications.BookerRequestSpec())
                .contentType(ContentType.JSON)
                .header("Cookie","token="+token)
                .when()
                .delete(path)
                .then().spec(specifications.BookerResponseSpec())
                .extract()
                .response();
    }
}
