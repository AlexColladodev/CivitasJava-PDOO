
package civitas;

//@author SatoriAlex // Alexander Collado Rojas Y7412507N

import java.util.ArrayList;


public class Sorpresa {
    
    //Atributos de Instancia
    private String texto;
    private int valor;
    private MazoSorpresas mazo;
    private TipoSorpresa tipo;
    
    //Metodos Privados
    private void aplicarAJugador_pagarCobrar(int actual, ArrayList<Jugador> todos){
        this.informe(actual, todos);
        
        todos.get(actual).modificarSaldo(this.valor);
    }
    
    private void aplicarAJugador_porCasaHotel(int actual, ArrayList<Jugador> todos){
        this.informe(actual, todos);
        
        todos.get(actual).modificarSaldo(this.valor * todos.get(actual).cantidadCasasHoteles());
    }
    
    private void informe(int actual, ArrayList<Jugador> todos){
        Diario.getInstance().ocurreEvento("Se le ha aplicado al jugador" + todos.get(actual) + " la sorpresa " + this.toString());
    }
    
    //Metodos de PAQUETE
    Sorpresa(TipoSorpresa tipo, String texto, int valor){
        this.texto = texto;
        this.tipo = tipo;
        this.valor = valor;
        
        this.mazo = null;
    }
    
    void aplicarAJugador(int actual, ArrayList<Jugador> todos){
        switch(this.tipo){
            case PORCASAHOTEL: aplicarAJugador_porCasaHotel(actual, todos); break;
            case PAGARCOBRAR: aplicarAJugador_pagarCobrar(actual, todos); break;
        }
    }
    
    //Metodo PUBLICO
    public String toString(){
        return this.texto;
    }
    
}
