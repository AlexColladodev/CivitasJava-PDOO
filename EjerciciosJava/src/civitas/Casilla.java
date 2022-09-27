
package civitas;

//@author SatoriAlex // Alexander Collado Rojas Y7412507N

public class Casilla {
    
    //Atributos de clases -- llevan static
    static final float FACTORALQUILERCALLE = 1.0f;
    static final float FACTORALQUILERCASA = 1.0f;
    static final float FACTORALQUILERHOTEL = 4.0f;
    
    //Atributos de instancia
    private TipoCasilla tipo;
    private String nombre;
    private float precioCompra, precioEdificar, precioBaseAlquiler;
    private int numCasas, numHoteles;
    
    //Constructor
    Casilla(TipoCasilla unTipo, String unNombre, float unPrecioCompra, float unPrecioEdificar, float unPrecioAlquilerBase){
        tipo = unTipo;
        nombre = unNombre;
        precioCompra = unPrecioCompra;
        precioEdificar = unPrecioEdificar;
        precioBaseAlquiler = unPrecioAlquilerBase;
        
        numCasas = 0;
        numHoteles = 0;
    }
    
    //Formula indicada en las reglas del juego 
    float getPrecioAlquilerCompleto(){
        return (precioBaseAlquiler * ( FACTORALQUILERCALLE + numCasas * FACTORALQUILERCASA + numHoteles * FACTORALQUILERHOTEL));
    }
    
    //Getters
    String getNombre(){
        return this.nombre;
    }
    
    float getPrecioCompra(){
        return this.precioCompra;
    }
    
    float getPrecioEdificar(){
        return this.precioEdificar;
    }
    
    float getPrecioBaseAlquiler(){
        return this.precioBaseAlquiler;
    }
    
    //Metodo de Instancia
    
    //Metodo para devolver mediante una cadena el estado de un objeto
    @Override
    public String toString(){
        String cadena;
        
        cadena = "Tipo de Casilla: " + tipo +
                    " Nombre de Casilla: " + nombre + 
                    " Precio Compra: " + precioCompra +
                    " Precio Edificar: " + precioEdificar +
                    " Precio Base Alquiler: " + precioBaseAlquiler +
                    " Numero de Casas: " + numCasas + 
                    " Numero de Hoteles: " + numHoteles;
        
        return cadena;
        
    }
}
