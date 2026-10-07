EJERCICIO 3 - Pruebas de Carga (Performance) con k6

INSTRUCCIONES DE EJECUCIÓN:

1. Prerrequisitos:
   - k6 instalado en la máquina local (https://k6.io/docs/getting-started/installation/).
   - Terminal o línea de comandos.

2. Ejecución de la Prueba:
   Para ejecutar el script de pruebas de carga, navegue hasta esta misma carpeta ("ejercicio3_performance") en su terminal y ejecute el siguiente comando:
   
   k6 run login_test.js

3. Parametrización y Meta:
   - El script leerá el archivo "users.csv" de manera dinámica y compartida (usando SharedArray para optimización de memoria RAM).
   - Se configuró el inyector "constant-arrival-rate" apuntando directamente a lanzar 25 TPS constantes por 1 minuto. Esto asegura superar holgadamente la meta mínima solicitada de 20 TPS de forma estable y sostenida.
   - Si k6 determina que un tiempo de respuesta del p(95) es mayor a 1.5s o el error supera el 3%, la prueba fallará el "threshold" automáticamente y su exit code será error, dando fe de la validación estricta en pipelines CI/CD.
