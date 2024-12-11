package com.ECFObjet.entites;
import org.junit.jupiter.api.*;


import static org.junit.jupiter.api.Assertions.*;

public class TestClasseClient {



        @Test
        void testClientCreation() {
            ClasseAdresse adresse = new ClasseAdresse(12, "Rue de Paris", "75001", "Paris");

            ClasseClient client = new ClasseClient("Société A", adresse, "06-12-34-56-78", "contact@a.com", 500000L, 50,"");

            assertEquals("Société A", client.getRaisonSociale());
            assertEquals("12 Rue de Paris, 75001 Paris", client.getAdresse());
            assertEquals("06-12-34-56-78", client.getTelephone());

            assertEquals("contact@a.com", client.getEmail());
            assertEquals(500000L, client.getChiffreAffaires());
            assertEquals(50, client.getNombreEmployes());
        }

        @Test
        void testIncrementIdentifiant() {
            ClasseAdresse adresse = new ClasseAdresse(12, "Rue de Paris", "75001", "Paris");
            ClasseClient client1 = new ClasseClient("Société A", adresse, "06-12-34-56-78", "contact@a.com", 500000L, 50,"");
            ClasseClient client2 = new ClasseClient("Société B", adresse, "06-12-34-56-78", "contact@b.com", 300000L, 30,"");

            assertEquals(1, client1.getIdentifiant());
            assertEquals(2, client2.getIdentifiant());
        }

        @Test
        void testValidationChiffreAffaires() {
            Exception exception = assertThrows(IllegalArgumentException.class, () -> {
                ClasseAdresse adresse = new ClasseAdresse(12, "Rue de Paris", "75001", "Paris");
                new ClasseClient("Société A", adresse, "06-12-34-56-78", "contact@a.com", 100L, 50,"");
            });

            assertEquals("Le chiffre d'affaires doit être supérieur à 200", exception.getMessage());
        }
    }

