/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controladorCivitas;

import civitas.CivitasJuego;
import civitas.Diario;
import vistaTextualCivitas.VistaTextual;
import civitas.OperacionJuego;
import civitas.OperacionInmobiliaria;
import civitas.GestionInmobiliaria;

//@author SatoriAlex // Alexander Collado Rojas Y7412507N

public class Controlador {
    private CivitasJuego juegoModel;
    private VistaTextual vista;
    
    
    public Controlador(CivitasJuego juego, VistaTextual vista){
        this.juegoModel = juego;
        this.vista = vista;
    }
    
    public void juega(){
        OperacionJuego siguiente;
        Respuesta respuesta;
        OperacionInmobiliaria operacion;
        int iPropiedad;
        
        while(!this.juegoModel.finalDelJuego()){
            
            this.vista.actualiza();
            
            this.vista.pausa();
            
            siguiente = this.juegoModel.siguientePaso();
            this.vista.mostrarSiguienteOperacion(siguiente);
            
            if(siguiente != OperacionJuego.PASAR_TURNO){
                    this.vista.mostrarEventos();
            }
            
            if(!this.juegoModel.finalDelJuego()){
                switch(siguiente){
                    case COMPRAR:
                        respuesta = this.vista.comprar();
                        if(respuesta == Respuesta.SI){
                            this.juegoModel.comprar();
                        }
                        this.juegoModel.siguientePasoCompletado(siguiente);
                    break;
                    case GESTIONAR:
                        operacion = this.vista.elegirOperacion();
                        
                        if(operacion != OperacionInmobiliaria.TERMINAR){
                            iPropiedad = this.vista.elegirPropiedad();
                            GestionInmobiliaria gestion = new GestionInmobiliaria(operacion, iPropiedad);
                            
                            if(operacion == OperacionInmobiliaria.CONSTRUIR_CASA){
                                this.juegoModel.construirCasa(gestion.getPropiedad());
                            }else if(operacion == OperacionInmobiliaria.CONSTRUIR_HOTEL){
                                this.juegoModel.construirHotel(gestion.getPropiedad());
                            }
                        }else{
                            this.juegoModel.siguientePasoCompletado(siguiente);
                        }         
                    break;
                }
            }else{
                this.vista.actualiza();
            }
        }
    }
}
