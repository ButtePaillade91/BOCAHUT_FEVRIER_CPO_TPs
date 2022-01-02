/*
Noms : Bocahut Manon, Février Titouan
Groupe : TDC
Rôle : Création classe partie
Date : 06/12/2021
 */
package bocahut_fevrier_mastermind;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author titou
 */
public class Partie {
    Plateau plateaujeu = new Plateau();
    String Combinaison[] = new String [4];
    
    public void initialiserPartie() {
        //rouge, jaune, bleu, noir, vert, blanc, violet, cyan
        plateaujeu.viderPlateau();
        
        
        plateaujeu.Combinaison();
        //System.out.println("Solution:");
        for(int i=0;i<4;i++) {
            Combinaison[i]=plateaujeu.Combinaison[i];
            //System.out.println(Combinaison[i]);
        }
        plateaujeu.afficherPlateauSurConsole();  
    }
    
    public void debuterPartie() {
        int lignedejeu=0;
        while(plateaujeu.EtreGagnante(lignedejeu-1) == false && lignedejeu<12) {
            int couleurjouées=0;
            while(couleurjouées!=5) {
                System.out.println("Choisissez une colonne de 0 à 3");
                Scanner sc1 = new Scanner(System.in);
                int colonnechoisie = sc1.nextInt();
                while(colonnechoisie!=0 && colonnechoisie!=1 && colonnechoisie!=2 && colonnechoisie!=3) {
                    System.out.println("Incorrect \nChoisissez une colonne de 0 à 3");
                    sc1 = new Scanner(System.in);
                    colonnechoisie = sc1.nextInt();
                }

                System.out.println("Choississez une couleur \nChoix possibles : rouge, jaune, bleu, noir, vert, blanc, violet, cyan");
                Scanner sc2 = new Scanner(System.in);
                String couleurchoisie = sc2.nextLine();
                while(!"rouge".equals(couleurchoisie) && !"jaune".equals(couleurchoisie) && !"bleu".equals(couleurchoisie) && !"noir".equals(couleurchoisie) && !"vert".equals(couleurchoisie) && !"blanc".equals(couleurchoisie) && !"violet".equals(couleurchoisie) && !"cyan".equals(couleurchoisie)) {
                    System.out.println("Incorrect \nChoississez une couleur \nChoix possibles : rouge, jaune, bleu, noir, vert, blanc, violet, cyan");
                    sc2 = new Scanner(System.in);
                    couleurchoisie = sc2.nextLine();
                }
                
                if(plateaujeu.CellulesPlateau[lignedejeu][colonnechoisie].pionCourant==null) {
                    Pion pionaplacer = new Pion(couleurchoisie);
                    plateaujeu.CellulesPlateau[lignedejeu][colonnechoisie].affecterPion(pionaplacer);
                    couleurjouées++;
                } 
                plateaujeu.CellulesPlateau[lignedejeu][colonnechoisie].pionCourant.couleur=couleurchoisie;
                if(couleurjouées==4) {
                    plateaujeu.afficherPlateauSurConsole();
                    System.out.println("Combinaison choisie ? \nOUI ? \nNON ?");
                    Scanner sc3 = new Scanner(System.in);
                    String choix = sc3.nextLine();
                    while(!"oui".equals(choix) && !"non".equals(choix) && !"OUI".equals(choix) && !"NON".equals(choix)) {
                        System.out.println("Incorrect \nCombinaison choisie ? \nOUI ? \nNON ?");
                        sc3 = new Scanner(System.in);
                        choix = sc3.nextLine();
                    }
                    if("OUI".equals(choix) || "oui".equals(choix)) {
                        couleurjouées=5;
                    }
                }
                plateaujeu.afficherPlateauSurConsole();
            }
            plateaujeu.Correction(lignedejeu);
            lignedejeu++;
        }
        if(lignedejeu<12) {
            System.out.println("Vous avez gagné la partie en " + lignedejeu + " tentative(s)!");
        }
        else {
            System.out.println("Vous avez perdu la partie car il ne vous reste plus aucun coup disponible!");
        }
    }
}
