# Llanquihue Tour App

## Autor

- **Nombre:** Iván Lema
- **Asignatura:** Desarrollo Orientado a Objetos I
- **Institución:** Duoc UC
- **Semana:** 8

## Descripción

Llanquihue Tour App es un proyecto desarrollado durante el ramo para practicar programación orientada a objetos en Java.

En las primeras etapas se trabajó con servicios turísticos, lectura de archivos, herencia y polimorfismo. En esta actualización se incorpora una interfaz común llamada `Registrable`, una colección que permite administrar distintos tipos de entidades y una interfaz gráfica creada con Swing.

La aplicación permite registrar:

- Guías turísticos.
- Vehículos.
- Colaboradores externos.

Los registros se mantienen durante la ejecución del programa y pueden visualizarse desde la misma ventana.

## Objetivo de la semana 8

El objetivo es integrar interfaces, polimorfismo, colecciones genéricas, validación de tipos con `instanceof` y una interfaz gráfica básica.

Para esto, las clases `GuiaTuristico`, `Vehiculo` y `ColaboradorExterno` implementan la interfaz `Registrable`. Sus objetos se guardan en una colección de tipo `List<Registrable>` dentro de `GestorEntidades`.

## Conceptos aplicados

- Clases y objetos.
- Encapsulamiento mediante atributos, getters y setters.
- Constructores.
- Herencia con `extends`.
- Sobrescritura con `@Override`.
- Interfaces con `implements`.
- Polimorfismo.
- Colecciones con `List` y `ArrayList`.
- Recorrido de colecciones con `for-each`.
- Identificación de objetos con `instanceof`.
- Manejo básico de archivos con `BufferedReader`.
- Manejo básico de errores con `try-catch` y validación de campos.
- Interfaz gráfica con Swing.
- Uso de `JFrame`, `JPanel`, `JComboBox`, `JTextField`, `JButton`, `JTextArea` y `JOptionPane`.
- Uso de `BorderLayout`, `GridLayout`, `FlowLayout` y `CardLayout`.

## Estructura del proyecto

```text
LlanquihueTourApp/
├── pom.xml
├── README.md
└── src/
    └── main/
        ├── java/
        │   └── cl/lema/llanquihuetourapp/
        │       ├── data/
        │       │   ├── GestorEntidades.java
        │       │   └── GestorServicios.java
        │       ├── gui/
        │       │   └── Grafica.java
        │       ├── model/
        │       │   ├── Registrable.java
        │       │   ├── GuiaTuristico.java
        │       │   ├── Vehiculo.java
        │       │   ├── ColaboradorExterno.java
        │       │   ├── ServicioTuristico.java
        │       │   ├── RutaGastronomica.java
        │       │   ├── PaseoLacustre.java
        │       │   └── ExcursionCultural.java
        │       └── ui/
        │           └── Main.java
        └── resources/
            └── tours.txt
```

## Paquetes principales

### `model`

Contiene las clases que representan los datos del sistema.

- `Registrable`: define el método común `mostrarResumen()`.
- `GuiaTuristico`: almacena nombre y especialidad.
- `Vehiculo`: almacena patente y tipo.
- `ColaboradorExterno`: almacena nombre y rol.
- `ServicioTuristico`: superclase utilizada en las etapas anteriores.
- `RutaGastronomica`, `PaseoLacustre` y `ExcursionCultural`: subclases de `ServicioTuristico`.

### `data`

Contiene las clases que administran la información.

- `GestorEntidades`: guarda objetos de tipo `Registrable`, recorre la colección y utiliza `instanceof` para diferenciarlos.
- `GestorServicios`: mantiene la lectura y gestión de los servicios turísticos desarrollados anteriormente.

### `gui`

Contiene la ventana principal del sistema.

- `Grafica`: permite seleccionar una entidad, ingresar sus datos, guardarla y mostrar los registros creados.

### `ui`

Contiene el punto de entrada de la aplicación.

- `Main`: inicia la ventana de Swing mediante `SwingUtilities.invokeLater()`.

## Funcionamiento

1. El programa inicia desde la clase `Main`.
2. Se crea y muestra la ventana `Grafica`.
3. El usuario selecciona un tipo de entidad desde el `JComboBox`.
4. `CardLayout` muestra el formulario correspondiente.
5. Al presionar **Guardar**, se validan los campos obligatorios.
6. Se crea un objeto de la clase seleccionada.
7. El objeto se agrega a `GestorEntidades` como tipo `Registrable`.
8. Al presionar **Mostrar Información**, se recorre la colección y se genera un resumen de los registros.

## Validaciones actuales

- No permite guardar una entidad si alguno de sus campos está vacío.
- Informa mediante `JOptionPane` cuando faltan datos.
- Muestra un mensaje cuando todavía no existen registros.
- La lectura del archivo de tours controla errores de acceso mediante `IOException`.

## Ejecución

### Desde IntelliJ IDEA

1. Abrir el proyecto `LlanquihueTourApp`.
2. Esperar que IntelliJ cargue la configuración Maven.
3. Abrir la clase:

```text
src/main/java/cl/lema/llanquihuetourapp/ui/Main.java
```

4. Ejecutar el método `main()`.
5. Registrar entidades desde la ventana y utilizar el botón **Mostrar Información** para revisar los resultados.

## Consideraciones

- Los registros se almacenan solo mientras el programa está abierto.
- No se utiliza una base de datos ni persistencia permanente.
- El proyecto mantiene las clases desarrolladas en semanas anteriores para mostrar su evolución durante el ramo.
