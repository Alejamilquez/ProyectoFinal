package Main;

import Controlador.CLogin;
import Controlador.CVentanaInicio;
import Modelo.MLogin;
import Modelo.MTabla;
import Vista.Login;
import Vista.VentanaInicio;
import Vista.VentanaNuevo;

public class Principal {

    public static void main(String[] args) {
        Login login = new Login();
        MLogin mLogin = new MLogin(login);
        MTabla mTabla = new MTabla();
        VentanaNuevo ventanaNuevo = new VentanaNuevo();
        VentanaInicio ventanaInicio = new VentanaInicio();
        CLogin cLogin = new CLogin(login, mLogin);
        CVentanaInicio cVentanaInicio = new CVentanaInicio(ventanaInicio, mTabla, ventanaNuevo);
        
        ventanaInicio.setVisible(true);
    }
}
