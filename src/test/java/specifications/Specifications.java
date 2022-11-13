package specifications;

import enums.SpecEnum;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import util.properties.GetProperties;

import java.util.Properties;

public class Specifications {
    public RequestSpecification RequestSpec(){
        GetProperties getProp = new GetProperties();
        Properties prop = getProp.properties_reader(SpecEnum.FILEPATH.getSpecInfos());
        return new RequestSpecBuilder().
                setBaseUri(prop.getProperty(SpecEnum.URL.getSpecInfos())).
                log(LogDetail.ALL).
                build();
    }
    public ResponseSpecification ResponseSpec(){
        return new ResponseSpecBuilder().
                log(LogDetail.ALL).
                build();
    }
}
