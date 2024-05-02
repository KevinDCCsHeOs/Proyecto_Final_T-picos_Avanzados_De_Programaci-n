package TablasDB;

public class EmpleadoTurno {
    
    private int folioEmpleado;
    private int cveTurno;

    public EmpleadoTurno(int folioEmpleado, int cveTurno) {
        this.folioEmpleado = folioEmpleado;
        this.cveTurno = cveTurno;
    }

    public int getFolioEmpleado() {
        return folioEmpleado;
    }

    public void setFolioEmpleado(int folioEmpleado) {
        this.folioEmpleado = folioEmpleado;
    }

    public int getCveTurno() {
        return cveTurno;
    }

    public void setCveTurno(int cveTurno) {
        this.cveTurno = cveTurno;
    }
    
}
