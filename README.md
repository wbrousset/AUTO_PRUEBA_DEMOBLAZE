# Prueba Demoblaze
Se realizaron 5 escenarios de pruebas para validar la funcionalidad de la plataforma
Para este proyecto se esta utilizando BDD, Java/Cucumber/Serenity

# Configuración de su maquina
* Establecer y configurar`JAVA_HOME, MAVEN_HOME` como variables de entorno
* Instalar Eclipse IDE
* Instalar plugin de Cucumber

## Escenarios 
* Se crearon los siguientes escenarios:
* 1.- @Signup: Dar de alta a un usuario
* 2.- @Login: Log in de un usuario
* 3.- @Logout: Log out de un usuario
* 4.- @AgregarLaptop: Agregar laptop al carrito
* 5.- @ValidarCart: Validar productos agregados al carrito

# Modo de ejecución
* Importar el proyecto desde File/Maven/Existing Maven Projects
* Instalar las dependencias del POM: en el nombre del proyecto hacer click derecho/Maven/Update Project
* Ir al package run y abrir el archivo Run.java
* Desde el mismo archivo Run.java hacer click derecho/Run As/Junit Test

# Reporte
* En el nombre del proyecto hacer click derecho/Show in/Terminal
* En la terminal escribir mvn serenity:aggregate y darle enter
* Verificar el reporte en la carpeta del proyecto target/site/serenity/index-html
