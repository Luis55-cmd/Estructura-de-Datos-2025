/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clase10;

/**
 *
 * @author Luis
 */
public class Cola {

    //Atributos de la Cola
    Nodo front;
    Nodo back;
    int size;//tamaño de la pila

    //Constructor de la Cola
    public Cola() {
        this.front = null;
        this.back = null;
        this.size = 0;
    }

    //La cola esta vacia?
    public boolean IsEmpty() {
        return front == null;
    }

    //Vaciar cola
    public void Vaciar() {
        front = null;
        back = null;
        size = 0;
    }

    //Agrega al final de la cola
    public void Encolar(Object dato) {
        Nodo nuevo = new Nodo(dato);

        if (!IsEmpty()) {
            back.pNext = nuevo;
            back = nuevo;
        } else {
            front = back = nuevo;
        }
        size++;
    }

    //Eliminar al inicio de la cola
    public void Desencolar() {
        if (!IsEmpty()) {
            front = front.pNext;
            size--;

        }
    }

    //Eliminar al inicio de la cola y retornar un nodo
    public Nodo Desencolar2() {
        if (!IsEmpty()) {
            Nodo aux = front;
            front = front.pNext;
            size--;
            return aux;
        }
        return null;
    }

    //Muestra la cola de inicio a fin
    public void MostrarCola() {
        if (!IsEmpty()) {
            Nodo aux = front;
            while (aux != null) {
                System.out.println(aux.dato);
                aux = aux.pNext;
            }
        } else {
            System.out.println("Pila vacia");
        }
    }

    public void OrdenarRecursivo(Cola cola) {
        if (!cola.IsEmpty()) {
            int size = cola.size;
            Nodo max = cola.front;
            Nodo aux;

            int count = 0;
            while (count < size) {
                aux = cola.Desencolar2();

                aux.pNext = null;
                if ((Integer) aux.dato > (Integer) max.dato) {
                    cola.Encolar(max.dato);
                    max = aux;

                } else if ((Integer) aux.dato < (Integer) max.dato) {
                    cola.Encolar(aux.dato);
                } else {
                    max = aux;
                }
                count++;
            }
            OrdenarRecursivo(cola);
            cola.Encolar(max.dato);
        }

    }

    //Recursivo
    public void InvertirCola(Cola cola) {
        int elem;
        if (!cola.IsEmpty()) {
            elem = (Integer) cola.front.dato;
            cola.Desencolar();
            InvertirCola(cola);
            cola.Encolar(elem);
        }

    }

    //Recursivo
    public void CopiarCola(Cola origen, Cola copia) {
        int elem;
        if (!origen.IsEmpty()) {
            elem = (Integer) origen.front.dato;
            origen.Desencolar();
            copia.Encolar(elem);
            CopiarCola(origen, copia);
            origen.Encolar(elem);
        }

    }

    public void CopiarColaIterativa(Cola origen, Cola copia) {
        int elem, n;
        n = origen.size;
        for (int i = 1; i <= n; i++) {
            elem = (Integer) origen.front.dato;
            origen.Desencolar();
            copia.Encolar(elem);
            origen.Encolar(elem);

        }
    }

    public void Colear(Cola cola, int info) {
        int elem, n;
        n = cola.size;
        cola.Encolar(info);
        for (int i = 1; i <= n; i++) {
            elem = (Integer) cola.front.dato;
            cola.Desencolar();
            cola.Encolar(elem);

        }

    }

    //Recursivo
    public void Colear2(Cola cola, int info, int n) {
        //n es el tamaño de la cola
        int elem;

        if (n > 0) {
            elem = (Integer) cola.front.dato;

            if (n == cola.size) {
                cola.Encolar(info);
            }
            cola.Desencolar();
            cola.Encolar(elem);
            Colear2(cola, info, n - 1);

        }

    }

    //Recursivo
    public void ColearIntercalado(Cola cola, int info, int n) {
        int elem;

        if (n > 0) {
            elem = (Integer) cola.front.dato;
            cola.Desencolar();
            cola.Encolar(info);

            cola.Encolar(elem);
            ColearIntercalado(cola, info, n - 1);

        }

    }

    //Ordenar una cola crecientemente, menor a mayor
    public void OrdenarCreciente() {
        //Cola vacia o Cola con un solo elemento
        if (front == null || front.pNext == null) {
            return; // No hay nada que ordenar
        }
        boolean intercambio;
        do {
            intercambio = false;
            Nodo aux = front;
            while (aux.pNext != null) { //Recorro la Cola
                if ((Integer) aux.dato > (Integer) aux.pNext.dato) {
                    // Intercambiar los valores de los nodos
                    Object temp = aux.dato;     //Guardo el valor del nodo
                    aux.dato = aux.pNext.dato;  //Intercambio el valor del nodo por el siguiente nodo
                    aux.pNext.dato = temp;      //Intercambio el valor del siguiente nodo por el valor del que guarde
                    intercambio = true;         //Y coloco que el intercambio se realizo
                }
                aux = aux.pNext;                //Paso al siguiente nodo
            }
        } while (intercambio);
    }

    //Eliminar elementos duplicados
    public void EliminarDuplicados() {
        //Cola vacia o Cola con un solo elemento
        if (front == null || front.pNext == null) {
            return;
        }
        Nodo actual = front; // Creo un nodo en el inicio de la cola
        while (actual != null) { //Recorro la Cola
            Nodo previo = actual;           //Creo dos nodos
            Nodo siguiente = actual.pNext;
            // Comparar el nodo actual con los siguientes
            while (siguiente != null) {
                if (actual.dato == siguiente.dato) {    //Si son iguales los elementos
                    // Eliminar el nodo repetido
                    previo.pNext = siguiente.pNext;
                } else {                                //Si no son iguales los elementos
                    previo = siguiente; // Avanzar al siguiente nodo
                }
                siguiente = siguiente.pNext;
            }
            actual = actual.pNext; // Avanzar al siguiente nodo principal
        }

    }

    //Funcion buscar un elemento sin conocer el tamaño
    public void BuscarElemento(Cola cola, int dato) {
        cola.InvertirCola(cola);
        if (Existe(cola, dato)) {
            System.out.println("El elemento: " + dato + " si esta dentro de la cola");
        } else {
            System.out.println("El elemento: " + dato + " no esta dentro de la cola");
        }

    }

    //Funcion ver si existe el elemento recursivo
    public boolean Existe(Cola cola, int dato) {
        int elem;
        boolean result;
        if (!cola.IsEmpty()) {
            elem = (Integer) cola.front.dato;
            cola.Desencolar();
            if (elem == dato) {
                result = true;
                cola.InvertirCola(cola);
            } else {
                result = Existe(cola, dato);
            }
            cola.Encolar(elem);

        } else {
            result = false;

        }
        return result;
    }

    
}
