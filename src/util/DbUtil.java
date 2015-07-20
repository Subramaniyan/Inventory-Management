package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
//import java.util.Properties;
//import java.io.FileNotFoundException;
//import java.io.IOException;
//import java.io.InputStream;


public class DbUtil {

    private static Connection connection = null;

    public static Connection getConnection() {
        if (connection != null)
            return connection;
        else {
            try {
                //Properties prop = new Properties();
                //InputStream inputStream = DbUtil.class.getClassLoader().getResourceAsStream("/db.properties");
                //prop.load(inputStream);
                //String driver = prop.getProperty("driver");
                //String url = prop.getProperty("url");
                //String user = prop.getProperty("user");
                //String password = prop.getProperty("password");
                Class.forName("com.mysql.jdbc.Driver");
                connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/Inventory", "root", "killer");
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } catch (SQLException e) {
                e.printStackTrace();
            } /* catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } */
            return connection;
        }

    }
}
