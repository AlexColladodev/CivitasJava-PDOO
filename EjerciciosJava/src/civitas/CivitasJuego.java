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
        this.mazo.alMazo(new Sorpresa(TipoSorpresa.PAGARCOBRAR, "Cobrar 25", 25));
        this.mazo.alMazo(new Sorpresa(TipoSorpresa.PAGARCOBRAR, "Pagar 25", 25));
        this.mazo.alMazo(new Sorpresa(TipoSorpresa.PAGARCOBRAR, "Cobrar 50", 50));
        this.mazo.alMazo(new Sorpresa(TipoSorpresa.PAGARCOBRAR, "Pagar 50", -50));
        this.mazo.alMazo(new Sorpresa(TipoSorpresa.PORCASAHOTEL, "Pagar 25 por cada casa u hotel", 25));
        this.mazo.alMazo(new Sorpresa(TipoSorpresa.PORCASAHOTEL, "Pagar 25 por cada casa u hotel", 25));
        this.mazo.alMazo(new Sorpresa(TipoSorpresa.PORCASAHOTEL, "Pagar 150 por cada casa u hotel", 150));
        this.mazo.alMazo(new Sorpresa(TipoSorpresa.PORCASAHOTEL, "Pagar 150 por cada casa u hotel", 150));
        
    }
    
    //Casilla(String titulo, float precioCompra, float precioEdificar, float precioBaseAlquiler){
        
    private void inicializaTablero(MazoSorpresas mazo){//Crear todas las casillas, las hago luego :D
        this.tablero.aniadeCasilla(new Casilla("Multiplaza", 2588.4f, 2988.6f, 85.3f));
        this.tablero.aniadeCasilla(new Casilla("Se vienen cositas SORPRESA", mazo));
        this.tablero.aniadeCasilla(new Casilla("AlbrookMall", 853.2f, 2541.7f, 99.3f));
        this.tablero.aniadeCasilla(new Casilla("Altaplaza", 2488.4f, 4589.6f, 87.4f));
        this.tablero.aniadeCasilla(new Casilla("Se vienen cositas SORPRESA", mazo));
        this.tablero.aniadeCasilla(new Casilla("SohoMall", 5263.4f, 4488.6f, 108.3f));
        this.tablero.aniadeCasilla(new Casilla("Se vienen cositas SORPRESA", mazo));
        this.tablero.aniadeCasilla(new Casilla("MetroMall", 1544.4f, 3323.6f, 85.4f));
        this.tablero.aniadeCasilla(new Casilla("WestLanMall", 888.0f, 1124.4f, 55.8f));
        this.tablero.aniadeCasilla(new Casilla("NevadaShopping", 2010.9f, 1288.8f, 85.1f));
        this.tablero.aniadeCasilla(new Casilla("Se vienen cositas SORPRESA", mazo));
        this.tablero.aniadeCasilla(new Casilla("CenterTravelMall", 574.1f, 1214.0f, 25.38f));
        this.tablero.aniadeCasilla(new Casilla("ETSIIT", 333.7f, 1311.5f, 63.2f));
        this.tablero.aniadeCasilla(new Casilla("Se vienen cositas SORPRESA", mazo));
        this.tablero.aniadeCasilla(new Casilla("ConventionCenter", 7463.4f, 1697.6f, 12.3f)); 
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
        return true;
    }
    
    public boolean construirHotel(int ip){
        this.jugadores.get(this.indiceJugadorActual).construirHotel(ip);
        return true;
    }
    
    public boolean finalDelJuego(){
        boolean fin = false;
        for(int i = 0; i < jugadores.size(); i++){
            if(jugadores.get(i).enBancarrota()){
                fin = true;
               
                //No se si debo ponerlo asi para que cuando finalice el juego muestre por pantalla el ranking
                System.out.println(ranking());
                
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
    
    //Metodo a;adido por mi cuenta
    public int getJugadorCasillaActual(){
        return this.getJugadorActual().getCasillaActual();
    }
    
    public Tablero getTablero(){
        return this.tablero;
    }
    
    public OperacionJuego siguientePaso(){
        
    }
    
    public void siguientePasoCompletado(OperacionJuego operacion){
        this.estado = this.gestorEstados.siguienteEstado(jugadores.get(indiceJugadorActual), this.estado, operacion);
    }
    
    
}
