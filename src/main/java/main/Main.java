package main;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        BaseDados bd = new BaseDados();
        Autor autor1 = new Autor("Nome1", "Nome Curto 1", "Nome Cientifico",
                "filiacao 1", "orcid1" ,"cienciaID1", "googleScholarID1",
                "scopusAuthorID1");
        Autor autor2 = new Autor("Autor Dois", "A. Dois", "Autor D.",
                "Instituição Y", "ORCID2", "CienciaID2", "GoogleScholarID2",
                "ScopusAuthorID2");
        bd.adicionaAutor(autor1);
        bd.adicionaAutor(autor2);

        journal journal1 = new journal("Manuel dos Santos", "2023", 200, 2003, "Jornal das 5", 2005);
        conferencia conferencia1 = new conferencia(200, "Porto", "A vida do maluco", 1983);


        Artigo artigo1 = new Artigo("Titulo1", Arrays.asList("Palavras1", "Palavras2"), "Resumo1",
                "Tipo1", 2024, 100);
        Artigo artigo2 = new Artigo("Titulo2", Arrays.asList("Palavras3", "Palavras4"), "Resumo2",
                "Tipo2", 2003, 500);

        // Adiciona autores aos artigos
        artigo1.adicionarAutor(autor1);
        artigo2.adicionarAutor(autor2);

        // Adiciona artigos à base de dados
        bd.adicionarArtigo(artigo1);
        bd.adicionarArtigo(artigo2);


        // Adiciona publicações à base de dados
        bd.inserirPublicacao(journal1);     //Publicações:
        bd.inserirPublicacao(conferencia1); //Nome: A vida do maluco, Tipo: Publicacao, Ano: 1983
                                            //Nome: Jornal das 5, Tipo: Publicacao, Ano: 2005


        System.out.println("\nAutores na base de dados:");
        for (Autor autor : bd.autores()) {
            System.out.println("Nome: " + autor.getNome() + ", ORCID: " + autor.getOrcid());
        }


        System.out.println("\nArtigos na base de dados:");
        for (Artigo artigo : bd.listarArtigos()) {
            if (artigo.getPublicacao() != null) {
                System.out.println(artigo.getTitulo() + " - Publicado em: " + artigo.getPublicacao().getNome());
            } else {
                System.out.println(artigo.getTitulo() + " - Publicação não encontrada.");
            }
        }



        System.out.println("\nPublicações:");
        for (Publicacao pub : bd.listarPublicacoes()) {
            System.out.println("Nome: " + pub.getNome() + ", Tipo: " + pub.getTipo() + ", Ano: " + pub.getAno());
            for (Artigo art : pub.getArtigos()) {
                System.out.println("  Artigo: " + art.getTitulo() + ", Ano: " + art.getAno());
                for (Autor aut : art.getAutores()) {
                    System.out.println("    Autor: " + aut.getNome());
                }
            }
        }

    }
}