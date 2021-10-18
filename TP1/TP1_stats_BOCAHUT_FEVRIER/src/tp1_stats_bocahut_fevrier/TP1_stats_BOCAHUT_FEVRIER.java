/*
Noms : Bocahut Manon, Février Titouan
Groupe : TDC
Rôle : Vérification de la distribution du générateur de nombres aléatoires
Date : 08/10/2021
 */
package tp1_stats_bocahut_fevrier;

import java.util.Random;
import java.util.Scanner;
/**
 *
 * @author titou
 */
public class TP1_stats_BOCAHUT_FEVRIER {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Random generateurAleat = new Random(); // créatoin de la procédure pour générer un nombre aléatoire
        int [] Dé = new int[6]; // création d'un tableau contenant les vleurs des faces d'un dé
        for (int i=0; i<Dé.length; i++ ) {
            Dé[i]=0;
        }
        
        int m;
        System.out.println("Saisissez un nombre entier : ");
        Scanner scan = new Scanner(System.in);
        m = scan.nextInt();
        
        for (int j = 0; j<m ; j++) {
            int nbrandom = generateurAleat.nextInt(6); //6 car si l'on met 5, seulement 5 valeurs sont tirées et non 6 (0 à 5)!
            Dé[nbrandom]+=1;
        
        }
        /*
        for (int k = 0; k<Dé.length; k++) {
            System.out.println(Dé[k]);
        }
        */
        for (int l=0; l<Dé.length; l++) { // boucle visant à couvrir tous les résultats possibles des 6 faces et à relever une statistiques quand à leur probabilité d'être tirée
            double resfinal = (Dé[l]*100.0)/m;
            System.out.println(resfinal + "%");
        }
    }
    
}
