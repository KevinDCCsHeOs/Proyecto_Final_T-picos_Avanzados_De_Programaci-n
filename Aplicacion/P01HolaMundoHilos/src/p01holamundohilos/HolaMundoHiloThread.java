package p01holamundohilos;

import java.util.Random;

public class HolaMundoHiloThread  extends Thread{
    
    private String nombre;
    
    public HolaMundoHiloThread(String nombre){
        this.nombre=nombre;
    }
    
    @Override
    public void run(){
        int num = new Random().nextInt(11);
        for(int i = 0; i <= num; i++){
            System.out.println("Hola soy el hilo: " + nombre + " voy en el ciclo:" + i);
        }
    }
    
}
