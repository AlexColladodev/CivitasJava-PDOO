require_relative 'estado_juego'
module Controlador_laberinto



class Controlador
  attr_reader :vidas, :estado, :habitacion_usuario
  def initialize(modelo)
    @modelo = modelo
    @vidas = 0
    @habitacion_usuario = nil
    @estado = Estado_juego::EN_ENTRADA_LABERINTO #ENTRADA_LABERINTO

  end

  def entrar(vidas) #Habitacion_Usuario le pide al modelo la puerta de entrada a la puerta del otro lado
    @vidas = vidas

    #Elemento separador entre afuera y la habitacion a la cual entrara
    elemento_separador = Elemento_separador.nueva_pared(@habitacion_usuario, @modelo.puerta_entrada.habitacion_al_otro_lado(@habitacion_usuario0))

    @habitacion_usuario = @modelo.puerta_entrada.habitacion_al_otro_lado(@habitacion_usuario) #El usuario entra al laberinto y ahora su habitacion es el atributo de instancia
    @habitacion_usuario.set_lado(Direccion::SUR, elemento_separador)

    @estado = Estado_juego::DENTRO_VIVO

  end

  def intentar_avanzar
    direccion = rand(4) #NORTE, SUR, ESTE, OESTE


    if(@habitacion_usuario.pasar(direccion))
      @habitacion_usuario = @habitacion_usuario.get_lado(direccion).habitacion_al_otro_lado(@habitacion_usuario)
      if(@habitacion_usuario == nil)
        @estado = Estado_juego::EN_SALIDA_LABERINTO
      else
        @estado = Estado_juego::DENTRO_VIVO
      end
    else
      @vidas = @vidas - 1
      if(@vidas == 0)
        @estado = Estado_juego::DENTRO_MUERTO
      else
        @estado = Estado_juego::DENTRO_VIVO
      end
    end

    if(@habitacion_usuario.tiene_trampa)
      @vidas = 0
      @estado = Estado_juego::DENTRO_MUERTO
    end

    return direccion

  end


end

end