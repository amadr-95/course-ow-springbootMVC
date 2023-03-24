# Ejemplo de Formulario
Mediante la anotacion `@GetMapping` del controlador se accede a las 
diferentes vistas: 
* Listado de empleados
* Registro de nuevo empleado

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