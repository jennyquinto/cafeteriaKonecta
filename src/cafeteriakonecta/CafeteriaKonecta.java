package cafeteriakonecta;

import controller.ProductoController;
import java.sql.Timestamp;
import java.util.Scanner;

public class CafeteriaKonecta {

    public static void main(String[] args) {
        Scanner consola = new Scanner(System.in);
        ProductoController controller = new ProductoController();
        Timestamp fecha_creacion;
        
        int option;
        option = 0;
        do {
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
                    System.out.println("Ingrese el nombre del producto");
                    String nombre = consola.next();

                    System.out.println("Ingrese la referencia del producto");
                    String referencia = consola.next();

                    System.out.println("Ingrese el precio del producto");
                    int precio = consola.nextInt();

                    System.out.println("Ingrese el peso del producto");
                    int peso = consola.nextInt();

                    System.out.println("Ingrese la categoria del producto");
                    String categoria = consola.next();

                    System.out.println("Ingrese el stock del producto");
                    int stock = consola.nextInt();

                    Long datetime = System.currentTimeMillis();
                    fecha_creacion = new Timestamp(datetime);

                    controller.insertProducto(nombre, referencia, precio, peso, categoria, stock, fecha_creacion);
                    break;
                    
                case 3:

                    System.out.println("Ingrese el id del producto a actualizar");
                    int id = consola.nextInt();

                    System.out.println("Ingrese el nombre del producto a actualizar");
                    nombre = consola.next();
                    
                    System.out.println("Ingrese la referencia del producto a actualizar");
                    referencia = consola.next();

                    System.out.println("Ingrese el precio del producto a actualizar");
                    precio = consola.nextInt();

                    System.out.println("Ingrese el peso del producto a actualizar");
                    peso = consola.nextInt();

                    System.out.println("Ingrese la categoria del producto a actualizar");
                    categoria = consola.next();

                    System.out.println("Ingrese el stock del producto a actualizar");
                    stock = consola.nextInt();

                    datetime = System.currentTimeMillis();
                    fecha_creacion = new Timestamp(datetime);
                    
                    controller.updateProducto(id, nombre, referencia, precio, peso, categoria,stock, fecha_creacion);                   
                    break;
                case 4:
                    
                    System.out.println("Ingrese el id del producto a actualizar");
                    int idDelete = consola.nextInt();
                    controller.deleteProducto(idDelete);
                    break;
                default:
                    break;

            }

        } while (option != 0);

    }

}
