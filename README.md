[![Review Assignment Due Date](https://classroom.github.com/assets/deadline-readme-button-22041afd0340ce965d47ae6ef1cefeee28c7c493a6346c4f15d667ab976d596c.svg)](https://classroom.github.com/a/SiO4G04Z)
# Estructura de trabajo

Este proyecto es una aplicación de consola desarrollada en Java que procesa datos de eventos sísmicos del Perú y genera estadísticas útiles. La aplicación permite visualizar y exportar reportes en formato ASCII basados en diferentes criterios.

## Objetivo

Desarrollar una aplicación utilizando el lenguaje de programación Java y el paradigma de orientación a objetos.

## Consideraciones Generales

- Cada equipo estará conformado por tres (3) integrantes.
- Cada equipo deberá designar un líder.
- El trabajo final será entregado por los líderes de equipo en la plataforma virtual de aprendizaje.
- Se entregará el código fuente del proyecto en GITHUB.

## Consideraciones Técnicas

- **IDE**: Java With Ant
- **JDK**: Java JDK 17 o superior
- **Tipo de aplicación**: Aplicación de consola
- Se deben aplicar los conceptos de programación orientada a objetos, estructuras de datos y manejo de archivos.
- El código fuente debe estar debidamente comentado e incluir los autores en los comentarios.

## Entregables

- Informe de trabajo final (UPT CLASS y GITHUB en PDF).
- Proyecto de Java (Github).
- Diapositivas de presentación (UPT CLASS y GITHUB en PDF).

## Presentación

La sustentación tendrá lugar en la Semana 18.

- **Parte 1: Exposición**: Durará 10 minutos (todos los integrantes del grupo exponen. La nota de exposición es individual).
- **Parte 2: Preguntas del docente**: Duración variable. El docente preguntará sobre el código fuente y la lógica del programa.

## Estructura del Informe

1. **Carátula**
   - Facultad, carrera, curso, título del trabajo, ciclo, integrantes del equipo, docente, sede, año y el logo de UTP.
2. **Índice**
3. **Capítulo 1: Aspectos Generales**
   - Descripción del problema.
   - Objetivos del sistema.
4. **Capítulo 2: Diseño de la Aplicación**
   - Descripción de los módulos.

| # | Nombre del módulo | Funcionalidades del módulo |
|---|-------------------|----------------------------|
| 1 |                   |                            |
| 2 |                   |                            |

   - Opciones del menú principal y lo que realiza cada una:

| # | Opción del menú | Descripción del menú |
|---|-----------------|----------------------|
| 1 |                 |                      |
| 2 |                 |                      |

   - Diseño de las clases.
     - Diagrama de clases y descripción de las funcionalidades de sus métodos.
     - Esquema:
       - **Paquete**: `<nombre del paquete>`
       - **Clase**: `<nombre de la clase>`
       - **Atributos**:

| Atributo | Descripción |
|----------|-------------|
|          |             |
|          |             |

       - **Métodos**:

| Método   | Descripción |
|----------|-------------|
|          |             |
|          |             |

5. **Conclusiones**
6. **Recomendaciones**
7. **Bibliografía**

## Proyecto: Estrucctura del proyecto ( proyecto de ejemplo)

La plataforma de datos abiertos del gobierno del Perú ([https://www.datosabiertos.gob.pe/](https://www.datosabiertos.gob.pe/)) pone a disposición de la ciudadanía diversas bases de datos de interés público. Estas bases de datos son de libre acceso y se encuentran generalmente en formatos de fácil procesamiento (.xls, .xlsx, .txt, .csv, etc.). De esta fuente de datos se ha obtenido la base de datos “Catálogo Sísmico del Perú” el cual contiene información de eventos sísmicos desde el año 1960 al 2021.

El archivo que se proporciona está en formato .csv y contiene 22712 registros.

### Los datos de cada registro son:

- **ID**: Número entero correlativo.
- **FECHA_UTC**: Fecha sin formato (ejemplo: 19600113 → 13/01/1960).
- **HORA_UTC**: Hora sin formato (ejemplo: 154034 → 15:40:34).
- **LATITUD**: Valor decimal positivo o negativo.
- **LONGITUD**: Valor decimal positivo o negativo.
- **PROFUNDIDAD**: Numérico entero.
- **MAGNITUD**: Valor decimal.

La aplicación cargará los datos del archivo proporcionado y deberá ofrecer las siguientes opciones de procesamiento estadístico al usuario:

- Tabla con el número de eventos sísmicos por año dado un rango de años.
- Tabla con el número de eventos sísmicos por mes dado un año.
- Tabla con el número de eventos sísmicos por mes dados un rango de magnitudes y un año.
- Tabla con el número de eventos sísmicos por cada hora dado un año.

Todos los cuadros mostrados al usuario en pantalla serán reportes ASCII debidamente formateados. Luego de mostrar el reporte solicitado, debe consultarse al usuario si desea exportarlo. La exportación deberá crear un archivo con los mismos datos mostrados en pantalla y dispuestos con el mismo formato. Deberá incluirse además en el archivo el título del reporte.

### Ejemplo de Reporte ASCII:

Reporte B: Tabla con el número de eventos sísmicos por mes dado un año.
(en este caso los datos corresponden al año 2020)

| Nº  | MES        | FREC | PORC  |
|-----|------------|------|-------|
| 01  | ENERO      | 73   | 9.03% |
| 02  | FEBRERO    | 67   | 8.29% |
| 03  | MARZO      | 68   | 8.42% |
| 04  | ABRIL      | 90   | 11.14%|
| 05  | MAYO       | 99   | 12.25%|
| 06  | JUNIO      | 49   | 6.06% |
| 07  | JULIO      | 51   | 6.31% |
| 08  | AGOSTO     | 60   | 7.43% |
| 09  | SETIEMBRE  | 48   | 5.94% |
| 10  | OCTUBRE    | 66   | 8.17% |
| 11  | NOVIEMBRE  | 70   | 8.66% |
| 12  | DICIEMBRE  | 67   | 8.29% |
|-----|------------|------|-------|
|     | **TOTAL**  | 808  | 100.00%|


## Acceso al Sistema

El usuario debe ingresar sus credenciales para tener acceso a la aplicación. El usuario tiene tres intentos para iniciar sesión. Un intento de sesión fallido debe mostrar un mensaje de error y el número del intento. Las credenciales (usuarios y contraseñas) serán leídas de un archivo de texto plano `usuarios.txt`.

## Menú Principal

MENU PRINCIPAL

- Número de eventos sísmicos por año dado un rango de años.
- Número de eventos sísmicos por mes dado un año.
- Número de eventos sísmicos por mes dados un rango de magnitudes y un año
- Número de eventos sísmicos por cada hora dado un año.

FIN DEL PROGRAMA
Ingrese opción [1 – 4]


## Menús de Opciones

### Módulo 01 – Eventos por Rango de Años

MÓDULO 01 – EVENTOS POR RANGO DE AÑOS

- Imprimir por pantalla.
- Exportar a archivo plano.
- Volver al Menú Principal


Ingrese opción [1-2]


## Archivos de Auditoría

Dado que el programa debe controlar excepciones, se deberá incluir funcionalidad para capturar excepciones y registrarlas en el archivo `auditoria.log`. Por cada excepción debe registrarse: fecha y hora del error, nombre del usuario, tipo de error y mensaje de error.

 

---

 
