/*
Noms : Bocahut Manon, Février Titouan
Groupe : TDC
Rôle : Création de la partie
Date : 18/11/2021
 */
package version4.pkg0;

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
    
    
    public void initialiserPartie() {
        grillejeu.viderGrille();
        
        System.out.println("Joueur 1 comment voulez-vous vous appeler ?");
        Scanner sc = new Scanner(System.in);
        String nomjoueur1 = sc.nextLine();
        Joueur J1 = new Joueur(nomjoueur1);
        System.out.println("Joueur 2 comment voulez-vous vous appeler ?");
        sc = new Scanner(System.in);
        String nomjoueur2 = sc.nextLine();
        Joueur J2 = new Joueur(nomjoueur2);
        
        ListeJoueurs[0]=J1;
        ListeJoueurs[1]=J2;
        
        attribuerCouleursAuxJoueurs();
        
        Jeton jetonjoueur1 = new Jeton(ListeJoueurs[0].couleur);
        ListeJoueurs[0].ajouterJeton(jetonjoueur1);
        Jeton jetonjoueur2 = new Jeton(ListeJoueurs[1].couleur);
        ListeJoueurs[1].ajouterJeton(jetonjoueur2);
        
        Random generateurAleatdesintrounoir = new Random();
        int desintrounoir1 = generateurAleatdesintrounoir.nextInt(4);
        int desintrounoir2 = generateurAleatdesintrounoir.nextInt(4);
        while(desintrounoir2==desintrounoir1) {
            desintrounoir2 = generateurAleatdesintrounoir.nextInt(4);
        }
        
        for(int i=0; i<5; i++) {
            Random generateurAleat = new Random();
            int lignetrounoir = generateurAleat.nextInt(6);
            int colonnetrounoir = generateurAleat.nextInt(7);
            if(grillejeu.placerTrouNoir(lignetrounoir, colonnetrounoir)==false) {
                i--;
            }
            if(i==desintrounoir1 || i==desintrounoir2) {
                grillejeu.placerDesintegrateur(lignetrounoir, colonnetrounoir);
            }
        }
        
        for(int i=0; i<3; i++) {
            Random generateurAleat = new Random();
            int lignedesintegrateur = generateurAleat.nextInt(6);
            int colonnedesintegrateur = generateurAleat.nextInt(7);
            if(grillejeu.placerDesintegrateur(lignedesintegrateur, colonnedesintegrateur)==false) {
                i--;
            }
            else if(grillejeu.CellulesJeu[lignedesintegrateur][colonnedesintegrateur].trouNoir==true) {
                i--;
            }
        }
    }
    public void debuterPartie() {
        boolean égalitérécup = false;
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
        while(grillejeu.etreGagnantePourJoueur(joueurPrécédent) == false && grillejeu.etreGagnantePourJoueur(joueurCourant)==false && grillejeu.etreRemplie() == false) {
            System.out.println(joueurCourant.nom + " à vous de jouer!");
            System.out.println("Que voulez-vous faire ?\n1°Jouer un Jeton\n2°Récupérer un Jeton\n3°Désintégrer un Jeton");
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
                    System.out.println("Impossible de jouer un jeton car vous n'en avez plus, vous ne pouvez qu'en récupérer!");
                    choixdejeu = sc.nextInt();
                }
            }
            else if(joueurCourant.nombreDesintegrateurs==0 || joueurPrécédent.nombreJetonsRestants==21) {
                while(choixdejeu==3) {
                    System.out.println("Impossible de désintégrer un jeton (vérifier qu'il y a des jetons adverses à désintégrer ou que vous avez en votre possession un désintégrateur)!");
                    choixdejeu = sc.nextInt();
                }
            }
            while(choixdejeu!=1 && choixdejeu!=2 && choixdejeu!=3) {
                System.out.println("Impossible, il faut choisir entre 1, 2 et 3!");
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
            
                if (grillejeu.ajouterJetonDansColonne(joueurCourant.ListeJetons[joueurCourant.nombreJetonsRestants-1], colonnechoisie)) {
                    if (grillejeu.CellulesJeu[i][colonnechoisie].presenceTrouNoir()==true) {
                        grillejeu.CellulesJeu[i][colonnechoisie].activerTrouNoir();
                        System.out.println("Vous tombez dans un trou noir!");
                        if (grillejeu.CellulesJeu[i][colonnechoisie].presenceDesintegrateur()==true) {
                            joueurCourant.obtenirDesintegrateur();
                            grillejeu.CellulesJeu[i][colonnechoisie].récupérerDesintegrateur();
                            System.out.println("Génial! Vous avez obtenu un désintégrateur!💣");
                        }
                    }    
                    else if(grillejeu.CellulesJeu[i][colonnechoisie].presenceDesintegrateur()==true) {
                        joueurCourant.obtenirDesintegrateur();
                        grillejeu.CellulesJeu[i][colonnechoisie].récupérerDesintegrateur();
                        System.out.println("Génial! Vous avez obtenu un désintégrateur!💣");
                    }
                }
                joueurCourant.ListeJetons[joueurCourant.nombreJetonsRestants-1]=null;
                joueurCourant.nombreJetonsRestants--;
                System.out.println(joueurCourant.nom + " il vous reste " + joueurCourant.nombreJetonsRestants + " jetons restants!");
                if (joueurCourant.nombreDesintegrateurs>0) {
                    System.out.print(joueurCourant.nom + " vous avez");
                    for(int j=0; j<joueurCourant.nombreDesintegrateurs; j++) {
                    System.out.print(" 💣 ");
                    }
                    System.out.println("\n");
                }
                else {
                    System.out.println(joueurCourant.nom + " vous n'avez pas de désintégrateurs");
                }
                
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
                grillejeu.tasserGrille();
                grillejeu.afficherGrilleSurConsole();
                System.out.println(joueurCourant.nom + " il vous reste " +joueurCourant.nombreJetonsRestants + " jetons restants!");
                if (joueurCourant.nombreDesintegrateurs>0) {
                    System.out.print(joueurCourant.nom + " vous avez");
                    for(int j=0; j<joueurCourant.nombreDesintegrateurs; j++) {
                    System.out.print(" 💣 ");
                    }
                    System.out.println("\n");
                }
                else {
                    System.out.println(joueurCourant.nom + " vous n'avez pas de désintégrateurs");
                }
                if(grillejeu.etreGagnantePourJoueur(joueurCourant) && grillejeu.etreGagnantePourJoueur(joueurPrécédent)) {
                    égalitérécup = true;
                }
                if (joueurCourant==ListeJoueurs[0]) {
                        joueurCourant = ListeJoueurs[1];
                        joueurPrécédent=ListeJoueurs[0];
                    }
                else {
                    joueurCourant = ListeJoueurs[0];
                    joueurPrécédent=ListeJoueurs[1];
                }
            }
            else if(choixdejeu==3) {
                System.out.println("Choisissez un jeton à désintégrer");
                System.out.println("Quelle ligne choisissez-vous ? (de 0 à 5)");
                int lignejetonàdésintégrer = sc.nextInt();
                while(lignejetonàdésintégrer<0 || lignejetonàdésintégrer>5) {
                    System.out.println("Erreur, vous devez choisir un numéro de ligne compris entre 0 et 5!");
                    lignejetonàdésintégrer = sc.nextInt();
                }
                System.out.println("Quelle colonne choisissez-vous ? (de 0 à 6)");
                int colonnejetonàdésintégrer = sc.nextInt();
                while(colonnejetonàdésintégrer<0 || colonnejetonàdésintégrer>6) {
                    System.out.println("Erreur, vous devez choisir un numéro de colonne compris entre 0 et 6!");
                    colonnejetonàdésintégrer = sc.nextInt();
                }
                while (grillejeu.CellulesJeu[lignejetonàdésintégrer][colonnejetonàdésintégrer].jetonCourant==null || grillejeu.CellulesJeu[lignejetonàdésintégrer][colonnejetonàdésintégrer].jetonCourant.couleur!=joueurPrécédent.couleur) {
                    System.out.println("Il n'y a pas de jeton adverse à désintégrer ici!");
                    System.out.println("Quelle ligne choisissez-vous ? (de 0 à 5)");
                    lignejetonàdésintégrer = sc.nextInt();
                    while(lignejetonàdésintégrer<0 || lignejetonàdésintégrer>5) {
                        System.out.println("Erreur, vous devez choisir un numéro de ligne compris entre 0 et 5!");
                        lignejetonàdésintégrer = sc.nextInt();
                    }
                    System.out.println("Quelle colonne choisissez-vous ? (de 0 à 6)");
                    colonnejetonàdésintégrer = sc.nextInt();
                    while(colonnejetonàdésintégrer<0 || colonnejetonàdésintégrer>6) {
                        System.out.println("Erreur, vous devez choisir un numéro de colonne compris entre 0 et 6!");
                        colonnejetonàdésintégrer = sc.nextInt();
                    }
                }
                grillejeu.supprimerJeton(lignejetonàdésintégrer, colonnejetonàdésintégrer);
                joueurCourant.utiliserDesintegrateur();
                grillejeu.tasserGrille();
                grillejeu.afficherGrilleSurConsole();
                System.out.println(joueurCourant.nom + " il vous reste " +joueurCourant.nombreJetonsRestants + " jetons restants!");
                if (joueurCourant.nombreDesintegrateurs>0) {
                    System.out.print(joueurCourant.nom + " vous avez");
                    for(int j=0; j<joueurCourant.nombreDesintegrateurs; j++) {
                    System.out.print(" 💣 ");
                    }
                    System.out.println("\n");
                }
                else {
                    System.out.println(joueurCourant.nom + " vous n'avez pas de désintégrateurs");
                }
                if(grillejeu.etreGagnantePourJoueur(joueurCourant) && grillejeu.etreGagnantePourJoueur(joueurPrécédent)) {
                    égalitérécup = true;
                }
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
        if(égalitérécup==true) {
            System.out.println("Faute de jeu!" + joueurCourant.nom + " gagne la partie!");
        }
        else if(grillejeu.etreGagnantePourJoueur(joueurPrécédent) == true) {
            System.out.println(joueurPrécédent.nom + " gagne la partie!");
        }
        else if(grillejeu.etreGagnantePourJoueur(joueurCourant) == true) {
            System.out.println(joueurCourant.nom + " gagne la partie!");
        }
        else {
            System.out.println("Partie terminée, la grille est pleine!");
        }
    }    
}
