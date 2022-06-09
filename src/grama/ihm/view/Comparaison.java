/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package grama.ihm.view;

import grama.calcule.matrix.FloydWarshall;
import grama.graph.Noeud;
import grama.ihm.DrawGraphPanel;
import grama.ihm.MainInterface;
import static grama.graph.Noeud.compareOpeningTo;


public class Comparaison extends InfoAbstractPanel {

    /**
     * Crée une nouvelle JPanel form 
     */
    public Comparaison(MainInterface parent) {
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

        titleLabel = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        ouverteLabel = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        gastronomiqueLabel = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        culturelleLabel = new javax.swing.JLabel();

        setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 20, 1, 40));
        setLayout(new java.awt.GridLayout(4, 0));

        titleLabel.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        titleLabel.setText("Comparaison entre deux noeuds :");
        add(titleLabel);

        jPanel1.setLayout(new java.awt.BorderLayout());

        ouverteLabel.setText("Choisisser deux noeuds");
        jPanel1.add(ouverteLabel, java.awt.BorderLayout.CENTER);

        add(jPanel1);

        jPanel2.setLayout(new java.awt.BorderLayout());
        jPanel2.add(gastronomiqueLabel, java.awt.BorderLayout.CENTER);

        add(jPanel2);

        jPanel3.setLayout(new java.awt.BorderLayout());
        jPanel3.add(culturelleLabel, java.awt.BorderLayout.CENTER);

        add(jPanel3);
    }// </editor-fold>//GEN-END:initComponents
    
    
    /**
     * notre méthode update permet d'actualiser l'affichage dans notre ihm pour la classe comparaison en fonction en fonction
     * des noeuds séléctionés.
     */
    @Override
    public void update() {
        DrawGraphPanel graphPanel = getParent().getDrawGraphPanel();
        if (graphPanel != null && graphPanel.getGraph() != null) {
            Noeud selected0 = graphPanel.getSelectedNodes().get(0);
            Noeud selected1 = graphPanel.getSelectedNodes().get(1);
            graphPanel.getPanelLegende().NoeudCorrespondVisible(false);
            graphPanel.getPanelLegende().cheminVisible(false);
            
            if (selected0 != null && selected1 != null) {
                int ouvertureGeneral = compareOpeningTo(selected0, selected1, graphPanel.getGraph(), FloydWarshall.getInstanceSaut(), Noeud.Type.ALL);
                if (ouvertureGeneral > 0) {
                    ouverteLabel.setText(selected0.getNom() + " est plus ouverte que " + selected1.getNom());
                } else if (ouvertureGeneral < 0) {
                    ouverteLabel.setText(selected0.getNom() + " est moins ouverte que " + selected1.getNom());
                } else {
                    ouverteLabel.setText(selected0.getNom() + " est autant ouverte que " + selected1.getNom());
                }

                int ouvertureGastronomique = compareOpeningTo(selected0, selected1, graphPanel.getGraph(), FloydWarshall.getInstanceSaut(), Noeud.Type.RESTAURANT);
                if (ouvertureGastronomique > 0) {
                    gastronomiqueLabel.setText(selected0.getNom() + " est plus gastronimique que " + selected1.getNom());
                } else if (ouvertureGastronomique < 0) {
                    gastronomiqueLabel.setText(selected0.getNom() + " est moins gastronomique que " + selected1.getNom());
                } else {
                    gastronomiqueLabel.setText(selected0.getNom() + " est autant gastronomique que " + selected1.getNom());
                }

                int ouvertureCulturelle = compareOpeningTo(selected0, selected1, graphPanel.getGraph(), FloydWarshall.getInstanceSaut(), Noeud.Type.LOISIR);
                if (ouvertureCulturelle > 0) {
                    culturelleLabel.setText(selected0.getNom() + " est plus culturelle que " + selected1.getNom());
                } else if (ouvertureCulturelle < 0) {
                    culturelleLabel.setText(selected0.getNom() + " est plus culturelle que " + selected1.getNom());
                } else {
                    culturelleLabel.setText(selected0.getNom() + " est autant culturelle que " + selected1.getNom());
                }
            } else {
                ouverteLabel.setText("Choisisser deux noeuds");
                gastronomiqueLabel.setText("");
                culturelleLabel.setText("");
            }
        }

    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel culturelleLabel;
    private javax.swing.JLabel gastronomiqueLabel;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JLabel ouverteLabel;
    private javax.swing.JLabel titleLabel;
    // End of variables declaration//GEN-END:variables
}
