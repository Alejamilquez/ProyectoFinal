
package DAO;

import Modelo.Conexion;
import Vista.VentanaInicio;
import com.mysql.cj.jdbc.result.ResultSetMetaData;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.table.DefaultTableModel;

public class BuscarDAO {
    
    private VentanaInicio VI;
    Conexion c = Conexion.getInstance();

    public BuscarDAO(VentanaInicio VI) {
        this.VI = VI;
    }
    
    
    public void buscar(){
        try {
            DefaultTableModel modelo = new DefaultTableModel();
            VI.Tabla.setModel(modelo);
            String cadena = VI.txtBuscar.getText();

            PreparedStatement ps = null;
            ResultSet rs = null;
            Connection con = c.conectar();

            //Busca columnas y la tabla de la base de datos
            String cadenaCompleta = "SELECT * FROM inventario where Codigo like'" + "%" + cadena + "%'";
            ps = con.prepareStatement(cadenaCompleta);
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
