package com.ECFObjet.entites;

abstract class ClasseSociete {
    private int identifiant;
    private String raisonSociale;
    private String adresse;
    private String telephone;
    private String email;

    public ClasseSociete(int identifiant, String raisonSociale, String adresse, String telephone, String email) {
        setIdentifiant(identifiant);
        setRaisonSociale(raisonSociale);
        setAdresse(adresse);
        setTelephone(telephone);
        setEmail(email);
    }

    public ClasseSociete() {
    }

    public int getIdentifiant() {
        return identifiant;
    }

    public void setIdentifiant(int identifiant) {
        this.identifiant = identifiant;
    }

    public String getRaisonSociale() {
        return raisonSociale;
    }

    public void setRaisonSociale(String raisonSociale) {
        this.raisonSociale = raisonSociale;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
