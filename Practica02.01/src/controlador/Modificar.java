package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import javax.swing.JOptionPane;
import vista.VentanaModificar;

public class Modificar implements ActionListener {

    private VentanaModificar ventana;

    public Modificar(VentanaModificar ventana) {
        this.ventana = ventana;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(this.ventana.getButtonList().get(0)) && !this.ventana.getCheckList().get(0).isSelected()) {
            if (this.ventana.getComboBox2().getItemCount() != 0) {
                String nomb = this.ventana.getTextList().get(0).getText();
                String direc = cambiarDir1();
                File nuevoDirectorio = new File(direc + nomb);
                File directorio = new File(direc);
                directorio.renameTo(nuevoDirectorio);
                JOptionPane.showMessageDialog(this.ventana, "Modificado", "Success", JOptionPane.INFORMATION_MESSAGE);
            } else {
                String nomb = this.ventana.getTextList().get(0).getText();
                String direc = cambiarDir();
                File nuevoDirectorio = new File(direc + nomb);
                File directorio = new File(direc);
                directorio.renameTo(nuevoDirectorio);
                JOptionPane.showMessageDialog(this.ventana, "Modificado", "Success", JOptionPane.INFORMATION_MESSAGE);
            }
        }
        if (e.getSource().equals(this.ventana.getButtonList().get(0)) && this.ventana.getCheckList().get(0).isSelected()) {
                String nombre = this.ventana.getTextList().get(0).getText();
                String direc = cambiarDir();
                File nuevoDirectorio = new File(direc + nombre);
                File directorio = new File(direc);
                directorio.renameTo(nuevoDirectorio);
                JOptionPane.showMessageDialog(this.ventana, "Modificado", "Success", JOptionPane.INFORMATION_MESSAGE);
        }

        if (e.getSource().equals(this.ventana.getComboBox())) {
            String unidad = nombreUnidad();
            this.ventana.cargaCombo1(unidad);
        }

        if (e.getSource().equals(this.ventana.getComboBox1())) {
            File carpeta = new File(cambiarDir());
            System.out.println(cambiarDir());
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

