package TablasDB;

public class Pagos {
    
    private int numeroFactura;
    private String fechaDePago;
    private String metodoDePago;
    private int importePagado;
    private String estadoDePago;

    public Pagos(int numeroFactura, String fechaDePago, String metodoDePago, int importePagado, String estadoDePago) {
        this.numeroFactura = numeroFactura;
        this.fechaDePago = fechaDePago;
        this.metodoDePago = metodoDePago;
        this.importePagado = importePagado;
        this.estadoDePago = estadoDePago;
    }

    public int getNumeroFactura() {
        return numeroFactura;
    }

    public void setNumeroFactura(int numeroFactura) {
        this.numeroFactura = numeroFactura;
    }

    public String getFechaDePago() {
        return fechaDePago;
    }

    public void setFechaDePago(String fechaDePago) {
        this.fechaDePago = fechaDePago;
    }

    public String getMetodoDePago() {
        return metodoDePago;
    }

    public void setMetodoDePago(String metodoDePago) {
        this.metodoDePago = metodoDePago;
    }

    public int getImportePagado() {
        return importePagado;
    }

    public void setImportePagado(int importePagado) {
        this.importePagado = importePagado;
    }

    public String getEstadoDePago() {
        return estadoDePago;
    }

    public void setEstadoDePago(String estadoDePago) {
        this.estadoDePago = estadoDePago;
    }
    
}
