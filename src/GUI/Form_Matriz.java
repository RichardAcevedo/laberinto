
package GUI;

import HILOS.Hilo_Actualizar;
import HILOS.Hilo_Buscar;
import java.awt.Color;
import javax.swing.JLabel;

public class Form_Matriz extends javax.swing.JFrame {

    private Laberinto myLab;
    private JLabel[][] myMatriz;
    private short tamCuadro;
    private Color muro;
    private Color caminoSin; //SIN RECCORRER
    private Color caminoRec; //RECORRIDO
    private Color teseo;
    private Color minoVivo;
    private Color minoMuerto;
    private Color salida;
    
    
    public Form_Matriz() {
        initComponents();
        this.tamCuadro = 25;
        this.muro = new Color(130,80,50);
        this.caminoSin = new Color(200,160,130);
        this.caminoRec = new Color(130,200,130);
        this.teseo = new Color(130,190,200);
        this.minoVivo = new Color(200,70,70);
        this.minoMuerto = new Color(200,70,170);
        this.salida = new Color(230,230,60);
        //this.myLab=new Laberinto("https://raw.githubusercontent.com/josesuarez9304/archivo-x/master/matrizEj.txt");
        this.myLab=new Laberinto("https://gitlab.com/madarme/archivos-persistencia/raw/master/laberinto/matrizLaberintoTeseo.txt");
        this.pintarMatriz(this.myLab.getLaberinto());
        this.lanzarHilos();
    }
    
    public void buscarCamino(){
        //int filaTeseo, int colTeseo,int filaMinTauro, int colMinTauro, int filaSalida, int colSalida 
        //caso jose 19,3,7,6,0,7
        //caso marco 8,1,4,0,1,4
        System.err.println("CAMINO TOTAL: "+this.myLab.getCamino(8,1,4,0,1,4));
    }
    
    public void actualizarM(){
        short[][] temp=this.myLab.getLaberinto();
        for(int i=0;i<temp.length;i++){
            for(int j=0;j<temp[0].length;j++){
                this.pintarCuadro(temp[i][j], i, j);
            }
        }
        this.repaint();
    }
    
     private void lanzarHilos(){
        Hilo_Actualizar myHA=new Hilo_Actualizar(this);
        myHA.start();
        Hilo_Buscar myHB=new Hilo_Buscar(this);
        myHB.start();
    }
    
    private void pintarMatriz(short[][] datos){
        this.myMatriz=new JLabel[datos.length][datos[0].length];
        for(int i=0;i<datos.length;i++){
            for(int j=0;j<datos[0].length;j++){
                this.myMatriz[i][j]=new JLabel();
                this.myMatriz[i][j].setOpaque(true);
                this.myMatriz[i][j].setBounds(j*this.tamCuadro, i*this.tamCuadro, this.tamCuadro, this.tamCuadro);
                this.pintarCuadro(datos[i][j], i, j);
                this.add(this.myMatriz[i][j]); //AÑADE EL LABEL AL FRAME
            }
        }
        this.repaint();
    }
    
    private void pintarCuadro(short x, int i, int j){
        switch(x){
            case -1:
                this.myMatriz[i][j].setBackground(this.muro);
                break;
            case 1:
                this.myMatriz[i][j].setBackground(this.caminoRec);
                break;
            case 0:
                this.myMatriz[i][j].setBackground(this.caminoSin);
                break;
            case 9:
                this.myMatriz[i][j].setBackground(this.teseo);
                break;
            case 100:
                this.myMatriz[i][j].setBackground(this.minoVivo);
                break;
            case -100:
                this.myMatriz[i][j].setBackground(this.minoMuerto);
                break;
            case 1000:
                this.myMatriz[i][j].setBackground(this.salida);
        }
    }
  
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 547, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Form_Matriz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Form_Matriz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Form_Matriz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Form_Matriz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Form_Matriz().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
