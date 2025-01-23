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
            flecha = flecha + "[" + inicio.dato + "]";
            JOptionPane.showMessageDialog(null, flecha + "\n"
                    + "Tamaño de la lista: " + this.tamaño,
                    "Mostrando lista de inicio a fin",
                    JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, "No hay nodos\n"
                    + "Tamaño de la lista: " + this.tamaño,
                    "Lista vacia",
                    JOptionPane.INFORMATION_MESSAGE);

        }
    }

    /*
    public void agregarElemento(int elemento) {
        tamaño++;
        NodoCircular nuevo = new NodoCircular(elemento,inicio);
        if (IsEmpty()) {
            inicio =nuevo;
            nuevo.siguiente = nuevo;

        } else {
            nuevo.siguiente=inicio.siguiente;
            inicio.siguiente=nuevo;
            
        }
    }
     */
    public void agregarElemento(int elemento) {
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

}
