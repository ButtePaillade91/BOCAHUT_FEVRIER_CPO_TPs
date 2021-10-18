/*
Noms : Bocahut Manon, Février Titouan
Groupe : TDC
Rôle : Convertir des températures
Date : 18/10/2021
 */
package tp2_convertisseurobjet_bocahut_fevrier;

import java.util.Scanner;

/**
 *
 * @author titou
 */
public class TP2_convertisseurObjet_BOCAHUT_FEVRIER {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Convertisseur convertisseur = new Convertisseur();
        convertisseur.FarenheitVersKelvin(25.0);
        convertisseur.KelvinVersFarenheit(25.0);
        
        Convertisseur secondconvertisseur = new Convertisseur();
        secondconvertisseur.CelciusVersKelvin(25.0);
        secondconvertisseur.FarenheitVersCelcius(25.0);
        secondconvertisseur.KelvinVersCelcius(25.0);
        
        System.out.println("Le premier convertisseur a converti " + convertisseur.nbConversions + " températures!");
        System.out.println("Le deuxième convertisseur a converti " + secondconvertisseur.nbConversions + " températures!");
        
        System.out.println("Bonjour, saisissez une valeur : "); // demande à l'utilisateur
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
        String te=""; // variable température d'entrée
        String ts=""; // variable température de sortie
        if (choix==1) {
            résultat = convertisseur.CelciusVersKelvin(température);
            te = "Celcius";
            ts = "Kelvin";
        }
        else if (choix==2) {
            résultat = convertisseur.KelvinVersCelcius(température);
            te = "Kelvin";
            ts = "Celcius";
        }
        else if (choix==3) {
            résultat = convertisseur.FarenheitVersCelcius(température);
            te = "Farenheit";
            ts = "Celcius";
        }
        else if (choix==4) {
            résultat = convertisseur.CelciusVersFarenheit(température);
            te = "Celcius";
            ts = "Farenheit";
        }
        else if (choix==5) {
            résultat = convertisseur.KelvinVersFarenheit(température);
            te = "Kelvin";
            ts = "Farenheit";
        }
        else if (choix==6) {
            résultat = convertisseur.FarenheitVersKelvin(température);
            te = "Farenheit";
            ts = "Kelvin";
        }
        System.out.println(température + " degrés " + te + " est égal à " + résultat + " degrés " + ts);
    }
}
