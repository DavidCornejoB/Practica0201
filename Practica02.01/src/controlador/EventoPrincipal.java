package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import vista.VentanaModificar;
import vista.VentanaCrearCarpeta;
import vista.VentanaCrearDirectorio;
import vista.VentanaEliminar;
import vista.VentanaPrincipal;
import vista.VentanaTree;

public class EventoPrincipal implements ActionListener{
    
    private VentanaPrincipal ventana;

    public EventoPrincipal(VentanaPrincipal ventana) {
        this.ventana = ventana;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource().equals(this.ventana.getMenuItemList().get(0))){
            VentanaCrearDirectorio ventana=new VentanaCrearDirectorio("Crear directorio");
            ventana.setVisible(true);
            this.ventana.getDesktop().add(ventana);
        }
        if(e.getSource().equals(this.ventana.getMenuItemList().get(1))){
            VentanaCrearCarpeta ventana=new VentanaCrearCarpeta("Carpeta - Archivo");
            ventana.setVisible(true);
            this.ventana.getDesktop().add(ventana);
        }
        if(e.getSource().equals(this.ventana.getMenuItemList().get(2))){
            VentanaModificar ventana=new VentanaModificar("Crear archivo");
            ventana.setVisible(true);
            this.ventana.getDesktop().add(ventana);
        }
        if(e.getSource().equals(this.ventana.getMenuItemList().get(4))){
            VentanaTree ventana=new VentanaTree("Ventana Directorio");
            ventana.setVisible(true);
            this.ventana.getDesktop().add(ventana);
        }
        if(e.getSource().equals(this.ventana.getMenuItemList().get(3))){
            VentanaEliminar ventana=new VentanaEliminar("Eliminar");
            ventana.setVisible(true);
            this.ventana.getDesktop().add(ventana);
        }
    }
    
    
}
