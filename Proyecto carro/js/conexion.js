// Obtén una referencia al elemento canvas
const canvas = document.getElementById("realTimeChart");
const ctx = canvas.getContext("2d");

// Configura el gráfico inicial
const data = {
    labels: [], // Etiquetas de tiempo
    datasets: [
        {
            label: "Valor en Tiempo Real",
            data: [], // Valores en tiempo real
            borderColor: "rgba(75, 192, 192, 1)",
            borderWidth: 2,
            fill: false,
        },
    ],
};

const config = {
    type: "line",
    data: data,
    options: {
        scales: {
            x: {
                type: "time",
                time: {
                    unit: "second", // Ajusta la unidad de tiempo según tus datos
                    displayFormats: {
                        second: "h:mm:ss a",
                    },
                },
            },
            y: {
                beginAtZero: true,
            },
        },
    },
};

// Crea el gráfico inicial
const realTimeChart = new Chart(ctx, config);

// Simula datos en tiempo real (reemplaza esto con tus datos reales)
function getData() {
    return {
        time: new Date(),
        value: Math.random() * 100,
    };
}

// Función para actualizar el gráfico en tiempo real
function updateChart() {
    const newData = getData();

    // Agrega nuevos datos al conjunto de datos
    data.labels.push(newData.time);
    data.datasets[0].data.push(newData.value);

    // Limita la cantidad de datos mostrados en el gráfico (ajusta según tus necesidades)
    const maxDataPoints = 10;
    if (data.labels.length > maxDataPoints) {
        data.labels.shift();
        data.datasets[0].data.shift();
    }

    // Actualiza el gráfico
    realTimeChart.update();
}

// Actualiza el gráfico cada segundo (ajusta el intervalo según tus necesidades)
setInterval(updateChart, 1000);

// Aquí debes incluir tu lógica JavaScript para asignar valores a las temperaturas
var temperaturaAmbiente = 25.5; // Supongamos que tienes un valor para la temperatura ambiente
var temperaturaObjeto = 30.2;    // Supongamos que tienes un valor para la temperatura del objeto

// Ahora, asigna estos valores a los elementos HTML correspondientes
document.getElementById("temperaturaAmbiente").textContent = temperaturaAmbiente.toFixed(2);
document.getElementById("temperaturaObjeto").textContent = temperaturaObjeto.toFixed(2);
    