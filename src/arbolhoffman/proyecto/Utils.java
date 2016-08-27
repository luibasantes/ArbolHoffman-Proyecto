/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arbolhoffman.proyecto;

import java.io.File;
import java.util.Scanner;

/**
 *
 * @author Luigi
 */
public class Utils {
    public static String leerTexto (String archivo){
        String texto="";
        try
        {
            File file = new File(archivo);
            Scanner input = new Scanner(file);
            while (input.hasNext())
            {
                String line = input.nextLine();
                texto+=line;
            }
            input.close();
        }
        catch(Exception e)
        {
            return texto;
        }
        return texto;
    }
}
