package cl.lema.llanquihuetourapp.model;

/**
 * Representa a un colaborador externo que presta apoyo a la agencia.
 * Implementa Registrable para ser almacenado junto con las demás entidades.
 *
 * @author Iván Lema
 * @version 1.0
 */
public class ColaboradorExterno implements Registrable{

    /** Nombre del colaborador externo. */
    private String nombre;

    /** Rol o función que cumple dentro de la actividad. */
    private String rol;

    /**
     * Crea un colaborador externo con sus datos principales.
     *
     * @param nombre nombre del colaborador.
     * @param rol función que realiza.
     */
    public ColaboradorExterno(String nombre, String rol) {
        this.nombre = nombre;
        this.rol = rol;
    }

    /**
     * Obtiene el nombre del colaborador.
     *
     * @return nombre registrado.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Asigna el nombre del colaborador.
     *
     * @param nombre nuevo nombre.
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Obtiene el rol del colaborador.
     *
     * @return rol registrado.
     */
    public String getRol() {
        return rol;
    }

    /**
     * Asigna el rol del colaborador.
     *
     * @param rol nuevo rol.
     */
    public void setRol(String rol) {
        this.rol = rol;
    }

    /**
     * Genera un resumen con los datos del colaborador.
     *
     * @return nombre y rol en formato de texto.
     */
    @Override
    public String mostrarResumen() {
        return nombre + " | " + "Rol :" + rol + "\n";
    }
}
