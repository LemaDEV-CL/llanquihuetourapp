package cl.lema.llanquihuetourapp.model;

/**
 * Representa un vehículo utilizado por la agencia.
 * Implementa Registrable para ser gestionado junto con otras entidades.
 *
 * @author Iván Lema
 * @version 1.0
 */
public class Vehiculo implements Registrable {

    /** Patente identificadora del vehículo. */
    private String patente;

    /** Tipo de vehículo registrado. */
    private String tipo;

    /**
     * Crea un vehículo con su patente y tipo.
     *
     * @param patente patente del vehículo.
     * @param tipo tipo o categoría del vehículo.
     */
    public Vehiculo(String patente, String tipo) {
        this.patente = patente;
        this.tipo = tipo;
    }

    /**
     * Obtiene la patente del vehículo.
     *
     * @return patente registrada.
     */
    public String getPatente() {
        return patente;
    }

    /**
     * Asigna la patente del vehículo.
     *
     * @param patente nueva patente.
     */
    public void setPatente(String patente) {
        this.patente = patente;
    }

    /**
     * Obtiene el tipo de vehículo.
     *
     * @return tipo registrado.
     */
    public String getTipo() {
        return tipo;
    }

    /**
     * Asigna el tipo de vehículo.
     *
     * @param tipo nuevo tipo.
     */
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    /**
     * Genera un resumen con los datos del vehículo.
     *
     * @return patente y tipo en formato de texto.
     */
    @Override
    public String mostrarResumen() {
        return patente + " | " + "Tipo :" + tipo + "\n";
    }
}
