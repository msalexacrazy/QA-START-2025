import org.testng.annotations.Test;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class TestConnection {

    @Test
    public void myTest() throws SQLException {
        Connection connection = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/db",
                "root",
                "password"
        );
        System.out.println("Connected!");
        connection.close();
    }
}
