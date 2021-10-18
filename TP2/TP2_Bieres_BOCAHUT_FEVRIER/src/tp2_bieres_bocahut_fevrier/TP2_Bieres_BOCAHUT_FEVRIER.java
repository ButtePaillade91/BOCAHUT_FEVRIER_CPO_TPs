/*
Noms : Bocahut Manon, Février Titouan
Groupe : TDC
Rôle : Création de classes et objets associés
Date : 18/10/2021
 */
package tp2_bieres_bocahut_fevrier;

/**
 *
 * @author titou
 */
public class TP2_Bieres_BOCAHUT_FEVRIER {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        BouteilleBiere uneBiere = new BouteilleBiere("Cuvée des trolls", 7.0, "Dubuisson"); // création d'une bière
        /*uneBiere.nom = "Cuvée des trolls";
        uneBiere.degreAlcool = 7.0;
        uneBiere.brasserie = "Dubuisson";
        uneBiere.ouverte = false;
        uneBiere.lireEtiquette();*/
        
        BouteilleBiere secondeBiere = new BouteilleBiere("Leffe", 6.6, "Abbaye de Leffe");
        /*secondeBiere.nom = "Leffe";
        secondeBiere.degreAlcool = 6.6;
        secondeBiere.brasserie = "Abbaye de Leffe";
        secondeBiere.lireEtiquette();*/
        
        BouteilleBiere troisièmeBiere = new BouteilleBiere("Pietra", 5.5, "Le Sun, Porticcio");
        BouteilleBiere quatrièmeBiere = new BouteilleBiere("Kiara", 4.5, "L'Amirautée");
        BouteilleBiere cinquièmeBiere = new BouteilleBiere("Skoll", 6.0, "L'affenage, Saint Gély");
        
        System.out.println(troisièmeBiere.Décapsuler()); // affichage du résultat du décapsulage
        
        System.out.println(uneBiere);
        
        BouteilleBiere premièrepinte = new BouteilleBiere("Heineken", 5.2, "Le Petit Nice");
        BouteilleBiere unedeuxième = new BouteilleBiere("Desperados", 5.6, "Café Riche");
        
        premièrepinte.Décapsuler();
        unedeuxième.Décapsuler();
        
        System.out.println(premièrepinte); // affichage de l'état des bières
        System.out.println(unedeuxième);
    }
    
}
