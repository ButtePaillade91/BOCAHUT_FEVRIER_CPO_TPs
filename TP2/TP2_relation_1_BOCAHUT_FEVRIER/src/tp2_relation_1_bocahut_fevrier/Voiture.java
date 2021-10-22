/*
Noms : Bocahut Manon, Février Titouan
Groupe : TDC
Rôle : crétion d'une nouvelle classe (vroum vroum)
Date : 22/10/2021
 */
package tp2_relation_1_bocahut_fevrier;

/**
 *
 * @author titou
 */
public class Voiture {
    String Modele ; 
    String Marque ;
    int PuissanceCV ;
    Personne Proprietaire;
    public Voiture(String modele, String marque, int puissanceCV) {
        Modele = modele ;
        Marque = marque ;
        PuissanceCV = puissanceCV ;
        Proprietaire = null;
    }
    
    @Override
    public String toString() { // méthode d'affichage particulière
        String caracteristiques_voiture;
        caracteristiques_voiture = "Le modèle est : " + Modele + "\nLa marque est : " + Marque + "\nLa puissance est : " + PuissanceCV;
        return caracteristiques_voiture;
    }
}
