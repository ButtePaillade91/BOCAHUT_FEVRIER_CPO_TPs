/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package version4.pkg0;

import java.awt.Graphics;
import javax.swing.ImageIcon;
import javax.swing.JButton;

/**
 *
 * @author titou
 */
public class CelluleGraphique extends JButton {
    Cellule celluleAssociee;
    
    ImageIcon img_vide = new javax.swing.ImageIcon(getClass().getResource("/images/cellule_vide.png"));
    ImageIcon img_desint = new javax.swing.ImageIcon(getClass().getResource("/images/cellule_desint.png"));
    ImageIcon img_trouNoir = new javax.swing.ImageIcon(getClass().getResource("/images/cellule_trounoir.png"));
    
    ImageIcon img_jetonGryffondor = new javax.swing.ImageIcon(getClass().getResource("/images/cellule_gryffondor.png"));
    ImageIcon img_jetonPoufsouffle = new javax.swing.ImageIcon(getClass().getResource("/images/cellule_poufsouffle.png"));
    ImageIcon img_jetonSerdaigle = new javax.swing.ImageIcon(getClass().getResource("/images/cellule_serdaigle.png"));
    ImageIcon img_jetonSerpentard = new javax.swing.ImageIcon(getClass().getResource("/images/cellule_serpentard.png"));

    
    public CelluleGraphique (Cellule uneCellule) {
        celluleAssociee = uneCellule;
    }
    
    @Override
    public void paintComponent (Graphics G) {
        super.paintComponent(G);
        if(celluleAssociee.presenceTrouNoir()==true) {
            setIcon(img_trouNoir);
        }
        else if(celluleAssociee.presenceDesintegrateur()==true) {
            setIcon(img_desint);
        }
        else {
            String couleur_jeton = celluleAssociee.lireCouleurDuJeton();
            if (couleur_jeton=="vide") {
                setIcon(img_vide);
            }
            else if(couleur_jeton=="gryffondor") { 
                setIcon(img_jetonGryffondor);
            }
            else if(couleur_jeton=="poufsouffle") {
                setIcon(img_jetonPoufsouffle);
            }
            else if(couleur_jeton=="serdaigle") {
                setIcon(img_jetonSerdaigle);
            }
            else if(couleur_jeton=="serpentard") {
                setIcon(img_jetonSerpentard);
            }
        }
    }
}
