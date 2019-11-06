
package HILOS;

import GUI.Form_Matriz;

public class Hilo_Buscar extends Thread{
    
     private Form_Matriz myFM;
     
     public Hilo_Buscar(Form_Matriz myFM){
         this.myFM=myFM;
     }
     
     @Override
     public void run(){
         this.myFM.buscarCamino();
     }
}
