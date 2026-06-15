package cl.lema.llanquihuetourapp.data;

import cl.lema.llanquihuetourapp.model.Tour;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
/**
 * Clase encargada de gestionar los datos de los tours.
 *
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

    /**
     * Genera una lista de tours leyendo los datos desde el archivo de texto.
     *
     * Cada línea del archivo debe tener el siguiente formato:
     * nombre;tipo;precio
     */

    public ArrayList<Tour> leerTours(){

        ArrayList<Tour> listaDeTours = new ArrayList<>();

        try(BufferedReader br = new BufferedReader(new FileReader(FILE_TOURS))){

            String linea;

            while ((linea = br.readLine()) != null) {

                String[] partes = linea.split(";");
                String nombre = partes[0];
                String tipo = partes[1];
                Double precio = Double.parseDouble(partes[2]);

                Tour tour = new Tour(nombre, tipo, precio);
                listaDeTours.add(tour);

            }
            return listaDeTours;

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
    /**
     * Filtra los tours según una palabra recibida como parámetro.
     *
     * El filtro se realiza comparando la palabra con el tipo de cada tour.
     * Si el tipo del tour contiene la palabra buscada, se agrega a una nueva lista.
     *
     * @param palabraFiltro palabra que se usará para filtrar por tipo de tour.
     * @return una lista con los tours que coinciden con el filtro indicado.
     */
    public ArrayList<Tour> filtrarPorTipo(String palabraFiltro){
        ArrayList<Tour> listaFiltrada = new ArrayList<>();
        obtenerLista();
        for (Tour tour : leerTours()){
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
        System.out.println(filtrarPorTipo(palabra));
    }
    /**
     * Devuelve la lista completa de tours generada desde el archivo de texto.
     *
     * @return una lista con todos los tours leídos desde el archivo.
     */
    public ArrayList<Tour> obtenerLista(){
        return leerTours();
    }
}