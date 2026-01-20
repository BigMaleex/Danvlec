# Danvlec

Danvlec es una aplicación de escritorio desarrollada en Java utilizando JavaFX. El proyecto parece estar enfocado en la gestión de usuarios y posiblemente en alguna funcionalidad relacionada con el control de tiempo (Clock).

## Requisitos

*   Java 25 o superior (se recomienda una versión LTS para estabilidad, aunque el proyecto usa actualmente la 25).
*   Maven.
*   MySQL (para la base de datos).

## Configuración de la Base de Datos

La aplicación espera una base de datos MySQL llamada `danvlec`.
Actualmente, las credenciales se obtienen de las variables de entorno:
*   `DanvlecBDUser`
*   `DanvlecBDPassword`

El host y puerto por defecto son `localhost:3306`.

## Ejecución

Para compilar y ejecutar el proyecto:

```bash
mvn compile
mvn exec:java -Dexec.mainClass="launcher.Launcher"
```
