/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package civitas;

//@author SatoriAlex // Alexander Collado Rojas Y7412507N

import java.util.ArrayList;
import java.util.Collections;


public class CivitasJuego {

    //Atributo de Instancia
    private int indiceJugadorActual;
    
    private Tablero tablero;
    private GestorEstados gestorEstados;
    private MazoSorpresas mazo;
    private EstadoJuego estado;
    private ArrayList<Jugador> jugadores; 
    
    //Metodos PRIVADOS
    private void avanzaJugador(){
        
    }
    
    private void contabilizarPasosPorSalida(){
        while(this.tablero.computarPasoPorSalida()){//Verificar metodo PasoPorSalida
            this.jugadores.get(this.indiceJugadorActual).pasaPorSalida();
        }
    }
    
    private void inicializaMazoSorpresas(){//Crear todas las sorpresas
        
    }
    
    private void inicializaTablero(MazoSorpresas mazo){//Crear todas las casillas, las hago luego :D
        this.tablero.aniadeCasilla(casilla);
    }
    
    private void pasarTurno(){
        this.indiceJugadorActual++;
        
        this.indiceJugadorActual = this.indiceJugadorActual % jugadores.size();
    }
    
    private ArrayList<Jugador> ranking(){
        Collections.sort(this.jugadores);
        
        return this.jugadores;
    }
    
    //Metodos PUBLICOS
    public CivitasJuego(ArrayList<String> nombres, boolean debug){
        this.jugadores = new ArrayList<>();
        
        int numJugadores = nombres.size();
        
        if(numJugadores < 4){//Solo si hay menos de 4 jugadores
            for(int i = 0; i < numJugadores; i++){
                jugadores.add(new Jugador(nombres.get(i)));
            }  
        }
        
        this.gestorEstados = new GestorEstados();
        this.estado = this.gestorEstados.estadoInicial();
        
        Dado.getInstance().setDebug(debug);
        
        this.indiceJugadorActual = Dado.getInstance().quienEmpieza(numJugadores);
        
        this.mazo = new MazoSorpresas(debug);
        
        this.tablero = new Tablero();
        this.inicializaTablero(this.mazo);
        this.inicializaMazoSorpresas();
        
    }
    
    public boolean comprar(){
        
    }
    
    public boolean construirCasa(int ip){
        this.jugadores.get(this.indiceJugadorActual).construirCasa(ip);
    }
    
    public boolean construirHotel(int ip){
        this.jugadores.get(this.indiceJugadorActual).construirHotel(ip);
    }
    
    public boolean finalDelJuego(){
        boolean fin = false;
        for(int i = 0; i < jugadores.size(); i++){
            if(jugadores.get(i).enBancarrota()){
                fin = true;
            }
        }
        
        return fin;
    }
    
    public int getIndiceJugadorActual(){
        return this.indiceJugadorActual;
    }
    
    public Jugador getJugadorActual(){
        return this.jugadores.get(indiceJugadorActual);
    }
    
    public ArrayList<Jugador> getJugadores(){
        return this.jugadores;
    }
    
    public Tablero getTablero(){
        return this.tablero;
    }
    
    public OperacionesJuego siguientePaso(){
        
    }
    
    public void siguientePasoCompletado(OperacionesJuego operacion){
        this.estado = this.gestorEstados.siguienteEstado(jugadores.get(indiceJugadorActual), this.estado, operacion);
    }
    
    
}
