package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import javax.swing.JOptionPane;
import vista.VentanaEliminar;

public class Eliminar implements ActionListener {

    private VentanaEliminar ventana;

    public Eliminar(VentanaEliminar ventana) {
        this.ventana = ventana;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(this.ventana.getButtonList().get(0)) && !this.ventana.getCheckList().get(0).isSelected()) {
            if (this.ventana.getComboBox2().getItemCount() != 0) {
                String direc = cambiarDir1();
                File directorio = new File(direc);
                directorio.delete();
                JOptionPane.showMessageDialog(this.ventana, "Eliminado", "Success", JOptionPane.INFORMATION_MESSAGE);
            } else {
                String direc = cambiarDir();
                File directorio = new File(direc);
                directorio.delete();
                JOptionPane.showMessageDialog(this.ventana, "Eliminado", "Success", JOptionPane.INFORMATION_MESSAGE);
            }
        }
        if (e.getSource().equals(this.ventana.getButtonList().get(0)) && this.ventana.getCheckList().get(0).isSelected()) {
            String direc = cambiarDir();
            File directorio = new File(direc);
            directorio.delete();
            JOptionPane.showMessageDialog(this.ventana, "Eliminado", "Success", JOptionPane.INFORMATION_MESSAGE);
        }

        if (e.getSource().equals(this.ventana.getComboBox())) {
            String unidad = nombreUnidad();
            this.ventana.cargaCombo1(unidad);
        }

        if (e.getSource().equals(this.ventana.getComboBox1())) {
            File carpeta = new File(cambiarDir());
            this.ventana.Mostrar(carpeta);
        }
    }

    public String nombreUnidad() {
        String unidad = "";
        String combo = this.ventana.getComboBox().getSelectedItem().toString();
        for (int i = 0; i < combo.length(); i++) {
            if (combo.charAt(i) == '(') {
                unidad = String.valueOf(combo.charAt(i + 1));
            }
        }
        return unidad;
    }

    public String cambiarDir() {
        String combo1 = this.ventana.getComboBox1().getSelectedItem().toString();
        combo1 = combo1.replace(File.separator, "/");
        return combo1;
    }

    public String cambiarDir1() {
        String combo1 = this.ventana.getComboBox2().getSelectedItem().toString();
        combo1 = combo1.replace(File.separator, "/");
        return combo1;
    }
}
