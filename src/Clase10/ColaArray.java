/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clase10;

/**
 *
 * @author Luis
 */
public class ColaArray {

    private int[] cola; // Arreglo para almacenar los elementos
    private int frente; // Índice del frente de la cola
    private int fin;    // Índice del fin de la cola
    private int capacidad;

    public ColaArray(int capacidad) {
        this.capacidad = capacidad;
        cola = new int[capacidad];
        frente = -1;
        fin = -1;
    }

    // Agregar elemento a la cola
    public void encolar(int elemento) {
        if ((fin + 1) % capacidad == frente) {
            System.out.println("La cola está llena.");
            return;
        }
        if (frente == -1) {
            frente = 0;
        }
        fin = (fin + 1) % capacidad;
        cola[fin] = elemento;
    }

    // Eliminar elemento del frente de la cola
    public int desencolar() {
        if (frente == -1) {
            System.out.println("La cola está vacía.");
            return -1;
        }
        int elemento = cola[frente];
        if (frente == fin) {
            frente = -1; // Cola vacía
            fin = -1;
        } else {
            frente = (frente + 1) % capacidad;
        }
        return elemento;
    }

    // Recorrer la cola sin modificarla
    public void recorrer() {
        if (frente == -1) {
            System.out.println("La cola está vacía.");
            return;
        }
        System.out.println("Elementos en la cola:");
        int i = frente;
        while (true) {
            System.out.println(cola[i]);
            if (i == fin) {
                break;
            }
            i = (i + 1) % capacidad;
        }
    }

    public static void main(String[] args) {
        ColaArray cola = new ColaArray(5);
        cola.encolar(10);
        cola.encolar(20);
        cola.encolar(30);
        cola.recorrer(); // Recorre los elementos
        System.out.println("Desencolando: " + cola.desencolar());
        cola.recorrer(); // Recorre los elementos restantes
    }
}
