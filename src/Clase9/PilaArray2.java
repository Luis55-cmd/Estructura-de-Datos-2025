/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clase9;

/**
 *
 * @author Luis
 */
public class PilaArray2 {

    //Atributos
    int array[];
    int cima;

    //Constructor
    public PilaArray2(int tamaño) {
        array = new int[tamaño];
        cima = -1;
    }

    //Metodo para agregar a la pila
    public void push(int dato) {
        cima++;
        array[cima] = dato;
    }

    //Metodo para eliminar
    public int pop() {
        int fuera = array[cima];
        cima--;
        return fuera;
    }

    //Metodo para saber si esta vacia
    public boolean IsEmpty() {
        return cima == -1;
    }

    //Metodo para agregar si esta full
    public boolean IsFull() {
        return array.length - 1 == cima;
    }
    //Metodo para saber cual esta en la cima
    public int cimaPila() {
        return array[cima];
    }
    //Metodo para saber el tamaño
    public int tamaño() {
        return array.length;
    }
    public void print(){
        
        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }
          
            
            
        
    }
    
    

}
