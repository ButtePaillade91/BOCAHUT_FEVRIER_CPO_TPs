/*
Noms : Bocahut Manon, Février Titouan
Groupe : TDC
Rôle : Création de la classe joueur
Date : 18/11/2021
 */
package version4.pkg0;

/**
 *
 * @author titou
 */
public class Joueur {
    //attributs de la classe joueur
    String nom;
    String couleur;
    Jeton [] ListeJetons = new Jeton[21];
    int nombreJetonsRestants = ListeJetons.length;
    int nombreDesintegrateurs=0;
    
    //méthodes de la classe joueur
    public Joueur(String nomJoueur) {
        nom = nomJoueur;
    }
    public void affecterCouleur(String couleurdujoueur) {
        couleur = couleurdujoueur;
    }
    public boolean ajouterJeton(Jeton jetondujoueur) {
        if (nombreJetonsRestants==21) {
            return(false) ;
        }
        else {
            ListeJetons [nombreJetonsRestants] = jetondujoueur;
            nombreJetonsRestants++;
            return(true);
        }
    }
    public void obtenirDesintegrateur() {
        nombreDesintegrateurs++;
    }
    public boolean utiliserDesintegrateur() {
        if (nombreDesintegrateurs!=0) {
            nombreDesintegrateurs--;
            return(true);
        }
        else {
            return(false);
        }
    }
}
