
package Controlador;

import DAO.InventarioDao;
import Vista.VentanaInicio;
import Vista.VentanaModificar;
import Vista.VentanaNuevo;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;



public class CInicio implements ActionListener{
    private final Vista.VentanaInicio VI;
    private final Vista.VentanaModificar VM;
    private final Vista.VentanaNuevo VN;
    private final DAO.InventarioDao Dao;

    public CInicio(VentanaInicio VI, VentanaModificar VM, VentanaNuevo VN, InventarioDao Dao) {
        this.VI = VI;
        this.VM = VM;
        this.VN = VN;
        this.Dao = Dao;
        this.VI.Btn_Nuevo.addActionListener(this);
        this.VI.Btn_Eliminar.addActionListener(this);
        this.VI.Btn_Modificar.addActionListener(this);
        this.VI.Btn_Salir.addActionListener(this);
    }

    

    @Override
    public void actionPerformed(ActionEvent evt) {
        if (evt.getSource().equals(VI.Btn_Nuevo)) {
            VN.setVisible(true);
            VI.dispose();
        }
        
        
        if (evt.getSource().equals(VI.Btn_Eliminar)) {
            int fila = VI.Tabla.getSelectedRow();

            if (fila == -1) {
                JOptionPane.showMessageDialog(null, "No se selecciono ninguna fila");
            } else {
                Dao.Eliminar(fila);
                VI.Cargar_Tabla();
            }
        }
        
        
        if (evt.getSource().equals(VI.Btn_Modificar)) {
            int fila = VI.Tabla.getSelectedRow();

            if (fila == -1) {
                JOptionPane.showMessageDialog(null, "No se selecciono ninguna fila");
            } else {
                VM.setVisible(true);
                VI.Campos(fila);
                VI.dispose();
            }
            //VM.setVisible(true);
            //VI.dispose();
        }
        if (evt.getSource().equals(VI.Btn_Salir)) {
            System.exit(0);
        }
    }
    
    
    
}
