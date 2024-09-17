document.addEventListener('DOMContentLoaded', function() {
    setInterval(function(){
        const nextButton = document.querySelector('#carouselExampleFade .carousel-control-next');
        if (nextButton) {
            nextButton.click();
        }
    }, 6500);
});

//funsion para agrandar la tarjeta cada vez que psao el mouse por encima
function enlargeCard(card) {
    if (window.innerWidth > 575) { // Verifica que el ancho de la pantalla sea mayor que 575px para su funcionamiento, en pantallas mas pequeñas no funcionará
      card.style.transform = 'scale(1.02)'; // Agranda la tarjeta al 103 de su tamaño original
    }
}
//funsion para achicar a su tamanio original cundo retiro el puntero encima de el
function resetCardSize(card) {
    card.style.transform = 'scale(1)'; // Restablece el tamaño de la tarjeta a su valor original
}

//funsion para agrandar la tarjeta cada vez que paso el mouse por encima
function enlargeCard2(card) {
    if (window.innerWidth > 575) { // Verifica que el ancho de la pantalla sea mayor que 575px para su funcionamiento, en pantallas mas pequeñas no funcionará
      card.style.transform = 'scale(1.1)'; // Agranda la tarjeta al 103 de su tamaño original
    }
}

//funsion para achicar a su tamanio original cundo retiro el puntero encima de el
function resetCardSize2(card) {
    card.style.transform = 'scale(1)'; // Restablece el tamaño de la tarjeta a su valor original
}

const tooltipTriggerList = document.querySelectorAll('[data-bs-toggle="tooltip"]')
const tooltipList = [...tooltipTriggerList].map(tooltipTriggerEl => new bootstrap.Tooltip(tooltipTriggerEl))



$(document).ready(function(){
    $('.card').matchHeight();
});

document.getElementById('tipoVivienda').addEventListener('change', function() {
                    const isCasa = this.value === '1';
                    document.getElementById('piso').disabled = isCasa;
                    document.getElementById('numeroDepartamento').disabled = isCasa;
                    document.getElementById('torreDepartamento').disabled = isCasa;

                    if (isCasa) {
                        document.getElementById('piso').value = 'null';
                        document.getElementById('numeroDepartamento').value = 'null';
                        document.getElementById('torreDepartamento').value = 'null';
                    }
                });

