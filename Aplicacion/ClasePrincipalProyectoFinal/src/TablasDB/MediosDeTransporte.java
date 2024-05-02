package TablasDB;

public class MediosDeTransporte {
    
    private int cveMDT;
    private String tipoDeUnidad;
    private String modelo;
    private String marca;
    private String placas;
    private int capacidadDePersonas;
    private String fichaTecnica;
    private int capacidadDeCarga;
    private String extras;

    public MediosDeTransporte(String tipoDeUnidad, String modelo, String marca, String placas, int capacidadDePersonas, String fichaTecnica, int capacidadDeCarga, String extras) {
        this.tipoDeUnidad = tipoDeUnidad;
        this.modelo = modelo;
        this.marca = marca;
        this.placas = placas;
        this.capacidadDePersonas = capacidadDePersonas;
        this.fichaTecnica = fichaTecnica;
        this.capacidadDeCarga = capacidadDeCarga;
        this.extras = extras;
    }

    public int getCveMDT() {
        return cveMDT;
    }

    public String getTipoDeUnidad() {
        return tipoDeUnidad;
    }

    public void setTipoDeUnidad(String tipoDeUnidad) {
        this.tipoDeUnidad = tipoDeUnidad;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getPlacas() {
        return placas;
    }

    public void setPlacas(String placas) {
        this.placas = placas;
    }

    public int getCapacidadDePersonas() {
        return capacidadDePersonas;
    }

    public void setCapacidadDePersonas(int capacidadDePersonas) {
        this.capacidadDePersonas = capacidadDePersonas;
    }

    public String getFichaTecnica() {
        return fichaTecnica;
    }

    public void setFichaTecnica(String fichaTecnica) {
        this.fichaTecnica = fichaTecnica;
    }

    public int getCapacidadDeCarga() {
        return capacidadDeCarga;
    }

    public void setCapacidadDeCarga(int capacidadDeCarga) {
        this.capacidadDeCarga = capacidadDeCarga;
    }

    public String getExtras() {
        return extras;
    }

    public void setExtras(String extras) {
        this.extras = extras;
    }
    
    
    
}
