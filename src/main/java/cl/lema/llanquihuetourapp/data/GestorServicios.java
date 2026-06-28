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
 * Clase encargada de gestionar los datos de los tours.*
 * Esta clase lee la información desde un archivo de texto, crea objetos de tipo y permite obtener la lista completa o una lista filtrada por tipo.
 *
 * @author Iván Lema
 * @version 1.0
 */
public class GestorServicios {
    /**
     * Ruta del archivo de texto donde están guardados los tours.
     */
    private static final String FILE_TOURS = "src/main/resources/tours.txt";
    ArrayList<ServicioTuristico> listaDeServicioTuristicos = new ArrayList<>();
    /**
     * Genera una lista de tours leyendo los datos desde el archivo de texto.*
     * Cada línea del archivo debe tener el siguiente formato:
     * nombre; tipo; precio
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
     * Devuelve la lista completa de tours generada desde el archivo de texto.
     *
     * @return una lista con todos los tours leídos desde el archivo.
     */
    public ArrayList<ServicioTuristico> obtenerLista(){
        if(listaDeServicioTuristicos.isEmpty()){
            cargarTours();
        }
        return cargarTours();
    }
    /**
     * Filtra los tours según una palabra recibida como parámetro.
     * El filtro se realiza comparando la palabra con el tipo de cada tour.
     * Si el tipo del tour contiene la palabra buscada, se agrega a una nueva lista.
     *
     * @param palabraFiltro palabra que se usará para filtrar por tipo de tour.
     * @return una lista con los tours que coinciden con el filtro indicado.
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
     * Muestra por consola los tours filtrados según la palabra recibida.
     *
     * @param palabra palabra que se usará para filtrar los tours antes de mostrarlos.
     */
    public void mostrarFiltro(String palabra){
        if (palabra != null && !palabra.isBlank()) {
            System.out.println(filtrarPorTipo(palabra));
        } else {
            System.out.println("Debe ingresar una palabra válida");
        }
    }
    /**
     * Método para creación de servicios de ejemplos requeridos en la tarea de la semana 6.
     *
     * @return lista de servicios creados para ser llamados desde Main
     */
    public ArrayList<ServicioTuristico> crearServicio(){
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
