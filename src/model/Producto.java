package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

public class Producto extends ConnectionDb {

    int id;
    String nombre;
    String referencia;
    int precio;
    int peso;
    String categoria;
    int stock;
    Timestamp fecha_creacion;
    ConnectionDb connectionDb;

    public Producto() {
        this.connectionDb = new ConnectionDb();
    }

    public Producto(String nombre, String referencia, int precio, int peso, String categoria, int stock, Timestamp fecha_creacion) {
        this.nombre = nombre;
        this.referencia = referencia;
        this.precio = precio;
        this.peso = peso;
        this.categoria = categoria;
        this.stock = stock;
        this.fecha_creacion = fecha_creacion;
    }

    

    public ArrayList<Producto> getProductos() {
        try {
            Connection connection = connectionDb.getConnection();
            String query = "SELECT * FROM producto";
            PreparedStatement sentencia = connection.prepareStatement(query);
            ResultSet rs = sentencia.executeQuery();
            ArrayList<Producto> listaProductos = new ArrayList<>();

            while (rs.next()) {
                Producto producto = new Producto();
                producto.id = rs.getInt(1);
                producto.nombre = rs.getString(2);
                producto.referencia = rs.getString(3);
                producto.precio = rs.getInt(4);
                producto.peso = rs.getInt(5);
                producto.categoria = rs.getString(6);
                producto.stock = rs.getInt(7);
                producto.fecha_creacion = rs.getTimestamp(8);
                System.out.println(producto.toString());
                listaProductos.add(producto);
            }
            connection.close();

            return listaProductos;

        } catch (Exception e) {
            System.out.println("Error " + e.toString());
            return null;

        }
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public int getPeso() {
        return peso;
    }

    public void setPeso(int peso) {
        this.peso = peso;
    }

    public String getReferencia() {
        return referencia;
    }

    public void setReferencia(String referencia) {
        this.referencia = referencia;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public Timestamp getFecha_creacion() {
        return fecha_creacion;
    }

    public void setFecha_creacion(Timestamp fecha_creacion) {
        this.fecha_creacion = fecha_creacion;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    @Override
    public String toString() {
        return id + " - " + nombre + " - " + referencia + " - "  + precio + " - " + peso + " - "+ categoria + " - " + stock +  " - " + fecha_creacion ;
    }

}
