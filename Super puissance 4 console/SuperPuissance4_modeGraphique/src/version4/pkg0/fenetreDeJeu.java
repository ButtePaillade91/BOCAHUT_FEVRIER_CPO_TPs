/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package version4.pkg0;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Random;

/**
 *
 * @author titou
 */
public class fenetreDeJeu extends javax.swing.JFrame {

    /**
     * Creates new form fenetreDeJeu
     */    
    Joueur[] ListeJoueurs = new Joueur[2];
    Joueur joueurCourant;
    Grille grillejeu = new Grille();
    int gryffondor=0;
    int poufsouffle=0;
    int serdaigle=0;
    int serpentard=0;
    int compteurmaisons=0;
    public fenetreDeJeu() {
        initComponents();
        btn_start.setEnabled(false);
        btn_col_0.setEnabled(false);
        btn_col_1.setEnabled(false);
        btn_col_2.setEnabled(false);
        btn_col_3.setEnabled(false);
        btn_col_4.setEnabled(false);
        btn_col_5.setEnabled(false);
        btn_col_6.setEnabled(false);
        hedwige.setVisible(false);
        les_3_freres.setVisible(false);
        panneau_info_joueurs.setVisible(false);
        panneau_info_partie.setVisible(false);
        texte_fin.setVisible(false);
        theEnd.setVisible(false);
        for (int i = 5; i >= 0; i--) {
            for (int j = 0; j < 7; j++) {
                CelluleGraphique cellGraph = new CelluleGraphique(grillejeu.CellulesJeu[i][j]);
                
                cellGraph.addActionListener(new java.awt.event.ActionListener() {
                    public void actionPerformed(java.awt.event.ActionEvent evt) {
                        Cellule c = cellGraph.celluleAssociee;
                        
                        if (c.jetonCourant == null) {
                            return;
                        }
                        if (c.jetonCourant.couleur == joueurCourant.couleur) {
                            textemessage.setText("Le joueur " + joueurCourant.nom + " récupère un de ses jetons");
                            Jeton jrecup = c.recupererJeton();
                            c.supprimerJeton();
                            joueurCourant.ajouterJeton(jrecup);
                            grillejeu.tasserGrille();
                            verifgagnant();
                            joueurSuivant();
                        }
                        else {
                            if (joueurCourant.nombreDesintegrateurs > 0) {
                                textemessage.setText("Le joueur " + joueurCourant.nom + "  désintègre un jeton");
                                c.supprimerJeton();
                                joueurCourant.utiliserDesintegrateur();
                                grillejeu.tasserGrille();
                                verifgagnant();
                                joueurSuivant();
                            }
                            else {
                                return;
                            }
                        }
                    
                        
                        
                        if(grillejeu.CellulesJeu[5][0].jetonCourant==null) {
                            btn_col_0.setEnabled(true);
                        }
                        if(grillejeu.CellulesJeu[5][1].jetonCourant==null) {
                            btn_col_1.setEnabled(true);
                        }
                        if(grillejeu.CellulesJeu[5][2].jetonCourant==null) {
                            btn_col_2.setEnabled(true);
                        }
                        if(grillejeu.CellulesJeu[5][3].jetonCourant==null) {
                            btn_col_3.setEnabled(true);
                        }
                        if(grillejeu.CellulesJeu[5][4].jetonCourant==null) {
                            btn_col_4.setEnabled(true);
                        }
                        if(grillejeu.CellulesJeu[5][5].jetonCourant==null) {
                            btn_col_5.setEnabled(true);
                        }
                        if(grillejeu.CellulesJeu[5][6].jetonCourant==null) {
                            btn_col_6.setEnabled(true);
                        }
                        panneau_grille.repaint();
                        lbl_j1_desint.setText(ListeJoueurs[0].nombreDesintegrateurs + "");
                        lbl_j2_desint.setText(ListeJoueurs[1].nombreDesintegrateurs + "");
                    }
                });

                panneau_grille.add(cellGraph);

                
                cellGraph.addMouseListener(new MouseListener() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                    }

                    @Override
                    public void mousePressed(MouseEvent e) {
                     //   throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                    }

                    @Override
                    public void mouseReleased(MouseEvent e) {
                      //  throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                    }

                   @Override
                    public void mouseEntered(MouseEvent e) {
                    cellGraph.setSize(105,105);
                    
                    }

                    @Override
                    public void mouseExited(MouseEvent e) {
                        cellGraph.setSize(96,96);
                       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                    }
                });
            }
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        texte_fin = new javax.swing.JTextField();
        theEnd = new javax.swing.JButton();
        hedwige = new javax.swing.JButton();
        les_3_freres = new javax.swing.JButton();
        Always = new javax.swing.JButton();
        panneau_info_partie = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        lbl_jcourant = new javax.swing.JLabel();
        message = new javax.swing.JScrollPane();
        textemessage = new javax.swing.JTextArea();
        panneau_numero_colonnes = new javax.swing.JPanel();
        btn_col_1 = new javax.swing.JButton();
        btn_col_0 = new javax.swing.JButton();
        btn_col_2 = new javax.swing.JButton();
        btn_col_3 = new javax.swing.JButton();
        btn_col_4 = new javax.swing.JButton();
        btn_col_5 = new javax.swing.JButton();
        btn_col_6 = new javax.swing.JButton();
        panneau_creation_partie = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        nom_joueur2 = new javax.swing.JTextField();
        nom_joueur1 = new javax.swing.JTextField();
        btn_start = new javax.swing.JButton();
        btn_gryffondor = new javax.swing.JButton();
        btn_serdaigle = new javax.swing.JButton();
        btn_poufsouffle = new javax.swing.JButton();
        btn_serpentard = new javax.swing.JButton();
        panneau_grille = new javax.swing.JPanel();
        panneau_fond = new javax.swing.JPanel();
        panneau_info_joueurs = new javax.swing.JPanel();
        lbl_j1_nom = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        lbl_j1_desint = new javax.swing.JLabel();
        lbl_j1_couleur = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        lbl_j2_desint = new javax.swing.JLabel();
        lbl_j2_couleur = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        lbl_j2_nom = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(0, 0, 0));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        texte_fin.setBackground(new java.awt.Color(0, 0, 0));
        texte_fin.setFont(new java.awt.Font("Harry P", 1, 48)); // NOI18N
        texte_fin.setForeground(new java.awt.Color(255, 255, 255));
        texte_fin.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        texte_fin.setText("joueurCourant.nom gagne!");
        texte_fin.setBorder(null);
        texte_fin.setPreferredSize(new java.awt.Dimension(1920, 1080));
        texte_fin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                texte_finActionPerformed(evt);
            }
        });
        getContentPane().add(texte_fin, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 90, 659, 127));

        theEnd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/theEnd.JPEG"))); // NOI18N
        getContentPane().add(theEnd, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 90, 570, 730));

        hedwige.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/hedwige.png"))); // NOI18N
        getContentPane().add(hedwige, new org.netbeans.lib.awtextra.AbsoluteConstraints(1220, 20, 280, 390));

        les_3_freres.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/les_3_frères.png"))); // NOI18N
        les_3_freres.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                les_3_freresActionPerformed(evt);
            }
        });
        getContentPane().add(les_3_freres, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 540, 290, 210));

        Always.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/image.png"))); // NOI18N
        Always.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AlwaysActionPerformed(evt);
            }
        });
        getContentPane().add(Always, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 680, 350, 100));

        panneau_info_partie.setBackground(new java.awt.Color(0, 0, 0));
        panneau_info_partie.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        panneau_info_partie.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setFont(new java.awt.Font("Harry P", 1, 36)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Infos jeu");
        panneau_info_partie.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 20, -1, -1));

        jLabel7.setFont(new java.awt.Font("Harry P", 0, 24)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("joueur actif :");
        panneau_info_partie.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 100, 140, 30));

        lbl_jcourant.setFont(new java.awt.Font("Harry P", 0, 24)); // NOI18N
        lbl_jcourant.setForeground(new java.awt.Color(255, 255, 255));
        lbl_jcourant.setText("nomjoueur");
        panneau_info_partie.add(lbl_jcourant, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 100, 120, 30));

        textemessage.setColumns(20);
        textemessage.setFont(new java.awt.Font("Arial Black", 0, 14)); // NOI18N
        textemessage.setRows(5);
        message.setViewportView(textemessage);

        panneau_info_partie.add(message, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 160, 300, 150));

        getContentPane().add(panneau_info_partie, new org.netbeans.lib.awtextra.AbsoluteConstraints(1100, 410, 410, 340));

        panneau_numero_colonnes.setBackground(new java.awt.Color(0, 0, 0));

        btn_col_1.setBackground(new java.awt.Color(0, 0, 0));
        btn_col_1.setFont(new java.awt.Font("Harry P", 0, 24)); // NOI18N
        btn_col_1.setForeground(new java.awt.Color(255, 255, 255));
        btn_col_1.setText("2");
        btn_col_1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn_col_1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn_col_1MouseExited(evt);
            }
        });
        btn_col_1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_col_1ActionPerformed(evt);
            }
        });

        btn_col_0.setBackground(new java.awt.Color(0, 0, 0));
        btn_col_0.setFont(new java.awt.Font("Harry P", 0, 24)); // NOI18N
        btn_col_0.setForeground(new java.awt.Color(255, 255, 255));
        btn_col_0.setText("1");
        btn_col_0.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_col_0ActionPerformed(evt);
            }
        });

        btn_col_2.setBackground(new java.awt.Color(0, 0, 0));
        btn_col_2.setFont(new java.awt.Font("Harry P", 0, 24)); // NOI18N
        btn_col_2.setForeground(new java.awt.Color(255, 255, 255));
        btn_col_2.setText("3");
        btn_col_2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_col_2ActionPerformed(evt);
            }
        });

        btn_col_3.setBackground(new java.awt.Color(0, 0, 0));
        btn_col_3.setFont(new java.awt.Font("Harry P", 0, 24)); // NOI18N
        btn_col_3.setForeground(new java.awt.Color(255, 255, 255));
        btn_col_3.setText("4");
        btn_col_3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_col_3ActionPerformed(evt);
            }
        });

        btn_col_4.setBackground(new java.awt.Color(0, 0, 0));
        btn_col_4.setFont(new java.awt.Font("Harry P", 0, 24)); // NOI18N
        btn_col_4.setForeground(new java.awt.Color(255, 255, 255));
        btn_col_4.setText("5");
        btn_col_4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_col_4ActionPerformed(evt);
            }
        });

        btn_col_5.setBackground(new java.awt.Color(0, 0, 0));
        btn_col_5.setFont(new java.awt.Font("Harry P", 0, 24)); // NOI18N
        btn_col_5.setForeground(new java.awt.Color(255, 255, 255));
        btn_col_5.setText("6");
        btn_col_5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_col_5ActionPerformed(evt);
            }
        });

        btn_col_6.setBackground(new java.awt.Color(0, 0, 0));
        btn_col_6.setFont(new java.awt.Font("Harry P", 0, 24)); // NOI18N
        btn_col_6.setForeground(new java.awt.Color(255, 255, 255));
        btn_col_6.setText("7");
        btn_col_6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_col_6ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panneau_numero_colonnesLayout = new javax.swing.GroupLayout(panneau_numero_colonnes);
        panneau_numero_colonnes.setLayout(panneau_numero_colonnesLayout);
        panneau_numero_colonnesLayout.setHorizontalGroup(
            panneau_numero_colonnesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panneau_numero_colonnesLayout.createSequentialGroup()
                .addComponent(btn_col_0, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_col_1, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_col_2, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_col_3, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_col_4, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_col_5, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_col_6, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panneau_numero_colonnesLayout.setVerticalGroup(
            panneau_numero_colonnesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panneau_numero_colonnesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(btn_col_0, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(btn_col_1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(btn_col_2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(btn_col_3, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(btn_col_4, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(btn_col_5, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(btn_col_6, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        getContentPane().add(panneau_numero_colonnes, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 30, 672, -1));

        panneau_creation_partie.setBackground(new java.awt.Color(0, 0, 0));
        panneau_creation_partie.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        panneau_creation_partie.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Harry P", 0, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Nom joueur 2 :");
        panneau_creation_partie.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 90, -1, -1));

        jLabel2.setFont(new java.awt.Font("Harry P", 0, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Nom joueur 1 :");
        panneau_creation_partie.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 30, -1, -1));

        nom_joueur2.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        nom_joueur2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nom_joueur2ActionPerformed(evt);
            }
        });
        panneau_creation_partie.add(nom_joueur2, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 80, 110, 40));

        nom_joueur1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        nom_joueur1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nom_joueur1ActionPerformed(evt);
            }
        });
        panneau_creation_partie.add(nom_joueur1, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 20, 110, 40));

        btn_start.setBackground(new java.awt.Color(0, 0, 0));
        btn_start.setFont(new java.awt.Font("Harry P", 0, 48)); // NOI18N
        btn_start.setForeground(new java.awt.Color(255, 255, 255));
        btn_start.setText("Demarrer Partie");
        btn_start.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_startActionPerformed(evt);
            }
        });
        panneau_creation_partie.add(btn_start, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 380, 330, 100));

        btn_gryffondor.setBackground(new java.awt.Color(0, 0, 0));
        btn_gryffondor.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/cellule_gryffondor.png"))); // NOI18N
        btn_gryffondor.setMaximumSize(new java.awt.Dimension(130, 110));
        btn_gryffondor.setMinimumSize(new java.awt.Dimension(130, 110));
        btn_gryffondor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_gryffondorActionPerformed(evt);
            }
        });
        panneau_creation_partie.add(btn_gryffondor, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 150, 130, 200));

        btn_serdaigle.setBackground(new java.awt.Color(0, 0, 0));
        btn_serdaigle.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/cellule_serdaigle.png"))); // NOI18N
        btn_serdaigle.setMaximumSize(new java.awt.Dimension(130, 110));
        btn_serdaigle.setMinimumSize(new java.awt.Dimension(130, 110));
        btn_serdaigle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_serdaigleActionPerformed(evt);
            }
        });
        panneau_creation_partie.add(btn_serdaigle, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 150, 130, 200));

        btn_poufsouffle.setBackground(new java.awt.Color(0, 0, 0));
        btn_poufsouffle.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/cellule_poufsouffle.png"))); // NOI18N
        btn_poufsouffle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_poufsouffleActionPerformed(evt);
            }
        });
        panneau_creation_partie.add(btn_poufsouffle, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 150, 130, 200));

        btn_serpentard.setBackground(new java.awt.Color(0, 0, 0));
        btn_serpentard.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/cellule_serpentard.png"))); // NOI18N
        btn_serpentard.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_serpentardActionPerformed(evt);
            }
        });
        panneau_creation_partie.add(btn_serpentard, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 150, 130, 200));

        getContentPane().add(panneau_creation_partie, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 130, 680, 500));

        panneau_grille.setBackground(new java.awt.Color(0, 0, 0));
        panneau_grille.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        panneau_grille.setLayout(new java.awt.GridLayout(6, 7));
        getContentPane().add(panneau_grille, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 90, 672, 576));

        panneau_fond.setBackground(new java.awt.Color(0, 0, 0));

        panneau_info_joueurs.setBackground(new java.awt.Color(0, 0, 0));
        panneau_info_joueurs.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        panneau_info_joueurs.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lbl_j1_nom.setFont(new java.awt.Font("Harry P", 0, 24)); // NOI18N
        lbl_j1_nom.setForeground(new java.awt.Color(255, 255, 255));
        lbl_j1_nom.setText("nomjoueur1");
        panneau_info_joueurs.add(lbl_j1_nom, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 120, -1, -1));

        jLabel5.setFont(new java.awt.Font("Harry P", 0, 24)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("joueur 1 :");
        panneau_info_joueurs.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 120, -1, -1));

        lbl_j1_desint.setFont(new java.awt.Font("Harry P", 0, 24)); // NOI18N
        lbl_j1_desint.setForeground(new java.awt.Color(255, 255, 255));
        lbl_j1_desint.setText("nbdesintjoueur1");
        panneau_info_joueurs.add(lbl_j1_desint, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 210, -1, -1));

        lbl_j1_couleur.setFont(new java.awt.Font("Harry P", 0, 24)); // NOI18N
        lbl_j1_couleur.setForeground(new java.awt.Color(255, 255, 255));
        lbl_j1_couleur.setText("couleur joueur1");
        panneau_info_joueurs.add(lbl_j1_couleur, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 170, -1, -1));

        jLabel9.setFont(new java.awt.Font("Harry P", 0, 24)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("maison :");
        panneau_info_joueurs.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 170, -1, -1));

        jLabel10.setFont(new java.awt.Font("Harry P", 0, 24)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("desintegrateurs :");
        panneau_info_joueurs.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 210, -1, -1));

        jSeparator1.setForeground(new java.awt.Color(255, 255, 255));
        panneau_info_joueurs.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 290, 360, 10));

        lbl_j2_desint.setFont(new java.awt.Font("Harry P", 0, 24)); // NOI18N
        lbl_j2_desint.setForeground(new java.awt.Color(255, 255, 255));
        lbl_j2_desint.setText("nbdesintjoueur2");
        panneau_info_joueurs.add(lbl_j2_desint, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 430, -1, -1));

        lbl_j2_couleur.setFont(new java.awt.Font("Harry P", 0, 24)); // NOI18N
        lbl_j2_couleur.setForeground(new java.awt.Color(255, 255, 255));
        lbl_j2_couleur.setText("couleur joueur2");
        panneau_info_joueurs.add(lbl_j2_couleur, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 390, -1, -1));

        jLabel11.setFont(new java.awt.Font("Harry P", 0, 24)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("maison :");
        panneau_info_joueurs.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 390, -1, -1));

        jLabel12.setFont(new java.awt.Font("Harry P", 0, 24)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("desintegrateurs :");
        panneau_info_joueurs.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 430, -1, -1));

        jLabel4.setFont(new java.awt.Font("Harry P", 1, 36)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Infos joueurs");
        panneau_info_joueurs.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 40, -1, -1));

        jLabel8.setFont(new java.awt.Font("Harry P", 0, 24)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("joueur 2 :");
        panneau_info_joueurs.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 350, -1, -1));

        lbl_j2_nom.setFont(new java.awt.Font("Harry P", 0, 24)); // NOI18N
        lbl_j2_nom.setForeground(new java.awt.Color(255, 255, 255));
        lbl_j2_nom.setText("nomjoueur2");
        panneau_info_joueurs.add(lbl_j2_nom, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 350, -1, -1));

        javax.swing.GroupLayout panneau_fondLayout = new javax.swing.GroupLayout(panneau_fond);
        panneau_fond.setLayout(panneau_fondLayout);
        panneau_fondLayout.setHorizontalGroup(
            panneau_fondLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panneau_fondLayout.createSequentialGroup()
                .addContainerGap(766, Short.MAX_VALUE)
                .addComponent(panneau_info_joueurs, javax.swing.GroupLayout.PREFERRED_SIZE, 410, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(744, 744, 744))
        );
        panneau_fondLayout.setVerticalGroup(
            panneau_fondLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panneau_fondLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(panneau_info_joueurs, javax.swing.GroupLayout.PREFERRED_SIZE, 500, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(560, Short.MAX_VALUE))
        );

        getContentPane().add(panneau_fond, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1920, 1080));

        setBounds(0, 0, 1934, 1117);
    }// </editor-fold>//GEN-END:initComponents

    private void btn_serpentardActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_serpentardActionPerformed
        // TODO add your handling code here:
        btn_serpentard.setEnabled(false);
        if(compteurmaisons==0) {
            serpentard=1;
        }
        else if(compteurmaisons==1) {
            serpentard=2;
        }
        compteurmaisons++;
        if(compteurmaisons==2) {
            btn_gryffondor.setEnabled(false);
            btn_poufsouffle.setEnabled(false);
            btn_serdaigle.setEnabled(false);
            btn_start.setEnabled(true);
        }
    }//GEN-LAST:event_btn_serpentardActionPerformed

    private void btn_serdaigleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_serdaigleActionPerformed
        // TODO add your handling code here:
        btn_serdaigle.setEnabled(false);
        if(compteurmaisons==0) {
            serdaigle=1;
        }
        else if(compteurmaisons==1) {
            serdaigle=2;
        }
        compteurmaisons++;
        if(compteurmaisons==2) {
            btn_gryffondor.setEnabled(false);
            btn_poufsouffle.setEnabled(false);
            btn_serpentard.setEnabled(false);
            btn_start.setEnabled(true);
        }
    }//GEN-LAST:event_btn_serdaigleActionPerformed

    private void btn_poufsouffleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_poufsouffleActionPerformed
        // TODO add your handling code here:
        btn_poufsouffle.setEnabled(false);
        if(compteurmaisons==0) {
            poufsouffle=1;
        }
        else if(compteurmaisons==1) {
            poufsouffle=2;
        }
        compteurmaisons++;
        if(compteurmaisons==2) {
            btn_gryffondor.setEnabled(false);
            btn_serdaigle.setEnabled(false);
            btn_serpentard.setEnabled(false);
            btn_start.setEnabled(true);
        }
    }//GEN-LAST:event_btn_poufsouffleActionPerformed

    private void btn_gryffondorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_gryffondorActionPerformed
        // TODO add your handling code here:
        btn_gryffondor.setEnabled(false);
        if(compteurmaisons==0) {
            gryffondor=1;

        }
        else if(compteurmaisons==1) {
            gryffondor=2;
        }
        compteurmaisons++;
        if(compteurmaisons==2) {
            btn_poufsouffle.setEnabled(false);
            btn_serdaigle.setEnabled(false);
            btn_serpentard.setEnabled(false);
            btn_start.setEnabled(true);
        }
    }//GEN-LAST:event_btn_gryffondorActionPerformed

    private void btn_startActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_startActionPerformed
        // TODO add your handling code here:
        panneau_creation_partie.setVisible(false);
        panneau_info_joueurs.setVisible(true);
        panneau_info_partie.setVisible(true);
        hedwige.setVisible(true);
        les_3_freres.setVisible(true);
        initialiserPartie();
        panneau_grille.repaint();
        btn_col_0.setEnabled(true);
        btn_col_1.setEnabled(true);
        btn_col_2.setEnabled(true);
        btn_col_3.setEnabled(true);
        btn_col_4.setEnabled(true);
        btn_col_5.setEnabled(true);
        btn_col_6.setEnabled(true);
        //btn_start.setEnabled(false);
        //btn_gryffondor.setVisible(false);
        //btn_poufsouffle.setVisible(false);
        //btn_serdaigle.setVisible(false);
        //btn_serpentard.setVisible(false);
    }//GEN-LAST:event_btn_startActionPerformed

    private void nom_joueur1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nom_joueur1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nom_joueur1ActionPerformed

    private void nom_joueur2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nom_joueur2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nom_joueur2ActionPerformed

    private void texte_finActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_texte_finActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_texte_finActionPerformed

    private void btn_col_6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_col_6ActionPerformed
        jouerDansColonne(6);
        if(grillejeu.CellulesJeu[5][6].jetonCourant != null){
            btn_col_6.setEnabled(false);
        }
        joueurSuivant();
    }//GEN-LAST:event_btn_col_6ActionPerformed

    private void btn_col_5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_col_5ActionPerformed
        jouerDansColonne(5);
        if (grillejeu.CellulesJeu[5][5].jetonCourant != null) {
            btn_col_5.setEnabled(false);
        }
        joueurSuivant();
    }//GEN-LAST:event_btn_col_5ActionPerformed

    private void btn_col_4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_col_4ActionPerformed
        jouerDansColonne(4);
        if (grillejeu.CellulesJeu[5][4].jetonCourant != null) {
            btn_col_4.setEnabled(false);
        }
        joueurSuivant();
    }//GEN-LAST:event_btn_col_4ActionPerformed

    private void btn_col_3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_col_3ActionPerformed
        jouerDansColonne(3);
        if (grillejeu.CellulesJeu[5][3].jetonCourant != null) {
            btn_col_3.setEnabled(false);
        }
        joueurSuivant();
    }//GEN-LAST:event_btn_col_3ActionPerformed

    private void btn_col_2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_col_2ActionPerformed
        jouerDansColonne(2);
        if (grillejeu.CellulesJeu[5][2].jetonCourant != null) {
            btn_col_2.setEnabled(false);
        }
        joueurSuivant();
    }//GEN-LAST:event_btn_col_2ActionPerformed

    private void btn_col_0ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_col_0ActionPerformed
        jouerDansColonne(0);
        if (grillejeu.CellulesJeu[5][0].jetonCourant != null) {
            btn_col_0.setEnabled(false);
        }
        joueurSuivant();
    }//GEN-LAST:event_btn_col_0ActionPerformed

    private void btn_col_1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_col_1ActionPerformed
        jouerDansColonne(1);
        if (grillejeu.CellulesJeu[5][1].jetonCourant != null) {
            btn_col_1.setEnabled(false);
        }
        joueurSuivant();
    }//GEN-LAST:event_btn_col_1ActionPerformed

    private void btn_col_1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_col_1MouseExited
        //btn_col_1.setOpaque(false);        // TODO add your handling code here:
    }//GEN-LAST:event_btn_col_1MouseExited

    private void btn_col_1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_col_1MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_col_1MouseEntered

    private void les_3_freresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_les_3_freresActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_les_3_freresActionPerformed

    private void AlwaysActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AlwaysActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_AlwaysActionPerformed

    public boolean jouerDansColonne(int indice_colonne) {
        int i = 0;
        while (i <= 5 && grillejeu.CellulesJeu[i][indice_colonne].jetonCourant != null) {
            i++;
        }
        boolean resultatAction;
        resultatAction = grillejeu.ajouterJetonDansColonne(joueurCourant.ListeJetons[joueurCourant.nombreJetonsRestants - 1], indice_colonne);
        joueurCourant.ListeJetons[joueurCourant.nombreJetonsRestants - 1] = null;
        joueurCourant.nombreJetonsRestants--;

        if (grillejeu.CellulesJeu[i][indice_colonne].presenceTrouNoir() == true) {
            grillejeu.CellulesJeu[i][indice_colonne].activerTrouNoir();
            System.out.println("Vous tombez dans un trou noir!");
            if (grillejeu.CellulesJeu[i][indice_colonne].presenceDesintegrateur() == true) {
                joueurCourant.obtenirDesintegrateur();
                grillejeu.CellulesJeu[i][indice_colonne].récupérerDesintegrateur();
                System.out.println("Génial! Vous avez obtenu un désintégrateur!💣");
            }
        } else if (grillejeu.CellulesJeu[i][indice_colonne].presenceDesintegrateur() == true) {
            joueurCourant.obtenirDesintegrateur();
            grillejeu.CellulesJeu[i][indice_colonne].récupérerDesintegrateur();
            System.out.println("Génial! Vous avez obtenu un désintégrateur!💣");
        }
        
        panneau_grille.repaint();

        lbl_j1_desint.setText(ListeJoueurs[0].nombreDesintegrateurs + "");
        lbl_j2_desint.setText(ListeJoueurs[1].nombreDesintegrateurs + "");
        
        verifgagnant();

        if (resultatAction == true) {
            return true;
        } else {
            return false;
        }
    }

    public void joueurSuivant() {
        if (joueurCourant == ListeJoueurs[0]) {
            joueurCourant = ListeJoueurs[1];
        } else {
            joueurCourant = ListeJoueurs[0];
        }
        lbl_jcourant.setText(joueurCourant.nom);
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(fenetreDeJeu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(fenetreDeJeu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(fenetreDeJeu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(fenetreDeJeu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new fenetreDeJeu().setVisible(true);
            }
        });
    }

    public void initialiserPartie() {
        grillejeu.viderGrille();

        String nomjoueur1 = nom_joueur1.getText();
        Joueur J1 = new Joueur(nomjoueur1);
        String nomjoueur2 = nom_joueur2.getText();
        Joueur J2 = new Joueur(nomjoueur2);

        ListeJoueurs[0] = J1;
        ListeJoueurs[1] = J2;

        attribuerCouleursAuxJoueurs();

        lbl_j1_nom.setText(nomjoueur1);
        lbl_j2_nom.setText(nomjoueur2);

        lbl_j1_couleur.setText(J1.couleur);
        lbl_j2_couleur.setText(J2.couleur);

        lbl_j1_desint.setText(J1.nombreDesintegrateurs + "");
        lbl_j2_desint.setText(J2.nombreDesintegrateurs + "");

        Random generateurAleat = new Random();
        int firstplayer = generateurAleat.nextInt(2);
        Joueur joueurPrécédent;
        
        if (firstplayer == 0) {
            joueurCourant = ListeJoueurs[0];
            joueurPrécédent = ListeJoueurs[1];
        }
        else {
            joueurCourant = ListeJoueurs[1];
            joueurPrécédent = ListeJoueurs[0];
        }

        lbl_jcourant.setText(joueurCourant.nom);

        for (int i = 0; i < 21; i++) {
            Jeton jetonjoueur1 = new Jeton(ListeJoueurs[0].couleur);
            ListeJoueurs[0].ajouterJeton(jetonjoueur1);
            Jeton jetonjoueur2 = new Jeton(ListeJoueurs[1].couleur);
            ListeJoueurs[1].ajouterJeton(jetonjoueur2);
        }

        Random generateurAleatdesintrounoir = new Random();
        int desintrounoir1 = generateurAleatdesintrounoir.nextInt(4);
        int desintrounoir2 = generateurAleatdesintrounoir.nextInt(4);
        while (desintrounoir2 == desintrounoir1) {
            desintrounoir2 = generateurAleatdesintrounoir.nextInt(4);
        }

        for (int i = 0; i < 5; i++) {
            generateurAleat = new Random();
            int lignetrounoir = generateurAleat.nextInt(6);
            int colonnetrounoir = generateurAleat.nextInt(7);
            if (grillejeu.placerTrouNoir(lignetrounoir, colonnetrounoir) == false) {
                i--;
            }
            if (i == desintrounoir1 || i == desintrounoir2) {
                grillejeu.placerDesintegrateur(lignetrounoir, colonnetrounoir);
            }

        }

        for (int i = 0; i < 3; i++) {
            generateurAleat = new Random();
            int lignedesintegrateur = generateurAleat.nextInt(6);
            int colonnedesintegrateur = generateurAleat.nextInt(7);
            if (grillejeu.placerDesintegrateur(lignedesintegrateur, colonnedesintegrateur) == false) {
                i--;
            } else if (grillejeu.CellulesJeu[lignedesintegrateur][colonnedesintegrateur].trouNoir == true) {
                i--;
            }
        }
    }

    public void attribuerCouleursAuxJoueurs() {
        if (gryffondor == 1) {
            ListeJoueurs[0].affecterCouleur("gryffondor");
            System.out.println(ListeJoueurs[0].nom + " vous représentez la maison Gryffondor");
        }
        else if (gryffondor == 2) {
            ListeJoueurs[1].affecterCouleur("gryffondor");
            System.out.println(ListeJoueurs[1].nom + " vous représentez la maison Gryffondor");
        }
        
        if (poufsouffle == 1) {
            ListeJoueurs[0].affecterCouleur("poufsouffle");
            System.out.println(ListeJoueurs[0].nom + " vous représentez la maison Poufsouffle");
        }
        else if (poufsouffle == 2) {
            ListeJoueurs[1].affecterCouleur("poufsouffle");
            System.out.println(ListeJoueurs[1].nom + " vous représentez la maison Poufsouffle");
        }
        
        if (serdaigle == 1) {
            ListeJoueurs[0].affecterCouleur("serdaigle");
            System.out.println(ListeJoueurs[0].nom + " vous représentez la maison Serdaigle");
        }
        else if (serdaigle == 2) {
            ListeJoueurs[1].affecterCouleur("serdaigle");
            System.out.println(ListeJoueurs[1].nom + " vous représentez la maison Serdaigle");
        }
        
        if (serpentard == 1) {
            ListeJoueurs[0].affecterCouleur("serpentard");
            System.out.println(ListeJoueurs[0].nom + " vous représentez la maison Serpentard");
        }
        else if (serpentard == 2) {
            ListeJoueurs[1].affecterCouleur("serpentard");
            System.out.println(ListeJoueurs[1].nom + " vous représentez la maison Serpentard");
        }
    }
    
    public void verifgagnant() {
        boolean vict_j1 = grillejeu.etreGagnantePourJoueur(ListeJoueurs[0]);
        boolean vict_j2 = grillejeu.etreGagnantePourJoueur(ListeJoueurs[1]);

        if (vict_j1 && !vict_j2) {
            textemessage.setText("Victoire de " + ListeJoueurs[0].nom);
            panneau_grille.setVisible(false);
            panneau_numero_colonnes.setVisible(false);
            panneau_creation_partie.setVisible(false);
            panneau_info_partie.setVisible(false);
            panneau_info_joueurs.setVisible(false);
            hedwige.setVisible(false);
            les_3_freres.setVisible(false);
            Always.setVisible(false);
            
            if (joueurCourant==ListeJoueurs[0]) {
                texte_fin.setText(joueurCourant.nom + " gagne la partie !");
            }
            else if(joueurCourant==ListeJoueurs[1]) {
                joueurSuivant();
                texte_fin.setText(joueurCourant.nom + " gagne la partie !");
            }
            texte_fin.setVisible(true);
            theEnd.setVisible(true);
        } else if (vict_j2 && !vict_j1) {
            textemessage.setText("Victoire de " + ListeJoueurs[1].nom);
            panneau_grille.setVisible(false);
            panneau_numero_colonnes.setVisible(false);
            panneau_creation_partie.setVisible(false);
            panneau_info_partie.setVisible(false);
            panneau_info_joueurs.setVisible(false);
            hedwige.setVisible(false);
            les_3_freres.setVisible(false);
            Always.setVisible(false);
            
            if (joueurCourant==ListeJoueurs[1]) {
                texte_fin.setText(joueurCourant.nom + " gagne la partie !");
            }
            else if(joueurCourant==ListeJoueurs[0]) {
                joueurSuivant();
                texte_fin.setText(joueurCourant.nom + " gagne la partie !");
            }
            texte_fin.setVisible(true);
            theEnd.setVisible(true);
        }
        else if (vict_j1 && vict_j2) {
            if (joueurCourant == ListeJoueurs[0]) {
                textemessage.setText("Victoire de " + ListeJoueurs[1].nom + " par faute de jeu de " + ListeJoueurs[0].nom);
                panneau_grille.setVisible(false);
                panneau_numero_colonnes.setVisible(false);
                panneau_creation_partie.setVisible(false);
                panneau_info_partie.setVisible(false);
                panneau_info_joueurs.setVisible(false);
                hedwige.setVisible(false);
                les_3_freres.setVisible(false);
                Always.setVisible(false);
                
                texte_fin.setText("Victoire de " + ListeJoueurs[1].nom + " par faute de jeu de " + ListeJoueurs[0].nom);
                texte_fin.setVisible(true);
                theEnd.setVisible(true);
            } else {
                textemessage.setText("Victoire de " + ListeJoueurs[0].nom + " par faute de jeu de " + ListeJoueurs[1].nom);
                panneau_grille.setVisible(false);
                panneau_numero_colonnes.setVisible(false);
                panneau_creation_partie.setVisible(false);
                panneau_info_partie.setVisible(false);
                panneau_info_joueurs.setVisible(false);
                hedwige.setVisible(false);
                les_3_freres.setVisible(false);
                Always.setVisible(false);
                
                texte_fin.setText("Victoire de " + ListeJoueurs[0].nom + " par faute de jeu de " + ListeJoueurs[1].nom);
                texte_fin.setVisible(true);
                theEnd.setVisible(true);
            }
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Always;
    private javax.swing.JButton btn_col_0;
    private javax.swing.JButton btn_col_1;
    private javax.swing.JButton btn_col_2;
    private javax.swing.JButton btn_col_3;
    private javax.swing.JButton btn_col_4;
    private javax.swing.JButton btn_col_5;
    private javax.swing.JButton btn_col_6;
    private javax.swing.JButton btn_gryffondor;
    private javax.swing.JButton btn_poufsouffle;
    private javax.swing.JButton btn_serdaigle;
    private javax.swing.JButton btn_serpentard;
    private javax.swing.JButton btn_start;
    private javax.swing.JButton hedwige;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel lbl_j1_couleur;
    private javax.swing.JLabel lbl_j1_desint;
    private javax.swing.JLabel lbl_j1_nom;
    private javax.swing.JLabel lbl_j2_couleur;
    private javax.swing.JLabel lbl_j2_desint;
    private javax.swing.JLabel lbl_j2_nom;
    private javax.swing.JLabel lbl_jcourant;
    private javax.swing.JButton les_3_freres;
    private javax.swing.JScrollPane message;
    private javax.swing.JTextField nom_joueur1;
    private javax.swing.JTextField nom_joueur2;
    private javax.swing.JPanel panneau_creation_partie;
    private javax.swing.JPanel panneau_fond;
    private javax.swing.JPanel panneau_grille;
    private javax.swing.JPanel panneau_info_joueurs;
    private javax.swing.JPanel panneau_info_partie;
    private javax.swing.JPanel panneau_numero_colonnes;
    private javax.swing.JTextField texte_fin;
    private javax.swing.JTextArea textemessage;
    private javax.swing.JButton theEnd;
    // End of variables declaration//GEN-END:variables

}
