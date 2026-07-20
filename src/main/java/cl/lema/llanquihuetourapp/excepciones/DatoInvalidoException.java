package cl.lema.llanquihuetourapp.excepciones;

/**
 * Excepción personalizada, utilizada cuando un dato del archivo no es válido.
 *
 * @author Iván Lema
 * @version 1.0
 */
public class DatoInvalidoException extends Exception {

    public DatoInvalidoException(String mensaje) {
        super(mensaje);
    }
}