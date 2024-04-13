package org.devemanuel.model;

public class Ciudad_Table {

    private String Ciudad ;
    private String Pais  ;
    private String  Idioma ;

    public String getCiudad() {
        return Ciudad;
    }

    public void setCiudad(String ciudad) {
        Ciudad = ciudad;
    }

    public String getPais() {
        return Pais;
    }

    public void setPais(String pais) {
        Pais = pais;
    }

    public String getIdioma() {
        return Idioma;
    }

    public void setIdioma(String idioma) {
        Idioma = idioma;
    }



    public Ciudad_Table(String ciudad, String pais, String idioma) {
        Ciudad = ciudad;
        Pais = pais;
        Idioma = idioma;
    }

}
