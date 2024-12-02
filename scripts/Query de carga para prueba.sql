#	drop database canchitabs; 

#	select * from canchitabs.cancha; 
#	select * from canchitabs.estadocancha;
#	select * from canchitabs.estadoreserva;
#	select * from canchitabs.reserva;
#	select * from canchitabs.rol;
	select * from canchitabs.usuario;
	select * from canchitabs.usuariorol;

#	select id from canchitabs.usuario cu where cu.email = "cuatro@mail";

# UPDATE canchitabs.usuario
#	SET email = 'gonza@mail'
#    WHERE id = '58a3b052-b152-4eb7-859d-09675b0da12b' ;
    
UPDATE canchitabs.usuariorol
	SET idRol = 2
    WHERE idUsuario ='51a98613-102f-4623-83ce-29e223be506e';
    
DELETE FROM canchitabs.usuario WHERE id='69c83e9b-06a6-48ac-8b80-e19db9013639'