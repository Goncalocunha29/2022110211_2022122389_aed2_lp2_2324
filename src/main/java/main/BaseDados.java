package main;

import java.util.List;
import java.util.TreeMap;
import java.util.ArrayList;
import java.util.HashMap;

public class BaseDados {
    private TreeMap<String, Autor> autores;
    private TreeMap<String, Artigo> artigos;
    private TreeMap<String, Publicacao> publicacoes;

    public BaseDados() {
        autores = new TreeMap<>();
        artigos = new TreeMap<>();
        publicacoes = new TreeMap<>();
    }

    public void adicionaAutor(Autor autor) {
        autores.put(autor.getOrcid(), autor);
    }
    public void removerAutor(String orcid) {
        autores.remove(orcid);
    }

    public void editarAutor(String orcid, Autor autor) {
        autores.put(orcid, autor);
    }


    public List<Autor> autores() {
        return new ArrayList<>(autores.values());
    }

    public void adicionarArtigo(Artigo artigo) {
        artigos.put(artigo.getTitulo(), artigo);
        for (Autor autor : artigo.getAutores()) {
            Autor existente = autores.get(autor.getOrcid());
            if (existente != null) {
                existente.adicionarArtigo(artigo);
            }
        }
    }

    public void removerArtigo(String titulo) {
        Artigo artigo = artigos.remove(titulo);
        if (artigo != null) {
            for (Autor autor : artigo.getAutores()) {
                Autor existente = autores.get(autor.getOrcid());
                if (existente != null) {
                    existente.getArtigos().remove(artigo);
                }
            }
        }
    }

    public void editarArtigo(String titulo, Artigo artigo) {
        removerArtigo(titulo);
        adicionarArtigo(artigo);
    }

    public List<Artigo> listarArtigos() {
        return new ArrayList<>(artigos.values());
    }



    // Métodos para gerenciar publicações
    public void inserirPublicacao(Publicacao publicacao){
        publicacoes.put(publicacao.getNome(), publicacao);
    }

    public void removerPublicacao(String nome) {
        publicacoes.remove(nome);
    }

    public void editarPublicacao(String nome, Publicacao publicacao) {
        publicacoes.put(nome, publicacao);
    }

    public List<Publicacao> listarPublicacoes() {
        return new ArrayList<>(publicacoes.values());
    }

}