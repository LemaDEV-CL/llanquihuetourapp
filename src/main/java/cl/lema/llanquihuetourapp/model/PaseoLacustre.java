package cl.lema.llanquihuetourapp.model;

/**

 * Representa un paseo lacustre dentro del sistema Llanquihue Tour.
 * <p>
 * Esta clase hereda de ServicioTuristico y agrega como dato propio
 * el tipo de embarcación utilizada en el paseo.
 */
public class PaseoLacustre extends ServicioTuristico{

    /**

     * Tipo de embarcación utilizada en el paseo lacustre.
     */
    private String tipoEmbarcacion;

    /**

     * Constructor con parámetros para crear un paseo lacustre.
     *
     * @param nombre nombre del servicio turístico.
     * @param duracionHoras duración del servicio en horas.
     * @param tipo tipo o categoría del servicio.
     * @param precio precio del servicio turístico.
     * @param tipoEmbarcacion tipo de embarcación utilizada.
     */
    public PaseoLacustre(String nombre, int duracionHoras, String tipo, double precio, String tipoEmbarcacion) {
        super(nombre, duracionHoras, tipo, precio);
        this.tipoEmbarcacion = tipoEmbarcacion;
    }

    /**

     * Obtiene el tipo de embarcación del paseo lacustre.
     *
     * @return tipo de embarcación.
     */
    public String getTipoEmbarcacion() {
        return tipoEmbarcacion;
    }

    /**

     * Asigna el tipo de embarcación del paseo lacustre.
     *
     * @param tipoEmbarcacion nuevo tipo de embarcación.
     */
    public void setTipoEmbarcacion(String tipoEmbarcacion) {
        this.tipoEmbarcacion = tipoEmbarcacion;
    }

    /**

     * Devuelve una representación en texto del paseo lacustre.
     *
     * @return información completa del paseo lacustre.
     */
    @Override
    public String toString() {
        return "PaseoLacustre{" + super.toString() + "tipoEmbarcacion=" + tipoEmbarcacion + '}' + "\n";
    }
}
