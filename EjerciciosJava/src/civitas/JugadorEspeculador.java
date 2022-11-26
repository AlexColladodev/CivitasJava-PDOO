/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package civitas;

/**
 *
 * @author alexc
 */
public class JugadorEspeculador extends Jugador {
    
    private static int FACTORESPECULADOR = 2;
    
    protected JugadorEspeculador(String nombre){
        super(nombre);
        
        for(int i = 0 ; i < super.getPropiedades().size(); i++){
            
        }
    }
    
    @Override
    public int getHotelesMax(){
        return (super.getHotelesMax() * FACTORESPECULADOR);
    }
    
    @Override
    public int getCasasMax(){
        return (super.getCasasMax() * FACTORESPECULADOR);
    }
    
    
    
    
    /*
    @Override
    public boolean puedoGastar(){
        
    }*/ //Toca sobreescribir el puede gastar para que cuando tenga que pagar solo pague la mitad
}
