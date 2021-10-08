/*
Noms : Bocahut Manon, Février Titouan
Groupe : TDC
Rôle : Convertisseur de températures
Date : 08/10/2021
*/
package tp1_convertisseur_bocahut_fevrier;

import java.util.Scanner;


/**
 *
 * @author titou
 */
public class TP1_convertisseur_BOCAHUT_FEVRIER {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
       System.out.println("Saisir une température");
       double x;
       Scanner sc = new Scanner(System.in);
       x = sc.nextDouble();
       System.out.println("La température en °Celsius est : " + x);
       double y = 273.15+x;
       System.out.println("La température en °Kelvin est : " + y);
       
       //En utilisant la fonction:
       System.out.println("Saisir une température");
       double C;
       Scanner sca = new Scanner(System.in);
       C = sca.nextDouble();
       System.out.println("La température en °Kelvin est : " + FarenheitVersKelvin(C));
       
    }
    public static double CelciusVersKelvin (double tCelcius) {
        double tKelvin  = 273.15+tCelcius;
        return(tKelvin);
    }
    public static double KelvinVersCelcius (double tKelvin) {
        double tCelcius  = tKelvin-273.15;
        return(tCelcius);
    }    
    public static double FarenheitVersCelcius (double tFarenheit) {
        double tCelcius  = (tFarenheit-32)/1.8;
        return(tCelcius);
    }    
    public static double CelciusVersFarenheit (double tCelcius) {
        double tFarenheit  = 1.8*tCelcius+32;
        return(tFarenheit);
    }
    public static double KelvinVersFarenheit (double tKelvin) {
        double tFarenheit = CelciusVersFarenheit(KelvinVersCelcius(tKelvin));
        return(tFarenheit);
    }
    public static double FarenheitVersKelvin (double tFarenheit) {
        double tKelvin = CelciusVersKelvin(FarenheitVersCelcius(tFarenheit));
        return(tKelvin);
    }
}
