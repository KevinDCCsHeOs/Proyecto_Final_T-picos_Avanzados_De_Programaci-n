package TablasDB;

public class Reservaciones {
    
    private int cveReservacion;
    private int cveMDT;
    private int numeroAsiento;
    private int cveHora;
    private int cveLugar;
    private int cveCosto;
    private String fecha;
    private int cveRuta;
    private int folioEmpleado;
    private int numeroFactura;
    private int cveUsuario;

    public Reservaciones(int cveMDT, int numeroAsiento, int cveHora, int cveLugar, int cveCosto, String fecha, int cveRuta, int folioEmpleado, int numeroFactura, int cveUsuario) {
        this.cveMDT = cveMDT;
        this.numeroAsiento = numeroAsiento;
        this.cveHora = cveHora;
        this.cveLugar = cveLugar;
        this.cveCosto = cveCosto;
        this.fecha = fecha;
        this.cveRuta = cveRuta;
        this.folioEmpleado = folioEmpleado;
        this.numeroFactura = numeroFactura;
        this.cveUsuario = cveUsuario;
    }

    public int getCveReservacion() {
        return cveReservacion;
    }

    public int getCveMDT() {
        return cveMDT;
    }

    public void setCveMDT(int cveMDT) {
        this.cveMDT = cveMDT;
    }

    public int getNumeroAsiento() {
        return numeroAsiento;
    }

    public void setNumeroAsiento(int numeroAsiento) {
        this.numeroAsiento = numeroAsiento;
    }

    public int getCveHora() {
        return cveHora;
    }

    public void setCveHora(int cveHora) {
        this.cveHora = cveHora;
    }

    public int getCveLugar() {
        return cveLugar;
    }

    public void setCveLugar(int cveLugar) {
        this.cveLugar = cveLugar;
    }

    public int getCveCosto() {
        return cveCosto;
    }

    public void setCveCosto(int cveCosto) {
        this.cveCosto = cveCosto;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public int getCveRuta() {
        return cveRuta;
    }

    public void setCveRuta(int cveRuta) {
        this.cveRuta = cveRuta;
    }

    public int getFolioEmpleado() {
        return folioEmpleado;
    }

    public void setFolioEmpleado(int folioEmpleado) {
        this.folioEmpleado = folioEmpleado;
    }

    public int getNumeroFactura() {
        return numeroFactura;
    }

    public void setNumeroFactura(int numeroFactura) {
        this.numeroFactura = numeroFactura;
    }

    public int getCveUsuario() {
        return cveUsuario;
    }

    public void setCveUsuario(int cveUsuario) {
        this.cveUsuario = cveUsuario;
    }
    
}
