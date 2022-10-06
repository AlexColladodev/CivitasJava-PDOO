/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejercicioclasepracticas;


public class Caracteristicas {
    
    private static int NUM_CARACTERISTICAS = 0;
    
    private int codCaracteristicas;
    private boolean piscina;
    private String direccion;
    private String telefonoContacto;
    private boolean parking;
    private int numHabitaciones;
    private int numRestaurantes;
    private float precioMedioHabitacion;
    
    public Caracteristicas(){
        this.codCaracteristicas = NUM_CARACTERISTICAS;
        this.numHabitaciones = 0;
        this.direccion = " ";
        this.telefonoContacto = " ";
        this.parking = false;
        this.piscina = false;
        this.numRestaurantes = 0;
        this.precioMedioHabitacion = 0;
        
        this.updateNum_CARACTERISTICAS();
    }

    public static int getNUM_CARACTERISTICAS() {
        return NUM_CARACTERISTICAS;
    }

    public static void setNUM_CARACTERISTICAS(int NUM_CARACTERISTICAS) {
        Caracteristicas.NUM_CARACTERISTICAS = NUM_CARACTERISTICAS;
    }

    public int getCodCaracteristicas() {
        return codCaracteristicas;
    }

    public void setCodCaracteristicas(int codCaracteristicas) {
        this.codCaracteristicas = codCaracteristicas;
    }

    public boolean isPiscina() {
        return piscina;
    }

    public void setPiscina(boolean piscina) {
        this.piscina = piscina;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefonoContacto() {
        return telefonoContacto;
    }

    public void setTelefonoContacto(String telefonoContacto) {
        this.telefonoContacto = telefonoContacto;
    }

    public boolean isParking() {
        return parking;
    }

    public void setParking(boolean parking) {
        this.parking = parking;
    }

    public int getNumHabitaciones() {
        return numHabitaciones;
    }

    public void setNumHabitaciones(int numHabitaciones) {
        this.numHabitaciones = numHabitaciones;
    }

    public int getNumRestaurantes() {
        return numRestaurantes;
    }

    public void setNumRestaurantes(int numRestaurantes) {
        this.numRestaurantes = numRestaurantes;
    }

    public float getPrecioMedioHabitacion() {
        return precioMedioHabitacion;
    }

    public void setPrecioMedioHabitacion(float precioMedioHabitacion) {
        this.precioMedioHabitacion = precioMedioHabitacion;
    }
    
    public void updateNum_CARACTERISTICAS(){
        NUM_CARACTERISTICAS++;
    }
    
    
    
    
}
