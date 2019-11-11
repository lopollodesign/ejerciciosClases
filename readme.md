# Proyecto final

Vicenç Álvarez Garau. 
Palma de Mallorca, 11 Noviembre 2019

## Mi objetivo

Llevar a cabo el uso de todos los conocimientos adquiridos en el curso enfocándome a los intereses personales de cara al futuro, en mi caso, la **orientación a objetos**. 

## El poyecto
El proyecto simula una agencia viajes sencilla. Te crea una cantidad de viajes elegido de forma aleatoria con los que podrás interactuar de dos maneras: abriendo sus detalles o borrándolo de la lista. 

Se ha dado mucha importancia a la escasez de la posibilidad de casos de error del usuario mediante la comprobación de los datos introducidos por éste, a la hora de pedir un código en la terminal, comprobar su existencia y ofrecerle una alternativa razonable.

He querido reforzar el uso de buenas prácticas, tanto a nivel de archivo como de arquitectura del proyecto, como si se tratara de un proyecto más completo, con posibilidad de ser escalable o ampliable. 

## Estructura

El proyecto se divide en 4 bloques:

- **Factory**: Es donde se procesan los datos, tanto la creación como la carga. 
- **Front**: Encargado de como se muestran los datos y como se interactua con el programa. 
- **Models**: Es la carpeta donde se encuentran los objetos de lo que se compone un viaje.
- **Utils**. 

**Detalle del bloque Factory:**

Dentro del `Factory.class` encontramos estas clases:
- **Data**: Este archivo solo se usa la primera vez que se iniciar el proyecto. Están los datos puestos a mano, creándose dentro instancias de los modelos básicos para el programa. Por decirlo de alguna manera, es la base de datos de los datos estáticos.
- **Serial**: Es el encargado de meter los datos del anterior en archivos o, en el caso de ya estar guardado, cargarlos de éstos.
- **TravelAgent**: Es el simulador del agente de viajes. Una vez cargados los datos anteriores, puede crear y gestionar los viajes.

**¿Qué tiene un viaje y que datos se pueden mostrar?**

Cuando se crea un viaje se asignan dos destinos aleatorios, el primero solo se usa para calcular la distancia, mientras que en el segundo es de donde se busca un hotel y un número aleatorio de actividades.

A la hora de calcular el precio, se suma cada uno de los servicios y el de la conexión, éste último dependerá de la distancia, y del tipo de transporte._(Por falta de tiempo, la conexión solo contempla la ida, no la vuelta, o sea que esperemos que le guste el destino al pasajero...)_

**Detalle del bloque Front:**

En todo momento se ha buscado la máxima independencia en cuanto a las responsabilidades, y con el Front pasa exactamente lo mismo, se ha delegado a la clase `App.class` todo el pintado de los mensajes y datos. También de los métodos genéricos como el de confirmación, pudiendo usar siempre los mismos sin repetir código.

## Iniciación

En el `Main.class` está activado el guardado del los datos en los archivos de formato "*txt*" desde el `Data.class`. Esto hace que se pase a dichos archivos en la url "*C:/json*" una info puesta a mano. Una vez iniciado la primera vez se puede poner en "false". (Cuando se acabe de revisar la tarea se puede borrar sin problema).

```java
new TravelAgent(true, travelsQuantity(true))
```
*(El primer parámetro)*

## Funcionamiento

_Al dedicar más tiempo en el punto anterior (Estructura), el funcionamiento no tiene mucha magia, o no tanto como me hubiera gustado._

**Pasos:**

- Al iniciarse se pide al usuario cuantos viajes se quieren auto-generar.
- Se muestra la lista de los viajes con los datos básicos.
- En dicha lista están las opciones que hay de cada uno de ellos.
- Se puede abrir un viaje mostrándose la información completa.
- Se puede borrar individualmente  siempre con la confirmación del usuario.
- En el caso de no quedar viajes te da la opción de salir o de volver a auto-generar y con cuantos viajes. 
- repetir y volver a empezar.

## Github

Aquí se puede ver progreso con los commits de cada paso que se ha hecho:

[Link a github del proyecto](https://github.com/lopollodesign/ejerciciosClases/tree/master/src)

## Pasos imaginarios

Hice hasta tener tiempo, pero tenía alguna idea extra para añadir al proyecto:

- Añadir un Viaje Aleatorio
- Añadir una instancia de forma manual en la misma terminal, guardándose en el archivo del que se ha cargado ese tipo de clase, por ejemplo un destino.
- Añadir y borrar un servicio concreto a una reserva con un localizador.
- Cambiar de hotel (Con el mensaje final de _"No hay más opciones"_).
- Serializar también los viajes: Iba a hacer que los viajes estuvieran en una List, no en un HashMap, y al cargarse se le asignara un localizador aleatorio cada vez que se arranque el proyecto.
