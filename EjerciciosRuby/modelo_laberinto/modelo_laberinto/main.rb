require_relative 'controlador.rb'
require_relative 'vista_laberinto.rb'
require_relative 'laberinto.rb'

include Controlador_laberinto
modelo = Laberinto.new()
controlador = Controlador.new(modelo)
vista = Vista_laberinto.new(controlador)
vista.menu_usuario





