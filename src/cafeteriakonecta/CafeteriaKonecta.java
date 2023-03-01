package cafeteriakonecta;

import controller.ProductoController;
import java.sql.Connection;
import java.util.Scanner;
import model.ConnectionDb;
import model.ventaProducto;

public class CafeteriaKonecta {

    public static void main(String[] args) {
        Scanner consola = new Scanner(System.in);
        ProductoController controller = new ProductoController();
        ConnectionDb connection = new ConnectionDb();

        try (Connection testConnection = connection.getConnection()) {

        } catch (Exception e) {
            System.out.println(e);
        }

        int option;
        option = 0;
        do{
            System.out.println("------------------------");
            System.out.println(" Menú cafeteria Konecta  ");            
            System.out.println("  1. Listar productos");
            System.out.println("  2. Crear producto");
            System.out.println("  3. Editar producto");
            System.out.println("  4. Eliminar productos");
            System.out.println("  0. Salir");
            
            option = consola.nextInt();
            
            switch (option) {
                case 0:
                    break;
                case 1:
                    controller.listarProductos();
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
                    break;
                default:
                    break;
                    
            }
            
        }while(option != 0); 
            
        
    }

}
