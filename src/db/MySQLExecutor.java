package db;

import utils.IDBConfig;
import utils.PropertiesConfig;
import java.sql.*;
import java.util.Map;

public class MySQLExecutor implements IDBExecutor {

    private static Connection connection = null;
    private static Statement statement = null;

    private void createDbStatement() {
        try {
            if(connection == null || connection.isClosed()) {
                IDBConfig configReader = new PropertiesConfig();
                Map<String, String> config = configReader.read();
                connection = DriverManager.getConnection(config.get("url") +
                        String.format("/%s", config.get("db_name")), config.get("username"), config.get("password"));
            } if (statement == null || statement.isClosed()) {
                statement = connection.createStatement();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    @Override
    public void execute(String request) {
        createDbStatement();
        try {
            statement.execute(request);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    @Override
    public void close() {
        try {
            if (statement != null && !statement.isClosed()) {
                statement.close();
                statement = null;
            }
            if (connection != null && !connection.isClosed()) {
                connection.close();
                connection = null;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public ResultSet executeQuery(String request) {
        createDbStatement();
        try {
            return statement.executeQuery(request);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}