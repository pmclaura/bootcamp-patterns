package singleton;


import java.sql.*;
import java.util.Properties;

public class PostgresDBClient {
    public static PostgresDBClient client = null;
    public static Connection connect;

    private PostgresDBClient()
    {
        try
        {
            Class.forName("org.postgresql.Driver");
            String url = "jdbc:postgresql://localhost/qautomation";
            Properties props = new Properties();
            props.setProperty("user", "postgres");
            props.setProperty("password", "postgres");
            connect = DriverManager.getConnection(url, props);

        } catch (SQLException | ClassNotFoundException e) {
            e.getStackTrace();
        }
    }
    public static PostgresDBClient getClient()
    {
        if (client == null){
            System.out.println("First time");
            client = new PostgresDBClient();
        }
        return client;
    }

    public void getData(){
        Statement stmt = null;
        try {
            stmt = this.connect.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM test");
            while (rs.next()) {
                System.out.print("Column 1 returned ");
                System.out.println(rs.getString(1));
            }
            rs.close();
            stmt.close();
        } catch (SQLException e) {
            e.getStackTrace();
        }
    }
}
