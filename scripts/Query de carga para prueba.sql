#	drop database canchitabs; 

#	select * from canchitabs.cancha; 
#	select * from canchitabs.estadocancha;
	select * from canchitabs.estadoreserva;
	select * from canchitabs.reserva;
	select * from canchitabs.rol;
	select * from canchitabs.usuario;
	select * from canchitabs.usuariorol;

select id from canchitabs.usuario cu where cu.email = "cuatro@mail";

UPDATE canchitabs.usuariorol
	SET idRol = 3
    WHERE idUsuario = '58a3b052-b152-4eb7-859d-09675b0da12b' ;
#Insert Para pruebas
#	---------- Agregar  Reserva ----------
#	INSERT INTO canchitabs.reserva (id, idUsuario, idCancha, idEstadoReserva, inicioReserva, finReserva) VALUE ('reservauno', (select id from canchitabs.usuario cu where cu.email = "cuatro@mail"), 'canchauno', 3, '11:00:00','12:00:00' );
#	INSERT INTO canchitabs.reserva (id, idUsuario, idCancha, idEstadoReserva, inicioReserva, finReserva) VALUE ('reservads', (select id from canchitabs.usuario cu where cu.email = "cuatro@mail"), 'canchados', 1, '8:00:00','9:00:00' );
#	INSERT INTO canchitabs.reserva (id, idUsuario, idCancha, idEstadoReserva, inicioReserva, finReserva) VALUE ('reservatres', (select id from canchitabs.usuario cu where cu.email = "cuatro@mail"), 'canchatres', 3, '13:00:00','14:00:00' );
#	INSERT INTO canchitabs.reserva (id, idUsuario, idCancha, idEstadoReserva, inicioReserva, finReserva) VALUE ('reservacuatro', (select id from canchitabs.usuario cu where cu.email = "cuatro@mail"), 'canchauno', 2, '15:00:00','16:00:00' );
#	INSERT INTO canchitabs.reserva (id, idUsuario, idCancha, idEstadoReserva, inicioReserva, finReserva) VALUE ('reservacinci', (select id from canchitabs.usuario cu where cu.email = "cuatro@mail"), 'canchados', 4, '10:00:00','11:00:00' );

