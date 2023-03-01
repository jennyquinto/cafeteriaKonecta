package model;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionDb {

    protected String driver = "com.mysql.jdbc.Driver";
    protected String user = "root";
    protected String password = "";
    protected String url = "jdbc:mysql://localhost:3306/cafeteriakonectadb";
    
    public Connection getConnection() {        
        Connection connection = null;
        try {
            connection = (Connection) DriverManager.getConnection(url, user, password);
            if (connection != null) {
                System.out.println("Conexión exitosa");
            }
        } catch (Exception e) {
            System.out.println("Error en la conexión" + e.getMessage());
        }
        return connection;
    }

}
