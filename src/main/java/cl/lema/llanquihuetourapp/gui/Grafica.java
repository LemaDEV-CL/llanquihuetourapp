package cl.lema.llanquihuetourapp.gui;

import cl.lema.llanquihuetourapp.data.GestorEntidades;
import cl.lema.llanquihuetourapp.model.ColaboradorExterno;
import cl.lema.llanquihuetourapp.model.GuiaTuristico;
import cl.lema.llanquihuetourapp.model.Registrable;
import cl.lema.llanquihuetourapp.model.Vehiculo;

import javax.swing.*;
import java.awt.*;

/**
 * Ventana principal de Llanquihue Tour.
 * Permite seleccionar un tipo de entidad, ingresar sus datos, guardarla
 * y visualizar los registros almacenados durante la ejecución.
 *
 * @author Iván Lema
 * @version 1.0
 */
public class Grafica extends JFrame {

    /** Gestor utilizado para almacenar y consultar las entidades creadas. */
    private GestorEntidades gestorEntidades = new GestorEntidades();

    /** Campo para ingresar el nombre del guía. */
    private JTextField nombreGuia;

    /** Campo para ingresar la especialidad del guía. */
    private JTextField especialidadGuia;

    /** Campo para ingresar la patente del vehículo. */
    private JTextField patenteVehiculo;

    /** Campo para ingresar el tipo de vehículo. */
    private JTextField tipoVehiculo;

    /** Campo para ingresar el nombre del colaborador. */
    private JTextField nombreColaborador;

    /** Campo para ingresar el rol del colaborador. */
    private JTextField rolColaborador;

    /** Administrador que cambia entre los formularios. */
    private CardLayout cardLayout;

    /** Panel que contiene las tarjetas de cada formulario. */
    private JPanel panelFormularios;

    /** Botón utilizado para guardar la entidad seleccionada. */
    private JButton btnGuardar;

    /** Botón utilizado para mostrar las entidades registradas. */
    private JButton btnMostrarInformacion;

    /** Área donde se muestran los resúmenes del sistema. */
    private JTextArea texto;

    /** Opciones disponibles para el registro de entidades. */
    private final String[] tiposEntidad = {
            "Guía Turístico",
            "Vehículo",
            "Colaborador Externo"
    };

    /** Lista desplegable para seleccionar el tipo de entidad. */
    private final JComboBox<String> comboTipo = new JComboBox<>(tiposEntidad);

    /**
     * Configura la ventana y agrega sus paneles principales.
     */
    public Grafica() {
        setTitle("Llanquihue Tour - Registro de entidades");
        setSize(400, 650);
        add(crearPanelPrincipal());

        configurarEventos();
    }

    /**
     * Construye el contenedor general de la ventana.
     *
     * @return panel principal con las secciones superior, central e inferior.
     */
    private JPanel crearPanelPrincipal() {
        JPanel panelPrincipal = new JPanel(new BorderLayout(10, 10));
        panelPrincipal.setBorder(
                BorderFactory.createEmptyBorder(15, 15, 15, 15)
        );

        panelPrincipal.add(crearPanelSuperior(), BorderLayout.NORTH);
        panelPrincipal.add(crearPanelFormularios(), BorderLayout.CENTER);
        panelPrincipal.add(crearPanelInferior(), BorderLayout.SOUTH);

        return panelPrincipal;
    }

    /**
     * Crea el título y la lista desplegable para seleccionar una entidad.
     *
     * @return panel superior de la interfaz.
     */
    private JPanel crearPanelSuperior() {

        JPanel panelSuperior = new JPanel(new BorderLayout(0, 15));
        JLabel titulo = new JLabel("Registro de entidades");
        JPanel panelSeleccion = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JLabel etiquetaTipo = new JLabel("Tipo de entidad:");

        panelSeleccion.add(etiquetaTipo);
        panelSeleccion.add(comboTipo);

        panelSuperior.add(titulo, BorderLayout.NORTH);
        panelSuperior.add(panelSeleccion, BorderLayout.CENTER);

        return panelSuperior;
    }

    /**
     * Crea los campos para registrar un guía turístico.
     *
     * @return formulario de guía turístico.
     */
    private JPanel crearFormularioGuia() {
        JPanel panelGuia = new JPanel(new GridLayout(2, 2, 10, 10));
        panelGuia.setBorder(BorderFactory.createTitledBorder("Datos del Guía"));
        nombreGuia = new JTextField();
        especialidadGuia = new JTextField();

        JLabel etiquetaNombre = new JLabel("Nombre:");
        JLabel etiquetaEspecialidad = new JLabel("Especialidad:");

        panelGuia.add(etiquetaNombre);
        panelGuia.add(nombreGuia);

        panelGuia.add(etiquetaEspecialidad);
        panelGuia.add(especialidadGuia);

        return panelGuia;
    }

    /**
     * Crea los campos para registrar un vehículo.
     *
     * @return formulario de vehículo.
     */
    private JPanel crearFormularioVehiculo() {
        JPanel panelVehiculo = new JPanel(new GridLayout(2, 2, 10, 10));
        panelVehiculo.setBorder(BorderFactory.createTitledBorder("Datos del Vehículo"));
        patenteVehiculo = new JTextField();
        tipoVehiculo = new JTextField();

        JLabel etiquetaPatente = new JLabel("Patente:");
        JLabel etiquetaTipo = new JLabel("Tipo:");

        panelVehiculo.add(etiquetaPatente);
        panelVehiculo.add(patenteVehiculo);

        panelVehiculo.add(etiquetaTipo);
        panelVehiculo.add(tipoVehiculo);

        return panelVehiculo;
    }

    /**
     * Crea los campos para registrar un colaborador externo.
     *
     * @return formulario de colaborador externo.
     */
    private JPanel crearFormularioColaborador() {

        JPanel panelColaborador =
                new JPanel(new GridLayout(2, 2, 10, 10));

        panelColaborador.setBorder(
                BorderFactory.createTitledBorder("Datos del colaborador externo"));

        nombreColaborador = new JTextField();
        rolColaborador = new JTextField();

        JLabel etiquetaNombreColaborador = new JLabel("Nombre:");
        JLabel etiquetaRol = new JLabel("Rol:");

        panelColaborador.add(etiquetaNombreColaborador);
        panelColaborador.add(nombreColaborador);

        panelColaborador.add(etiquetaRol);
        panelColaborador.add(rolColaborador);

        return panelColaborador;
    }

    /**
     * Agrupa los tres formularios mediante CardLayout.
     *
     * @return panel que muestra un formulario a la vez.
     */
    private JPanel crearPanelFormularios() {
        cardLayout = new CardLayout();

        panelFormularios = new JPanel(cardLayout);

        panelFormularios.add(crearFormularioGuia(), "Guía Turístico");
        panelFormularios.add(crearFormularioVehiculo(),"Vehículo");
        panelFormularios.add(crearFormularioColaborador(), "Colaborador Externo");

        return panelFormularios;
    }

    /**
     * Crea los botones y el área destinada a mostrar los registros.
     *
     * @return panel inferior de la interfaz.
     */
    private JPanel crearPanelInferior() {
        JPanel panelInferior = new JPanel(new BorderLayout(10, 10));
        JPanel panelBotones = new JPanel(new FlowLayout(FlowLayout.LEFT, 10, 5));

        btnGuardar = new JButton("Guardar");
        btnMostrarInformacion = new JButton("Mostrar Información");

        panelBotones.add(btnGuardar);
        panelBotones.add(btnMostrarInformacion);

        texto = new JTextArea(8,30);
        texto.setEditable(false);
        texto.setLineWrap(true);
        texto.setWrapStyleWord(true);

        JScrollPane scrollTexto = new JScrollPane(texto);
        scrollTexto.setBorder(BorderFactory.createTitledBorder("Información registrada"));

        panelInferior.add(panelBotones, BorderLayout.NORTH);
        panelInferior.add(scrollTexto, BorderLayout.CENTER);

        return panelInferior;
    }

    /**
     * Configura las acciones del selector y de los botones de la ventana.
     */
    private void configurarEventos() {

        comboTipo.addActionListener(e -> {

            String seleccion = (String) comboTipo.getSelectedItem();
            cardLayout.show (panelFormularios, seleccion);
        });
        btnGuardar.addActionListener(e -> {
            guardarEntidad();
        });

        btnMostrarInformacion.addActionListener(e -> {

            String resumen = gestorEntidades.mostrarEntidades();
            texto.setText(resumen);
        });
    }

    /**
     * Revisa la opción seleccionada y dirige el guardado al método correspondiente.
     */
    private void guardarEntidad(){

        String seleccion = (String) comboTipo.getSelectedItem();

        if(seleccion == null)
            return;

        switch (seleccion) {

            case "Guía Turístico":
                guardarGuia();
                break;

            case "Colaborador Externo":
                guardarColaborador();
                break;

            case "Vehículo":
                guardarVehiculo();
                break;

            default:
                texto.setText("No se reconoce el tipo de entidad");
        }

    }


    /**
     * Valida y guarda los datos ingresados para un guía turístico.
     */
    private void guardarGuia(){
        String nombre = nombreGuia.getText().trim();
        String especialidad = especialidadGuia.getText().trim();

        if(nombre.isEmpty() || especialidad.isEmpty()) {
            mostrarErrorCampoVacio();
            return;
        }

        GuiaTuristico guia = new GuiaTuristico(nombre, especialidad);
        gestorEntidades.agregarRegistrable(guia);
        nombreGuia.setText("");
        especialidadGuia.setText("");
        JOptionPane.showMessageDialog(this, "Guía guardado correctamente");
    }

    /**
     * Valida y guarda los datos ingresados para un vehículo.
     */
    private void guardarVehiculo(){
        String patente = patenteVehiculo.getText().trim();
        String tipo = tipoVehiculo.getText().trim();

        if(patente.isEmpty() || tipo.isEmpty()) {
            mostrarErrorCampoVacio();
            return;
        }

        Vehiculo vehiculo = new Vehiculo(patente, tipo);
        gestorEntidades.agregarRegistrable(vehiculo);
        patenteVehiculo.setText("");
        tipoVehiculo.setText("");
        JOptionPane.showMessageDialog(this, "Vehículo guardado correctamente");
    }

    /**
     * Valida y guarda los datos ingresados para un colaborador externo.
     */
    private void guardarColaborador(){
        String nombre = nombreColaborador.getText().trim();
        String rol = rolColaborador.getText().trim();

        if(nombre.isEmpty() || rol.isEmpty()) {
            mostrarErrorCampoVacio();
            return;
        }

        ColaboradorExterno colaborador = new ColaboradorExterno(nombre, rol);
        gestorEntidades.agregarRegistrable(colaborador);
        nombreColaborador.setText("");
        rolColaborador.setText("");
        JOptionPane.showMessageDialog(this, "Colaborador guardado correctamente");
    }

    /**
     * Muestra un mensaje cuando falta información obligatoria.
     */
    private void mostrarErrorCampoVacio() {

        JOptionPane.showMessageDialog(
                this,
                "Asegúrese de ingresar la información en todos los campos",
                "Campo obligatorio",
                JOptionPane.ERROR_MESSAGE
        );
    }

}
