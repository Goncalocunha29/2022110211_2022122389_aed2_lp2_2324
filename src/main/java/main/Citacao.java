package main;

import java.util.HashMap;
import java.util.Map;

public class Citacao {
    private int artigoDe;
    private int artigoPara;
    private Map<String, Integer> atributos;


    private String autor;
    private String texto;

    public Citacao(String autor, String texto) {
        this.autor = autor;
        this.texto = texto;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }
    public int getArtigoPara() {
        return artigoPara;
    }

    @Override
    public String toString() {
        return "Citacao{" +
                "autor='" + autor + '\'' +
                ", texto='" + texto + '\'' +
                '}';
    }

}
