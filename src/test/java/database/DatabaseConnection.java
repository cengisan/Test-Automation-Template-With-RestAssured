package database;

import enums.DatabaseEnum;
import util.HelperClass;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

public class DatabaseConnection {

    public static Connection databaseConnection() {
        Connection connection = null;
        HelperClass helperClass = new HelperClass();
        Properties prop = helperClass.propertiesReader(DatabaseEnum.FILEPATH.getDbInfo());
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
