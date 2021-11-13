/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package version.pkg1.pkg0;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author titou
 */
public class Partie {
    Joueur [] ListeJoueurs = new Joueur [2];
    Joueur joueurCourant;
    Grille grillejeu;
    
    public void attribuerCouleursAuxJoueurs() {
        Random generateurAleat = new Random();
        int joueur = generateurAleat.nextInt(3);
        while(joueur==0) {
            joueur = generateurAleat.nextInt(3);
        }
        if(joueur==1) {
            ListeJoueurs[0].affecterCouleur("rouge");
            System.out.println(ListeJoueurs[0].nom + " vous êtes les rouges!");
            ListeJoueurs[1].affecterCouleur("jaune");
            System.out.println(ListeJoueurs[1].nom + " vous êtes les jaunes!");
        }
        else {
            ListeJoueurs[0].affecterCouleur("jaune");
            System.out.println(ListeJoueurs[0].nom + " vous êtes les jaunes!");
            ListeJoueurs[1].affecterCouleur("rouge");
            System.out.println(ListeJoueurs[1].nom + " vous êtes les rouges!");
        }
    }
    
    public Partie(Joueur joueur1, Joueur joueur2) {
        ListeJoueurs[0] = joueur1;
        ListeJoueurs[1] = joueur2;
    }
    
    public void initialiserPartie() {
        grillejeu = new Grille();
        Jeton jetonjoueur1 = new Jeton(ListeJoueurs[0].couleur);
        ListeJoueurs[0].ajouterJeton(jetonjoueur1);
        Jeton jetonjoueur2 = new Jeton(ListeJoueurs[1].couleur);
        ListeJoueurs[1].ajouterJeton(jetonjoueur2);
    }
    public void debuterPartie() {
        Random generateurAleat = new Random();
        int firstplayer = generateurAleat.nextInt(2);
        Joueur joueurPrécédent;
        String couleuraléat;
        if (firstplayer==0) {
            couleuraléat = "rouge";
        }
        else {
            couleuraléat = "jaune";
        }
        if (ListeJoueurs[0].couleur==couleuraléat) {
            joueurCourant=ListeJoueurs[0];
            joueurPrécédent = ListeJoueurs[1];
        }
        else {
            joueurCourant=ListeJoueurs[1];
            joueurPrécédent = ListeJoueurs[0];
        }
        grillejeu.afficherGrilleSurConsole();
        while(grillejeu.etreGagnantePourJoueur(joueurPrécédent) == false && grillejeu.etreRemplie() == false) {
            
            System.out.println(joueurCourant.nom + ", choisissez une colonne");
            Scanner sc = new Scanner(System.in);
            int colonnechoisie = sc.nextInt();
            while (colonnechoisie<0 || colonnechoisie>6) {
                System.out.println("Valeur impossible, il faut choisir entre 0 et 6 inclus!");
                colonnechoisie = sc.nextInt();
            }
            
            grillejeu.ajouterJetonDansColonne(joueurCourant.ListeJetons[joueurCourant.nombreJetonsRestants-1], colonnechoisie);
            if (joueurCourant==ListeJoueurs[0]) {
                joueurCourant = ListeJoueurs[1];
                joueurPrécédent=ListeJoueurs[0];
            }
            else {
                joueurCourant = ListeJoueurs[0];
                joueurPrécédent=ListeJoueurs[1];
            }
            grillejeu.afficherGrilleSurConsole();
        }
        if (grillejeu.etreGagnantePourJoueur(joueurPrécédent) == true) {
            System.out.println(joueurPrécédent.nom + " gagne la partie!");
        }
        else {
            System.out.println("Partie terminée, la grille est pleine!");
        }
    }
}