/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arbolhoffman.proyecto;

import java.util.Scanner;

/**
 *
 * @author Luigi
 */
public class ArbolHoffmanProyecto {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        boolean bandera = true; 
        Scanner sc = new Scanner(System.in);
        String opcion;
        while (bandera){
            System.out.print("1)Comprimir\n2)Descomprimir\n3)Salir\n☻♣:");
            opcion=sc.nextLine();
            if (opcion.equals("1")){
                 System.out.println(Utils.calcularFrecuencias(Utils.leerTexto("archivo.txt")));
                 System.out.println(Utils.binarioHexadecimal("001001001001001001110110110110110110110110000000000000"
                         + "0001011011011011011011011001001001001001001111111111111111111111110101010101010101010101"));
            }else if(opcion.equals("2")){
                 
            }else if (opcion.equals("3")){
                 bandera = false;
            }
         }
    }
    
}
