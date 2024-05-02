package TablasDB;

public class Descuentos {
    
    private int cveDescuento;
    private String tipoDescuento;
    private int porcentajeDescuento;

    public Descuentos(String tipoDescuento, int porcentajeDescuento) {
        this.tipoDescuento = tipoDescuento;
        this.porcentajeDescuento = porcentajeDescuento;
    }

    public int getCveDescuento() {
        return cveDescuento;
    }

    public String getTipoDescuento() {
        return tipoDescuento;
    }

    public void setTipoDescuento(String tipoDescuento) {
        this.tipoDescuento = tipoDescuento;
    }

    public int getPorcentajeDescuento() {
        return porcentajeDescuento;
    }

    public void setPorcentajeDescuento(int porcentajeDescuento) {
        this.porcentajeDescuento = porcentajeDescuento;
    }
    
    
    
}
