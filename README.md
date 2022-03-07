# API para la práctica.

---
## Contenido:

- Diagrama de clases.
- <details>
    <summary>Docker</summary>
    
    - Carpeta Init
    - mongodb.js
  </details>
- <details>
    <summary>Main</summary>
  
    - <details>
      <summary>App</summary>
    
        - PracticaFinalCursoBackApplication.java
        - configuration
        - controller
        - dto
        - error
        - mapper
        - model
        - repository
        - service
      </details>
    - <details>
        <summary>Resources</summary>
  
        - application.properties
      </details>
  </details>
- <details>
    <summary>Tests</summary>
  
    - controller
  </details>
    
---
## Docker

> - Carpeta Init con el script que crea la base de datos con dos datos de ejemplo
> - mongodb.js runnea el docker de la base de datos con todo lo que necesita.

---
## Main
### App
#### PracticaFinalCursoBackApplication.java
> Clase principal que se encarga de resetear la base de datos e introducir las pistas, administradores y dos usuarios de ejemplo en la base de datos, e inicializar la API.
#### Configuration
> Dividida en 4 subcarpetas, este paquete contiene la configuracion del swagger, el mapper, 
los cors y las json views, cada clase en su respectiva subcarpeta.

> Clases en este paquete:
> - CorsConfig
>- MapperConfig
>- Swagger
>- Views
#### Controller 
>Este paquete contiene los controladores de la api, los cuales gestionan los endpoints para las 
llamadas que se puedan hacer a la api, tanto operaciones CRUD como otras llamadas como por ejemplo, buscar pistas por tipo. 
Hay un controlador por cada entidad del modelo.

>Clases en este paquete:
>- AdminController
>- AlquilerController
>- ClienteController
>- InfraestructuraController
#### Dto 
>Paquete que contiene los Data Transfer Objects que necesitamos en la api. 

>Clases en este paquete:
>- AdminDTO
>- AlquilerDTO
>- ClienteDTO
>- InfraestructuraDTO
#### Error 
>Paquete con excepciones personalizadas.

>Clases en este paquete: 
>- ErrorController
>- GeneralError
>- Structure
#### Mapper 
>Paquete con las clases encargadas de convertir
> los DTO en clases del modelo y viceversa.

> Clases en este paquete: 
>- AdminMapper
>- AlquilerMapper
>- ClienteMapper
>- InfraestructuraMapper
#### Model 
> Clases que modelan las entidades que se guardan en la base de datos. 
> Estas clases pojo son la base del proyecto.
>
> También está el enum de tipos de pista, la clase del login y la clase abstracta User de la que 
> heredan los administradores y usuarios.

> Clases en este paquete: 
>- Admin
>- Alquiler
>- Cliente
>- Infraestructura
>- Login
>- TipoPista
>- User
#### Repository
> Este paquete contiene las interfaces que usará SpringBoot 
> para hacer las llamadas a la base de datos. Al estar usando mongo como base de datos, 
> estos interfaces extienden de MongoRepository, por lo que SpringBoot puede hacer las operaciones CRUD.
> 
> A parte de las operaciones CRUD básica, estos repositorios contienen todas las llamadas personalizadas que queremos.

> Clases en este paquete:
>- AdminRepository
>- AlquilerRepository
>- ClienteRepository
>- InfraestructuraRepository
#### Service 
> Este paquete contiene las clases de servicios, que se encargan de llamar al repositorio o repositorios necesarios
> para devolver lo que se le haya pedido, por ejemplo, un admin.

> Clases en este paquete:
>- AdminService
>- AlquilerService
>- ClienteService
>- InfraestructuraService

### Resources
> En esta carpeta sólamente se encuentra el fichero application.properties, el cual
> almacena las propiedades de la aplicacion en un diccionario, lo que hace mucho mas facil usarlas y, 
> sobre todo, cambiarlas si fuera necesario, pues en vez de tener que tocar todo el programa, solamente tendriamos 
> que modificar este fichero.
---
## Test 
> Como su nombre indica, aquí testeamos la aplicación gracias a JUnit y Mockito.
> 
> El único paquete que contiene es el de los controladores.
### Controller
> Este paquete contiene las clases de test de los controladores, que son las siguientes: 
>
>- AdminControllerTest
>- AlquilerControllerTest
>- ClienteControllerTest
>- InfraestructuraControllerTest

---
## Hecho por: 

| Programador             | GitHub                                       | Gmail                               |
|-------------------------|----------------------------------------------|-------------------------------------|
| Dylan Hurtado López     | [GitHub](https://github.com/DyLaNHurtado)    | [Gmail](dylanhurtado43@gmail.com)   |
| Eneko Rebollo Hernández | [GitHub](https://github.com/enekor)          | [Gmail](enekorebollo@gmail.com)     |
| Saúl Mellado Herrera    | [GitHub](https://github.com/saulmella12)     | [Gmail](saulmella12@gmail.com)      |
| Emilio López Novillo    | [GitHub](https://github.com/emilio2403)      | [Gmail](lopeznovillo2000@gmail.com) |
| Daniel Rodríguez Muñoz  | [GitHub](https://github.com/Idliketobealoli) | [Gmail](daniel.ro.mu02@gmail.com)   |
