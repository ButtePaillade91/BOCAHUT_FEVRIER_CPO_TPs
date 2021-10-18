/*
Noms : Bocahut Manon, Février Titouan
Groupe : TDC
Rôle : Ajout d'une nouvelle classe (BouteilleBiere)
Date : 18/10/2021
 */
package tp2_bieres_bocahut_fevrier;

/**
 *
 * @author titou
 */
public class BouteilleBiere { // propriétés d'une bière (attributs)
    String nom;
    double degreAlcool;
    String brasserie;
    boolean ouverte;
    public void lireEtiquette() {
        System.out.println("Bouteille de " + nom + " (" + degreAlcool + " degres) \nBrasserie : " + brasserie ); //méthode d'affichage
    }
    public BouteilleBiere(String unNom, double unDegre, String uneBrasserie) {
        nom = unNom;
        degreAlcool = unDegre;
        brasserie = uneBrasserie;
        ouverte = false;
    }
    public boolean Décapsuler() {
        if (ouverte == false) {
            ouverte = true;
            return(true);
        }
        else {
            System.out.println("erreur : biere déjà ouverte");
            return(false);
        }
    }
    @Override
    public String toString() { // méthode d'affichage particulière
        String chaine_a_retourner;
        chaine_a_retourner = nom + " (" + degreAlcool + " degrés) Ouverte ? ";
        if (ouverte == true) chaine_a_retourner += "oui";
        else chaine_a_retourner += "non";
        return chaine_a_retourner;
    }
}

