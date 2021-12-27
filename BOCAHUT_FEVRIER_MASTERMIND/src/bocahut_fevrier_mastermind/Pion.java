/*
Noms : Bocahut Manon, Février Titouan
Groupe : TDC
Rôle : Création classe pion
Date : 06/12/2021
 */
package bocahut_fevrier_mastermind;

/**
 *
 * @author titou
 */
public class Pion {
    String couleur;
    
    public Pion(String couleurpion) {
        couleur = couleurpion;
    }
    
    public String lireCouleur() {
        return (couleur);
    }
}
