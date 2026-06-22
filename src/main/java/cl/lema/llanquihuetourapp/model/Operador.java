package cl.lema.llanquihuetourapp.model;

import java.util.List;

/**

 * Representa un operador turístico asociado al sistema Llanquihue Tour.
 * Esta clase aplica composición, ya que contiene un objeto de tipo
 * Direccion para representar su ubicación.
 *
 * @author Iván Lema
 * @version 1.0
 */
public class Operador {

    /**

     * Nombre del operador turístico.
     */
    private String nombre;

    /**

     * Tipo o categoría del operador.
     */
    private String tipo;

    /**

     * Dirección asociada al operador.
     */
    private Direccion direccion;

    /**

     * Lista de tours asociados al operador.
     */
    private List<Tour> tours;

    /**

     * Constructor con parámetros para crear un operador turístico.
     *
     * @param nombre nombre del operador.
     * @param tipo tipo o categoría del operador.
     * @param calle calle asociada a la dirección del operador.
     * @param comuna comuna asociada a la dirección del operador.
     * @param ciudad ciudad asociada a la dirección del operador.
     */
    public Operador(String nombre, String tipo, String calle, String comuna, String ciudad) {
        this.nombre = nombre;
        this.tipo = tipo;
        this.direccion = new Direccion(calle, comuna, ciudad);
    }

    /**

     * Obtiene el nombre del operador.
     *
     * @return nombre del operador.
     */
    public String getNombre() {
        return nombre;
    }

    /**

     * Asigna el nombre del operador.
     *
     * @param nombre nuevo nombre del operador.
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**

     * Obtiene el tipo del operador.
     *
     * @return tipo del operador.
     */
    public String getTipo() {
        return tipo;
    }

    /**

     * Asigna el tipo del operador.
     *
     * @param tipo nuevo tipo del operador.
     */
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    /**

     * Obtiene la dirección del operador.
     *
     * @return dirección asociada al operador.
     */
    public Direccion getDireccion() {
        return direccion;
    }

    /**

     * Asigna una dirección al operador.
     *
     * @param direccion nueva dirección del operador.
     */
    public void setDireccion(Direccion direccion) {
        this.direccion = direccion;
    }

    /**

     * Devuelve una representación en texto del objeto Operador.
     *
     * @return texto con el nombre, tipo y dirección del operador.
     */

@Override
    public String toString() {
        return "Operador{" +
                "nombre='" + nombre + '\'' +
                ", tipo='" + tipo + '\'' +
                ", direccion=" + direccion +
                '}';
    }
}
