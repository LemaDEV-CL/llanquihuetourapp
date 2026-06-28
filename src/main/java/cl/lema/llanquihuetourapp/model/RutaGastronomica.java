package cl.lema.llanquihuetourapp.model;

/**

 * Representa una ruta gastronómica dentro del sistema Llanquihue Tour.
 * Esta clase hereda de ServicioTuristico y agrega como dato propio
 * el número de paradas que tendrá la ruta.
 */
public class RutaGastronomica extends ServicioTuristico {

    /**

     * Número de paradas consideradas en la ruta gastronómica.
     */
    private int numeroParadas;

    /**

     * Constructor con parámetros para crear una ruta gastronómica.
     *
     * @param nombre nombre del servicio turístico.
     * @param duracionHoras duración del servicio en horas.
     * @param tipo tipo o categoría del servicio.
     * @param precio precio del servicio turístico.
     * @param numeroParadas cantidad de paradas de la ruta gastronómica.
     */
    public RutaGastronomica(String nombre, int duracionHoras, String tipo, double precio, int numeroParadas) {
        super(nombre, duracionHoras, tipo, precio);
        this.numeroParadas = numeroParadas;
    }

    /**

     * Obtiene el número de paradas de la ruta gastronómica.
     *
     * @return número de paradas.
     */
    public int getNumeroParadas() {
        return numeroParadas;
    }

    /**

     * Asigna el número de paradas de la ruta gastronómica.
     *
     * @param numeroParadas nuevo número de paradas.
     */
    public void setNumeroParadas(int numeroParadas) {
        this.numeroParadas = numeroParadas;
    }

    /**

     * Devuelve una representación en texto de la ruta gastronómica.
     *
     * @return información completa de la ruta gastronómica.
     */
    @Override
    public String toString() {
        return "RutaGastronomica{" + super.toString() +
                "numeroParadas=" + numeroParadas +
                '}' + "\n";
    }
}
