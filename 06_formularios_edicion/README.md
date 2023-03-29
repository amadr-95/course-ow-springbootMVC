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

## Edición de un empleado
Se rescata el objeto _Empleado_ con sus datos buscando por ID. Una vez editados  
los valores se inserta de nuevo en la lista, borrando el anterior (esto se lleva  
a cabo gracias a los métodos _buscarID_ y _edit_ de la clase _EmpleadoService_).  
Se reutiliza la plantilla de formulario tanto para crear nuevos usuarios como para  
editar los ya existentes, haciendo uso de las funcionalidades de Thymeleaf.