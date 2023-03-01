package controller;

import java.sql.Timestamp;
import java.util.ArrayList;
import model.Producto;

public class ProductoController {

    public ArrayList<Producto> listarProductos() {
        Producto producto = new Producto();
        return producto.getProductos();
    }

    public boolean insertProducto(String nombre, String referencia, int precio, int peso, String categoria, int stock, Timestamp fecha_creacion) {
        Producto producto = new Producto();
        producto.nombre = nombre;
        producto.referencia = referencia;
        producto.precio = precio;
        producto.peso = peso;
        producto.categoria = categoria;
        producto.stock = stock;
        producto.fecha_creacion = fecha_creacion;
        return producto.insert();

    }

    public boolean updateProducto(int id, String nombre, String referencia, int precio, int peso, String categoria, int stock, Timestamp fecha_creacion) {
        Producto producto = new Producto();
        producto.id = id;
        producto.nombre = nombre;
        producto.referencia = referencia;
        producto.precio = precio;
        producto.peso = peso;
        producto.categoria = categoria;
        producto.stock = stock;
        producto.fecha_creacion = fecha_creacion;
        return producto.update();
    }
    
    public Producto findProducto (int id){
        Producto producto = new  Producto();
        return producto.find(id);
    }

    public boolean deleteProducto(int id) {
        Producto producto = new Producto();
        return producto.delete(id);
    }
}

