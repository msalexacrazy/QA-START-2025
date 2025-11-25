package org.prog.session11.steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.prog.session11.DataHolder;
import org.prog.session9.PersonDto;
import org.prog.session9.ResultsDto;
import org.testng.Assert;

import java.sql.*;
import java.util.List;

public class DBSteps {

    public static Connection connection;

    @Given("I store {string} in database")
    public void storePersonsToDB(String alias) throws SQLException {
        ResultsDto resultsDto = (ResultsDto) DataHolder.DATA.get(alias);
        List<PersonDto> personDtos = resultsDto.getResults();
        PreparedStatement preparedStatement = connection.prepareStatement(
                "INSERT INTO Persons (FirstName, LastName, Gender, Title, Nat) VALUES (?,?,?,?,?)"
        );
        personDtos.forEach(dto -> executeStatement(dto, preparedStatement));
    }

    @Given("I store {string} in database with location")
    public void storePersonsWithLocationToDB(String alias) throws SQLException {
        ResultsDto resultsDto = (ResultsDto) DataHolder.DATA.get(alias);
        List<PersonDto> personDtos = resultsDto.getResults();
        PreparedStatement preparedStatement = connection.prepareStatement(
                "INSERT INTO Persons (FirstName, LastName, Gender, Title, Nat,  City, Street, HouseNumber) VALUES (?,?,?,?,?,?,?,?)"
        );
        personDtos.forEach(dto -> executeStatement(dto, preparedStatement));
    }

    @Given("I pick a single random person from DB as {string}")
    public void pickRandomPersonFromDB(String alias) throws SQLException {
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT * FROM Persons ORDER BY RAND() LIMIT 1");
        if (resultSet.next()) {
            DataHolder.DATA.put(alias,
                    resultSet.getString("FirstName") + " " +
                            resultSet.getString("LastName"));
        } else {
            Assert.fail("No records found");
        }
    }

    @Given("I pick a random person location from DB as {string}")
    public void pickRandomLocationFromDB(String alias) throws SQLException {
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT * FROM Persons ORDER BY RAND() LIMIT 1");
        if (resultSet.next()) {
            DataHolder.DATA.put(alias,
                    resultSet.getString("City") + "," +
                            resultSet.getString("Street") + "," +
                            resultSet.getInt("HouseNumber"));
        } else {
            Assert.fail("No records found");
        }
    }

    @Given("I write the cost {string} in the database")
    public void writeCoastForAliasInDB(String alias) throws SQLException {
        String price = (String) DataHolder.DATA.get(alias);
        System.out.println("Saved price: " + price);

        try (PreparedStatement ps = DBSteps.connection.prepareStatement(
                "INSERT INTO PriseIphone(Prise) VALUES (?)")) {
            ps.setString(1, price);
            ps.executeUpdate();
        }
    }

    @When("I set search to random location")
    public void printRandomLocationFromDB() throws SQLException {
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(
                "SELECT City, Street, HouseNumber FROM Persons ORDER BY RAND() LIMIT 1"
        );

        if (resultSet.next()) {
            String city = resultSet.getString("City");
            String street = resultSet.getString("Street");
            int houseNumber = resultSet.getInt("HouseNumber");

            System.out.println("Random location from DB: " + city + ", " + street + " " + houseNumber);
        }
    }

    @When("I query the database for {string}")
    public void queryDatabaseForAlias(String alias) throws SQLException {
        PreparedStatement ps = connection.prepareStatement(
                "SELECT Prise FROM PriseIphone ORDER BY IphoneID DESC LIMIT 1"
        );
        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            String dbPrice = rs.getString("Prise");
            DataHolder.DATA.put(alias + "_db", dbPrice);
        } else {
            Assert.fail("No price found in DB for alias: " + alias);
        }

    }

    @Then("persons from {string} are present in database with location")
    public void verifyPersonsWithLocationInDB(String alias) throws SQLException {
        ResultsDto resultsDto = (ResultsDto) DataHolder.DATA.get(alias);
        List<PersonDto> personDtos = resultsDto.getResults();

        for (PersonDto dto : personDtos) {
            PreparedStatement ps = connection.prepareStatement(
                    "SELECT COUNT(*) FROM Persons WHERE FirstName=? AND LastName=? AND Gender=? AND Title=? AND Nat=? AND City=? AND Street=? AND HouseNumber=?"
            );
            ps.setString(1, dto.getName().getFirst());
            ps.setString(2, dto.getName().getLast());
            ps.setString(3, dto.getGender());
            ps.setString(4, dto.getName().getTitle());
            ps.setString(5, dto.getNat());
            ps.setString(6, dto.getLocation().getCity());
            ps.setString(7, dto.getLocation().getStreet().getName());
            ps.setInt(8, dto.getLocation().getStreet().getNumber());

            ResultSet rs = ps.executeQuery();
            rs.next();
            int count = rs.getInt(1);

            org.testng.Assert.assertTrue(count > 0,
                    "Person with location not found in DB: " +
                            dto.getName().getFirst() + " " + dto.getName().getLast() +
                            " @ " + dto.getLocation().getCity() + ", " +
                            dto.getLocation().getStreet().getName() + " " +
                            dto.getLocation().getStreet().getNumber()
            );
        }
    }

    @Then("the cost for {string} is present in the database")
    public void verifyCostInDatabase(String alias) {
        String expectedPrice = (String) DataHolder.DATA.get(alias);
        String actualPrice = (String) DataHolder.DATA.get(alias + "_db");

        Assert.assertEquals(actualPrice, expectedPrice,
                "Price in DB does not match the one from site for alias: " + alias);
    }

    private void executeStatement(PersonDto dto, PreparedStatement preparedStatement) {
        try {
            preparedStatement.setString(1, dto.getName().getFirst());
            preparedStatement.setString(2, dto.getName().getLast());
            preparedStatement.setString(3, dto.getGender());
            preparedStatement.setString(4, dto.getName().getTitle());
            preparedStatement.setString(5, dto.getNat());
            preparedStatement.setString(6, dto.getLocation().getCity());
            preparedStatement.setString(7, dto.getLocation().getStreet().getName());
            preparedStatement.setInt(8, dto.getLocation().getStreet().getNumber());
            preparedStatement.execute();
        } catch (Exception e) {
            System.out.println("Error inserting person: " + dto);
        }
    }
}
