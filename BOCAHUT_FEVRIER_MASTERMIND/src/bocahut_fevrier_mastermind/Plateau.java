/*
Noms : Bocahut Manon, Février Titouan
Groupe : TDC
Rôle : Création classe plateau
Date : 06/12/2021
 */
package bocahut_fevrier_mastermind;

import java.util.Random;

/**
 *
 * @author titou
 */
public class Plateau {
    Cellule [][] CellulesPlateau = new Cellule[12][4];
    String Combinaison[] = new String [4];
    
    
    
    public Plateau() {
        for(int i=0; i<12; i++) {
            for(int j=0; j<4; j++) {
                CellulesPlateau[i][j] = new Cellule();
            }
        }
    }
    
    public void Combinaison() {
        String tabCouleurs[] = new String[8];
        tabCouleurs[0] = "rouge";
        tabCouleurs[1] = "jaune";
        tabCouleurs[2] = "bleu";
        tabCouleurs[3] = "noir";
        tabCouleurs[4] = "vert";
        tabCouleurs[5] = "blanc";
        tabCouleurs[6] = "violet";
        tabCouleurs[7] = "cyan";
        for (int i=0; i<4 ; i++) {
            Random generateurAleat = new Random();
            int codecouleurs = generateurAleat.nextInt(7);
            Combinaison[i] = tabCouleurs[codecouleurs];
        }
    }
    
    public void viderPlateau() {
        for(int i=0; i<12; i++) {
            for(int j=0; j<4; j++) {
                CellulesPlateau[i][j].pionCourant = null;
            }
        }
    }
    
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BLACK = "\u001B[30m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_WHITE = "\u001B[37m";
    
    public void afficherPlateauSurConsole() {
        //rouge, jaune, bleu, noir, vert, blanc, violet, cyan
        for (int i=11 ; i>-1 ; i--) {
            for (int j=0 ; j<4 ; j++) {
                if(CellulesPlateau[i][j].pionCourant!=null) {
                    String c = CellulesPlateau[i][j].lireCouleurDuPion();
                    if ("rouge".equals(c)) {
                        System.out.print(ANSI_RED + " ● " + ANSI_RESET);
                    }
                    else if ("jaune".equals(c)) {
                        System.out.print(ANSI_YELLOW + " ● " + ANSI_RESET);
                    }
                    else if ("bleu".equals(c)) {
                        System.out.print(ANSI_BLUE + " ● " + ANSI_RESET);
                    }
                    else if ("noir".equals(c)) {
                        System.out.print(ANSI_BLACK + " ● " + ANSI_RESET);
                    }  
                    else if ("vert".equals(c)) {
                        System.out.print(ANSI_GREEN + " ● " + ANSI_RESET);
                    }  
                    else if ("blanc".equals(c)) {
                        System.out.print(ANSI_WHITE + " ● " + ANSI_RESET);
                    }  
                    else if ("violet".equals(c)) {
                        System.out.print(ANSI_PURPLE + " ● " + ANSI_RESET);
                    }  
                    else if ("cyan".equals(c)) {
                        System.out.print(ANSI_CYAN + " ● " + ANSI_RESET);
                    }  
                }
                else {
                    System.out.print(" O ");
                }
            }
            System.out.println("");
        }
    }
    
    public boolean EtreGagnante(int ligne) {
        if(ligne==-1) {
            return(false);
        }
        int compteur=0;
        for (int i=0 ; i<4 ; i++) {
            if (CellulesPlateau[ligne][i].pionCourant.couleur.equals(Combinaison[i])) {
                compteur++;
            }
        }
        if(compteur==4) {
            return(true);
        }
        else {
            return(false);
        }
    }
    
    public void Correction(int ligne) {
        int compteurbons=0;
        int compteurmauvaiseplace=0;
        int incorrect=0;
        int combi0=0;
        int combi1=0;
        int combi2=0;
        int combi3=0;
        if (CellulesPlateau[ligne][0].pionCourant.couleur.equals(Combinaison[0])) {
            combi0++;
            compteurbons++;
        }
        if (CellulesPlateau[ligne][1].pionCourant.couleur.equals(Combinaison[1])) {
            combi1++;
            compteurbons++;
        }
        if (CellulesPlateau[ligne][2].pionCourant.couleur.equals(Combinaison[2])) {
            combi2++;
            compteurbons++;
        }
        if (CellulesPlateau[ligne][3].pionCourant.couleur.equals(Combinaison[3])) {
            combi3++;
            compteurbons++;
        }
        
        if(CellulesPlateau[ligne][0].pionCourant.couleur.equals(Combinaison[1])) {
            if(combi1==0) {
                combi1++;
                compteurmauvaiseplace++;
            }
        }
        else if(CellulesPlateau[ligne][0].pionCourant.couleur.equals(Combinaison[2])) {
            if(combi2==0) {
                combi2++;
                compteurmauvaiseplace++;
            }
        }
        else if(CellulesPlateau[ligne][0].pionCourant.couleur.equals(Combinaison[3])) {
            if(combi3==0) {
                combi3++;
                compteurmauvaiseplace++;
            }
        }

        if(CellulesPlateau[ligne][1].pionCourant.couleur.equals(Combinaison[0])) {
            if(combi0==0) {
                combi0++;
                compteurmauvaiseplace++;
            }
        }
        else if(CellulesPlateau[ligne][1].pionCourant.couleur.equals(Combinaison[2])) {
            if(combi2==0) {
                combi2++;
                compteurmauvaiseplace++;
            }
        }
        else if(CellulesPlateau[ligne][1].pionCourant.couleur.equals(Combinaison[3])) {
            if(combi3==0) {
                combi3++;
                compteurmauvaiseplace++;
            }
        }
        
        if(CellulesPlateau[ligne][2].pionCourant.couleur.equals(Combinaison[0])) {
            if(combi0==0) {
                combi0++;
                compteurmauvaiseplace++;
            }
        }
        else if(CellulesPlateau[ligne][2].pionCourant.couleur.equals(Combinaison[1])) {
            if(combi1==0) {
                combi1++;
                compteurmauvaiseplace++;
            }
        }
        else if(CellulesPlateau[ligne][2].pionCourant.couleur.equals(Combinaison[3])) {
            if(combi3==0) {
                combi3++;
                compteurmauvaiseplace++;
            }
        }
        
        if(CellulesPlateau[ligne][3].pionCourant.couleur.equals(Combinaison[0])) {
            if(combi0==0) {
                combi0++;
                compteurmauvaiseplace++;
            }
        }
        else if(CellulesPlateau[ligne][3].pionCourant.couleur.equals(Combinaison[1])) {
            if(combi1==0) {
                combi1++;
                compteurmauvaiseplace++;
            }
        }
        else if(CellulesPlateau[ligne][3].pionCourant.couleur.equals(Combinaison[2])) {
            if(combi2==0) {
                combi2++;
                compteurmauvaiseplace++;
            }
        }
        
        
        
        incorrect=4-(compteurbons+compteurmauvaiseplace);
        System.out.println("Il y a " + compteurbons +" pion(s) juste(s), " + compteurmauvaiseplace + " pion(s) mal(s) placé(s) et " + incorrect + " mauvais pion(s)");
    }
}