package TablasDB;

public class HorariosSalida {
    
    private int cveHora;
    private String hora;

    public HorariosSalida(String hora) {
        this.hora = hora;
    }
    
    public int getCveHora(){
        return cveHora;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }
    
}
