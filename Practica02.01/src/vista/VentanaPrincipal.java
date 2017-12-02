package vista;

import controlador.EventoPrincipal;
import java.util.ArrayList;
import java.util.List;
import javax.swing.*;

public class VentanaPrincipal extends JFrame {

    private JMenuBar barraMenu;
    private List<JMenu> menuList;
    private List<JMenuItem> menuItemList;
    private JDesktopPane desktop;
 
    public VentanaPrincipal(String title) {
        super(title);
        this.setSize(500, 500);
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.initComponents();
        this.setVisible(true);
    }

    public void initComponents() {
        this.desktop = new JDesktopPane();
        this.barraMenu = new JMenuBar();
        this.menuList = new ArrayList<JMenu>();
        this.menuItemList = new ArrayList<JMenuItem>();

        this.setContentPane(this.desktop);
        this.menuList.add(new JMenu("Crear"));
        this.menuList.add(new JMenu("Modificar"));
        this.menuList.add(new JMenu("Eliminar"));
        this.menuList.add(new JMenu("Directorio"));

        this.menuItemList.add(new JMenuItem("Crear directorio"));
        this.menuItemList.add(new JMenuItem("Carpeta - Archivo"));
        this.menuItemList.add(new JMenuItem("Modificar"));
        this.menuItemList.add(new JMenuItem("Eliminar"));
        this.menuItemList.add(new JMenuItem("Mostrar directorio"));
        
        for (int i = 0; i < this.menuItemList.size(); i++) {
            this.menuItemList.get(i).addActionListener(new EventoPrincipal(this));
        }

        this.menuList.get(0).add(this.menuItemList.get(0));
        this.menuList.get(0).add(this.menuItemList.get(1));
        
        this.menuList.get(1).add(this.menuItemList.get(2));
        
        this.menuList.get(2).add(this.menuItemList.get(3));
        
        this.menuList.get(3).add(this.menuItemList.get(4));

        this.barraMenu.add(this.menuList.get(0));
        this.barraMenu.add(this.menuList.get(1));
        this.barraMenu.add(this.menuList.get(2));
        this.barraMenu.add(this.menuList.get(3));

        this.setJMenuBar(barraMenu);
    }

    public JMenuBar getBarraMenu() {
        return barraMenu;
    }

    public void setBarraMenu(JMenuBar barraMenu) {
        this.barraMenu = barraMenu;
    }

    public List<JMenu> getMenuList() {
        return menuList;
    }

    public void setMenuList(List<JMenu> menuList) {
        this.menuList = menuList;
    }

    public List<JMenuItem> getMenuItemList() {
        return menuItemList;
    }

    public void setMenuItemList(List<JMenuItem> menuItemList) {
        this.menuItemList = menuItemList;
    }

    public JDesktopPane getDesktop() {
        return desktop;
    }

    public void setDesktop(JDesktopPane desktop) {
        this.desktop = desktop;
    }

}
