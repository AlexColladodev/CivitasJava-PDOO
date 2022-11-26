require_relative 'controlador.rb'
require_relative 'habitacion.rb'
require_relative 'direccion.rb'

class Vista_laberinto

  def initialize(controlador)
    @controlador = controlador
  end

  def menu_usuario
    estado=@controlador.estado
    values=[*1..10].map!(&:to_s)

    case estado
    when Estado_juego::TRAMPA_ACTIVADA
      @controlador.vidas = 0
      self.informe_final_trampas
      exit 0

    when Estado_juego::EN_ENTRADA_LABERINTO

      puts "Intoduzca el número de vidas (entre 1 y 10) antes de entrar en el laberinto"
      st=gets.chomp

      while (!values.include? st)
        puts "Intoduzca el número de vidas (entre 1 y 10) antes de entrar en el laberinto"
        st=gets.chomp
      end
      @controlador.entrar(st.to_i)

    when Estado_juego::DENTRO_VIVO
      self.informe_dentro(@controlador.habitacion_usuario, @controlador.vidas)
      puts "Pulse una tecla"
      st= gets.chomp

      Lista_direcciones[@controlador.intentar_avanzar()]
    when Estado_juego::EN_SALIDA_LABERINTO
      self.informe_final(@controlador.vidas)
      exit 0
    when Estado_juego::DENTRO_MUERTO
      self.informe_final(@controlador.vidas)
      exit 0

    end
    menu_usuario
  end

  def informe_dentro(habitacion, vidas)
    puts "Estas en la habitacion :"  + habitacion.num_habitacion.to_s + " -- PoSibilidad de trampa = " + habitacion.activa_trampa.to_s
    puts "Te quedan :"  + vidas.to_s
  end

  def informe_final(vidas)
    if(vidas == 0)
      puts "Has muerto te quedan :" + vidas.to_s + " vidas"
    else
      puts "SALISTE"
    end
  end

  def informe_final_trampas()
    puts "Has muerto por una trampa tu vida ahora es 0"
  end
end
