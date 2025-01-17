/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clase4;

/**
 *
 * @author Luis
 */
public class main {
    public static void main(String[] args) {
        ListaEnlazadaConArreglos lista = new ListaEnlazadaConArreglos(10);

        lista.agregarInicio(10);
        lista.agregarInicio(20);
        lista.agregarFinal(30);

        System.out.println("Lista después de agregar elementos:");
        lista.imprimirLista();

        System.out.println("Eliminando elemento al inicio: " + lista.eliminarInicio());

        System.out.println("Lista después de eliminar:");
        lista.imprimirLista();

        System.out.println("Tamaño actual de la lista: " + lista.tamaño());
    }
}

