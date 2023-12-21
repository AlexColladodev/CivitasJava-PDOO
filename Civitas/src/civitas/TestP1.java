
package civitas;

//@author SatoriAlex // Alexander Collado Rojas Y7412507N

import java.util.ArrayList;
/*
public class TestP1 {
    
    public static void main(String[] args) {
        
        
 
    // PROGRAMA PRINCIPAL
    
    //UNO: Ver si las estadisticas de los dados sea aceptable.
        //Se puede hacer con un ArrayList pero ahorita no me acuerdo xd
        int n_jugadores = 4;
        int valor_dado = 0;
        
        ArrayList<Integer> jugadores = new ArrayList<>();
        
        for(int i = 0; i < n_jugadores; i++){
            jugadores.add(0);
        }

        //Se van generando los valores aleatories de 0 a n-1 jugadores entonces en la posicion
            // i del array de jugadores se reemplaza el anterior + 1. Es decir este se incrementa
        for(int i = 0; i < 100; i++){     
            valor_dado = Dado.getInstance().quienEmpieza(n_jugadores);
            jugadores.set(valor_dado, jugadores.get(valor_dado)+1);
        }
        System.out.println("PRUEBA 1");
        System.out.println( " Jugador 1: " + jugadores.get(0) + System.lineSeparator() +
                            " Jugador 2: " + jugadores.get(1) + System.lineSeparator() +
                            " Jugador 3: " + jugadores.get(2) + System.lineSeparator() +
                            " Jugador 4: " + jugadores.get(3));
        
    //DOS: FUNCIONAMIENTO DEL MODO DEBUG DEL DADO ACTIVANDO Y DESACTIVANDO
        
        System.out.println("PRUEBA 2");
        Dado.getInstance().setDebug(true);
        
        System.out.println("DEBUG ACTIVADO");
        for(int i = 0; i < 10; i++){
            System.out.println("Debug Activado Tirada " + i + " valor: " + Dado.getInstance().tirar());
        }
        
        Dado.getInstance().setDebug(false);
        
        System.out.println("DEBUG DESACTIVADO");
        for(int i = 0; i < 10; i++){
            System.out.println("Tirada " + i + " valor: " + Dado.getInstance().tirar());
        }
        
    //TRES: PROBAR getUltimoResultado DEL DADO
    
        System.out.println("PRUEBA 3");
        System.out.println("Tirada 0: " + Dado.getInstance().tirar());
        System.out.println("Obteniendo resultado de tirada anterior: " + Dado.getInstance().getUltimoResultado());
        
        System.out.println("Tirada 1: " + Dado.getInstance().tirar());
        System.out.println("Obteniendo resultado de tirada anterior: " + Dado.getInstance().getUltimoResultado());
        
    //CUATRO: MOSTRR UN VALOR  DE CADA TIPO DE ENUMERADO
    
        System.out.println("PRUEBA 4");
        
        System.out.println("ENUMERADO TipoCasilla: " + TipoCasilla.CALLE);
        System.out.println("ENUMERADO EstadosJuego: " + EstadoJuego.INICIO_TURNO);
        System.out.println("ENUMERADO TipoSorpresa: " + TipoSorpresa.PAGARCOBRAR);
        
    //CINCO: CREACION DE OBJETO TABLERO Y REALIZAR TESTS
    
        Tablero tablero = new Tablero();
        tablero.aniadeCasilla(new Casilla(TipoCasilla.CALLE, "Primera Parada", 11.5f, 17.2f, 22.3f));
        tablero.aniadeCasilla(new Casilla(TipoCasilla.CALLE, "ETSIIT", 4.5f, 78.2f, 3.3f));
        tablero.aniadeCasilla(new Casilla(TipoCasilla.CALLE, "Samsung", 41.5f, 87.2f, 21.3f));
        tablero.aniadeCasilla(new Casilla(TipoCasilla.CALLE, "MultiPlaza", 42.9f, 47.2f, 96.3f));
        tablero.aniadeCasilla(new Casilla(TipoCasilla.CALLE, "Soho Mall", 22.7f, 21.66f, 12.63f));
        tablero.aniadeCasilla(new Casilla(TipoCasilla.CALLE, "Town Center", 17.8f, 32.2f, 27.3f));
       
       //Porque utilice 6 casillas
       for(int i = 0; i < 7; i++){
           System.out.println(tablero.getCasilla(i).toString());
       }
       
    //SEIS: PRUEBA DE PRECIO DE LAS CALLES Y MEDIA
    
        int casillaMenorCoste = 1;
        int casillaMayorCoste = 1;
        float suma = 0;
        float promedioPrecioCompra = 0;
    
        for(int i = 1; i < 6; i++){
            
            if(tablero.getCasilla(i).getPrecioCompra() < tablero.getCasilla(casillaMenorCoste).getPrecioCompra()){
                casillaMenorCoste = i;
            }
    
            if(tablero.getCasilla(i).getPrecioCompra() > tablero.getCasilla(casillaMayorCoste).getPrecioCompra()){
                casillaMayorCoste = i;
            }
            
            suma += tablero.getCasilla(i).getPrecioCompra();
            promedioPrecioCompra = suma / 6;
            
        }
        
        System.out.println("CASILLA CON MENOR PRECIO DE COMPRA: " + tablero.getCasilla(casillaMenorCoste).getNombre());
        System.out.println("CASILLA CON MAYOR PRECIO DE COMPRA: " + tablero.getCasilla(casillaMayorCoste).getNombre());
        System.out.println("PROMEDIO DE LAS CASILLAS PRECIO DE COMPRA: " + promedioPrecioCompra);
        
    //SIETE: PROBAR LA CLASE DIARIO
    
        while(Diario.getInstance().eventosPendientes())
            System.out.println(Diario.getInstance().leerEvento());
    
    //OCHO: REALIZAR PRUEBAS PARA VER SI LA TIRADA DE LOS DADOS FUNCIONA CORRECTAMENTE
        for(int i = 0; i < 6; i++){ //Solo hay 6 casillas actualmente
            System.out.println("Posicion Actual: " + i + " siguiente posicion: " + tablero.nuevaPosicion(i, Dado.getInstance().tirar()) + " La ultima tirada fue: " + Dado.getInstance().getUltimoResultado());
        }
        
    //FIN PROGRAMA PRINCIPAL
        
        
        
    }
    
}
*/
