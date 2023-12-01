/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package playjava;

/**
 *
 * @author Acer Nitro5
 */
public class Mapa {

    private String nombre;
    private String descripcion;
    //

    public Mapa() {
    }

    public Mapa(String nombre) {
        this.nombre = nombre;
        this.descripcion = obtenerDescripcion(nombre);
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    //continentes son  objetos para la lista 

    private String obtenerDescripcion(String nombreContinente) {
        switch (nombreContinente) {
            case "Africa":
                return "¡Bienvenido a África! Un vasto territorio lleno de misterios y peligros. "
                        + "\nPrepárate para enfrentarte a feroces bestias y explorar la rica "
                        + "\ndiversidad de la fauna salvaje.";
            case "America del Norte":
                return "¡En América del Norte, la batalla está a punto de comenzar! "
                        + "\nDesde las bulliciosas calles de las ciudades hasta los paisajes "
                        + "\nhelados del norte, prepárate para enfrentarte a desafíos en cada rincón.";
            case "America del Sur":
                return "¡Surca la selva impenetrable y escala las alturas de los Andes "
                        + "\nen América del Sur! Este continente vibrante y diverso te desafiará con su "
                        + "\nbelleza natural y peligros ocultos.";
            case "Asia":
                return "¡Enfréntate a la grandeza de Asia! Desde los bulliciosos mercados hasta "
                        + "\nlas antiguas tierras de misterio, prepárate para descubrir tus habilidades "
                        + "\nen medio de la rica cultura y la historia intrigante.";
            case "Europa":
                return "¡Explora las majestuosas tierras de Europa! Con sus ciudades llenas "
                        + "\nde historia, arquitectura impresionante y desafíos estratégicos, "
                        + "\nesta batalla te llevará a través de una experiencia única.";
            case "Oceania":
                return "¡Las aguas cristalinas y las islas paradisíacas de Oceanía son el "
                        + "\nescenario de tu próxima batalla! Prepárate para enfrentarte a enemigos "
                        + "\nen un entorno idílico con sorpresas bajo la superficie.";
            case "Antartida":
                return "¡Bienvenido a la Antártida, el continente más frío de la Tierra! "
                        + "\nAquí, la batalla se libra en medio de vastas extensiones de hielo "
                        + "\ny en condiciones extremas. ¡Prepárate para la lucha en este inhóspito terreno!";
            default:
                return "Descripción no disponible";
        }
    }
}
