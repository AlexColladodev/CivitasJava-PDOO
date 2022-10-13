/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejercicioclasepracticas;

/**
 *
 * @author alexc
 */
public class Restaurante {
    private String nombre;
    private int estrellas;
    private float precioMedio;
    private int aforo;
    private Hotel hotel;
    
    public Restaurante(String nombre, int estrellas, float precio, int aforo){
        this.nombre = nombre;
        this.estrellas = estrellas;
        this.precioMedio = precio;
        this.aforo = aforo;
        this.hotel = null;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEstrellas() {
        return estrellas;
    }

    public void setEstrellas(int estrellas) {
        this.estrellas = estrellas;
    }

    public float getPrecioMedio() {
        return precioMedio;
    }

    public void setPrecioMedio(float precioMedio) {
        this.precioMedio = precioMedio;
    }

    public int getAforo() {
        return aforo;
    }

    public void setAforo(int aforo) {
        this.aforo = aforo;
    }
    
    public void setHotel(Hotel h){
        this.hotel = h;
    }
    
    
}
