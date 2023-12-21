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
public class SorpresaPorCasaHotel extends Sorpresa {
    
    
    SorpresaPorCasaHotel(String nombre, int valor){
        super(nombre, valor);
    }
    
    void aplicarAJugador(int actual, ArrayList<Jugador> todos){
        this.informe(actual, todos);
        
        todos.get(actual).modificarSaldo(this.getValor() * todos.get(actual).cantidadCasasHoteles());
    }
}
