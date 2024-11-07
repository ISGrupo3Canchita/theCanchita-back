#	drop database canchitabs;
# Traeme un el id de un usuario segun el email.    
#	select id from canchitabs.usuario cu where cu.email = "gnz@gnz"; 
#	select * from canchitabs.usuariorol; 
#	select * from canchitabs.cancha; 
	select * from canchitabs.reserva;
#   select * from canchitabs.reserva cr where cr.id="uno";
#	update canchitabs.reserva set idEstadoReserva = 3 where id= "0a2c3c08-9366-48af-95b4-bbbda73cfdd0";


#Insert Para pruebas
#Agrega 3 usuarios
#	insert into canchitabs.usuario (id, nombreUsuario, email, cantidadReserva, telefonoUsuario, contraseñaUsuario )value ('usuariouno', 'UNO', 'uno@mail', 0, '02241','123');
#	insert into canchitabs.usuario (id, nombreUsuario, email, cantidadReserva, telefonoUsuario, contraseñaUsuario )value ('usuariodos', 'DOS', 'dos@mail', 0, '02242','123');
#	insert into canchitabs.usuario (id, nombreUsuario, email, cantidadReserva, telefonoUsuario, contraseñaUsuario )value ('usuariotres', 'TRES', 'tres@mail', 0, '02243','123');
#	---------- Agrego un rol Al Usuario ----------
#	Insert into canchitabs.usuariorol (id, idUsuario, idRol) value( 1,(select id from canchitabs.usuario cu where cu.email = "uno@mail"), 1);
#	Insert into canchitabs.usuariorol (id, idUsuario, idRol) value( 2,(select id from canchitabs.usuario cu where cu.email = "dos@mail"), 2);
#	Insert into canchitabs.usuariorol (id, idUsuario, idRol) value( 3,(select id from canchitabs.usuario cu where cu.email = "tres@mail"), 3);
#	---------- Agregar Cancha ----------
#	Insert into canchitabs.cancha (id, nombreCancha, idEstadoCancha, direccion, horarioInicio, horarioCierre) value('canchauno', 'Potrero', 1, 'en Campo', "8:00:00", "21:00:00");
#	Insert into canchitabs.cancha (id, nombreCancha, idEstadoCancha, direccion, horarioInicio, horarioCierre) value('canchados', 'Cancha', 1, 'en Ciudad', "8:00:00", "21:00:00");
#	Insert into canchitabs.cancha (id, nombreCancha, idEstadoCancha, direccion, horarioInicio, horarioCierre) value('canchatres', 'Box', 1, 'por Ahi', "8:00:00", "21:00:00");
#	---------- Agregouna Reserva
#	INSERT INTO canchitabs.reserva (id, idUsuario, idCancha, idEstadoReserva, inicioReserva, finReserva) VALUE ('reservauno', 'usuariouno', 'canchauno', 3, '11:00:00','12:00:00' );
#	INSERT INTO canchitabs.reserva (id, idUsuario, idCancha, idEstadoReserva, inicioReserva, finReserva) VALUE ('reservados', 'usuariouno', 'canchados', 1, '8:00:00','9:00:00' );
#	INSERT INTO canchitabs.reserva (id, idUsuario, idCancha, idEstadoReserva, inicioReserva, finReserva) VALUE ('reservatres', 'usuariouno', 'canchatres', 3, '13:00:00','14:00:00' );
#	INSERT INTO canchitabs.reserva (id, idUsuario, idCancha, idEstadoReserva, inicioReserva, finReserva) VALUE ('reservacuatro', 'usuariouno', 'canchauno', 2, '15:00:00','16:00:00' );
#   INSERT INTO canchitabs.reserva (id, idUsuario, idCancha, idEstadoReserva, inicioReserva, finReserva) VALUE ('reservacinco', 'usuariouno', 'canchados', 4, '10:00:00','11:00:00' );

