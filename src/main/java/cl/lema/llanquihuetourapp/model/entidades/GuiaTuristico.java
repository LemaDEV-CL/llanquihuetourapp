package cl.lema.llanquihuetourapp.model.entidades;

import cl.lema.llanquihuetourapp.model.servicios.ServicioTuristico;

import java.util.ArrayList;

/**
 * Representa a un guía turístico de la agencia.
 * Implementa Registrable para ser administrado junto con las demás entidades.
 * También permite almacenar los servicios turísticos asignados al guía.
 *
 * @author Iván Lema
 * @version 1.0
 */
public class GuiaTuristico implements Registrable {

    /** Nombre del guía turístico. */
    private String nombre;

    /** Área o actividad en la que se especializa. */
    private String especialidad;

    /** Lista de servicios turísticos asignados al guía. */
    private ArrayList<ServicioTuristico> servicios;

    /**
     * Crea un guía turístico con sus datos principales.
     * La lista de servicios se inicia vacía.
     *
     * @param nombre nombre del guía.
     * @param especialidad especialidad del guía.
     */
    public GuiaTuristico(String nombre, String especialidad) {
        this.nombre = nombre;
        this.especialidad = especialidad;
        this.servicios = new ArrayList<>();
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
     * Obtiene la lista de servicios turísticos asignados.
     *
     * @return lista de servicios del guía.
     */
    public ArrayList<ServicioTuristico> getServicios() {
        return servicios;
    }

    /**
     * Reemplaza la lista de servicios turísticos del guía.
     *
     * @param servicios nueva lista de servicios.
     */
    public void setServicios(ArrayList<ServicioTuristico> servicios) {
        this.servicios = servicios;
    }

    /**
     * Agrega un servicio turístico a la lista del guía.
     *
     * @param servicio servicio que será asignado.
     */
    public void agregarServicio(ServicioTuristico servicio){
        this.servicios.add(servicio);
    }

    /**
     * Obtiene el nombre del primer tour asignado.
     * Si la lista está vacía, informa que no existe un tour asignado.
     *
     * @return nombre del tour o mensaje sin tour asignado.
     */
    private String obtenerNombreTour() {

        if (servicios.isEmpty()) {
            return "Sin tour asignado";
        }

        return servicios.get(0).getNombre();
    }

    /**
     * Genera un resumen con los datos principales del guía.
     *
     * @return nombre, especialidad y tour asignado en formato de texto.
     */
    @Override
    public String mostrarResumen() {
        return nombre + " | " + "Especialidad :" + especialidad + " | " + "Tour: " + obtenerNombreTour() + "\n"+ "\n";
    }

    /**
     * Devuelve todos los datos del guía en formato de texto.
     *
     * @return representación del guía turístico.
     */
    @Override
    public String toString() {
        return "GuiaTuristico{" +
                "nombre='" + nombre + '\'' +
                ", especialidad='" + especialidad + '\'' +
                ", servicios=" + servicios +
                '}';
    }
}