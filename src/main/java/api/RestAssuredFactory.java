package api;

import driver.CookiesFactory;
import driver.DriverFactory;
import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;



public class RestAssuredFactory {

    public static RequestSpecification baseRequest() {
        String cookieValue = CookiesFactory.getCookie("orangehrm");

        return RestAssured.given()
                .baseUri(System.getProperty("url"))
                .header("Cookie", "orangehrm="+ cookieValue)
                .contentType("application/json")
                .log().all();
    }


}
