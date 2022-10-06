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
    
    private boolean puedoEdificarCasa(Casilla propeidad){
        
    }
    
    private boolean puedoEdificarHotel(Casilla propiedad){
        
    }
    
    private boolean puedoGastar(float precio){
        
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
    }
    
    boolean moverACasilla(int numCasilla){
        
    }
    
    boolean paga(float cantidad){
        
    }
    
    boolean pagaAlquiler(float cantidad){
        
    }
    
    boolean pasaPorSalida(){
        
    }
    
    boolean puedeComprarCasilla(){
        
    }
    
    boolean recibe(float cantidad){
        
    }
    
    boolean tieneAlgoQueGestionar(){
        
    }
    
    //METODOS PUBLICOS
    public int compareTo(Jugador otro){
        
    }
    
    
    
    
    
}
