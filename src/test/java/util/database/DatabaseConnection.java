package util.database;

import enums.DatabaseEnum;
import util.properties.GetProperties;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

public class DatabaseConnection {

    public static Connection databaseConnection() {
        Connection connection = null;
        GetProperties propReader = new GetProperties();
        Properties prop = propReader.properties_reader(DatabaseEnum.FILEPATH.getDbInfo());
        try {
            Class.forName(DatabaseEnum.CLASSNAME.getDbInfo());
            connection = DriverManager
                    .getConnection(prop.getProperty(DatabaseEnum.HOST.getDbInfo()), prop.getProperty(DatabaseEnum.USER.getDbInfo()) , prop.getProperty(DatabaseEnum.PASSWORD.getDbInfo()));
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
        return connection;
    }
}
