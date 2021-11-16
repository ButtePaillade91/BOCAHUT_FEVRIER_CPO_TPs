/*
Noms : Bocahut Manon, Février Titouan
Groupe : TDC
Rôle : Création de la grille
Date : 14/11/2021
 */
package version2.pkg0;
import java.util.Random;

/**
 *
 * @author titou
 */
public class Grille {
    Cellule [][] CellulesJeu = new Cellule [6][7];
    
    public Grille() {
        for(int i=0; i<6; i++) {
            for(int j=0; j<7; j++) {
                CellulesJeu[i][j] = new Cellule();
            }
        }
    }
    public boolean ajouterJetonDansColonne(Jeton jetonaajouter, int nbcolonne) {
        if (CellulesJeu [5][nbcolonne].jetonCourant!=null) {
            System.out.println("Impossible car la colonne est déjà pleine (colonne" + nbcolonne + ")");    
            return(false);
        }
        else{
            int i=0;
            while(CellulesJeu[i][nbcolonne].jetonCourant!=null) {
                i+=1;
            }
            CellulesJeu[i][nbcolonne].affecterJeton(jetonaajouter);
            return(true);
        }

    }
    public boolean etreRemplie() {
        for(int i=0; i<6; i++) {
            for(int j=0; j<7; j++) {
                if(CellulesJeu[i][j].jetonCourant==null) {
                    return(false);
                }
            }
        }
        return(true);
    }
    public void viderGrille() {
        CellulesJeu = new Cellule [6][7];
        for(int i=0; i<6; i++) {
            for(int j=0; j<7; j++) {
                CellulesJeu[i][j] = new Cellule();
            }
        }
    }
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_RED_BACKGROUND = "\u001B[41m";
    public static final String ANSI_YELLOW_BACKGROUND = "\u001B[43m";
    
    public void afficherGrilleSurConsole() {
        for (int i=5 ; i>-1 ; i--) {
            for (int j=0 ; j<7 ; j++) {
                if(CellulesJeu[i][j].jetonCourant!=null) {
                    String c = CellulesJeu[i][j].lireCouleurDuJeton();
                    if (c=="rouge") {
                        System.out.print(ANSI_RED_BACKGROUND + " • " + ANSI_RESET);
                    }
                    else if (c=="jaune") {
                        System.out.print(ANSI_YELLOW_BACKGROUND + " • " +ANSI_RESET);
                    }                   
                }
                else if (CellulesJeu[i][j].presenceTrouNoir()==true) {
                    System.out.print(" ● ");
                }
                else {
                    System.out.print(" O ");
                }
            }
            System.out.println("");
        }
    }
    public boolean celluleOccupée(int ligne, int colonne) {
        int i = ligne;
        int j = colonne;
        if (CellulesJeu[i][j]!=null) {
            return(true);
        }
        else {
            return(false);
        }
    }
    public String lireCouleurDuJeton(int ligne, int colonne) {
        int i = ligne;
        int j = colonne;
        return(CellulesJeu[i][j].lireCouleurDuJeton());
    }
    public boolean etreGagnantePourJoueur(Joueur joueur) {
        for (int i=0; i<6; i++) {
            for (int j=0; j<4; j++) {
                if (CellulesJeu[i][j].lireCouleurDuJeton() == CellulesJeu[i][j+1].lireCouleurDuJeton() && CellulesJeu[i][j].lireCouleurDuJeton() == CellulesJeu[i][j+2].lireCouleurDuJeton() && CellulesJeu[i][j].lireCouleurDuJeton() == CellulesJeu[i][j+3].lireCouleurDuJeton() && CellulesJeu[i][j].lireCouleurDuJeton() == joueur.couleur) { //alignement horizontal positif
                    return(true);
                }    
            } 
        }
        for(int i=0; i<3; i++) {
            for(int j=0; j<7; j++) {
                if (CellulesJeu[i][j].lireCouleurDuJeton() == CellulesJeu[i+1][j].lireCouleurDuJeton() && CellulesJeu[i][j].lireCouleurDuJeton() == CellulesJeu[i+2][j].lireCouleurDuJeton() && CellulesJeu[i][j].lireCouleurDuJeton() == CellulesJeu[i+3][j].lireCouleurDuJeton() && CellulesJeu[i][j].lireCouleurDuJeton() == joueur.couleur) {
                    return(true);
                }
            }
        }
        for(int i=0; i<3; i++) {
            for(int j=0; j<4; j++) {
                if(CellulesJeu[i][j].lireCouleurDuJeton() == CellulesJeu[i+1][j+1].lireCouleurDuJeton() && CellulesJeu[i][j].lireCouleurDuJeton() == CellulesJeu[i+2][j+2].lireCouleurDuJeton() && CellulesJeu[i][j].lireCouleurDuJeton() == CellulesJeu[i+3][j+3].lireCouleurDuJeton() && CellulesJeu[i][j].lireCouleurDuJeton() == joueur.couleur) {
                    return(true);
                }
            }
        }
        for(int i=3; i<6; i++) {
            for(int j=0; j<4; j++) {
                if(CellulesJeu[i][j].lireCouleurDuJeton() == CellulesJeu[i-1][j+1].lireCouleurDuJeton() && CellulesJeu[i][j].lireCouleurDuJeton() == CellulesJeu[i-2][j+2].lireCouleurDuJeton() && CellulesJeu[i][j].lireCouleurDuJeton() == CellulesJeu[i-3][j+3].lireCouleurDuJeton() && CellulesJeu[i][j].lireCouleurDuJeton() == joueur.couleur) {
                    return(true);
                }
            }
        }
        return(false);
    }
    
    public boolean placerTrouNoir(int lignetrounoir, int colonnetrounoir) {
        if (CellulesJeu[lignetrounoir][colonnetrounoir].placertrouNoir()==true) {
            return(true);
        }
        else {
            return(false);
        }
        
    }
}
