package vista;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.io.File;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;

public class VentanaTree extends JInternalFrame {

    private JPanel panel;
    private DefaultTreeModel modeloTree;
    private File ruta;
    private DefaultMutableTreeNode nodo;
    private DefaultMutableTreeNode hijo;
    private JTree arbol;
    private JScrollPane scroll;

    public VentanaTree(String title) {
        super(title, true, true, true, true);
        this.setSize(500, 500);
        String ruta = (String) JOptionPane.showInputDialog(null, "Directorio", "Escoger Directorio", JOptionPane.QUESTION_MESSAGE);
        this.ruta = new File(ruta);
        this.iniciaComponente();
    }

    public void iniciaComponente() {

        this.panel = new JPanel(new BorderLayout());
        JPanel panelNorte = new JPanel(new GridLayout(3, 2));

        if (!ruta.exists()) {
            ruta.mkdirs();
            JOptionPane.showMessageDialog(null, "Raiz Creado", "Inicio Raiz", JOptionPane.INFORMATION_MESSAGE);
        }
        this.nodo = new DefaultMutableTreeNode(ruta.getName());
        this.modeloTree = new DefaultTreeModel(nodo);
        this.cargarArbol(ruta.listFiles(), 0, this.nodo);
        this.arbol = new JTree(modeloTree);
        this.scroll = new JScrollPane(this.arbol);

        this.panel.add(panelNorte, BorderLayout.NORTH);
        this.panel.add(this.scroll, BorderLayout.CENTER);

        this.add(this.panel);

        this.panel.add(panelNorte, BorderLayout.NORTH);
        this.panel.add(this.scroll, BorderLayout.CENTER);
        this.add(this.panel);
    }

    public void cargarArbol(File[] lista, int i, DefaultMutableTreeNode nodoAux) {

        for (File a : lista) {
            System.out.println("" + a.getPath());
            this.hijo = new DefaultMutableTreeNode(a.getName());
            this.modeloTree.insertNodeInto(hijo, nodoAux, i);
            if (a.isDirectory()) {
                cargarArbol(a.listFiles(), 0, hijo);
            }
            i++;
        }

    }

    public DefaultTreeModel getModeloTree() {
        return modeloTree;
    }

    public void setModeloTree(DefaultTreeModel modeloTree) {
        this.modeloTree = modeloTree;
    }

    public JPanel getPanel() {
        return panel;
    }

    public void setPanel(JPanel panel) {
        this.panel = panel;
    }

    public File getRuta() {
        return ruta;
    }

    public void setRuta(File ruta) {
        this.ruta = ruta;
    }

    public DefaultMutableTreeNode getNodo() {
        return nodo;
    }

    public void setNodo(DefaultMutableTreeNode nodo) {
        this.nodo = nodo;
    }

    public DefaultMutableTreeNode getHijo() {
        return hijo;
    }

    public void setHijo(DefaultMutableTreeNode hijo) {
        this.hijo = hijo;
    }

    public JTree getArbol() {
        return arbol;
    }

    public void setArbol(JTree arbol) {
        this.arbol = arbol;
    }

    public JScrollPane getScroll() {
        return scroll;
    }

    public void setScroll(JScrollPane scroll) {
        this.scroll = scroll;
    }

}
