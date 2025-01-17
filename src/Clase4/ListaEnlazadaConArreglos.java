/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clase4;

/**
 *
 * @author Luis
 */
public class ListaEnlazadaConArreglos {
    
    private int[] valores;  // Arreglo para almacenar los valores
    private int[] siguientes;  // Arreglo para almacenar los índices del siguiente nodo
    private int capacidad;  // Capacidad máxima de la lista
    private int cabeza;  // Índice del primer nodo
    private int tamaño;  // Número de elementos en la lista
    private int libre;  // Índice del próximo espacio libre

    // Constructor para inicializar la lista
    public ListaEnlazadaConArreglos(int capacidad) {
        this.capacidad = capacidad;
        this.valores = new int[capacidad];
        this.siguientes = new int[capacidad];
        this.cabeza = -1;  // La lista comienza vacía
        this.tamaño = 0;
        this.libre = 0;

        // Inicializa los espacios libres
        for (int i = 0; i < capacidad - 1; i++) {
            siguientes[i] = i + 1;
        }
        siguientes[capacidad - 1] = -1;  // Último elemento apunta a -1
    }

    // Método para agregar un elemento al inicio de la lista
    public void agregarInicio(int valor) {
        if (tamaño == capacidad) {
            throw new RuntimeException("La lista está llena.");
        }

        // Obtiene el índice libre
        int nuevoNodo = libre;
        libre = siguientes[libre];  // Actualiza el índice libre

        // Asigna el valor y actualiza los punteros
        valores[nuevoNodo] = valor;
        siguientes[nuevoNodo] = cabeza;
        cabeza = nuevoNodo;

        tamaño++;
    }

    // Método para agregar un elemento al final de la lista
    public void agregarFinal(int valor) {
        if (tamaño == capacidad) {
            throw new RuntimeException("La lista está llena.");
        }

        int nuevoNodo = libre;
        libre = siguientes[libre];

        valores[nuevoNodo] = valor;
        siguientes[nuevoNodo] = -1;

        if (cabeza == -1) {
            cabeza = nuevoNodo;  // Si la lista estaba vacía
        } else {
            int actual = cabeza;
            while (siguientes[actual] != -1) {
                actual = siguientes[actual];
            }
            siguientes[actual] = nuevoNodo;  // Enlaza el último nodo con el nuevo
        }

        tamaño++;
    }

    // Método para eliminar un elemento al inicio de la lista
    public int eliminarInicio() {
        if (cabeza == -1) {
            throw new RuntimeException("La lista está vacía.");
        }

        int nodoEliminado = cabeza;
        int valor = valores[nodoEliminado];

        cabeza = siguientes[cabeza];  // Actualiza la cabeza
        siguientes[nodoEliminado] = libre;  // Libera el nodo eliminado
        libre = nodoEliminado;

        tamaño--;
        return valor;
    }

    // Método para obtener el tamaño de la lista
    public int tamaño() {
        return tamaño;
    }

    // Método para imprimir la lista
    public void imprimirLista() {
        int actual = cabeza;
        while (actual != -1) {
            System.out.print(valores[actual] + " -> ");
            actual = siguientes[actual];
        }
        System.out.println("null");
    }
}

