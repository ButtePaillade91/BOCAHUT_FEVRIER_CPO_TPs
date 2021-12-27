/*
Noms : Bocahut Manon, Février Titouan
Groupe : TDC
Rôle : Création classe cellule
Date : 06/12/2021
 */
package bocahut_fevrier_mastermind;

/**
 *
 * @author titou
 */
public class Cellule {
    Pion pionCourant;
    
    
    public Cellule() {
        pionCourant = null;
    }
    
    
    public String lireCouleurDuPion() {
        if (pionCourant == null) {
            return("vide");
        }
        else {
            return(pionCourant.couleur);
    
        }
    }
    
    
        public boolean affecterPion(Pion piondelacellule) {
        if(pionCourant!=null) {
            return(false);
        }
        else {
            pionCourant=piondelacellule;
            return(true);
        }
    }
    
}
