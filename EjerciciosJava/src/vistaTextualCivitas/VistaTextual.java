package vistaTextualCivitas;

import civitas.Casilla;
import civitas.CivitasJuego;
import civitas.Diario;
import civitas.OperacionJuego;
import controladorCivitas.Respuesta;
import civitas.OperacionInmobiliaria;
import civitas.Jugador;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;



public class VistaTextual implements Vista {

    
  private static String separador = "=====================";
  
  private Scanner in;
  
  CivitasJuego juegoModel;
  
  public VistaTextual (CivitasJuego juegoModel) {
    in = new Scanner (System.in);
    this.juegoModel=juegoModel;
  }
  
  
           
 public  void pausa() {
    System.out.print ("\nPulsa una tecla");
    in.nextLine();
  }

  int leeEntero (int max, String msg1, String msg2) {
    Boolean ok;
    String cadena;
    int numero = -1;
    do {
      System.out.print (msg1);
      cadena = in.nextLine();
      try {  
        numero = Integer.parseInt(cadena);
        ok = true;
      } catch (NumberFormatException e) { // No se ha introducido un entero
        System.out.println (msg2);
        ok = false;  
      }
      if (ok && (numero < 0 || numero >= max)) {
        System.out.println (msg2);
        ok = false;
      }
    } while (!ok);

    return numero;
  }

  int menu (String titulo, ArrayList<String> lista) {
    String tab = "  ";
    int opcion;
    System.out.println (titulo);
    for (int i = 0; i < lista.size(); i++) {
      System.out.println (tab+i+"-"+lista.get(i));
    }

    opcion = leeEntero(lista.size(),
                          "\n"+tab+"Elige una opción: ",
                          tab+"Valor erróneo");
    return opcion;
  }
  
  //PARA LOS METODOS CREE UN METODO QUE ME DEVUELVE LA CASILLA ACTUAL DESDE LA CLASE CIVITAS
  
  public void actualiza(){
      
      System.out.println(this.juegoModel.getJugadorActual().toString());
      
      System.out.println("La informacion de la casilla actual es: " + this.juegoModel.getTablero().getCasilla(this.juegoModel.getJugadorCasillaActual()));
        
  }
  

  public Respuesta comprar(){
      String casillaActual = this.juegoModel.getTablero().getCasilla(this.juegoModel.getJugadorCasillaActual()).getNombre();
      
      int opcion = menu("Estas en la casilla: " + casillaActual + ". Deseas comprarla?", new ArrayList<>(Arrays.asList("SI", "NO")));
      
      return (Respuesta.values()[opcion]);
  }

  public OperacionInmobiliaria elegirOperacion(){
      
      String gestiones = "\nCONSTRUIR  CASA \n COSTRUIR HOTEL \n TERMINAR";
      
      int opcion = menu("Que Gestion Inmobiliaria deseas realizar?" + gestiones, new ArrayList<>(Arrays.asList("CONSTRUIR_CASA", "CONSTRUIR_HOTEL", "TERMINAR")));
      
      return (OperacionInmobiliaria.values()[opcion]);      
  }

  public int elegirPropiedad(){//Usando el indexOf de las propiedades de un jugador respecto con la casilla en la que esta ahorita
      
      ArrayList<String> propiedades = new ArrayList<>();
      
      for(int i = 0; i < this.juegoModel.getJugadorActual().getPropiedades().size(); i++){
          propiedades.add(this.juegoModel.getJugadorActual().getPropiedades().get(i).getNombre());
      }
      
      int propiedadElegida = menu("Indice de la propiedad sobre la cual se desea realizar gestiones: ", propiedades);
      
      return propiedadElegida;
  }

  //Muestra en consola el valor del argumento pasado
    //Con valor se refiere al numero o  al enumerado como palabra??
  public void mostrarSiguienteOperacion(OperacionJuego operacion){
      switch(operacion){
          case AVANZAR: System.out.println("La siguiente operacion es: AVANZAR");
          break;
          case PASAR_TURNO: System.out.println("La siguiente operacion es: PASAR_TURNO");
          break;
          case COMPRAR: System.out.println("La siguiente operacion es: COMPRAR");
          break;
          case GESTIONAR: System.out.println("La siguiente operacion es: GESTIONAR");
          break;
      }
  }

  public void mostrarEventos(){
      while(Diario.getInstance().eventosPendientes()){
          System.out.println(Diario.getInstance().leerEvento());
      }
  }

}
