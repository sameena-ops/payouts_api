package testsuites;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import org.junit.BeforeClass;

public class BaseTest {

    public static RequestSpecification requestSpecification;
    public static RequestSpecBuilder requestSpecBuilder;

    @BeforeClass
    public static void setUp(){
        requestSpecBuilder = new RequestSpecBuilder();
        requestSpecBuilder.setBaseUri("https://relay-candidate.proxy.beeceptor.com/").setContentType(ContentType.JSON);
        requestSpecification= requestSpecBuilder.build();
    }
}
