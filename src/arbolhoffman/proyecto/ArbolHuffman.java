/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arbolhoffman.proyecto;

import java.util.HashMap;
import java.util.PriorityQueue;

/**
 *
 * @author Luigi
 */
public class ArbolHuffman {
    private Nodo raiz;

    public ArbolHuffman(Nodo raiz) {
        this.raiz = raiz;
    }
    public ArbolHuffman() {
        this.raiz = null;
    }

    public Nodo getRaiz() {
        return raiz;
    }

    public void setRaiz(Nodo raiz) {
        this.raiz = raiz;
    }
    public void calcularArbol (HashMap<String,Integer> mapa){
        PriorityQueue<Nodo> cola = new PriorityQueue<>((Nodo o1, Nodo o2)->o1.getPeso()-o2.getPeso());
        for(String keys : mapa.keySet()){
            cola.offer(new Nodo(keys,mapa.get(keys)));
        }
        while(cola.size()!=1){
            Nodo a = cola.poll();
            Nodo b = cola.poll();
            Nodo c = new Nodo(a.getContenido()+b.getContenido(),a.getPeso()+b.getPeso());
            c.setIzquierda(a);
            c.setDerecha(b);
            cola.offer(c);
        }
        this.raiz=cola.poll();
    }
    public HashMap<String,String> calcularCodigos(){
        HashMap<String,String> mapa = new HashMap<>();
        Nodo nodo=raiz;
        String binario="";
        while(nodo.getDerecha()!=null){
            
            if(nodo.getIzquierda().esHoja()){                
                //mapa.put((String)nodo.getIzquierda().getContenido(),binario+nodo.getIzquierda().getBinario());
            }          
            nodo = nodo.getDerecha();
            //binario+=nodo.getBinario;
            if(nodo.esHoja()){
                mapa.put((String)nodo.getContenido(),binario);
            }
        }
        return mapa;
    }
}
