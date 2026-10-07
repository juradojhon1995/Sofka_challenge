import http from 'k6/http';
import { check } from 'k6';
import { SharedArray } from 'k6/data';
import papaparse from 'https://jslib.k6.io/papaparse/5.1.1/index.js';

// Cargar y parsear el archivo CSV dinámicamente
const csvData = new SharedArray('users', function () {
  return papaparse.parse(open('./users.csv'), { header: true }).data;
});

export const options = {
  scenarios: {
    constant_request_rate: {
      executor: 'constant-arrival-rate',
      rate: 25, // Forzamos 25 TPS constantes para asegurar superar la meta de "al menos 20 TPS"
      timeUnit: '1s', // TPS = Transacciones por segundo
      duration: '1m', // Ejecutaremos la prueba por 1 minuto
      preAllocatedVUs: 10,
      maxVUs: 100, // Permitimos escalar los Virtual Users si la red es lenta
    },
  },
  thresholds: {
    // Requisito 1: El tiempo de respuesta permitido es máximo 1.5s (1500ms) en el 95% de las peticiones
    http_req_duration: ['p(95)<1500'],
    // Requisito 2: Tasa de error menor al 3% (0.03)
    http_req_failed: ['rate<0.03'],
  },
};

export default function () {
  // Escoger un usuario aleatorio del CSV
  const randomUser = csvData[Math.floor(Math.random() * csvData.length)];

  const url = 'https://fakestoreapi.com/auth/login';
  const payload = JSON.stringify({
    username: randomUser.user,
    password: randomUser.passwd,
  });

  const params = {
    headers: {
      'Content-Type': 'application/json',
    },
    timeout: '60s', // max-time 60 estipulado en el CURL original
  };

  const res = http.post(url, payload, params);

  // Validación para asegurar que el Login fue exitoso
  check(res, {
    'Login exitoso (status 200)': (r) => r.status === 200,
  });
}
