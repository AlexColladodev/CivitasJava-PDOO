
package ejercicioclasepracticas;

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
    
    //Constructor
    public Hotel(String nombre, String ciudad, int estrellas){
        this.nombre = nombre;
        this.ciudad = ciudad;
        this.estrellas = estrellas;
        
        NUM_HOTELES++; //Cada vez que se cree un nuevo hotel se aumentara el valor 
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
}
