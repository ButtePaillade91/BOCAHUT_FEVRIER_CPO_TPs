/*
Noms : Bocahut Manon, Février Titouan
Groupe : TDC
Rôle : Création des cellules de la grille
Date : 14/11/2021
 */
package version2.pkg0;

/**
 *
 * @author titou
 */
public class Cellule {
    Jeton jetonCourant;
    boolean trouNoir;
    boolean desintegrateur;
    
    public Cellule() {
        jetonCourant = null;
        trouNoir = false;
        desintegrateur = false;
    }
    public boolean affecterJeton(Jeton jetondelacellule) {
        if(jetonCourant!=null) {
            return(false);
        }
        else if(trouNoir==true) {
            return(false);
        }
        else if(desintegrateur==true) {
            return(false);
        }
        else {
            jetonCourant=jetondelacellule;
            return(true);
        }
    }
    public String lireCouleurDuJeton() {
        if (jetonCourant==null) {
            return("vide");
        }
        else {
            return(jetonCourant.couleur);
    
        }
    }
    public boolean presenceTrouNoir() {
        if (trouNoir==true) {
            return(true);
        }
        else {
            return(false);
        }
    }
    public boolean activerTrouNoir() {
        jetonCourant=null;
        trouNoir=false;
        if (jetonCourant==null) {
            return(true);
        }
        else {
        return(false);
        }
    }
    public boolean placertrouNoir() {
        if(trouNoir==true) {
            return(false);
        }
        else {
            trouNoir=true;
            return(true);
        }
    }
}
