/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package civitas;

import java.util.ArrayList;

/**
 *
 * @author alexc
 */
public class CasillaCalle extends Casilla{
    
    //Atributos de clases -- llevan static
    private static final float FACTORALQUILERCALLE = 1.0f;
    private static final float FACTORALQUILERCASA = 1.0f;
    private static final float FACTORALQUILERHOTEL = 4.0f;
    
    private float precioCompra;
    private float precioEdificar;
    private float precioBaseAlquiler;
    private int numCasas, numHoteles;
    private Jugador propietario;
    
    CasillaCalle(String titulo, float precioCompra, float precioEdificar, float precioBaseAlquiler){        
        super(titulo);
        
        this.init();
        
        setTipo(TipoCasilla.CALLE); //Metodo para acceder y cambiar el tipo de la casilla
        
        this.precioCompra = precioCompra;
        this.precioEdificar = precioEdificar;
        this.precioBaseAlquiler = precioBaseAlquiler;
    }
    
    private void init(){ 
        this.propietario = null;
        this.numCasas = 0;
        this.numHoteles = 0;  
    }
    
    //METODOS DE PAQUETE
     boolean comprar(Jugador jugador){
        boolean result = false;
        
        if(!this.tienePropietario()){
           this.propietario = jugador;
            this.propietario.paga(this.precioCompra); 
            result = true;
        }
        return result;
    }
    
    boolean construirCasa(Jugador jugador){
        boolean result = false;
        
        if(esEsteElPropietario(jugador)){
                jugador.paga(this.precioEdificar);
                this.numCasas++;
                result = true;
        
        }
        
        return result;
    }
    
    boolean construirHotel(Jugador jugador){
        jugador.paga(this.precioEdificar);
        this.numHoteles++;
        return true;
    }
    
    boolean derruirCasas(int numero, Jugador jugador){
        
        boolean realizado = false;
        
        if(esEsteElPropietario(jugador) && this.numCasas >= numero){
            numCasas -= numero;
            realizado = true;
        }
        
        return realizado;
    }
    
    @Override
    void recibeJugador(int iactual, ArrayList<Jugador> todos){
            informe(iactual, todos);
        
        Jugador jugador = todos.get(iactual);
        
        if(!this.tienePropietario()){
            jugador.puedeComprarCasilla();
        }else{
            this.tramitarAlquiler(jugador);
        }    
    }
    
    //METODOS PUBLICOS
    public float getPrecioAlquilerCompleto(){
        return (precioBaseAlquiler * ( FACTORALQUILERCALLE + numCasas * FACTORALQUILERCASA + numHoteles * FACTORALQUILERHOTEL));
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
    
    public int cantidadCasasHoteles(){
        return numCasas + numHoteles;
    }
    
    public int getNumCasas(){
        return this.numCasas;
    }
    
    public int getNumHoteles(){
        return this.numHoteles;
    }
    
    @Override
    public String toString(){
        String cadena;
        
        cadena = "\nTipo de Casilla: " + this.getTipo() + 
                    "\n Nombre de Casilla: " + this.getNombre() + 
                    "\n Precio Compra: " + this.precioCompra +
                    "\n Precio Edificar: " + this.precioEdificar +
                    "\n Precio Base Alquiler: " + this.precioBaseAlquiler +
                    "\n Numero de Casas: " + this.numCasas + 
                    "\n Numero de Hoteles: " + this.numHoteles;
        
        if(tienePropietario()){
            cadena = cadena + "\nLa casilla tiene propietario: \n" + propietario.getNombre();
        }
        
        return cadena;
        
    }
    
    public void tramitarAlquiler(Jugador jugador){
        if(tienePropietario() && esEsteElPropietario(jugador)){
            jugador.pagaAlquiler(this.getPrecioAlquilerCompleto());
            propietario.recibe(this.getPrecioAlquilerCompleto());
        }
    }
    
    public boolean tienePropietario(){
        boolean tienePropietario = false;
        if(propietario != null){
            tienePropietario = true;
        }
        
        return tienePropietario;
    }
    
    public boolean esEsteElPropietario(Jugador jugador){
        boolean esteEsElPropietario = false;
        
        if(this.propietario == jugador){
            esteEsElPropietario = true;
        }
        
        return esteEsElPropietario;
    }    
    
    
}
