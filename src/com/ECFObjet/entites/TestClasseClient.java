package com.ECFObjet.entites;
import org.junit.jupiter.api.*;


import static org.junit.jupiter.api.Assertions.*;

public class TestClasseClient {



        @Test
        void testClientCreation() {
            ClasseClient client = new ClasseClient("Société A", "Adresse A", "0123456789", "contact@a.com", 500000L, 50);

            assertEquals("Société A", client.getRaisonSociale());
            assertEquals("Adresse A", client.getAdresse());
            assertEquals("0123456789", client.getTelephone());

            assertEquals("contact@a.com", client.getEmail());
            assertEquals(500000L, client.getChiffreAffaires());
            assertEquals(50, client.getNombreEmployes());
        }

        @Test
        void testIncrementIdentifiant() {
            ClasseClient client1 = new ClasseClient("Société A", "Adresse A", "0123456789", "contact@a.com", 500000L, 50);
            ClasseClient client2 = new ClasseClient("Société B", "Adresse B", "0123456790", "contact@b.com", 300000L, 30);

            assertEquals(1, client1.getIdentifiant());
            assertEquals(2, client2.getIdentifiant());
        }

        @Test
        void testValidationChiffreAffaires() {
            Exception exception = assertThrows(IllegalArgumentException.class, () -> {
                new ClasseClient("Société A", "Adresse A", "0123456789", "contact@a.com", 100L, 50);
            });

            assertEquals("Le chiffre d'affaires doit être supérieur à 200", exception.getMessage());
        }
    }

