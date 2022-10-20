require_relative 'controlador.rb'
require_relative 'habitacion.rb'
require_relative 'direccion.rb'

class Vista_laberinto

  def initialize(controlador)
    @controlador
  end

  def menu_usuario
    estado=@controlador.estado
    values=[*1..10].map!(&:to_s)

    case estado
    when EstadoJuego::TRAMPA_ACTIVADA
      @controlador.vidas = 0
      self.informe_final_trampas
      exit 0

    when EstadoJuego::EN_ENTRADA_LABERINTO

      puts "Intoduzca el número de vidas (entre 1 y 10) antes de entrar en el laberinto"
      st=gets.chomp

      while (!values.include? st)
        puts "Intoduzca el número de vidas (entre 1 y 10) antes de entrar en el laberinto"
        st=gets.chomp
      end
      @controlador.entrar(st.to_i)

    when EstadoJuego::DENTRO_VIVO
      self.informe_dentro(@controlador.habitacion_usuario, @controlador.vidas)
      puts "Pulse una tecla"
      st= gets.chomp

      Lista_direcciones[@controlador.intenta_avanzad()]
    when EstadoJuego::EN_SALIDA_LABERINTO
      self.informe_final(@controlador.vidas)
      exit 0
    when EstadoJuego::DENTRO_MUERTO
      self.informe_final(@controlador.vidas)
      exit0

    end
    menu_usuario
  end

  def informe_dentro(habitacion, vidas)
    puts habitacion.num_habitacion.to_s
    puts vidas.to_s
  end

  def informe_final(vidas)
    puts vidas.to_s
  end

  def informe_final_trampas()
    puts "Has muerto por una trampa tu vida ahora es 0"
  end
end
