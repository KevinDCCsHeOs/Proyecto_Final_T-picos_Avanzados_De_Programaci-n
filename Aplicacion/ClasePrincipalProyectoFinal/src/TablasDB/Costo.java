package TablasDB;

public class Costo {
    
    private int cveCosto;
    private int cveMDT;
    private int costo;
    private String extras;
    private int costoExtras;
    private int cveDescuento;
    private int total;

    public Costo(int cveMDT, int costo, String extras, int costoExtras, int cveDescuento, int total) {
        this.cveMDT = cveMDT;
        this.costo = costo;
        this.extras = extras;
        this.costoExtras = costoExtras;
        this.cveDescuento = cveDescuento;
        this.total = total;
    }

    public int getCveCosto() {
        return cveCosto;
    }

    public int getCveMDT() {
        return cveMDT;
    }

    public void setCveMDT(int cveMDT) {
        this.cveMDT = cveMDT;
    }

    public int getCosto() {
        return costo;
    }

    public void setCosto(int costo) {
        this.costo = costo;
    }

    public String getExtras() {
        return extras;
    }

    public void setExtras(String extras) {
        this.extras = extras;
    }

    public int getCostoExtras() {
        return costoExtras;
    }

    public void setCostoExtras(int costoExtras) {
        this.costoExtras = costoExtras;
    }

    public int getCveDescuento() {
        return cveDescuento;
    }

    public void setCveDescuento(int cveDescuento) {
        this.cveDescuento = cveDescuento;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }
    
    
    
}
