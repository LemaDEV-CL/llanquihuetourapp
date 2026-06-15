package cl.lema.llanquihuetourapp.model;

/**
 * Clase que representa un tour turístico.
 *
 * Cada tour tiene un nombre, un tipo y un precio. Esta clase se usa como modelo
 * para guardar la información que viene desde el archivo de texto.
 *
 * @author Iván Lema
 * @version 1.0
 */
public class Tour {

    /**
     * Nombre del tour turístico.
     */
    private String nombre;

    /**
     * Tipo o categoría del tour turístico.
     */
    private String tipo;

    /**
     * Precio del tour turístico.
     */
    private double precio;

    /**
     * Constructor vacío de la clase Tour.
     */
    public Tour() {
    }

    /**
     * Constructor con parámetros para crear un tour con sus datos principales.
     *
     * @param nombre nombre del tour turístico.
     * @param tipo tipo o categoría del tour turístico.
     * @param precio precio del tour turístico.
     */
    public Tour(String nombre, String tipo, double precio) {
        this.nombre = nombre;
        this.tipo = tipo;
        this.precio = precio;
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
     * Devuelve una representación en texto del objeto Tour.
     *
     * @return texto con los datos del tour.
     */
    @Override
    public String toString() {
        return "Tour{" +
                "nombre='" + nombre + '\'' +
                ", tipo='" + tipo + '\'' +
                ", precio=" + precio +
                '}';
    }
}
