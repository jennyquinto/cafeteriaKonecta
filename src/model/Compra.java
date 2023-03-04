package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class Compra extends Producto {

    public int id;
    public int idProducto;
    public String nombreProducto;
    public int cantidad;
    public int stock ;

    public Compra() {
        this.connectionDb = new ConnectionDb();
    }

    public Compra(int idProducto, String nombreProducto, int cantidad, int stock) {
        this.idProducto = idProducto;
        this.nombreProducto = nombreProducto;
        this.cantidad = cantidad;
        this.stock = stock;
    }

    public ArrayList<Compra> getCompras() {
        try {
            Connection connection = connectionDb.getConnection();
            String query = "SELECT * FROM compra";
            PreparedStatement sentencia = connection.prepareStatement(query);
            ResultSet rs = sentencia.executeQuery();
            ArrayList<Compra> listaCompras = new ArrayList<>();

            while (rs.next()) {
                Compra compra = new Compra();

                compra.id = rs.getInt(1);
                compra.idProducto = rs.getInt(2);
                compra.nombreProducto = rs.getString(3);
                compra.cantidad = rs.getInt(4);
                compra.stock = rs.getInt(5);

                System.out.println(compra.toString());
                listaCompras.add(compra);
            }
            connection.close();

            return listaCompras;

        } catch (Exception e) {
            System.out.println("Error " + e.toString());
            return null;

        }
    }

    public boolean insert() {
        
        try {
            Connection connection = connectionDb.getConnection();            
            String query = "INSERT INTO compra VALUES (null,?,?,?,?)";
            PreparedStatement sentencia = connection.prepareStatement(query);
            sentencia.setInt(1, idProducto);
            sentencia.setString(2, nombreProducto);
            sentencia.setInt(3, cantidad);
            sentencia.setInt(4, stock);
            
            int filasAfectadas = sentencia.executeUpdate();
            connection.close();

            if (filasAfectadas > 0) {
                System.out.println("Compra realizada");
                return true;

            } else {
                System.out.println("Compra no realizada");
                return false;
            }
        } catch (Exception e) {
            System.out.println("Error al registrar la compra" + e.toString());
            return false;

        }
    }

    @Override
    public String toString() {
        return id + " - " + idProducto + " - " + nombreProducto + " - " + cantidad + " - " + stock;
    }

    
    
}
