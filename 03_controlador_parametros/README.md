##  Ejemplo de un controlador que muestra varias vistas html
### Vista index.html
Haciendo uso de la anotación `@RequestParam` muestra el texto fijo _"Hola + [nombre]"_, siendo
[nombre] el valor que se le especifica en la URL `localhost:9000/?name=[name]`.  
Si no se le especifica ningun nombre, por defecto muestra el texto _"Hola Mundo"_  
Tambien existe otra version de esta vista en la que se usa la anotación `@PathVariable`  
para mostrar el saludo, pasando directamente la variable a la URL. `localhost:9000/saludo/[name]`

### Vista info.html
Esta vista tan solo muestra el texto fijo _"Estoy aprendiendo a usar diferentes vistas con un controlador"_

### Vista welcome.html
Muestra un saludo personalizado: _Welcome, 'nombre' 'apellido'!_  
El _nombre_ y el _apellido_ se obtienen a través de dos métodos diferentes:
* Un método usa la anotación `@RequestParam`, mediante la cual se le pasan los parámetros  
a la vista. `localhost:9000/welcome/?firstName=[firstName]&lastname=[lastName]`
* Y el otro método usa la anotación `@PathVariable`, mediante la cual se pasan las variables  
directamente a la URL. `localhost:9000/welcome/[firstName][lastName]`