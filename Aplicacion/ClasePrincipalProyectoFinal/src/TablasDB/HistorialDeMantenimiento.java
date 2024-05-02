package TablasDB;

public class HistorialDeMantenimiento {
    
    private int cveHDV;
    private int cveMDT;
    private String fecha;
    private String reparaciones;
    private String costosAsociados;

    public HistorialDeMantenimiento(int cveMDT, String fecha, String reparaciones, String costosAsociados) {
        this.cveMDT = cveMDT;
        this.fecha = fecha;
        this.reparaciones = reparaciones;
        this.costosAsociados = costosAsociados;
    }

    public int getCveHDV() {
        return cveHDV;
    }

    public int getCveMDT() {
        return cveMDT;
    }

    public void setCveMDT(int cveMDT) {
        this.cveMDT = cveMDT;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getReparaciones() {
        return reparaciones;
    }

    public void setReparaciones(String reparaciones) {
        this.reparaciones = reparaciones;
    }

    public String getCostosAsociados() {
        return costosAsociados;
    }

    public void setCostosAsociados(String costosAsociados) {
        this.costosAsociados = costosAsociados;
    }
    
    
    
}
