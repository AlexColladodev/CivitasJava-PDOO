
package ejercicios;

//@author SatoriAlex // Alexander Collado Rojas Y7412507N

public class Parcela {
    
    //Atributos de clases -- llevan static
    static final float FACTORALQUILERCALLE = 1.0f;
    static final float FACTORALQUILERCASA = 1.0f;
    static final float FACTORALQUILERHOTEL = 4.0f;
    
    //Atributos de instancia
    private String nombre;
    private float precioCompra, precioEdificar, precioBaseAlquiler;
    private int numCasas, numHoteles;
    
    //Cambios SESION 1
    private float largo;
    private float ancho;
    
    //Metodos Getter y Setters
    float getLargo(){
        return largo;
    }
    
    float getAncho(){
        return ancho;
    }
    
    void setAncho(float ancho){
        this.ancho = ancho;
    }
    
    void setLargo(float largo){
        this.largo = largo;
    }
    
    float getDimension(){
        return largo * ancho;
    }
    
    float costePorMetroCuadrado(){
        return getDimension() / precioCompra;
    }
    
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
        return (precioBaseAlquiler * ( FACTORALQUILERCALLE + numCasas * FACTORALQUILERCASA + numHoteles * FACTORALQUILERHOTEL));
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
    
    //Metodos
    boolean igualdadIdentidad(Parcela otraParcela){
        
        boolean identidad = false;
        
        if(this == otraParcela){
            identidad = true;
        }
        
        return identidad;
    }
    
    boolean igualdadEstado(Parcela otraParcela){
        
        boolean estado = false;
        
        if((this.nombre.equals(otraParcela.nombre)) && this.precioCompra == otraParcela.precioCompra && this.precioEdificar == otraParcela.precioEdificar 
                && this.precioBaseAlquiler == otraParcela.precioBaseAlquiler && this.numCasas == otraParcela.numCasas && this.numHoteles == otraParcela.numHoteles)
        {
            estado = true;
        }
        
        return estado;
        
    }
       
}
