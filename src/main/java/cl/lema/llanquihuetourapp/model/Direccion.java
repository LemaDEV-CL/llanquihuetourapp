package cl.lema.llanquihuetourapp.model;

/**

 * Representa una dirección dentro del sistema
 * Esta clase se utiliza para almacenar los datos de ubicación asociados
 * a un operador turístico, considerando calle, comuna y ciudad.
 *
 * @author Iván Lema
 * @version 1.0
 */
public class Direccion {

    /**

     * Calle asociada a la dirección.
     */
    private String calle;

    /**

     * Comuna asociada a la dirección.
     */
    private String comuna;

    /**

     * Ciudad asociada a la dirección.
     */
    private String ciudad;

    /**

     * Constructor con parámetros para crear una dirección.
     *
     * @param calle valor recibido para la dirección.
     * @param comuna valor recibido para la dirección.
     * @param ciudad valor recibido para la dirección.
     */
    public Direccion(String calle, String comuna, String ciudad) {
        this.calle = calle;
        this.comuna = comuna;
        this.ciudad = ciudad;
    }

    /**

     * Obtiene la calle registrada en la dirección.
     *
     * @return calle de la dirección.
     */
    public String getCalle() {
        return calle;
    }

    /**

     * Asigna la calle de la dirección.
     *
     * @param calle nueva calle de la dirección.
     */
    public void setCalle(String calle) {
        this.calle = calle;
    }

    /**

     * Obtiene la comuna registrada en la dirección.
     *
     * @return comuna de la dirección.
     */
    public String getComuna() {
        return comuna;
    }

    /**

     * Asigna la comuna de la dirección.
     *
     * @param comuna nueva comuna de la dirección.
     */
    public void setComuna(String comuna) {
        this.comuna = comuna;
    }

    /**

     * Obtiene la ciudad registrada en la dirección.
     *
     * @return ciudad de la dirección.
     */
    public String getCiudad() {
        return ciudad;
    }

    /**

     * Asigna la ciudad de la dirección.
     *
     * @param ciudad nueva ciudad de la dirección.
     */
    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    /**

     * Devuelve una representación en texto del objeto Direccion.
     *
     * @return texto con la calle, comuna y ciudad registradas.
     */
@Override
    public String toString() {
        return "Direccion{" +
                "calle='" + calle + '\'' +
                ", comuna='" + comuna + '\'' +
                ", ciudad='" + ciudad + '\'' +
                '}';
    }
}
