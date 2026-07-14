package cl.lema.llanquihuetourapp.ui;

import cl.lema.llanquihuetourapp.data.GestorEntidades;
import cl.lema.llanquihuetourapp.data.GestorServicios;
import cl.lema.llanquihuetourapp.gui.Grafica;
import cl.lema.llanquihuetourapp.model.ServicioTuristico;

import javax.swing.*;
import java.awt.*;
import java.util.List;

/**
 * Clase principal de Llanquihue Tour.
 * Inicia la interfaz gráfica utilizando Swing.
 *
 * @author Iván Lema
 * @version 1.0
 */
public class Main {

    /**
     * Inicia la aplicación, crea la ventana, la centra y la hace visible.
     *
     */
    public static void main(String[] args) {

        SwingUtilities.invokeLater(() -> {
            Grafica panta = new Grafica();
            panta.setLocationRelativeTo(null);
            panta.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            panta.setVisible(true);
        });
    }
}
