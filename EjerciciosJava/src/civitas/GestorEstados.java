package civitas;

class GestorEstados {
  EstadoJuego estadoInicial() {
    return (EstadoJuego.INICIO_TURNO);
  }
  
  OperacionesJuego siguienteOperacion(Jugador jugador, EstadoJuego estado) {
    OperacionesJuego op = null;

    switch (estado) {
      case INICIO_TURNO :
          op = OperacionesJuego.AVANZAR;
        break;

      case DESPUES_AVANZAR :
        if (jugador.getPuedeComprar())
          op = OperacionesJuego.COMPRAR;
        else if (jugador.tieneAlgoQueGestionar())
          op = OperacionesJuego.GESTIONAR;
        else
          op = OperacionesJuego.PASAR_TURNO;
        break;

      case DESPUES_COMPRAR :
        if (jugador.tieneAlgoQueGestionar())
          op = OperacionesJuego.GESTIONAR;
        else
          op = OperacionesJuego.PASAR_TURNO;
        break;

      case DESPUES_GESTIONAR :
        op = OperacionesJuego.PASAR_TURNO;
        break;        
    }
    return op;
  }
  
  EstadoJuego siguienteEstado (Jugador jugador, EstadoJuego estado, OperacionesJuego operacion) {
    EstadoJuego siguiente = null;

    switch (estado) {
      case INICIO_TURNO :
        if (operacion==OperacionesJuego.AVANZAR)
          siguiente = EstadoJuego.DESPUES_AVANZAR;
        break;

      case DESPUES_AVANZAR :
        switch (operacion) {
          case PASAR_TURNO :
            siguiente = EstadoJuego.INICIO_TURNO;
            break;
          case COMPRAR :
            siguiente = EstadoJuego.DESPUES_COMPRAR;
            break;
          case GESTIONAR :
            siguiente = EstadoJuego.DESPUES_GESTIONAR;
            break;
        }
        break;

      case DESPUES_COMPRAR :
        if (operacion==OperacionesJuego.GESTIONAR)
          siguiente = EstadoJuego.DESPUES_GESTIONAR;
        else if (operacion==OperacionesJuego.PASAR_TURNO)
          siguiente = EstadoJuego.INICIO_TURNO;
        break;

      case DESPUES_GESTIONAR :
        if (operacion==OperacionesJuego.PASAR_TURNO)
          siguiente = EstadoJuego.INICIO_TURNO;
        break;
    }

    Diario.getInstance().ocurreEvento("De: "+estado.toString()+ " con "+operacion.toString()+ " sale: "+siguiente.toString());

    return siguiente;
  }

}