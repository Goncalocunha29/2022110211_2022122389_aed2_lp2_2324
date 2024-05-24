package main;

import java.util.*;

public class Artigo {
    private String titulo;
    private List<String> palavrasChave;
    private String resumo;
    private String tipoPublicacao;
    private int ano;
    private int numDownloads;
    private Map<Date, Integer> numVisualDiarias;
    private Map<Date, Integer> numLikesDiarios;
    private List<Autor> autores;
    private List<Artigo> artigos;
    private Publicacao publicacao;

    public Artigo(String titulo, List<String> palavrasChave, String resumo,
                  String tipoPublicacao, int ano, int numDownloads) {
        this.titulo = titulo;
        this.palavrasChave = palavrasChave;
        this.resumo = resumo;
        this.tipoPublicacao = tipoPublicacao;
        this.ano = ano;
        this.numDownloads = numDownloads;
        this.numVisualDiarias = new HashMap<>();
        this.numLikesDiarios = new HashMap<>();
        this.autores = new ArrayList<>();
        this.artigos = new ArrayList<>();
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }


    public String getResumo() {
        return resumo;
    }

    public void setResumo(String resumo) {
        this.resumo = resumo;
    }

    public List<Autor> getAutores() {
        return autores;
    }

    public void setAutores(List<Autor> autores) {
        this.autores = autores;
    }

    public Publicacao getPublicacao() {
        return publicacao;
    }

    public void setPublicacao(Publicacao publicacao) {
        this.publicacao = publicacao;
    }

    public void adicionarAutor(Autor autor) {
        autores.add(autor);
    }

    public void removerAutor(Autor autor) {
        autores.remove(autor);
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }
}
