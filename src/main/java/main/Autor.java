package main;

import java.util.*;

public class Autor {
    private String nome;
    private String nomeCurto;
    private String nomeCientifico;
    private String filiacao;
    private String orcid;
    private String cienciaID;
    private String googleScholarID;
    private String scopusAuthorID;
    private List<Artigo> artigos;

    public Autor (String nome, String nomeCurto, String nomeCientifico, String filiacao,
                  String orcid, String cienciaID, String googleScholarID, String scopusAuthorID){
        this.nome = nome;
        this.nomeCurto = nomeCurto;
        this.nomeCientifico = nomeCientifico;
        this.filiacao = filiacao;
        this.orcid = orcid;
        this.cienciaID = cienciaID;
        this.googleScholarID = googleScholarID;
        this.scopusAuthorID = scopusAuthorID;
        this.artigos = new ArrayList<>();
    }

    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNomeCurto() {
        return nomeCurto;
    }

    public void setNomeCurto(String nomeCurto) {
        this.nomeCurto = nomeCurto;
    }

    public String getNomeCientifico() {
        return nomeCientifico;
    }

    public void setNomeCientifico(String nomeCientifico) {
        this.nomeCientifico = nomeCientifico;
    }

    public String getFiliacao() {
        return filiacao;
    }

    public void setFiliacao(String filiacao) {
        this.filiacao = filiacao;
    }

    public String getOrcid() {
        return orcid;
    }

    public void setOrcid(String orcid) {
        this.orcid = orcid;
    }

    public String getCienciaID() {
        return cienciaID;
    }

    public void setCienciaID(String cienciaID) {
        this.cienciaID = cienciaID;
    }

    public String getGoogleScholarID() {
        return googleScholarID;
    }

    public void setGoogleScholarID(String googleScholarID) {
        this.googleScholarID = googleScholarID;
    }

    public String getScopusAuthorID() {
        return scopusAuthorID;
    }

    public void setScopusAuthorID(String scopusAuthorID) {
        this.scopusAuthorID = scopusAuthorID;
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
}