# Proyecto Llanquihue Tour App

## Autor

* Nombre: Iván Lema
* Asignatura: Desarrollo Orientado a Objetos I
* Institución: Duoc UC

## Descripción

Este proyecto fue creado en Java como parte de la actividad de la Semana 5 del ramo Desarrollo Orientado a Objetos I.

La aplicación simula un sistema básico para la agencia de turismo Llanquihue Tour. El programa lee una lista de tours desde un archivo de texto, transforma esos datos en objetos, los almacena en una colección `ArrayList` y muestra la información por consola.

Además, el sistema permite filtrar tours por tipo y asociar operadores turísticos a un tour, aplicando conceptos básicos de Programación Orientada a Objetos.

## Objetivo del proyecto

El objetivo principal es practicar conceptos básicos de Java y Programación Orientada a Objetos, tales como:

* Crear clases.
* Crear objetos.
* Usar atributos privados.
* Usar constructores.
* Usar métodos get y set.
* Usar el método `toString()`.
* Aplicar composición entre clases.
* Usar `ArrayList`.
* Leer datos desde un archivo `.txt`.
* Recorrer una lista de objetos.
* Filtrar datos según una palabra.
* Mostrar información por consola.
* Organizar el proyecto en paquetes.

## Estructura del proyecto

El proyecto está organizado en paquetes según la responsabilidad de cada clase:

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
        │               │   └── GestorDatos.java
        │               ├── model/
        │               │   ├── Direccion.java
        │               │   ├── Operador.java
        │               │   └── Tour.java
        │               └── ui/
        │                   └── Main.java
        └── resources/
            └── tours.txt
```

## Paquetes del proyecto

### `model`

Contiene las clases que representan los objetos principales del sistema.

Clases:

* `Tour`
* `Operador`
* `Direccion`

### `data`

Contiene la clase encargada de leer y gestionar los datos provenientes del archivo de texto.

Clase:

* `GestorDatos`

### `ui`

Contiene la clase principal desde donde se ejecuta el programa.

Clase:

* `Main`

## Clases del proyecto

### `Tour`

La clase `Tour` representa un servicio turístico de Llanquihue Tour.

Contiene los siguientes datos:

* Nombre del tour.
* Tipo de tour.
* Precio del tour.
* Lista de operadores asociados.

También incluye constructores, métodos get y set, método `toString()` y un método para agregar operadores al tour.

### `Operador`

La clase `Operador` representa a una persona o empresa que participa en la ejecución de un tour.

Puede representar, por ejemplo:

* Transporte.
* Alimentación.
* Guía turístico.
* Otro proveedor relacionado al servicio.

Contiene los siguientes datos:

* Nombre del operador.
* Tipo de operador.
* Dirección del operador.

Esta clase aplica composición, ya que contiene un objeto de tipo `Direccion`.

### `Direccion`

La clase `Direccion` representa la ubicación asociada a un operador.

Contiene los siguientes datos:

* Calle.
* Comuna.
* Ciudad.

Esta clase permite separar la información de dirección en una clase propia, aplicando organización y reutilización de código.

### `GestorDatos`

La clase `GestorDatos` se encarga de leer el archivo `tours.txt`.

Sus principales funciones son:

* Leer el archivo de texto línea por línea.
* Separar los datos usando `split(";")`.
* Crear objetos de tipo `Tour`.
* Agregar los tours a un `ArrayList`.
* Obtener la lista completa de tours.
* Filtrar tours según su tipo.
* Mostrar los resultados filtrados por consola.

### `Main`

La clase `Main` es la clase principal del programa.

Desde esta clase se ejecuta la aplicación. En ella se crea un objeto de `GestorDatos`, se carga la lista de tours, se muestran los datos por consola, se aplica un filtro por tipo y se realiza un ejemplo de asignación de operadores a un tour.

## Archivo de datos

El archivo `tours.txt` se encuentra en la carpeta:

```text
src/main/resources/tours.txt
```

Cada línea del archivo tiene la siguiente estructura:

```text
nombre;tipo;precio
```

Ejemplo:

```text
Gastronomía Local;Gastronómico;48000
```

El programa separa los datos usando el punto y coma `;`.

## Funcionamiento del programa

Cuando se ejecuta el programa:

1. Se crea un objeto de la clase `GestorDatos`.
2. Se lee el archivo `tours.txt`.
3. Se crea un objeto `Tour` por cada línea del archivo.
4. Cada tour se agrega a un `ArrayList`.
5. Se muestra la lista completa de tours por consola.
6. Se filtran los tours según un tipo indicado.
7. Se muestra el resultado filtrado en consola.
8. Se crean operadores de ejemplo.
9. Se agregan operadores a un tour.
10. Se muestra información del tour y sus operadores asociados.

## Instrucciones para ejecutar

1. Abrir el proyecto en IntelliJ IDEA.
2. Verificar que el archivo `tours.txt` esté en la carpeta:

```text
src/main/resources/
```

3. Abrir la clase `Main.java`, ubicada en:

```text
src/main/java/cl/lema/llanquihuetourapp/ui/Main.java
```

4. Ejecutar el método `main`.
5. Revisar los resultados en la consola.

## Tecnologías utilizadas

* Java
* IntelliJ IDEA
* Maven
* Archivo de texto `.txt`

## Estado del proyecto

Proyecto básico realizado para practicar Programación Orientada a Objetos en Java, lectura de archivos, creación de objetos, uso de colecciones, filtros simples, composición entre clases y organización modular del código.
