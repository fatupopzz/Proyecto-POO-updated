document.getElementById('deleteAccountBtn').addEventListener('click', () => {
    Swal.fire({
        title: '¿Estás seguro?',
        text: "Esta acción eliminará tu cuenta permanentemente.",
        icon: 'warning',
        showCancelButton: true,
        confirmButtonColor: '#d9534f',
        cancelButtonColor: '#53cf4a',
        confirmButtonText: 'Sí, eliminar cuenta',
        cancelButtonText: 'Cancelar'
    }).then((result) => {
        if (result.isConfirmed) {
            Swal.fire(
                'Cuenta Eliminada',
                'Tu cuenta ha sido eliminada correctamente.',
                'success'
            ).then(() => {
                window.location.href = 'restaurantes.html';
            });
        }
    });
});

document.getElementById('editAccountBtn').addEventListener('click', () => {
    Swal.fire({
        title: 'Editar Datos',
        text: 'Esta funcionalidad estará disponible pronto.',
        icon: 'info',
        confirmButtonText: 'OK'
    });
});
