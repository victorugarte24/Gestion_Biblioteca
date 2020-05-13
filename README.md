Gestión de Biblioteca
=====================

## Ejecutar Proyecto:
Crear la base de datos mysql con los ficheros que se encuentran en resources (Gestion_Biblioteca/src/main/resources/mysql).
Nombre de la base de datos: "gestion_biblioteca_db"
Usuario: "root"
Contraseña: "admin"

Compilar el proyecto ejecutando el comando:
```
mvn compile
```

Ejecutar el proyecto utilizando el comando:
```
mvn exec:java -D"exec.mainClass"="es.deusto.spq.main.main 
````

### Descripción y Contexto
---
  Esta aplicación está diseñada para ser utilizada para la gestión de bibliotecas. Los usuarios tienen distintos modos para encontrar información sobre los libros que se encuentran en el lugar, además, tienen la opción de reservarlos. Por otro lado, los bibliotecarios pueden conocer la ubicacion de los libros que se encuentran en sus instalaciones.

### Guía de usuario
---
Para usar la aplicación, el usuario debe registrarse. Una vez registrado, iniciará sesión y ya podrá utilizar la aplicación de gestión de la biblioteca.
Al entrar, el usuario estará en la ventana principal, dicha ventana será el menú principal de la aplicación. 
Si accede a la ventana libro, podrá buscar la información de los libros que estén en la biblioteca, asi como tomarlo prestado en caso de ser posible.
A continuación veremos un pequeño resumen de las ventanas:

* Esta será la primera ventana que verá el usuario al abrir la aplicación, deberá de insertar su nombre de usuario y contraseña, además debe de poner si quiere acceder como "Bibliotecario" o como "Usuario". En caso de no estar registrado debe pulsar en el botón "Registrarse":

![1](https://user-images.githubusercontent.com/43268879/80314464-f07fd900-87f1-11ea-9ed6-3223cc865670.JPG)

* Si el usuario no está registrado deberá clickar en "Registrarse" en la pantalla anterior y rellenar con sus datos en la siguiente pantalla:

![VentanaRegistro](https://user-images.githubusercontent.com/43268879/78472206-40a9d500-7737-11ea-8112-5b9c3d0b2a3d.jpg)

### Modo "Usuario"

* Al acceder a la aplicación, el usuario se encontrará con esta ventana, que será la principal. Aquí, el usuario podrá ver una serie de libros, además de poder hacer búsquedas mediante la barra superior. Podra búscar mediante diferentes criterios: Título, Autor e ISBN. Pulsando uno de los libros y haciendo clic en "Más información", accederemos a la ventana donde aparecen los detalles de los libros.

![image](https://user-images.githubusercontent.com/43268879/80314598-c4b12300-87f2-11ea-8982-0ba5fc262a8f.png)

* En esta ventana podemos ver la información sobre el libro seleccionado. Además, podemos acceder a otra ventana donde podemos ver la información del autor.

![ventanalibro](https://user-images.githubusercontent.com/43268879/80314697-51f47780-87f3-11ea-86ea-0b8548faf9da.JPG)

* Esta es la ventana que nos ofrece información sobre el autor del libro.

![ventanaautor](https://user-images.githubusercontent.com/43268879/80314766-b0215a80-87f3-11ea-9cca-058ba15b0116.JPG)

### Modo "Bibliotecario"

Ahora veremos como funciona el programa en caso de seleccionar la opción "Bibliotecario" en la primera ventana.

* Esta ventana tiene similitud con la pantalla principal del modo "Usuario". Una de las mayores diferencias es que la ventana nos adelanta información sobre los libros en la parte izquierda de la pantalla.

![image](https://user-images.githubusercontent.com/43268879/80314802-f1b20580-87f3-11ea-8ca7-e0f27ee31c20.png)

* Para poder saber la ubicación de un libro podemos usar esta ventana, que nos ofrece de manera ilustrativa la información.

![image](https://user-images.githubusercontent.com/43268879/80314857-6127f500-87f4-11ea-98d3-49d17eaa555c.png)


## Proyecto realizado con:
* [Maven](https://maven.apache.org/) - Dependency Management
* [MySQL](https://www.mysql.com/) - Base de datos
* [Java 8](https://www.oracle.com/java/technologies/javase/javase-jdk8-downloads.html) - Java SE Development Kit 8

## Desarrollado por:
* Jonathan Blázquez 
* Víctor Ugarte 
* Sergio Cogollos
