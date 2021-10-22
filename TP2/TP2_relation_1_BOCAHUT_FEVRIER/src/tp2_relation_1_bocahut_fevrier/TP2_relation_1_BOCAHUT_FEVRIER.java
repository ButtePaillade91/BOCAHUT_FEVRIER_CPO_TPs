/*
Noms : Bocahut Manon, Février Titouan
Groupe : TDC
Rôle : Mise en place d'une relation simple entre deux ou plusieurs objets
Date : 22/10/2021
 */
package tp2_relation_1_bocahut_fevrier;

/**
 *
 * @author titou
 */
public class TP2_relation_1_BOCAHUT_FEVRIER {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Voiture uneClio = new Voiture("Clio", "Renault", 5);
        Voiture uneAutreClio = new Voiture("Clio", "Renault", 5);
        Voiture une2008 = new Voiture("2008", "Peugeot", 6);
        Voiture uneMicra = new Voiture("Micra", "Nissan", 4);
        
        Personne bob = new Personne("Bobby", "Sixkiller");
        Personne reno = new Personne("Reno", "Raines");
        
        // System.out.println("liste des voitures disponibles " + uneClio + "\n" + uneAutreClio + "\n" + une2008 + "\n" + uneMicra);
        
        bob.liste_voitures[0] = uneClio;
        bob.nbVoitures = 1;
        
        uneClio.Proprietaire = bob;
        // System.out.println("la première voiture de Bob est " + bob.liste_voitures[0]);
        
        bob.liste_voitures[1] = uneAutreClio;
        bob.liste_voitures[2] = uneAutreClio;
        bob.nbVoitures = 3;
        
        reno.liste_voitures[0] = une2008;
        reno.liste_voitures[1] = uneMicra;
        reno.nbVoitures = 2;
        System.out.println("la première voiture de Bob est : \n" + bob.liste_voitures[0] + "\net la deuxième de Bob est : \n" + bob.liste_voitures[1]);
        System.out.println("la première voiture de Reno est : \n" + reno.liste_voitures[0] + "\net la deuxième de Reno est : \n" + reno.liste_voitures[1]);
        
        System.out.println(bob.ajouter_voiture(uneMicra));
    }
    
}
