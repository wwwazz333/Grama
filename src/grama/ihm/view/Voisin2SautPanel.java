/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package grama.ihm.view;

import grama.calcule.matrix.FloydWarshall;
import grama.graph.Noeud;
import grama.ihm.DrawGraphPanel;
import grama.ihm.Drawable;
import grama.ihm.MainInterface;
import java.util.LinkedList;
import java.util.List;

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

        jPanel1 = new javax.swing.JPanel();
        titleView = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        nbrVoinsin2Saut = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        listVoisin = new javax.swing.JTextArea();

        setLayout(new javax.swing.BoxLayout(this, javax.swing.BoxLayout.Y_AXIS));

        jPanel1.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 20, 1, 40));
        jPanel1.setLayout(new java.awt.BorderLayout());

        titleView.setFont(new java.awt.Font("sansserif", 0, 24)); // NOI18N
        titleView.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        titleView.setText("Voisin 2 sauts");
        jPanel1.add(titleView, java.awt.BorderLayout.NORTH);

        jLabel1.setText("Nombre voisins 2 sauts :");
        jPanel1.add(jLabel1, java.awt.BorderLayout.WEST);

        nbrVoinsin2Saut.setText("null");
        jPanel1.add(nbrVoinsin2Saut, java.awt.BorderLayout.EAST);

        add(jPanel1);

        jPanel2.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 20, 1, 1));
        jPanel2.setLayout(new java.awt.BorderLayout());

        jLabel2.setText("voisins :");
        jPanel2.add(jLabel2, java.awt.BorderLayout.WEST);

        listVoisin.setEditable(false);
        listVoisin.setBackground(new java.awt.Color(204, 204, 204));
        listVoisin.setColumns(20);
        listVoisin.setForeground(new java.awt.Color(0, 0, 0));
        listVoisin.setRows(5);
        listVoisin.setTabSize(4);
        listVoisin.setText("null");
        jScrollPane1.setViewportView(listVoisin);

        jPanel2.add(jScrollPane1, java.awt.BorderLayout.EAST);

        add(jPanel2);
    }// </editor-fold>//GEN-END:initComponents
/**
 * permet d'update notre pannel et d'afficher la liste des voisins en fonction des ainsi que le nombre de voisins
 * 
 */
    @Override
    public void update() {
        DrawGraphPanel graphPanel = getParent().getDrawGraphPanel();
        if (graphPanel != null && graphPanel.getGraph() != null) {
            Noeud selected = graphPanel.getSelectedNodes().get(0);
            listVoisin.enableInputMethods(false);
            graphPanel.getPanelLegende().cheminVisible(false);
            graphPanel.getPanelLegende().NoeudCorrespondVisible(true);
            

            listVoisin.setText("");
            if (selected != null) {
                List<Noeud> nodes = selected.getVoisin2Dist(graphPanel.getGraph(), FloydWarshall.getInstanceSaut(), Noeud.Type.ALL);
                List<Drawable> nodeHighlite = new LinkedList<>();

                nbrVoinsin2Saut.setText(String.valueOf(nodes.size()));
                for (Noeud node : nodes) {
                    listVoisin.setText(listVoisin.getText() + "\n" + node.toString());
                    nodeHighlite.add((Drawable) node);

                }

                graphPanel.setHighlited(nodeHighlite);

            }
        }

    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea listVoisin;
    private javax.swing.JLabel nbrVoinsin2Saut;
    private javax.swing.JLabel titleView;
    // End of variables declaration//GEN-END:variables
}
