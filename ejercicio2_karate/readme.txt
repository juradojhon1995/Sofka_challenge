EJERCICIO 2 - Pruebas de API REST con Karate DSL

INSTRUCCIONES DE EJECUCIÓN:

1. Prerrequisitos:
   - Java Development Kit (JDK) 11 o superior.
   - Apache Maven instalado.
   - IDE de preferencia (opcional para ejecución).

2. Ejecución de las Pruebas:
   Para ejecutar la suite de pruebas del API de PetStore (Swagger), abra una terminal en el directorio principal de este ejercicio ("ejercicio2_karate") y ejecute:
   
   mvn clean test

   Esto ejecutará el flujo completo (End-to-End) sobre el modelo User de la API, el cual contiene las siguientes operaciones secuenciales:
   - POST: Creación de usuario
   - GET: Búsqueda del usuario creado
   - PUT: Actualización de datos (Nombre y Correo)
   - GET: Verificación de la actualización
   - DELETE: Eliminación del usuario (y validación del 404 posterior)

3. Visualización del Reporte:
   Karate generará de forma automática un reporte detallado en HTML con las peticiones y respuestas exactas.
   - Navegue a la siguiente ruta y abra el archivo "karate-summary.html":
     ejercicio2_karate/target/karate-reports/karate-summary.html
