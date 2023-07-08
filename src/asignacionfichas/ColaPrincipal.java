//--------------------------------------------
// Universidad Nacional
// Sede Regional Chorotega
// Evaluacion #2 de Estructuras de Datos
// Programa: Caja de Servicios en CoopeUpala
//--------------------------------------------

package asignacionfichas;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author jeanh
 */

 public class ColaPrincipal {
        
    //Variables
    private NodoPrincipal colaInicial, colaFinal;
    String Cola = "";
    public NodoPrincipal Imostra1,Imostra2,Imostra3,
                         Fmostra1,Fmostra2,Fmostra3;
    
    
    //-- Metodos para Mostrador #1 --
    public int Mostra1(){
        Fmostra1 = null;
        Imostra1 = null;
        return 0;
    }//fin de metodo
    
    public void Mostra1_Agrega(int inf){
        if(Mostra1_Vacia()){
        NodoPrincipal nodoNuevo = new NodoPrincipal();
        nodoNuevo.info = inf;
        nodoNuevo.sig = null;
        
        if (Mostra1_Vacia()) {
            Imostra1 = nodoNuevo;
            Fmostra1 = nodoNuevo;
        }else{
            Fmostra1.sig = nodoNuevo;
            Fmostra1 = nodoNuevo;
           JOptionPane.showMessageDialog(null,"Espere en la fila, otros estan siendo atendidos.");
        }
        } 
    }//fin de metodo
    
    public boolean Mostra1_Vacia(){
        if(Imostra1 == null){
            return true;
        }else{
            return false;
        }
    }//fin de metodo
     
    public int Mostra1_Extrae(){
           if(!Mostra1_Vacia()) {
               int informacion= Imostra1.info;
            if(Imostra1 == Fmostra1){
               Imostra1 = null;
               Fmostra1 = null;
            }else{ 
                Imostra1 = Imostra1.sig;
            }
            return informacion;
        }else{
            return Integer.MAX_VALUE;
        }
    }//fin de metodo
     
     
    //-- Metodos para Mostrador #2 --
    public int Mostra2(){
        Imostra2 = null;
        Fmostra2 = null;
        return 0;
    }//fin de metodo
     
    public void Mostra2_Agrega(int inf){
        if(Mostra2_Vacia()){
        NodoPrincipal nodoNuevo = new NodoPrincipal();
        nodoNuevo.info = inf;
        nodoNuevo.sig = null;
        if(Mostra2_Vacia()){
            Imostra2 = nodoNuevo;
            Fmostra2 = nodoNuevo;
        }else{
            Fmostra2.sig = nodoNuevo;
            Fmostra2 = nodoNuevo;
           JOptionPane.showMessageDialog(null,"Espere en la fila, por favor.");
        }
        } 
    }//fin de metodo
     
    public boolean Mostra2_Vacia(){
        if(Imostra2 == null) {
            return true;
        }else{
            return false;
        }
    }//fin de metodo
    
    
    //-- Metodos para Mostrador #3 --
    public int Mostra3(){
        Fmostra3 = null;
        Imostra3 = null;
        return 0;
    }//fin de metodo
    
    public void Mostra3_Agrega(int inf){
        if (Mostra3_Vacia()) {
        NodoPrincipal nodoNuevo = new NodoPrincipal();
        nodoNuevo.info = inf;
        nodoNuevo.sig = null;
        if(Mostra3_Vacia()){
            Imostra3 = nodoNuevo;
            Fmostra3 = nodoNuevo;
        }else{
           JOptionPane.showMessageDialog(null,"Espere en la fila, por favor.");
        }
        } 
    }//fin de metodo
      
    public boolean Mostra3_Vacia(){
        if(Imostra3 == null) {
            return true;
        }else{
            return false;
        }
    }//fin de metodo
    
    int conta1=0,conta2=0, conta3=0;
    public void verifica(){
         int aux = Extrae();
         if(Mostra1_Vacia()){
             Mostra1_Agrega(aux);
         }else{
             if(Mostra2_Vacia()){
                 Mostra2_Agrega(aux); 
             }else{
                 if(Mostra3_Vacia()){
                 Mostra3_Agrega(aux);
             }
          }
        }
    }//fin de metodo
    
    //-- Metodos para ColaPrincipal --
    public boolean ColaV(){
        if(colaInicial == null){
            return true;
        }else{
            return false;
        }
    }//fin de metodo
    
     public void Agrega(int info){
        NodoPrincipal nodoNuevo = new NodoPrincipal();
        nodoNuevo.info = info;
        nodoNuevo.sig = null;
        if(ColaV()){
            colaInicial = nodoNuevo;
            colaFinal = nodoNuevo;
        }else{
            colaFinal.sig = nodoNuevo;
            colaFinal = nodoNuevo;
        }
    }//fin de metodo
     
    public int Extrae(){
      if(!ColaV()){
        int informacion = colaInicial.info; 
          if(colaInicial == colaFinal){
            colaInicial = null;
            colaFinal = null;
            }else{
                colaInicial=colaInicial.sig;
            }
            return informacion;
       }else
       return Integer.MAX_VALUE;  
    }//fin de metodo
 
    public void Muestra(){
        NodoPrincipal ruta = colaInicial;
        String colaAlReves = "";
        while(ruta != null){
            Cola += ruta.info + " ";
            ruta = ruta.sig;
        }
        String cadena [] = Cola.split(" ");
        
        for(int i = cadena.length-1; i >= 0; i--){
            colaAlReves += " " + cadena[i];                    
        }
        JOptionPane.showMessageDialog(null, colaAlReves);
        Cola = "";
    }//fin de metodo 
}//fin de clase