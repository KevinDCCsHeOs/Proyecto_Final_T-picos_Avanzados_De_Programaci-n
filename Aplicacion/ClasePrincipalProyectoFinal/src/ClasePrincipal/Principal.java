package ClasePrincipal;

import InterfacesGraficas.Login;
import java.awt.Toolkit;
import java.awt.Dimension;
import javax.swing.JFrame;

public class Principal {
    
    public static void main(String[] args) {
        
        Login log = new Login();
        log.setLocationRelativeTo(null); // Para que se posicione en el centro de la pantalla
        log.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        log.setVisible(true);
        log.setResizable(false);
        
    }
    
}
