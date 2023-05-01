
package Controlador;

import Modelo.MTabla;
import Vista.VentanaInicio;
import Vista.VentanaNuevo;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CVentanaInicio implements ActionListener{
    
    private VentanaInicio ventanaInicio;
    private MTabla mTabla;
    private VentanaNuevo ventanaNuevo;

    public CVentanaInicio(VentanaInicio ventanaInicio, MTabla mTabla, VentanaNuevo ventanaNuevo) {
        this.ventanaInicio = ventanaInicio;
        this.mTabla = mTabla;
        this.ventanaNuevo = ventanaNuevo;
        this.ventanaInicio.Btn_Cargar.addActionListener(this);
        this.ventanaInicio.Btn_Nuevo.addActionListener(this);
    }

    
    @Override
    public void actionPerformed(ActionEvent i) {
        
        if (i.getSource() == ventanaInicio.Btn_Cargar) {
            System.out.println("55555555");
            mTabla.CargarTabla();
        }
        
        if (i.getSource() == ventanaInicio.Btn_Salir) {
            System.out.println("hsiena d");
            //ventanaNuevo.setVisible(true);
            ventanaInicio.dispose();
        }
        
        if (i.getSource() == ventanaInicio.Btn_Salir) {
            System.out.println("saliendo...");
            ventanaInicio.dispose();
        }
    }
}
