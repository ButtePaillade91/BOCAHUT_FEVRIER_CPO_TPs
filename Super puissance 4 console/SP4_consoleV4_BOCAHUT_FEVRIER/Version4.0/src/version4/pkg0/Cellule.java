/*
Noms : Bocahut Manon, Février Titouan
Groupe : TDC
Rôle : Création des cellules de la grille
Date : 18/11/2021
 */
package version4.pkg0;

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
            jetonCourant=jetondelacellule;
            return(true);
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
    public Jeton recupererJeton() {
        return(jetonCourant);
    }
    public boolean supprimerJeton() {
        if(jetonCourant!=null) {
            jetonCourant=null;
            return(true);
        }
        else {
            return(false);
        }
    }
    public boolean placerDesintegrateur() {
        if(desintegrateur==true) {
            return(false);
        }
        else {
            desintegrateur=true;
            return(true);
        }        
    }
    public boolean presenceDesintegrateur() {
        if (desintegrateur==true) {
            return(true);
        }
        else {
            return(false);
        }
    }
    public boolean récupérerDesintegrateur() {
        if(desintegrateur==true) {
            desintegrateur=false;
            return(true);
        }
        else {
            return(false);
        }
    }
}
