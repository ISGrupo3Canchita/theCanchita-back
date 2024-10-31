drop database canchitabs;

select * from canchitabs.usuario;

select * from canchitabs.usuariorol;

select * from  canchitabs.rol;

select id from canchitabs.usuario cu where cu.email = "gnz@mail.com";


#Insert Para pruebas
#Agrega un usuario
insert into canchitabs.usuario (id, nombreUsuario, email, cantidadReserva, telefonoUsuario, contraseñaUsuario )
	value ('cerouno', 'Gonzalo', 'gnz@gnz', 0, '02243','123');
    
select id from canchitabs.usuario cu where cu.email = "gnz@gnz";  
  
#Agrego un rol Al Usuario
Insert into canchitabs.usuariorol (id, idUsuario, idRol) 
		value( "gnz",
        (select id from canchitabs.usuario cu where cu.email = "gnz@mail.com"),
        3);
#Agregar Cancha
Insert into canchitabs.cancha (id, nombreCancha, idEstadoCancha, direccion, horarioInicio, horarioCierre)
	value(1, 'ElPotrero', 1, 'Por Ahí', 8, 19);
	
#Agregouna Reserva
INSERT INTO canchitabs.reserva (id, idUsuario, idCancha, idEstadoReserva, inicioReserva, finRserva) 
	VALUE (1, 'cerouno', 1, 1, 11,12 );
    
select * from canchitabs.reserva;