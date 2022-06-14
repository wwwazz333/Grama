package grama.ihm.view;

import grama.graph.Lien;
import grama.graph.Noeud;
import grama.ihm.DrawGraphPanel;
import grama.ihm.MainInterface;
import java.awt.Color;

/**
 * Permet d'afficher les information à propos d'un noeud
 * @author virgile
 */
public class InfoGraphPanel extends InfoAbstractPanel {

    /**
     * Creates new form infoGraphPanel
     * @param parent la fenetre parente
     */
    public InfoGraphPanel(MainInterface parent) {
        super(parent);
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form. WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jPanel3 = new javax.swing.JPanel();
        infoGenralPanel = new javax.swing.JPanel();
        infoPanel1 = new javax.swing.JPanel();
        titleGenralInfoLabel = new javax.swing.JLabel();
        nbrLabel1 = new javax.swing.JLabel();
        nbrLieuLabel = new javax.swing.JLabel();
        infoPanel2 = new javax.swing.JPanel();
        nbrVilleLabel = new javax.swing.JLabel();
        nbrLabel2 = new javax.swing.JLabel();
        infoPanel3 = new javax.swing.JPanel();
        nbrLabel7 = new javax.swing.JLabel();
        nbrRestoLabel = new javax.swing.JLabel();
        infoPanel4 = new javax.swing.JPanel();
        nbrLoisirLabel = new javax.swing.JLabel();
        nbrLabel4 = new javax.swing.JLabel();
        affichageLieux = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        checkBoxPanel = new javax.swing.JPanel();
        checkBoxVille = new javax.swing.JCheckBox();
        checkBoxLoisir = new javax.swing.JCheckBox();
        checkBoxResto = new javax.swing.JCheckBox();
        infoPanel5 = new javax.swing.JPanel();
        nbrLabel3 = new javax.swing.JLabel();
        nbrRouteLabel = new javax.swing.JLabel();
        infoPanel6 = new javax.swing.JPanel();
        nbrDepartementalLabel = new javax.swing.JLabel();
        nbrLabel6 = new javax.swing.JLabel();
        infoPanel7 = new javax.swing.JPanel();
        nbrLabel5 = new javax.swing.JLabel();
        nbrNationalLabel = new javax.swing.JLabel();
        infoPanel8 = new javax.swing.JPanel();
        nbrLabel8 = new javax.swing.JLabel();
        nbrAutorouteLabel = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        checkBoxDepartemental = new javax.swing.JCheckBox();
        checkBoxNational = new javax.swing.JCheckBox();
        checkBoxAutoroute = new javax.swing.JCheckBox();
        infoSelectedPanel = new javax.swing.JPanel();
        nameSelectedPanel = new javax.swing.JPanel();
        titleSelectedInfoLabel = new javax.swing.JLabel();
        nameLabel = new javax.swing.JLabel();
        nameSelectedLabel = new javax.swing.JLabel();
        typeSelectedPanel = new javax.swing.JPanel();
        typeLabel = new javax.swing.JLabel();
        typeSelectedLabel = new javax.swing.JLabel();
        ouvetureSelectedPanel = new javax.swing.JPanel();
        ouvertureLabel = new javax.swing.JLabel();
        ouvertureSelectedLabel = new javax.swing.JLabel();

        setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 20, 1, 40));
        setLayout(new java.awt.BorderLayout());

        jScrollPane1.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));

        jPanel3.setLayout(new java.awt.GridLayout(2, 1, 0, 1));

        infoGenralPanel.setLayout(new javax.swing.BoxLayout(infoGenralPanel, javax.swing.BoxLayout.Y_AXIS));

        infoPanel1.setLayout(new java.awt.BorderLayout());

        titleGenralInfoLabel.setFont(new java.awt.Font("sansserif", 1, 18)); // NOI18N
        titleGenralInfoLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        titleGenralInfoLabel.setText("Général");
        infoPanel1.add(titleGenralInfoLabel, java.awt.BorderLayout.NORTH);

        nbrLabel1.setFont(new java.awt.Font("sansserif", 1, 13)); // NOI18N
        nbrLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        nbrLabel1.setText("nombre lieux : ");
        infoPanel1.add(nbrLabel1, java.awt.BorderLayout.WEST);

        nbrLieuLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        nbrLieuLabel.setText("null");
        infoPanel1.add(nbrLieuLabel, java.awt.BorderLayout.EAST);

        infoGenralPanel.add(infoPanel1);

        infoPanel2.setLayout(new java.awt.BorderLayout());

        nbrVilleLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        nbrVilleLabel.setText("null");
        infoPanel2.add(nbrVilleLabel, java.awt.BorderLayout.EAST);

        nbrLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        nbrLabel2.setText("nombre ville : ");
        infoPanel2.add(nbrLabel2, java.awt.BorderLayout.WEST);

        infoGenralPanel.add(infoPanel2);

        infoPanel3.setLayout(new java.awt.BorderLayout());

        nbrLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        nbrLabel7.setText("nombre restaurant : ");
        infoPanel3.add(nbrLabel7, java.awt.BorderLayout.WEST);

        nbrRestoLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        nbrRestoLabel.setText("null");
        infoPanel3.add(nbrRestoLabel, java.awt.BorderLayout.EAST);

        infoGenralPanel.add(infoPanel3);

        infoPanel4.setLayout(new java.awt.BorderLayout());

        nbrLoisirLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        nbrLoisirLabel.setText("null");
        infoPanel4.add(nbrLoisirLabel, java.awt.BorderLayout.EAST);

        nbrLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        nbrLabel4.setText("nombre loisir : ");
        infoPanel4.add(nbrLabel4, java.awt.BorderLayout.WEST);

        infoGenralPanel.add(infoPanel4);

        affichageLieux.setLayout(new java.awt.BorderLayout());

        jLabel1.setFont(new java.awt.Font("sansserif", 2, 13)); // NOI18N
        jLabel1.setText("affichage lieu");
        affichageLieux.add(jLabel1, java.awt.BorderLayout.WEST);

        checkBoxPanel.setOpaque(false);
        checkBoxPanel.setLayout(new javax.swing.BoxLayout(checkBoxPanel, javax.swing.BoxLayout.LINE_AXIS));

        checkBoxVille.setSelected(true);
        checkBoxVille.setText("V");
        checkBoxVille.setToolTipText("Ville");
        checkBoxVille.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkBoxVilleActionPerformed(evt);
            }
        });
        checkBoxPanel.add(checkBoxVille);

        checkBoxLoisir.setSelected(true);
        checkBoxLoisir.setText("L");
        checkBoxLoisir.setToolTipText("Loisir");
        checkBoxLoisir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkBoxLoisirActionPerformed(evt);
            }
        });
        checkBoxPanel.add(checkBoxLoisir);

        checkBoxResto.setSelected(true);
        checkBoxResto.setText("R");
        checkBoxResto.setToolTipText("Restaurant");
        checkBoxResto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkBoxRestoActionPerformed(evt);
            }
        });
        checkBoxPanel.add(checkBoxResto);

        affichageLieux.add(checkBoxPanel, java.awt.BorderLayout.EAST);

        infoGenralPanel.add(affichageLieux);

        infoPanel5.setLayout(new java.awt.BorderLayout());

        nbrLabel3.setFont(new java.awt.Font("sansserif", 1, 13)); // NOI18N
        nbrLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        nbrLabel3.setText("nombre route : ");
        infoPanel5.add(nbrLabel3, java.awt.BorderLayout.WEST);

        nbrRouteLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        nbrRouteLabel.setText("null");
        infoPanel5.add(nbrRouteLabel, java.awt.BorderLayout.EAST);

        infoGenralPanel.add(infoPanel5);

        infoPanel6.setLayout(new java.awt.BorderLayout());

        nbrDepartementalLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        nbrDepartementalLabel.setText("null");
        infoPanel6.add(nbrDepartementalLabel, java.awt.BorderLayout.EAST);

        nbrLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        nbrLabel6.setText("nombre departemental : ");
        infoPanel6.add(nbrLabel6, java.awt.BorderLayout.WEST);

        infoGenralPanel.add(infoPanel6);

        infoPanel7.setLayout(new java.awt.BorderLayout());

        nbrLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        nbrLabel5.setText("nombre nationale : ");
        infoPanel7.add(nbrLabel5, java.awt.BorderLayout.WEST);

        nbrNationalLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        nbrNationalLabel.setText("null");
        infoPanel7.add(nbrNationalLabel, java.awt.BorderLayout.EAST);

        infoGenralPanel.add(infoPanel7);

        infoPanel8.setLayout(new java.awt.BorderLayout());

        nbrLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        nbrLabel8.setText("nombre autoroute : ");
        infoPanel8.add(nbrLabel8, java.awt.BorderLayout.WEST);

        nbrAutorouteLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        nbrAutorouteLabel.setText("null");
        infoPanel8.add(nbrAutorouteLabel, java.awt.BorderLayout.EAST);

        infoGenralPanel.add(infoPanel8);

        jPanel1.setLayout(new java.awt.BorderLayout());

        jLabel2.setFont(new java.awt.Font("sansserif", 2, 13)); // NOI18N
        jLabel2.setText("affichage route");
        jPanel1.add(jLabel2, java.awt.BorderLayout.WEST);

        jPanel2.setLayout(new javax.swing.BoxLayout(jPanel2, javax.swing.BoxLayout.LINE_AXIS));

        checkBoxDepartemental.setSelected(true);
        checkBoxDepartemental.setText("D");
        checkBoxDepartemental.setToolTipText("Départemental");
        checkBoxDepartemental.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkBoxDepartementalActionPerformed(evt);
            }
        });
        jPanel2.add(checkBoxDepartemental);

        checkBoxNational.setSelected(true);
        checkBoxNational.setText("N");
        checkBoxNational.setToolTipText("Nationale");
        checkBoxNational.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkBoxNationalActionPerformed(evt);
            }
        });
        jPanel2.add(checkBoxNational);

        checkBoxAutoroute.setSelected(true);
        checkBoxAutoroute.setText("A");
        checkBoxAutoroute.setToolTipText("Autoroute");
        checkBoxAutoroute.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkBoxAutorouteActionPerformed(evt);
            }
        });
        jPanel2.add(checkBoxAutoroute);

        jPanel1.add(jPanel2, java.awt.BorderLayout.EAST);

        infoGenralPanel.add(jPanel1);

        jPanel3.add(infoGenralPanel);

        infoSelectedPanel.setLayout(new javax.swing.BoxLayout(infoSelectedPanel, javax.swing.BoxLayout.Y_AXIS));

        nameSelectedPanel.setLayout(new java.awt.BorderLayout());

        titleSelectedInfoLabel.setFont(new java.awt.Font("sansserif", 1, 18)); // NOI18N
        titleSelectedInfoLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        titleSelectedInfoLabel.setText("Particulier");
        nameSelectedPanel.add(titleSelectedInfoLabel, java.awt.BorderLayout.NORTH);

        nameLabel.setFont(new java.awt.Font("sansserif", 0, 13)); // NOI18N
        nameLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        nameLabel.setText("nom : ");
        nameSelectedPanel.add(nameLabel, java.awt.BorderLayout.WEST);

        nameSelectedLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        nameSelectedLabel.setText("null");
        nameSelectedPanel.add(nameSelectedLabel, java.awt.BorderLayout.EAST);

        infoSelectedPanel.add(nameSelectedPanel);

        typeSelectedPanel.setLayout(new java.awt.BorderLayout());

        typeLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        typeLabel.setText("type : ");
        typeSelectedPanel.add(typeLabel, java.awt.BorderLayout.WEST);

        typeSelectedLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        typeSelectedLabel.setText("null");
        typeSelectedPanel.add(typeSelectedLabel, java.awt.BorderLayout.EAST);

        infoSelectedPanel.add(typeSelectedPanel);

        ouvetureSelectedPanel.setLayout(new java.awt.BorderLayout());

        ouvertureLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        ouvertureLabel.setText("ouverture : ");
        ouvetureSelectedPanel.add(ouvertureLabel, java.awt.BorderLayout.WEST);

        ouvertureSelectedLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        ouvertureSelectedLabel.setText("null");
        ouvetureSelectedPanel.add(ouvertureSelectedLabel, java.awt.BorderLayout.EAST);

        infoSelectedPanel.add(ouvetureSelectedPanel);

        jPanel3.add(infoSelectedPanel);

        jScrollPane1.setViewportView(jPanel3);

        add(jScrollPane1, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    private void checkBoxRestoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkBoxRestoActionPerformed
        this.update();
    }//GEN-LAST:event_checkBoxRestoActionPerformed

    private void checkBoxVilleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkBoxVilleActionPerformed
        this.update();
    }//GEN-LAST:event_checkBoxVilleActionPerformed

    private void checkBoxLoisirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkBoxLoisirActionPerformed
        this.update();
    }//GEN-LAST:event_checkBoxLoisirActionPerformed

    private void checkBoxDepartementalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkBoxDepartementalActionPerformed
        this.update();
    }//GEN-LAST:event_checkBoxDepartementalActionPerformed

    private void checkBoxNationalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkBoxNationalActionPerformed
        this.update();
    }//GEN-LAST:event_checkBoxNationalActionPerformed

    private void checkBoxAutorouteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkBoxAutorouteActionPerformed
        this.update();
    }//GEN-LAST:event_checkBoxAutorouteActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel affichageLieux;
    private javax.swing.JCheckBox checkBoxAutoroute;
    private javax.swing.JCheckBox checkBoxDepartemental;
    private javax.swing.JCheckBox checkBoxLoisir;
    private javax.swing.JCheckBox checkBoxNational;
    private javax.swing.JPanel checkBoxPanel;
    private javax.swing.JCheckBox checkBoxResto;
    private javax.swing.JCheckBox checkBoxVille;
    private javax.swing.JPanel infoGenralPanel;
    private javax.swing.JPanel infoPanel1;
    private javax.swing.JPanel infoPanel2;
    private javax.swing.JPanel infoPanel3;
    private javax.swing.JPanel infoPanel4;
    private javax.swing.JPanel infoPanel5;
    private javax.swing.JPanel infoPanel6;
    private javax.swing.JPanel infoPanel7;
    private javax.swing.JPanel infoPanel8;
    private javax.swing.JPanel infoSelectedPanel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel nameLabel;
    private javax.swing.JLabel nameSelectedLabel;
    private javax.swing.JPanel nameSelectedPanel;
    private javax.swing.JLabel nbrAutorouteLabel;
    private javax.swing.JLabel nbrDepartementalLabel;
    private javax.swing.JLabel nbrLabel1;
    private javax.swing.JLabel nbrLabel2;
    private javax.swing.JLabel nbrLabel3;
    private javax.swing.JLabel nbrLabel4;
    private javax.swing.JLabel nbrLabel5;
    private javax.swing.JLabel nbrLabel6;
    private javax.swing.JLabel nbrLabel7;
    private javax.swing.JLabel nbrLabel8;
    private javax.swing.JLabel nbrLieuLabel;
    private javax.swing.JLabel nbrLoisirLabel;
    private javax.swing.JLabel nbrNationalLabel;
    private javax.swing.JLabel nbrRestoLabel;
    private javax.swing.JLabel nbrRouteLabel;
    private javax.swing.JLabel nbrVilleLabel;
    private javax.swing.JLabel ouvertureLabel;
    private javax.swing.JLabel ouvertureSelectedLabel;
    private javax.swing.JPanel ouvetureSelectedPanel;
    private javax.swing.JLabel titleGenralInfoLabel;
    private javax.swing.JLabel titleSelectedInfoLabel;
    private javax.swing.JLabel typeLabel;
    private javax.swing.JLabel typeSelectedLabel;
    private javax.swing.JPanel typeSelectedPanel;
    // End of variables declaration//GEN-END:variables

    @Override
    /**
     * permet d'avoir le nombre de chaque type de route,de liens. cela permet aussi d'afficher des informations sur le noeud séléctionné (son nom,son
     * type,son ouverture)
     */
    public void update() {
        DrawGraphPanel graphPanel = getMainInterface().getDrawGraphPanel();
        if (graphPanel != null && graphPanel.getGraph() != null) {
            Noeud.Type typeNoeudAffichage = Noeud.Type.NONE;
            if (checkBoxVille.isSelected()) {
                typeNoeudAffichage = typeNoeudAffichage.or(Noeud.Type.VILLE);
            }
            if (checkBoxLoisir.isSelected()) {
                typeNoeudAffichage = typeNoeudAffichage.or(Noeud.Type.LOISIR);
            }
            if (checkBoxResto.isSelected()) {
                typeNoeudAffichage = typeNoeudAffichage.or(Noeud.Type.RESTAURANT);
            }
            graphPanel.setTypeNoeud(typeNoeudAffichage);
            Lien.Type typeLienAffichage = Lien.Type.NONE;
            if (checkBoxDepartemental.isSelected()) {
                typeLienAffichage = typeLienAffichage.or(Lien.Type.DEPARTEMENTALE);
            }
            if (checkBoxNational.isSelected()) {
                typeLienAffichage = typeLienAffichage.or(Lien.Type.NATIONALE);
            }
            if (checkBoxAutoroute.isSelected()) {
                typeLienAffichage = typeLienAffichage.or(Lien.Type.AUTOROUTE);
            }
            graphPanel.setTypeLien(typeLienAffichage);

            nbrLieuLabel.setText(Integer.toString(graphPanel.getGraph().getListNoeudOfType(Noeud.Type.ALL).size()));
            nbrVilleLabel.setText(Integer.toString(graphPanel.getGraph().getListNoeudOfType(Noeud.Type.VILLE).size()));
            nbrRestoLabel.setText(Integer.toString(graphPanel.getGraph().getListNoeudOfType(Noeud.Type.RESTAURANT).size()));
            nbrLoisirLabel.setText(Integer.toString(graphPanel.getGraph().getListNoeudOfType(Noeud.Type.LOISIR).size()));

            nbrRouteLabel.setText(Integer.toString(graphPanel.getGraph().getListLienOfType(Lien.Type.ALL).size()));
            nbrDepartementalLabel.setText(Integer.toString(graphPanel.getGraph().getListLienOfType(Lien.Type.DEPARTEMENTALE).size()));
            nbrNationalLabel.setText(Integer.toString(graphPanel.getGraph().getListLienOfType(Lien.Type.NATIONALE).size()));
            nbrAutorouteLabel.setText(Integer.toString(graphPanel.getGraph().getListLienOfType(Lien.Type.AUTOROUTE).size()));

            //Selected
            Noeud selected = graphPanel.getSelectedNodes().get(0);
            if (selected != null) {
                nameSelectedLabel.setText(selected.getNom());
                typeSelectedLabel.setText(selected.getTypeLieu().toString());
                ouvertureSelectedLabel.setText(String.valueOf(selected.getListLien().size()));
            } else {
                nameSelectedLabel.setText("null");
                typeSelectedLabel.setText("null");
                ouvertureSelectedLabel.setText("null");
            }
            graphPanel.getPanelLegende().NoeudCorrespondVisible(false);
            graphPanel.getPanelLegende().cheminVisible(false);
            

            graphPanel.repaint();
        }
    }
}
