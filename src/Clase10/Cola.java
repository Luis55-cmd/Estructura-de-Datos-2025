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
            for (int i = 0; i < size; i++) {
                Nodo actual = front;
                Desencolar();
                System.out.println(actual.dato);
                Encolar(actual.dato);
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

    public void Promedio(Cola cola) {
        if (!IsEmpty()) {
            int suma = 0;
            for (int i = 0; i < size; i++) {
                Nodo actual = front;

                
                Nodo sum = Desencolar2();
                suma += (Integer) sum.dato;
                //Suma todos los números del conjunto.
                //Divide el resultado entre el número de valores del conjunto
                Encolar(actual.dato);
            }
            suma = suma / cola.size;
            System.out.println("El promedio de los elementos: " + suma);
        } else {
            System.out.println("Pila vacia");
        }

    }

}
