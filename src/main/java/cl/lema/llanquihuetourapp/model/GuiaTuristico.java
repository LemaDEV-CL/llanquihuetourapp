package cl.lema.llanquihuetourapp.model;

/**
 * Representa a un guía turístico de la agencia.
 * Implementa Registrable para ser administrado desde una colección común.
 *
 * @author Iván Lema
 * @version 1.0
 */
public class GuiaTuristico implements Registrable {

    /** Nombre del guía turístico. */
    private String nombre;

    /** Área o actividad en la que se especializa. */
    private String especialidad;

    /**
     * Crea un guía turístico con sus datos principales.
     *
     * @param nombre nombre del guía.
     * @param especialidad especialidad del guía.
     */
    public GuiaTuristico(String nombre, String especialidad) {
        this.nombre = nombre;
        this.especialidad = especialidad;
    }

    /**
     * Obtiene el nombre del guía.
     *
     * @return nombre registrado.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Asigna el nombre del guía.
     *
     * @param nombre nuevo nombre.
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Obtiene la especialidad del guía.
     *
     * @return especialidad registrada.
     */
    public String getEspecialidad() {
        return especialidad;
    }

    /**
     * Asigna la especialidad del guía.
     *
     * @param especialidad nueva especialidad.
     */
    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    /**
     * Genera un resumen con los datos del guía.
     *
     * @return nombre y especialidad en formato de texto.
     */
    @Override
    public String mostrarResumen() {
        return nombre + " | " + "Especialidad :" + especialidad + "\n";
    }
}
