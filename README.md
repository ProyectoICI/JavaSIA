## Requisitos generales del sistema
Los proyectos considera el desarrollo de un producto de software que dé respuesta a una
necesidad de la sociedad.
Ambos softwares deberán ser implementados en su totalidad por el grupo de trabajo.
Los problemas a abordar deben ser escogido y modelados por los propios alumnos en grupos
de 2 a 3 personas. Se sugiere conformar grupos de a 3 por un tema de carga académica.
Toda entrega se realizará por el aula virtual.
Los proyectos deberán ser desarrollados bajo el lenguaje de JAVA.

## Proyecto Sistema de Información (SIA) Avance

- SIA1.1 Realizar un análisis de los datos a utilizar y principales funcionalidades a implementar que dan
sentido a la realización del proyecto.

- SIA1.2 Diseño conceptual de clases del Dominio y su código en Java

- <span style="color:green">SIA1.3 Todos los atributos de todas las clases deben ser privados y poseer sus respectivos métodos de
lectura y escritura (getter y setter).</span>

- SIA1.4 Se deben incluir datos iniciales dentro del código.

- <span style="color:yellow">SIA1.5 Diseño conceptual y codificación de 2 colecciones de objetos, con la 2ª colección anidada como
muestra la figura. Las colecciones pueden ser implementadas mediante arreglos o clases del
Java Collections Framework  (JCF).</span> 

- SIA1.6 Diseño conceptual y codificación de 2 clases que utilicen sobrecarga de métodos (no de
constructores)

- SIA1.7 Diseño conceptual y codificación de al menos 1 clase mapa del Java Collections Framework

- SIA1.8 Se debe hacer un menú para el Sistema donde ofrezca las funcionalidades de: 1) Inserción
Manual / agregar elemento y 2) Mostrar por pantalla listado de elementos. Esto para la 2ª
colección de objetos (colección anidada) del SIA1.5

- <span style="color:green">SIA1.9 Todas las funcionalidades deben ser implementadas mediante consola (Sin ventanas) </span>

- <span style="color:green">SIA1.10 Utilización de GitHub (Realización de al menos 3 Commit) </span>

```
src/
├── controller/
│   └── ShiftController.java
├── model/
│   ├── Nurse.java
│   ├── Shift.java
│   ├── Department.java
│   └── InitialData.java
├── repository/
│   └── ShiftRepository.java
├── service/
│   ├── ShiftService.java
│   └── NurseService.java
└── ui/
    └── ConsoleUI.java
```
