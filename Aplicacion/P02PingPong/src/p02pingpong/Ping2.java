package p02pingpong;

public class Ping2 extends Thread{
    
    @Override
    public void run(){
        for (int i = 0; i <= 1000; i++){
            System.out.println("Ping");
            try{
                sleep(10);
            }
            catch (InterruptedException e){}
        }
    }
    
}
