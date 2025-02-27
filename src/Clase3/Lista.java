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
            pFirst = pFirst.pNext;
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

    // Método para agregar un número en orden
    public void agregarEnOrden(int numero) {
        Nodo nuevoNodo = new Nodo(numero);

        // Caso 1: La lista está vacía o el nuevo número es menor que el primer elemento
        if (pFirst == null || numero < (Integer) pFirst.dato) {
            nuevoNodo.pNext = pFirst;
            pFirst = nuevoNodo;
        } else {
            // Caso 2: Buscar el lugar correcto para insertar el nuevo nodo
            Nodo actual = pFirst;
            while (actual.pNext != null && (Integer) actual.pNext.dato < numero) {
                actual = actual.pNext;
            }
            // Insertar el nuevo nodo en su posición
            nuevoNodo.pNext = actual.pNext;
            actual.pNext = nuevoNodo;
        }
    }

    /*
    
    
//Cuantas veces aparece la sublista l2 en la lista l1
    //123123
    //12
    public void Contar(Lista l1, Lista l2) {
        Nodo inicio = l1.pFirst;
        Nodo a1 = inicio;
        Nodo a2 = l2.pFirst;
        int aparaciones = 0;
        while (a1 != null) {//para solo el primero llega null
            while (a1 != null && a1.data == a2.data) {//
                a1 = a1.pNext;
                a2 = a2.pNext;
                if (a2 == null) {
                    aparaciones++;
                    break;
                }
            }
            inicio = inicio.pNext;
            a1 = inicio;
            a2 = l2.pFirst;
        }
        System.out.println(aparaciones);
    }

    //Crea y Ordena una nueva lista a partir de 2 listas ordenadas

    public void Ordenar(Lista l1, Lista l2) {
        
        Nodo aux1 = l1.pFirst;
        Nodo aux2 = l2.pFirst;
        Lista resultado = new Lista();
        while (aux1 != null && aux2 != null) { //para el primero que llegue a null
            if (aux1.data > aux2.data) {
                resultado.Append(aux2.data);
                aux2 = aux2.pNext;
            } else {
                resultado.Append(aux1.data);
                aux1 = aux1.pNext;

            }

        }
        if (aux1 == null) {
            while (aux2 != null) {
                resultado.Append(aux2.data);
                aux2 = aux2.pNext;
            }

        } else if (aux2 == null) {
            while (aux1 != null) {
                resultado.Append(aux1.data);
                aux1 = aux1.pNext;
            }

        }

        resultado.Mostrar();

    }

    // Método para eliminar elementos repetidos
    public void eliminarRepetidos() {
        if (pFirst == null || pFirst.pNext == null) {
            return; // Si la lista está vacía o tiene un solo elemento, no hay nada que hacer
        }

        Nodo actual = pFirst;

        // Recorremos la lista nodo por nodo
        while (actual != null) {
            Nodo previo = actual;
            Nodo siguiente = actual.pNext;

            // Comparar el nodo actual con los siguientes
            while (siguiente != null) {
                if (actual.data == siguiente.data) {
                    // Eliminar el nodo repetido
                    previo.pNext = siguiente.pNext;
                } else {
                    previo = siguiente; // Avanzar al siguiente nodo
                }
                siguiente = siguiente.pNext;
            }
            actual = actual.pNext; // Avanzar al siguiente nodo principal
        }
    }

    // Método para ordenar 1 lista intercambiando los valores de los nodos viendo cual es menor o mayor
    public void Ordenar1Listainter() {
        if (pFirst == null || pFirst.pNext == null) {
            return; // No hay nada que ordenar
        }

        boolean intercambio;
        do {
            intercambio = false;
            Nodo aux = pFirst;
            while (aux.pNext != null) {
                if (aux.data > aux.pNext.data) {
                    // Intercambiar los valores de los nodos
                    int temp = aux.data;
                    aux.data = aux.pNext.data;
                    aux.pNext.data = temp;
                    intercambio = true;
                }
                aux = aux.pNext;
            }
        } while (intercambio);
    }

    // Método para ordenar 1 lista comparando el primer elemento con el resto modificando nodos
    public void Ordenar1Lista() {
        if (pFirst == null || pFirst.pNext == null) {
            return; // No hay nada que ordenar
        }

        Nodo actual = pFirst;

        // Recorrer la lista nodo por nodo
        while (actual != null) {
            Nodo menor = actual; // Inicialmente asumimos que el menor es el nodo actual
            Nodo siguiente = actual.pNext;

            // Comparar el nodo actual con el resto de los nodos
            while (siguiente != null) {
                if (siguiente.data < menor.data) {
                    menor = siguiente; // Actualizar el nodo con el menor valor encontrado
                }
                siguiente = siguiente.pNext;
            }

            // Intercambiar los valores si se encontró un menor
            if (menor != actual) {
                int temp = actual.data;
                actual.data = menor.data;
                menor.data = temp;
            }

            actual = actual.pNext; // Pasar al siguiente nodo
        }

    }
    // Método para ordenar 1 lista creando una nueva lista/ buscas el menor y lo agregas a la nueva lista

    public void Ordenar1ListayCrear() {
        Lista listaOrdenada = new Lista();

        // Mientras la lista original no esté vacía
        while (pFirst != null) {
            // Encontrar el nodo con el valor mínimo
            Nodo menor = pFirst;
            Nodo actual = pFirst;
            Nodo anteriorMenor = null;
            Nodo anterior = null;

            // Recorrer la lista para encontrar el menor valor
            while (actual.pNext != null) {
                if (actual.pNext.data < menor.data) {
                    menor = actual.pNext;
                    anteriorMenor = actual;
                }
                actual = actual.pNext;
            }

            // Eliminar el nodo menor de la lista original
            if (anteriorMenor != null) {
                anteriorMenor.pNext = menor.pNext; // Saltar el nodo menor
            } else {
                pFirst = pFirst.pNext; // El menor es la cabeza
            }

            menor.pNext = null; // Desconectar el nodo menor
            listaOrdenada.Append(menor.data); // Agregar el valor del nodo menor a la nueva lista
        }

        listaOrdenada.Mostrar();
    }


    //Funcion para encontrar un bucle en un lista
    public void EncontrarBucle(Lista listabucle) {
        
        
        
        Nodo aux1 = listabucle.pFirst;
        Nodo aux2 = listabucle.pFirst;
        
        
        do {
            
            aux1 = aux1.pNext;
            aux2 = aux2.pNext;
            if (aux2 != null) {
                aux2 = aux2.pNext;
            } else {
                System.out.println("No hay bucle dentro de la lista");
                break;
            }
            
        } while (aux1 != null && aux2 != null && aux1 != aux2);
        //aux1 4----2
        //aux2 4
        
        if (aux1 != null && aux2 != null && aux1 == aux2) {
            System.out.println("El  nodo donde se inicia el bucle es el nodo:");//2
            System.out.println(aux1.data);
        }
    }


    

    // Método para invertir la lista temporalmente y mostrarla en orden inverso
    public void mostrarReverso() {
        if (cabeza == null) {
            System.out.println("La lista está vacía.");
            return;
        }

        // Invertimos temporalmente la lista
        Nodo anterior = null;
        Nodo actual = cabeza;
        Nodo siguiente = null;

        while (actual != null) {
            siguiente = actual.siguiente;
            actual.siguiente = anterior; // Invertimos el puntero
            anterior = actual;
            actual = siguiente;
        }

        // Mostramos la lista invertida
        Nodo temp = anterior; // 'anterior' es ahora la nueva cabeza temporal
        while (temp != null) {
            System.out.print(temp.dato + " -> ");
            temp = temp.siguiente;
        }
        System.out.println("NULL");

        // Restauramos la lista a su orden original invirtiéndola de nuevo
        actual = anterior;
        anterior = null;
        while (actual != null) {
            siguiente = actual.siguiente;
            actual.siguiente = anterior;
            anterior = actual;
            actual = siguiente;
        }

        cabeza = anterior; // Restauramos la cabeza original
    }

    // Función para determinar si un número es par o impar
    public boolean esParOImpar(int numero) {
        if (numero % 2 == 0) {
            return true; //"El número " + numero + " es PAR.";
        } else {
            return false; //"El número " + numero + " es IMPAR.";
        }
    }


    /*
    class Node {
    char data;
    Node next;

    public Node(char data) {
        this.data = data;
        this.next = null;
    }
}

class LinkedList {
    Node head;

    // Método para agregar un nodo al final de la lista
    public void append(char data) {
        if (head == null) {
            head = new Node(data);
            return;
        }
        Node current = head;
        while (current.next != null) {
            current = current.next;
        }
        current.next = new Node(data);
    }

    // Método para verificar si la lista es palíndromo
    public boolean esPalindromo() {
        // Si la lista está vacía o tiene solo un elemento, es palíndromo
        if (head == null || head.next == null) {
            return true;
        }

        // Paso 1: Usar dos punteros (rápido y lento) para encontrar el medio de la lista
        Node slow = head;
        Node fast = head;
        
        // Paso 2: El puntero lento llega al medio y el puntero rápido llega al final
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // Paso 3: Revertir la segunda mitad de la lista
        Node reversedHalf = reverseList(slow);

        // Paso 4: Comparar la primera mitad con la segunda mitad
        Node current = head;
        while (reversedHalf != null) {
            if (current.data != reversedHalf.data) {
                return false;  // No es un palíndromo
            }
            current = current.next;
            reversedHalf = reversedHalf.next;
        }
        
        return true;  // Es un palíndromo
    }

    // Método para revertir la lista a partir de un nodo dado
    private Node reverseList(Node node) {
        Node prev = null;
        Node current = node;
        Node next = null;

        while (current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }

        return prev;  // El nuevo "head" de la lista invertida
    }
}

public class PalindromeLinkedList {
    public static void main(String[] args) {
        LinkedList lista = new LinkedList();
        lista.append('r');
        lista.append('a');
        lista.append('d');
        lista.append('a');
        lista.append('r');

        if (lista.esPalindromo()) {
            System.out.println("La lista enlazada es un PALÍNDROMO.");
        } else {
            System.out.println("La lista enlazada NO es un palíndromo.");
        }
    }
}
    
     */
}
