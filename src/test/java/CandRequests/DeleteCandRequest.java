package CandRequests;

import RequestResponse.GetCandResponseModel;
import api.RestAssuredActions;
import io.restassured.response.Response;

import java.awt.geom.RectangularShape;

public class DeleteCandRequest {
    public Response deleteExistCand()
    {
        var getCandResponseModel=new GetCandRequest().getallCand();

        String requestBody = "{\"ids\":["+getCandResponseModel.data.getFirst().id+"]}";
        return   new RestAssuredActions().delete(System.getProperty("endpoint"), requestBody);

    }
}
