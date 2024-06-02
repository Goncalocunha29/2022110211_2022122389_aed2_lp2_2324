package main;

import java.util.Arrays;
import java.util.List;

public class Testes {
    public static void main(String[] args) {
        testarBaseDeDados();
    }

    public static void testarBaseDeDados() {
        BaseDados bd = new BaseDados();
        Autor autor1 = new Autor("João Silva", "J. Silva", "João Silva", "Universidade do Minho",
                "0000-0002-1825-0097", "0000-0002-1825-0097", "0000-0002-1825-0097", "0000-0002-1825-0097");

        Autor autor2 = new Autor("Maria Fernandes Silva", "M. Silva", "Maria Silva", "Universidade do Porto",
                "0000-0002-1825-0098", "0000-0002-1825-0098", "0000-0002-1825-0098", "0000-0002-1825-0098");

        bd.adicionaAutor(autor1);
        bd.adicionaAutor(autor2);

        journal journal1 = new journal("Manuel dos Santos", "2023", 200,
                2003, "Porto","Jornal das 5" ,2005); // Cria publicações

        conferencia conferencia1 = new conferencia(200, "Porto", "A vida do maluco", 1983); // Cria publicações

        Artigo artigo1 = new Artigo("Titulo1", Arrays.asList("Palavras1", "Palavras2"), "Resumo1",
                "Tipo1", 2024, 100); // Cria artigos

        Artigo artigo2 = new Artigo("Titulo2", Arrays.asList("Palavras3", "Palavras4"), "Resumo2",
                "Tipo2", 2003, 500);

        artigo1.adicionarAutor(autor1);
        artigo2.adicionarAutor(autor2);

        bd.adicionarArtigo(artigo1);
        bd.adicionarArtigo(artigo2);

        bd.inserirPublicacao(journal1);
        bd.inserirPublicacao(conferencia1);

        artigo1.adicionarVoto();
        artigo1.adicionarVoto();
        artigo1.adicionarVoto();

        System.out.println("\nAutores na base de dados:");
        for (Autor autor : bd.autores()) {
            System.out.println("Nome: " + autor.getNome() + ", ORCID: " + autor.getOrcid());
        }

        System.out.println("\nArtigos na base de dados:");
        for (Artigo artigo : bd.listarArtigos()) {
            System.out.println(artigo.getTitulo() + " - Publicado em: " + artigo.getLocal());
            for (Autor autor : artigo.getAutores()) {
                System.out.println("Autor: " + autor.getNome());
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

        bd.removerAutor(autor1);

        System.out.println("\nAutores na base de dados após remoção:");
        for (Autor autor : bd.autores()) {
            System.out.println("Nome: " + autor.getNome() + ", ORCID: " + autor.getOrcid());
        }


        System.out.println("\nArtigos na base de dados após remoção de autor:");
        for (Artigo artigo : bd.listarArtigos()) {
            System.out.println(artigo.getTitulo() + " - Publicado em: " + artigo.getLocal());
            for (Autor autor : artigo.getAutores()) {
                System.out.println("Autor: " + autor.getNome());
            }
        }

        int anoInicio = 2022;
        int anoFim = 2025;
        List<Artigo> artigosPorAutorPeriodo = bd.buscarArtigosPorAutorPeriodo(autor2, anoInicio, anoFim);

        System.out.println("\nArtigos escritos por " + autor2.getNome() + " entre " + anoInicio + " e " +anoFim + ":");
        for (Artigo artigo : artigosPorAutorPeriodo) {
            System.out.println("Titulo: " + artigo.getTitulo() + ", Ano: " + artigo.getAno());
        }

        artigo1.registaVisualizacao("2024-05");
        System.out.println("\nArtigos não visualizados ou descarregados:");
        for (Artigo artigo : bd.artigosNaoVisualizadosOuDescarregados("2024-05")) {
            System.out.println("Título: " + artigo.getTitulo());
        }

        System.out.println("\nTop 3 Artigos mais usados em 2024-05:");
        for (Artigo artigo : bd.top3ArtigosMaisUsados("2024-05")) {
            System.out.println("Título: " + artigo.getTitulo() + ", Usos: " + artigo.getTotalUsosMensais("2024-05"));
        }

        System.out.println("\nLista de Artigos:");
        for (Artigo artigo : bd.listarArtigos()) {
            System.out.println("Título: " + artigo.getTitulo() + ", Publicado em: " + artigo.getLocal());
            for (Autor autor : artigo.getAutores()) {
                System.out.println("Autor: " + autor.getNome());
            }
        }

        System.out.println("\nLista de Autores:");
        for (Autor autor : bd.autores()) {
            System.out.println("Nome: " + autor.getNome() + ", ORCID: " + autor.getOrcid());
        }

        System.out.println("\nLigações entre Artigos:");
        for (Artigo artigo : bd.listarArtigos()) {
            System.out.println("Artigo: " + artigo.getTitulo());
            for (Autor autor : artigo.getAutores()) {
                System.out.println("Autor: " + autor.getNome());
            }
        }

        System.out.println("\nUtilização Mensal e Anual dos Artigos:");
        for (Artigo artigo : bd.listarArtigos()) {
            System.out.println("Artigo: " + artigo.getTitulo());
            System.out.println("Visualizações Mensais: " + artigo.getVisualizacoesMensais("2024-05"));
            System.out.println("Visualizações Anuais: " + artigo.getVisualizacoesAnuais(2024));
            System.out.println("Likes: " + artigo.getVotos());
        }


    }


}
