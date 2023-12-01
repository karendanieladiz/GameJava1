/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package playjava;

/**
 *
 * @author Acer Nitro5
 */
public class Habilidad {
    private String nombreH;
    private int  efecto;


    public Habilidad() {
    }

    public Habilidad(String nombreH, int efecto ) {
        this.nombreH = nombreH;
        this.efecto = efecto;
        
    }

    
    public String getNombreH() {
        return nombreH;
    }

    public void setNombreH(String nombreH) {
        this.nombreH = nombreH;
    }

    public int getEfecto() {
        return efecto;
    }

    public void setEfecto(int efecto) {
        this.efecto = efecto;
    }
    @Override
    public String toString() {
    // Devuelve una representación de cadena que sea más legible
    return "Habilidad: " + nombreH ;
}
 
    
    
}
