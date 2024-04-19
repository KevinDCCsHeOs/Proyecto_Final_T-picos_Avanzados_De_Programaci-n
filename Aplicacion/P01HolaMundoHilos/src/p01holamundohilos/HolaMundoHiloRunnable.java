/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package p01holamundohilos;

/**
 *
 * @author levij
 */
public class HolaMundoHiloRunnable implements Runnable{

    private String nombre;
    
    public HolaMundoHiloRunnable(String nombre){
        this.nombre=nombre;
    }
    
    @Override
    public void run() {
        for(int i = 0; i<=1000; i++){
            System.out.println("Hola soy el hilo: " + nombre + " voy en el ciclo:" + i);
        }
    }
    
}
