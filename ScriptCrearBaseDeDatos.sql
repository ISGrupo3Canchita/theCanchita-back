/*
	##### The Canchita #####
*/
CREATE DATABASE canchitabs;

CREATE TABLE canchitabs.usuario(
	id VARCHAR(36) NOT NULL,
    nombre_Usuario VARCHAR(255),
    email VARCHAR(255),
    cantidad_Reserva INT NOT NULL DEFAULT 0,
    telefono_Usuario INT,
    contraseña_Usuario VARCHAR(255) NOT NULL,
    PRIMARY KEY (id)
    );
CREATE TABLE canchitabs.rol(
	id VARCHAR(36)  NOT NULL,
    nombre VARCHAR(144),
    descripcion VARCHAR(255),
    PRIMARY KEY (id)
    );

CREATE TABLE canchitabs.usuarioRol(
    id VARCHAR(36) NOT NULL,
    id_Usuario VARCHAR(36) NOT NULL,
    id_Rol VARCHAR(36) NOT NULL,
    PRIMARY KEY (id),
    CONSTRAINT FK_Usuario FOREIGN KEY (id_Usuario) REFERENCES usuario(id),
    CONSTRAINT FK_Rol FOREIGN KEY (id_Rol) REFERENCES rol(id)
);

CREATE TABLE canchitabs.estadoCancha(
	id VARCHAR(36) NOT NULL,
    nombre_Estado VARCHAR(144),
    descripcion_Estado VARCHAR(255),
    PRIMARY KEY (id)
);

CREATE TABLE canchitabs.cancha(
	id VARCHAR(36) NOT NULL,
    nombre_Cancha VARCHAR(255) DEFAULT ('Sin Nombre') ,
    id_Estado_Cancha VARCHAR(36) NOT NULL,
    direccion VARCHAR (144),
    horario_Inicio TIME NOT NULL,
    horario_Cierre TIME NOT NULL,
    PRIMARY KEY (id),
    CONSTRAINT FK_Cancha FOREIGN KEY (id_Estado_Cancha) REFERENCES estadoCancha(id)
);
CREATE TABLE canchitabs.estadoReserva(
	id VARCHAR(36) NOT NULL,
    nombre_Estado VARCHAR(144),
    descripcion_Estado VARCHAR(255),
    PRIMARY KEY (id)
);

CREATE TABLE canchitabs.reserva(
		id VARCHAR (36) NOT NULL,
        id_Usuario VARCHAR(36) NOT NULL,
        id_Cancha VARCHAR(36) NOT NULL,
        id_Estado_Reserva VARCHAR(36) NOT NULL,
        inicio_Reserva TIME NOT NULL,
        fin_Rserva TIME NOT NULL,
        CONSTRAINT FK_UsuarioReserva FOREIGN KEY (id_Usuario) REFERENCES usuario(id),
        CONSTRAINT FK_CancahReserva FOREIGN KEY (id_Cancha) REFERENCES cancha(id),
        CONSTRAINT FK_ReservaEstado FOREIGN KEY (id_Estado_Reserva) REFERENCES estadoReserva(id),
        PRIMARY KEY (id)
    );


INSERT INTO canchitabs.rol (id, nombre, descripcion) VALUES ('3','Usuario', 'Habilitado a reservar canchas')
insert into canchitabs.rol(id, nombre, descripcion) values ('2', 'Operador','Habilitada la opcion de aceptar o rechazar una reserva')
insert into canchitabs.rol(id, nombre ,descripcion) values ('1', 'Administrador','Habilitada la gestion de la aplicacion')