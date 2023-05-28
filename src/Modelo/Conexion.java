
package Modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {
    
    
    private Conexion(){
    }
    
    //varible en la cual se guarda el estado de la conexion de la base de datos
    private static Connection conexion;
    
    //variable para crear una sola instancia
    private static Conexion instancia;
    
    //variable para conectar a la base de datos
    private String url ="jdbc:mysql://localhost/proyectofinal";
    private String usuario = "root";
    private String contraseña = "12345";
    
    //metodo para conectar a la base de datos
    public Connection conectar(){
        
        Connection conexion = null;
        
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conexion = DriverManager.getConnection(url, usuario, contraseña);
            System.out.println("Conexion exitosa");
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("Error conexion" + e);
        }
        return conexion;
    }

    
    /*patron singleton
        - Este patron nos certifica que solo se instancia una vez la conexion evitando multiples conexiones
        - Al tener una sola instancia permite ahorrar recursos del sistema como por ejmplo memoria o tiempo en CPU
        - Al utlizar Singleton la instancia de la conexion se vuelve global lo cual hace que se puede acceder a ella desde 
        cualquier parte del programa
    */
    public static Conexion getInstance(){
        if(instancia == null){
            instancia = new Conexion();
        }
        return  instancia;
    }
}