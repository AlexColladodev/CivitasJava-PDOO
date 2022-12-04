/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package civitas;

//@author SatoriAlex // Alexander Collado Rojas Y7412507N

import java.util.ArrayList;


public class Jugador implements Comparable<Jugador>{
    
    //Atributos de clase
    static final protected int CasasMax = 4;
    static final protected int CasasPorHotel = 4;
    static final protected int HotelesMax = 4;
    static final protected float PasoPorSalida = 1000;
    static final private float SaldoInicial = 7500;
    
    
    
    //Atributos de Instancia
    private int casillaActual;
    private String nombre;
    private boolean puedeComprar;
    private float saldo;
    private ArrayList<CasillaCalle> propiedades;
    private boolean especulador = false;
    
    //Constructores
    Jugador(String nombre){
        this.nombre = nombre;
        this.casillaActual = 0;
        this.propiedades = new ArrayList<>();
        this.saldo = SaldoInicial;
        this.puedeComprar = false;
        
    }
    
    protected Jugador(Jugador otro){
        this.casillaActual = otro.casillaActual;
        this.nombre = otro.nombre;
        this.propiedades = otro.propiedades;
        this.puedeComprar = otro.puedeComprar;
        this.saldo = otro.saldo;
    }
    
    //METODOS PRIVADOS
    private boolean existeLaPropiedad(int ip){
        boolean valorValida = false;
        
        if(ip >= 0 && ip <= propiedades.size()){
            valorValida = true;
        }
        
        return valorValida;
    }
    
    public int getCasasMax(){
        return Jugador.CasasMax;
    }
    
    public int getHotelesMax(){
        return Jugador.HotelesMax;
    }
    
    private static float getPremioPasoSalida(){
        return Jugador.PasoPorSalida;
    }
    
    private boolean puedoEdificarCasa(CasillaCalle propiedad){ //Puedo edificar si tengo dinero para edificar y si no he llegado al numMaximo de casas
        float precioEdificar = propiedad.getPrecioEdificar();
        boolean puedoEdificar = false;
        
        if(this.puedoGastar(precioEdificar) && propiedad.getNumCasas() < Jugador.CasasMax){
            puedoEdificar = true;
        }
        
        return puedoEdificar;
    }
    
    private boolean puedoEdificarHotel(CasillaCalle propiedad){ //Puedo edificar hotel si tengo las casas necesarias, no he llegado al maximo de hoteles y si tengo dinero
        boolean puedoEdificarHotel = false;
        float precio = propiedad.getPrecioEdificar();
        
        if(this.puedoGastar(precio)){
            if(propiedad.getNumHoteles()< Jugador.HotelesMax){
                //[propiedad.getNumCasas()>=getCasasPorHotel()]
                if(propiedad.getNumCasas() >= Jugador.CasasPorHotel){
                    puedoEdificarHotel = true;
                }
            }
        }
        
        return puedoEdificarHotel;
    }
    
    boolean puedoGastar(float precio){
        return this.saldo >= precio;
    }
    
    public JugadorEspeculador convertirJugador(){
        this.especulador = true;
        return new JugadorEspeculador(this);
    }
    
    public String getEspeculador(){
        String info = "" + this.especulador;
        return info;
    }
    
    //Metodos PROTECTED --> CAMBIADOS PARA PRACTICA 3
    public String getNombre(){
        return this.nombre;
    }
    
    public String getSaldoTexto(){
        String info;
        info = "" + this.getSaldo();
        return info;
    }
    
    public ArrayList<CasillaCalle> getPropiedades(){
        return this.propiedades;
    }
    
    protected float getSaldo(){
        return this.saldo;
    }
    
    //Metodos PAQUETES
    int cantidadCasasHoteles(){
        int suma = 0;
        for(int i = 0; i < this.propiedades.size(); i++){
            suma += this.propiedades.get(i).getNumCasas() + this.propiedades.get(i).getNumHoteles();
        }
        
        return suma;
    }
    
    boolean comprar(CasillaCalle titulo){
        
        boolean result = false;
        
        if(this.puedeComprar){
            float precio = titulo.getPrecioCompra();
            
            if(this.puedoGastar(precio)){
                result = titulo.comprar(this);
                this.propiedades.add(titulo);
                
                Diario.getInstance().ocurreEvento("El jugador " + this.nombre + " compra la propeidad " + titulo.getNombre());
                
                this.puedeComprar = false;
            }else{ 
                Diario.getInstance().ocurreEvento("El jugador " + this.nombre + " no tiene saldo para comprar la propiedad " + titulo.getNombre());
            } 
        }
        
        return result;
    }
    
    boolean construirCasa(int ip){
        boolean result = false;
        boolean existe = this.existeLaPropiedad(ip);
        boolean puedoEdificar = false;
        
        if(existe){
            CasillaCalle propiedad = this.propiedades.get(ip);
            puedoEdificar = this.puedoEdificarCasa(propiedad);
            if(puedoEdificar){
                result = propiedad.construirCasa(this);
                
                if(result){
                   Diario.getInstance().ocurreEvento("El jugador " + this.nombre + " ha construido una casa en la propiedad " + ip);
                }
            }
        }
        
        return result;
    }
    
    boolean construirHotel(int ip){
        boolean result = false;
        
        if(this.existeLaPropiedad(ip)){
            CasillaCalle propiedad = this.propiedades.get(ip);
            
            boolean puedoEdificarHotel = this.puedoEdificarHotel(propiedad);
            
            if(puedoEdificarHotel){
                result = propiedad.construirHotel(this);
                propiedad.derruirCasas(Jugador.CasasPorHotel, this);
                Diario.getInstance().ocurreEvento("El jugador " + this.nombre + " construye hotel en la propiedad " + ip);
            }
        }
        
        return result;
    }
    
    boolean enBancarrota(){
        return (this.saldo < 0);
    }
    
    static int getCasasPorHotel(){
        return Jugador.CasasPorHotel;
    }
    
    int getCasillaActual(){
        return this.casillaActual;
    }
    
    boolean getPuedeComprar(){
        return this.puedeComprar;
    }
    
    boolean modificarSaldo(float cantidad){
        this.saldo = saldo + cantidad;
        
        Diario.getInstance().ocurreEvento("Se ha modificado el saldo en: " + cantidad + " el nuevo saldo es de: " + this.saldo);
        
        return true;
    }
    
    boolean moverACasilla(int numCasilla){
        this.casillaActual = numCasilla;
        this.puedeComprar = false;
        
        Diario.getInstance().ocurreEvento("El jugador " + this.nombre + " se ha desplazado a la casilla " + this.casillaActual + " no puede comprarla");
        
        return true;
    }
    
    boolean paga(float cantidad){
        return this.modificarSaldo(cantidad * -1);
    }
    
    boolean pagaAlquiler(float cantidad){
        return this.paga(cantidad);
    }
    
    boolean pasaPorSalida(){
        this.recibe(Jugador.PasoPorSalida);
        
        Diario.getInstance().ocurreEvento("El jugador " + this.nombre + " ha pasado por SALIDA");
        
        return true;
    }
    
    boolean puedeComprarCasilla(){
        this.puedeComprar = true;
        
        return this.puedeComprar;
    }
    
    boolean recibe(float cantidad){
        return this.modificarSaldo(cantidad);
    }
    
    boolean tieneAlgoQueGestionar(){
        return this.propiedades.size() > 0;
    }
    
    //METODOS PUBLICOS
    @Override
    public int compareTo(Jugador otro){
        int compare = 0;
        
        if(this.saldo == otro.saldo){//No necesito getSaldo ya que son readers de la misma clase
            compare = 1;
        }else{
            compare = 1;
        }
        
        return compare;
    }
    
    @Override
    public String toString(){
        String informacion = "";
        
        informacion = "\nNombre del Jugador: " + this.getNombre() + "\n";
        
        informacion += "El saldo del jugador es: " + this.getSaldo() + "\n" 
                        + "Tiene las siguientes propiedades: " + "\n";
        
        if(this.getPropiedades().isEmpty()){
            informacion = informacion + "El jugador no tiene ninguna propiedad";
        }else{
            for(int i = 0; i < this.getPropiedades().size(); i++){
                informacion += this.getPropiedades().get(i).getNombre();
            }
        }
        
        return informacion;
    }
    
    
    
    
    
}
