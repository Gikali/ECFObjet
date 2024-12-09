package com.ECFObjet.entites;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TestClasseProspect {

    @Test
    public void CreateClasseProspect() {
        ClasseProspect prospect = new ClasseProspect("Société B","rue machin","0648547269","moil@ff.fr","06/09/2024",true);

        assertEquals("Société B", prospect.getRaisonSociale());
        assertEquals("rue machin", prospect.getAdresse());
        assertEquals("0648547269", prospect.getTelephone());
        assertEquals("moil@ff.fr", prospect.getEmail());
        assertEquals("06/09/2024", prospect.getDateProspection());
        assertEquals(true, prospect.getEstInteresse());

    }
    @Test
    void testIncrementIdentifiant() {
        ClasseProspect prospect1 = new ClasseProspect("Société B", "Adresse A", "0123456789", "contact@a.com", "05/09/2024", true);
        ClasseProspect prospect2 = new ClasseProspect("Société C", "Adresse B", "0123456790", "contact@b.com", "06/05/2024", false);

        assertEquals(1, prospect1.getIdentifiant());
        assertEquals(2, prospect2.getIdentifiant());
    }
}
