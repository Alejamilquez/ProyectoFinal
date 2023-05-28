
package Principal;

import Controlador.CLogin;
import DAO.LoginDAO;
import Modelo.Conexion;
import Modelo.MLogin;
import Vista.Login;
import Vista.VentanaInicio;

public class Main {
    
    public static void main(String[] args) {
        MLogin a = new MLogin();
        Login c = new Login();
        LoginDAO b = new LoginDAO(c);
        CLogin d = new CLogin(a,b,c);
        Conexion e = Conexion.getInstance();
        VentanaInicio f = new VentanaInicio();
        
        
        c.setVisible(true);
    }
 

    /*public static void main(String[] args) {
        Login login = new Login();
        
        login.setVisible(true);
    }
    */
}
