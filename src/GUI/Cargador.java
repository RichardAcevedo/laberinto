
package GUI;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;


public class Cargador {
    
    public static short[][] getLaberinto(String URL){
        short[][] laberinto;
        laberinto =null;
        ArrayList<String> l = new ArrayList<String>();
        try {
            URL url = new URL(URL);
            BufferedReader in = null;
            try {
                in = new BufferedReader(new InputStreamReader(
                        url.openStream()));
            } catch (Throwable t) {
            }
            String inputLine;

            int alto = 0, datos = 0;
            String[] splited = null;
            while ((inputLine = in.readLine()) != null) {
                splited = inputLine.split(";");
                for (int i = 0; i < splited.length; i++) {
                    l.add(splited[i]);
                }
                alto++;
            }
            laberinto = new short[alto][splited.length];
            for (int i = 0; i < alto; i++) {
                for (int j = 0; j < splited.length; j++) {
                    laberinto[i][j] = Short.parseShort(l.get(datos));
                    datos++;
                }
            }
            //IMPRESION DEL LABERINTO
            //for (int i = 0; i < alto; i++) {
            //    for (int j = 0; j < splited.length; j++) {
            //        System.out.print(laberinto[i][j]+"  ");
            //    }
            //    System.out.println("");
            //}
            in.close();
        } catch (MalformedURLException ex1) {
            System.out.println("URL erronea: " + ex1.getMessage());
        } catch (IOException ex2) {
            System.out.println("Error IO:" + ex2.getMessage());
        }
        return laberinto;
    }
    
}
