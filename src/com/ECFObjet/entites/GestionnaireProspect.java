package com.ECFObjet.entites;
import java.util.ArrayList;

public class GestionnaireProspect {
    private static ArrayList<ClasseSociete> gestprospect = new ArrayList<>();

    public static void ajoutProspect(ClasseSociete prospects){
        gestprospect.add(prospects);
    }
    public static ArrayList<ClasseSociete> getGestProspect(){
        return gestprospect;
    }
}
