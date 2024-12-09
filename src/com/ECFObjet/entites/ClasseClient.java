package com.ECFObjet.entites;

public class ClasseClient extends ClasseSociete {
    private long chiffreAffaires;
    private int nombreEmployes;
    private static  int prochainIdentifiantClient = 1;

    public ClasseClient(int identifiant, String raisonSociale, String adresse, String telephone, String email, long chiffreAffaires, int nombreEmployes) {
        super(prochainIdentifiantClient ++, raisonSociale, adresse, telephone, email);
        setChiffreAffaires(chiffreAffaires);
        setNombreEmployes(nombreEmployes);
    }

    public long getChiffreAffaires() {
        return chiffreAffaires;
    }

    public void setChiffreAffaires(long chiffreAffaires) {
        this.chiffreAffaires = chiffreAffaires;
    }

    public int getNombreEmployes() {
        return nombreEmployes;
    }

    public void setNombreEmployes(int nombreEmployes) {
        this.nombreEmployes = nombreEmployes;
    }

    public int getProchainIdentifiantClient() {
        return prochainIdentifiantClient;
    }

    public void setProchainIdentifiantClient(int prochainIdentifiantClient) {
        this.prochainIdentifiantClient = prochainIdentifiantClient;
    }



}
