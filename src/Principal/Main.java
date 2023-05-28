
package Principal;

import Controlador.CLogin;
import DAO.LoginDAO;
import Modelo.Conexion;
import Modelo.MLogin;
import Vista.Login;
import Vista.VentanaInicio;
import Vista.VentanaModificar;
import Vista.VentanaNuevo;
import Controlador.CNuevo;
import Modelo.MInventario;
import Controlador.CInicio;
import DAO.InventarioDao;
import Controlador.*;

public class Main {
    
    public static void main(String[] args) {
        MLogin a = new MLogin();
        Login c = new Login();
        LoginDAO b = new LoginDAO(c);
        CLogin d = new CLogin(a,b,c);
        Conexion e = new Conexion();
        VentanaInicio f = new VentanaInicio();
        /*VentanaNuevo VN = new VentanaNuevo();
        VentanaModificar VM = new VentanaModificar();
        MInventario MI = new MInventario();
        InventarioDao ID = new InventarioDao();
        CInicio cI = new CInicio(VI, VM , VN , ID, MI);
        CNuevo cN = new CNuevo(MI, ID, VI, VN);
        CModificar cM = new CModificar(ID, MI, VN, VI, VM);*/
        
        
        
        
        c.setVisible(true);
    }
 

    /*public static void main(String[] args) {
        Login login = new Login();
        
        login.setVisible(true);
    }
    */
}
