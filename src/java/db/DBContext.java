package db;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author Riel
 */
public class DBContext {

    public Connection getConnection() throws Exception {
        String url = "jdbc:sqlserver://" + serverName + ":" + portNumber + ";databaseName=" + dbName;
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        return DriverManager.getConnection(url, userID, password);
    }
    private final String serverName = "localhost";
    private final String dbName = "Photographer";
    private final String portNumber = "1433";
    private final String userID = "sa1";
    private final String password = "123";

    public String getImagePath() throws Exception {
        return "images/";
    }

}
