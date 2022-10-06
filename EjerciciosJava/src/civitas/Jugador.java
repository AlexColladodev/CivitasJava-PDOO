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
    private ArrayList<Casilla> propiedades;
    
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
    
    private static int getCasasMax(){
        return Jugador.CasasMax;
    }
    
    private static int getHotelesMax(){
        return Jugador.HotelesMax;
    }
    
    private static float getPremioPasoSalida(){
        return Jugador.PasoPorSalida;
    }
    
    private boolean puedoEdificarCasa(Casilla propiedad){ //Puedo edificar si tengo dinero para edificar y si no he llegado al numMaximo de casas
        return (propiedad.getNumCasas() < Jugador.CasasMax && this.puedoGastar(propiedad.getPrecioEdificar()));
    }
    
    private boolean puedoEdificarHotel(Casilla propiedad){ //Puedo edificar hotel si tengo las casas necesarias, no he llegado al maximo de hoteles y si tengo dinero
        return (propiedad.getNumHoteles() < Jugador.HotelesMax && propiedad.getNumCasas() == Jugador.CasasPorHotel);
    }
    
    private boolean puedoGastar(float precio){
        return this.saldo >= precio;
    }
    
    //Metodos PROTECTED
    protected String getNombre(){
        return this.nombre;
    }
    
    protected ArrayList<Casilla> getPropiedades(){
        return this.propiedades;
    }
    
    protected float getSaldo(){
        return this.saldo;
    }
    
    //Metodos PAQUETES
    int cantidadCasasHoteles(){
        
    }
    
    boolean comprar(Casilla titulo){
        
    }
    
    boolean construirCasa(int ip){
        
    }
    
    boolean construirHotel(int ip){
        
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
        
    }
    
    
    
    
    
}
