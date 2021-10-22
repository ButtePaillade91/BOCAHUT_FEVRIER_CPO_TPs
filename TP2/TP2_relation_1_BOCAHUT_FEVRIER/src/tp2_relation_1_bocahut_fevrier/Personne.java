/*
Noms : Bocahut Manon, Février Titouan
Groupe : TDC
Rôle : création d'une nouvelle classe (personne)
Date : 22/10/2021
 */
package tp2_relation_1_bocahut_fevrier;

/**
 *
 * @author titou
 */
public class Personne {
    String nom ;
    String prenom ;
    int nbVoitures;
    Voiture [] liste_voitures;
    public Personne (String Nom, String Prenom) {
        nom = Nom;
        prenom = Prenom;
        liste_voitures= new Voiture[3];
        nbVoitures = 0;
    }
    
    @Override
    public String toString() { // méthode d'affichage particulière
        String attributs_personne;
        attributs_personne = "La personne s'appelle : " + nom + prenom ;
        return attributs_personne;
    }
    
    public boolean ajouter_voiture(Voiture voiture_a_ajouter) {
        if (voiture_a_ajouter.Proprietaire != null) {
            System.out.println("Voiture volée!!!");
            return false;
        }
        else if (nbVoitures==3) {
            System.out.println("Le propriétaire possède trop de voitures");
            return false;
        }
        else {
            voiture_a_ajouter.Proprietaire = this;
            liste_voitures[voiture_a_ajouter.Proprietaire.nbVoitures]=voiture_a_ajouter;
            voiture_a_ajouter.Proprietaire.nbVoitures+=1;
            return true;
        }
    }
}
