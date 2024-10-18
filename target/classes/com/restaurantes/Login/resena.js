document.getElementById('review-form').addEventListener('submit', function(event) {
    event.preventDefault();

    // Obtiene los valores de los campos del formulario
    const restaurantName = document.getElementById('restaurant-name').value;
    const rating = document.getElementById('rating').value;
    const reviewText = document.getElementById('review-text').value;

    // Validación: Asegurarse de que los campos no estén vacíos
    if ( !rating || !reviewText) {
        alert('Por favor, complete todos los campos antes de enviar.');
        return;
    }

    // Simulación de guardado de reseña (aquí puedes hacer una solicitud a tu backend o almacenarla localmente)
    // console.log('Restaurante:', restaurantName);
    console.log('Puntuación:', rating);
    console.log('Reseña:', reviewText);

    // Muestra un mensaje de confirmación
    alert('¡Gracias por tu reseña!');

    // Redirige al usuario a la página de restaurantes después de enviar la reseña
    window.location.href = 'restaurantes.html'; // Redirige a la página principal de restaurantes
});
