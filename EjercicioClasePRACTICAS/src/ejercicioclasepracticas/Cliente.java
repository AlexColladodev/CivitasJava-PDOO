/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejercicioclasepracticas;

import java.util.ArrayList;

/**
 *
 * @author alexc
 */
public class Cliente {
    private String dni;
    private String nombre;
    private ArrayList<Reserva> reservas = new ArrayList<>();
    
    
    public Cliente(String dni, String nombre){
        this.dni = dni;
        this.nombre = nombre;
    }
    
    public String getNombre(){
        return this.nombre;
    }
    
    public void addReserva(Reserva reserva){
        reservas.add(reserva);
    }
    
    public ArrayList<Reserva> getReservas(){
        return this.reservas;
    }
}
