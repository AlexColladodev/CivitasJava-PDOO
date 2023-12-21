/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package civitas;

//@author SatoriAlex // Alexander Collado Rojas Y7412507N

public class GestionInmobiliaria {
    private int propiedad;
    private OperacionInmobiliaria operacion;
    
    public GestionInmobiliaria(OperacionInmobiliaria gest, int ip){
        this.propiedad = ip;
        this.operacion = gest;
    }

    public int getPropiedad() {
        return propiedad;
    }

    public OperacionInmobiliaria getOperacion() {
        return operacion;
    }
    
    
}
