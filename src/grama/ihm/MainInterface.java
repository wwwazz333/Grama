package grama.ihm;

import grama.calcule.matrix.FloydWarshall;
import grama.exceptions.FormatFileException;
import grama.formater.StringFormater;
import grama.graph.Graph;
import grama.graph.Lien;
import grama.graph.Noeud;
import java.awt.CardLayout;
import java.awt.Component;
import java.awt.Image;
import java.awt.Toolkit;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ButtonGroup;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author wwwazz
 */
public class MainInterface extends javax.swing.JFrame implements Updatable {

    enum ViewMode {
        AFFICHAGE(1),
        VOISIN_DIRECT(1),
        VOISIN2ND(1),
        COMPARAISON(2),
        CHEMIN(2);

        private final int nbrSelectableNode;

        private ViewMode(int a) {
            this.nbrSelectableNode = a;
        }

        public int getNbrSelectableNode() {
            return nbrSelectableNode;
        }

        @Override
        public String toString() {
            return super.toString().toLowerCase();
        }

    }

    private DrawGraphPanel drawGraphPanel;
    private ViewMode currMode = ViewMode.AFFICHAGE;

    private ButtonGroup groupView = new ButtonGroup();

    private void loadFile(File fileGraph) throws IOException {
        Graph graphmap = new Graph();

        graphmap.loadFromString(StringFormater.readFile(fileGraph));

        loadNewGraph(graphmap);
        update();
    }

    private void loadNewGraph(Graph graph) {
        drawGraphPanel = new DrawGraphPanel(this, graph, getFont());
        splitPanel.setRightComponent(drawGraphPanel);
        FloydWarshall.getInstanceKilometrage().initKilometrage(graph);
        FloydWarshall.getInstanceSaut().initSaut(graph);

    }

    /**
     * Creates new form MainInterface
     */
    public MainInterface() {
        initComponents();
        Image icon = Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("/res/logo.png"));
        this.setSize(800,600);
        this.setIconImage(icon);
//        Graph graphmap = new Graph();
//        graphmap.loadFromString("V,Paris:A,120::V,Lyon;A,220::V,Marseille;N,146::V,Rennes;N,59::V,Lille;D,35::L,DisneyLand;D,21::V,Reims;A,367::R,Mcdo;;\n"
//                + "V,Marseille:A,220::V,Paris;A,324::V,Toulouse;N,73::V,Nice;N,49::V,Toulon;D,14::R,Quick;D,346::V,SaintLaurentdeChamousset;N,24::R,Mcdo;;\n"
//                + "V,Lyon:D,10::R,Bocuse;A,120::V,Paris;A,138::V,Grenoble;N,39::V,Dijon;N,237::L,LePal;D,3::V,Villeurbanne;N,34::R,Mcdo;;\n"
//                + "V,Toulouse:A,324::V,Marseille;A,132::V,Bordeaux;N,337::V,Angers;N,342::R,Bocuse;D,37::V,Toulon;D,36::V,Rennes;N,344::L,Walibi;;\n"
//                + "V,Nice:N,73::V,Marseille;A,356::V,Reims;A,254::V,Lille;N,213::V,Villeurbanne;D,34::R,Mcdo;D,43::V,Dijon;N,420::L,Asterix;;\n"
//                + "V,Nantes:A,355::V,Montpellier;A,390::V,Strasbourg;N,572::V,Toulon;N,234::V,Bordeaux;D,53::V,Lille;D,252::V,Reims;N,53::L,CentreAere;;\n"
//                + "V,Montpellier:A,355::V,Nantes;A,356::V,Strasbourg;N,342::V,Bordeaux;N,235::V,Rennes;D,329::V,SaintLaurentdeChamousset;D,379::V,Angers;N,525::R,Quick;;\n"
//                + "V,Strasbourg:A,390::V,Nantes;A,356::V,Montpellier;N,220::V,Lille;N,35::V,Reims;D,437::L,Asterix;D,43::R,PizzàJo;D,35::R,PlanetSushi;;\n"
//                + "V,Bordeaux:A,132::V,Toulouse;N,342::V,Montpellier;N,234::V,Nantes;A,356::V,Lille;D,23::R,PlanetSushi;D,352::V,Dijon;N,42::L,CentreAere;;\n"
//                + "V,Lille:N,59::V,Paris;A,254::V,Nice;D,53::V,Nantes;N,220::V,Strasbourg;A,356::V,Bordeaux;D,432::V,Rennes;A,522::R,Bocuse;;\n"
//                + "V,Rennes:N,146::V,Paris;D,36::V,Toulouse;N,235::V,Montpellier;D,432::V,Lille;A,355::V,SaintLaurentdeChamousset;A,53::V,Grenoble;A,353::R,PlanetSushi;;\n"
//                + "V,Reims:D,21::V,Paris;A,356::V,Nice;D,252::V,Nantes;N,35::V,Strasbourg;N,83::V,SaintLaurentdeChamousset;A,356::V,Dijon;A,432::L,Futuroscope;;\n"
//                + "V,SaintLaurentdeChamousset:D,346::V,Marseille;D,329::V,Montpellier;A,355::V,Rennes;N,83::V,Reims;A,356::R,BurgerKing;N,34::V,Villeurbanne;A,2::R,PizzàJo;;\n"
//                + "V,Toulon:N,49::V,Marseille;D,37::V,Toulouse;N,572::V,Nantes;A,359::V,Dijon;A,352::V,Angers;D,348::R,Quick;N,449::L,DisneyLand;;\n"
//                + "V,Grenoble:A,138::V,Lyon;A,53::V,Rennes;N,438::V,Dijon;N,438::R,PlanetSushi;D,238::R,PizzàJo;D,34::R,Mcdo;N,246::L,Futuroscope;;\n"
//                + "V,Dijon:N,39::V,Lyon;D,43::V,Nice;D,352::V,Bordeaux;A,356::V,Reims;A,359::V,Toulon;N,438::V,Grenoble;;\n"
//                + "V,Angers:N,337::V,Toulouse;D,379::V,Montpellier;A,352::V,Toulon;A,332::R,BurgerKing;N,324::R,PizzàJo;D,23::L,Walibi;;\n"
//                + "V,Villeurbanne:D,3::V,Lyon;N,213::V,Nice;N,34::V,SaintLaurentdeChamousset;A,259::L,Futuroscope;A,345::L,Walibi;D,24::L,LePal;N,31::R,BurgerKing;;\n"
//                + "R,Mcdo:D,34::V,Nice;D,34::V,Grenoble;A,223::R,Quick;A,367::V,Paris;N,34::V,Lyon;N,24::V,Marseille;;\n"
//                + "R,BurgerKing:A,356::V,SaintLaurentdeChamousset;A,332::V,Angers;N,31::V,Villeurbanne;N,53::R,PizzàJo;D,523::L,CentreAere;D,59::L,Asterix;;\n"
//                + "R,PlanetSushi:D,23::V,Bordeaux;N,438::V,Grenoble;D,35::V,Strasbourg;N,322::R,Bocuse;A,353::V,Rennes;A,532::L,DisneyLand;;\n"
//                + "R,PizzàJo:D,43::V,Strasbourg;D,238::V,Grenoble;N,324::V,Angers;N,53::R,BurgerKing;A,2::V,SaintLaurentdeChamousset;A,53::L,Asterix;;\n"
//                + "R,Bocuse:D,10::V,Lyon;N,342::V,Toulouse;N,322::R,PlanetSushi;D,24::L,CentreAere;A,246::L,LePal;A,522::V,Lille;D,32::L,Futuroscope;;\n"
//                + "R,Quick:D,14::V,Marseille;D,348::V,Toulon;A,223::R,Mcdo;A,359::L,CentreAere;N,525::V,Montpellier;N,424::L,LePal;;\n"
//                + "L,CentreAere:D,523::R,BurgerKing;A,359::R,Quick;A,123::L,DisneyLand;D,24::R,Bocuse;N,42::V,Bordeaux;N,53::V,Nantes;;\n"
//                + "L,Asterix:D,437::V,Strasbourg;D,59::R,BurgerKing;A,53::R,PizzàJo;A,422::L,LePal;N,442::L,Walibi;N,420::V,Nice;;\n"
//                + "L,LePal:N,237::V,Lyon;D,24::V,Villeurbanne;N,424::R,Quick;A,422::L,Asterix;A,246::R,Bocuse;D,39::L,Futuroscope;;\n"
//                + "L,Walibi:D,23::V,Angers;A,345::V,Villeurbanne;N,442::L,Asterix;A,439::L,Futuroscope;N,344::V,Toulouse;D,44::L,DisneyLand;;\n"
//                + "L,DisneyLand:D,35::V,Paris;A,532::R,PlanetSushi;A,123::L,CentreAere;D,44::L,Walibi;N,537::L,Futuroscope;N,449::V,Toulon;;\n"
//                + "L,Futuroscope:A,259::V,Villeurbanne;D,39::L,LePal;N,537::L,DisneyLand;A,432::V,Reims;N,246::V,Grenoble;D,32::R,Bocuse;A,439::L,Walibi;;");
//
//        loadNewGraph(graphmap);
        splitPanel.setRightComponent(null);
        splitPanel.setDividerLocation(0.25);

        groupView.add(principalMenuItem);
        groupView.add(affichageMenuItem);
        groupView.add(voisinDirectMenuItem);
        groupView.add(voisin2ndMenuItem);
        groupView.add(comparaisonMenuItem);
        groupView.add(cheminMenuItem);

        this.update();
    }

    /**
     * This method is called from within the constructor to initialize the form. WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        splitPanel = new javax.swing.JSplitPane();
        leftPanel = new javax.swing.JPanel();
        infoPanel = new javax.swing.JPanel();
        infoGenralPanel = new javax.swing.JPanel();
        infoPanel1 = new javax.swing.JPanel();
        nbrLabel = new javax.swing.JLabel();
        nbrLieuLabel = new javax.swing.JLabel();
        titleGenralInfoLabel = new javax.swing.JLabel();
        infoPanel2 = new javax.swing.JPanel();
        nbrLabel1 = new javax.swing.JLabel();
        nbrVilleLabel = new javax.swing.JLabel();
        infoPanel3 = new javax.swing.JPanel();
        nbrLabel2 = new javax.swing.JLabel();
        nbrRestoLabel = new javax.swing.JLabel();
        infoPanel4 = new javax.swing.JPanel();
        nbrLabel3 = new javax.swing.JLabel();
        nbrLoisirLabel = new javax.swing.JLabel();
        infoPanel5 = new javax.swing.JPanel();
        nbrLabel4 = new javax.swing.JLabel();
        nbrRouteLabel = new javax.swing.JLabel();
        infoPanel6 = new javax.swing.JPanel();
        nbrLabel5 = new javax.swing.JLabel();
        nbrDepartementalLabel = new javax.swing.JLabel();
        infoPanel7 = new javax.swing.JPanel();
        nbrLabel6 = new javax.swing.JLabel();
        nbrNationalLabel = new javax.swing.JLabel();
        infoPanel8 = new javax.swing.JPanel();
        nbrLabel7 = new javax.swing.JLabel();
        nbrAutorouteLabel = new javax.swing.JLabel();
        infoSelectedPanel = new javax.swing.JPanel();
        nameSelectedPanel = new javax.swing.JPanel();
        titleSelectedInfoLabel = new javax.swing.JLabel();
        nameSelectedLabel = new javax.swing.JLabel();
        nameLabel = new javax.swing.JLabel();
        typeSelectedPanel = new javax.swing.JPanel();
        typeLabel = new javax.swing.JLabel();
        typeSelectedLabel = new javax.swing.JLabel();
        ouvetureSelectedPanel = new javax.swing.JPanel();
        ouvertureLabel = new javax.swing.JLabel();
        ouvertureSelectedLabel = new javax.swing.JLabel();
        voisinDirectPanel = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        voisin2Panel = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        comparaisonPanel = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        cheminPanel = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        fileMenu = new javax.swing.JMenu();
        OpenMenuItem = new javax.swing.JMenuItem();
        ViewMenu = new javax.swing.JMenu();
        principalMenuItem = new javax.swing.JRadioButtonMenuItem();
        affichageMenuItem = new javax.swing.JRadioButtonMenuItem();
        voisinDirectMenuItem = new javax.swing.JRadioButtonMenuItem();
        voisin2ndMenuItem = new javax.swing.JRadioButtonMenuItem();
        comparaisonMenuItem = new javax.swing.JRadioButtonMenuItem();
        cheminMenuItem = new javax.swing.JRadioButtonMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Grama");
        setMinimumSize(new java.awt.Dimension(144, 144));
        setSize(new java.awt.Dimension(720, 480));

        splitPanel.setDividerLocation(200);
        splitPanel.setResizeWeight(0.1);
        splitPanel.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        leftPanel.setLayout(new java.awt.CardLayout());

        infoPanel.setBackground(new java.awt.Color(0, 0, 0));
        infoPanel.setLayout(new java.awt.GridLayout(2, 1, 0, 1));

        infoGenralPanel.setLayout(new javax.swing.BoxLayout(infoGenralPanel, javax.swing.BoxLayout.Y_AXIS));

        infoPanel1.setLayout(new java.awt.BorderLayout());

        nbrLabel.setFont(new java.awt.Font("sansserif", 1, 13)); // NOI18N
        nbrLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        nbrLabel.setText("nombre lieux : ");
        infoPanel1.add(nbrLabel, java.awt.BorderLayout.LINE_START);

        nbrLieuLabel.setText("null");
        infoPanel1.add(nbrLieuLabel, java.awt.BorderLayout.LINE_END);

        titleGenralInfoLabel.setFont(new java.awt.Font("sansserif", 1, 13)); // NOI18N
        titleGenralInfoLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        titleGenralInfoLabel.setText("Général");
        infoPanel1.add(titleGenralInfoLabel, java.awt.BorderLayout.PAGE_START);

        infoGenralPanel.add(infoPanel1);

        infoPanel2.setLayout(new java.awt.BorderLayout());

        nbrLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        nbrLabel1.setText("nombre ville : ");
        infoPanel2.add(nbrLabel1, java.awt.BorderLayout.LINE_START);

        nbrVilleLabel.setText("null");
        infoPanel2.add(nbrVilleLabel, java.awt.BorderLayout.LINE_END);

        infoGenralPanel.add(infoPanel2);

        infoPanel3.setLayout(new java.awt.BorderLayout());

        nbrLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        nbrLabel2.setText("nombre restaurant : ");
        infoPanel3.add(nbrLabel2, java.awt.BorderLayout.LINE_START);

        nbrRestoLabel.setText("null");
        infoPanel3.add(nbrRestoLabel, java.awt.BorderLayout.LINE_END);

        infoGenralPanel.add(infoPanel3);

        infoPanel4.setLayout(new java.awt.BorderLayout());

        nbrLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        nbrLabel3.setText("nombre loisir : ");
        infoPanel4.add(nbrLabel3, java.awt.BorderLayout.LINE_START);

        nbrLoisirLabel.setText("null");
        infoPanel4.add(nbrLoisirLabel, java.awt.BorderLayout.LINE_END);

        infoGenralPanel.add(infoPanel4);

        infoPanel5.setLayout(new java.awt.BorderLayout());

        nbrLabel4.setFont(new java.awt.Font("sansserif", 1, 13)); // NOI18N
        nbrLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        nbrLabel4.setText("nombre routes : ");
        infoPanel5.add(nbrLabel4, java.awt.BorderLayout.LINE_START);

        nbrRouteLabel.setText("null");
        infoPanel5.add(nbrRouteLabel, java.awt.BorderLayout.LINE_END);

        infoGenralPanel.add(infoPanel5);

        infoPanel6.setLayout(new java.awt.BorderLayout());

        nbrLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        nbrLabel5.setText("nombre departemental : ");
        infoPanel6.add(nbrLabel5, java.awt.BorderLayout.LINE_START);

        nbrDepartementalLabel.setText("null");
        infoPanel6.add(nbrDepartementalLabel, java.awt.BorderLayout.LINE_END);

        infoGenralPanel.add(infoPanel6);

        infoPanel7.setLayout(new java.awt.BorderLayout());

        nbrLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        nbrLabel6.setText("nombre national : ");
        infoPanel7.add(nbrLabel6, java.awt.BorderLayout.LINE_START);

        nbrNationalLabel.setText("null");
        infoPanel7.add(nbrNationalLabel, java.awt.BorderLayout.LINE_END);

        infoGenralPanel.add(infoPanel7);

        infoPanel8.setLayout(new java.awt.BorderLayout());

        nbrLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        nbrLabel7.setText("nombre autoroute : ");
        infoPanel8.add(nbrLabel7, java.awt.BorderLayout.LINE_START);

        nbrAutorouteLabel.setText("null");
        infoPanel8.add(nbrAutorouteLabel, java.awt.BorderLayout.LINE_END);

        infoGenralPanel.add(infoPanel8);

        infoPanel.add(infoGenralPanel);

        infoSelectedPanel.setLayout(new javax.swing.BoxLayout(infoSelectedPanel, javax.swing.BoxLayout.Y_AXIS));

        nameSelectedPanel.setLayout(new java.awt.BorderLayout());

        titleSelectedInfoLabel.setFont(new java.awt.Font("sansserif", 1, 13)); // NOI18N
        titleSelectedInfoLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        titleSelectedInfoLabel.setText("Élement selectionné");
        nameSelectedPanel.add(titleSelectedInfoLabel, java.awt.BorderLayout.PAGE_START);

        nameSelectedLabel.setText("null");
        nameSelectedPanel.add(nameSelectedLabel, java.awt.BorderLayout.LINE_END);

        nameLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        nameLabel.setText("nom : ");
        nameSelectedPanel.add(nameLabel, java.awt.BorderLayout.LINE_START);

        infoSelectedPanel.add(nameSelectedPanel);

        typeSelectedPanel.setLayout(new java.awt.BorderLayout());

        typeLabel.setText("type : ");
        typeSelectedPanel.add(typeLabel, java.awt.BorderLayout.LINE_START);

        typeSelectedLabel.setText("null");
        typeSelectedPanel.add(typeSelectedLabel, java.awt.BorderLayout.LINE_END);

        infoSelectedPanel.add(typeSelectedPanel);

        ouvetureSelectedPanel.setLayout(new java.awt.BorderLayout());

        ouvertureLabel.setText("ouverture : ");
        ouvetureSelectedPanel.add(ouvertureLabel, java.awt.BorderLayout.LINE_START);

        ouvertureSelectedLabel.setText("null");
        ouvetureSelectedPanel.add(ouvertureSelectedLabel, java.awt.BorderLayout.LINE_END);

        infoSelectedPanel.add(ouvetureSelectedPanel);

        infoPanel.add(infoSelectedPanel);

        leftPanel.add(infoPanel, "affichage");

        jLabel1.setText("voisins direct");
        voisinDirectPanel.add(jLabel1);

        leftPanel.add(voisinDirectPanel, "voisin_direct");

        jLabel2.setText("voisin 2 saut");
        voisin2Panel.add(jLabel2);

        leftPanel.add(voisin2Panel, "voisin2nd");

        jLabel3.setText("comparaison");
        comparaisonPanel.add(jLabel3);

        leftPanel.add(comparaisonPanel, "comparaison");

        jLabel4.setText("Chemin");
        cheminPanel.add(jLabel4);

        leftPanel.add(cheminPanel, "chemin");

        splitPanel.setLeftComponent(leftPanel);

        getContentPane().add(splitPanel, java.awt.BorderLayout.CENTER);

        fileMenu.setText("Fichier");

        OpenMenuItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_O, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        OpenMenuItem.setText("Ouvrir");
        OpenMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                OpenMenuItemActionPerformed(evt);
            }
        });
        fileMenu.add(OpenMenuItem);

        jMenuBar1.add(fileMenu);

        ViewMenu.setText("Vue");
        ViewMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ViewMenuActionPerformed(evt);
            }
        });

        principalMenuItem.setText("principal");
        principalMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                principalMenuItemActionPerformed(evt);
            }
        });
        ViewMenu.add(principalMenuItem);

        affichageMenuItem.setSelected(true);
        affichageMenuItem.setText("affichage");
        affichageMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                affichageMenuItemActionPerformed(evt);
            }
        });
        ViewMenu.add(affichageMenuItem);

        voisinDirectMenuItem.setSelected(true);
        voisinDirectMenuItem.setText("voisins direct");
        voisinDirectMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                voisinDirectMenuItemActionPerformed(evt);
            }
        });
        ViewMenu.add(voisinDirectMenuItem);

        voisin2ndMenuItem.setSelected(true);
        voisin2ndMenuItem.setText("voisins 2 sauts");
        voisin2ndMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                voisin2ndMenuItemActionPerformed(evt);
            }
        });
        ViewMenu.add(voisin2ndMenuItem);

        comparaisonMenuItem.setSelected(true);
        comparaisonMenuItem.setText("comparaison");
        comparaisonMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comparaisonMenuItemActionPerformed(evt);
            }
        });
        ViewMenu.add(comparaisonMenuItem);

        cheminMenuItem.setSelected(true);
        cheminMenuItem.setText("chemin");
        cheminMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cheminMenuItemActionPerformed(evt);
            }
        });
        ViewMenu.add(cheminMenuItem);

        jMenuBar1.add(ViewMenu);

        setJMenuBar(jMenuBar1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void OpenMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_OpenMenuItemActionPerformed
        openFile();
    }//GEN-LAST:event_OpenMenuItemActionPerformed

    private void ViewMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ViewMenuActionPerformed

    }//GEN-LAST:event_ViewMenuActionPerformed

    private void voisinDirectMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_voisinDirectMenuItemActionPerformed
        switchToMode(ViewMode.VOISIN_DIRECT);
    }//GEN-LAST:event_voisinDirectMenuItemActionPerformed

    private void affichageMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_affichageMenuItemActionPerformed
        switchToMode(ViewMode.AFFICHAGE);
    }//GEN-LAST:event_affichageMenuItemActionPerformed

    private void voisin2ndMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_voisin2ndMenuItemActionPerformed
        switchToMode(ViewMode.VOISIN2ND);
    }//GEN-LAST:event_voisin2ndMenuItemActionPerformed

    private void cheminMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cheminMenuItemActionPerformed
        switchToMode(ViewMode.CHEMIN);
    }//GEN-LAST:event_cheminMenuItemActionPerformed

    private void comparaisonMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comparaisonMenuItemActionPerformed
        switchToMode(ViewMode.COMPARAISON);
    }//GEN-LAST:event_comparaisonMenuItemActionPerformed

    private void principalMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_principalMenuItemActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_principalMenuItemActionPerformed

    /**
     * show a dialog window for a warning
     *
     * @param parent the parent Component of this new dialog window
     * @param msg the message do display in this new dialog window
     */
    private void showWarningDialog(Component parent, String msg) {
        JOptionPane.showMessageDialog(parent, msg, "Grama", JOptionPane.WARNING_MESSAGE);
    }

    /**
     * show a dialog window for warn about the read right of a file
     *
     * @param file the file with wrong right.
     */
    private void showReadRightWarning(File file) {
        showWarningDialog(this, file.getAbsolutePath() + "\nVous n'avez pas l'autorisation d'ouvrir ce fichier. Consultez le propriétaire du fichier ou un administrateur pour obtenir cette autorisation");

    }

    /**
     * launch a graphical way to open a file
     */
    private void openFile() {
        JFileChooser fileOpen = new JFileChooser();
        fileOpen.setMultiSelectionEnabled(false);
        fileOpen.setFileFilter(new FileNameExtensionFilter("fichier en .csv", "csv"));

        int res = fileOpen.showOpenDialog(this);
        File file = fileOpen.getSelectedFile();
        while (res == JFileChooser.APPROVE_OPTION && file != null && !file.canRead()) {
            showReadRightWarning(file);
            res = fileOpen.showOpenDialog(this);
            file = fileOpen.getSelectedFile();
        }

        if (res == JFileChooser.APPROVE_OPTION) {
            try {
                loadFile(file);
            } catch (FormatFileException e) {
                showWarningDialog(this, "Erreur à la ligne : " + e.getLineNumber() + "\n" + e.getNonConforme());
            } catch (IOException ex) {
                showReadRightWarning(file);
            }

        }
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
            java.util.logging.Logger.getLogger(MainInterface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainInterface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainInterface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainInterface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                MainInterface mainInterface = new MainInterface();
                mainInterface.setLocationRelativeTo(null);
                mainInterface.setVisible(true);
            }
        });
    }

    public static void start() {
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
            java.util.logging.Logger.getLogger(MainInterface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainInterface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainInterface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainInterface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            MainInterface mainInterface = new MainInterface();
            mainInterface.setLocationRelativeTo(null);
            mainInterface.setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem OpenMenuItem;
    private javax.swing.JMenu ViewMenu;
    private javax.swing.JRadioButtonMenuItem affichageMenuItem;
    private javax.swing.JRadioButtonMenuItem cheminMenuItem;
    private javax.swing.JPanel cheminPanel;
    private javax.swing.JRadioButtonMenuItem comparaisonMenuItem;
    private javax.swing.JPanel comparaisonPanel;
    private javax.swing.JMenu fileMenu;
    private javax.swing.JPanel infoGenralPanel;
    private javax.swing.JPanel infoPanel;
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
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel leftPanel;
    private javax.swing.JLabel nameLabel;
    private javax.swing.JLabel nameSelectedLabel;
    private javax.swing.JPanel nameSelectedPanel;
    private javax.swing.JLabel nbrAutorouteLabel;
    private javax.swing.JLabel nbrDepartementalLabel;
    private javax.swing.JLabel nbrLabel;
    private javax.swing.JLabel nbrLabel1;
    private javax.swing.JLabel nbrLabel2;
    private javax.swing.JLabel nbrLabel3;
    private javax.swing.JLabel nbrLabel4;
    private javax.swing.JLabel nbrLabel5;
    private javax.swing.JLabel nbrLabel6;
    private javax.swing.JLabel nbrLabel7;
    private javax.swing.JLabel nbrLieuLabel;
    private javax.swing.JLabel nbrLoisirLabel;
    private javax.swing.JLabel nbrNationalLabel;
    private javax.swing.JLabel nbrRestoLabel;
    private javax.swing.JLabel nbrRouteLabel;
    private javax.swing.JLabel nbrVilleLabel;
    private javax.swing.JLabel ouvertureLabel;
    private javax.swing.JLabel ouvertureSelectedLabel;
    private javax.swing.JPanel ouvetureSelectedPanel;
    private javax.swing.JRadioButtonMenuItem principalMenuItem;
    private javax.swing.JSplitPane splitPanel;
    private javax.swing.JLabel titleGenralInfoLabel;
    private javax.swing.JLabel titleSelectedInfoLabel;
    private javax.swing.JLabel typeLabel;
    private javax.swing.JLabel typeSelectedLabel;
    private javax.swing.JPanel typeSelectedPanel;
    private javax.swing.JPanel voisin2Panel;
    private javax.swing.JRadioButtonMenuItem voisin2ndMenuItem;
    private javax.swing.JRadioButtonMenuItem voisinDirectMenuItem;
    private javax.swing.JPanel voisinDirectPanel;
    // End of variables declaration//GEN-END:variables

    @Override
    public void update() {
        if (drawGraphPanel == null) {
            return;
        }
        if (currMode == ViewMode.AFFICHAGE) {
            //Général
            nbrLieuLabel.setText(Integer.toString(drawGraphPanel.getGraph().getListNoeudOfType(Noeud.Type.ALL).size()));
            nbrVilleLabel.setText(Integer.toString(drawGraphPanel.getGraph().getListNoeudOfType(Noeud.Type.VILLE).size()));
            nbrRestoLabel.setText(Integer.toString(drawGraphPanel.getGraph().getListNoeudOfType(Noeud.Type.RESTAURANT).size()));
            nbrLoisirLabel.setText(Integer.toString(drawGraphPanel.getGraph().getListNoeudOfType(Noeud.Type.LOISIR).size()));

            nbrRouteLabel.setText(Integer.toString(drawGraphPanel.getGraph().getListLienOfType(Lien.Type.ALL).size()));
            nbrDepartementalLabel.setText(Integer.toString(drawGraphPanel.getGraph().getListLienOfType(Lien.Type.DEPARTEMENTALE).size()));
            nbrNationalLabel.setText(Integer.toString(drawGraphPanel.getGraph().getListLienOfType(Lien.Type.NATIONALE).size()));
            nbrAutorouteLabel.setText(Integer.toString(drawGraphPanel.getGraph().getListLienOfType(Lien.Type.AUTOROUTE).size()));

            //Selected
            Noeud selected = drawGraphPanel.getSelectedNodes()[0];
            if (selected != null) {
                nameSelectedLabel.setText(selected.getNom());
                typeSelectedLabel.setText(selected.getTypeLieu().toString());
                ouvertureSelectedLabel.setText(String.valueOf(selected.getListLien().size()));
            } else {
                nameSelectedLabel.setText("null");
                typeSelectedLabel.setText("null");
                ouvertureSelectedLabel.setText("null");
            }
        }
    }

    public void switchToMode(ViewMode mode) {
        this.currMode = mode;
        if (leftPanel.getLayout() instanceof CardLayout) {
            CardLayout crd = (CardLayout) leftPanel.getLayout();
            crd.show(leftPanel, this.currMode.toString());
            drawGraphPanel.setNbrSelectableNode(currMode.getNbrSelectableNode());
        }
    }
}
