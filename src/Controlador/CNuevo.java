
package Controlador;

import DAO.InventarioDao;
import Modelo.MInventario;
import Vista.Login;
import Vista.VentanaInicio;
import Vista.VentanaModificar;
import Vista.VentanaNuevo;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;


public class CNuevo implements ActionListener{
    
    private final Modelo.MInventario Model;
    private final DAO.InventarioDao DAO;
    private final Vista.VentanaInicio VI;
    private final Vista.VentanaNuevo VN;

    public CNuevo(MInventario Model, InventarioDao DAO, VentanaInicio VI, VentanaNuevo VN) {
        this.Model = Model;
        this.DAO = DAO;
        this.VI = VI;
        this.VN = VN;
        this.VN.Btn_Insertar.addActionListener(this);
        this.VN.Btn_Atras.addActionListener(this);
    }
    
    

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource().equals(VN.Btn_Insertar)){
            Model.setCodigo(Integer.parseInt(VN.TxtCodigo_Nuevo.getText()));
            Model.setNombre(VN.TxtNombre_Nuevo.getText());
            Model.setMarca(VN.TxtMarca_Nuevo.getText());
            Model.setCantidad(Integer.parseInt(VN.TxtCantidad_Nuevo.getText()));
            Model.setPrecio(Integer.parseInt(VN.TxtPrecio_Nuevo.getText()));

            if(DAO.Insertar(Model)){
                JOptionPane.showMessageDialog(null, "Datos registrados");
                VentanaInicio ventanaInicio = new VentanaInicio();
                ventanaInicio.setVisible(true);
            }
            VN.dispose();
        }
        if(e.getSource().equals(VN.Btn_Atras)){
            VentanaInicio ventanaInicio = new VentanaInicio();
            ventanaInicio.setVisible(true);
            VN.dispose();
        }
    }
    
    
}
