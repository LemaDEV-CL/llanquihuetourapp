package cl.lema.llanquihuetourapp.data;

import cl.lema.llanquihuetourapp.excepciones.DatoInvalidoException;
import cl.lema.llanquihuetourapp.model.servicios.ExcursionCultural;
import cl.lema.llanquihuetourapp.model.servicios.PaseoLacustre;
import cl.lema.llanquihuetourapp.model.servicios.RutaGastronomica;
import cl.lema.llanquihuetourapp.model.servicios.ServicioTuristico;

import java.io.*;
import java.util.ArrayList;

/**
 * Gestiona los servicios turísticos utilizados en las etapas anteriores del proyecto.
 * Lee tours desde un archivo, permite filtrarlos y también crea servicios de ejemplo.
 *
 * @author Iván Lema
 * @version 1.0
 */
public class GestorServicios {

    /** Lista que almacena los servicios turísticos cargados. */
    private final ArrayList<ServicioTuristico> listaDeServiciosTuristicos = new ArrayList<>();

    /**
     * Carga los tours desde el archivo de texto.
     * Cada línea válida debe contener nombre, duración, tipo y precio separados por punto y coma.
     *
     * @return lista de servicios turísticos cargados desde el archivo.
     */
    public ArrayList<ServicioTuristico> cargarTours() {

        listaDeServiciosTuristicos.clear();

        InputStream archivo = GestorServicios.class.getResourceAsStream("/tours.txt");

        if (archivo == null) {
            System.out.println("No se encontró el archivo tours.txt");
            return listaDeServiciosTuristicos;
        }

        int numeroLinea = 0;

        try (BufferedReader br = new BufferedReader(new InputStreamReader(archivo))) {

            String linea;

            while ((linea = br.readLine()) != null) {
                numeroLinea++;
                if (linea.isBlank()) {
                    continue;
                }

                String[] partes = linea.split(";", -1);

                if (partes.length != 4) {
                    System.out.println( "La línea " + numeroLinea + " no contiene 4 datos" );
                    continue;
                }

                String nombre = partes[0].trim();
                String duracionTexto = partes[1].trim();
                String tipo = partes[2].trim();
                String precioTexto = partes[3].trim();

                try {
                    if (nombre.isEmpty() || duracionTexto.isEmpty() || tipo.isEmpty() || precioTexto.isEmpty()) {
                        throw new DatoInvalidoException( "contiene uno o más campos vacíos" );
                    }

                    int duracion = Integer.parseInt(duracionTexto);
                    double precio = Double.parseDouble(precioTexto);

                    if (duracion <= 0) { throw new DatoInvalidoException( "la duración debe ser mayor que cero" );
                    }

                    if (precio < 0) {
                        throw new DatoInvalidoException( "el precio no puede ser negativo" );
                    }

                    ServicioTuristico servicioTuristico = new ServicioTuristico( nombre, duracion, tipo, precio );
                    listaDeServiciosTuristicos.add( servicioTuristico );

                } catch (NumberFormatException e) {
                    System.out.println( "Línea " + numeroLinea + " omitida por formato numérico incorrecto" );

                } catch (DatoInvalidoException e) {
                    System.out.println( "Línea " + numeroLinea + " omitida porque " + e.getMessage() );
                }
            }

        } catch (IOException e) {
            System.out.println( "Error al leer la lista de tours: " + e.getMessage() );
        }

        return listaDeServiciosTuristicos;
    }

    /**
     * Obtiene la lista completa de tours. Si está vacía, primero intenta cargarla.
     *
     * @return lista completa de servicios turísticos.
     */
    public ArrayList<ServicioTuristico> obtenerLista(){
        if(listaDeServiciosTuristicos.isEmpty()){
            cargarTours();
        }
        return listaDeServiciosTuristicos;
    }

    /**
     * Obtiene la lista de los nombres de los tours (objetos) extraídos desde el archivo txt.
     *
     * @return lista de nombres de los servicios disponibles.
     */
    public String[] listarNombres(){
        obtenerLista();
        String[] nombreServicios = new String[listaDeServiciosTuristicos.size()];

        for(int i = 0; i < nombreServicios.length; i++){
            nombreServicios[i] = listaDeServiciosTuristicos.get(i).getNombre();
        }
        return nombreServicios;
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
     * Se deja el método disponible desde la entrega de la tarea de la semana 5 en caso de requerir su uso.
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
