/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package grama.ihm.view;

import grama.graph.Noeud;
import grama.ihm.DrawGraphPanel;
import grama.ihm.Drawable;
import grama.ihm.MainInterface;
import java.util.LinkedList;
import java.util.List;


public class VoisinDirect extends InfoAbstractPanel {

    /**
     * Creates new form VoisinDirect
     */
    public VoisinDirect(MainInterface parent) {
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

        jLabel2 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        nbVoisinLabel = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        listVoisinArea = new javax.swing.JTextArea();

        setLayout(new javax.swing.BoxLayout(this, javax.swing.BoxLayout.Y_AXIS));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel2.setText("Voisins Directe");
        add(jLabel2);

        jPanel1.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 20, 1, 40));
        jPanel1.setLayout(new java.awt.BorderLayout());

        jLabel1.setText("Nombre de voisin direct :");
        jPanel1.add(jLabel1, java.awt.BorderLayout.WEST);

        nbVoisinLabel.setText("null");
        jPanel1.add(nbVoisinLabel, java.awt.BorderLayout.LINE_END);

        add(jPanel1);

        jPanel2.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 20, 1, 1));
        jPanel2.setLayout(new java.awt.BorderLayout());

        jLabel4.setText("Liste des voisins directs :");
        jPanel2.add(jLabel4, java.awt.BorderLayout.WEST);

        listVoisinArea.setEditable(false);
        listVoisinArea.setBackground(new java.awt.Color(204, 204, 204));
        listVoisinArea.setColumns(20);
        listVoisinArea.setForeground(new java.awt.Color(0, 0, 0));
        listVoisinArea.setRows(5);
        jScrollPane1.setViewportView(listVoisinArea);

        jPanel2.add(jScrollPane1, java.awt.BorderLayout.LINE_END);

        add(jPanel2);
    }// </editor-fold>//GEN-END:initComponents
    /**
     * permet d'afficher la liste des voisins directes
     */
    @Override
    public void update() {
        DrawGraphPanel graphPanel = getParent().getDrawGraphPanel();
        if (graphPanel != null && graphPanel.getGraph() != null) {
            Noeud selected = graphPanel.getSelectedNodes().get(0);
            graphPanel.getPanelLegende().cheminVisible(false);
            graphPanel.getPanelLegende().NoeudCorrespondVisible(true);
            
            if (selected != null) {
                List<Noeud> nodes = selected.getVoisinsOfType(Noeud.Type.ALL);
                nbVoisinLabel.setText(String.valueOf(nodes.size()));
                listVoisinArea.setText("");

                List<Drawable> drawables = new LinkedList<>();
                for (Noeud noeud : nodes) {
                    listVoisinArea.setText(listVoisinArea.getText() + "\n" + noeud);
                    drawables.add((Drawable) noeud);
                }
                graphPanel.setHighlited(drawables);
            }
        }

    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea listVoisinArea;
    private javax.swing.JLabel nbVoisinLabel;
    // End of variables declaration//GEN-END:variables
}
