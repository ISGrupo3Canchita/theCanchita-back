#drop database canchitabs;

#Insert Para pruebas
#Agrega un usuario
#	select * from canchitabs.usuario;
#	insert into canchitabs.usuario (id, nombreUsuario, email, cantidadReserva, telefonoUsuario, contraseñaUsuario )
#		value ('cerouno', 'Gonzalo', 'gnz@gnz', 0, '02243','123');
    
# Traeme un el id de un usuario segun el email.    
#	select id from canchitabs.usuario cu where cu.email = "gnz@gnz";  
  
#	---------- Agrego un rol Al Usuario ----------
#	select * from canchitabs.usuariorol; 
#	Insert into canchitabs.usuariorol (id, idUsuario, idRol) 
#		value( 1,(select id from canchitabs.usuario cu where cu.email = "gnz@gnz"), 3);

#	---------- Agregar Cancha ----------
	select * from canchitabs.cancha; 
#	Insert into canchitabs.cancha (id, nombreCancha, idEstadoCancha, direccion, horarioInicio, horarioCierre)
#		value('uno', 'El Potrero', 1, 'Por Ahí', "8:00:00", "21:00:00");
	
#Agregouna Reserva
	select * from canchitabs.reserva;
    select * from canchitabs.reserva cr where cr.idEstadoReserva=3;
#	INSERT INTO canchitabs.reserva (id, idUsuario, idCancha, idEstadoReserva, inicioReserva, finRserva) 
#		VALUE (1, 'cerouno', 1, 1, 11,12 );

update canchitabs.reserva set idEstadoReserva = 3 where id= "0a2c3c08-9366-48af-95b4-bbbda73cfdd0";
