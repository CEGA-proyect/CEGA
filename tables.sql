CREATE TABLE usuario(documento varchar(50) primary key, 
correo varchar(50) UNIQUE, 
nombre varchar(100) NOT NULL, 
usern varchar(50) NOT NULL ,
estado varchar(50) NOT NULL, 
tipoIdentificacion varchar(3) NOT NULL,
fechaRegistro date NOT NULL,
contrasena varchar(50) NOT NULL
);