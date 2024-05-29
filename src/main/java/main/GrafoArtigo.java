package main;

import edu.princeton.cs.algs4.Bag;
import edu.princeton.cs.algs4.Digraph;

public class GrafoArtigo {
    private Digraph grafo;
    private Bag<Citacao>[] citacoes;


    public GrafoArtigo(int numArtigos) {
        grafo = new Digraph(numArtigos); // Cria um grafo com numArtigos vertices
        citacoes = (Bag<Citacao>[]) new Bag[numArtigos]; // Cria um vetor de Bags de Citacoes
        for (int i = 0; i < numArtigos; i++) {
            citacoes[i] = new Bag<Citacao>();
        }
    }

    public void adicionarCitacao(int artigoDe, int artigoPara, Citacao citacao) {
        grafo.addEdge(artigoDe, artigoPara); // Adiciona uma aresta entre os vertices artigoDe e artigoPara
        citacoes[artigoDe].add(citacao);
    }

    public Iterable<Integer> adj(int v) {
        return grafo.adj(v); // Retorna os vertices adjacentes ao vertice v
    }

    public Iterable<Citacao> citacoes(int v) {
        return citacoes[v]; // Retorna as citacoes do vertice v
    }

    public int numVertices() {
        return grafo.V(); // Retorna o número de vértices no grafo
    }

    public int numArestas() {
        return grafo.E(); // Retorna o número de arestas no grafo
    }

    public int calcularCitasDePrimeiraOrdem(int artigoId) {
        int citas = 0;
        for (int v = 0; v < grafo.V(); v++) {
            for (Citacao citacao : citacoes[v]) {
                if (citacao.getArtigoPara() == artigoId) {
                    citas++;
                }
            }
        }
        return citas;
    }
}
