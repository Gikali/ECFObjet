package com.ECFObjet.entites;
import java.util.ArrayList;

public class GestionnaireProspect {
    private static ArrayList<ClasseProspect> gestprospect = new ArrayList<>();

    public static void ajoutProspect(ClasseProspect prospects){
        gestprospect.add(prospects);
    }
    public static ArrayList<ClasseProspect> getGestProspect(){
        return gestprospect;
    }
}
