/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clase9;

/**
 *
 * @author Luis
 */
public class Pila {

    Nodo cima;
    int n;//tamaño de la pila

    public Pila() {
        this.cima = null;
        this.n = 0;
    }

    public boolean IsEmpty() {
        return cima == null;
    }

    //Agregar al inicio
    public void push(int num) {
        Nodo nuevo = new Nodo(num);
        
        Nodo temp = cima;
        cima = nuevo;
        nuevo.pNext = temp;
        
        n++;
    }

    //Eliminar al inicio
    public int pop() {
        if (!IsEmpty()) {
            Nodo temp = cima;
            cima = temp.pNext;

            n--;
            return temp.dato;

        } else {
            System.out.println("Pila vacia");
        }
        return 0;
    }

    public void mostrarpila() {
        if (!IsEmpty()) {
            Nodo aux = cima;
            while (aux != null) {
                System.out.println(aux.dato);
                aux = aux.pNext;
            }
        } else {
            System.out.println("Pila vacia");
        }

    }
    
    public void mostrarrecursiva(Pila p) {
        int elemento;
        if (!IsEmpty()) {
            elemento = cima.dato;
            p.pop();
            System.out.println(elemento);
            p.mostrarrecursiva(p);
            p.push(elemento);
        }
    }

    
    public void copiarrecursiva(Pila origen, Pila copia) {
        int elemento;
        if (!IsEmpty()) {
            elemento = cima.dato;
            origen.pop();
            copiarrecursiva(origen,copia);
            origen.push(elemento);
            copia.push(elemento);
            
        }
    }

    public void copiarinvertidarecursiva(Pila origen, Pila copia) {
        int elemento;
        if (!IsEmpty()) {
            elemento = cima.dato;
            origen.pop();
            copia.push(elemento);
            copiarinvertidarecursiva(origen,copia);
            origen.push(elemento);
            
            
        }
    }

    public void sumergirrecursiva(Pila p, int x) {
        int elemento;
        if (!IsEmpty()) {
            elemento = cima.dato;
            p.pop();
            sumergirrecursiva(p, x);
            p.push(elemento);
        } else {
            p.push(x);
        }
    }
    
    

    //Funcion para voltear una pila
    public void voltear(Pila original) {
        Pila copia = new Pila();
        Nodo aux = original.cima;
        while (aux != null) {
            copia.push(aux.dato);
            aux = aux.pNext;
        }
        copia.mostrarpila();

    }

    //Funcion para copiar una pila //Pila b = mipila.copiar();
    public Pila copiar() {
        Pila auxiliar = new Pila();
        Pila copia = new Pila();

        // Paso 1: Pasar los elementos a una pila auxiliar para invertir el orden
        while (!this.IsEmpty()) {
            auxiliar.push(this.pop());

        }

        // Paso 2: Restaurar la pila original y copiarla a la nueva
        while (!auxiliar.IsEmpty()) {
            int dato = auxiliar.pop();
            push(dato);
            copia.push(dato);
        }
        return copia;
    }

    //Funcion para copiar una pila invertida
    public Pila copiarinvertida() {
        Pila invertida = new Pila();
        Nodo actual = cima;

        // Simplemente vamos apilando los elementos en la nueva pila
        while (actual != null) {
            invertida.push(actual.dato);
            actual = actual.pNext;
        }

        return invertida;
    }

    //Funcion para agregar un elemento al final de la pila
    public void agregarfinal(int num) { //3--2--1--null
        Nodo nuevo = new Nodo(num, null);
        Nodo aux = cima;
        if (!IsEmpty()) {
            while (aux != null) {
                if (aux.pNext == null) {
                    aux.pNext = nuevo;
                    nuevo.pNext = null;
                }
                aux = aux.pNext;
            }
        } else {
            cima=nuevo;
        }

    }
    //De forma recursivo
    /*
     public void agregarfinal(int num,Pila p)
    p.pop() //ida
    agregarfinal(int num,Pila p)
    p.push() //vuelta
    
    */
    

}
