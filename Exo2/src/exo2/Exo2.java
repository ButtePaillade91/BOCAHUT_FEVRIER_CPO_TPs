/*
Noms : Bocahut Manon, Février Titouan
Groupe : TDC
Rôle : Addition d'entiers
Date : 27/09/2021
*/
package exo2;

import java.util.Scanner;

/**
 *
 * @author titou
 */
public class Exo2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        //Declaration des variables
        int nb; // nombre d'entiers a additionner
        Scanner sc = new Scanner(System.in);
        System.out.println("\n Entrer le nombre :");
        nb=sc.nextInt(); // On demande a sc de donner le prochain entier
        int result; // resultat
        int ind; //indice
        result=0;
        
        //Addition des nb premiers entiers
        ind=1;
        while (ind <= nb) {
            result=result+ind;
            ind++;
            
        }
        
        
        
        
        //Affichage du resultat
        System.out.println();
        System.out.println("La somme des " + nb + "entiers est: " +result);
    }

    private static void Int() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
