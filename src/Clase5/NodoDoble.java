/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clase5;

/**
 *
 * @author Luis
 */
public class NodoDoble<T> {

    //Atributos del nodo doble
    public T dato;
    public NodoDoble siguiente;
    public NodoDoble anterior;

    //Constructor para el primer nodo
    public NodoDoble(T dato) {
        this.dato = dato;
        this.siguiente = null;
        this.anterior = null;
    }

    //Constructor para cuando ya hay nodo
    public NodoDoble(T dato, NodoDoble siguiente, NodoDoble anterior) {
        this.dato = dato;
        this.siguiente = siguiente;
        this.anterior = anterior;

    }

}
