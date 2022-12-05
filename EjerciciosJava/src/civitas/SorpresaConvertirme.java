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
public class SorpresaConvertirme extends Sorpresa{
    
    SorpresaConvertirme(String texto){
        super(texto);
    }
    
    void aplicarAJugador(int actual, ArrayList<Jugador> todos){
        this.informe(actual, todos);
        
        todos.set(actual, new JugadorEspeculador(todos.get(actual)));
    }
}
