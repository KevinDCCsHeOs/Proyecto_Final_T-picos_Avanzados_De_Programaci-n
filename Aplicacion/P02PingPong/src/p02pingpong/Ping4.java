package p02pingpong;

public class Ping4 extends Thread{
    
    Mensaje men;
    
    public Ping4(Mensaje men){
        this.men = men;
    }
    
    @Override
    public void run(){
        for(int i = 0; i<=1000; i++)
            System.out.println(men.getMesaje());
    }
    
}
