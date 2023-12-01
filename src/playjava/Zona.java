/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package playjava;

/**
 *
 * @author Acer Nitro5
 */
public class Zona {
    private String nombre;
    private Arma arma;
    private Player luchador;

    public Zona(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Arma getArma() {
        return arma;
    }

    public void setArma(Arma arma) {
        this.arma = arma;
    }

    public Player getLuchador() {
        return luchador;
    }

    public void setLuchador(Player luchador) {
        this.luchador = luchador;
    }

   
    
    
}
