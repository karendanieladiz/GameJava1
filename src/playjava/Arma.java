/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package playjava;

/**
 *
 * @author Acer Nitro5
 */
public class Arma {
    private String nombre;
    private int daño;

    public Arma() {
    }

    public Arma(String nombre, int daño) {
        this.nombre = nombre;
        this.daño   = daño;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getDaño() {
        return daño;
    }

    public void setDaño(int daño) {
        this.daño = daño;
    }
    
     @Override
    public String toString() {
        return nombre +" (Danio "+daño+")" ;
    }
    
    
    
    
}
