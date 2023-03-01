package cafeteriakonecta;

import java.sql.Connection;
import model.ConnectionDb;

public class CafeteriaKonecta {

    public static void main(String[] args) {

        ConnectionDb connection = new ConnectionDb();
        
        try (Connection testConnection = connection.getConnection()) {
            
        } catch (Exception e) {
            System.out.println(e);
        }
    }

}
