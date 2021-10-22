/*
Noms : Bocahut Manon, Février Titouan
Groupe : TDC
Rôle : Manipuler les références objets
Date : 18/10/2021
 */
package tp2_manip_bocahut_fevrier;

/**
 *
 * @author titou
 */
public class TP2_manip_BOCAHUT_FEVRIER {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Tartiflette assiete1 = new Tartiflette(500);
        Tartiflette assiete2 = new Tartiflette(600);
        Tartiflette assiete3 = assiete2;
        // 2 Tartiflettes ont été réellement crées: celle de l'assiete 1 et 2. De plus, assiete2 et assiete3 font référence à 2 tartiflettes différentes mais ayant la même valeur: 600 Calories!
        
        System.out.println("nb de calories de Assiete 2 : " + assiete2.nbCalories);
        System.out.println("nb de calories de Assiete 3 : " + assiete3.nbCalories);
        assiete2.nbCalories +=1;
        System.out.println("nb de calories de Assiete 2 : " + assiete2.nbCalories);
        System.out.println("nb de calories de Assiete 3 : " + assiete3.nbCalories);
        // Comme on a crée assiete 3 lié avec assiete 2, on constate qu'en changeant les propriétés de l'un, cela change automatiquement celles de l'autre!
        
        Tartiflette assietefictive = new Tartiflette(assiete1.nbCalories);
        assiete1.nbCalories = assiete2.nbCalories;
        assiete2.nbCalories = assietefictive.nbCalories;
        
        // Moussaka assiete666 = assiete1;  faux car assiete1 a été créée comme appartenant à la classe tartiflette et ne peut donc pas être une Moussaka
        // Moussaka assiete667 = new Tartiflette(); de la m^me manière, on ne peut pas dire qu'une assiete de Moussaka est composée de tartiflette
        // D'après les exmples ci-dessus, une référence objet qui annonce référencer un type d'objet ne peut pas référencer un objet qui n'a aucun rapport
        
        int [] RefMoussaka = new int[10];
        for (int i=0; i<RefMoussaka.length; i+=1) {
            Moussaka assiete_i = new Moussaka(100+100*i);
            RefMoussaka[i] = assiete_i.nbCalories;
            System.out.println(RefMoussaka[i]);
        }
        // Surement! Ca serait bien une facon de modéliser la relation!
    }
    
}
