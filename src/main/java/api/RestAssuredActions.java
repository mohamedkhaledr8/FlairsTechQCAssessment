package api;

import io.restassured.response.Response;

import java.util.Map;

import static api.RestAssuredFactory.baseRequest;

public class RestAssuredActions {


    public  Response post(String endpoint, Object body) {
        return baseRequest()
                .body(body)
                .post(endpoint)
                .then()
                .log().all()
                .extract().response();
    }
    public  Response get(String endpoint, Map<String, Object> queryParams) {
        return baseRequest()
                .queryParams(queryParams)
                .get(endpoint)
                .then()
                .log().all()
                .extract().response();
    }


    public  Response delete(String endpoint, Object body) {
        return baseRequest().body(body)
                .delete(endpoint)
                .then()
                .log().all()
                .extract().response();
    }


}
