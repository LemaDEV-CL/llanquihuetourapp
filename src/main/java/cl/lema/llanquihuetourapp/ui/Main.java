package cl.lema.llanquihuetourapp.ui;

import cl.lema.llanquihuetourapp.data.GestorServicios;
import cl.lema.llanquihuetourapp.gui.Grafica;
import javax.swing.*;

/**
 * Clase principal de Llanquihue Tour.
 * Inicia la interfaz gráfica utilizando Swing.
 *
 * @author Iván Lema
 * @version 1.0
 */
public class Main {

    /**
     * Inicia la aplicación creando la ventana.
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
