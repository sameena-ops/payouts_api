package testsuites;

import entities.GetAllPayoutsResponse;
import entities.Payouts;
import io.restassured.response.Response;
import org.junit.Assert;

import org.junit.Test;
import properties.EndPoints;

import java.util.ArrayList;
import java.util.List;

import static io.restassured.RestAssured.given;

public class GetAllPaymentsTests extends BaseTest {

    @Test
    /* This test is a pass as we are asserting on status code */
    public void validateAllPayouts() {
        Response response = given().spec(requestSpecification).when()
                .get(EndPoints.ALL_PAYOUTS);
        System.out.println(response.asString());

        Assert.assertEquals(200, response.getStatusCode());
    }

    @Test
    /* This test is a fail as currency field is a mismatch for second element of payouts array*/
    public void validateCurrencyAllPayouts() {
        List<String> expectedCurr = new ArrayList<>();
        expectedCurr.add("SEK");
        expectedCurr.add("PLN");
        Response response = given().spec(requestSpecification).when()
                .get(EndPoints.ALL_PAYOUTS);
        GetAllPayoutsResponse allPayoutsResponse = response.as(GetAllPayoutsResponse.class);
        List<Payouts> actualCurr = allPayoutsResponse.getPayouts();
        for (Payouts p : actualCurr) {
            System.out.println(p.getCurrency());
            Assert.assertTrue(expectedCurr.contains(p.getCurrency()));
        }
    }
}
