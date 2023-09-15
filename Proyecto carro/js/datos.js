function actualizarTemperaturas() {
    // Obtener la temperatura ambiente y la temperatura del objeto desde la API
    const temperaturaAmbiente = obtenerTemperaturaAmbiente(); // Reemplaza con tu función
    const temperaturaObjeto = obtenerTemperaturaObjeto(); // Reemplaza con tu función

    // Actualizar los elementos span en el HTML
    document.getElementById("temperaturaAmbiente").textContent = temperaturaAmbiente;
    document.getElementById("temperaturaObjeto").textContent = temperaturaObjeto;
}

// Llamar a la función para actualizar las temperaturas cuando la página se cargue
window.onload = actualizarTemperaturas;