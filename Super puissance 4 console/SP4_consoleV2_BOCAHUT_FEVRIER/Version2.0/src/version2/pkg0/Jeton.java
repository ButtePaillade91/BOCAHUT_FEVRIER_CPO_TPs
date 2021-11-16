/*
Noms : Bocahut Manon, Février Titouan
Groupe : TDC
Rôle : Création de la classe jeton
Date : 14/11/2021
 */
package version2.pkg0;

/**
 *
 * @author titou
 */
public class Jeton {
    String couleur;
    
    public Jeton(String couleurjeton) {
        couleur = couleurjeton;
    }
    public String lireCouleur() {
        return(couleur);
    }    
}
