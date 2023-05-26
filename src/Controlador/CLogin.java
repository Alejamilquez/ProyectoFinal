
package Controlador;

import DAO.LoginDAO;
import Modelo.MLogin;
import Vista.Login;
import Vista.VentanaInicio;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CLogin implements ActionListener{
    
    private MLogin mlogin;
    private LoginDAO loginDAO;
    private Login login;

    public CLogin(MLogin mlogin, LoginDAO loginDAO, Login login) {
        this.mlogin = mlogin;
        this.loginDAO = loginDAO;
        this.login = login;
        this.login.Btn_Ingresar.addActionListener(this);
    }

    


    //@Override;
    
    public void actionPerformed(ActionEvent e) {
        if(e.getSource().equals(login.Btn_Ingresar)){
            mlogin.setCampoU(login.CampoUsuario.getText());
            mlogin.setCampoC(login.CampoContraseña.getPassword());
            
            if(loginDAO.Comprobar() == 1){
                VentanaInicio ventanaInicio = new VentanaInicio();
                ventanaInicio.setVisible(true);
                login.dispose();
            }
            
        }
    }
    
}
