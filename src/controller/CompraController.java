package controller;

import java.util.ArrayList;
import model.Compra;
import model.Producto;

public class CompraController extends Producto {

    public ArrayList<Compra> listarCompras() {
        Compra compra = new Compra();
        return compra.getCompras();
    }

    public boolean insertCompra(int idProducto, String nombreProducto, int cantidad, int stock) {
        Compra compra = new Compra();
        compra.idProducto = idProducto;
        compra.nombreProducto = nombreProducto;
        compra.cantidad = cantidad;
        compra.stock = stock;
        return compra.insert();

    }

}
