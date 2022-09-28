
package civitas;

/**
 *
 * SatoriAlex // Alexander Collado Rojas Y7412507N
 */
public class Director {
    
    //Atributos de instancia
    private String nombre;
    private long telefono;
    
    //Cosntructor
    public Director(String nombre, long telefono){
        this.nombre = nombre;
        this.telefono = telefono;
    }
    
    public String getNombre(){
        return this.nombre;
    }
    
}
