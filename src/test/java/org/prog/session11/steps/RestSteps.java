package org.prog.session11.steps;

import io.cucumber.java.en.Given;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.prog.session11.DataHolder;
import org.prog.session9.ResultsDto;

public class RestSteps {

    @Given("request {int} random location from API with fields {string} as {string}")
    public void requestPersonFromAPI(int amount, String fields, String alias) {
        Response response = RestAssured.given()
                .baseUri("https://randomuser.me/")
                .basePath("api/")
                .queryParam("inc", fields) // приклад: "gender,name,nat,location"
                .queryParam("results", amount)
                .queryParam("noinfo")
                .get();
        response.prettyPrint();
        DataHolder.DATA.put(alias, response.as(ResultsDto.class));
    }
}
