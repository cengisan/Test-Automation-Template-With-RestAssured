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
    public RequestSpecification BookerRequestSpec(){
        GetProperties getProp = new GetProperties();
        Properties prop = getProp.properties_reader(SpecEnum.FILEPATH.getSpecInfos());
        return new RequestSpecBuilder().
                setBaseUri(prop.getProperty(SpecEnum.BOOKERURL.getSpecInfos())).
                log(LogDetail.ALL).
                build();
    }
    public ResponseSpecification BookerResponseSpec(){
        return new ResponseSpecBuilder().
                build();
    }
    public RequestSpecification ReqresRequestSpec(){
        GetProperties getProp = new GetProperties();
        Properties prop = getProp.properties_reader(SpecEnum.FILEPATH.getSpecInfos());
        return new RequestSpecBuilder().
                setBaseUri(prop.getProperty(SpecEnum.REQRESURL.getSpecInfos())).
                log(LogDetail.ALL).
                build();
    }
    public ResponseSpecification ReqresResponseSpec(){
        return new ResponseSpecBuilder().
                build();
    }
}
