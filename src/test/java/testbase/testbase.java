package testbase;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.testng.annotations.BeforeClass;
public class testbase {
    RequestSpecification requestSpec;
    ResponseSpecification responseSpec;

    @BeforeClass
    public RequestSpecification RequestSpec(){

        RequestSpecBuilder specBuilder = new RequestSpecBuilder().
                setBaseUri("https://restful-booker.herokuapp.com/").
                log(LogDetail.ALL).
                setContentType(ContentType.JSON);
        requestSpec = specBuilder.build();
        return requestSpec;
    }
    @BeforeClass
    public ResponseSpecification ResponseSpec(){

        ResponseSpecBuilder specBuilder = new ResponseSpecBuilder().
                log(LogDetail.ALL).
                expectContentType(ContentType.JSON);
        responseSpec = specBuilder.build();
        return responseSpec;
    }
}
