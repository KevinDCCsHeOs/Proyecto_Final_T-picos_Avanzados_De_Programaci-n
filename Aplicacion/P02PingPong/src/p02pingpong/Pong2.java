package p02pingpong;

public class Pong2 extends Thread{
    
    @Override
    public void run(){
        for (int i = 0; i <= 1000; i++){
            System.out.println("Pong");
            try{
                sleep(10);
            }
            catch (InterruptedException e){}
        }
    }
    
}
