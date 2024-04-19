package p02pingpong;

public class P02PingPong {
    
    public static void main(String[] args) {
        
        /*Ping1 ping1 = new Ping1();
        Pong1 pong1 = new Pong1();
        Pang1 pang1 = new Pang1();
        
        ping1.start();
        pong1.start();
        pang1.start();*/
        
        /*Ping2 ping2 = new Ping2();
        Pong2 pong2 = new Pong2();
        Pang2 pang2 = new Pang2();
        
        ping2.start();
        pong2.start();
        pang2.start();*/
        
        /*Ping3 ping3 = new Ping3();
        Pong3 pong3 = new Pong3();
        Pang3 pang3 = new Pang3();
        
        ping3.start();
        pong3.start();
        pang3.start();*/
        
        Mensaje m = new Mensaje();
        Ping4 ping4 = new Ping4(m);
        Pong4 pong4 = new Pong4(m);
        Pang4 pang4 = new Pang4(m);
        
        ping4.start();
        pong4.start();
        pang4.start();
        
    }
    
}
