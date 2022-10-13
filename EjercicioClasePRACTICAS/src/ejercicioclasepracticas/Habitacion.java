/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejercicioclasepracticas;

/**
 *
 * @author alexc
 */
public class Habitacion {
    private static final float FACTOR = 2.6f;
    
    private int numero;
    private int capacidad;
    
    public Habitacion(int numero, int capacidad){
        this.capacidad = capacidad;
        this.numero = numero;
    }
    
    public int getNumero(){
        return this.numero;
    }
    
    public int getCapacidad(){
        return this.capacidad;
    }
    
    public float costeMantenimiento(){
        return this.capacidad * FACTOR;
    }
    
}
