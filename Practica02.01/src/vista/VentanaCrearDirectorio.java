package vista;

import controlador.CrearDirectorio;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import javax.swing.*;
import javax.swing.filechooser.FileSystemView;

public class VentanaCrearDirectorio extends JInternalFrame {

    private List<JTextField> textList;
    private List<JButton> buttonList;
    private List<JLabel> labelList;
    private File[] units;
    private JComboBox comboBox;
    private Object[] items;
    private CrearDirectorio c;

    public VentanaCrearDirectorio(String title) {
        super(title, true, true, true, true);
        this.setSize(440, 160);
        this.setLocation(100, 50);
        this.initComponents();
    }

    public void initComponents() {
        this.textList = new ArrayList<JTextField>();
        this.labelList = new ArrayList<JLabel>();
        this.buttonList = new ArrayList<JButton>();
        this.comboBox = new JComboBox();

        this.labelList.add(new JLabel("Unidad de Almacenamiento: "));
        this.labelList.add(new JLabel("Nombre del directorio: "));

        this.textList.add(new JTextField(10));

        this.buttonList.add(new JButton("Crear directorio"));
        this.buttonList.add(new JButton("Actualizar Unidades"));
        
        for(int i=0;i<this.buttonList.size();i++){
            this.buttonList.get(i).addActionListener(new CrearDirectorio(this));
        }

        JPanel panelPrincipal = new JPanel(new BorderLayout());
        JPanel panelNorte = new JPanel(new GridLayout(2, 2));
        JPanel panelSur=new JPanel(new FlowLayout());
        this.cargaCombo();
        
        panelNorte.add(this.labelList.get(0));
        panelNorte.add(this.comboBox);
        panelNorte.add(this.labelList.get(1));
        panelNorte.add(this.textList.get(0));
        panelSur.add(this.buttonList.get(0));
        panelSur.add(this.buttonList.get(1));

        panelPrincipal.add(panelNorte, BorderLayout.NORTH);
        panelPrincipal.add(panelSur,BorderLayout.SOUTH);
        
        this.add(panelPrincipal);
    }

    public void cargaCombo() {
        this.comboBox.removeAllItems();
        this.units = File.listRoots();
        for (File f : units) {
            String elemento = FileSystemView.getFileSystemView().getSystemDisplayName(f);//Obtiene el nombre de la unidad
            if (!elemento.isEmpty()) //No admite elementos vacios
            {
                this.comboBox.addItem(elemento);
            }
        }  
    }

    public List<JTextField> getTextList() {
        return textList;
    }

    public void setTextList(List<JTextField> textList) {
        this.textList = textList;
    }

    public List<JButton> getButtonList() {
        return buttonList;
    }

    public void setButtonList(List<JButton> buttonList) {
        this.buttonList = buttonList;
    }

    public List<JLabel> getLabelList() {
        return labelList;
    }

    public void setLabelList(List<JLabel> labelList) {
        this.labelList = labelList;
    }

    public File[] getUnits() {
        return units;
    }

    public void setUnits(File[] units) {
        this.units = units;
    }

    public JComboBox getComboBox() {
        return comboBox;
    }

    public void setComboBox(JComboBox comboBox) {
        this.comboBox = comboBox;
    }

    public Object[] getItems() {
        return items;
    }

    public void setItems(Object[] items) {
        this.items = items;
    }

    public CrearDirectorio getC() {
        return c;
    }

    public void setC(CrearDirectorio c) {
        this.c = c;
    }
    
}
