package com.ECFObjet.entites;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class ClasseProspect extends ClasseSociete {
    private LocalDate dateProspection;
    private boolean estInteresse;
    private static int prochainIdentifiantProspect = 1;
    private static final DateTimeFormatter DATE_FORMAT = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    public ClasseProspect( String raisonSociale, ClasseAdresse adresse, String telephone, String email, String dateProspection, boolean estInteresse, String commentaire) {
        super( raisonSociale, adresse, telephone, email, commentaire);
        setDateProspection(dateProspection);
        setEstInteresse(estInteresse);
        setIdentifiant(prochainIdentifiantProspect++);
    }

    public String getDateProspection() {

        return this.dateProspection.format(DATE_FORMAT);
    }

    public void setDateProspection(String dateProspection) {
        try {
            this.dateProspection = LocalDate.parse(dateProspection, DATE_FORMAT);
        } catch (DateTimeParseException e) {
            throw new IllegalArgumentException("La date doit être au format jj/mm/aaaa.");
        }
    }



    public boolean getEstInteresse() {
        return estInteresse;
    }

    public void setEstInteresse(boolean estInteresse) {
        this.estInteresse = estInteresse;
    }

    public int getProchainIdentifiantProspect() {

        return prochainIdentifiantProspect;
    }

    public void setProchainIdentifiantProspect(int prochainIdentifiantProspect) {
        this.prochainIdentifiantProspect = prochainIdentifiantProspect;
    }

}
