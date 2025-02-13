/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clase10;

/**
 *
 * @author Luis
 */
public class Nodo {

    Nodo pNext;
    Object dato;

    public Nodo(Object dato, Nodo pNext) {
        this.dato = dato;
        this.pNext = pNext;
    }

    public Nodo(Object dato) {
        this.dato = dato;
        this.pNext = null;
    }
}
