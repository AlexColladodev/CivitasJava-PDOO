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
public class CasillaSorpresa extends Casilla{
    
    private MazoSorpresas mazo;
    
    CasillaSorpresa(String nombre, MazoSorpresas mazo){
        super(nombre);
        
        this.setTipo(TipoCasilla.SORPRESA);
        this.mazo = mazo;
    }
    
    @Override
    void recibeJugador(int iactual, ArrayList<Jugador> todos){
        Sorpresa sorpresa = mazo.siguiente();
        
        informe(iactual, todos);
        
        sorpresa.aplicarAJugador(iactual, todos);
    }
    
    @Override
    public String toString(){
        String cadena;
        
        cadena = "CASILLA SORPRESA --> " + this.getNombre();
       
        
        return cadena;
        
    }
    
}
