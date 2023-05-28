
package DAO;

import Modelo.Conexion;
import java.sql.PreparedStatement;
import java.sql.*;
import Modelo.MInventario;
import Vista.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;


public class InventarioDao{
    Conexion c = Conexion.getInstance();
    Connection con = c.conectar();
    
    //INSERTAR
    public boolean Insertar(MInventario Inv) {
       String sql = "Insert into inventario (Codigo, Nombre, Marca, Cantidad, Precio) values (?, ?, ?, ?, ?)";
       
        try{
            MInventario insertar = (MInventario) Inv;
            
            PreparedStatement statement;
            statement = con.prepareStatement(sql);
            
            statement.setString(1, insertar.getCodigo()+ "");
            statement.setString(2, insertar.getNombre());
            statement.setString(3, insertar.getMarca() );
            statement.setString(4, insertar.getCantidad()+"");
            statement.setString(5, insertar.getPrecio()+"");
            
            statement.executeUpdate();
            
            statement.close();
            con.close();
            return true;
        } catch(SQLException ex){
            System.out.println("Error" + ex.getMessage());
            return false;
        }
    }
    
    
    //MODIFICAR
    public boolean Modificar(MInventario inv) {
        String sql = "UPDATE inventario SET Nombre = ?, Marca = ?, Cantidad = ?, Precio = ?  WHERE Codigo = ?";
       
        try{
            MInventario Modificar = (MInventario) inv;
            
            PreparedStatement statement;
            statement = con.prepareStatement(sql);
            
            statement.setString(1, Modificar.getNombre());
            statement.setString(2, Modificar.getMarca());
            statement.setString(3, Modificar.getCantidad() + "");
            statement.setString(4, Modificar.getPrecio()+"");
            statement.setString(5, Modificar.getCodigo()+"");
                    
            statement.executeUpdate();
            return true;
        } catch(Exception ex){
            System.out.println("Error" + ex.getMessage());
            return false;
        }
    }
    

    //ELIMINAR
    public void Eliminar(int fila){
        VentanaInicio VI = new VentanaInicio();
        try {
            String valor = VI.Tabla.getValueAt(fila, 0).toString();

            PreparedStatement eliminar = con.prepareStatement("DELETE FROM inventario WHERE Codigo = '" + valor + "'");
            eliminar.executeUpdate();
            JOptionPane.showMessageDialog(null, "Dato eliminado");
        } catch (SQLException ex) {
            Logger.getLogger(VentanaInicio.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    /*public void Campos(int fila) {
        VentanaModificar VM = new VentanaModificar();
        VentanaInicio VI = new VentanaInicio();
        VM.LabelCod.setText(VI.Tabla.getValueAt(fila, 0).toString());
        VM.txtNombre_Modificar.setText(VI.Tabla.getValueAt(fila, 1).toString());
        VM.txtMarca_Modificar.setText(VI.Tabla.getValueAt(fila, 2).toString());
        VM.txtCantidad_Modificar.setText(VI.Tabla.getValueAt(fila, 3).toString());
        VM.txtPrecio_Modificar.setText(VI.Tabla.getValueAt(fila, 4).toString());           
    }*/

}
