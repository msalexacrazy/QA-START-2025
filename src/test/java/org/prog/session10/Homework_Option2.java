package org.prog.session10;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.prog.session8.page.AlloPage;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.sql.*;


//TODO: Option 2 - Create table with phone name and price for this model
//TODO: Option 2 - Load allo.ua, search for Iphone, and store its price to DB
public class Homework_Option2 {
    private Connection connection;
    private WebDriver driver;
    private AlloPage alloPage;

    @BeforeSuite
    public void beforeSuite() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        connection = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/db", "root", "password");
        driver = new ChromeDriver();
        alloPage = new AlloPage(driver);
    }

    @AfterSuite
    public void tearDown() throws SQLException {
        if (connection != null) {
            connection.close();
        }
        if (driver != null) {
            driver.quit(); // закриває всі вкладки і процес браузера
        }
    }

    @Test
    public void testWriteToDBFromSite() throws SQLException {
        driver.manage().window().maximize();
        alloPage.loadPage();
        alloPage.searchSmth("Iphone");
        String price = alloPage.getPrise();

        try (PreparedStatement preparedStatement = connection.prepareStatement(
                "INSERT INTO PriseIphone (Prise) VALUES (?)")) {
            preparedStatement.setString(1, price);
            preparedStatement.executeUpdate();
        }
    }
    @Test
    public void testReadFromDB() throws SQLException, ClassNotFoundException {
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT * FROM PriseIphone");
        while (resultSet.next()) {
            System.out.println(
                    resultSet.getInt("IphoneID") + ", " +
                            resultSet.getString("Prise")
            );
        }
    }

}
