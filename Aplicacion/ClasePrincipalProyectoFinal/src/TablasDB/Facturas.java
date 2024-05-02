package TablasDB;

public class Facturas {
    
    private int numeroFactura;
    private String fechaEmision;
    private int cveUsuario;
    private double importeTotal;
    private String estadoDeFactura;

    public Facturas(String fechaEmision, int cveUsuario, double importeTotal, String estadoDeFactura) {
        this.fechaEmision = fechaEmision;
        this.cveUsuario = cveUsuario;
        this.importeTotal = importeTotal;
        this.estadoDeFactura = estadoDeFactura;
    }

    public int getNumeroFactura(){
        return numeroFactura;
    }
    
    public String getFechaEmision() {
        return fechaEmision;
    }

    public void setFechaEmision(String fechaEmision) {
        this.fechaEmision = fechaEmision;
    }

    public int getCveUsuario() {
        return cveUsuario;
    }

    public void setCveUsuario(int cveUsuario) {
        this.cveUsuario = cveUsuario;
    }

    public double getImporteTotal() {
        return importeTotal;
    }

    public void setImporteTotal(double importeTotal) {
        this.importeTotal = importeTotal;
    }

    public String getEstadoDeFactura() {
        return estadoDeFactura;
    }

    public void setEstadoDeFactura(String estadoDeFactura) {
        this.estadoDeFactura = estadoDeFactura;
    }
    
}
