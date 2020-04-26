Gestión de Biblioteca
=====================

### Descripción y Contexto
---
  Esta aplicación está diseñada para ser utilizada para la gestión de bibliotecas. Los usuarios tienen distintos modos para encontrar información sobre los libros que se encuentran en el lugar, además, tienen la opción de reservarlos. Por otro lado, los bibliotecarios pueden conocer la ubicacion de los libros que se encuentran en sus instalaciones.

### Guía de usuario
---
Para usar la aplicación, el usuario debe registrarse. Una vez registrado, iniciará sesión y ya podrá utilizar la aplicación de gestión de la biblioteca.
Al entrar, el usuario estará en la ventana principal, dicha ventana será el menú principal de la aplicación. 
Si accede a la ventana libro, podrá buscar la información de los libros que estén en la biblioteca, asi como tomarlo prestado en caso de ser posible.
A continuación veremos un pequeño resumen de las ventanas:

* Esta será la primera ventana que verá el usuario al abrir la aplicación:

![VentanaLogin](https://user-images.githubusercontent.com/43268879/78472092-8d40e080-7736-11ea-8ee8-a8f5ee233846.jpg)

* Si el usuario no está registrado deberá clickar en "Registrarse" en la pantalla anterior y rellenar con sus datos en la siguiente pantalla:

![VentanaRegistro](https://user-images.githubusercontent.com/43268879/78472206-40a9d500-7737-11ea-8112-5b9c3d0b2a3d.jpg)

* Al acceder a la aplicación, el usuario se encontrará con esta ventana, que será la principal. Aquí, el usuario podrá ver una serie de libros, además de poder hacer búsquedas mediante la barra superior.

![ventanaPrincipal](https://user-images.githubusercontent.com/43268879/78564087-3ca3b300-781c-11ea-9eb8-220d377dbb67.jpg)

* En está última ventana, denominada como ventana libro, será la que el usuario verá al realizar una búsqueda de algún libro. En dicha ventana se podrá ver la información y existirá la opción de poder reservarlo.

![ventanaLibro](https://user-images.githubusercontent.com/43268879/78564571-ebe08a00-781c-11ea-9596-d4235451665a.jpg)


## Proyecto realizado con:
* [Maven](https://maven.apache.org/) - Dependency Management
* [MySQL](https://www.mysql.com/) - Base de datos
* [Java 8](https://www.oracle.com/java/technologies/javase/javase-jdk8-downloads.html) - Java SE Development Kit 8

## Desarrollado por:
* Jonathan Blázquez 
* Víctor Ugarte 
* Nicolás Cerero
* Sergio Cogollos

## Ejecutar Proyecto:
Instalar la base de datos mysql con los dos ficheros que se encuentran en resources.
Ejecutar el comando en la ruta del proyecto: mvn exec:java -D"exec.mainClass"="es.deusto.spq.main.main"
