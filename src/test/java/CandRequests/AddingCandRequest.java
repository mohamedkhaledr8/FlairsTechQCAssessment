package CandRequests;

import RequestsBody.AddingCandRequestBody;
import api.RestAssuredActions;
import io.restassured.response.Response;

public class AddingCandRequest {

    public  Response AddingCandWithFillAllRequiredData(AddingCandRequestBody reqBody)
    {
        return new RestAssuredActions().post(System.getProperty("endpoint"), reqBody);
    }
}
