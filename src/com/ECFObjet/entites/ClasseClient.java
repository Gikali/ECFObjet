package com.ECFObjet.entites;

public class ClasseClient extends ClasseSociete {
    private long chiffreAffaires;
    private int nombreEmployes;
    private static  int prochainIdentifiantClient = 1;

    public ClasseClient ( String raisonSociale, ClasseAdresse adresse, String telephone, String email, long chiffreAffaires, int nombreEmployes, String commentaire) {
        super( raisonSociale, adresse, telephone, email, commentaire );

        setChiffreAffaires(chiffreAffaires);
        setNombreEmployes(nombreEmployes);
        setIdentifiant(prochainIdentifiantClient++);
    }

    public long getChiffreAffaires() {
        return chiffreAffaires;
    }

    public void setChiffreAffaires(long chiffreAffaires) throws IllegalArgumentException {
        if (chiffreAffaires < 200) {
            throw new IllegalArgumentException("Le chiffre d'affaires doit être supérieur à 200");
        }
        this.chiffreAffaires = chiffreAffaires;
    }

    public int getNombreEmployes() {
        return nombreEmployes;
    }

    public void setNombreEmployes(int nombreEmployes) {
        if (nombreEmployes <= 0) {
            throw new IllegalArgumentException("Le nombre d'employés doit être surpérieur à 0");
        }
        this.nombreEmployes = nombreEmployes;
    }

    public int getProchainIdentifiantClient() {
        return prochainIdentifiantClient;
    }

    public void setProchainIdentifiantClient(int prochainIdentifiantClient) {
        this.prochainIdentifiantClient = prochainIdentifiantClient;
    }



}
