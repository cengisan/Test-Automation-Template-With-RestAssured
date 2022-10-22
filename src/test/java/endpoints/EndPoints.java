package endpoints;

import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import testbase.testbase;
import java.util.HashMap;
import static io.restassured.RestAssured.*;

public class EndPoints {
    RequestSpecification spec = (new testbase()).RequestSpec();

    public void Auth (String path, HashMap payload){

         given(spec)
                .contentType("application/json")
        .when()
                .body(payload)
                .post(path)
        .then()
                 .log().all()
                 .extract()
                 .response();
    }
}
