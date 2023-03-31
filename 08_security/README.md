# Ejemplo de Formulario
Mediante la anotacion `@GetMapping` del controlador se accede a las 
diferentes vistas: 
* Listado de empleados
* Registro de nuevo empleado
* Edición de un empleado

## Listado
Muestra el listado de todos los trabajadores con sus respectivos valores.  
La variable del campo _directivo (boolean)_ se recoge con un icono. 
`<"th:if="${empleado.directivo}"><i class="fa-solid fa-check"></i>
<"th:unless="${empleado.directivo}"><i class="fa-solid fa-xmark"></i>`

## Registro de nuevo empleado
Permite rellenar los diferentes campos del objeto _Empleado_ que se pasa al controlador.  
Con la anotacion `@PostMapping("/new/empleado/submit")` realizamos la accion al pulsar sobre el boton de **enviar**,
que es introducir al nuevo empleado en la Lista (definida en la clase _EmpleadoService_)
y redirigir hacia la URL del listado para ver que se ha insertado correctamente.  
Se añaden validaciones a las diferentes propiedades de la clase _Empleado_ mediante las  
anotaciones `@Min, @NotEmpty ...`. Para hacer uso de estas anotaciones tambien es necesario
añadir la siguiente depedencia en el pom.xml:  
`<dependency>`  
`<groupId>org.springframework.boot</groupId>`  
`<artifactId>spring-boot-starter-validation</artifactId>`  
`</dependency>`  
La gestión de los posibles errores en estas validaciones se hace mediante la clase `MyConfig`,
cuyos métodos estan anotados con `@Bean`. Tambien se crea un archivo `errors.properties`
con los mensajes de error personalizados.

## Edición de un empleado
Se rescata el objeto `Empleado` con sus datos buscando por ID. Una vez editados  
los valores se inserta de nuevo en la lista, borrando el anterior (esto se lleva  
a cabo gracias a los métodos `buscarID` y `edit` de la clase `EmpleadoService`).  
Se reutiliza la plantilla de formulario tanto para crear nuevos usuarios como para  
editar los ya existentes, haciendo uso de las funcionalidades de Thymeleaf.  
**Nota:** Al editar un empleado, su campo de ID es de solo lectura, puesto que es una   
referencia única y no deberia ser modificable.

## Login:
Para acceder a la aplicacion se implementa un login, añadiendo la siguiente dependencia  
en el pom.xml:  
`<dependency>`  
`<groupId>org.springframework.boot</groupId>`  
`<artifactId>spring-boot-starter-security</artifactId>`  
`</dependency>`  
La configuracion de esta barrera de seguridad se hace en la clase `SecurityConfig`, dentro  
del paquete Seguridad.