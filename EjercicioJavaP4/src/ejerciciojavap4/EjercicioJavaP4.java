
package ejerciciojavap4;

import java.util.ArrayList;


public class EjercicioJavaP4 {


    public static void main(String[] args) {
        /*
        Casilla casillaNormal = new Casilla("Alex");
        CasillaCalle casillaCalle = new CasillaCalle("Ada");
        
        casillaNormal.recibeJugador();
        casillaCalle.recibeJugador();
        
        //casillaNormal.construirCasa(); Error
        casillaCalle.construirCasa();
        
        
        ArrayList<CasillaCalle> tablero = new ArrayList<>();
        
        tablero.add(casillaNormal);
        tablero.add(casillaCalle);
        */
        /*
        CasillaCalle casilla1 = new CasillaCalle("Nombr1");
        Casilla casilla2 = casilla1;
        
        casilla1.recibeJugador();
        casilla2.recibeJugador();
        
        casilla1.construirCasa();
        //casilla2.construirCasa();
        
        ((CasillaCalle) casilla2).construirCasa(); //Realizar casting
         */
        
        //MODIFICACIONES
        ArrayList<Casilla> casillas = new ArrayList<>();
        
        Casilla cc1 = new CasillaCalle("Cc1");
        Casilla cc2 = new CasillaCalle("Cc2");
        Casilla cc3 = new CasillaCalle("Cc3");
        Casilla cc4 = new CasillaCalle("Cc4");
        Casilla cc5 = new CasillaCalle("Cc5");
        
        Casilla ca1 = new CasillaAvenida("Ca1");
        Casilla ca2 = new CasillaAvenida("Ca2");
        Casilla ca3 = new CasillaAvenida("Ca3");
        Casilla ca4 = new CasillaAvenida("Ca4");
        Casilla ca5 = new CasillaAvenida("Ca5");
        
        /*
        Casilla casdaasda = new CasillaAvenida("asdasd");
        Casilla casdwa = new Casilla("Asdasd");
        CasillaAvenida claos = new CasillaAvenida("asdas");*/

        
        casillas.add(cc1);
        casillas.add(cc2);
        casillas.add(cc3);
        casillas.add(cc4);
        casillas.add(cc5);
        casillas.add(ca1);
        casillas.add(ca2);
        casillas.add(ca3);
        casillas.add(ca4);
        casillas.add(ca5);
        
        float suma = 0;
        
        ((CasillaCalle)casillas.get(0)).construirCasa();
        
        for(Casilla casilla : casillas){
            
            suma+= casilla.precioCompra();
           
        }
        
        System.out.println(suma);
        
        
    }
    
}
