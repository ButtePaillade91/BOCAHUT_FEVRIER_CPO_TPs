/*
Noms : Bocahut Manon, Février Titouan
Groupe : TDC
Rôle : Saisie et manipulation des nombres
Date : 08/10/2021
*/
package tp1_manipnombresint_bocahut_fevrier;

import java.util.Scanner;

/**
 *
 * @author titou
 */
public class TP1_manipNombresInt_BOCAHUT_FEVRIER {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
       System.out.println("Saisir un entier"); // demande à l'utilisateur de saisir un nombre
       int x;
       Scanner sc = new Scanner(System.in);
       x = sc.nextInt();
       System.out.println("Saisir un entier");
       int y;
       y =sc.nextInt();
       System.out.println("Vos entiers sont");
       System.out.println(x);
       System.out.println(y);
       
       System.out.println("La somme de ces entiers est : " + (x+y)); // réalisation d'opérations mathématiques sur les entiers rentrés préalablement
       System.out.println("La différence de ces entiers est : " + (x-y));
       System.out.println("Le produit de ces entiers est : " + x*y);
       
       System.out.println("Le quotient de ces entiers est : " + x/y + " et le reste de cette division est : " + x%y);
    }
    
}
