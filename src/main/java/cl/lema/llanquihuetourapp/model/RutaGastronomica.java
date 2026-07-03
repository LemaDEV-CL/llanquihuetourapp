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
     * Método que muestra la información base de la superclase  mas los atributos de la subclase RutaGastronomica
     */
    @Override
    public void mostrarInformacion() {
        super.mostrarInformacion();
        System.out.println("Numero paradas: " + numeroParadas);
    }
}
