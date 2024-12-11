package com.ECFObjet.entites;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TestClasseProspect {

    @Test
    public void CreateClasseProspect() {
        ClasseAdresse adresse = new ClasseAdresse(12, "Rue de Paris", "75001", "Paris");
        ClasseProspect prospect = new ClasseProspect("Société B",adresse,"06-12-34-56-78","moil@ff.fr","06/09/2024",true,"");

        assertEquals("Société B", prospect.getRaisonSociale());
        assertEquals("12 Rue de Paris, 75001 Paris", prospect.getAdresse());
        assertEquals("06-12-34-56-78", prospect.getTelephone());
        assertEquals("moil@ff.fr", prospect.getEmail());
        assertEquals("06/09/2024", prospect.getDateProspection());
        assertEquals(true, prospect.getEstInteresse());

    }
    @Test
    void testIncrementIdentifiant() {
        ClasseAdresse adresse = new ClasseAdresse(12, "Rue de Paris", "75001", "Paris");
        ClasseProspect prospect1 = new ClasseProspect("Société B", adresse, "06-12-34-56-78", "contact@a.com", "05/09/2024", true,"");
        ClasseProspect prospect2 = new ClasseProspect("Société C", adresse, "06-12-34-56-78", "contact@b.com", "06/05/2024", false,"");

        assertEquals(1, prospect1.getIdentifiant());
        assertEquals(2, prospect2.getIdentifiant());
    }
}
