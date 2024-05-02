package p04rebotes;

import java.awt.*;
import java.util.Random;

public class Pelota {
    
    private int x;
    private int y;
    private Color color;
    private int dx;
    private int dy;
    
    public Pelota(){
        Random rnd = new Random();
        x = rnd.nextInt(400);
        y = rnd.nextInt(400);
        color = new Color(rnd.nextInt(255),
                rnd.nextInt(255),
                rnd.nextInt(255));
        if (rnd.nextInt(2)==0)
            dx=1;
        else 
            dx=-1;
        if (rnd.nextInt(2)==0)
            dy=1;
        else 
            dy=-1;
    }
    
    public void Pinta(Graphics g) throws InterruptedException{
        if (x>375) dx=-1;
        if (x<25) dx=1;
        if (y>375) dy=-1;
        if (y<25) dy=1;
        Random rnd = new Random();
        x= x + dx;
        y= y + dy;
        g.setColor(new Color(rnd.nextInt(255),
                rnd.nextInt(255),
                rnd.nextInt(255)));
        g.drawOval(x, y, 25, 25);
        g.fillOval(x, y, 25, 25);
        //Thread.sleep((int)(Math.random()*10));
    }
    
}
