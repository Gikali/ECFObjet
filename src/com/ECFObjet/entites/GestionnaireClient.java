package com.ECFObjet.entites;

import java.util.ArrayList;

public class GestionnaireClient {
    private static ArrayList<ClasseClient> gestClient = new ArrayList<>();

    public static void ajoutClient (ClasseClient client) {
        gestClient.add(client);
    }

    public static ArrayList<ClasseClient> getGestClient() {
        return gestClient;
    }
}
