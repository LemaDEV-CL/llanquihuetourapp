package cl.lema.llanquihuetourapp.data;

import cl.lema.llanquihuetourapp.model.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Administra las entidades registrables de la agencia.
 * Permite guardar guías, vehículos y colaboradores externos en una misma colección
 * y generar un resumen aplicando polimorfismo e instanceof.
 *
 * @author Iván Lema
 * @version 1.0
 */
public class GestorEntidades {

    /** Colección común para todas las clases que implementan Registrable. */
    private final List<Registrable> entidades = new ArrayList<>();

    /**
     * Agrega una nueva entidad a la colección.
     *
     * @param registrable entidad que se desea registrar.
     */
    public void agregarRegistrable(Registrable registrable){
        entidades.add(registrable);
    }

    /**
     * Recorre las entidades, identifica su tipo y construye un resumen general.
     *
     * @return texto con las entidades registradas o un mensaje si la colección está vacía.
     */
    public String mostrarEntidades() {

        if (entidades.isEmpty()) {
            return "No se encontraron registros";
        }
        StringBuilder sb = new StringBuilder();

        for (Registrable registrable : entidades) {

            if (registrable instanceof GuiaTuristico) {
                sb.append("Guía: ");
            }
            if (registrable instanceof Vehiculo) {
                sb.append("Vehículo: ");
            }
            if (registrable instanceof ColaboradorExterno) {
                sb.append("Colaborador: ");
            }
            sb.append(registrable.mostrarResumen());
        }
        return sb.toString();
    }
}
