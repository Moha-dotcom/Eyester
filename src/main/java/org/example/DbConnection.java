package org.example;




import com.mysql.cj.jdbc.JdbcConnection;
import com.mysql.cj.log.Log;

import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

public class DbConnection {
    // Nested Class to access Properties

        public static Properties loadProperties() throws IOException {
            Properties configuration  = new Properties();
            InputStream inputStream = DbConnection.class
                    .getClassLoader()
                    .getResourceAsStream("db.properties");
            configuration.load(inputStream);
            if (inputStream != null) {
                inputStream.close();
            }
            return configuration;

    }
    Properties conf = loadProperties();
    String url = conf.getProperty("url");
    String username = conf.getProperty("username");
    String password = conf.getProperty("password");

    public DbConnection() throws IOException, SQLException {
    }
    public Connection establishConnection() throws SQLException {

        Log logger = null;
        Connection connection = DriverManager.getConnection(url, username, password);
            logger = (Log) ((JdbcConnection) connection).getSession().getLog();
            logger.logInfo("SuccessFully Connected to the Database");

            return connection;
        }
}

