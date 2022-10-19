
package civitas;

//@author SatoriAlex // Alexander Collado Rojas Y7412507N

import java.util.ArrayList;

    /*
    Casilla(TipoCasilla unTipo, String unNombre, float unPrecioCompra, float unPrecioEdificar, float unPrecioAlquilerBase){
        tipo = unTipo;
        nombre = unNombre;
        precioCompra = unPrecioCompra;
        precioEdificar = unPrecioEdificar;
        precioBaseAlquiler = unPrecioAlquilerBase;
        
        numCasas = 0;
        numHoteles = 0;
    }*/
public class Casilla {
    
    //Atributos de clases -- llevan static
    private static final float FACTORALQUILERCALLE = 1.0f;
    private static final float FACTORALQUILERCASA = 1.0f;
    private static final float FACTORALQUILERHOTEL = 4.0f;
    
    //Atributos de instancia
    private TipoCasilla tipo;
    private String nombre;
    private float precioCompra, precioEdificar, precioBaseAlquiler;
    private int numCasas, numHoteles;
    private MazoSorpresas mazo; //CASILLAS TIPO SORPRESA
    private Sorpresa sorpresa;
    private Jugador propietario;
    
    //Metodos de PAQUETE
    
    //Constructores
    
    //PARA CASILLAS TIPO DESCANSO
    Casilla(String nombre){
        this.init();
        
        this.tipo = TipoCasilla.DESCANSO;
        this.nombre = nombre;
    }
    
    //PARA CASILLAS TIPO CALLE
    Casilla(String titulo, float precioCompra, float precioEdificar, float precioBaseAlquiler){
        this.init();
        
        this.tipo = TipoCasilla.CALLE;
        this.nombre = titulo;
        this.precioBaseAlquiler = precioBaseAlquiler;
        this.precioEdificar = precioEdificar;
        this.precioCompra = precioCompra;
    }
    
    //PARA CASILLAS TIPO SORPRESAS
    Casilla(String nombre, MazoSorpresas mazo){
        this.init();
        
        this.tipo = TipoCasilla.SORPRESA;
        this.nombre = nombre;
        this.mazo = mazo;
    }
    
    void recibeJugador(int iactual, ArrayList<Jugador> todos){
        switch(this.tipo){
            case CALLE -> recibeJugador_calle(iactual, todos);
            case SORPRESA -> recibeJugador_sorpresa(iactual, todos);
            case DESCANSO -> informe(iactual, todos);
        }
    }
    
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
    
    void informe(int iactual, ArrayList<Jugador> todos){//Informa sobre que jugador ha caido en que casilla
        Diario.getInstance().ocurreEvento("El jugador " + todos.get(iactual) + " ha caido en la casilla" + this.getNombre());
    }
    
    //Metodos PRIVAOS
    private void init(){
        this.tipo = null;
        this.mazo = null;
        this.sorpresa = null;
        this.propietario = null;
        
        this.nombre = " ";
        this.precioBaseAlquiler = 0;
        this.precioCompra = 0;
        this.precioEdificar = 0;
        
        this.numCasas = 0;
        this.numHoteles = 0;
    }   
    
    private void recibeJugador_calle(int iactual, ArrayList<Jugador> todos){
        informe(iactual, todos);
        
        Jugador jugador = todos.get(iactual);
        
        if(!this.tienePropietario()){
            jugador.puedeComprarCasilla();
        }else{
            this.tramitarAlquiler(jugador);
        }
    }
    
    private void recibeJugador_sorpresa(int iactual, ArrayList<Jugador> todos){
        Sorpresa sorpresa = mazo.siguiente();
        
        this.informe(iactual, todos);
        
        sorpresa.aplicarAJugador(iactual, todos);
    }
    //Metodos PUBLICOS
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
    
    public int cantidadCasasHoteles(){
        return numCasas + numHoteles;
    }
    
    public int getNumCasas(){
        return this.numCasas;
    }
    
    public int getNumHoteles(){
        return this.numHoteles;
    }
    
    
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
        
        if(tienePropietario()){
            cadena = cadena + "La casilla tiene propietario: " + propietario.getNombre();
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
