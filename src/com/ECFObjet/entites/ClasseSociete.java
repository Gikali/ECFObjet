package com.ECFObjet.entites;
import com.ECFObjet.entites.ClasseAdresse;
import com.ECFObjet.utility.Regex;
import com.ECFObjet.entites.TypeCRUD;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.HashSet;

public abstract class ClasseSociete {
    private int identifiant;
    private String raisonSociale;
    private  String adresse;
    private String telephone;
    private String email;
    private String commentaire;
    private TypeCRUD typeCRUD;

    public ClasseSociete( String raisonSociale, ClasseAdresse adresse, String telephone, String email, String commentaire) {
        setRaisonSociale(raisonSociale);
        setAdresse(adresse);
        setTelephone(telephone);
        setEmail(email);
        setCommentaire(commentaire);

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
        if (raisonSocialeUnique(nouvelleRaison, typeCRUD)) {
            this.raisonSociale = nouvelleRaison;
        } else {
            throw new IllegalArgumentException("Erreur : La raison sociale '" + nouvelleRaison + "' existe déjà !");
        }
    }


    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(ClasseAdresse adresse) throws IllegalArgumentException {
        if (adresse == null) {
            throw new IllegalArgumentException("L'adresse ne peut pas être vide");
        }

        this.adresse = adresse.getNumeroRue() + "," + adresse.getNomRue() + "," + adresse.getVille() + "," + adresse.getCodePostal();
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        if (telephone == null || !telephone.trim().matches(Regex.REGEX_TEL)) {
            throw new IllegalArgumentException("Erreur : le numéro de téléphone " + telephone + " est invalide.");
        }
        this.telephone = telephone.trim();

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

    public String getCommentaire() {
        return commentaire;
    }

    public void setCommentaire(String commentaire) {
        if (commentaire == null || commentaire.isEmpty()) {
            commentaire = "";
        }
        this.commentaire = commentaire;
    }

    public static boolean raisonSocialeUnique(String nouvelleRaison, TypeCRUD typeCRUD) {

        for (ClasseSociete client : GestionnaireClient.getGestClient()) {
            if (client.getRaisonSociale().equalsIgnoreCase(nouvelleRaison) && typeCRUD == TypeCRUD.CREATE) {
                return false;
            }
        }

        for (ClasseSociete prospect : GestionnaireProspect.getGestProspect()) {
            if (prospect.getRaisonSociale().equalsIgnoreCase(nouvelleRaison)&& typeCRUD == TypeCRUD.CREATE) {
                return false;
            }
        }
        return true;
    }
    @Override
    public String toString() {
        return raisonSociale + " id: " + identifiant;
    }
}


