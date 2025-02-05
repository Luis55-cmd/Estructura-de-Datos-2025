/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clase9;

/**
 *
 * @author Luis
 */
public class Nodo {

    Nodo pNext;
    int dato;

    public Nodo(int dato, Nodo pNext) {
        this.dato = dato;
        this.pNext = pNext;
    }

    public Nodo(int dato) {
        this.dato = dato;
        this.pNext = null;
    }

}
