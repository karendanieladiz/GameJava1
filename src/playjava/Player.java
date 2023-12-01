/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package playjava;

import java.util.Random;

/**
 *
 * @author Acer Nitro5
 */
public class Player {

    private String nombre;
    private int vida;
    private Arma arma;
    private Habilidad habilidad;
    private Zona zona;

    public Player() {
    }

    public Player(String nombre, Habilidad habilidad) {
        this.nombre = nombre;
        this.vida = 200;
        this.habilidad = habilidad;

    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getVida() {
        return vida;
    }

    public void setVida(int vida) {
        this.vida = vida;
    }

    public Arma getArma() {
        return arma;
    }

    public void setArma(Arma arma) {
        this.arma = arma;
    }

    public Habilidad getHabilidad() {
        return habilidad;
    }

    public void setHabilidad(Habilidad habilidad) {
        this.habilidad = habilidad;
    }

    public Zona getZona() {
        return zona;
    }

    public void setZona(Zona zona) {
        this.zona = zona;
    }

    public void aumentarVida(int factor) { // cuando el arma es la 'Chancla'
        this.vida *= factor;

    }

    public void enfrentar(Player oponente) {
        System.out.println("\n¡Comienza el enfrentamiento entre " + this.getNombre() + " y " + oponente.getNombre() + "!");

        // Se decide aleatoriamente quién ataca primero
        boolean primerAtacante = new Random().nextBoolean();

        while (this.getVida() > 0 && oponente.getVida() > 0) {
            // Determinar quién ataca primero en este turno
            Player atacante = (primerAtacante) ? this : oponente;
            Player defensor = (primerAtacante) ? oponente : this;

            // Calcular el daño y aplicarlo al defensor
            int danioInfligido = atacante.getArma().getDaño();
            // Aplicar el daño al defensor
            defensor.reducirVida(danioInfligido);
            System.out.println(defensor.getNombre() + " ahora tiene " + defensor.getVida() + " puntos de vida.");

           

            // Cambiar el turno para el próximo turno
            primerAtacante = !primerAtacante;
        }

        // Imprimir el resultado del enfrentamiento
        if (this.getVida() <= 0) {
            System.out.println(this.getNombre() + " ha sido eliminado.");
        } else {
            System.out.println(oponente.getNombre() + " ha sido eliminado.");
        }
    }
    public void reducirVida(int cantidad) {
        vida = Math.max(0, vida - cantidad);
    }



    @Override
    public String toString() {
        return nombre + "  HP: " + vida;
    }

}
