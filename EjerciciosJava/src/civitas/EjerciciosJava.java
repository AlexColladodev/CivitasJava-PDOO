
package civitas;

//@author SatoriAlex // Alexander Collado Rojas Y7412507N

import java.util.ArrayList;

public class EjerciciosJava {
   
    
    public static void main(String[] args) {
        
        
 /* PARCELA
        //Probando Primera Parte PARCELA
        //Para mandar valores flotantes y no mande error como double hay que poner la f
        Parcela par1 = new Parcela("Parcela1", 12.3f, 15.5f, 12.2f);
        Parcela par2 = new Parcela("Parcela2", 11.2f, 12.5f, 25.2f);
        
        System.out.println("Nombre: " + par1.getNombre() + " PrecioCompra: " + par1.getPrecioCompra() + " PrecioEdificar : " + par1.getPrecioEdificar());
        System.out.println("Nombre: " + par2.getNombre() + " PrecioCompra: " + par2.getPrecioCompra() + " PrecioEdificar : " + par2.getPrecioEdificar());
        
        par1.construirCasa();
        par1.construirCasa();
        par2.construirCasa();
        
        System.out.println("Casas de parcela1: " + par1.getNumCasas());
        System.out.println("Casas de parcela2: " + par2.getNumCasas());
        
        par1.construirHotel();
        par2.construirHotel();
        par2.construirHotel();
        
        System.out.println("Hoteles de parcela1: " + par1.getNumHoteles());
        System.out.println("Hoteles de parcela2: " + par2.getNumHoteles());
        
        System.out.println("PrecioAlquiler Parcela1: " + par1.getPrecioAlquilerCompleto());
        System.out.println("PrecioAlquiler Parcela2: " + par2.getPrecioAlquilerCompleto());
        
        
        Parcela par3 = par2; //Igualdad de identidad prueba
        Parcela par4 = new Parcela("Parcela2", 11.2f, 12.5f, 25.2f); //Igualdad de estado prueba
        
        //Construir las casas y hoteles para tener el mismo estado
        par4.construirCasa();
        par4.construirHotel();
        par4.construirHotel();
        
        //par3.construirCasa(); //A; apuntar a la misma direcci[on de memoria si par3 cambia entonces tambien cambia par2
        
        System.out.println("Igualdad de Identidad");
        System.out.println("Parcela 1 con Parcela 2: " + par1.igualdadIdentidad(par2)); // false NO IGUALDAD NI DE IDENTIDAD NI DE ESTADO
        System.out.println("Parcela 2 con Parcela 3: " + par2.igualdadIdentidad(par3)); // true IGUALDAD DE IDENTIDAD Y DE ESTADO
        System.out.println("Parcela 2 con Parcela 4: " + par2.igualdadIdentidad(par4)); // false NO IGUALDAD DE IDENTIDAD PERO SI DE ESTADO
        
        System.out.println("Igualdad de Estado");
        System.out.println("Parcela 1 con Parcela 2: " + par1.igualdadEstado(par2)); // false NO IGUALDAD NI DE IDENTIDAD NI DE ESTADO
        System.out.println("Parcela 2 con Parcela 3: " + par2.igualdadEstado(par3)); // false IGUALDAD DE IDENTIDAD Y DE ESTADO
        System.out.println("Parcela 2 con Parcela 4: " + par2.igualdadEstado(par4)); // true NO IGUALDAD DE IDENTIDAD PERO SI DE ESTADO
        //FIN de prueba de primera parte
     FIN PARCELA */
 
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
        System.out.println("ENUMERADO EstadosJuego: " + EstadosJuego.INICIO_TURNO);
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
    
    //TESTEO PARA LA P2 PROGRAMA PRINCIPAL NO CIVITAS
        Hotel hotel1 = new Hotel("Hotel Paradise", "PTY", 5);
        Hotel hotel2 = new Hotel("Hotel Bali", "PTY", 2);
        System.out.println("Numero de Hoteles: " + Hotel.getNUM_HOTELES());
        
        Director dir1 = new Director("Manolo", 258963147l);
        
        hotel1.setDirector(dir1);
        
        System.out.println("Director del Hotel 1: " + hotel1.getDirector().getNombre());
    
    }
    
}

