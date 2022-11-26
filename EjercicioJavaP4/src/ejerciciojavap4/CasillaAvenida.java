
package ejerciciojavap4;


public class CasillaAvenida extends Casilla {
    private int numParcela;
    private static final float FACTOR_AVENIDA = 2.4f; 
    
    CasillaAvenida(String nombre){
        super(nombre);
        
        numParcela = 1;
    }
    
    void construirParcela(){
        numParcela++;
        
        System.out.println("Hay un total de " + numParcela + " parcelas");
    }

    @Override
    float precioCompra() {
       return (numParcela * FACTOR_AVENIDA);
    }
}
