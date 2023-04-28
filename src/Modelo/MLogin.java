package Modelo;

import Vista.Login;
import Vista.VentanaInicio;
import javax.swing.JOptionPane;

public class MLogin {

    private Login login;
    //private Login login;
    String Usuario = "Administrador";
    String Contraseña = "123456";

    public MLogin(Login login) {
        this.login = login;
    }


    public void Comprobar() {

        String Pass = new String(login.CampoContraseña.getPassword());
        String Us = new String(login.CampoUsuario.getText());

        if (Us.equals(Usuario) && Pass.equals(Contraseña)) {
            VentanaInicio ventana1 = new VentanaInicio();
            ventana1.setVisible(true);
            login.dispose();
        } else {
            JOptionPane.showMessageDialog(null, "Usuario o contaseña incorrecto");
        }
    }
}
