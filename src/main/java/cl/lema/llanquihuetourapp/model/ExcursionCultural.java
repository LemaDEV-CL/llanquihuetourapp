package cl.lema.llanquihuetourapp.model;

/**

 * Representa una excursión cultural dentro del sistema Llanquihue Tour.
 *
 * Esta clase hereda de ServicioTuristico y agrega como dato propio
 * el lugar histórico asociado a la excursión.
 */
public class ExcursionCultural extends ServicioTuristico {

    /**

     * Lugar histórico asociado a la excursión cultural.
     */
    private String lugarHistorico;

    /**

     * Constructor con parámetros para crear una excursión cultural.
     *
     * @param nombre nombre del servicio turístico.
     * @param duracionHoras duración del servicio en horas.
     * @param tipo tipo o categoría del servicio.
     * @param precio precio del servicio turístico.
     * @param lugarHistorico lugar histórico asociado a la excursión.
     */
    public ExcursionCultural(String nombre, int duracionHoras, String tipo, double precio, String lugarHistorico) {
        super(nombre,duracionHoras, tipo, precio);
        this.lugarHistorico = lugarHistorico;
    }

    /**

     * Obtiene el lugar histórico de la excursión cultural.
     *
     * @return lugar histórico asociado.
     */
    public String getLugarHistorico() {
        return lugarHistorico;
    }

    /**

     * Asigna el lugar histórico de la excursión cultural.
     *
     * @param lugarHistorico nuevo lugar histórico.
     */
    public void setLugarHistorico(String lugarHistorico) {
        this.lugarHistorico = lugarHistorico;
    }

    /**

     * Devuelve una representación en texto de la excursión cultural.
     *
     * @return información completa de la excursión cultural.
     */
    @Override
    public String toString() {
        return "ExcursionCultural{" + super.toString() + "lugarHistorico=" + lugarHistorico + '}' + "\n";
    }
}
