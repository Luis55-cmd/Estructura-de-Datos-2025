/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clase3;

/**
 *
 * @author Luis
 */
public class Lista {
    Nodo inicio,fin; //Punteros inicio y final
    public Lista(){
        inicio=null;
        fin=null;
    }
    //Funcion agregar un nodo al inicio
    public void agregar_al_inicio(int elemento){
        //creando al nodo
        inicio=new Nodo(elemento, inicio);
        if(fin==null){
            fin=inicio;
        
        }
    }

    //Funcion mostrar lista
    public void mostrar_lista(){
        Nodo recorrer= inicio;
        System.out.println();
        while(recorrer!=null){
            System.out.print("["+recorrer.dato+"]---->");
            recorrer=recorrer.next;
            }
        }
}
