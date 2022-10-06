
package ejercicioclasepracticas;

import java.util.ArrayList;

/**
 *
 * @author SatoriAlex // Alexander Collado Rojas Y7412507N
 */
public class Hotel {
    
    //Atributo de clase
    private static int NUM_HOTELES = 0; //Lo inicializo al crearlo para tenerlo en 0
    
    //Atributos de instancia
    private String nombre;
    private String ciudad;
    private int estrellas;
    private Director director;
    private ArrayList<Reserva> reservas = new ArrayList<>();
    private Parcela parcela;
    private Caracteristicas caracteristicas;
    
    //Constructor
    public Hotel(String nombre, String ciudad, int estrellas, Parcela parcela, Caracteristicas caracteristicas){
        this.nombre = nombre;
        this.ciudad = ciudad;
        this.estrellas = estrellas;
        this.parcela = parcela;
        this.caracteristicas = caracteristicas;
        
        
        NUM_HOTELES++; //Cada vez que se cree un nuevo hotel se aumentara el valor 
        
        parcela.addHotel(this);
    }
    
    //Metodo de Clase
    public static int getNUM_HOTELES(){
        return Hotel.NUM_HOTELES;
    }
    
    //Metodos de Instancia
    public void setDirector(Director director){
        this.director = director;
    }
    
    public Director getDirector(){
        return this.director;
    }
    
    public ArrayList<Reserva> getReservas(){
        return this.reservas;
    }
    
    public void addReserva(Cliente cliente, String fechaEntrada, String fechaSalida){
        reservas.add(new Reserva(fechaEntrada, fechaSalida, cliente, this));
    }
    
    public Caracteristicas getCaracteristicas(){
        return this.caracteristicas;
    }
}
