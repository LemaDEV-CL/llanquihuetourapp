# Proyecto Llanquihue Tour App

## Autor

* Nombre: Iván Lema
* Asignatura: Desarrollo Orientado a Objetos I
* Institución: Duoc UC

## Descripción del proyecto

Este proyecto corresponde al caso **Llanquihue Tour**, trabajado durante el ramo Desarrollo Orientado a Objetos I.

En las semanas anteriores se comenzó creando una aplicación básica para leer tours desde un archivo de texto, guardar datos en listas y mostrar información por consola.

En la semana 6 se agregó una jerarquía de clases usando herencia, creando una clase padre llamada `ServicioTuristico` y clases hijas para representar distintos tipos de servicios.

En la semana 7 se mantiene esa jerarquía y se agrega el uso de polimorfismo, usando una colección de tipo `ServicioTuristico` donde se guardan objetos de distintas subclases. Luego, desde el `Main`, se recorre la lista y cada objeto muestra su información usando el método `mostrarInformacion()`.

## Objetivo de la semana 7

El objetivo principal de esta semana es practicar el uso de polimorfismo en Java.

Para eso se trabajó con una clase padre y varias clases hijas. Todas las clases hijas sobrescriben el método `mostrarInformacion()`, pero cada una muestra datos distintos según el tipo de servicio turístico.

También se usa una lista de tipo `ServicioTuristico`, donde se agregan servicios de diferentes subclases como rutas gastronómicas, paseos lacustres y excursiones culturales.

## Conceptos aplicados

En este proyecto se aplican los siguientes conceptos:

* Clases y objetos.
* Atributos privados.
* Constructores.
* Métodos get y set.
* Composición entre clases.
* Herencia.
* Uso de `extends`.
* Uso de `super(...)`.
* Sobrescritura de métodos con `@Override`.
* Polimorfismo.
* Uso de listas con `List` y `ArrayList`.
* Recorrido de listas con `for-each`.
* Organización del proyecto en paquetes.
* Salida de información por consola.

## Estructura del proyecto

El proyecto está organizado en paquetes para separar mejor las responsabilidades de cada clase.

```text
LlanquihueTourApp/
├── pom.xml
├── Readme.md
└── src/
    └── main/
        ├── java/
        │   └── cl/
        │       └── lema/
        │           └── llanquihuetourapp/
        │               ├── data/
        │               │   └── GestorServicios.java
        │               ├── model/
        │               │   ├── Direccion.java
        │               │   ├── Operador.java
        │               │   ├── ServicioTuristico.java
        │               │   ├── RutaGastronomica.java
        │               │   ├── PaseoLacustre.java
        │               │   └── ExcursionCultural.java
        │               └── ui/
        │                   └── Main.java
        └── resources/
            └── tours.txt
```

## Paquetes del proyecto

### `model`

Contiene las clases principales del sistema.

En este paquete están las clases que representan los servicios turísticos, operadores y direcciones.

Clases:

* `ServicioTuristico`
* `RutaGastronomica`
* `PaseoLacustre`
* `ExcursionCultural`
* `Operador`
* `Direccion`

### `data`

Contiene la clase encargada de crear y gestionar los servicios turísticos.

Clase:

* `GestorServicios`

### `ui`

Contiene la clase principal desde donde se ejecuta el programa.

Clase:

* `Main`

## Clases principales

### `ServicioTuristico`

Es la clase padre o superclase del proyecto.

Representa un servicio turístico general de Llanquihue Tour.

Contiene datos comunes como:

* Nombre.
* Duración en horas.
* Tipo.
* Precio.
* Lista de operadores asociados.

También tiene el método `mostrarInformacion()`, que muestra los datos generales del servicio turístico.

### `RutaGastronomica`

Es una subclase que hereda de `ServicioTuristico`.

Representa un servicio turístico de tipo gastronómico.

Además de los datos heredados desde `ServicioTuristico`, agrega el atributo:

* `numeroParadas`

Esta clase sobrescribe el método `mostrarInformacion()` para mostrar también la cantidad de paradas de la ruta.

### `PaseoLacustre`

Es una subclase que hereda de `ServicioTuristico`.

Representa un paseo relacionado con lagos o navegación.

Además de los datos heredados desde `ServicioTuristico`, agrega el atributo:

* `tipoEmbarcacion`

Esta clase sobrescribe el método `mostrarInformacion()` para mostrar también el tipo de embarcación utilizada.

### `ExcursionCultural`

Es una subclase que hereda de `ServicioTuristico`.

Representa una excursión cultural.

Además de los datos heredados desde `ServicioTuristico`, agrega el atributo:

* `lugarHistorico`

Esta clase sobrescribe el método `mostrarInformacion()` para mostrar también el lugar histórico relacionado con la excursión.

### `Operador`

Representa a una persona o empresa que participa en un servicio turístico.

Puede ser, por ejemplo:

* Transporte.
* Alimentación.
* Guía turístico.

Esta clase usa composición porque tiene un objeto de tipo `Direccion`.

### `Direccion`

Representa los datos de ubicación de un operador.

Contiene:

* Calle.
* Comuna.
* Ciudad.

### `GestorServicios`

Esta clase se encarga de gestionar los servicios del proyecto.

Actualmente tiene métodos para:

* Cargar servicios desde el archivo `tours.txt`.
* Obtener la lista de servicios.
* Filtrar servicios por tipo.
* Crear servicios de prueba para demostrar herencia y polimorfismo.

Para la semana 7, el método más importante es `crearServicios()`, ya que ahí se crean objetos de distintas subclases y se agregan a una lista de tipo `ServicioTuristico`.

### `Main`

Es la clase principal del programa.

En esta clase se crea un objeto de `GestorServicios`, se obtiene una lista de servicios turísticos y se recorre la lista con un ciclo `for-each`.

Aunque la lista está declarada como `List<ServicioTuristico>`, dentro de ella hay objetos de distintas clases hijas:

* `RutaGastronomica`
* `PaseoLacustre`
* `ExcursionCultural`

Al llamar al método `mostrarInformacion()`, cada objeto muestra su propia información. Esto permite demostrar el uso básico de polimorfismo.

## Funcionamiento del programa

Al ejecutar el programa:

1. Se crea un objeto de la clase `GestorServicios`.
2. Se llama al método `crearServicios()`.
3. Se crean servicios turísticos de distintos tipos.
4. Se agregan operadores a algunos servicios.
5. Se recorre la lista de servicios usando `for-each`.
6. Se llama al método `mostrarInformacion()` desde una referencia de tipo `ServicioTuristico`.
7. Cada subclase muestra su información correspondiente en consola.

## Ejemplo del uso de polimorfismo

En el programa se usa una lista declarada de esta forma:

```java
List<ServicioTuristico> servicios = gestor.crearServicios();
```

En esa lista se guardan distintos tipos de servicios turísticos.

Luego se recorre con:

```java
for (ServicioTuristico servicioTuristico : servicios) {
    servicioTuristico.mostrarInformacion();
}
```

Aunque todos se recorren como `ServicioTuristico`, cada objeto ejecuta su propio método `mostrarInformacion()` según la clase real a la que pertenece.

Esto permite aplicar polimorfismo de forma básica.

## Archivo de datos

El archivo `tours.txt` se encuentra en:

```text
src/main/resources/tours.txt
```

Este archivo se mantiene desde las semanas anteriores, donde se trabajó lectura de datos desde archivo de texto.

Para la semana 7, el foco principal está en la creación de servicios de prueba desde `GestorServicios`, para mostrar herencia y polimorfismo.

## Cómo ejecutar el proyecto

1. Abrir el proyecto en IntelliJ IDEA.
2. Verificar que el proyecto cargue correctamente con Maven.
3. Abrir la clase `Main.java`, ubicada en:

```text
src/main/java/cl/lema/llanquihuetourapp/ui/Main.java
```

4. Ejecutar el método `main`.
5. Revisar la salida en consola.

## Qué se muestra en consola

Al ejecutar el programa se muestra información de distintos servicios turísticos, como:

* Rutas gastronómicas.
* Paseos lacustres.
* Excursiones culturales.
* Operadores asociados a algunos servicios.

Cada servicio muestra sus datos generales y también su dato específico según la subclase correspondiente.

## Tecnologías utilizadas

* Java.
* IntelliJ IDEA.
* Maven.
* Archivo de texto `.txt`.

## Estado del proyecto

Proyecto actualizado hasta la semana 7 del ramo Desarrollo Orientado a Objetos I.

En esta versión se mantiene lo trabajado anteriormente y se agrega el uso de herencia y polimorfismo mediante una jerarquía de servicios turísticos.
