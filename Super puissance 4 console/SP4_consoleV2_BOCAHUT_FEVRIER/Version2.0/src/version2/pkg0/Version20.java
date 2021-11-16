/*
Noms : Bocahut Manon, Février Titouan
Groupe : TDC
Rôle : Super puissance 4 Version 2.0 en mode console : ajout des trous noirs
Date : 14/11/2021
 */
package version2.pkg0;
import java.util.Arrays;

/**
 *
 * @author titou
 */
public class Version20 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Joueur J1 = new Joueur("Titouan");
        Joueur J2 = new Joueur("Manon");
        Partie Game = new Partie(J1, J2);
        Game.attribuerCouleursAuxJoueurs();
        Game.ListeJoueurs[0]=J1;
        Game.ListeJoueurs[1]=J2;
        Jeton jetonJ1 = new Jeton(J1.couleur);
        Jeton jetonJ2 = new Jeton(J2.couleur);
        for (int i=0; i<21; i++) {
            J1.ListeJetons[i]=jetonJ1;
            J2.ListeJetons[i]=jetonJ2;
        }
        J1.ajouterJeton(jetonJ1);
        J2.ajouterJeton(jetonJ2);
        Game.initialiserPartie();
        Game.debuterPartie();        
    }
    
}
