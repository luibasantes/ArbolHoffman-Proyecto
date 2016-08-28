/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arbolhoffman.proyecto;

import java.io.File;
import java.util.HashMap;
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
    public static HashMap<String,Integer> calcularFrecuencias (String texto){
        HashMap<String,Integer> frecuencias = new HashMap<>();
        for (String i : texto.split("")){
            if(frecuencias.containsKey(i)){
                frecuencias.put(i, frecuencias.get(i)+1);
            }else{
                frecuencias.put(i, 1);
            }
        }     
        return frecuencias;
    }
    public static String binarioHexadecimal (String binario){
        String hexa="";
        for(int i=0 ; i+1<=binario.length();i+=4){
            if(i+4<=binario.length()){
                hexa+=Integer.toHexString(Integer.parseInt(binario.substring(i, i+4),2));
            }else if(i+3==binario.length()){
                hexa+=Integer.toHexString(Integer.parseInt(binario.substring(i, i+3)+"0",2));
                hexa+="-";
            }else if(i+2==binario.length()){
                hexa+=Integer.toHexString(Integer.parseInt(binario.substring(i, i+2)+"00",2));
                hexa+="--";
            }else{
                hexa+=Integer.toHexString(Integer.parseInt(binario.substring(i, i)+"000",2));
                hexa+="---";
            }
        }
        
        return hexa;
    }
}
