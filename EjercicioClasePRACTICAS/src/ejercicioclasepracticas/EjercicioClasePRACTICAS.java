/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ejercicioclasepracticas;


import java.util.ArrayList;

public class EjercicioClasePRACTICAS {

        private static String conMasParcelas(ArrayList<Parcela> parcelas){
        
        float sumaParcelas1 = 0.0f;
        float sumaParcelas2 = 0.0f;
        float sumaParcelas3 = 0.0f;
        int indiceMayor1 = -1;
        int indiceMayor2 = -1;
        int indiceMayor3 = -1;
        String propietarioMayor = "Ninguno";
        
        
        for(int i = 0; i < parcelas.size(); i++){
            if(parcelas.get(i).getPropietario().getPropietarioID() == "01"){
                sumaParcelas1 += parcelas.get(i).getPrecioCompra();
                indiceMayor1 = i;
            }
            if(parcelas.get(i).getPropietario().getPropietarioID() == "02"){
                sumaParcelas2 += parcelas.get(i).getPrecioCompra();
                indiceMayor2 = i;
            }
            if(parcelas.get(i).getPropietario().getPropietarioID() == "03"){
                sumaParcelas3 += parcelas.get(i).getPrecioCompra();
                indiceMayor3 = i;
            }      
        }    
        
        if(sumaParcelas1 > sumaParcelas2){
            propietarioMayor = parcelas.get(indiceMayor1).getPropietario().getNombre();
        }
        if(sumaParcelas2 > sumaParcelas3){
            propietarioMayor = parcelas.get(indiceMayor2).getPropietario().getNombre();
        }
        if(sumaParcelas3 > sumaParcelas1){
            propietarioMayor = parcelas.get(indiceMayor3).getPropietario().getNombre();
        }
        
        return propietarioMayor;
    }
        
    public static void main(String[] args) {
        
        /*
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
        //FIN de prueba de primera parte*/
        
        /*
        System.out.println("/////// EJERCICIOS DE CLASE 2 ////////");
        ArrayList<Parcela> parcelas = new ArrayList<>();
        ArrayList<Propietario> propietarios = new ArrayList<>();
        
        propietarios.add(new Propietario("Alex", "654123", "01"));
        propietarios.add(new Propietario("Andres", "111222333", "02"));
        propietarios.add(new Propietario("Dani", "7894561", "03"));
        
        parcelas.add(new Parcela("Parcela 1", 42.3f, 52.3f, 77.8f, propietarios.get(0)));
        parcelas.add(new Parcela("Parcela 2", 11.5f, 45.3f, 78.8f, propietarios.get(0)));
        parcelas.add(new Parcela("Parcela 3", 74.5f, 21.3f, 78.8f, propietarios.get(0)));
        parcelas.add(new Parcela("Parcela 4", 114.5f, 31.3f, 78.8f, propietarios.get(0)));
        parcelas.add(new Parcela("Parcela 5", 78.5f, 222.3f, 78.8f, propietarios.get(1)));
        parcelas.add(new Parcela("Parcela 6", 55.5f, 45.3f, 42.8f, propietarios.get(1)));
        parcelas.add(new Parcela("Parcela 7", 28.5f, 66.3f, 15.8f, propietarios.get(1)));
        parcelas.add(new Parcela("Parcela 8", 45.5f, 87.3f, 97.8f, propietarios.get(2)));
        parcelas.add(new Parcela("Parcela 9", 25.5f, 98.3f, 74.8f, propietarios.get(2)));
        parcelas.add(new Parcela("Parcela 10", 96.5f, 33.3f, 14.8f, propietarios.get(2)));
        
        
        System.out.println("El propietario con mas coste de compra en todas las parcelas es: " + conMasParcelas(parcelas));        
     */

    //TESTEO PARA LA P2 PROGRAMA PRINCIPAL NO CIVITAS
        Parcela par1 = new Parcela("Parcela1", 12.3f, 15.5f, 12.2f); 
        Caracteristicas car1 = new Caracteristicas();
        Caracteristicas car2 = new Caracteristicas();
        Caracteristicas car3 = new Caracteristicas();
        
        Hotel hotel1 = new Hotel("Hotel Paradise", "PTY", 5, par1, car1);
        Hotel hotel2 = new Hotel("Hotel Bali", "PTY", 2, par1, car2);
        Hotel hotel3 = new Hotel("Hotel Bali", "PTY", 2, par1, car3);
        System.out.println("Numero de Hoteles: " + Hotel.getNUM_HOTELES());
        
        hotel1.getCaracteristicas().setNumHabitaciones(5);
        hotel1.getCaracteristicas().setPrecioMedioHabitacion(22.6f);
        hotel2.getCaracteristicas().setNumHabitaciones(3);
        hotel2.getCaracteristicas().setPrecioMedioHabitacion(14.2f);
        hotel3.getCaracteristicas().setNumHabitaciones(7);
        hotel3.getCaracteristicas().setPrecioMedioHabitacion(63.4f);
        
        Director dir1 = new Director("Manolo", 258963147l);
        
        hotel1.setDirector(dir1);
        
        System.out.println("Director del Hotel 1: " + hotel1.getDirector().getNombre());
        
        Cliente client1 = new Cliente("Y7412507N", "Alex");
        Reserva reserv1 = new Reserva("25/10/22", "22/3/21", client1, hotel2);
        Reserva reserv2 = new Reserva("22/09/22", "22/3/21", client1, hotel2);
        
        hotel2.addReserva(client1, reserv1.getFechaEntrada(), reserv1.getFechaSalida());
        //hotel2.addReserva(client1, reserv2.getFechaEntrada(), reserv2.getFechaSalida());
        client1.addReserva(reserv1);
        //client1.addReserva(reserv2);
        
        for(int i = 0; i < hotel2.getReservas().size(); i++){
            System.out.println(hotel2.getReservas().get(i).getCliente().getNombre() + " " + hotel2.getReservas().get(i).getFechaEntrada());
        }
        
        for(int i = 0; i < client1.getReservas().size(); i++){
            System.out.println(client1.getReservas().get(i).getFechaEntrada());
        }
        
        System.out.println("RESULTADOS A EJERCICIO DE CLASE 10/06/22");
        
        int sumaHabitaciones = 0;
        
        for(int i = 0; i < par1.getHoteles().size(); i++){
            sumaHabitaciones = sumaHabitaciones + par1.getHoteles().get(i).getCaracteristicas().getNumHabitaciones();
        }
        
        System.out.println("La suma de todas las habitaciones de la parcela " + par1.getNombre() + " es " + sumaHabitaciones);
        
        float sumaPrecio = 0;
        
        for(int i = 0; i < par1.getHoteles().size(); i++){
            sumaPrecio = sumaPrecio +  (par1.getHoteles().get(i).getCaracteristicas().getNumHabitaciones() * par1.getHoteles().get(i).getCaracteristicas().getPrecioMedioHabitacion());
        }
        
        System.out.println("El precio total de la suma de las habitaciones respecto al precio medio por habitacion es de " + sumaPrecio);
        
    
    
        hotel1.addHabitacion(5, 6);
        hotel1.addHabitacion(15, 22);
        hotel1.addHabitacion(23, 55);
        
        
        System.out.println("Se busca habitacion para 5 personas // Es la hab numero: " + hotel1.buscarHabitacion(6));
        System.out.println("Se busca habitacion para 15 personas // Es la hab numero: " + hotel1.buscarHabitacion(22));
        
        Empleado empleado1 = new Empleado("Manuelito Sanchez");
        empleado1.addTrabajo(hotel1);
        
        Empleado empleado2 = new Empleado("Alex Croto");
        empleado1.addTrabajo(hotel1);
        
        Empleado empleado3 = new Empleado("Benito Camelas");
        empleado1.addTrabajo(hotel1);
        
        System.out.println("Factor del HOTEL 1 segun su estrellas. Estrellas: " + hotel1.getEstrellas() + " el factor es: " + Hotel.getFactor(hotel1.getEstrellas()));
        
        System.out.println("Coste por dia de hotel 1: " + hotel1.costePorDia());
    
    }
    
}
