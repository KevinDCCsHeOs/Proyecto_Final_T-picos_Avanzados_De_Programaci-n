package p02pingpong;

public class Ping1 extends Thread{
    
    @Override
    public void run(){
        for (int i = 0; i<=1000; i++){
            System.out.println("Ping");
        }
    }
    
}
