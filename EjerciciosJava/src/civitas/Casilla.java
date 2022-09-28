
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
    public float getPrecioAlquilerCompleto(){
        return (precioBaseAlquiler * ( FACTORALQUILERCALLE + numCasas * FACTORALQUILERCASA + numHoteles * FACTORALQUILERHOTEL));
    }
    
    //Getters
    public String getNombre(){
        return this.nombre;
    }
    
    public float getPrecioCompra(){
        return this.precioCompra;
    }
    
    public float getPrecioEdificar(){
        return this.precioEdificar;
    }
    
    public float getPrecioBaseAlquiler(){
        return this.precioBaseAlquiler;
    }
    
    //Metodo de Instancia
    
    //Metodo para devolver mediante una cadena el estado de un objeto
    @Override
    public String toString(){
        String cadena;
        
        cadena = "Tipo de Casilla: " + this.tipo + 
                    " Nombre de Casilla: " + this.nombre + 
                    " Precio Compra: " + this.precioCompra +
                    " Precio Edificar: " + this.precioEdificar +
                    " Precio Base Alquiler: " + this.precioBaseAlquiler +
                    " Numero de Casas: " + this.numCasas + 
                    " Numero de Hoteles: " + this.numHoteles;
        
        return cadena;
        
    }
}
