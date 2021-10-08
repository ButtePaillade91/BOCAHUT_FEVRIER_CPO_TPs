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
       /*System.out.println("Saisir une température");
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
       */
       
       //Programme final:
       System.out.println("Bonjour, saisissez une valeur : ");
       double température;
       Scanner sc = new Scanner(System.in);
       température = sc.nextDouble();
       System.out.println("Saisissez la conversion que vous souhaitez effectuer : \n1) De Celcius vers Kelvin\n2) De Kelvin vers Celcius\n3) De Farenheit vers Celcius\n4) De Celcius vers Farenheit\n5) De Kelvin vers Farenheit\n6) De Farenheit vers Kelvin");
       
       int choix;
       Scanner scan = new Scanner(System.in);
       choix = scan.nextInt();
       
       while(choix!=1 && choix!=2 && choix!=3 && choix!=4 && choix!=5 && choix!=6) {
           System.out.println("Valeur impossible, les valeurs possibles sont : 1,2,3,4,5,6!\nEntre une nouvelle valeur!");
           Scanner scanaire = new Scanner(System.in);
           choix = scanaire.nextInt();
       }
       double résultat=0;
       String te="";
       String ts="";
       if (choix==1) {
           résultat = CelciusVersKelvin(température);
           te = "Celcius";
           ts = "Kelvin";
       }
       else if (choix==2) {
           résultat = KelvinVersCelcius(température);
           te = "Kelvin";
           ts = "Celcius";
       }
       else if (choix==3) {
           résultat = FarenheitVersCelcius(température);
           te = "Farenheit";
           ts = "Celcius";
       }
       else if (choix==4) {
           résultat = CelciusVersFarenheit(température);
           te = "Celcius";
           ts = "Farenheit";
       }
       else if (choix==5) {
           résultat = KelvinVersFarenheit(température);
           te = "Kelvin";
           ts = "Farenheit";
       }
       else if (choix==6) {
           résultat = FarenheitVersKelvin(température);
           te = "Farenheit";
           ts = "Kelvin";
       }
       System.out.println(température + " degré " + te + " est égal à " + résultat + " degrés " + ts);
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
