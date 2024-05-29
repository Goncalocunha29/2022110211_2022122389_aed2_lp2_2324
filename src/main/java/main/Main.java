package main;

import edu.princeton.cs.algs4.Graph;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        BaseDados bd = new BaseDados(); // Cria uma base de dados
        Autor autor1 = new Autor("Nome1", "Curto", "Nome Cientifico",
                "filiacao 1", "orcid1" ,"cienciaID1", "googleScholarID1",
                "scopusAuthorID1");
        Autor autor2 = new Autor("Autor Dois", "A. Dois", "Autor D.",
                "Instituição Y", "ORCID2", "CienciaID2", "GoogleScholarID2",
                "ScopusAuthorID2");


        bd.adicionaAutor(autor1); // Adiciona autores à base de dados
        bd.adicionaAutor(autor2);


        journal journal1 = new journal("Manuel dos Santos", "2023", 200,
                2003, "Porto","Jornal das 5" ,2005); // Cria publicações
        conferencia conferencia1 = new conferencia(200, "Porto", "A vida do maluco", 1983); // Cria publicações


        Artigo artigo1 = new Artigo("Titulo1", Arrays.asList("Palavras1", "Palavras2"), "Resumo1",
                "Tipo1", 2024, 100); // Cria artigos
        Artigo artigo2 = new Artigo("Titulo2", Arrays.asList("Palavras3", "Palavras4"), "Resumo2",
                "Tipo2", 2003, 500);

        // Adiciona autores aos artigos
        artigo1.adicionarAutor(autor1);
        artigo2.adicionarAutor(autor2);

        // Adiciona artigos à base de dados
        bd.adicionarArtigo(artigo1);
        bd.adicionarArtigo(artigo2);

        artigo1.setPublicacao(journal1);
        artigo2.setPublicacao(conferencia1);// Adiciona artigos às publicações

        artigo1.adicionarVoto(); // Adiciona likes aos artigos


        // Adiciona publicações à base de dados
        bd.inserirPublicacao(journal1);     //Publicações:
        bd.inserirPublicacao(conferencia1); //Nome: A vida do maluco, Tipo: Publicacao, Ano: 1983
                                            //Nome: Jornal das 5, Tipo: Publicacao, Ano: 2005
        journal1.adicionarArtigo(artigo1); // Adiciona artigos às publicações
        conferencia1.adicionarArtigo(artigo2);


        // Adiciona artigos às publicações
        System.out.println("\nAutores na base de dados:");
        for (Autor autor : bd.autores()) {
            System.out.println("Nome: " + autor.getNome() + ", ORCID: " + autor.getOrcid()); //Nome: Nome1, ORCID: orcid1
                                                                                             //Nome: Autor Dois, ORCID: ORCID2
        }


        System.out.println("\nArtigos na base de dados:");
        for (Artigo artigo : bd.listarArtigos()) {
            if (artigo.getPublicacao() != null) {
                System.out.println(artigo.getTitulo() + " - Publicado em: " + artigo.getLocal()); //Titulo1 - Publicado em: Porto
                                                                                                                  //Titulo2 - Publicado em: Lisboa
            } else {
                System.out.println(artigo.getTitulo() + " - Publicação não encontrada.");
            }
        }


        System.out.println("\nPublicações:");
        for (Publicacao pub : bd.listarPublicacoes()) {
            System.out.println("Nome: " + pub.getNome() + ", Tipo: " + pub.getTipo() + ", Ano: " + pub.getAno());
            for (Artigo art : pub.getArtigos()) {
                System.out.println("Artigo: " + art.getTitulo() + ", Ano: " + art.getAno());
                for (Autor aut : art.getAutores()) {
                    System.out.println("Autor: " + aut.getNome());
                }
            }
        }



        //R3
        bd.removerAutor(autor1); // Remove autor da base de dados
        artigo1.removerAutor(autor1);

        // Remove autor da base de dados e reescreve as informações
        System.out.println("\nAutores na base de dados após remoção:");
        for (Autor autor : bd.autores()) {
            System.out.println("Nome: " + autor.getNome() + ", ORCID: " + autor.getOrcid());
        }

        /*
        System.out.println("\nAutores removidos:");
        for (String nomeCurto : bd.listarAutoresRemovidos()) {
            System.out.println("Nome Curto: " + nomeCurto);
        }
        */

        System.out.println("\nArtigos na base de dados após remoção de autor:");
        for (Artigo artigo : bd.listarArtigos()) {
            System.out.println(artigo.getTitulo() + " - Publicado em: " + artigo.getLocal());
            for (Autor autor : artigo.getAutores()) {
                System.out.println("Autor: " + autor.getNome());
            }
        }

        //R4
        int anoInicio = 1982;
        int anoFim = 2025;
        List<Artigo> artigosPorAutorPeriodo = bd.buscarArtigosPorAutorPeriodo(autor2, anoInicio, anoFim);

        System.out.println("\nArtigos escritos por " + autor2.getNome() + " entre " + anoInicio + " e " + anoFim + ":");
        for (Artigo artigo : artigosPorAutorPeriodo) {
            System.out.println("Titulo: " + artigo.getTitulo() + ", Ano: " + artigo.getAno());
        }


        //---------------------------------R5----------------------------------//
        bd.gerarRelatorioGlobal();





        //---------------------------------R6----------------------------------//






        //---------------------------------R7----------------------------------//





        //---------------------------------R8----------------------------------//

        bd.gerarRelatorioGlobal();

        Citacao citacao1 = new Citacao("Autor Dois", "A cada artigo que publico sinto que ajudei alguem");
        Citacao citacao2 = new Citacao("Nome1", "A vida é um desafio, e eu estou disposto a enfrenta-lo");

        bd.adicionarCitacao("Ajudar o proximo", "Consegui", citacao1);
        bd.adicionarCitacao("Desafio", "Enfrentar", citacao2);

        bd.adicionarColaboracao("orcid1", "ORCID2");
        /*
        System.out.println("\nCitacoes:");
        for (Citacao citacao : bd.listarCitacoes()) {
            System.out.println("Citacao: " + citacao.getTexto() + ", Autor: " + citacao.getAutor());
        }


        bd.listarColaboracoes();
        System.out.println("\nColaborações entre Autores:");
        for (Autor autor : bd.autores()) {
            System.out.println("Autor: " + autor.getNome());
            for (String colaboradorId : grafoAutor.adj(autor.getOrcid())) {
                Autor colaborador = bd.getAutor(colaboradorId);
                System.out.println("  Colaborou com: " + colaborador.getNome());
            }
        }
        */


        //---------------------------------R9----------------------------------//

        List<Artigo> artigosConferencia = bd.listarArtigosPorPublicacaoEPeriodo("A vida do maluco", 1980, 2024);
        System.out.println("\nArtigos publicados na Conferência 'A vida do maluco':");
        for (Artigo artigo : artigosConferencia) {
            System.out.println(artigo.getTitulo());
        }



        //int citasArtigo1 = bd.calcularCitasDePrimeiraOrdem(artigo1.getId());
        //int citasArtigo2 = bd.calcularCitasDePrimeiraOrdem(artigo2.getId());

        // Impressão dos resultados
        //System.out.println("Citações de primeira ordem para o Artigo 1: " + citasArtigo1);
        //System.out.println("Citações de primeira ordem para o Artigo 2: " + citasArtigo2);
    }
}