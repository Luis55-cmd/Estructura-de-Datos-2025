/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clase3;

/**
 *
 * @author Luis
 */
public class Lista<T> {

    //Atributos
    public Nodo pFirst, pLast; //Punteros inicio y final
    public int size; //Tamaño de la lista

    //Constructor lista
    public Lista() {
        this.pFirst = null;
        this.pLast = null;
        this.size = 0;
    }

    //Funcion para saber si la lista esta vacia
    public boolean IsEmpty() {
        return pFirst == null;

    }

    //Funcion vaciar lista
    public void Vaciar() {
        this.pFirst = null;
        this.size = 0;
    }

    //Funcion agregar al final
    public void AgregarAlFinal(T dato) {
        Nodo nuevo = new Nodo(dato);
        if (!IsEmpty()) {
            
            this.pLast.pNext = nuevo; //primero cambio el apuntador
            this.pLast = nuevo; //luego el pLast/Nodo
        } else {
            
            this.pFirst = this.pLast = nuevo;

        }
        
        this.size++;

    }

    //Funcion agregar un nodo al inicio
    public void AgregarAlInicio(T dato) {
        Nodo nuevo = new Nodo(dato);
        if (!IsEmpty()) {
            nuevo.pNext = this.pFirst;
            this.pFirst = nuevo;
        } else {
            this.pFirst = this.pLast = nuevo;
        }
        this.size++;
    }

    //Funcion eliminar un nodo al inicio
    public void EliminarAlInicio() {
        if (!IsEmpty()) {
            System.out.println("Se ha eliminado el " + pFirst.dato);
            pFirst=pFirst.pNext;
            size--;
        }

    }

    //Funcion eliminar un nodo al final
    public void EliminarAlFinal() {
        if (!IsEmpty()) {
            System.out.println("Se ha eliminado el " + pLast.dato);
            if (this.pFirst == this.pLast) {
                Vaciar();
            } else {
                Nodo aux = this.pFirst;
                while (aux.pNext != this.pLast) {
                    aux = aux.pNext;

                }

                aux.pNext = null;
                this.pLast = aux;
                this.size--;
            }
        }

    }

    //Funcion eliminar un elemento especifico
    public void EliminarEspecifico(T elemento) {
        if (pFirst == null) {
            System.out.println("La lista está vacía, no se puede eliminar el valor.");
            return;
        }

        // Si el valor a eliminar está en el primer nodo
        if (pFirst.dato == elemento) {
            pFirst = pFirst.pNext; // Mover el puntero `head` al siguiente nodo
            return;
        }

        // Recorrer la lista buscando el nodo con el valor a eliminar
        Nodo current = pFirst;
        while (current.pNext != null && current.pNext.dato != elemento) {
            current = current.pNext;
        }

        // Si se encontró el valor, eliminar el nodo
        if (current.pNext != null) {
            current.pNext = current.pNext.pNext; // Saltar el nodo que contiene el valor
        } else {
            System.out.println("El valor " + elemento + " no se encontró en la lista.");
        }
        this.size--;

    }

    //Funcion buscar un elemento de un nodo
    public boolean Buscar(T elemento) {
        Nodo temp = pFirst; // Comienza desde el primer nodo
        while (temp != null) {  //Para recorrer la lista
            if (temp.dato == elemento) {
                return true; // Si encuentra el valor, devuelve true
            }
            temp = temp.pNext; // Si no, avanza al siguiente nodo
        }
        return false; // Si llega al final y no lo encuentra, devuelve false

    }

    //Funcion mostrar lista
    public void MostrarLista() {
        
        Nodo recorrer = pFirst;
        System.out.print("Tamaño de la lista: " + this.size);
        System.out.println();
        if (!IsEmpty()) {
            
            /*for(int i=0;i<size;i++){
                sout(dato);
                aux=aux.pNext;
            }
            
            */
            while (recorrer != null) {

                System.out.print("[" + recorrer.dato + "]---->");

                recorrer = recorrer.pNext;

            }
            System.out.println("null");

        } else {
            System.out.println("[]");
        }

    }

    //Funcion intercala el numero 666 entre cada nodo
    public void Intercalar666() {
        Nodo recorrer = pFirst;
        System.out.println();
        if (!IsEmpty()) {
            while (recorrer != null) {

                System.out.print("[" + recorrer.dato + "]---->");
                System.out.print("[" + 666 + "]---->");

                recorrer = recorrer.pNext;

            }
            System.out.println("null");

        } else {
            System.out.println("[]");
        }

    }

}
