package com.ECFObjet.entites;
import com.ECFObjet.entites.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.HashSet;

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

    public void setRaisonSociale(String nouvelleRaison) throws IllegalArgumentException {
        if (raisonSocialeUnique(nouvelleRaison)) {
            this.raisonSociale = nouvelleRaison;
        } else {
            throw new IllegalArgumentException("Erreur : La raison sociale '" + nouvelleRaison + "' existe déjà !");
        }
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

    private boolean raisonSocialeUnique(String nouvelleRaison) {

        for (ClasseSociete client : GestionnaireClient.getGestClient()) {
            if (client.getRaisonSociale().equalsIgnoreCase(nouvelleRaison)) {
                return false;
            }
        }

        for (ClasseSociete prospect : GestionnaireProspect.getGestProspect()) {
            if (prospect.getRaisonSociale().equalsIgnoreCase(nouvelleRaison)) {
                return false;
            }
        }
        return true;
    }
}


