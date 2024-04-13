package org.devemanuel.model;

public class Ciudad {
    // atributos
    private String nombreCiudad;
    private String codigoCiudad;
    private String distrito;
    private int poblacion;
    private int identificador;

    // constructores
    public Ciudad() {}

    public Ciudad(int identificador, String nombreCiudad, String codigoCiudad, String distrito, int poblacion){
        this.identificador = identificador;
        this.nombreCiudad = nombreCiudad;
        this.codigoCiudad = codigoCiudad;
        this.distrito = distrito;
        this.poblacion = poblacion;

    }

    public Ciudad(String nombreCiudad, String codigoCiudad, String distrito, int poblacion){
        this.nombreCiudad = nombreCiudad;
        this.codigoCiudad = codigoCiudad;
        this.distrito = distrito;
        this.poblacion = poblacion;

    }

    public String getNombreCiudad() {
        return nombreCiudad;
    }

    public void setNombreCiudad(String nombreCiudad) {
        this.nombreCiudad = nombreCiudad;
    }

    public String getCodigoCiudad() {
        return codigoCiudad;
    }

    public void setCodigoCiudad(String codigoCiudad) {
        this.codigoCiudad = codigoCiudad;
    }

    public String getDistrito() {
        return distrito;
    }

    public void setDistrito(String distrito) {
        this.distrito = distrito;
    }

    public int getPoblacion() {
        return poblacion;
    }

    public void setPoblacion(int poblacion) {
        this.poblacion = poblacion;
    }
    public int getIdentificador() {
        return identificador;
    }

    public void setIdentificador(int identificador) {
        this.identificador = identificador;
    }




}
