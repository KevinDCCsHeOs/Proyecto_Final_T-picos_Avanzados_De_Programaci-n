package Bancoo;

public class EjecucionTransferencias implements Runnable{

    private Banco banco;
    private int delaCuenta;
    private double cantidadMax;
    
    public EjecucionTransferencias(Banco b, int de, double max){
        banco=b;
        delaCuenta=de;
        cantidadMax=max;
    }
    
    @Override
    public void run(){
        try{
            while(true){
                int paraLaCuenta = (int)(Math.random()*100);
                double cantidad = cantidadMax*Math.random();
                banco.transferencia(delaCuenta, paraLaCuenta, cantidad);
                Thread.sleep((int)(Math.random()*10));
            }
        }catch(InterruptedException e){ }
    }
    
}
