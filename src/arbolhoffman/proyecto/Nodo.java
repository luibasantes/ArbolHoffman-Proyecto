/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arbolhoffman.proyecto;

/**
 *
 * @author Luigi
 */
public class Nodo {
    private Nodo izquierda,derecha;
    private String contenido;
    private int Peso;

    public Nodo(String contenido,int peso) {
        this.izquierda = null;
        this.derecha = null;
        this.contenido = contenido;
        this.Peso = peso;
    }

    public Nodo getIzquierda() {
        return izquierda;
    }

    public void setIzquierda(Nodo izquierda) {
        this.izquierda = izquierda;
    }

    public Nodo getDerecha() {
        return derecha;
    }

    public void setDerecha(Nodo derecha) {
        this.derecha = derecha;
    }

    public String getContenido() {
        return contenido;
    }

    public void setContenido(String contenido) {
        this.contenido = contenido;
    }

    public int getPeso() {
        return Peso;
    }

    public void setPeso(int Peso) {
        this.Peso = Peso;
    }
    public boolean esHoja(){
        return this.izquierda==null && this.derecha==null;
    }
    
}
