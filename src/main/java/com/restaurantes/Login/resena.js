document.addEventListener('DOMContentLoaded', function() {
    // Función para manejar la selección de estrellas
    function setupStarRating(starContainerId, ratingInputId) {
        const stars = document.querySelectorAll(`#${starContainerId} .star`);
        const ratingInput = document.getElementById(ratingInputId);

        stars.forEach((star) => {
            star.addEventListener('click', function() {
                const ratingValue = star.getAttribute('data-value');
                ratingInput.value = ratingValue;

                // Marcar solo hasta la estrella seleccionada
                stars.forEach((s, i) => {
                    if (i < ratingValue) {
                        s.classList.add('checked');
                    } else {
                        s.classList.remove('checked');
                    }
                });
            });
        });
    }

    // Inicializar las estrellas para comida y precios
    setupStarRating('food-rating', 'foodRating');
    setupStarRating('price-rating', 'priceRating');
    setupStarRating('service-rating', 'serviceRating');

    document.getElementById('review-form').addEventListener('submit', function(event) {
        event.preventDefault();

        // Obtener valores
        const restaurantName = document.getElementById('restaurant-name').value;
        const reviewText = document.getElementById('review-text').value;
        const foodRatingValue = document.getElementById('foodRating').value;
        const priceRatingValue = document.getElementById('priceRating').value;
        const serviceRatingValue = document.getElementById('serviceRating').value;

        // Validación
        if (!foodRatingValue || !priceRatingValue || !reviewText || !serviceRatingValue) {
            Swal.fire({
                icon: 'warning',
                title: 'Campos incompletos',
                text: 'Por favor, complete todos los campos antes de enviar.',
            });
            return;
        }

        // Simulación de guardado
        console.log('Restaurante:', restaurantName);
        console.log('Calificación de la Comida:', foodRatingValue);
        console.log('Calificación de los Precios:', priceRatingValue);
        console.log('Clasificacion del Servicio:', serviceRatingValue);
        console.log('Reseña:', reviewText);

        Swal.fire({
            icon: 'success',
            title: '¡Gracias por tu reseña!',
            text: 'Tu reseña ha sido enviada exitosamente.',
            confirmButtonColor: '#21be16'
        }).then(() => {
            window.location.href = 'restaurantes.html';
        });
    });
});
