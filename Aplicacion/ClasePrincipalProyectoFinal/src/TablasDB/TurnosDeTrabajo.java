package TablasDB;

public class TurnosDeTrabajo {
    
    private int cveTurno;
    private String turno;
    private String horaES;
    
    public TurnosDeTrabajo(){}

    public TurnosDeTrabajo(int cveTurno, String turno, String horaES) {
        this.cveTurno = cveTurno;
        this.turno = turno;
        this.horaES = horaES;
    }
    
    public TurnosDeTrabajo(String turno, String horaES) {
        this.turno = turno;
        this.horaES = horaES;
    }
    
    public int getCveTurno(){
        return cveTurno;
    }
    
    public String getTurno() {
        return turno;
    }

    public void setTurno(String turno) {
        this.turno = turno;
    }

    public String getHoraES() {
        return horaES;
    }

    public void setHoraES(String horaES) {
        this.horaES = horaES;
    }
    
}
