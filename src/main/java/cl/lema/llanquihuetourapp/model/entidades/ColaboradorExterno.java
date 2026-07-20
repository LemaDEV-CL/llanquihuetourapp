package cl.lema.llanquihuetourapp.model.entidades;

import cl.lema.llanquihuetourapp.model.servicios.ServicioTuristico;

import java.util.ArrayList;

/**
 * Representa a un colaborador externo que presta apoyo a la agencia.
 * Implementa Registrable para ser almacenado junto con las demás entidades.
 * También permite asignar servicios turísticos y registrar su dirección.
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
     * Tipo de colaborador externo.
     * Por ejemplo: restaurante, paseo a caballo o coffee break.
     */
    private String tipo;

    /** Dirección del colaborador externo. */
    private Direccion direccion;

    /** Lista de servicios turísticos asignados al colaborador externo. */
    private ArrayList<ServicioTuristico> servicios;

    /**
     * Crea un colaborador externo con sus datos principales.
     * La dirección se relaciona mediante composición y la lista de servicios
     * se inicia vacía.
     *
     * @param nombre nombre del colaborador.
     * @param rol función que realiza.
     * @param tipo tipo de servicio que presta el colaborador.
     * @param direccion dirección del colaborador.
     */
    public ColaboradorExterno(String nombre, String rol, String tipo, Direccion direccion) {
        this.nombre = nombre;
        this.rol = rol;
        this.direccion = direccion;
        this.tipo = tipo;
        this.servicios = new ArrayList<>();
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
     * Obtiene la dirección del colaborador.
     *
     * @return dirección registrada.
     */
    public Direccion getDireccion() {
        return direccion;
    }

    /**
     * Obtiene el tipo de colaborador externo.
     *
     * @return tipo de servicio que presta.
     */
    public String getTipo() {
        return tipo;
    }

    /**
     * Asigna el tipo de colaborador externo.
     *
     * @param tipo nuevo tipo de colaborador.
     */
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    /**
     * Asigna una nueva dirección al colaborador.
     *
     * @param direccion nueva dirección.
     */
    public void setDireccion(Direccion direccion) {
        this.direccion = direccion;
    }

    /**
     * Obtiene la lista de servicios turísticos asignados.
     *
     * @return lista de servicios del colaborador.
     */
    public ArrayList<ServicioTuristico> getServicios() {
        return servicios;
    }

    /**
     * Reemplaza la lista de servicios turísticos.
     *
     * @param servicios nueva lista de servicios.
     */
    public void setServicios(ArrayList<ServicioTuristico> servicios) {
        this.servicios = servicios;
    }

    /**
     * Agrega un servicio turístico a la lista del colaborador.
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
     * Genera un resumen con los datos principales del colaborador.
     *
     * @return información del colaborador en formato de texto.
     */
    @Override
    public String mostrarResumen() {
        return nombre + " | " + "Rol :" + rol + " | " + "Tipo :" + tipo + " | " + "Calle :" + direccion + " | " + "Tour: " + obtenerNombreTour() + "\n"+ "\n";
    }

    /**
     * Devuelve todos los datos del colaborador en formato de texto.
     *
     * @return representación del colaborador externo.
     */
    @Override
    public String toString() {
        return "ColaboradorExterno{" +
                "nombre='" + nombre + '\'' +
                ", rol='" + rol + '\'' +
                ", tipo='" + tipo + '\'' +
                ", direccion=" + direccion +
                ", servicios=" + servicios +
                '}';
    }
}