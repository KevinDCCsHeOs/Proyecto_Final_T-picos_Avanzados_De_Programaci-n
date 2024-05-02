package TablasDB;

public class Rutas {
    
    private int cveRutas;
    private String distancia;
    private int puntoOrigen;
    private int puntoDestino;
    private String duracionEstimada;
    private String paradasIntermedias;

    public Rutas(String distancia, int puntoOrigen, int puntoDestino, String duracionEstimada, String paradasIntermedias) {
        this.distancia = distancia;
        this.puntoOrigen = puntoOrigen;
        this.puntoDestino = puntoDestino;
        this.duracionEstimada = duracionEstimada;
        this.paradasIntermedias = paradasIntermedias;
    }

    public int getCveRutas(){
        return cveRutas;
    }
    
    public String getDistancia() {
        return distancia;
    }

    public void setDistancia(String distancia) {
        this.distancia = distancia;
    }

    public int getPuntoOrigen() {
        return puntoOrigen;
    }

    public void setPuntoOrigen(int puntoOrigen) {
        this.puntoOrigen = puntoOrigen;
    }

    public int getPuntoDestino() {
        return puntoDestino;
    }

    public void setPuntoDestino(int puntoDestino) {
        this.puntoDestino = puntoDestino;
    }

    public String getDuracionEstimada() {
        return duracionEstimada;
    }

    public void setDuracionEstimada(String duracionEstimada) {
        this.duracionEstimada = duracionEstimada;
    }

    public String getParadasIntermedias() {
        return paradasIntermedias;
    }

    public void setParadasIntermedias(String paradasIntermedias) {
        this.paradasIntermedias = paradasIntermedias;
    }
    
}
