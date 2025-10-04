package CandRequests;

import RequestResponse.GetCandResponseModel;
import api.RestAssuredActions;
import io.restassured.response.Response;

import java.util.HashMap;

public class GetCandRequest {

    public GetCandResponseModel getallCand()
    {

        var params = new HashMap<String,Object>();
        params.put("limit", 50);
        params.put("offset", 0);
        params.put("model", "list");
        params.put("sortField", "candidate.dateOfApplication");
        params.put("sortOrder", "DESC");


        var response = new RestAssuredActions().get(System.getProperty("endpoint"),params);
        return response.as(GetCandResponseModel.class);
    }
}
