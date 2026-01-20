# Propuestas de Mejora para Danvlec

Tras un análisis inicial del repositorio, se han identificado las siguientes áreas de mejora:

## 1. Seguridad
*   **Hash de Contraseñas:** Actualmente se usa SHA-256 sin sal (salt) en `ValidateOutputs.java`. Se recomienda migrar a **BCrypt** para una mayor resistencia contra ataques de fuerza bruta.
*   **Cifrado AES:** La clave AES está hardcoded en el código (`"1234567890123456"`). Esto es una vulnerabilidad grave. Se debería usar un sistema de gestión de claves o al menos una variable de entorno.

## 2. Arquitectura y Diseño
*   **Abuso de Estado Estático:** Muchas clases (`DataManager`, `UserData`, `ScreenManager`) dependen de métodos y variables estáticas. Esto dificulta las pruebas unitarias y el escalado de la aplicación.
*   **Gestión de Conexiones:** El uso de una única conexión estática en `DataManager` es propenso a errores de conexión perdida. Se recomienda implementar un **Connection Pool** (ej. HikariCP).
*   **Configuración:** Los valores de IP y puerto están hardcoded. Se deben mover a un archivo de configuración (`.properties` o `.env`).

## 3. Calidad de Código
*   **Logging:** Se abusa de `System.out.println` y `e.printStackTrace()`. Se debe estandarizar el uso de **SLF4J/Logback** (que ya están en las dependencias).
*   **Validaciones:** `ValidateFormInputs.java` usa arrays de booleanos con índices implícitos, lo cual es poco legible. Se recomienda usar objetos o enums.
*   **Versión de Java:** Se utiliza Java 25. A menos que se necesiten características experimentales de dicha versión, se recomienda usar una versión **LTS** (como Java 21).

## 4. Testing
*   El proyecto carece totalmente de pruebas automatizadas. Se recomienda añadir **JUnit 5** y **Mockito**.
