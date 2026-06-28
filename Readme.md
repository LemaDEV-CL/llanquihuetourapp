# Proyecto Llanquihue Tour App

## Autor

* Nombre: Iván Lema
* Asignatura: Desarrollo Orientado a Objetos I
* Institución: Duoc UC

## Descripción

Este proyecto fue actualizado en Java como parte de la actividad de la Semana 6 del ramo Desarrollo Orientado a Objetos I.

Semana 5- La aplicación simula un sistema básico para la agencia de turismo Llanquihue Tour. El programa lee una lista de servicioTuristicos desde un archivo de texto, transforma esos datos en objetos, los almacena en una colección `ArrayList` y muestra la información por consola.
Además, el sistema permite filtrar servicioTuristicos por tipo y asociar operadores turísticos a un servicioTuristico, aplicando conceptos básicos de Programación Orientada a Objetos.

Semana 6 - La aplicación se actualiza con el objetivo de agregar una super clase junto con sub clases para la práctica y aprendizaje del concepto herencia.

## Objetivo del proyecto

El objetivo principal es practicar conceptos básicos de Java y Programación Orientada a Objetos, tales como:

* Crear clases.
* Crear subclases
* Crear objetos.
* Usar atributos privados.
* Usar constructores.
* Usar métodos get y set.
* Usar el método `toString()`.
* Aplicar composición entre clases.
* Aplicar los fundamentos de herencia y polimorfismo
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
        │               │   └── GestorServicios.java
        │               ├── model/
        │               │   ├── Direccion.java
        │               │   ├── Operador.java
        │               │   └── ServicioTuristico.java
        │               │   └── ExcursionCultural.java
        │               │   └── PaseoLacustre.java
        │               │   └── RutaGastronomica.java                        
        │               └── ui/
        │                   └── Main.java
        └── resources/
            └── tours.txt
```

## Paquetes del proyecto

### `model`

Contiene las clases que representan los objetos principales del sistema.

Clases:

* `ServicioTuristico`
* `Operador`
* `Direccion`
* `ExcursionCultural`
* `PaseoLacustre`
* `RutaGastronomica`

### `data`

Contiene la clase encargada de leer y gestionar los datos provenientes del archivo de texto.

Clase:

* `GestorServicios`

### `ui`

Contiene la clase principal desde donde se ejecuta el programa.

Clase:

* `Main`

## Clases del proyecto

### `ServicioTuristico`

La clase `ServicioTuristico` representa un servicio turístico de Llanquihue Tour como clase padre.

Contiene los siguientes datos:

* Nombre del servicioTuristico.
* Duración del servicioTuristico.
* Tipo de servicioTuristico.
* Precio del servicioTuristico.
* Lista de operadores asociados.

También incluye constructores, métodos get y set, método `toString()` y un método para agregar operadores al servicioTuristico.

### `Operador`

La clase `Operador` representa a una persona o empresa que participa en la ejecución de un servicioTuristico.

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

### `GestorServicios`

La clase `GestorServicios` se encarga de leer el archivo `tours.txt`.

Sus principales funciones son:

* Leer el archivo de texto línea por línea.
* Separar los datos usando `split(";")`.
* Crear objetos de tipo `ServicioTuristico`.
* Agregar los servicioTuristicos a un `ArrayList`.
* Obtener la lista completa de servicioTuristicos.
* Filtrar servicioTuristicos según su tipo.
* Mostrar los resultados filtrados por consola.
* Crear una lista de servicios de las clases hijas heredadas de ServicioTuristico

### `Main`

La clase `Main` es la clase principal del programa.

Desde esta clase se ejecuta la aplicación. En ella se crea un objeto de `GestorServicios`, 
se carga la lista de servicioTuristicos, se muestran los datos por consola, 
se aplica un filtro por tipo y se realiza un ejemplo de asignación de operadores a un servicioTuristico.
Se agregan ejemplos de lectura en consola para objetos creados a partir de las clases hijas heredadas de ServicioTuristico.

## Archivo de datos

El archivo `tours.txt` se encuentra en la carpeta:

```text
src/main/resources/tours.txt
```

Cada línea del archivo tiene la siguiente estructura:

```text
nombre;duracionHoras;tipo;precio
```

Ejemplo:

```text
Gastronomía Local;6;Gastronómico;48000
```

El programa separa los datos usando el punto y coma `;`.

## Funcionamiento del programa

Cuando se ejecuta el programa:

1. Se crea un objeto de la clase `GestorServicios`.
2. Se lee el archivo `tours.txt`.
3. Se crea un objeto `ServicioTuristico` por cada línea del archivo.
4. Cada servicioTuristico se agrega a un `ArrayList`.
5. Se muestra la lista completa de servicioTuristicos por consola.
6. Se filtran los servicioTuristicos según un tipo indicado.
7. Se muestra el resultado filtrado en consola.
8. Se crean operadores de ejemplo.
9. Se agregan operadores a un servicioTuristico.
10. Se muestra información del servicioTuristico y sus operadores asociados.
11. Se crean nuevos servicios turisticos de las clases creadas ExcursionCultural, PaseoLacustre y RutaGastronomica a través del método crearServicio();
12. Se agregan operadores a las instancias
13. Se muestran en consola

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
Semana 6 - Proyecto actualizado para la práctica y aprendizaje de los fundamentos de herencia y polimorfismo.
