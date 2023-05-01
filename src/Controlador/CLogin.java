
package Controlador;

import Modelo.MLogin;
import Vista.Login;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CLogin implements ActionListener {

    private Login login;
    private MLogin mLogin;

    public CLogin(Login login, MLogin mLogin) {
        this.login = login;
        this.mLogin = mLogin;
        this.login.Btn_Ingresar.addActionListener(this);
    }
    
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == login.Btn_Ingresar) {
            mLogin.Comprobar();
        }
    }
    
}
