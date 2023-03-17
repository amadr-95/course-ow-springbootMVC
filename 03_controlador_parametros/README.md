##  Ejemplo de un controlador que muestra varias vistas html
### Vista index.html
Haciendo uso de la anotación `@RequestParam` muestra el texto fijo _"Hola + [nombre]"_, siendo
[nombre] el valor que se le especifica en la URL `localhost:9000/?name=[name]`.
Si no se le especifica ningun nombre, por defecto muestra el texto _"Hola Mundo"_

### Vista info.html
Esta vista tan solo muestra el texto fijo _"Estoy aprendiendo a usar diferentes vistas con un controlador"_
