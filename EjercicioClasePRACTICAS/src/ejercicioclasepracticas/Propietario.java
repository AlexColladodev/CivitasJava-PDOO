/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejercicioclasepracticas;

/**
 *
 * @author alexc
 */
public class Propietario {


    private String nombre;
    private String contacto;
    private String propietario_id;
    
    Propietario(String nombre, String contacto, String propietario_id){
        this.nombre = nombre;
        this.contacto = contacto;
        this.propietario_id = propietario_id;
    }
    
    public String getNombre(){
        return this.nombre;
    }
    
    public String getContacto(){
        return this.contacto;
    }
    
    public String getPropietarioID(){
        return this.propietario_id;
    }
    
    public void setNombre(String nombre){
        this.nombre = nombre;
    }
    
    public void setContacto(String contacto){
        this.contacto = contacto;
    }
    
    public void setPropietarioID(String propietario_id){
        this.propietario_id = propietario_id;
    }
    
}
