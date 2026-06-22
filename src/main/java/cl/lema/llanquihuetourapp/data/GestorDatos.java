package cl.lema.llanquihuetourapp.data;

import cl.lema.llanquihuetourapp.model.Tour;
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
public class GestorDatos {
    /**
     * Ruta del archivo de texto donde están guardados los tours.
     */
    private static final String FILE_TOURS = "src/main/resources/tours.txt";
    ArrayList<Tour> listaDeTours = new ArrayList<>();
    /**
     * Genera una lista de tours leyendo los datos desde el archivo de texto.*
     * Cada línea del archivo debe tener el siguiente formato:
     * nombre; tipo; precio
     */
    public ArrayList<Tour> cargarTours(){
        listaDeTours.clear();
        try(BufferedReader br = new BufferedReader(new FileReader(FILE_TOURS))){
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] partes = linea.split(";");
                if(partes.length == 3){
                    Tour tour = new Tour(
                            partes[0],
                            partes[1],
                            Double.parseDouble(partes[2])
                    );
                    listaDeTours.add(tour);
                }
            }
        } catch (IOException e) {
            System.out.println("Error al leer la lista de tours: " + e.getMessage());
        }
        return listaDeTours;
    }
    /**
     * Devuelve la lista completa de tours generada desde el archivo de texto.
     *
     * @return una lista con todos los tours leídos desde el archivo.
     */
    public ArrayList<Tour> obtenerLista(){
        if(listaDeTours.isEmpty()){
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
    private ArrayList<Tour> filtrarPorTipo(String palabraFiltro){
        ArrayList<Tour> listaFiltrada = new ArrayList<>();
        for (Tour tour : obtenerLista()){
            if(tour.getTipo().contains(palabraFiltro)){
                listaFiltrada.add(tour);
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

}