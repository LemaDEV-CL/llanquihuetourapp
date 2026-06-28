package cl.lema.llanquihuetourapp.ui;

import cl.lema.llanquihuetourapp.data.GestorServicios;
import cl.lema.llanquihuetourapp.model.Operador;
import cl.lema.llanquihuetourapp.model.RutaGastronomica;
import cl.lema.llanquihuetourapp.model.ServicioTuristico;

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
     */
    public static void main(String[] args) {
        /**
         * Crea objetos de tipo GestorServicios y ServicioTuristico para el uso de atributos.
         * Crea una variable @param palabraFiltro para asignar la palabra que se usa en el método de filtrados de servicios por tipo.
         * Crea lista de servicios turisticos del archivo tours.txt
         * Crea operadores de la clase Operador para los ejemplos del ejercicio
         */
        GestorServicios gestor = new GestorServicios();
        ServicioTuristico servicio = new ServicioTuristico();
        String palabraFiltro = "Gastronómico";
        List<ServicioTuristico> serviciosTuristicos = gestor.cargarTours(); // Carga los servicios del archivo tours.txt
        Operador opTransporte1 = new Operador("TransChile", "Transporte", "Santo Domingo 18", "Providencia", "Santiago");
        Operador opComida1 = new Operador("Parrillada", "Alimentación", "Antonio Marchant 111", "Cerro Navia", "Santiago");
        Operador opGuia1 = new Operador("Andrés Mora", "Guia", "Cruz del sur 1924", "Las Condes", "Santiago");

        /**
         * Crea la lista de servicios turisticos recibidos desde el método crearServicio de la clase gestorServicios
         * y agrega operadores a los disntos serviciso turisticos.
         * Depues muestra en consola la lista de servicios.
         */
        ArrayList<ServicioTuristico> listaServicio = gestor.crearServicio();
        listaServicio.get(0).agregarOperador(opTransporte1);
        listaServicio.get(1).agregarOperador(opComida1);
        listaServicio.get(2).agregarOperador(opGuia1);
        listaServicio.get(3).agregarOperador(opTransporte1);
        listaServicio.get(4).agregarOperador(opGuia1);
        listaServicio.get(5).agregarOperador(opGuia1);

        System.out.println(listaServicio);

        //        /**
//         * Muestra todos los tours leídos desde el archivo y luego muestra los tours filtrados por tipo.
//         *
//         * Agrega operadores a los Tours para asignar a los proveedores disponibles para cada servicio y
//         * luego muestra un ejemplo en consola
//         */
//        System.out.println("::: Servicios :::");
//        System.out.println(serviciosTuristicos);
//
//        System.out.println();
//        System.out.println("::: Servicios filtrado por tipo " + "'" + palabraFiltro + "' " + ":::");
//        gestor.mostrarFiltro(palabraFiltro);
//
//        serviciosTuristicos.get(0).agregarOperador(opTransporte1);
//        serviciosTuristicos.get(0).agregarOperador(opGuia1);
//        serviciosTuristicos.get(15).agregarOperador(opComida1);
//        System.out.println(serviciosTuristicos.get(0).getOperadores());
//        System.out.println(serviciosTuristicos.get(15));
    }
}

