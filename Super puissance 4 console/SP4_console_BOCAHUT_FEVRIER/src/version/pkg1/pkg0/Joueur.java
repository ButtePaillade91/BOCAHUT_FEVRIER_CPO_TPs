/*
Noms : Bocahut Manon, Février Titouan
Groupe : TDC
Rôle : Création classe joueur
Date : 25/10/2021
 */
package version.pkg1.pkg0;

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
            return(true);
        }
    }
}
