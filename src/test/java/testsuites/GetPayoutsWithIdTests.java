package testsuites;

import entities.PaymentAction;
import entities.PayoutByIdResponse;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import org.junit.Assert;
import org.junit.Test;
import properties.EndPoints;
import java.util.List;
import static io.restassured.RestAssured.given;


public class GetPayoutsWithIdTests extends BaseTest {


    @Test
    /* This test is a pass as we are asserting on status code */
    public void validatePayoutWithId() {
        Response response = given().spec(requestSpecification).when().queryParam("id", "11ebb9ef6a7d4df0b20d59ad574e9761")
                .get(EndPoints.ALL_PAYOUTS);
        System.out.println(response.asString());
        Assert.assertEquals(200, response.getStatusCode());
    }

    @Test
    /* This test is a fail as response is giving 200 for invalid uuid */
    public void validateResponseWithInvalidUuid() {
        Response response = given().spec(requestSpecification).when().queryParam("id", "...")
                .get(EndPoints.ALL_PAYOUTS);
        System.out.println(response.asString());
        Assert.assertEquals(404, response.getStatusCode());
    }

    @Test
    /* This test is a fail as response doesnt have invoice number */
    public void validateAllFieldsExistsInResponse() throws IllegalAccessException {
        Response response = given().spec(requestSpecification).when().queryParam("id", "11ebb9ef6a7d4df0b20d59ad574e9761")
                .get(EndPoints.ALL_PAYOUTS);
        PayoutByIdResponse payoutByIdResponse = response.getBody().as(PayoutByIdResponse.class);
        List<PaymentAction> paymentActions = payoutByIdResponse.getPaymentActions();
       for(PaymentAction pa:paymentActions)
            Assert.assertNotNull(pa.getInvoiceNumber());
    }
    @Test
    /* This test is a pass*/
    public void validatePaymentActionsArrayCount() {
        Response response = given().spec(requestSpecification).when().queryParam("id", "11ebb9ef6a7d4df0b20d59ad574e9761")
                .get(EndPoints.ALL_PAYOUTS);
        PayoutByIdResponse payoutByIdResponse = response.getBody().as(PayoutByIdResponse.class);
        List<PaymentAction> list = payoutByIdResponse.getPaymentActions();
        Assert.assertEquals(payoutByIdResponse.getNumberOfPaymentActions(),list.size());
    }
}
