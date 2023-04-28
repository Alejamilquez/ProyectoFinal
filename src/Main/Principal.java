package Main;

import Controlador.CLogin;
import Modelo.MLogin;
import Vista.Login;

public class Principal {

    public static void main(String[] args) {
        Login login = new Login();
        MLogin mLogin = new MLogin(login);
        CLogin cLogin = new CLogin(login, mLogin);
        
        login.setVisible(true);
    }
}
