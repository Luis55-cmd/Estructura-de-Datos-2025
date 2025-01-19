/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clase3;

/**
 *
 * @author Luis
 */
public class Nodo <T>{
    public T dato; //Lo que contiene el nodo
    public Nodo <T> pNext; //Puntero al siguiente nodo
    
    //Constructor para insertar al inicio
    public Nodo(T dato, Nodo pNext) {
        this.dato = dato;
        this.pNext = pNext;
    }
    //Constructor para insertar al final
    public Nodo(T dato){
        this.dato = dato;
        this.pNext = null;
    }
}
