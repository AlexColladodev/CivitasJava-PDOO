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
    
    //Llama al constructor de copia para convertir un jugador como Especulador
    protected JugadorEspeculador(Jugador otro){
        super(otro);
        
        this.actualizaPropiedadesPorConversion(otro);
    }
    
    private void actualizaPropiedadesPorConversion(Jugador antiguoPropietario){
        for(int i = 0; i < antiguoPropietario.getPropiedades().size(); i++){
            antiguoPropietario.getPropiedades().get(i).actualizaPropietarioPorConversion(this);
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
    
    @Override
    boolean paga(float cantidad){
        return super.modificarSaldo(cantidad / FACTORESPECULADOR);
    }
    
    @Override
    boolean puedoGastar(float cantidad){
        return super.puedoGastar(cantidad / FACTORESPECULADOR);
    }
    
    @Override
    protected boolean puedoEdificarHotel(CasillaCalle casilla){
        boolean puedoEdificarHotel = false;
        float precio = casilla.getPrecioEdificar();
        
        if(this.puedoGastar(precio / FACTORESPECULADOR)){
            if(casilla.getNumHoteles()< JugadorEspeculador.HotelesMax){
                //[propiedad.getNumCasas()>=getCasasPorHotel()]
                if(casilla.getNumCasas() >= JugadorEspeculador.CasasPorHotel){
                    puedoEdificarHotel = true;
                }
            }
        }
        
        return puedoEdificarHotel;
    }
    
    @Override
    protected boolean puedoEdificarCasa(CasillaCalle casilla){
        float precioEdificar = casilla.getPrecioEdificar();
        boolean puedoEdificar = false;
        
        if(this.puedoGastar(precioEdificar / FACTORESPECULADOR) && casilla.getNumCasas() < JugadorEspeculador.CasasMax){
            puedoEdificar = true;
        }
        
        return puedoEdificar;
    }
    
    /*
    @Override
    public boolean puedoGastar(){
        
    }*/ //Toca sobreescribir el puede gastar para que cuando tenga que pagar solo pague la mitad
}
