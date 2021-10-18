/*
Noms : Bocahut Manon, Février Titouan
Groupe : TDC
Rôle : Calculette
Date : 27/09/2021
*/
package calculator;

import java.util.Scanner;

/**
 *
 * @author titou
 */
public class Calculator {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        System.out.println("Please enter the operator:" + "\n1) add" + "\n2) substract" + "\n3) multiply" + "\n4) divide" + "\n5) modulo");
        int operateur;
        Scanner sc = new Scanner(System.in);
        operateur=sc.nextInt();
        
        if (operateur < 1) {
            System.out.println("La valeur saisie est impossible");
            System.exit(0);
        }else if (operateur > 5) {
            System.out.println("La valeur saisie est impossible");
            System.exit(0);
        }
        
        System.out.println("\nEntrer une valeur :");
        int operande1 = sc.nextInt();
        int operande2 = sc.nextInt();
        
        if (operateur == 1) {
            System.out.println("The result is : " + (operande1+operande2));
        }else if (operateur == 2) {
            System.out.println("The result is : " + (operande1-operande2));
        }else if (operateur == 3) {
            System.out.println("The result is : " + (operande1*operande2));
        }else if (operateur == 4) {
            System.out.println("The result is : " + (operande1/operande2));
        }else if (operateur == 5) {
            System.out.println("The result is : " + (operande1%operande2));
        }
    }
    
}
