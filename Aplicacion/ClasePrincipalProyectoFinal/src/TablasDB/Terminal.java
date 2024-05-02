package TablasDB;

public class Terminal {
    
    private int cveLugar;
    private String nombreLugar;

    public Terminal(String nombreLugar) {
        this.nombreLugar = nombreLugar;
    }

    public int cveLugar(){
        return cveLugar;
    }
    
    public String getNombreLugar() {
        return nombreLugar;
    }

    public void setNombreLugar(String nombreLugar) {
        this.nombreLugar = nombreLugar;
    }
    
}
