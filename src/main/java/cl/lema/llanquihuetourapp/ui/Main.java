package cl.lema.llanquihuetourapp.ui;

import cl.lema.llanquihuetourapp.data.GestorDatos;
import cl.lema.llanquihuetourapp.model.Tour;
/**
 * Clase principal del programa.
 *
 * Desde esta clase se ejecuta la aplicación, se obtiene la lista de tours desde y se muestran los resultados por consola.
 *
 * @author Iván Lema
 * @version 1.0
 */
public class Main {

    /**
     * Método principal que inicia la ejecución del programa.
     *
     * Crea un objeto de tipo gestorDatos, muestra todos los tours leídos
     * desde el archivo y luego muestra los tours filtrados por tipo.
     */
    public static void main (String[] args){

        GestorDatos gestor = new GestorDatos();
        String palabraFiltro = "Gastronómico";

        System.out.println("::: Servicios :::");
        for (Tour tours : gestor.obtenerLista()){
            System.out.println(tours.toString());

        }

        System.out.println();
        System.out.println("::: Servicios filtrado por tipo " + palabraFiltro + ":::");
        gestor.mostrarFiltro(palabraFiltro);


    }
}
