/*
	##### The Canchita #####
*/
CREATE DATABASE canchitabs;

CREATE TABLE canchitabs.usuario(
	id VARCHAR(36) NOT NULL,
    nombreUsuario VARCHAR(255),
    email VARCHAR(255) UNIQUE,
    cantidadReserva INT NOT NULL,
    telefonoUsuario varchar(144),
    contraseñaUsuario VARCHAR(255) NOT NULL,
    PRIMARY KEY (id)
    );
CREATE TABLE canchitabs.rol(
	id INT  NOT null AUTO_INCREMENT ,
    nombre VARCHAR(144),
    descripcion VARCHAR(255),
    PRIMARY KEY (id)
    );

CREATE TABLE canchitabs.usuariorol(
    id VARCHAR(144) NOT null ,
    idUsuario VARCHAR(36) NOT NULL,
    idRol INT NOT NULL,
    PRIMARY KEY (id),
    CONSTRAINT FK_Usuario FOREIGN KEY (idUsuario) REFERENCES usuario(id),
    CONSTRAINT FK_Rol FOREIGN KEY (idRol) REFERENCES rol(id)
);

CREATE TABLE canchitabs.estadoCancha(
	id INT NOT null AUTO_INCREMENT ,
    nombreEstado VARCHAR(144),
    descripcionEstado VARCHAR(255),
    PRIMARY KEY (id)
);

CREATE TABLE canchitabs.cancha(
	id VARCHAR(144) NOT null ,
    nombreCancha VARCHAR(255) DEFAULT ('Sin Nombre') ,
    idEstadoCancha INTEGER NOT NULL,
    direccion VARCHAR (144),
    horarioInicio VARCHAR(144) NOT NULL,
    horarioCierre VARCHAR(144) NOT NULL,
    PRIMARY KEY (id),
    CONSTRAINT FK_Cancha FOREIGN KEY (idEstadoCancha) REFERENCES estadoCancha(id)
);
CREATE TABLE canchitabs.estadoReserva(
	id INT NOT null AUTO_INCREMENT  ,
    nombreEstado VARCHAR(144),
    descripcionEstado VARCHAR(255),
    PRIMARY KEY (id)
);

CREATE TABLE canchitabs.reserva(
		id VARCHAR(144) NOT null  ,
        idUsuario VARCHAR(36) NOT NULL,
        idCancha VARCHAR(144) NOT NULL,
        idEstadoReserva INT NOT NULL,
        inicioReserva TIME NOT NULL,
        finReserva TIME NOT NULL,
        CONSTRAINT FK_UsuarioReserva FOREIGN KEY (idUsuario) REFERENCES usuario(id),
        CONSTRAINT FK_CanchaReserva FOREIGN KEY (idCancha) REFERENCES cancha(id),
        CONSTRAINT FK_ReservaEstado FOREIGN KEY (idEstadoReserva) REFERENCES estadoReserva(id),
        PRIMARY KEY (id)
    );

INSERT INTO canchitabs.rol (id, nombre, descripcion) VALUES ('3','Usuario', 'Habilitado a reservar canchas');
insert into canchitabs.rol(id, nombre, descripcion) values ('2', 'Operador','Habilitada la opcion de aceptar o rechazar una reserva');
insert into canchitabs.rol(id, nombre ,descripcion) values ('1', 'Administrador','Habilitada la gestion de la aplicacion');
#select * from canchitabs.rol

insert into canchitabs.estadocancha (id, nombreEstado, descripcionEstado) values ( 1 , 'Habilitada', 'La cancha está disponible para su uso'); 
insert into canchitabs.estadocancha (id, nombreEstado, descripcionEstado) values ( 2 ,'Deshabilitada', 'La cancha no está disponible para su uso');
#	select * from canchitabs.estadocancha;


insert into canchitabs.estadoreserva (id , nombreEstado, descripcionEstado) values ( 1 , 'Reservada', 'El usuario reservó la cancha en el horario dado');
insert into canchitabs.estadoreserva (id , nombreEstado, descripcionEstado) values ( 2 , 'Finalizada', 'La reserva en el horario dado finalizó');
insert into canchitabs.estadoreserva (id , nombreEstado, descripcionEstado) values ( 3 , 'Pendiente', 'La reserva del usuario aún no está Reservada');
insert into canchitabs.estadoreserva (id , nombreEstado, descripcionEstado) values ( 4 , 'Cancelada', 'La reserva del usuario fué cancelada por el Usuario o por el Operador');
#	select * from canchitabs.estadoreserva 

