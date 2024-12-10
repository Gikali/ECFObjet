package com.ECFObjet.entites;
import com.ECFObjet.entites.*;
import com.ECFObjet.utility.Regex;

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


    public ClasseSociete( String raisonSociale, String adresse, String telephone, String email) {
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
        if (!telephone.matches(Regex.REGEX_TEL)) {
        this.telephone = telephone;}
        else {
            throw new IllegalArgumentException("Erreur le numéro de téléphone est invalide");
        }

    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        if (!email.matches(Regex.REGEX_MAIL)){
        this.email = email;}
        else {
            throw new IllegalArgumentException("Erreur l'adresse mail est incorrecte");
        }
    }

    public static boolean raisonSocialeUnique(String nouvelleRaison) {

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


