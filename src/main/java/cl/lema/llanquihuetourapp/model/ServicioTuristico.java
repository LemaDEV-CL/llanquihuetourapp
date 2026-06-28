package cl.lema.llanquihuetourapp.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Clase que representa un tour turístico.
 * Cada tour tiene un nombre, un tipo y un precio. Esta clase se usa como modelo
 * para guardar la información que viene desde el archivo de texto.
 *
 * @author Iván Lema
 * @version 1.0
 */
public class ServicioTuristico {

    /**
     * Nombre del servicio turístico.
     */
    private String nombre;

    /**
     * Duración del servicio turístico.
     */
    private int duracionHoras;

    /**
     * Tipo o categoría del servicio turístico.
     */
    private String tipo;

    /**
     * Precio del servicio turístico.
     */
    private double precio;
    /**
     * Precio del servicio turístico.
     */
    protected List<Operador>  operadores;
    /**
     * Constructor vacío de la clase Tour.
     */
    public ServicioTuristico() {
    }

    /**
     * Constructor con parámetros para crear un tour con sus datos principales.
     *
     * @param nombre nombre del tour turístico.
     * @param duracionHoras duración en horas del servicio turístico.
     * @param tipo tipo o categoría del tour turístico.
     * @param precio precio del tour turístico.
     */
    public ServicioTuristico(String nombre, int duracionHoras, String tipo, double precio) {
        this.nombre = nombre;
        this.duracionHoras = duracionHoras;
        this.tipo = tipo;
        this.precio = precio;
        this.operadores = new ArrayList<>();
    }

    /**
     * Obtiene el nombre del tour.
     *
     * @return nombre del tour.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Asigna el nombre del tour.
     *
     * @param nombre nuevo nombre del tour.
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    /**
     * Obtiene la duración del tour.
     *
     * @return duración del tour.
     */
    public int getDuracionHoras() {
        return duracionHoras;
    }
    /**
     * Asigna la duración del tour.
     *
     * @param duracionHoras nueva duración del tour.
     */
    public void setDuracionHoras(int duracionHoras) {
        this.duracionHoras = duracionHoras;
    }

    /**
     * Obtiene el tipo del tour.
     *
     * @return tipo del tour.
     */


    public String getTipo() {
        return tipo;
    }

    /**
     * Asigna el tipo del tour.
     *
     * @param tipo nuevo tipo del tour.
     */
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    /**
     * Obtiene el precio del tour.
     *
     * @return precio del tour.
     */
    public double getPrecio() {
        return precio;
    }

    /**
     * Asigna el precio del tour.
     *
     * @param precio nuevo precio del tour.
     */
    public void setPrecio(double precio) {
        this.precio = precio;
    }
    /**
     * Obtiene la lista de operadores
     *
     * @return operadores del tour.
     */
    public List<Operador> getOperadores() {
        return operadores;
    }
    /**
     * Asigna operadores disponibles del tour.
     *
     * @param operadores nuevo operador para tour.
     */
    public void setOperadores(List<Operador> operadores) {
        this.operadores = operadores;
    }
    /**
     * Método que agregar un nuevo operador a la lista de operadores.
     *
     * @param operador operador que se agrega a la lista de operadores.
     */
    public void agregarOperador(Operador operador) {
        operadores.add(operador);
    }
    /**
     * Devuelve una representación en texto del objeto.
     *
     * @return texto con los datos del tour.
     */
    @Override
    public String toString() {
        return "Tour-> " +
                "nombre: " + nombre + '|' +
                "Duración: " + duracionHoras + '|' +
                " tipo: " + tipo + '|' +
                " precio: " + precio +
                " Operadores: " + operadores
                ;
    }
}
