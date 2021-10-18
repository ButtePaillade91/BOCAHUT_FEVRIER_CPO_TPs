/*
Noms : Bocahut Manon, Février Titouan
Groupe : TDC
Rôle : ajout d'une nouvelle classe (Convertisseur)
Date : 18/10/2021
 */
package tp2_convertisseurobjet_bocahut_fevrier;

/**
 *
 * @author titou
 */
public class Convertisseur {
   int nbConversions = 0;

   public void Convertisseur() {
       
   }
   public double CelciusVersKelvin(double tCelcius) {
       double tKelvin  = 273.15+tCelcius; // conversion selon le système internationnal
       nbConversions+=1;
       return(tKelvin);
   }
   public double KelvinVersCelcius(double tKelvin) {
       double tCelcius  = tKelvin-273.15;
       nbConversions+=1;
       return(tCelcius);
   }
   public double FarenheitVersCelcius(double tFarenheit) {
       double tCelcius  = (tFarenheit-32)/1.8;
       nbConversions+=1;
       return(tCelcius);
   }
   public double CelciusVersFarenheit(double tCelcius) {
       double tFarenheit  = 1.8*tCelcius+32;
       nbConversions+=1;
       return(tFarenheit);
   }
   public double FarenheitVersKelvin(double tFarenheit) {
       double tKelvin = ((tFarenheit-32)/1.8)+273.15;
       nbConversions+=1;
       return(tKelvin);
   }
   public double KelvinVersFarenheit(double tKelvin) {
       double tFarenheit = ((tKelvin-273.15)*1.8)+32;
       nbConversions+=1;
       return(tFarenheit);
   }
   @Override
    public String toString() { // méthode d'affichage particulière
        return "nb e conversions" + nbConversions;
    }
}
