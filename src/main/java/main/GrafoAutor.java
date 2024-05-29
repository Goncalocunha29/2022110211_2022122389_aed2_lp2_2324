package main;

import edu.princeton.cs.algs4.Bag;
import edu.princeton.cs.algs4.Graph;

public class GrafoAutor {
    private Graph grafo;
    private Bag<String>[] colabs;

    public GrafoAutor(int numAutores) {
        grafo = new Graph(numAutores);
        colabs = (Bag<String>[]) new Bag[numAutores]; // Cria um vetor de Bags de colaborações
        for (int i = 0; i < numAutores; i++) {// Cria um grafo com numAutores vertices
            colabs[i] = new Bag<String>();
        }
    }

    public void adicionarColaboracao(int autor1, int autor2) {
        grafo.addEdge(autor1, autor2); // Adiciona uma aresta entre os vertices autor1 e autor2
        colabs[autor1].add("Colaboração com autor " + autor2);
        colabs[autor2].add("Colaboração com autor " + autor1);// Adiciona uma aresta entre os vertices autor1 e autor2
    }

    public Iterable<Integer> adj(int v) {
        return grafo.adj(v); // Retorna os vertices adjacentes ao vertice v
    }

    public int numVertices() {
        return grafo.V(); // Retorna o número de vértices no grafo
    }

    public int numArestas() {
        return grafo.E(); // Retorna o número de arestas no grafo
    }
}
