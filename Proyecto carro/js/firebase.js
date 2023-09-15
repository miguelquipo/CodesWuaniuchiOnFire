import { initializeApp } from "firebase/app";
import { getDatabase, ref, onValue } from "firebase/database";

const firebaseConfig = {
    apiKey: "AIzaSyCdyKZ8DwGNmkIQiB0COCmKa03ePW6V9aE",
    authDomain: "examen-modulo-2.firebaseapp.com",
    databaseURL: "https://examen-modulo-2-default-rtdb.firebaseio.com",
    projectId: "examen-modulo-2",
    storageBucket: "examen-modulo-2.appspot.com",
    messagingSenderId: "1088499745738",
    appId: "1:1088499745738:web:9bc0bd47c191d727808533"
  };

const app = initializeApp(firebaseConfig);

const database = getDatabase(app);
const dataRef = ref(database, "https://examen-modulo-2-default-rtdb.firebaseio.com");

// Escuchar cambios en la base de datos en tiempo real
onValue(dataRef, (snapshot) => {
    const data = snapshot.val();
    // Llamar a una función para actualizar los gráficos
    actualizarGraficos(data);
});

function actualizarGraficos(data) {
    // Obtener referencias a elementos HTML (por ejemplo, el elemento canvas)
    const canvas = document.getElementById("miGrafico");
    const ctx = canvas.getContext("2d");

    // Crear un conjunto de datos para el gráfico (ajusta esto según tus datos)
    const labels = Object.keys(data); // Supongamos que tienes etiquetas de tiempo como claves
    const valores = Object.values(data); // Supongamos que los valores son números

    // Crear el objeto de configuración del gráfico
    const config = {
        type: "line", // Tipo de gráfico (puedes cambiarlo según tu necesidad)
        data: {
            labels: labels,
            datasets: [
                {
                    label: "Mi Gráfico",
                    data: valores,
                    borderColor: "rgba(75, 192, 192, 1)", // Color de la línea
                    borderWidth: 2, // Ancho de la línea
                    fill: false // No llenar el área bajo la línea
                }
            ]
        },
        options: {
            // Opciones de configuración del gráfico
        }
    };

    // Crear e inicializar el gráfico
    const miGrafico = new Chart(ctx, config);
}
