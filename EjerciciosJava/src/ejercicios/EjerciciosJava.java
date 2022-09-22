
package ejercicios;

//@author SatoriAlex // Alexander Collado Rojas Y7412507N

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
        
        
        Parcela par3 = par2; //Igualdad de identidad prueba
        Parcela par4 = new Parcela("Parcela2", 11.2f, 12.5f, 25.2f); //Igualdad de estado prueba
        
        //Construir las casas y hoteles para tener el mismo estado
        par4.construirCasa();
        par4.construirHotel();
        par4.construirHotel();
        
        //par3.construirCasa(); //A; apuntar a la misma direcci[on de memoria si par3 cambia entonces tambien cambia par2
        
        System.out.println("Igualdad de Identidad");
        System.out.println("Parcela 1 con Parcela 2: " + par1.igualdadIdentidad(par2)); // false NO IGUALDAD NI DE IDENTIDAD NI DE ESTADO
        System.out.println("Parcela 2 con Parcela 3: " + par2.igualdadIdentidad(par3)); // true IGUALDAD DE IDENTIDAD Y DE ESTADO
        System.out.println("Parcela 2 con Parcela 4: " + par2.igualdadIdentidad(par4)); // false NO IGUALDAD DE IDENTIDAD PERO SI DE ESTADO
        
        System.out.println("Igualdad de Estado");
        System.out.println("Parcela 1 con Parcela 2: " + par1.igualdadEstado(par2)); // false NO IGUALDAD NI DE IDENTIDAD NI DE ESTADO
        System.out.println("Parcela 2 con Parcela 3: " + par2.igualdadEstado(par3)); // false IGUALDAD DE IDENTIDAD Y DE ESTADO
        System.out.println("Parcela 2 con Parcela 4: " + par2.igualdadEstado(par4)); // true NO IGUALDAD DE IDENTIDAD PERO SI DE ESTADO
        //FIN de prueba de primera parte
        
    }
    
}

