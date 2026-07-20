package cl.lema.llanquihuetourapp.model.entidades;

/**
 * Representa la dirección de una entidad registrada en el sistema.
 * Contiene los datos de calle, comuna, ciudad y país.
 *
 * @author Iván Lema
 * @version 1.0
 */
public class Direccion {

    /** Calle correspondiente a la dirección. */
    private String calle;

    /** Comuna correspondiente a la dirección. */
    private String comuna;

    /** Ciudad correspondiente a la dirección. */
    private String ciudad;

    /** País correspondiente a la dirección. */
    private String pais;

    /**
     * Crea una dirección con todos sus datos principales.
     *
     * @param pais país de la dirección.
     * @param ciudad ciudad de la dirección.
     * @param comuna comuna de la dirección.
     * @param calle calle de la dirección.
     */
    public Direccion(String pais, String ciudad, String comuna, String calle) {
        this.pais = pais;
        this.ciudad = ciudad;
        this.comuna = comuna;
        this.calle = calle;
    }

    /**
     * Obtiene la calle registrada.
     *
     * @return calle de la dirección.
     */
    public String getCalle() {
        return calle;
    }

    /**
     * Asigna una nueva calle.
     *
     * @param calle nueva calle.
     */
    public void setCalle(String calle) {
        this.calle = calle;
    }

    /**
     * Obtiene la comuna registrada.
     *
     * @return comuna de la dirección.
     */
    public String getComuna() {
        return comuna;
    }

    /**
     * Asigna una nueva comuna.
     *
     * @param comuna nueva comuna.
     */
    public void setComuna(String comuna) {
        this.comuna = comuna;
    }

    /**
     * Obtiene la ciudad registrada.
     *
     * @return ciudad de la dirección.
     */
    public String getCiudad() {
        return ciudad;
    }

    /**
     * Asigna una nueva ciudad.
     *
     * @param ciudad nueva ciudad.
     */
    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    /**
     * Obtiene el país registrado.
     *
     * @return país de la dirección.
     */
    public String getPais() {
        return pais;
    }

    /**
     * Asigna un nuevo país.
     *
     * @param pais nuevo país.
     */
    public void setPais(String pais) {
        this.pais = pais;
    }

    /**
     * Devuelve la dirección completa en formato de texto.
     *
     * @return calle, comuna, ciudad y país.
     */
    @Override
    public String toString() {
        return calle + " | " + "Comuna:  " + comuna + " | " + "Ciudad: " + ciudad + " | " + "País: " + pais;
    }
}