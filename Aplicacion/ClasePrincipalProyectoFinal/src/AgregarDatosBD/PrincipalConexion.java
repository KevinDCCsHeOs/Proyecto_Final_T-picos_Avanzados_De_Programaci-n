package AgregarDatosBD;

public interface PrincipalConexion {
    
    static final String URL = "jdbc:mysql://127.0.0.1:3306/basededatosprincipal?user=root";
    static final String USER = "root";
    static final String PASSWORD = "R4ns0mw4r3";
    
    public void agregar(Object obj);
    
}
