EJERCICIO 1 - Automatización E2E con Serenity BDD

INSTRUCCIONES DE EJECUCIÓN:

1. Prerrequisitos:
   - Java Development Kit (JDK) 11 o superior instalado.
   - Apache Maven instalado.
   - Navegador Google Chrome instalado en el sistema.

2. Ejecución de las Pruebas:
   Para ejecutar las pruebas y generar el reporte, abra una terminal (consola o línea de comandos) en la carpeta "ejercicio1_serenity" y ejecute el siguiente comando:
   
   mvn clean verify

   Si desea ejecutar escenarios específicos, puede hacerlo mediante tags:
   - Para ejecutar la validación de campos obligatorios:
     mvn clean verify -D"cucumber.filter.tags=@MandatoryFieldsValidation"
     
   - Para ejecutar la compra exitosa E2E:
     mvn clean verify -D"cucumber.filter.tags=@SuccessfulPurchase"

3. Visualización de los Reportes:
   Una vez finalizada la ejecución, Serenity BDD generará un reporte detallado en HTML (Living Documentation) que incluye capturas de pantalla del paso a paso de las pruebas.
   - Navegue a la siguiente ruta y abra el archivo "index.html" en cualquier navegador:
     ejercicio1_serenity/target/site/serenity/index.html
