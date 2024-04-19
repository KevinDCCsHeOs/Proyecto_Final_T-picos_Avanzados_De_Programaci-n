package p02pingpong;

public class Mensaje {
    
    private String mensaje;
    private boolean ocupado;
    
    public Mensaje(){
        this.mensaje = "Pang";
        this.ocupado = false;
    }
    
    public synchronized String getMesaje(){
        while(ocupado == true){
            try{
                wait();
            }
            catch(InterruptedException ie){
                
            }
        }
        ocupado = true;
        if(mensaje.compareTo("Ping") == 0)
            mensaje = "Pong";
        else if (mensaje.compareTo("Pong") == 0)
            mensaje="Pang";
        else 
            mensaje="Ping";
        ocupado=false;
        notify();
        return mensaje;
    }
    
}
