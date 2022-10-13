
package ejercicioclasepracticas;

import java.util.ArrayList;

/**
 *
 * @author alexc
 */
public class Empleado {
    
    private String nombre;
    private ArrayList<Hotel> trabaja;
    private int numHorasJornadas;
    private float costePorHora;
    
    public Empleado(String nombre){
        this.nombre = nombre;
        this.trabaja = null;
        this.trabaja = new ArrayList<>();
        this.numHorasJornadas = 0;
        this.costePorHora = 8.2f;
    }
    
    public String getNombre(){
        return this.nombre;
    }
    
    public boolean addTrabajo(Hotel hotel){
        
        boolean r = false;
        
        if(trabaja.size() < 2){
            trabaja.add(hotel);
            r = true;
        }
        
        return r;
    }
    
    public int getNumHorasJornadas(){
        return this.numHorasJornadas;
    }
    
    public void setNumHorasJornadas(int n){
        this.numHorasJornadas = n;
    }
    
    public float getCostePorHora(){
        return this.costePorHora;
    }
    
    public void setCostePorHora(float f){
        this.costePorHora = f;
    }
    
    public float costeEmpleados(){
        return this.costePorHora * this.numHorasJornadas;
    }
}
