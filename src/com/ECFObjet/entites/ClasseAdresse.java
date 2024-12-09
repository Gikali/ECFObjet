package com.ECFObjet.entites;

public class ClasseAdresse {
    private int numeroRue;
    private String nomRue;
    private String codePostal;
    private String ville;

    public ClasseAdresse() {

    }

    public ClasseAdresse(int numeroRue, String nomRue, String ville, String codePostal) {
        setNumeroRue(numeroRue);
        setNomRue(nomRue);
        setVille(ville);
        setCodePostal(codePostal);
    }

    public int getNumeroRue() {
        return numeroRue;
    }

    public void setNumeroRue(int numeroRue) {
        this.numeroRue = numeroRue;
    }

    public String getNomRue() {
        return nomRue;
    }

    public void setNomRue(String nomRue) {
        this.nomRue = nomRue;
    }

    public String getCodePostal() {
        return codePostal;
    }

    public void setCodePostal(String codePostal) {
        this.codePostal = codePostal;
    }

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }
}
