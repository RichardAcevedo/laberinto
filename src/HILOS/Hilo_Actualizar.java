
package HILOS;

import GUI.Form_Matriz;

public class Hilo_Actualizar extends Thread{
    
    private Form_Matriz myFM;
    
    public Hilo_Actualizar(Form_Matriz myFM){
        this.myFM=myFM;
    }
    
    @Override
    public void run(){
        while(true){
            this.myFM.actualizarM();
            try{
                Thread.sleep(50);
            }catch(Exception e){}
        }
    }
    
}
