package main;

import java.util.*;

public class BaseDados {
    private TreeMap<String, Autor> autores;
    private TreeMap<String, Artigo> artigos;
    private TreeMap<String, Publicacao> publicacoes;
    private List<String> autoresRemovidos;
    private TreeMap<Integer, List<Artigo>> artigosPorAno;
    private GrafoArtigo grafoArtigo;
    private GrafoAutor grafoAutor;

    public BaseDados() {
        autores = new TreeMap<>();
        artigos = new TreeMap<>();
        publicacoes = new TreeMap<>();
        this.autoresRemovidos = new ArrayList<>();
        artigosPorAno = new TreeMap<>();
        grafoArtigo = new GrafoArtigo(1000); // Supondo no máximo x artigos
        grafoAutor = new GrafoAutor(1000); // Supondo no máximo x autores

    }

    public void adicionaAutor(Autor autor) {
        autores.put(autor.getOrcid(), autor);
    }
    public void removerAutor(String orcid) {
        Autor autor = autores.remove(orcid);
        if (autor != null) {
            for (Artigo artigo : autor.getArtigos()) {
                artigo.getAutores().remove(autor);
            }
            autoresRemovidos.add(autor.getNome());
        }
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

    public void removerAutor(Autor autor){
        autores.remove(autor.getOrcid());

    }

    public List<String> listarAutoresRemovidos(){
        List<String> autoresRemovidos = new ArrayList<>();
        for (Autor autor : autores()) {
            if (autor.getArtigos().isEmpty()) {
                autoresRemovidos.add(autor.getNome());
            }
        }
        return autoresRemovidos;
    }

    public List<Artigo> buscarArtigosPorAutorPeriodo(Autor autor, int anoInicio, int anoFim) {
        List<Artigo> artigosEncontrados = new ArrayList<>();
        for (Map.Entry<Integer, List<Artigo>> entry : artigosPorAno.subMap(anoInicio, true, anoFim, true).entrySet()) {
            for (Artigo artigo : entry.getValue()) {
                if (artigo.getAutores().contains(autor)) {
                    artigosEncontrados.add(artigo);
                }
            }
        }
        return artigosEncontrados;
    }

    //---------------------------------R5----------------------------------//
    public void gerarRelatorioGlobal() {
        System.out.println("\nRelatório Global do Sistema");

        System.out.println("\nLista de Artigos:");
        for (Artigo artigo : listarArtigos()) {
            System.out.println("Título: " + artigo.getTitulo() + ", Publicado em: " + artigo.getPublicacao().getLocal());
            for (Autor autor : artigo.getAutores()) {
                System.out.println("Autor: " + autor.getNome());
            }
        }

        System.out.println("\nLista de Autores:");
        for (Autor autor : autores()) {
            System.out.println("Nome: " + autor.getNome() + ", ORCID: " + autor.getOrcid());
        }

        System.out.println("\nLigações entre Artigos:");
        for (Artigo artigo : listarArtigos()) {
            System.out.println("Artigo: " + artigo.getTitulo());
            for (Autor autor : artigo.getAutores()) {
                System.out.println("Autor: " + autor.getNome());
            }
        }

        System.out.println("\nUtilização Mensal e Anual dos Artigos:");
        for (Artigo artigo : listarArtigos()) {
            System.out.println("Artigo: " + artigo.getTitulo());
            System.out.println("Visualizações Mensais: " + artigo.getVisualizacoesMensais("2024-05"));
            System.out.println("Visualizações Anuais: " + artigo.getVisualizacoesAnuais(2024));
            System.out.println("Likes: " + artigo.getVotos());
        }
    }

    //---------------------------------R6----------------------------------//


    //---------------------------------R7----------------------------------//



    //---------------------------------R8----------------------------------//
    public Artigo getArtigo(String titulo) {
        return artigos.get(titulo);
    }

    public Autor getAutor(String orcid) {
        return autores.get(orcid);
    }

    public void adicionarCitacao(String tituloDe, String tituloPara, Citacao citacao) {
        Artigo artigoDe = getArtigo(tituloDe);
        Artigo artigoPara = getArtigo(tituloPara);
        if (artigoDe != null && artigoPara != null) {
            grafoArtigo.adicionarCitacao(Integer.parseInt(artigoDe.getId()), Integer.parseInt(artigoPara.getId()), citacao);
            // Adiciona uma aresta entre os vertices artigoDe e artigoPara
        }
    }

    public void adicionarColaboracao(String orcid1, String orcid2) {
        Autor autor1 = getAutor(orcid1);
        Autor autor2 = getAutor(orcid2);
        if (autor1 != null && autor2 != null) {
            grafoAutor.adicionarColaboracao(Integer.parseInt(autor1.getOrcid()), Integer.parseInt(autor2.getOrcid()));
            // Adiciona uma aresta entre os vertices autor1 e autor2
        }
    }

    public List<Citacao> listarCitacoes() {
        List<Citacao> todasCitacoes = new ArrayList<>();
        for (Artigo artigo : listarArtigos()) {
            for (Citacao citacao : grafoArtigo.citacoes(Integer.parseInt(artigo.getId()))) {
                todasCitacoes.add(citacao);
                // Retorna as citacoes do vertice v
            }
        }
        return todasCitacoes;
    }

    public List<String> listarColaboracoes() {
        List<String> todasColaboracoes = new ArrayList<>();
        for (Autor autor : autores()) {
            for (int colaboradorId : grafoAutor.adj(Integer.parseInt(autor.getOrcid()))) {
                todasColaboracoes.add(autor.getOrcid() + "-" + colaboradorId);
            }
        }
        return todasColaboracoes;
    }


    //---------------------------------R9----------------------------------//
    // (9.1)
    public List<Artigo> listarArtigosPorPublicacaoEPeriodo(String nomePublicacao, int anoInicio, int anoFim) {
        List<Artigo> artigosEncontrados = new ArrayList<>();
        for (Artigo artigo : artigos.values()) {
            if (artigo.getPublicacao() != null && artigo.getPublicacao().getNome().equals(nomePublicacao) &&
                    artigo.getAno() >= anoInicio && artigo.getAno() <= anoFim) {
                artigosEncontrados.add(artigo);
            }
        }
        return artigosEncontrados;
    }
    // (9.2)
    /*
    public int calcularCitasDePrimeiraOrdem(String titulo) {
        Artigo artigo = getArtigo("Titulo2");
        if (artigo != null) {
            return grafoArtigo.calcularCitasDePrimeiraOrdem(Integer.parseInt(artigo.getId())); // Retorna o número de citações de primeira ordem
        }
        return 0;
    }*/

    // (9.3)

    // (9.4)

    // (9.5)

    // (9.6)



}