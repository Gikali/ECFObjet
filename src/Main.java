import com.ECFObjet.entites.ClasseAdresse;
import com.ECFObjet.entites.ClasseClient;
import com.ECFObjet.entites.ClasseProspect;
import com.ECFObjet.vues.*;

import static com.ECFObjet.entites.GestionnaireClient.getGestClient;
import static com.ECFObjet.entites.GestionnaireProspect.getGestProspect;

public class Main {
    public static void main(String[] args) {

        new Accueil().setVisible(true);
        getGestClient().add(new ClasseClient("Société A",new ClasseAdresse(7,"rue Machin","Ville","54200"),"0678145231","dou@gmail.com",2500,25,""));
        getGestClient().add(new ClasseClient("Société B",new ClasseAdresse(7,"rue Machin","Ville","54200"),"0678145231","dou@gmail.com",2500,25,""));
        getGestProspect().add(new ClasseProspect("Société C",new ClasseAdresse(7,"rue Machin","Ville","54200"),"0678145231","dou@gmail.com","18/09/2024",true,""));
        getGestProspect().add(new ClasseProspect("Société D",new ClasseAdresse(7,"rue Machin","Ville","54200"),"0678145231","dou@gmail.com","18/09/2024",true,""));
    }
}