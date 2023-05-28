
package DAO;

import javax.swing.JOptionPane;
import Vista.Login;

public class LoginDAO {
    
    private Login login;

    public LoginDAO(Login login) {
        this.login = login;
    }
    
    
    String Usuario = "Administrador";
    String Contraseña = "12345";
    
    public int Comprobar(){
        
        int a=0;
        String Us = new String(login.CampoUsuario.getText());
        String Pass = new String(login.CampoContraseña.getPassword());
        
        if (Us.equals(Usuario) && Pass.equals(Contraseña)) {
            a=1;
        } else {
            JOptionPane.showMessageDialog(null, "Usuario o contaseña incorrecto");
            a=0;
        }
        return a;
    }
}
