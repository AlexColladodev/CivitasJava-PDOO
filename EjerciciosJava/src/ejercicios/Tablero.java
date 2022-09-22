

package ejercicios;


//@author SatoriAlex // Alexander Collado Rojas Y7412507N

//Necesario incluirlo para el uso de ArrayList
import java.util.ArrayList;

public class Tablero {
    
    //Atributos de instancia
    private ArrayList<Casilla> casillas;
    private boolean porSalida;
    
    //Constructor
    Tablero(){
        casillas = new ArrayList<>();
        
        casillas.add(new Casilla(TipoCasilla.CALLE, "Salida", 0f, 0f, 0f)); //Incluir la primera casilla de nombre Salida, los demas valores a 0 y de tipo calle por mientras
        
        porSalida = false;
  
    }
    
    //Metodos de instancia privados
    private boolean correcto(int numCasilla){
        //return (numCasilla > 0)?true:false; Usando operador ternario redundante
        
        boolean correct = false;
        
        if(numCasilla >= 0){
            correct = true;
        }
        
        return correct;
    }
    
    //Metodos de instancia de paquete =? publicos
    
    //Solo lo devuelve y lo deja en false // Preguntar
    boolean computarPasoPorSalida(){       
        return porSalida;
    }
    
    void aniadeCasilla(Casilla casilla){
        casillas.add(casilla);
    }
    
    Casilla getCasilla(int numCasilla){
        
        return (correcto(numCasilla))?casillas.get(numCasilla):null;
        
    }
    
    int nuevaPosicion(int actual, int tirada){
        
        int nuevaPosicion = (actual+tirada) % casillas.size();
        
        //Si la nueva posicion no es el resultado de sumar actual + tirada entonces se habra pasado por salida
        if(nuevaPosicion != actual + tirada){
            porSalida = true;
        }
        
        return (actual+tirada) % casillas.size();
    }
    
    
    
    
    
}
