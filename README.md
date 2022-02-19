# Filtrar por fecha y hora de reserva

* el calendario de la interfaz andrid nos devuelve un LocalDate, este lo usamos en un servicio para filtrar los alquileres
cullos inicios sean iguales a la variable dada por el calendario usando el metodo  _*toLocalDate().compareTo()*_ de LocalDateTime