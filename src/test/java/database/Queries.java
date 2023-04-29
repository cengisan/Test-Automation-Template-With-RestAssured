package database;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Queries extends DatabaseConnection{
    String query;
    PreparedStatement statement;
    ResultSet resultSet;
    public String dummyQuery (){

        String value = null;
        query = "SELECT value1 FROM table_name where columnName = 'columnValue'";
        System.out.println("RUNNING SQL----> " + query);

        try {
            statement = databaseConnection().prepareStatement(query);
            resultSet = statement.executeQuery();
            while (resultSet.next()){
                value = resultSet.getString(1);
                System.out.println("The valur from the table is " + value);
            }
            databaseConnection().close();
            statement.close();
            resultSet.close();
        } catch (SQLException e) {
            throw new RuntimeException("There is an error in SQL query!");
        }
        return value;
    }

}
