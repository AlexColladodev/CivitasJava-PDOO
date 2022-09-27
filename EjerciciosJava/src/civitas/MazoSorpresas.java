
package civitas;

import java.util.ArrayList;
import java.util.Collections;



//@author SatoriAlex // Alexander Collado Rojas Y7412507N

public class MazoSorpresas {
    
    //Atributos de Instancia
    private ArrayList<Sorpresa> sorpresas;
    private boolean barajada;
    private int usadas;
    private boolean debug;
    
    //Metodo Privado
    void init(){
        sorpresas = new ArrayList<>();
        barajada = false;
        usadas = 0;
    }
    
    //Constructores
    MazoSorpresas(boolean d){
        
        init();
        
        debug = d;
        
        String evento = "Modo Debug Activado";
        
        Diario.getInstance().ocurreEvento(evento);
    }
    
    MazoSorpresas(){
        
        init();
        
        debug = false;
    }
    
    void alMazo(Sorpresa s){
        if(!barajada){
            sorpresas.add(s);
        }
    }
    
    Sorpresa siguiente(){
        
        Sorpresa sorpresaAuxiliar;
        
        if((!barajada || usadas == sorpresas.size()) && !debug ){
            Collections.shuffle(sorpresas); // Barajear
            usadas = 0;
            barajada = true;
        }
        
        usadas++;
        sorpresaAuxiliar = sorpresas.get(0);
        sorpresas.remove(0);
        sorpresas.add(sorpresaAuxiliar);
        
        return sorpresaAuxiliar;
    }
}
