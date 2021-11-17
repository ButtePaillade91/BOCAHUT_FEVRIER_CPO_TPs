/*
Noms : Bocahut Manon, Février Titouan
Groupe : TDC
Rôle : Création de la partie
Date : 16/11/2021
 */
package version3.pkg0;

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
            System.out.println("\n\n\n\n" + ListeJoueurs[0].nom + " vous êtes les rouges!");
            ListeJoueurs[1].affecterCouleur("jaune");
            System.out.println(ListeJoueurs[1].nom + " vous êtes les jaunes!");
        }
        else {
            ListeJoueurs[0].affecterCouleur("jaune");
            System.out.println("\n\n\n\n" + ListeJoueurs[0].nom + " vous êtes les jaunes!");
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
        for(int i=0; i<5; i++) {
            Random generateurAleat = new Random();
            int lignetrounoir = generateurAleat.nextInt(6);
            int colonnetrounoir = generateurAleat.nextInt(7);
            if(grillejeu.placerTrouNoir(lignetrounoir, colonnetrounoir)==false) {
                i--;
            }
        }
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
            System.out.println(joueurCourant.nom + " à vous de jouer!");
            System.out.println("Que voulez-vous faire ?\n1°Jouer un Jeton\n2°Récupérer un Jeton");
            Scanner sc = new Scanner(System.in);
            int choixdejeu = sc.nextInt();
            if (joueurCourant.nombreJetonsRestants==21) {
                while(choixdejeu==2) {
                System.out.println("Impossible de récupérer un jeton, vous n'en avez joué aucun!");
                choixdejeu = sc.nextInt();
                }
            }
            else if(joueurCourant.nombreJetonsRestants==0) {
                while(choixdejeu==1) {
                    System.out.println("Impossible de jouer un jeton car vous n'en avez plus, vous ne pouvez qu'ne récupérer!");
                    choixdejeu = sc.nextInt();
                }
            }
            while(choixdejeu!=1 && choixdejeu!=2) {
                System.out.println("Impossible, il faut choisir entre 1 et 2!");
                choixdejeu = sc.nextInt();
            }   
        
            if(choixdejeu==1) {
                System.out.println(joueurCourant.nom + ", choisissez une colonne");
                sc = new Scanner(System.in);
                int colonnechoisie = sc.nextInt();
                while (colonnechoisie<0 || colonnechoisie>6) {
                    System.out.println("Valeur impossible, il faut choisir entre 0 et 6 inclus!");
                    colonnechoisie = sc.nextInt();
                }
                int i=0;
                while(i<=5 && grillejeu.CellulesJeu[i][colonnechoisie].jetonCourant!=null) {
                    i++;
                }
            
                if (grillejeu.ajouterJetonDansColonne(joueurCourant.ListeJetons[joueurCourant.nombreJetonsRestants-1], colonnechoisie)==true && grillejeu.CellulesJeu[i][colonnechoisie].presenceTrouNoir()==true) {
                    grillejeu.CellulesJeu[i][colonnechoisie].activerTrouNoir();
                    System.out.println("Vous tombez dans un trou noir!");
                }
                joueurCourant.ListeJetons[joueurCourant.nombreJetonsRestants-1]=null;
                joueurCourant.nombreJetonsRestants--;
                System.out.println(joueurCourant.nom + " il vous reste " +joueurCourant.nombreJetonsRestants + " jetons restants!");
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
            else if(choixdejeu==2) {
                System.out.println("Choisissez un jeton à récupérer");
                System.out.println("Quelle ligne choisissez-vous ? (de 0 à 5)");
                int lignejeton = sc.nextInt();
                while(lignejeton<0 || lignejeton>5) {
                    System.out.println("Erreur, vous devez choisir un numéro de ligne compris entre 0 et 5!");
                    lignejeton = sc.nextInt();
                }
                System.out.println("Quelle colonne choisissez-vous ? (de 0 à 6)");
                int colonnejeton = sc.nextInt();
                while(colonnejeton<0 || colonnejeton>6) {
                    System.out.println("Erreur, vous devez choisir un numéro de colonne compris entre 0 et 6!");
                    colonnejeton = sc.nextInt();
                }
                while(grillejeu.CellulesJeu[lignejeton][colonnejeton].jetonCourant==null || grillejeu.CellulesJeu[lignejeton][colonnejeton].jetonCourant.couleur!=joueurCourant.couleur) {
                    System.out.println("Il est impossible de récupérer un jeton dans cette case, veuillez réessayer !");
                    System.out.println("Choisissez un jeton à récupérer");
                    System.out.println("Quelle ligne choisissez-vous ? (de 0 à 5)");
                    lignejeton = sc.nextInt();
                    while(lignejeton<0 || lignejeton>5) {
                        System.out.println("Erreur, vous devez choisir un numéro de ligne compris entre 0 et 5!");
                        lignejeton = sc.nextInt();
                    }
                    System.out.println("Quelle colonne choisissez-vous ? (de 0 à 6)");
                    colonnejeton = sc.nextInt();
                    while(colonnejeton<0 || colonnejeton>6) {
                        System.out.println("Erreur, vous devez choisir un numéro de colonne compris entre 0 et 6!");
                        colonnejeton = sc.nextInt();
                    }
                }
                Jeton jetonàrécupérer = grillejeu.recupererJeton(lignejeton, colonnejeton);
                joueurCourant.ajouterJeton(jetonàrécupérer);
                grillejeu.tasserGrille(colonnejeton);
                System.out.println(joueurCourant.nom + " il vous reste " +joueurCourant.nombreJetonsRestants + " jetons restants!");
                if (joueurCourant==ListeJoueurs[0]) {
                        joueurCourant = ListeJoueurs[1];
                        joueurPrécédent=ListeJoueurs[0];
                    }
                else {
                    joueurCourant = ListeJoueurs[0];
                    joueurPrécédent=ListeJoueurs[1];
                }
            }
        }
        if (grillejeu.etreGagnantePourJoueur(joueurPrécédent) == true) {
            System.out.println(joueurPrécédent.nom + " gagne la partie!");
        }
        else {
            System.out.println("Partie terminée, la grille est pleine!");
        }
    }    
}
