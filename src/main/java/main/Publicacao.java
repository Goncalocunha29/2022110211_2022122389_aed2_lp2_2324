package main;

import java.util.List;
import java.util.ArrayList;


    public abstract class Publicacao{
        private String nome;
        private int ano;
        private String tipo;
        private List<Artigo> artigos;

        public Publicacao(String nome, int ano) {
            this.nome = nome;
            this.ano = ano;
            this.tipo = "Publicacao";
            this.artigos = new ArrayList<>();
        }

        public String getNome() {
            return nome;
        }

        public void setNome(String nome) {
            this.nome = nome;
        }

        public int getAno() {
            return ano;
        }
        public void setAno(int ano) {
            this.ano = ano;
        }
        public String getTipo(){
            return tipo;
        }

        public void setTipo(String tipo) {
            this.tipo = tipo;
        }

        public List<Artigo> getArtigos() {
            return artigos;
        }

        public void setArtigos(List<Artigo> artigos) {
            this.artigos = artigos;
        }

        public void adicionarArtigo(Artigo artigo) {
            artigos.add(artigo);
        }

        public void removerArtigo(Artigo artigo) {
            artigos.remove(artigo);
        }
        public abstract String getLocal();
    }




//------------------------------Journal-----------------------------------//
class journal extends Publicacao {
    private String publisher;
    private String periodicidade;
    private float jcrIF;
    private float scopusIF;
    private String local;

    public journal(String publisher, String periodicidade, float jcrIF, float scopusIF, String local ,String nome, int ano){
        super(nome, ano);
        this.publisher = publisher;
        this.periodicidade = periodicidade;
        this.jcrIF = jcrIF;
        this.scopusIF = scopusIF;
        this.local = local;
    }
    public String getPublisher() {
        return publisher;
    }
    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }
    public String getPeriodicidade() {
        return periodicidade;
    }
    public void setPeriodicidade(String periodicidade) {
        this.periodicidade = periodicidade;
    }
    public float getJcrIF() {
        return jcrIF;
    }
    public void setJcrIF(float jcrIF) {
        this.jcrIF = jcrIF;
    }
    public float getScopusIF() {
        return scopusIF;
    }
    public void setScopusIF(float scopusIF) {
        this.scopusIF = scopusIF;
    }
    public String getLocal() {
        return local;
    }

}

//------------------------------conferencia-----------------------------------//
class conferencia extends Publicacao{
    private int numEdicao;
    private String local;

    public conferencia(int numEdicao, String local, String nome, int ano){
        super(nome, ano);
        this.numEdicao = numEdicao;
        this.local = local;
    }
    public int getNumEdicao() {
        return numEdicao;
    }
    public void setNumEdicao(){
        this.numEdicao = numEdicao;
    }
    public String getLocal(){
        return local;
    }
    public void setLocal(String local) {
        this.local = local;
    }
}