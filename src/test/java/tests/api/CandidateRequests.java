package tests.api;

import CandRequests.AddingCandRequest;
import CandRequests.DeleteCandRequest;
import RequestsBodyData.AddingCandRequestBodyData;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import org.testng.Assert;

public class CandidateRequests {

private Response requestResponse;
    @When("Admin deletes Candidate")
    public void deleteCandidate() {

        requestResponse = new DeleteCandRequest().deleteExistCand();

    }


   @When("Admin adding Candidate")
    public void addingCandidate() {
       requestResponse =  new AddingCandRequest().AddingCandWithFillAllRequiredData(new AddingCandRequestBodyData().FillAllCandRequiredData());

    }

    @Then("Candidate should be added")
    public void CandidateShouldBeAdded(){
        Assert.assertEquals(requestResponse.getStatusCode(), 200);
    }
    @Then("Candidate should be deleted")
    public void CandidateShouldBeDeleted(){
        Assert.assertEquals(requestResponse.getStatusCode(), 200);
    }





    }


