package cl.lema.llanquihuetourapp.data;

import cl.lema.llanquihuetourapp.model.ExcursionCultural;
import cl.lema.llanquihuetourapp.model.PaseoLacustre;
import cl.lema.llanquihuetourapp.model.RutaGastronomica;
import cl.lema.llanquihuetourapp.model.ServicioTuristico;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Gestiona los servicios turísticos utilizados en las etapas anteriores del proyecto.
 * Lee tours desde un archivo, permite filtrarlos y también crea servicios de ejemplo.
 *
 * @author Iván Lema
 * @version 1.0
 */
public class GestorServicios {

    /** Ruta del archivo donde se encuentran los tours. */
    private static final String FILE_TOURS = "src/main/resources/tours.txt";

    /** Lista que almacena los servicios turísticos cargados. */
    ArrayList<ServicioTuristico> listaDeServicioTuristicos = new ArrayList<>();

    /**
     * Carga los tours desde el archivo de texto.
     * Cada línea válida debe contener nombre, duración, tipo y precio separados por punto y coma.
     *
     * @return lista de servicios turísticos cargados desde el archivo.
     */
    public ArrayList<ServicioTuristico> cargarTours(){
        listaDeServicioTuristicos.clear();
        try(BufferedReader br = new BufferedReader(new FileReader(FILE_TOURS))){
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] partes = linea.split(";");
                if(partes.length == 4){
                    ServicioTuristico servicioTuristico = new ServicioTuristico(
                            partes[0],
                            Integer.parseInt(partes[1]),
                            partes[2],
                            Double.parseDouble(partes[3])
                    );
                    listaDeServicioTuristicos.add(servicioTuristico);
                }
            }
        } catch (IOException e) {
            System.out.println("Error al leer la lista de tours: " + e.getMessage());
        }
        return listaDeServicioTuristicos;
    }

    /**
     * Obtiene la lista completa de tours. Si está vacía, primero intenta cargarla.
     *
     * @return lista completa de servicios turísticos.
     */
    public ArrayList<ServicioTuristico> obtenerLista(){
        if(listaDeServicioTuristicos.isEmpty()){
            cargarTours();
        }
        return listaDeServicioTuristicos;
    }

    /**
     * Filtra los tours comparando la palabra recibida con su tipo.
     *
     * @param palabraFiltro texto utilizado para filtrar los servicios.
     * @return lista con los tours que coinciden con el filtro.
     */
    private ArrayList<ServicioTuristico> filtrarPorTipo(String palabraFiltro){
        ArrayList<ServicioTuristico> listaFiltrada = new ArrayList<>();
        for (ServicioTuristico servicioTuristico : obtenerLista()){
            if(servicioTuristico.getTipo().contains(palabraFiltro)){
                listaFiltrada.add(servicioTuristico);
            }
        }
        return listaFiltrada;
    }

    /**
     * Muestra por consola los tours que coinciden con una palabra de búsqueda.
     *
     * @param palabra texto utilizado para filtrar los tours.
     */
    public void mostrarFiltro(String palabra){
        if (palabra != null && !palabra.isBlank()) {
            System.out.println(filtrarPorTipo(palabra));
        } else {
            System.out.println("Debe ingresar una palabra válida");
        }
    }

    /**
     * Crea servicios de ejemplo para demostrar herencia y polimorfismo.
     *
     * @return lista con rutas gastronómicas, paseos lacustres y excursiones culturales.
     */
    public ArrayList<ServicioTuristico> crearServicios(){
        ArrayList<ServicioTuristico> servicios = new ArrayList<>();
        RutaGastronomica rutaEmpanada = new RutaGastronomica("Ruta de la empanada", 8, "Gastronómico", 48000, 3);
        RutaGastronomica rutaDelMar = new RutaGastronomica("Ruta del mar", 8, "Gastronómico", 60000, 2);
        PaseoLacustre paseoPtoVaras = new PaseoLacustre("Paseo por Lago Llanquihue", 16, "Lacustre", 55000, "Catamaran");
        PaseoLacustre paseoBariloche = new PaseoLacustre("Paseo por Bariloche", 24, "Lacustre", 72000, "Lancha");
        ExcursionCultural precolombino = new ExcursionCultural("City tour + museo", 4, "Walking tour", 35000, "Museo Precolombino");
        ExcursionCultural parqueMET = new ExcursionCultural("Parque Metropolitano", 2, "Walking tour", 40000, "Funicular + teleférico");
        servicios.add(rutaEmpanada);
        servicios.add(rutaDelMar);
        servicios.add(paseoPtoVaras);
        servicios.add(paseoBariloche);
        servicios.add(precolombino);
        servicios.add(parqueMET);
        return servicios;
    }

}
