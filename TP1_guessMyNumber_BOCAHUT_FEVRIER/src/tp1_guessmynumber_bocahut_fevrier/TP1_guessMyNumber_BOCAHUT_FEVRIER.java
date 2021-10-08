/*
Noms : Bocahut Manon, Février Titouan
Groupe : TDC
Rôle : Réaliser un jeu type "Guess My Number"
Date : 08/10/2021
*/
package tp1_guessmynumber_bocahut_fevrier;

import java.util.Random;
import java.util.Scanner;
/**
 *
 * @author titou
 */
public class TP1_guessMyNumber_BOCAHUT_FEVRIER {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Random generateurAleat = new Random();
        /*
        for (int i=0; i<5; i++) {
            int n = generateurAleat.nextInt(100);
            System.out.println(n);
        }
        */
        System.out.println("Choisissez un mode de difficulté : \n1)Facile\n2)Normal\n3)Difficile");
        int lvl;
        int nbuser=0;
        int compteur=0;
        Scanner scan = new Scanner(System.in);
        lvl = scan.nextInt();
        while (lvl!=1 && lvl!=2 && lvl!=3) {
            System.out.println("Valeur impossible, les valeurs possibles sont : 1,2 ou 3!\nEntre une nouvelle valeur!");
            Scanner scanaire = new Scanner(System.in);
            lvl = scanaire.nextInt();
        }
        if (lvl == 1) {
            int nbordi = generateurAleat.nextInt(100);
            System.out.println("Saisissez un nombre entre 0 et 100");
            while (nbuser!=nbordi) {
                Scanner sc = new Scanner(System.in);
                nbuser = sc.nextInt();
                compteur+=1;
                if (nbuser>nbordi) {
                    if (nbuser-nbordi>=25) {
                        System.out.println("vraiement trop grand");
                        System.out.println("Essaye encore!");
                    }
                    else {
                        System.out.println("trop grand");
                        System.out.println("Essaye encore!");
                    }
                }
                else if (nbuser<nbordi) {
                    if (nbordi-nbuser>=25) {
                        System.out.println("vraiement trop petit");
                        System.out.println("Essaye encore!");
                    }
                    else {
                        System.out.println("trop petit");
                        System.out.println("Essaye encore!");
                    }
                }
            }    
        }
        else if (lvl==2) {
            int nbordi = generateurAleat.nextInt(1000);
            System.out.println("Saisissez un nombre entre 0 et 1000");
            while (nbuser!=nbordi) {
                Scanner sc = new Scanner(System.in);
                nbuser = sc.nextInt();
                compteur+=1;
                if (nbuser>nbordi) {
                    System.out.println("trop grand");
                    System.out.println("Essaye encore!");
                }
                else {
                    System.out.println("trop petit");
                    System.out.println("Essaye encore!");
                    }
                }
        }
        else {
            int nbordi = generateurAleat.nextInt(10000);
            System.out.println("Saisissez un nombre entre 0 et 10000");
            while (nbuser!=nbordi) {
                Scanner sc = new Scanner(System.in);
                nbuser = sc.nextInt();
                compteur+=1;
                if (compteur==15) {
                    System.out.println("Trop d'essais, vous avez perdu !");
                    System.exit(0);
                }
                if (nbuser>nbordi) {
                    System.out.println("trop grand");
                    System.out.println("Essaye encore!");
                }
                else {
                    System.out.println("trop petit");
                    System.out.println("Essaye encore!");
                }
            }
        }
        System.out.println("gagné\nNombre d'essais : " + compteur);
}
    
}
