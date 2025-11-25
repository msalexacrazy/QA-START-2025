package org.prog.session11.steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.prog.session11.DataHolder;
import org.prog.session8.page.AlloPage;
import org.prog.session8.page.GooglePage;
import org.testng.Assert;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class WebSteps {

    public static WebDriver driver;
    private GooglePage googlePage = new GooglePage(driver);
    private AlloPage alloPage = new AlloPage(driver);

    @Given("I load google page")
    public void iLoadGooglePage() {
        googlePage.loadPage();
    }

    @Given("I accept cookies if they are present")
    public void iAcceptCookiesIfTheyArePresent() {
        if (googlePage.isCookiesPresent()) {
            googlePage.acceptCookiesIfPresent();
        }
    }

    @Given("Search {string} coast")
    public void searchSmthFromSite(String alias) throws SQLException {
        driver.manage().window().maximize();
        alloPage.loadPage();
        alloPage.searchSmth(alias);
        String price = alloPage.getPrise();
        DataHolder.DATA.put(alias, price);
    }


    @When("I set search to {string}")
    public void iSetSearchToRandomPersonsName(String alias) {
        if (DataHolder.DATA.containsKey(alias)) {
            googlePage.setSearchFieldValue((String) DataHolder.DATA.get(alias));
        } else {
            googlePage.setSearchFieldValue(alias);
        }
    }

    @Then("Search field contains {string}")
    public void searchFieldContainsRandomPersonsName(String alias) {
        Assert.assertEquals(
                googlePage.getSearchFieldValue(),
                DataHolder.DATA.get(alias),
                "Search field expected to contain random persons name");
    }
}
