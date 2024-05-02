package examenunidad4;

public class Atleta extends Thread{
    
    private String n;
    
    public Atleta(String n){
        this.n=n;
    }
    
    @Override
    public void run(){
        System.out.println("comienza " + n);
        for(int i = 1; i <= 50; i++){
            System.out.println(n + " en el metro numero " + i);
        }
        System.out.println("Termina " + n);
    }
    
}
