package cafeteriakonecta;

import controller.ProductoController;
import controller.CompraController;
import java.sql.Timestamp;
import java.util.Scanner;
import model.Producto;
import model.Compra;

public class CafeteriaKonecta {

    public static void main(String[] args) {
        Scanner consola = new Scanner(System.in);
        Producto producto = new Producto();
        ProductoController controllerProducto = new ProductoController();
        CompraController controllerCompra = new CompraController();
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
            System.out.println("  5. Listar compras");
            System.out.println("  6. Comprar Producto");
            System.out.println("  0. Salir");

            option = consola.nextInt();

            switch (option) {
                case 0:
                    break;

                case 1:

                    controllerProducto.listarProductos();
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

                    controllerProducto.insertProducto(nombre, referencia, precio, peso, categoria, stock, fecha_creacion);
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

                    controllerProducto.updateProducto(id, nombre, referencia, precio, peso, categoria, stock, fecha_creacion);
                    break;
                case 4:

                    System.out.println("Ingrese el id del producto a eliminar");
                    int idDelete = consola.nextInt();
                    controllerProducto.deleteProducto(idDelete);
                    break;
                case 5:

                    controllerCompra.listarCompras();

                    break;
                case 6:
                    System.out.println("Ingrese el id del producto a comprar");
                    int idProducto = consola.nextInt();
                    System.out.println("Ingrese la cantidad a comprar");
                    int cantidad = consola.nextInt();

                    System.out.println("Desea confirmar la compra");
                    System.out.println("1) Ingrese 1 para confirmar");
                    System.out.println("2) Ingrese 2 para rechazar");
                    int comprar = consola.nextInt();
                    if (comprar == 1) {
                        producto = controllerProducto.findProducto(idProducto);
                        stock = producto.stock - cantidad;
                        if (stock <0) {
                            System.out.println("No es posible realizar la venta");
                            System.out.println(producto.nombre + " restante = " + producto.stock);
                        } else {
                            controllerProducto.updateProducto(idProducto, producto.nombre, producto.referencia, producto.precio, producto.peso, producto.categoria, stock, producto.fecha_creacion);
                            controllerCompra.insertCompra(idProducto, producto.nombre, cantidad, stock);
                            break;

                        }

                    }
                    break;
                default:
                    break;

            }

        } while (option != 0);

    }

}
