# Proyecto Llanquihue Tour App

## Autor

* Nombre: Iván Lema
* Asignatura: Desarrollo Orientado a Objetos I
* Institución: Duoc UC

## Descripción

Este proyecto fue creado en Java como parte de una actividad del ramo de Programación Orientada a Objetos.

La idea del programa es leer una lista de tours desde un archivo de texto y mostrar esos datos por consola. También se realiza un filtro por tipo de tour, por ejemplo, para mostrar solo los tours de tipo gastronómico.

## Objetivo del proyecto

El objetivo principal es practicar conceptos básicos de Java y programación orientada a objetos, como:

* Crear clases.
* Crear objetos.
* Usar atributos privados.
* Usar constructores.
* Usar métodos get y set.
* Usar ArrayList.
* Leer datos desde un archivo `.txt`.
* Recorrer una lista con un ciclo `for`.
* Filtrar datos según una palabra.
* Mostrar información por consola.

## Estructura del proyecto

El proyecto está organizado en paquetes:

```text
src/
└── main/
    ├── java/
    │   └── cl/
    │       └── lema/
    │           └── llanquihuetourapp/
    │               ├── data/
    │               │   └── GestorDatos.java
    │               ├── model/
    │               │   └── Tour.java
    │               └── ui/
    │                   └── Main.java
    └── resources/
        └── tours.txt
```

## Clases del proyecto

### Tour

La clase `Tour` representa un tour turístico.

Tiene los siguientes datos:

* Nombre del tour.
* Tipo de tour.
* Precio del tour.

También tiene sus constructores, métodos get y set, y el método `toString()` para mostrar la información por consola.

### GestorDatos

La clase `GestorDatos` se encarga de leer el archivo `tours.txt`.

Desde esta clase se genera una lista de tours usando `ArrayList`.

También tiene un método para filtrar los tours según su tipo.

### Main

La clase `Main` es la clase principal del programa.

Desde esta clase se crea un objeto de `GestorDatos`, se muestra la lista completa de tours y luego se muestra una lista filtrada por tipo.

## Archivo de datos

El archivo `tours.txt` contiene los datos de los tours.

Cada línea tiene la siguiente estructura:

```text
nombre;tipo;precio
```

Ejemplo:

```text
Gastronomía Local;Gastronómico;48000
```

El programa separa esos datos usando el punto y coma `;`.

## Funcionamiento del programa

Cuando se ejecuta el programa:

1. Se lee el archivo `tours.txt`.
2. Se crea un objeto `Tour` por cada línea del archivo.
3. Cada objeto se agrega a un `ArrayList`.
4. Se muestra la lista completa de tours.
5. Se filtran los tours por tipo.
6. Se muestra el resultado filtrado en consola.

## Instrucciones para ejecutar

1. Abrir el proyecto en IntelliJ IDEA.
2. Revisar que el archivo `tours.txt` esté en la carpeta `resources`.
3. Abrir la clase `Main.java`.
4. Ejecutar el método `main`.
5. Revisar los resultados en la consola.

## Tecnologías utilizadas

* Java
* IntelliJ IDEA

## Estado del proyecto

Proyecto básico realizado para practicar lectura de archivos, creación de objetos, uso de listas y filtros simples en Java.
