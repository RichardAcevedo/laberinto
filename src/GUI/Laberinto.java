
package GUI;

public class Laberinto {
    
    private short[][]laberinto;
    private long time;

    
    public Laberinto(String URL){
        this.time=80;
        this.laberinto=Cargador.getLaberinto(URL);
    }

    protected short[][] getLaberinto() {
        return laberinto;
    }
    
    public String getCamino(int filaTeseo, int colTeseo,int filaMinTauro, int colMinTauro, int filaSalida, int colSalida){
        String caminoM = this.encontrarObj(true, filaTeseo, colTeseo, filaTeseo, colTeseo, filaMinTauro, colMinTauro);
        System.out.println("TESEO-MINOTAURO: "+caminoM);
        if(caminoM==null){
            return null;
        }
        String caminoS=this.encontrarObj(false, filaMinTauro, colMinTauro, filaMinTauro, colMinTauro, filaSalida, colSalida);
        System.out.println("MINOTAURO-SALIDA: "+caminoS);
        if(caminoS==null){
            return null;
        }
        return caminoM+" "+caminoS;
    }
    
    private String encontrarObj(boolean tipo, int FI, int CI, int filaTeseo, int colTeseo,int filaObj, int colObj){
        this.dormir();
        if((filaTeseo==filaObj)&&(colTeseo==colObj)){
            if(tipo){
                this.laberinto[filaObj][colObj]=-100;
            }else{
                this.laberinto[filaObj][colObj]=1000;
            }
            return "["+filaTeseo+";"+colTeseo+"]";
        }
        if(this.validarU(filaTeseo, colTeseo)){
            if(!tipo && filaTeseo==FI && colTeseo==CI){
                this.laberinto[filaTeseo][colTeseo]=-100;
            }else{
                this.laberinto[filaTeseo][colTeseo]=1;
            }
            this.laberinto[filaTeseo][colTeseo+1]=9;
            String txt=this.encontrarObj(tipo, FI, CI, filaTeseo, colTeseo+1, filaObj, colObj);
            if(txt!=null){
                return "["+filaTeseo+";"+colTeseo+"]"+" "+txt;
            }else{
                this.laberinto[filaTeseo][colTeseo]=9;
                this.laberinto[filaTeseo][colTeseo+1]=0;   
            }
        }
        if(this.validarL(filaTeseo, colTeseo)){
            if(!tipo && filaTeseo==FI && colTeseo==CI){
                this.laberinto[filaTeseo][colTeseo]=-100;
            }else{
                this.laberinto[filaTeseo][colTeseo]=1;
            }
            this.laberinto[filaTeseo][colTeseo-1]=9;
            String txt=this.encontrarObj(tipo, FI, CI, filaTeseo, colTeseo-1, filaObj, colObj);
            if(txt!=null){
                return "["+filaTeseo+";"+colTeseo+"]"+" "+txt;
            }else{
                this.laberinto[filaTeseo][colTeseo]=9;
                this.laberinto[filaTeseo][colTeseo-1]=0;
            }
        }
        if(this.validarD(filaTeseo, colTeseo)){
           if(!tipo && filaTeseo==FI && colTeseo==CI){
                this.laberinto[filaTeseo][colTeseo]=-100;
            }else{
                this.laberinto[filaTeseo][colTeseo]=1;
            }
            this.laberinto[filaTeseo+1][colTeseo]=9;
            String txt=this.encontrarObj(tipo, FI, CI, filaTeseo+1, colTeseo, filaObj, colObj);
            if(txt!=null){
                return "["+filaTeseo+";"+colTeseo+"]"+" "+txt;
            }else{
                this.laberinto[filaTeseo][colTeseo]=9;
                this.laberinto[filaTeseo+1][colTeseo]=0;
            }
        }
        if(this.validarR(filaTeseo, colTeseo)){
            if(!tipo && filaTeseo==FI && colTeseo==CI){
                this.laberinto[filaTeseo][colTeseo]=-100;
            }else{
                this.laberinto[filaTeseo][colTeseo]=1;
            }
            this.laberinto[filaTeseo-1][colTeseo]=9;
            String txt=this.encontrarObj(tipo, FI, CI, filaTeseo-1, colTeseo, filaObj, colObj);
            if(txt!=null){
                return "["+filaTeseo+";"+colTeseo+"]"+" "+txt;
            }else{
                this.laberinto[filaTeseo][colTeseo]=9;
                this.laberinto[filaTeseo-1][colTeseo]=0;
            }
        }
        this.dormir();
        return null;
    }
    
    private void dormir(){
        try{
            Thread.sleep(this.time);
        }catch (Exception e){}
    }
    
    private boolean validarR(int filaTeseo, int colTeseo){
        return((colTeseo+1<this.laberinto[0].length)&&((this.laberinto[filaTeseo][colTeseo+1]==0)||(this.laberinto[filaTeseo][colTeseo+1]==100)||(this.laberinto[filaTeseo][colTeseo+1]==1000)));
    }
    
    private boolean validarL(int filaTeseo, int colTeseo){
        return((colTeseo-1>=0)&&((this.laberinto[filaTeseo][colTeseo-1]==0)||(this.laberinto[filaTeseo][colTeseo-1]==100)||(this.laberinto[filaTeseo][colTeseo-1]==1000)));
    }
    
    private boolean validarD(int filaTeseo, int colTeseo){
        return((filaTeseo+1<this.laberinto.length)&&((this.laberinto[filaTeseo+1][colTeseo]==0)||(this.laberinto[filaTeseo+1][colTeseo]==100)||(this.laberinto[filaTeseo+1][colTeseo]==1000)));
    }
    
    private boolean validarU(int filaTeseo, int colTeseo){
        return((filaTeseo-1>=0)&&((this.laberinto[filaTeseo-1][colTeseo]==0)||(this.laberinto[filaTeseo-1][colTeseo]==100)||(this.laberinto[filaTeseo-1][colTeseo]==1000)));
    }
   

    
}
