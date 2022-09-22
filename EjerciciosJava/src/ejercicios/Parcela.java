
package ejercicios;

//@author SatoriAlex // Alexander Collado Rojas Y7412507N

public class Parcela {
    
    //Atributos de clases -- llevan static
    
    //Atributos de instancia
    private String nombre;
    private float precioCompra, precioEdificar, precioBaseAlquiler;
    private int numCasas, numHoteles;
    
    //Constructores
    Parcela(String nombre, float precioCompra, float precioEdificar, float precioBaseAlquiler){
        
        //El this para identificar el objeto del metodo
        this.nombre = nombre;
        this.precioCompra = precioCompra;
        this.precioEdificar = precioEdificar;
        this.precioBaseAlquiler = precioBaseAlquiler;
        
        //Todos los atributos deben ser inicializados en los constructores
        numCasas = 0;
        numHoteles = 0;
        
    }
    
    //Metodos Consultores
    String getNombre(){
        return nombre;
    }
    
    float getPrecioCompra(){
        return precioCompra;
    }
    
    float getPrecioEdificar(){
        return precioEdificar;
    }
    
    int getNumCasas(){
        return numCasas;
    }
    
    int getNumHoteles(){
        return numHoteles;
    }
    
    //Formula indicada en las reglas del juego 
    float getPrecioAlquilerCompleto(){
        return (precioBaseAlquiler * ( 1 + numCasas + numHoteles * 4));
    }
    
    //Metodos Modificadores
    boolean construirCasa(){
        //Sin restricciones de comprobacion
        numCasas++;
        
        return true;
    }
    
    boolean construirHotel(){
        //Sin restricciones de comprobacion
        numHoteles++;
        
        return true;
    }
       
}
