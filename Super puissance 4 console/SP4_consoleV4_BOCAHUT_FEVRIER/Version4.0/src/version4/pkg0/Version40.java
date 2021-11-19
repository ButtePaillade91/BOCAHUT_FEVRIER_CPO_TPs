/*
Noms : Bocahut Manon, Février Titouan
Groupe : TDC
Rôle : Super puissance 4 Version 4.0 en mode console : ajout des désintégrateurs
Date : 14/11/2021
 */
package version4.pkg0;

import java.util.Scanner;

/**
 *
 * @author titou
 */
public class Version40 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
         // TODO code application logic here
        System.out.println("Joueur 1 comment voulez-vous vous appeler ?");
        Scanner sc = new Scanner(System.in);
        String nomjoueur1 = sc.nextLine();
        Joueur J1 = new Joueur(nomjoueur1);
        System.out.println("Joueur 2 comment voulez-vous vous appeler ?");
        sc = new Scanner(System.in);
        String nomjoueur2 = sc.nextLine();
        Joueur J2 = new Joueur(nomjoueur2);
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
