CREATE TABLE usuario(documento varchar(50) primary key, 
correo varchar(50) UNIQUE, 
nombre varchar(100) NOT NULL, 
usern varchar(50) NOT NULL ,
estado varchar(50) NOT NULL, 
tipoIdentificacion varchar(3) NOT NULL,
fechaRegistro date NOT NULL,
contrasena varchar(50) NOT NULL
);

  CREATE TABLE categoria (
	id int4 NOT NULL DEFAULT nextval('categoria_id'::regclass),
	nombre varchar(60) NOT NULL,
	descripcion varchar(200) NOT NULL,
	fechadecreacion date NOT NULL,
	estado varchar(10) NOT NULL,
	fechademodificacion date NULL,
	CONSTRAINT categoria_nombre_key UNIQUE (nombre),
	CONSTRAINT categoria_pkey PRIMARY KEY (id)
);


CREATE TABLE public.necesidad (
	id int4 NOT NULL DEFAULT nextval('necesidad_id'::regclass),
	nombre varchar(60) NOT NULL,
	descripcion varchar(200) NOT NULL,
	"fecha de creacion" date NOT NULL,
	estado varchar(10) NOT NULL,
	"fecha de modificacion" date NULL,
	urgencia varchar(7) NOT NULL,
	categoria_id int4 NOT NULL,
	CONSTRAINT necesidad_pk PRIMARY KEY (id),
	CONSTRAINT necesidad_categoria_id_fkey FOREIGN KEY (categoria_id) REFERENCES categoria(id)
);