package DAO;

import Modelo.Conexion;
import Modelo.MReporte;
import java.io.File;
import java.io.FileOutputStream;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.JFileChooser;
import java.sql.Connection;
import javax.swing.JOptionPane;

public class ReporteDAO{

    private MReporte m;

    JFileChooser seleccionar = new JFileChooser();
    File archivo;
    FileOutputStream salida;
    ArrayList<String> datos = new ArrayList<>();
    StringBuilder linea = new StringBuilder(); //es una varibla tipo String la cual es posible modificar
    Conexion c = Conexion.getInstance();
    Connection con = c.conectar();

    ///////////////////////////////////////////////////////////////////////////////////////////////////////
    public void reporte() {
        String sql = "SELECT Codigo, Nombre, Marca, Cantidad, Precio FROM inventario WHERE Cantidad<=10";

        String k = "Reporte de los productos agotados o proximos a agotarsen\n";
        datos.add(k);
        
        try {
            PreparedStatement ps = con.prepareCall(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                m = new MReporte();
                m.setCodigo(rs.getInt("Codigo"));
                m.setNombre(rs.getString("Nombre"));
                m.setMarca(rs.getString("Marca"));
                m.setCantidad(rs.getInt("Cantidad"));
                m.setPrecio(rs.getInt("Precio"));
                String dato = m.getCodigo() + " " + m.getNombre() + " " + m.getMarca() + " " + m.getCantidad() + " " + m.getPrecio() + "\n";
                datos.add(dato);
            }
            for (int i = 0; i < datos.size(); i++) {
                linea.append(datos.get(i));
            }
            //System.out.println(linea.toString());
            escribir(linea.toString());

        } catch (Exception e) {
            System.out.println("Error extraer datos");
        }

    }

    ///////////////////////////////////////////////////////////////////////////////////////////////////////
    public void escribir(String linea) {
        String mensaje=null;
        if (seleccionar.showDialog(null, "Guardar") == JFileChooser.APPROVE_OPTION) {
            archivo = seleccionar.getSelectedFile();
            if (archivo.getName().endsWith("txt")) {
                String d = linea;
                mensaje = guardar(archivo, d);
            }
            if (mensaje != null) {
                    JOptionPane.showMessageDialog(null, mensaje);
                }else{
                    JOptionPane.showMessageDialog(null, "Archivo no compatible");
                }
        }
    }

    ///////////////////////////////////////////////////////////////////////////////////////////////////////
    public String guardar(File archivo, String d) {
        String mensaje;
        try {
            salida = new FileOutputStream(archivo);
            byte[] bytxt = d.getBytes();
            salida.write(bytxt);
            mensaje = "Archivo guardado";
        } catch (Exception e) {
            mensaje = null;
        }
        return mensaje;
    }

}
