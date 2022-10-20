/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

//@author SatoriAlex // Alexander Collado Rojas Y7412507N

import civitas.CivitasJuego;
import controladorCivitas.Controlador;
import java.util.ArrayList;
import vistaTextualCivitas.VistaTextual;

public class JuegoTexto {
    public static void main(String[] args){
        ArrayList<String> nombres = new ArrayList<String>();
        nombres.add("Alex");
        nombres.add("Dani");
        nombres.add("Jhonny");
        nombres.add("Mike");
        
        CivitasJuego juegoModel = new CivitasJuego(nombres, false);
        
        VistaTextual vista = new VistaTextual(juegoModel);
        
        Controlador controlador = new Controlador(juegoModel, vista);
        
        controlador.juega();
        
    }
}
