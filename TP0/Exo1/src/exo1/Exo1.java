/*
Noms : Bocahut Manon, Février Titouan
Groupe : TDC
Rôle : Affichage d'un message
Date : 27/09/2021
*/
package exo1;

import java.util.Scanner;

/**
 *
 * @author titou
 */
public class Exo1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        System.out.println("Bonjour"); /* commande de renvoi */
        System.out.println("Au-revoir!");
        
        String prenom; /* initialisation variable */
        Scanner sc; /* méthode pour saisir des informations au clavier */
        sc = new Scanner(System.in);
        System.out.println("Salut, comment tu t'appelles ?");
        prenom = sc.nextLine();
        
    }
    
}
