/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package grama.ihm.view;

import grama.calcule.matrix.FloydWarshall;
import grama.graph.Lien;
import grama.graph.Noeud;
import grama.ihm.DrawGraphPanel;
import grama.ihm.Drawable;
import grama.ihm.MainInterface;
import java.util.LinkedList;
import java.util.List;
import javax.swing.DefaultListModel;

/**
 * Permett de visualiser tous les noeuds à 2 distances d'un noeud (sélectionné)
 *
 * @author virgile
 */
public class Voisin2SautPanel extends InfoAbstractPanel {

    public Voisin2SautPanel(MainInterface parent) {
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

        titleView = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        filler3 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 20), new java.awt.Dimension(0, 20), new java.awt.Dimension(0, 32767));
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        nbrVoinsin2Saut = new javax.swing.JLabel();
        filler2 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 20), new java.awt.Dimension(0, 20), new java.awt.Dimension(0, 32767));
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jListNoeud = new javax.swing.JList<>();

        setLayout(new java.awt.BorderLayout());

        titleView.setFont(new java.awt.Font("sansserif", 0, 24)); // NOI18N
        titleView.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        titleView.setText("Voisin 2 sauts");
        add(titleView, java.awt.BorderLayout.NORTH);

        jPanel3.setLayout(new javax.swing.BoxLayout(jPanel3, javax.swing.BoxLayout.Y_AXIS));
        jPanel3.add(filler3);

        jPanel1.setLayout(new javax.swing.BoxLayout(jPanel1, javax.swing.BoxLayout.LINE_AXIS));

        jLabel1.setText("Nombre voisin 2 sauts :  ");
        jPanel1.add(jLabel1);

        nbrVoinsin2Saut.setText("null");
        jPanel1.add(nbrVoinsin2Saut);

        jPanel3.add(jPanel1);
        jPanel3.add(filler2);

        jPanel2.setLayout(new java.awt.BorderLayout());

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Liste des voisins");
        jPanel2.add(jLabel2, java.awt.BorderLayout.NORTH);

        jScrollPane2.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));

        jListNoeud.setBackground(new java.awt.Color(214, 217, 223));
        jListNoeud.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jListNoeud.setModel(new DefaultListModel<>());
        jListNoeud.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jListNoeud.setSelectionBackground(new java.awt.Color(214, 217, 223));
        jListNoeud.setSelectionForeground(new java.awt.Color(0, 0, 0));
        jListNoeud.setVisibleRowCount(30);
        jScrollPane2.setViewportView(jListNoeud);

        jPanel2.add(jScrollPane2, java.awt.BorderLayout.CENTER);

        jPanel3.add(jPanel2);

        add(jPanel3, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents
/**
     * permet d'update notre pannel et d'afficher la liste des voisins ainsi que le nombre de voisins
     *
     */
    @Override
    public void update() {
        DrawGraphPanel graphPanel = getMainInterface().getDrawGraphPanel();
        if (graphPanel != null && graphPanel.getGraph() != null) {
            graphPanel.setLinkSelectable(true);
            Noeud selectedNoeuds = null;
            if (!graphPanel.getSelectedNodes().isEmpty()) {
                selectedNoeuds = graphPanel.getSelectedNodes().get(0);
            }
            Lien slectedLien = graphPanel.getSelectedLink();
            graphPanel.getPanelLegende().cheminVisible(false);
            graphPanel.getPanelLegende().NoeudCorrespondVisible(true);

            DefaultListModel<Noeud> listModel = new DefaultListModel<>();
            List<Drawable> nodeHighlite = new LinkedList<>();
            if (selectedNoeuds != null) {
                List<Noeud> nodes = selectedNoeuds.getVoisin2Dist(graphPanel.getGraph(), Noeud.Type.ALL);

                nbrVoinsin2Saut.setText(String.valueOf(nodes.size()));
                for (Noeud node : nodes) {
                    listModel.addElement(node);
                    nodeHighlite.add((Drawable) node);

                }

            } else {
                nbrVoinsin2Saut.setText("null");
            }
            if (slectedLien != null) {
                nodeHighlite.add((Drawable) slectedLien.getDstAndDepart()[0]);
                nodeHighlite.add((Drawable) slectedLien.getDstAndDepart()[1]);
            }
            graphPanel.setHighlited(nodeHighlite);
            jListNoeud.setModel(listModel);
        }

    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.Box.Filler filler2;
    private javax.swing.Box.Filler filler3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JList<Noeud> jListNoeud;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel nbrVoinsin2Saut;
    private javax.swing.JLabel titleView;
    // End of variables declaration//GEN-END:variables
}
