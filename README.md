# Llanquihue Tour App

## Autor

- **Nombre:** Iván Lema
- **Asignatura:** Desarrollo Orientado a Objetos I
- **Institución:** Duoc UC
- **Semana:** 9 - Evaluación Final Transversal

## Descripción

Llanquihue Tour App es un prototipo desarrollado en Java para organizar parte de la operación de una agencia de turismo.

La aplicación permite registrar distintos proveedores necesarios para realizar los tours:

- Guías turísticos.
- Vehículos.
- Colaboradores externos.

Los tours se cargan desde un archivo de texto y se muestran en una lista desplegable. Al registrar un proveedor, se le asigna el tour seleccionado y la información queda almacenada durante la ejecución del programa.

## Funcionalidades principales

- Carga servicios turísticos desde `tours.txt` utilizando el classpath.
- Convierte cada línea válida del archivo en un objeto `ServicioTuristico`.
- Controla líneas vacías, datos incompletos y errores de conversión numérica.
- Registra guías, vehículos y colaboradores externos desde una interfaz Swing.
- Cambia entre formularios mediante `CardLayout`.
- Asigna un tour al proveedor registrado.
- Guarda distintas entidades en una colección común de tipo `List<Registrable>`.
- Recorre la colección y muestra un resumen de los registros.
- Permite filtrar servicios por su tipo desde `GestorServicios`.

## Conceptos aplicados

- Clases y objetos.
- Encapsulamiento.
- Constructores, getters y setters.
- Composición mediante la clase `Direccion`.
- Agregación entre proveedores y servicios turísticos.
- Herencia con `ServicioTuristico` y sus subclases.
- Sobrescritura de métodos con `@Override`.
- Interfaces mediante `Registrable`.
- Polimorfismo con `List<Registrable>`.
- Uso de `instanceof`.
- Colecciones con `List` y `ArrayList`.
- Lectura de archivos con `BufferedReader`.
- Manejo de errores con `try-catch`.
- Excepción personalizada `DatoInvalidoException`.
- Interfaz gráfica con Java Swing.

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
        │       ├── excepciones/
        │       │   └── DatoInvalidoException.java
        │       ├── gui/
        │       │   └── Grafica.java
        │       ├── model/
        │       │   ├── entidades/
        │       │   │   ├── Registrable.java
        │       │   │   ├── GuiaTuristico.java
        │       │   │   ├── Vehiculo.java
        │       │   │   ├── ColaboradorExterno.java
        │       │   │   └── Direccion.java
        │       │   └── servicios/
        │       │       ├── ServicioTuristico.java
        │       │       ├── RutaGastronomica.java
        │       │       ├── PaseoLacustre.java
        │       │       └── ExcursionCultural.java
        │       └── ui/
        │           └── Main.java
        └── resources/
            └── tours.txt
```

## Clases principales

### `GestorServicios`

Lee el archivo `tours.txt`, valida sus líneas, crea los objetos turísticos y permite obtener o filtrar los servicios cargados.

### `GestorEntidades`

Administra una colección de objetos `Registrable`, agrega nuevos registros y genera el resumen que se muestra en la interfaz.

### `Grafica`

Construye la ventana principal, cambia entre los formularios y conecta los botones con la lógica de guardado y consulta.

### `Registrable`

Define el método común `mostrarResumen()`, implementado por los proveedores del sistema.

### `GuiaTuristico`, `Vehiculo` y `ColaboradorExterno`

Representan a los proveedores que pueden ser registrados y asociados a un servicio turístico.

### `ServicioTuristico`

Representa los datos principales de un tour. Es la superclase de `RutaGastronomica`, `PaseoLacustre` y `ExcursionCultural`.

### `Direccion`

Agrupa los datos de ubicación utilizados por `ColaboradorExterno`.

## Formato del archivo de tours

Cada línea de `tours.txt` debe contener cuatro datos separados por punto y coma:

```text
nombre;duracionHoras;tipo;precio
```

Ejemplo:

```text
Ruta de los Volcanes;4;Aventura;85000
```

Las líneas vacías, incompletas o con números inválidos se omiten para que la carga pueda continuar.

## Cómo clonar el proyecto

```bash
git clone https://github.com/LemaDEV-CL/llanquihuetourapp.git
cd llanquihuetourapp
```

## Cómo ejecutar el proyecto

### Desde IntelliJ IDEA

1. Abrir la carpeta del proyecto.
2. Esperar que IntelliJ reconozca el proyecto Maven.
3. Abrir la clase:

```text
src/main/java/cl/lema/llanquihuetourapp/ui/Main.java
```

4. Ejecutar el método `main()`.
5. Seleccionar una entidad y un tour.
6. Completar los campos y presionar **Guardar**.
7. Presionar **Mostrar Información** para revisar los registros.

## Consideraciones

- Los proveedores registrados se mantienen solo mientras la aplicación está abierta.
- Actualmente se muestra el primer tour asignado a cada proveedor.
- La colección de servicios permite ampliar el proyecto para manejar más tours por proveedor en una futura versión.
- Este proyecto corresponde a un prototipo académico y no a un sistema comercial terminado.
