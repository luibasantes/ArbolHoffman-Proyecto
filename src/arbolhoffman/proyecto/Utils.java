/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arbolhoffman.proyecto;

import java.io.File;
import java.io.PrintWriter;
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
            File file = new File(archivo+".txt");
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
        
        return hexa.toUpperCase();
    }
    public static String hexadecimalBinario (String hexa){
        String binario="";
        int count=0;
        for(String i : hexa.split("")){
            String s="";
            if(!i.equals("-")){
                s=Integer.toBinaryString(Integer.parseInt(i,16));
                if(s.length()==1){
                    binario+="000"+s;
                }else if(s.length()==2){
                    binario+="00"+s;
                }else if(s.length()==3){
                    binario+="0"+s;
                }else{
                    binario+=s;
                }
                
            }else{
                count++;
            }
        }
        return binario.substring(0,binario.length()-count);
    }
    public static void guardarTexto (String archivo, String texto, HashMap<String,String> mapa){
        try
        {
            PrintWriter file=new PrintWriter(archivo+".txt");
            file.println(texto);
            file.close();
            PrintWriter file1=new PrintWriter(archivo+"_compres.txt");
            String s="";
            for(String keys : mapa.keySet()){
                s+=keys+":"+mapa.get(keys)+"|";
            }
            file1.println(s.substring(0,s.length()-1));
            file1.close();
        }
        catch(Exception e)
        {
            System.out.println("Algo salio mal.(No se Guardo)");
        }
    }
    public static HashMap<String,String> leerMapa (String archivo){
        HashMap<String,String> mapa = new HashMap<>();
        try{
            File file = new File(archivo);
            Scanner input = new Scanner(file);
            while (input.hasNext())
            {
                String line = input.nextLine();
                String[]a = line.split("|");
                for(String i: a ){
                    String []b=i.split(":");
                    mapa.put(b[0],b[1]);
                }
            }
            input.close();
        }catch(Exception e){
            System.out.println("Algo fallo al cargar.");
        }
        
        return mapa;
    }
}
