/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clase6;

/**
 *
 * @author Luis
 */
public class NodoCircular {

    public int dato;
    public NodoCircular siguiente;
    
    //Al yo colocarle NodoCirucular siguiente automaticamente cuando cree un nuevo
    //nodo, este nuevo va a apuntar al siguiente

    public NodoCircular(int dato, NodoCircular siguiente) {
        this.dato = dato;
        this.siguiente = siguiente;
    }
    public NodoCircular(int dato) {
        this.dato = dato;
        
    }
}
