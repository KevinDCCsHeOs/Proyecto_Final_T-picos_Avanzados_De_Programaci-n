package practica1bd;

import java.sql.*;

public class Practica1BD {

    public static void main(String[] args) {
        
        String connectString = "jdbc:postgresql://localhost:5432/Tienda";
        String user = "postgres";
        String password = "1234";
        
        try {
            Connection miConexion = DriverManager.getConnection(connectString,user,password);
            Statement miStatement = miConexion.createStatement();
            ResultSet miResultSet = miStatement.executeQuery("SELECT * FROM productos");
            while(miResultSet.next())
                System.out.println(miResultSet.getInt("id_producto") + " " +
                        miResultSet.getString("descripcion") + " "+
                        miResultSet.getInt("precio_introductor") + " " + 
                        miResultSet.getInt("precio_detallista") + " " + 
                        miResultSet.getInt("tipo_producto") + " " + 
                        miResultSet.getString("unidad_medida"));
        }catch(Exception e){
            System.out.println("¡¡No conecta!!");
            e.printStackTrace();
        }
        
    }
    
}
