/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejercicioclasepracticas;

/**
 *
 * @author alexc
 */
public class Reserva {
    private String fechaEntrada;
    private String fechaSalida;
    private Cliente cliente;
    private Hotel hotel;
    
    public Reserva(String fechaEntrada, String fechaSalida, Cliente cliente, Hotel hotel){
        this.fechaEntrada = fechaEntrada;
        this.fechaSalida = fechaSalida;
        this.cliente = cliente;
        this.hotel = hotel;
        /*
        this.hotel.addReserva(cliente, fechaEntrada, fechaSalida);
        this.cliente.addReserva(this);*/
        
    }
    
    public String getFechaEntrada(){
        return this.fechaEntrada;
    }
    
    public String getFechaSalida(){
        return this.fechaSalida;
    }
    
    public Cliente getCliente(){
        return this.cliente;
    }
}
