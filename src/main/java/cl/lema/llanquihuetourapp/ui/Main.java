package cl.lema.llanquihuetourapp.ui;

import cl.lema.llanquihuetourapp.data.GestorServicios;
import cl.lema.llanquihuetourapp.model.Operador;
import cl.lema.llanquihuetourapp.model.ServicioTuristico;
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
         */
        GestorServicios gestor = new GestorServicios();
        ServicioTuristico servicio = new ServicioTuristico();
        String palabraFiltro = "Gastronómico";
        List<ServicioTuristico> listaCargada = gestor.cargarTours(); // Carga los servicios del archivo tours.txt

        /**
         * Crea la lista de servicios turisticos recibidos desde el método crearServicio de la clase gestorServicios
         * y agrega operadores a los disntos serviciso turisticos.
         * Depues muestra en consola la lista de servicios con el método `mostrarInformacion()` sobreescrito para cada subclase.
         * Crea operadores de la clase Operador para los ejemplos del ejercicio.
         */
        List<ServicioTuristico> servicios = gestor.crearServicios();
        Operador opTransporte1 = new Operador("TransChile", "Transporte", "Santo Domingo 18", "Providencia", "Santiago");
        Operador opComida1 = new Operador("Parrillada", "Alimentación", "Antonio Marchant 111", "Cerro Navia", "Santiago");
        Operador opGuia1 = new Operador("Andrés Mora", "Guia", "Cruz del sur 1924", "Las Condes", "Santiago");
        servicios.get(0).agregarOperador(opTransporte1);
        servicios.get(0).agregarOperador(opGuia1);
        servicios.get(1).agregarOperador(opComida1);
        servicios.get(2).agregarOperador(opGuia1);
        servicios.get(3).agregarOperador(opTransporte1);
        servicios.get(4).agregarOperador(opGuia1);
        servicios.get(4).agregarOperador(opComida1);
        servicios.get(5).agregarOperador(opGuia1);

        for  (ServicioTuristico servicioTuristico : servicios) {
            servicioTuristico.mostrarInformacion();
            System.out.println();
        }
    }
}

