package Prueba_Empleado;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class BaseDeDatosEmpleados {
    
    private String maquina = "127.0.0.1";
    private String user = "postgres";
    private String password = "1234";
    private int puerto = 5432;
    private String servidor = "";
    private static Connection conexion = null;
    
    public BaseDeDatosEmpleados(String nombreBase){
        this.servidor = "jdbc:postgresql://" + this.maquina + ":" + this.puerto + "/"+nombreBase;
        try{
            Connection miConexion = DriverManager.getConnection(this.servidor, user, password);
        }catch (Exception e){
            System.out.println("ERROR AL REGISTRAR EL DRIVER");
            System.exit(0);
        }
        try{
            conexion = DriverManager.getConnection(this.servidor, this.user, this.password);
        }catch(SQLException e){
            System.out.println("ERROR AL CONCETAR CON EL SERVIDOR");
            System.exit(0);
        }
        System.out.println("CONECTADO A " + nombreBase);
    }
    
    public static Connection getConexion(){
        return conexion;
    }
    
}
