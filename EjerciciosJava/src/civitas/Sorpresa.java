
package civitas;

//@author SatoriAlex // Alexander Collado Rojas Y7412507N

import java.util.ArrayList;


public abstract class Sorpresa {
    
    //Atributos de Instancia
    private String texto;
    private int valor;
    private MazoSorpresas mazo;
    
    //Metodos Privados
   /*
    private void aplicarAJugador_pagarCobrar(int actual, ArrayList<Jugador> todos){
        this.informe(actual, todos);
        
        todos.get(actual).modificarSaldo(this.valor);
    }
    
    private void aplicarAJugador_porCasaHotel(int actual, ArrayList<Jugador> todos){
        this.informe(actual, todos);
        
        todos.get(actual).modificarSaldo(this.valor * todos.get(actual).cantidadCasasHoteles());
    }
    */
    
    void informe(int actual, ArrayList<Jugador> todos){
        Diario.getInstance().ocurreEvento("Se le ha aplicado al jugador" + todos.get(actual) + " la sorpresa " + this.toString());
    }
    
    //Metodos de PAQUETE
    Sorpresa(String texto, int valor){
        this.texto = texto;
        this.valor = valor;
        
        this.mazo = null;
    }
    
    abstract void aplicarAJugador(int actual, ArrayList<Jugador> todos);
    
    int getValor(){
        return this.valor;
    }
    
    //Metodo PUBLICO
    @Override
    public String toString(){
        return this.texto;
    }
    
}
