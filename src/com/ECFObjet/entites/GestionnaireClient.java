package com.ECFObjet.entites;

import java.util.ArrayList;

public class GestionnaireClient {
    private static ArrayList<ClasseSociete> gestClient = new ArrayList<>();

    public void ajoutClient (ClasseSociete client) {
        gestClient.add(client);
    }
    public static ArrayList<ClasseSociete> getGestClient() {
        return gestClient;
    }
}
