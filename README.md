# Sofka Challenge - QA Automation 🚀

Bienvenido al repositorio con la resolución de las pruebas técnicas (UI y API) para el proceso de QA Automation. Este proyecto está construido con los más altos estándares de calidad y buenas prácticas (Patrón Screenplay, aserciones robustas, cero hardcoding y esperas dinámicas).

## 📁 Estructura del Repositorio

El repositorio es un proyecto Maven multi-módulo que contiene dos ejercicios principales:

### 1️⃣ Ejercicio 1: Automatización UI (OpenCart)
Ubicado en la carpeta `ejercicio1_serenity/`.
- **Tecnologías:** Java 11+, Serenity BDD, Patrón Screenplay, Cucumber.
- **Descripción:** Prueba funcional automatizada E2E de un flujo de compras en [OpenCart](http://opencart.abstracta.us/). El flujo valida la inserción de productos en el carrito, verificaciones de campos obligatorios, el Checkout adaptativo (con generación de correos únicos para sortear la falta de stock y restricciones de "Guest Checkout") y la finalización exitosa de la orden.
- **Documentación específica:** Revisar los archivos `readme.txt` y `conclusiones.txt` dentro del módulo para detalles de ejecución y hallazgos.

### 2️⃣ Ejercicio 2: Pruebas de API REST (PetStore)
Ubicado en la carpeta `ejercicio2_karate/`.
- **Tecnologías:** Karate DSL, JUnit 5.
- **Descripción:** Automatización del flujo CRUD (Create, Read, Update, Delete) sobre el modelo `User` en [Swagger PetStore API](https://petstore.swagger.io/). Se emplea interoperabilidad con Java para generación de data dinámica, asegurando que las pruebas corran en ambientes paralelos sin conflicto de datos.
- **Documentación específica:** Revisar los archivos `readme.txt` y `conclusiones.txt` dentro del módulo.

### 3️⃣ Ejercicio 3: Performance & Análisis de Carga
Ubicado en la carpeta `ejercicio3_performance/`.
- **Tecnologías:** k6 (JavaScript).
- **Descripción:** Script de inyección de carga (`login_test.js`) apuntando al API de *FakeStore* asegurando mediante *Thresholds* estrictos el cumplimiento de 20+ TPS, tiempos de respuesta menores a 1.5s y tasas de error menores al 3%, parametrizado con un `users.csv` optimizado en memoria (`SharedArray`).
- **Análisis de Resultados:** Incluye el documento de análisis y detección de cuellos de botella (`InformeResultados.md`).

---

## 🛠️ Instrucciones Generales de Ejecución

Ambos ejercicios pueden ser ejecutados desde la raíz del proyecto o desde sus respectivas carpetas utilizando **Apache Maven**.

### Ejecutar Ejercicio 1 (Serenity BDD)
```bash
cd ejercicio1_serenity
mvn clean verify
```
*El reporte Living Documentation se generará en `ejercicio1_serenity/target/site/serenity/index.html`*

### Ejecutar Ejercicio 2 (Karate DSL)
```bash
cd ejercicio2_karate
mvn clean test
```
*El reporte de Karate se generará en `ejercicio2_karate/target/karate-reports/karate-summary.html`*

---
**Nota:** Diseñado y desarrollado aplicando enfoques de nivel Senior QA para lograr mantenibilidad y escalabilidad.