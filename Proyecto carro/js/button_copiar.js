// Obtén referencias a la etiqueta <pre> y al botón
const preElement = document.getElementById('miPre');
const copiarContenidoButton = document.getElementById('copiarContenido');

// Agrega un evento click al botón para copiar el contenido
copiarContenidoButton.addEventListener('click', function () {
    // Crea un elemento de texto oculto para copiar el contenido
    const tempTextarea = document.createElement('textarea');
    tempTextarea.value = preElement.textContent;
    document.body.appendChild(tempTextarea);
    
    // Selecciona y copia el contenido al portapapeles
    tempTextarea.select();
    document.execCommand('copy');
    
    // Elimina el elemento de texto temporal
    document.body.removeChild(tempTextarea);
    
    // Cambia el texto del botón para indicar que se ha copiado
    copiarContenidoButton.textContent = 'Contenido Copiado';
    
    // Restaura el texto original después de un tiempo
    setTimeout(() => {
        copiarContenidoButton.textContent = 'Copiar Contenido';
    }, 2000); // Cambiar de nuevo después de 2 segundos (opcional)
});

