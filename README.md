# Laboratorio de Informática

## Nombre del Curso

Ciclos de Vida del Desarrollo de Software

## Período Académico

2021-1

## Integrantes

- Juan Pablo Espinosa 
- Ricardo Amaya Rivera
- Juan Sebástian García Hincapie
- Cristian Camilo Piñeros Arevalo

## Profesor

Julián Mauricio Velasco Briceño



## Descripción del Producto

### Descripción General

La Plataforma Solidaridad Escuela, es una herramienta para generar un entorno de comunicación y ayuda dentro de la comunidad de la Escuela Colombiana de Ingeniería Julio Garavito. Por medio de esta los estudiantes pueden generar **Necesidades**, que son problemas que ellos presenten al interior de la universidad, asi mismo el resto de usuarios de la plataforma pueden generar **ofertas**, cada una de estas estan asociadas a una categoria en especifico y pueden ser **respondidas** por otros miembros de la comunidad.El administrador de la plataforma tiene la posibilidad de ver diversos reportes que pueden ser usados al interior de la universidad para generar combios beneficiosos para la comunidad universitaria.



### Manual de Usuario:


### Inicio de Sesión

la página de inicio de sesión, en la que el usuario puede iniciar sesión en la plataforma haciendo uso de sus respectivas credenciales, dependiendo de las mismas se redireccionara a una pagina de acuerdo con su rol (admin , user , estudiante).

![login](images/login.png)

### Roles
------------------------------------------------------------------------------------
#### Administrador

dentro de este rol se tiene una vista administrativa de las acciones realizadas dentro de la aplicacion, como lo son crear Categorias, Actualizar categorias , Actualizar Ofertas , Actualizar Necesidades y generar reportes y graficas de los aspectos mencionados anteriormente.

![login](images/admin.png)


##### Crear categoria: 

Para poder crear una categoria se necesita su nombre, descripcion y validez, si la categoria es invalida impide que sea utilizada para crear una oferta o una necesidad.

![crearCate](images/crearCate.png)

##### Actualizar categoria:
Para actualizar uan categoria se debe escoger dentro de la lista desplegable de categorias y cambiar la caracteristica que desee.

![crearCate](images/actualizarCate.png)

##### Actualizar oferta:
Para actualizar una oferta se debe seleccionar en la lista desplegable el nombre de la oferta que se desea desplegar, y posteriormente elegir su nuevo estado.

![crearCate](images/actualizarOfer.png)

##### Actualizar necesidad:
Para actualizar una oferta se debe seleccionar en la lista desplegable el nombre de la oferta que se desea desplegar, y posteriormente elegir su nuevo estado.

![crearCate](images/actualizarNece.png)

##### Reportes:
Dentro de la vista de administrador se puede ver un reporte de ofertas, necesidades, respuestas y categorias, cada uno de estos se puede descargar como pdf o Excel 

![crearCate](images/reportes.png)

#####Graficas:

El administrador puede ver los reportes anteriormente mostrados de forma grafica. 

![crearCate](images/graficas.png)

------------------------------------------------------------------------------------

### Usuario
Este rol puede crear ofertas, a su vez puede crear respuestas a las necesidades o ofertas de otros usuarios. 

![crearCate](images/user.png)

##### Crear Oferta:
 para crear uan oferta se debe especificar la categoria a la que pertenece, su nombre y la descripcion.

![crearCate](images/crearOfe.png) 

#### Crear respuesta
Para poder crear una respuesta se debe escoger una oferta o necesidad de las tablas que se despliegan, posteriormente se redireccionara a responder esa oferta/necesidad en especifico.  

![crearCate](images/crearResp.png)
![crearCate](images/crearResp2.png) 

------------------------------------------------------------------------------------
### Estudiante

Este rol es el unico que puede crear Necesidades, pero a su vez al ser usuario puede crear ofertas y respuestas  ademas de esto tiene la posibilidad de actualizar las necesidades y las ofertas.   

![login](images/estudiante.png) 

##### Crear Necesidad: 
Para crear una neccesidad se necesita saber la categoria a la que pertenece, su nombre, descripcion y la urgencia con la que necesita una respuesta.

![crearCate](images/crearNece.png)

*como el estudiante es un usuario, tambien tiene las mismas funcionalidades* 

## Arquitectura y Diseño detallado

### Modelo E-R

![base](images/base.png) 

### Diagrama de Clases
![base](images/clases1.png)
![base](images/clases2.png)
![base](images/clases3.png)



## Enlace a la aplicación en Heroku


## Enlace al sistema de Integración Continua (Circle CI)
	
pendiente

## Enlace a Taiga

https://tree.taiga.io/project/jgarciah-solidaridad-escuela/timeline
## Enlace a Codacy

pendiente

## Descripción del Proceso

### Metodología
No hubo ninguna reunión presencial, todas las reuniones fueron realizadas de forma 100% virtual utilizando la plataforma de **Microsoft Teams**, en la cual realizábamos las sustentaciones de retroalimentación con el profesor, trabajábamos grupalmente desarrollando los Sprints en el horario de clase, y por fuera del horario de clase cada uno por su cuenta realizó las tareas que les fueron asignadas en el **Taiga**.

## Sprint 1

Se implemento el inicio de sesion por medio de Shiro, tomando usuarios de la base de datos y sus contraseñas, Posteriormente se crearon las categorias y necesidades , por ultimo se implemento la posibilidad de actualizar la categoria.
![base](images/sprint1.png)

## Sprint 2
se corrigieron errores y cosas incompletas del sprint 1 como un N maximo para la creacion de necesidades, si implementaron las ofertas, las respuestas y las actualizaciones de los parametros de cada una de estas.

![base](images/sprint2.png)

## Sprint 3
Se corriguieron los errores del sprint 3 como la navegabilidad de la aplicacion, el despliegue continuo, generar correctamente los excel y los PDF y los mensajes al usuario para tener una mejor experiencia
se implemento la posibilidad de eliminar categorias, las categorias no validas y los reportes de ofertas, necesidades y categorias
![base](images/sprint3.png)



## Credenciales para las Bases de Datos

* **Host:** ec2-3-233-7-12.compute-1.amazonaws.com

* **Database:** deckjsi71c2o3h

* **User:** brrlyybiheohdb

* **Port:** 5432

* **Password:** 696d65463569a973f469eb4ecf40fa501f73dda8709878a860f4c44643bdb5bc

* **URI:** postgres://brrlyybiheohdb:696d65463569a973f469eb4ecf40fa501f73dda8709878a860f4c44643bdb5bc@ec2-3-233-7-12.compute-1.amazonaws.com:5432/ddcvu5tsjj9ist

* **Heroku CLI:** 
