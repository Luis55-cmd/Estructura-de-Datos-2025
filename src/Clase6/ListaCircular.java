/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clase6;

import javax.swing.JOptionPane;

/**
 *
 * @author Luis
 */
public class ListaCircular {

    //Atributos de la lista doble
    public NodoCircular inicio;
    public NodoCircular ultimo;
    public int tamaño;

    //Constructor de la lista doble
    public ListaCircular() {
        inicio = null;
        ultimo = null;
        tamaño = 0;
    }

    //Funcion para saber si esta vacia la lista
    public boolean IsEmpty() {
        return inicio == null; //si inicio es igual a null retorna verdadero
    }

    //Funcion mostrar la lista de inicio a fin
    public void mostrarLista() {
        if (!IsEmpty()) {
            NodoCircular recorrer = inicio;

            String flecha = "=>";
            do { //primero entra en el ciclo y despues revisa la condicion del ciclo
                flecha = flecha + "[" + recorrer.dato + "]=>";

                recorrer = recorrer.siguiente;

            } while (recorrer != inicio);
            flecha = flecha + "[" + ultimo.siguiente.dato + "]";
            JOptionPane.showMessageDialog(null, flecha + "\n"
                    + "Tamaño de la lista: " + this.tamaño
                    + "\n" + "El ultimo elemento que aparece en la lista es solo "
                    + "para corroborar que es Circular",
                    "Mostrando lista de inicio a fin",
                    JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, "No hay nodos\n"
                    + "Tamaño de la lista: " + this.tamaño,
                    "Lista vacia",
                    JOptionPane.INFORMATION_MESSAGE);

        }
    }
    //Funcion agregar inicio con un auxiliar
    public void agregarInicio(int dato) {
        if (IsEmpty()) {
            inicio = ultimo = new NodoCircular(dato, inicio);
        } else {
            NodoCircular aux = inicio;
            inicio = new NodoCircular(dato);
            inicio.siguiente = aux;
        }
        ultimo.siguiente = inicio;

        tamaño++;
    }
    //Funcion agregar final sin auxiliar y directamente del constructor
    public void agregarFinal(int dato) {
        if (IsEmpty()) {
            inicio = ultimo = new NodoCircular(dato, inicio);
        } else {
            NodoCircular nuevo = new NodoCircular(dato, inicio);
            ultimo.siguiente = nuevo;
            ultimo = nuevo;
        }
        tamaño++;
    }
    //Funcion agregar final con auxiliar y recorriendo la lista
    /*

    public void agregarElementoFinal(int elemento) {
        tamaño++;

        if (IsEmpty()) {
            NodoCircular nuevo = new NodoCircular(elemento, inicio);
            inicio = nuevo;
            inicio.siguiente = inicio;

        } else {
            NodoCircular nuevo = new NodoCircular(elemento, inicio);
            NodoCircular aux = inicio;
            while (aux.siguiente != inicio) {
                aux = aux.siguiente;

            }
            aux.siguiente = nuevo;
            ultimo = aux.siguiente;

        }

    }
     */
}
