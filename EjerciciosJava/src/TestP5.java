/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

import civitas.CivitasJuego;
import controladorCivitas.Controlador;
import java.util.ArrayList;
import vistaTextualCivitas.VistaTextual;
import GUI.*;

import GUI.*;

public class TestP5 {

    public static void main(String[] args) {

        CivitasView vistaGUI = new CivitasView();
        CapturaNombres captura = new CapturaNombres(vistaGUI, true);

        Dado.createInstance(vistaGUI);
        Dado.getInstance().setDebug(false);
        
        ArrayList<String> nombres = new ArrayList<String>();
        nombres = captura.getNombres();

        CivitasJuego juegoModel = new CivitasJuego(nombres, false);
        Controlador controlador = new Controlador(juegoModel, vistaGUI);
        
        vistaGUI.setJuego(juegoModel);

        controlador.juega();

    }
}
