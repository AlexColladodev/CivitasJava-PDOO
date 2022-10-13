
package ejercicioclasepracticas;

import java.util.ArrayList;

/**
 *
 * @author SatoriAlex // Alexander Collado Rojas Y7412507N
 */
public class Hotel {
    
    //Atributo de clase
    private static int NUM_HOTELES = 0; //Lo inicializo al crearlo para tenerlo en 0
    private static final float[] FACTOR_EST = {1.2f, 1.5f, 2.0f, 2.5f, 3.0f};
    
    //Atributos de instancia
    private String nombre;
    private String ciudad;
    private int estrellas;
    private Director director;
    private ArrayList<Reserva> reservas = new ArrayList<>();
    private Parcela parcela;
    private Caracteristicas caracteristicas;
    private ArrayList<Empleado> empleados = new ArrayList<>();
    private ArrayList<Habitacion> habitaciones = new ArrayList<>();
    
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
    
    public int getEstrellas(){
        return this.estrellas;
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
    
    public boolean addEmpleado(Empleado empleado){
        this.empleados.add(empleado);
        
        return true;      
    }
    
    public void addHabitacion(int capacidad, int numero){
        this.habitaciones.add(new Habitacion(capacidad, numero));
    }
    
    public int getNumHabitaciones(){
        return this.habitaciones.size();
    }
    
    public int buscarHabitacion(int capacidad){
        
        int num = -1;
        
        for(int i = 0; i < habitaciones.size(); i++){
            if(habitaciones.get(i).getCapacidad() == capacidad){
                num = habitaciones.get(i).getNumero();
            }
        }
        
        return num;
    }
    
    public int costePorDia(){
        int sumaEmpleado = 0;
        int sumaHabitacion = 0;
        
        for(int i = 0; i < empleados.size(); i++){
            sumaEmpleado += this.empleados.get(i).costeEmpleados();
        }
        
        for(int i = 0; i < habitaciones.size(); i++){
            sumaHabitacion += this.habitaciones.get(i).costeMantenimiento();
        }
        
        return sumaEmpleado + sumaHabitacion;
    }
    
    public static float getFactor(int n){
        return Hotel.FACTOR_EST[n-1];
    }
    
    
}
