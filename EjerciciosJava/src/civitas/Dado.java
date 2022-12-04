
package civitas;

import java.util.Random;

//@author SatoriAlex // Alexander Collado Rojas Y7412507N

public class Dado {
    
    //Atributo de Clase
    static final private Dado instance = new Dado();
    static final private int VALORESDADO = 6;
    static final private int VALORDEBUG = 1;
    
    //Atributos de Instancia
    private Random random = new Random();
    private int ultimoResultado;
    private boolean debug;

    public boolean isDebug() {
        return debug;
    }
    
    private Dado(){ 
        debug = false;
        ultimoResultado = 0;
    }
    
    public static Dado getInstance(){
        return Dado.instance;
    }
    
    
    public int tirar(){
        
        if(!debug){
            ultimoResultado = (random.nextInt(VALORESDADO)+1); // Posibles resultados entre 0 y 6 // Normalmente seria entre 0 y 5 pero con el +1 se cambia
        }else{
            ultimoResultado = VALORDEBUG;
        }
        
        return ultimoResultado;
    }
    
    //Devuelve quien empieza entre 0 y n-1 jugadores
    int quienEmpieza(int n){
        return random.nextInt(n);
    }
    
    public void setDebug(boolean d){
        
        debug = d;
        String evento;
        
        if(d){
            evento = "Modo Debug Activado";
        }else{
            evento = "Modo Debug Desactivado";
        }
        
        Diario.getInstance().ocurreEvento(evento);
    }
    
    public int getUltimoResultado(){
        return this.ultimoResultado;
    }
    
}
