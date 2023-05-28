
package Controlador;

import Vista.VentanaInicio;
import Vista.VentanaModificar;
import Vista.VentanaNuevo;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import DAO.InventarioDao;
import Modelo.MInventario;


public class CModificar implements ActionListener{
    private final InventarioDao Dao;
    private final MInventario Model;
    private final Vista.VentanaNuevo VN;
    private final Vista.VentanaInicio VI;
    private final Vista.VentanaModificar VM;

    public CModificar(InventarioDao Dao, MInventario Model, VentanaNuevo VN, VentanaInicio VI, VentanaModificar VM) {
        this.Dao = Dao;
        this.Model = Model;
        this.VN = VN;
        this.VI = VI;
        this.VM = VM;
        this.VM.Btn_Modificar.addActionListener(this);
        this.VM.Btn_Atras.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource().equals(VM.Btn_Modificar)){
                Model.setNombre(VM.txtNombre_Modificar.getText());
                Model.setMarca(VM.txtMarca_Modificar.getText());
                Model.setCantidad(Integer.parseInt(VM.txtCantidad_Modificar.getText()));
                Model.setPrecio(Integer.parseInt(VM.txtPrecio_Modificar.getText()));
                Model.setCodigo(Integer.parseInt(VM.LabelCod.getText()));
                if (Dao.Modificar(Model)) {
                    JOptionPane.showMessageDialog(null, "Datos modificados");
                    VI.Cargar_Tabla();
                    VI.setVisible(true);
                }
            }
            VM.dispose();
            
            
        if(e.getSource().equals(VM.Btn_Atras)){
            VentanaInicio ventanaInicio = new VentanaInicio();
            ventanaInicio.setVisible(true);
            VM.dispose();
        }
    }
}
