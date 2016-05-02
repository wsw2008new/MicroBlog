package connections;

/**
 * Created by alikemal on 04.04.2016.
 */

import java.sql.*;


public class Connection {
    private static Connection instance = new Connection();
    public java.sql.Connection connection = null;

    private Connection() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try {
            connection = DriverManager
                    .getConnection("jdbc:mysql://46.101.100.122/ali_asp", "ali_asp", "123456");
        } catch (SQLException e) {
            System.out.println("Connection Failed! Check output console");
            e.printStackTrace();
        }
    }

    public static Connection getInstance() {
        return instance;
    }

    public void exeQuerynonResult(String query) {
        try {
            PreparedStatement stmt = Connection.getInstance().connection.prepareStatement(query);
            stmt.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public ResultSet exeQuery(String query) {

        ResultSet rs = null;
        try {
            Statement stmt = Connection.getInstance().connection.createStatement();
            rs = stmt.executeQuery(query);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return rs;
    }
}