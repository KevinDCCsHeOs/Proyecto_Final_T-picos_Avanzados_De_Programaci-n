package p02pingpong;

public class Pang3 extends Thread{
    
    @Override
    public void run(){
        
        for(int i = 0; i <= 1000; i++){
            System.out.println("Pang");
            Thread.yield();
        }
        
    }
    
}
