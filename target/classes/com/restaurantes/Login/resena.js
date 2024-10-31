document.addEventListener('DOMContentLoaded', function() {
    let ratingValue = 0; // Inicialmente, sin estrellas seleccionadas

    // Obtener todas las estrellas
    const stars = document.querySelectorAll('.star');
    const ratingInput = document.getElementById('rating'); // Campo oculto para el valor de la calificación

    // Añadir eventos de clic a cada estrella
    stars.forEach((star, index) => {
        star.addEventListener('click', function() {
            ratingValue = index + 1; // El índice comienza en 0, por lo que sumamos 1
            ratingInput.value = ratingValue; // Asignamos el valor al campo de calificación oculto

            // Actualizar visualmente las estrellas seleccionadas
            stars.forEach((s, i) => {
                if (i < ratingValue) {
                    s.classList.add('checked');
                } else {
                    s.classList.remove('checked');
                }
            });
        });
    });

    document.getElementById('review-form').addEventListener('submit', function(event) {
        event.preventDefault();

        // Obtiene los valores de los campos del formulario
        const restaurantName = document.getElementById('restaurant-name').value;
        const reviewText = document.getElementById('review-text').value;

        // Validación: Asegurarse de que los campos no estén vacíos y que se haya seleccionado una calificación
        if (!ratingValue || !reviewText) {
            alert('Por favor, complete todos los campos antes de enviar.');
            return;
        }

        // Simulación de guardado de reseña (aquí puedes hacer una solicitud a tu backend o almacenarla localmente)
        console.log('Restaurante:', restaurantName);
        console.log('Puntuación:', ratingValue);
        console.log('Reseña:', reviewText);

        // Muestra un mensaje de confirmación
        alert('¡Gracias por tu reseña!');

        // Redirige al usuario a la página de restaurantes después de enviar la reseña
        window.location.href = 'restaurantes.html'; // Redirige a la página principal de restaurantes
    });
});
