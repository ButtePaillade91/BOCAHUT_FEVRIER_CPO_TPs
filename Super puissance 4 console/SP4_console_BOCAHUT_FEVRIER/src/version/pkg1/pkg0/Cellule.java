/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package version.pkg1.pkg0;

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
}