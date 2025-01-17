/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clase3;

/**
 *
 * @author Luis
 */
public class Nodo {
    public int dato;
    public Nodo next; //puntero
    
    //constructor

    public Nodo(int dato, Nodo next) {
        this.dato = dato;
        this.next = next;
    }
}
