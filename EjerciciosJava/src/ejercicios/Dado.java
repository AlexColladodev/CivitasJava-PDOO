
package ejercicios;

import java.util.Random;

//@author SatoriAlex // Alexander Collado Rojas Y7412507N

public class Dado {
    
    //Atributo de Clase
    static final private Dado instance = new Dado();
    
    //Atributos de Instancia
    private Random random = new Random();
    private int ultimoResultado;
    private boolean debug;
    
    private Dado(){//Hacerlo privado
        debug = false;
        ultimoResultado = 0;
        //Random ya inicializado al declarar objeto dado
    }
    
    static public Dado getInstance(){
        return instance;
    }
    
    
    int tirar(){
        
        if(!debug){
            ultimoResultado = (random.nextInt(6)+1); // Posibles resultados entre 0 y 6 // Normalmente seria entre 0 y 5 pero con el +1 se cambia
        }else{
            ultimoResultado = 1;
        }
        
        return ultimoResultado;
    }
    
    //Devuelve quien empieza entre 0 y n-1 jugadores
    int quienEmpieza(int n){
        return random.nextInt(n);
    }
    
    void setDebug(boolean d){
        
        debug = d;
        String evento;
        
        if(d){
            evento = "Modo Debug Activado";
        }else{
            evento = "Modo Debug Desactivado";
        }
        
        Diario.getInstance().ocurreEvento(evento);
    }
    
    int getUltimoResultado(){
        return ultimoResultado;
    }
    
}
