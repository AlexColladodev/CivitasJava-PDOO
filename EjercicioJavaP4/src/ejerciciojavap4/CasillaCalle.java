/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejerciciojavap4;

/**
 *
 * @author alexc
 */
public class CasillaCalle extends Casilla {
    private int numCasas;
    private static final float FACTOR_CALLE = 1.6f;
    
    CasillaCalle(String nombre){
        super(nombre);
        this.numCasas = 1;
    }
    
    /*
    boolean recibeJugador(){
        
        System.out.println("Soy una casilla calle y recibo al jugador");
        return true;
    }*/
    
    boolean recibeJugador(){
        boolean tmp = super.recibeJugador();
        
        if(tmp)
            System.out.println("        y ademas soy una casilla calle");
        
        return true;
    }
    
    void construirCasa(){
        numCasas++;
        
        System.out.println("Hay un total de " + numCasas + " casas");
    }

    @Override
    float precioCompra() {
        return (numCasas * FACTOR_CALLE);
    }
    
}

