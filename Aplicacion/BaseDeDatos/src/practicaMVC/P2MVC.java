package practicaMVC;

public class P2MVC {
    
    public static void main(String[] args) {
        
        new BaseDatos("Tienda");
        View vista = new View();
        Controler  controlador = new Controler(vista);
        vista.conectaControlador(controlador);
        
    }
    
}
