
package ejercicios;

/**
 *
 * @author SatoriAlex // Alexander Collado Rojas Y7412507N
 */
public class EjerciciosJava {

    
    public static void main(String[] args) {
        
        
 
        //Probando Primera Parte PARCELA
        //Para mandar valores flotantes y no mande error como double hay que poner la f
        Parcela par1 = new Parcela("Parcela1", 12.3f, 15.5f, 12.2f);
        Parcela par2 = new Parcela("Parcela2", 11.2f, 12.5f, 25.2f);
        
        System.out.println("Nombre: " + par1.getNombre() + " PrecioCompra: " + par1.getPrecioCompra() + " PrecioEdificar : " + par1.getPrecioEdificar());
        System.out.println("Nombre: " + par2.getNombre() + " PrecioCompra: " + par2.getPrecioCompra() + " PrecioEdificar : " + par2.getPrecioEdificar());
        
        par1.construirCasa();
        par1.construirCasa();
        par2.construirCasa();
        
        System.out.println("Casas de parcela1: " + par1.getNumCasas());
        System.out.println("Casas de parcela2: " + par2.getNumCasas());
        
        par1.construirHotel();
        par2.construirHotel();
        par2.construirHotel();
        
        System.out.println("Hoteles de parcela1: " + par1.getNumHoteles());
        System.out.println("Hoteles de parcela2: " + par2.getNumHoteles());
        
        System.out.println("PrecioAlquiler Parcela1: " + par1.getPrecioAlquilerCompleto());
        System.out.println("PrecioAlquiler Parcela2: " + par2.getPrecioAlquilerCompleto());
        //FIN de prueba de primera parte
        
    }
    
}

