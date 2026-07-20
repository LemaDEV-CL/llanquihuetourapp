package cl.lema.llanquihuetourapp.gui;

import cl.lema.llanquihuetourapp.data.GestorEntidades;
import cl.lema.llanquihuetourapp.data.GestorServicios;
import cl.lema.llanquihuetourapp.model.entidades.ColaboradorExterno;
import cl.lema.llanquihuetourapp.model.entidades.Direccion;
import cl.lema.llanquihuetourapp.model.entidades.GuiaTuristico;
import cl.lema.llanquihuetourapp.model.entidades.Vehiculo;
import cl.lema.llanquihuetourapp.model.servicios.ServicioTuristico;
import javax.swing.*;
import java.awt.*;

/**
 * Ventana principal de la aplicación Llanquihue Tour.
 * Permite registrar guías turísticos, vehículos y colaboradores externos.
 * También permite asignar servicios turísticos a las entidades y mostrar
 * la información almacenada durante la ejecución del programa.
 *
 * @author Iván Lema
 * @version 1.1
 */
public class Grafica extends JFrame {

    /**
     * Gestor utilizado para almacenar y consultar las entidades registradas.
     */
    private GestorEntidades gestorEntidades = new GestorEntidades();

    /**
     * Gestor utilizado para obtener los servicios turísticos disponibles.
     */
    private GestorServicios gestorServicios = new GestorServicios();

    /**
     * Campo para ingresar el nombre del guía turístico.
     */
    private JTextField nombreGuia;

    /**
     * Campo para ingresar la especialidad del guía turístico.
     */
    private JTextField especialidadGuia;

    /**
     * Campo para ingresar la patente del vehículo.
     */
    private JTextField patenteVehiculo;

    /**
     * Campo para ingresar el tipo de vehículo.
     */
    private JTextField tipoVehiculo;

    /**
     * Campo para ingresar el nombre del colaborador externo.
     */
    private JTextField nombreColaborador;

    /**
     * Campo para ingresar el rol del colaborador externo.
     */
    private JTextField rolColaborador;

    /**
     * Campo para ingresar el tipo de colaborador externo.
     */
    private JTextField tipoColaborador;

    /**
     * Campo para ingresar la calle de la dirección del colaborador.
     */
    private JTextField calleColaborador;

    /**
     * Campo para ingresar la comuna de la dirección del colaborador.
     */
    private JTextField comunaColaborador;

    /**
     * Campo para ingresar la ciudad de la dirección del colaborador.
     */
    private JTextField ciudadColaborador;

    /**
     * Campo para ingresar el país de la dirección del colaborador.
     */
    private JTextField paisColaborador;

    /**
     * Administrador utilizado para cambiar entre los formularios
     * de las diferentes entidades.
     */
    private CardLayout cardLayoutForms;

    /**
     * Panel que contiene los formularios administrados mediante CardLayout.
     */
    private JPanel panelFormularios;

    /**
     * Botón utilizado para guardar la entidad seleccionada.
     */
    private JButton btnGuardar;

    /**
     * Botón utilizado para mostrar las entidades registradas.
     */
    private JButton btnMostrarInformacion;

    /**
     * Área de texto donde se muestra la información almacenada.
     */
    private JTextArea texto;

    /**
     * Nombres de los tipos de entidades que se pueden registrar.
     */
    private final String[] tiposEntidad = {
            "Guía Turístico",
            "Vehículo",
            "Colaborador Externo"
    };

    /**
     * Lista desplegable para seleccionar el tipo de entidad.
     */
    private final JComboBox<String> comboTipo = new JComboBox<>(tiposEntidad);

    /**
     * Nombres de los servicios turísticos disponibles.
     */
    private final String[] nombresServicios = gestorServicios.listarNombres();

    /**
     * Lista desplegable para seleccionar un servicio turístico.
     */
    private final JComboBox<String> comboNombresServicio =
            new JComboBox<>(nombresServicios);

    /**
     * Construye y configura la ventana principal de la aplicación.
     * Agrega los paneles y configura los eventos de los componentes.
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
     * Crea el título y las listas desplegables para seleccionar
     * el tipo de entidad y el servicio turístico.
     *
     * @return panel superior de la interfaz.
     */
    private JPanel crearPanelSuperior() {

        JPanel panelSuperior = new JPanel(new BorderLayout(0, 15));
        JLabel titulo = new JLabel("Registro de entidades");
        JPanel panelSeleccion = new JPanel(new GridLayout(0, 2, 10, 10));
        JLabel etiquetaTipo = new JLabel("Tipo de entidad:");
        JLabel etiquetaAgregarTour = new JLabel("Agregar tour:");

        panelSeleccion.add(etiquetaTipo);
        panelSeleccion.add(comboTipo);

        panelSeleccion.add(etiquetaAgregarTour);
        panelSeleccion.add(comboNombresServicio);

        panelSuperior.add(titulo, BorderLayout.NORTH);
        panelSuperior.add(panelSeleccion, BorderLayout.CENTER);

        return panelSuperior;
    }

    /**
     * Crea los campos necesarios para registrar un guía turístico.
     *
     * @return formulario de registro de guía turístico.
     */
    private JPanel crearFormularioGuia() {
        JPanel panelGuia = new JPanel(new GridLayout(0, 2, 10, 10));
        panelGuia.setBorder(BorderFactory.createTitledBorder("Datos del Guía"));

        nombreGuia = new JTextField(15);
        especialidadGuia = new JTextField(15);

        JLabel etiquetaNombre = new JLabel("Nombre:");
        JLabel etiquetaEspecialidad = new JLabel("Especialidad:");

        panelGuia.add(etiquetaNombre);
        panelGuia.add(nombreGuia);

        panelGuia.add(etiquetaEspecialidad);
        panelGuia.add(especialidadGuia);

        return panelGuia;
    }

    /**
     * Crea los campos necesarios para registrar un vehículo.
     *
     * @return formulario de registro de vehículo.
     */
    private JPanel crearFormularioVehiculo() {
        JPanel panelVehiculo = new JPanel(new GridLayout(0, 2, 10, 10));
        panelVehiculo.setBorder(
                BorderFactory.createTitledBorder("Datos del Vehículo")
        );

        patenteVehiculo = new JTextField(15);
        tipoVehiculo = new JTextField(15);

        JLabel etiquetaPatente = new JLabel("Patente:");
        JLabel etiquetaTipo = new JLabel("Tipo:");

        panelVehiculo.add(etiquetaPatente);
        panelVehiculo.add(patenteVehiculo);

        panelVehiculo.add(etiquetaTipo);
        panelVehiculo.add(tipoVehiculo);

        return panelVehiculo;
    }

    /**
     * Crea los campos necesarios para registrar un colaborador externo,
     * incluyendo sus datos personales y su dirección.
     *
     * @return formulario de registro de colaborador externo.
     */
    private JPanel crearFormularioColaborador() {

        JPanel panelColaborador =
                new JPanel(new GridLayout(0, 2, 10, 10));

        panelColaborador.setBorder(
                BorderFactory.createTitledBorder(
                        "Datos del colaborador externo"
                )
        );

        nombreColaborador = new JTextField(15);
        rolColaborador = new JTextField(15);
        tipoColaborador = new JTextField(15);
        calleColaborador = new JTextField(15);
        comunaColaborador = new JTextField(15);
        ciudadColaborador = new JTextField(15);
        paisColaborador = new JTextField(15);

        JLabel etiquetaNombreColaborador = new JLabel("Nombre:");
        JLabel etiquetaRol = new JLabel("Rol:");
        JLabel etiquetaTipoColaborador = new JLabel("Tipo:");
        JLabel etiquetaCalleColaborador = new JLabel("Calle:");
        JLabel etiquetaComunaColaborador = new JLabel("Comuna:");
        JLabel etiquetaCiudadColaborador = new JLabel("Ciudad:");
        JLabel etiquetaPaisColaborador = new JLabel("País:");

        panelColaborador.add(etiquetaNombreColaborador);
        panelColaborador.add(nombreColaborador);

        panelColaborador.add(etiquetaRol);
        panelColaborador.add(rolColaborador);

        panelColaborador.add(etiquetaTipoColaborador);
        panelColaborador.add(tipoColaborador);

        panelColaborador.add(etiquetaCalleColaborador);
        panelColaborador.add(calleColaborador);

        panelColaborador.add(etiquetaCiudadColaborador);
        panelColaborador.add(ciudadColaborador);

        panelColaborador.add(etiquetaComunaColaborador);
        panelColaborador.add(comunaColaborador);

        panelColaborador.add(etiquetaPaisColaborador);
        panelColaborador.add(paisColaborador);

        return panelColaborador;
    }

    /**
     * Crea un contenedor para mantener el formulario ubicado
     * en la parte superior del panel.
     *
     * @param formulario formulario que se mostrará dentro del contenedor.
     * @return contenedor con el formulario ubicado en la parte superior.
     */
    private JPanel crearContenedorFormulario(JPanel formulario) {
        JPanel contenedor = new JPanel(new BorderLayout());
        contenedor.add(formulario, BorderLayout.NORTH);

        return contenedor;
    }

    /**
     * Agrupa los formularios de las entidades mediante CardLayout.
     * Este diseño permite mostrar solamente un formulario a la vez.
     *
     * @return panel que contiene los formularios de registro.
     */
    private JPanel crearPanelFormularios() {
        cardLayoutForms = new CardLayout();

        panelFormularios = new JPanel(cardLayoutForms);

        panelFormularios.add(
                crearContenedorFormulario(crearFormularioGuia()),
                "Guía Turístico"
        );

        panelFormularios.add(
                crearContenedorFormulario(crearFormularioVehiculo()),
                "Vehículo"
        );

        panelFormularios.add(
                crearContenedorFormulario(crearFormularioColaborador()),
                "Colaborador Externo"
        );

        return panelFormularios;
    }

    /**
     * Crea los botones y el área destinada a mostrar
     * la información registrada.
     *
     * @return panel inferior de la interfaz.
     */
    private JPanel crearPanelInferior() {
        JPanel panelInferior = new JPanel(new BorderLayout(10, 10));
        JPanel panelBotones =
                new JPanel(new FlowLayout(FlowLayout.LEFT, 10, 5));

        btnGuardar = new JButton("Guardar");
        btnMostrarInformacion = new JButton("Mostrar Información");

        panelBotones.add(btnGuardar);
        panelBotones.add(btnMostrarInformacion);

        texto = new JTextArea(8,30);
        texto.setEditable(false);
        texto.setLineWrap(true);
        texto.setWrapStyleWord(true);

        JScrollPane scrollTexto = new JScrollPane(texto);
        scrollTexto.setBorder(
                BorderFactory.createTitledBorder("Información registrada")
        );

        panelInferior.add(panelBotones, BorderLayout.NORTH);
        panelInferior.add(scrollTexto, BorderLayout.CENTER);

        return panelInferior;
    }

    /**
     * Configura las acciones de las listas desplegables
     * y de los botones de la ventana.
     */
    private void configurarEventos() {

        comboTipo.addActionListener(e -> {

            String seleccion = (String) comboTipo.getSelectedItem();
            cardLayoutForms.show(panelFormularios, seleccion);
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
     * Revisa el tipo de entidad seleccionado y dirige el proceso
     * al método de guardado correspondiente.
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
     * Obtiene el servicio turístico seleccionado en la lista desplegable.
     *
     * @return servicio turístico seleccionado o {@code null} si no existe
     * una selección válida.
     */
    public ServicioTuristico asignarTour(){
        int indexTour = comboNombresServicio.getSelectedIndex();

        if(indexTour == -1){
            return null;
        }

        ServicioTuristico tourAsignado =
                gestorServicios.obtenerLista().get(indexTour);

        return tourAsignado;
    }

    /**
     * Valida los campos y guarda un nuevo guía turístico.
     * El servicio seleccionado es asignado al guía antes de registrarlo.
     */
    private void guardarGuia(){
        String nombre = nombreGuia.getText().trim();
        String especialidad = especialidadGuia.getText().trim();

        if(nombre.isEmpty() || especialidad.isEmpty()) {
            mostrarErrorCampoVacio();
            return;
        }

        GuiaTuristico guia = new GuiaTuristico(nombre, especialidad);
        guia.agregarServicio(asignarTour());
        gestorEntidades.agregarRegistrable(guia);
        nombreGuia.setText("");
        especialidadGuia.setText("");
        JOptionPane.showMessageDialog(
                this,
                "Guía guardado correctamente"
        );
    }

    /**
     * Valida los campos y guarda un nuevo vehículo.
     * El servicio seleccionado es asignado al vehículo antes de registrarlo.
     */
    private void guardarVehiculo(){
        String patente = patenteVehiculo.getText().trim();
        String tipo = tipoVehiculo.getText().trim();

        if(patente.isEmpty() || tipo.isEmpty()) {
            mostrarErrorCampoVacio();
            return;
        }

        Vehiculo vehiculo = new Vehiculo(patente, tipo);
        vehiculo.agregarServicio(asignarTour());
        gestorEntidades.agregarRegistrable(vehiculo);
        patenteVehiculo.setText("");
        tipoVehiculo.setText("");
        JOptionPane.showMessageDialog(
                this,
                "Vehículo guardado correctamente"
        );
    }

    /**
     * Valida los campos y guarda un nuevo colaborador externo.
     * También crea su dirección y le asigna el servicio seleccionado.
     */
    private void guardarColaborador(){
        String nombre = nombreColaborador.getText().trim();
        String rol = rolColaborador.getText().trim();
        String tipo = tipoColaborador.getText().trim();
        String pais = paisColaborador.getText().trim();
        String ciudad = ciudadColaborador.getText().trim();
        String comuna = comunaColaborador.getText().trim();
        String calle = calleColaborador.getText().trim();

        if (nombre.isEmpty() || rol.isEmpty() || tipo.isEmpty()
                || pais.isEmpty() || ciudad.isEmpty()
                || comuna.isEmpty() || calle.isEmpty()) {

            mostrarErrorCampoVacio();
            return;
        }

        ColaboradorExterno colaborador =
                new ColaboradorExterno(
                        nombre,
                        rol,
                        tipo,
                        new Direccion(pais, ciudad, comuna, calle)
                );

        colaborador.agregarServicio(asignarTour());
        gestorEntidades.agregarRegistrable(colaborador);
        nombreColaborador.setText("");
        rolColaborador.setText("");
        tipoColaborador.setText("");
        paisColaborador.setText("");
        ciudadColaborador.setText("");
        comunaColaborador.setText("");
        calleColaborador.setText("");

        JOptionPane.showMessageDialog(
                this,
                "Colaborador guardado correctamente"
        );
    }

    /**
     * Muestra un mensaje de error cuando uno o más campos
     * obligatorios se encuentran vacíos.
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