package cl.lema.llanquihuetourapp.model.entidades;

import cl.lema.llanquihuetourapp.model.servicios.ServicioTuristico;

import java.util.ArrayList;

/**
 * Representa un vehículo utilizado por la agencia.
 * Implementa Registrable para ser gestionado junto con las demás entidades.
 * También permite almacenar los servicios turísticos asignados al vehículo.
 *
 * @author Iván Lema
 * @version 1.0
 */
public class Vehiculo implements Registrable {

    /** Patente identificadora del vehículo. */
    private String patente;

    /** Tipo o categoría del vehículo registrado. */
    private String tipo;

    /** Lista de servicios turísticos asignados al vehículo. */
    private ArrayList<ServicioTuristico> servicios;

    /**
     * Crea un vehículo con su patente y tipo.
     * La lista de servicios se inicia vacía.
     *
     * @param patente patente del vehículo.
     * @param tipo tipo o categoría del vehículo.
     */
    public Vehiculo(String patente, String tipo) {
        this.patente = patente;
        this.tipo = tipo;
        this.servicios = new ArrayList<>();
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
     * Asigna una nueva patente al vehículo.
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
     * Asigna un nuevo tipo al vehículo.
     *
     * @param tipo nuevo tipo.
     */
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    /**
     * Obtiene la lista de servicios turísticos asignados.
     *
     * @return lista de servicios del vehículo.
     */
    public ArrayList<ServicioTuristico> getServicios() {
        return servicios;
    }

    /**
     * Reemplaza la lista de servicios turísticos del vehículo.
     *
     * @param servicios nueva lista de servicios.
     */
    public void setServicios(ArrayList<ServicioTuristico> servicios) {
        this.servicios = servicios;
    }

    /**
     * Agrega un servicio turístico a la lista del vehículo.
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
     * Genera un resumen con los datos principales del vehículo.
     *
     * @return patente, tipo y tour asignado en formato de texto.
     */
    @Override
    public String mostrarResumen() {
        return patente + " | " + "Tipo :" + tipo + " | " + "Tour " + obtenerNombreTour() + "\n" + "\n";
    }

    /**
     * Devuelve todos los datos del vehículo en formato de texto.
     *
     * @return representación del vehículo.
     */
    @Override
    public String toString() {
        return "Vehiculo{" +
                "patente='" + patente + '\'' +
                ", tipo='" + tipo + '\'' +
                ", servicios=" + servicios +
                '}';
    }
}