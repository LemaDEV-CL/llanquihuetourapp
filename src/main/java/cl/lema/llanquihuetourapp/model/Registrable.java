package cl.lema.llanquihuetourapp.model;

/**
 * Define el comportamiento común de las entidades administradas por la agencia.
 * Las clases que la implementan deben entregar un resumen de sus datos.
 *
 * @author Iván Lema
 * @version 1.0
 */
public interface Registrable {

    /**
     * Genera un resumen de la entidad.
     *
     * @return información principal de la entidad en formato de texto.
     */
    String mostrarResumen();
}
