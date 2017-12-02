package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import javax.swing.JOptionPane;
import vista.VentanaCrearCarpeta;

public class CrearCarpeta implements ActionListener {

    VentanaCrearCarpeta ventana;

    public CrearCarpeta(VentanaCrearCarpeta ventana) {
        this.ventana = ventana;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(this.ventana.getButtonList().get(0)) && !this.ventana.getCheckList().get(0).isSelected()) {
            if (this.ventana.getComboBox2().getItemCount() != 0) {

                String direc = cambiarDir1();
                File directorio = new File(direc + "/" + this.ventana.getTextList().get(0).getText());
                if (!directorio.exists()) {
                    directorio.mkdir();
                    JOptionPane.showMessageDialog(this.ventana, "Carpeta creada", "Success", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(this.ventana, "Carpeta ya Existente", "Error", JOptionPane.ERROR_MESSAGE);
                }
            } else {
                String direc = cambiarDir();
                File directorio = new File(direc + "/" + this.ventana.getTextList().get(0).getText());
                if (!directorio.exists()) {
                    directorio.mkdir();
                    JOptionPane.showMessageDialog(this.ventana, "Carpeta creada", "Success", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(this.ventana, "Carpeta ya Existente", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }

        }

        if (e.getSource().equals(this.ventana.getButtonList().get(0)) && this.ventana.getCheckList().get(0).isSelected()) {
            String direc = cambiarDir();
            File directorio = new File(direc + "/" + this.ventana.getTextList().get(0).getText());
            if (!directorio.exists()) {
                directorio.mkdir();
                JOptionPane.showMessageDialog(this.ventana, "Carpeta creada", "Success", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(this.ventana, "Carpeta ya Existente", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }

        if (e.getSource().equals(this.ventana.getButtonList().get(1)) && !this.ventana.getCheckList().get(0).isSelected()) {
            String nombArchivo = this.ventana.getTextList().get(0).getText();
            String direc = cambiarDir1();
            File archivo = new File(direc + "/" + nombArchivo);
            if (!archivo.exists()) {
                try {
                    archivo.createNewFile();
                    JOptionPane.showMessageDialog(this.ventana, "Archivo creado", "Success", JOptionPane.INFORMATION_MESSAGE);
                } catch (IOException ex) {
                    System.out.println("Error al crear el archivo");
                }
            } else {
                JOptionPane.showMessageDialog(this.ventana, "Archivo Existente", "Error", JOptionPane.INFORMATION_MESSAGE);
            }

        }
        if (e.getSource().equals(this.ventana.getButtonList().get(1)) && this.ventana.getCheckList().get(0).isSelected()) {
            String nombArchivo = this.ventana.getTextList().get(0).getText();
            String direc = cambiarDir();
            File archivo = new File(direc + "/" + nombArchivo);

            if (!archivo.exists()) {
                try {
                    archivo.createNewFile();
                    JOptionPane.showMessageDialog(this.ventana, "Archivo creado", "Success", JOptionPane.INFORMATION_MESSAGE);
                } catch (IOException ex) {
                    System.out.println("Error al crear el archivo");
                }
            } else {
                JOptionPane.showMessageDialog(this.ventana, "Archivo Existente", "Error", JOptionPane.ERROR_MESSAGE);
            }
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
        String combo1 = "";
        combo1 = this.ventana.getComboBox2().getSelectedItem().toString();
        combo1 = combo1.replace(File.separator, "/");
        return combo1;
    }

}
