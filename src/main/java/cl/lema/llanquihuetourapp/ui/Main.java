package cl.lema.llanquihuetourapp.ui;

import cl.lema.llanquihuetourapp.data.GestorDatos;
import cl.lema.llanquihuetourapp.model.Operador;
import cl.lema.llanquihuetourapp.model.Tour;
import java.util.ArrayList;
import java.util.List;

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
     * <p>
     * Crea un objeto de tipo gestorDatos, muestra todos los tours leídos
     * desde el archivo y luego muestra los tours filtrados por tipo.
     *
     * Agrega operadores a los Tours para asignar a los proveedores disponibles para cada servicio y
     * luego muestra un ejemplo en consola
     */
    public static void main(String[] args) {

        GestorDatos gestor = new GestorDatos();
        String palabraFiltro = "Gastronómico";
        List<Tour> tours = gestor.cargarTours();

        System.out.println("::: Servicios :::");
        System.out.println(tours);

        System.out.println();
        System.out.println("::: Servicios filtrado por tipo " + "'" + palabraFiltro + "' " + ":::");
        gestor.mostrarFiltro(palabraFiltro);

        Operador opTransporte1 = new Operador("TransChile", "Transporte", "Santo Domingo 18", "Providencia", "Santiago");
        Operador opComida1 = new Operador("Parrillada", "Alimentación", "Antonio Marchant 111", "Cerro Navia", "Santiago");
        Operador opGuia1 = new Operador("Andrés Mora", "Guia", "Cruz del sur 1924", "Las Condes", "Santiago");

        tours.get(0).agregarOperador(opTransporte1);
        tours.get(0).agregarOperador(opGuia1);
        tours.get(15).agregarOperador(opComida1);
        System.out.println(tours.get(0).getOperadores());
        System.out.println(tours.get(15).getNombre());
    }
}

