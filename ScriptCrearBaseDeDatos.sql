/*
	##### The Canchita #####
*/
CREATE DATABASE canchitabs;

CREATE TABLE canchitabs.usuario(
	id VARCHAR(36) NOT NULL,
    nombreUsuario VARCHAR(255),
    email VARCHAR(255),
    cantidadReserva INT NOT NULL,
    telefonoUsuario INT,
    contraseñaUsuario VARCHAR(255) NOT NULL,
    PRIMARY KEY (id)
    );
CREATE TABLE canchitabs.rol(
	id VARCHAR(36)  NOT NULL,
    nombre VARCHAR(144),
    descripcion VARCHAR(255),
    PRIMARY KEY (id)
    );

CREATE TABLE canchitabs.usuariorol(
    id VARCHAR(36) NOT NULL,
    idUsuario VARCHAR(36) NOT NULL,
    idRol VARCHAR(36) NOT NULL,
    PRIMARY KEY (id),
    CONSTRAINT FK_Usuario FOREIGN KEY (idUsuario) REFERENCES usuario(id),
    CONSTRAINT FK_Rol FOREIGN KEY (idRol) REFERENCES rol(id)
);

CREATE TABLE canchitabs.estadoCancha(
	id VARCHAR(36) NOT NULL,
    nombreEstado VARCHAR(144),
    descripcionEstado VARCHAR(255),
    PRIMARY KEY (id)
);

CREATE TABLE canchitabs.cancha(
	id VARCHAR(36) NOT NULL,
    nombreCancha VARCHAR(255) DEFAULT ('Sin Nombre') ,
    idEstadoCancha VARCHAR(36) NOT NULL,
    direccion VARCHAR (144),
    horarioInicio TIME NOT NULL,
    horarioCierre TIME NOT NULL,
    PRIMARY KEY (id),
    CONSTRAINT FK_Cancha FOREIGN KEY (idEstadoCancha) REFERENCES estadoCancha(id)
);
CREATE TABLE canchitabs.estadoReserva(
	id VARCHAR(36) NOT NULL,
    nombreEstado VARCHAR(144),
    descripcionEstado VARCHAR(255),
    PRIMARY KEY (id)
);

CREATE TABLE canchitabs.reserva(
		id VARCHAR (36) NOT NULL,
        idUsuario VARCHAR(36) NOT NULL,
        idCancha VARCHAR(36) NOT NULL,
        idEstadoReserva VARCHAR(36) NOT NULL,
        inicioReserva TIME NOT NULL,
        finRserva TIME NOT NULL,
        CONSTRAINT FK_UsuarioReserva FOREIGN KEY (idUsuario) REFERENCES usuario(id),
        CONSTRAINT FK_CancahReserva FOREIGN KEY (idCancha) REFERENCES cancha(id),
        CONSTRAINT FK_ReservaEstado FOREIGN KEY (idEstadoReserva) REFERENCES estadoReserva(id),
        PRIMARY KEY (id)
    );

INSERT INTO canchitabs.rol (id, nombre, descripcion) VALUES ('3','Usuario', 'Habilitado a reservar canchas')
insert into canchitabs.rol(id, nombre, descripcion) values ('2', 'Operador','Habilitada la opcion de aceptar o rechazar una reserva')
insert into canchitabs.rol(id, nombre ,descripcion) values ('1', 'Administrador','Habilitada la gestion de la aplicacion')