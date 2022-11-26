/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejerciciojavap4;

/**
 *
 * @author alexc
 */
public abstract class Casilla {
    private String nombre;
    
    Casilla(String nombre){
        this.nombre = nombre; 
    }
    
    boolean recibeJugador(){
            System.out.println(" Soy una casilla y recibo a un jugador ");
            
            return true;
    }
    
    abstract float precioCompra();
        
    
    
    
}
