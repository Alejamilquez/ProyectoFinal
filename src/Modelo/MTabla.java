package Modelo;

//import java.sql.*;
import Vista.VentanaInicio;
import com.mysql.cj.jdbc.result.ResultSetMetaData;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.table.DefaultTableModel;

public class MTabla{

    VentanaInicio ventanaInicio = new VentanaInicio();

    public void CargarTabla() {
        System.out.println("entro cargar tabla");
        try {
            DefaultTableModel modelo = new DefaultTableModel();
            ventanaInicio.Tabla.setModel(modelo);

            PreparedStatement ps = null;
            ResultSet rs = null;
            Conexion conn = new Conexion();
            Connection con = conn.conectar();

            
            //Selecciona columnas y la tabla de la base de datos
            String sql = "SELECT Codigo, Nombre, Marca, Cantidad, Precio FROM inventario";
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            ResultSetMetaData rsMd = (ResultSetMetaData) rs.getMetaData();
            int cantidadColumnas = rsMd.getColumnCount();

            //Asignando nombre a las columnas
            modelo.addColumn("Codigo");
            modelo.addColumn("Nombre");
            modelo.addColumn("Marca");
            modelo.addColumn("Cantidad");
            modelo.addColumn("Precio");

            
            //Llenando la tabla
            while (rs.next()) {
                Object[] filas = new Object[cantidadColumnas];

                for (int i = 0; i < cantidadColumnas; i++) {
                    filas[i] = rs.getObject(i + 1);
                }
                modelo.addRow(filas);
            }

        } catch (SQLException ex) {
            System.out.println(ex.toString());
        }
    }

}
