
package ejercicios;

//@author SatoriAlex // Alexander Collado Rojas Y7412507N


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
        int jugador0 = 0;
        int jugador1 = 0;
        int jugador2 = 0;
        int jugador3 = 0;
        
        //ArrayList<Integer> arl = new ArrayList<Integer>();

        for(int i = 0; i < 100; i++){          
            switch(Dado.getInstance().quienEmpieza(n_jugadores)){
                case 0: jugador0++; break;
                case 1: jugador1++; break;
                case 2: jugador2++; break;
                case 3: jugador3++; break;
            }
        }
        System.out.println("PRUEBA 1");
        System.out.println("Jugador 1: " + jugador0 +
                            " Jugador 2: " + jugador1 + 
                            " Jugador 3: " + jugador2 + 
                            " Jugador 4: " + jugador3);
        
    //DOS: FUNCIONAMIENTO DEL MODO DEBUG DEL DADO ACTIVANDO Y DESACTIVANDO
        
        System.out.println("PRUEBA 2");
        Dado.getInstance().setDebug(true);
        
        System.out.println("DEBUG ACTIVADO");
        for(int i = 0; i < 10; i++){
            System.out.println("Tirada " + i + " valor: " + Dado.getInstance().tirar());
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
        
        System.out.println("ENUMERADO TipoSorpresa: " + TipoSorpresa.PAGARCOBRAR);
        
    //CINCO: CREACION DE OBJETO TABLERO Y REALIZAR TESTS
    
        Tablero tablero = new Tablero();
        tablero.aniadeCasilla(new Casilla(TipoCasilla.CALLE, "Primera Parada", 11.5f, 17.2f, 22.3f));
        tablero.aniadeCasilla(new Casilla(TipoCasilla.CALLE, "ETSIIT", 4.5f, 78.2f, 3.3f));
        tablero.aniadeCasilla(new Casilla(TipoCasilla.CALLE, "Samsung", 41.5f, 87.2f, 21.3f));
        tablero.aniadeCasilla(new Casilla(TipoCasilla.CALLE, "MultiPlaza", 42.9f, 47.2f, 96.3f));
        tablero.aniadeCasilla(new Casilla(TipoCasilla.CALLE, "Soho Mall", 3.7f, 21.66f, 12.63f));
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
        
    //FIN PROGRAMA PRINCIPAL
    }
    
}

