package endpoints;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import testbase.testBase;
import java.util.HashMap;
import static io.restassured.RestAssured.*;

public class EndPoints {
    Response response;
    RequestSpecification requestSpecificationspec = (new testBase()).RequestSpec();
    ResponseSpecification responseSpecification = (new testBase()).ResponseSpec();

    public Response Auth (String path, HashMap payload){

         response = given(requestSpecificationspec)
                .contentType("application/json")
                .body(payload)
        .when()
                .body(payload)
                .post(path)
        .then()
                 .log().all()
                 .extract()
                 .response();
         return response;
    }
}
