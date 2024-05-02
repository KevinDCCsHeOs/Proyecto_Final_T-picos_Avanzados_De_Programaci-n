package p04rebotes;

import javax.swing.JFrame;

public class P04Rebotes {

    public static void main(String[] args) {
        
        Pantalla pantalla = new Pantalla();
        pantalla.setSize(400,400);
        pantalla.setResizable(false);
        pantalla.setVisible(true);
        pantalla.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
    }
    
}
