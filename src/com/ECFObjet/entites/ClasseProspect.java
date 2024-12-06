package com.ECFObjet.entites;

import java.time.LocalDate;

public class ClasseProspect extends ClasseSociete {
    private LocalDate dateProspection;
    private boolean estInteresse;
    private int prochainIdentifiantProspect;

    public LocalDate getDateProspection() {
        return dateProspection;
    }

    public void setDateProspection(LocalDate dateProspection) {
        this.dateProspection = dateProspection;
    }

    public boolean isEstInteresse() {
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
