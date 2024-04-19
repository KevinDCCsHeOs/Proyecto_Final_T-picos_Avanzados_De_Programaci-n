package p01holamundohilos;

public class Principal {
    
    public static void main(String[] args) {
        
        HolaMundoHiloThread h1 = new HolaMundoHiloThread("Hilo 1");
        HolaMundoHiloThread h2 = new HolaMundoHiloThread("Hilo 2");
        HolaMundoHiloThread h3 = new HolaMundoHiloThread("Hilo 3");
        HolaMundoHiloThread h4 = new HolaMundoHiloThread("Hilo 4");
        HolaMundoHiloThread h5 = new HolaMundoHiloThread("Hilo 5");
        
        h1.start();
        h2.start();
        h3.start();
        h4.start();
        h5.start();
        
        /*HolaMundoHiloRunnable h1 = new HolaMundoHiloRunnable("Hilo 1");
        HolaMundoHiloRunnable h2 = new HolaMundoHiloRunnable("Hilo 2");
        HolaMundoHiloRunnable h3 = new HolaMundoHiloRunnable("Hilo 3");
        
        new Thread(h1).start();
        new Thread(h2).start();
        new Thread(h3).start();*/
        
    }
    
}
