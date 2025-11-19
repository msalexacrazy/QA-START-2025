package org.prog.session9;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.Test;
import io.restassured.response.ValidatableResponse;
import org.hamcrest.Matchers;
import io.restassured.http.ContentType;

import java.util.List;
//TODO: add check for location.street.number
//TODO: add check for location.street.name
//TODO: add check for location.coordinates.latitude
//TODO: add check for location.coordinates.longitude
public class HomeworkTest {

    @Test
    public void myRestTest() {
        RequestSpecification requestSpecification =
                generateRequestSpecification("https://randomuser.me/");

        Response response = requestSpecification.get();

        ValidatableResponse validatableResponse = response.then();
        validatableResponse.statusCode(200);
        validatableResponse.contentType(ContentType.JSON);

        List<Integer> streetNumbers = response.jsonPath().getList("results.location.street.number");
        List<String> streetNames = response.jsonPath().getList("results.location.street.name");
        List<String> latitudes = response.jsonPath().getList("results.location.coordinates.latitude");
        List<String> longitudes = response.jsonPath().getList("results.location.coordinates.longitude");

        Assert.assertFalse(streetNumbers.isEmpty(), "Street numbers list is empty!");
        Assert.assertFalse(streetNames.isEmpty(), "Street names list is empty!");
        Assert.assertFalse(latitudes.isEmpty(), "Latitudes list is empty!");
        Assert.assertFalse(longitudes.isEmpty(), "Longitudes list is empty!");

        System.out.println("Street numbers: " + streetNumbers);
        System.out.println("Street names: " + streetNames);
        System.out.println("Latitudes: " + latitudes);
        System.out.println("Longitudes: " + longitudes);

        response.prettyPrint();
    }

    private RequestSpecification generateRequestSpecification(String baseUrl) {
        return RestAssured.given()
                .baseUri(baseUrl)
                .basePath("api/")
                .queryParam("inc", "gender,name,nat,location")
                .queryParam("results", 3)
                .queryParam("noinfo");
    }
}