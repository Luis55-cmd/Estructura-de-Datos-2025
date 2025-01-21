/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clase5;

import javax.swing.JOptionPane;

/**
 *
 * @author Luis
 */
public class ListaDoble<T> {

    //Atributos de la lista doble
    public NodoDoble inicio;
    public NodoDoble fin;
    public int tamaño;

    //Constructor de la lista doble
    public ListaDoble() {
        inicio = fin = null;
        tamaño = 0;
    }

    //Funcion para saber si esta vacia la lista
    public boolean IsEmpty() {
        return inicio == null; //si inicio es igual a null retorna verdadero
    }

    //Funcion vaciar lista
    public void vaciar() {
        this.inicio = null;
        this.tamaño = 0;
    }

    //Funcion que me devuelve el tamaño de la lista
    public int tamañoLista() {
        return this.tamaño;
    }

    //Funcion para saber si un elemento esta en la lista
    public boolean estaEnLista(T dato) {
        NodoDoble aux = inicio; // Comienza desde el primer nodo
        while (aux != null) {  //Para recorrer la lista
            if (aux.dato == dato) {
                return true; // Si encuentra el valor, devuelve true
            }
            aux = aux.siguiente; // Si no, avanza al siguiente nodo
        }
        return false; // Si llega al final y no lo encuentra, devuelve false
    }

    //Funcion para agregar nodos al final de la lista
    public void agregarFinal(T dato) {
        tamaño++;
        if (!IsEmpty()) {
            fin = new NodoDoble(dato, null, fin);
            fin.anterior.siguiente = fin;

        } else {
            inicio = fin = new NodoDoble(dato);

        }

    }

    //Funcion para agregar nodos al inicio de la lista
    public void agregarInicio(T dato) {
        tamaño++;
        if (!IsEmpty()) {
            inicio = new NodoDoble(dato, inicio, null);
            inicio.siguiente.anterior = inicio;

        } else {
            inicio = fin = new NodoDoble(dato);

        }

    }

    //Funcion mostrar la lista de inicio a fin
    public void mostrarInicioFin() {
        System.out.println();
        if (!IsEmpty()) {
            NodoDoble recorrer = inicio;
            String flecha = "<=>";
            while (recorrer != null) {
                flecha = flecha + "[" + recorrer.dato + "]<=>";
                recorrer = recorrer.siguiente;
            }

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

    //Funcion mostrar la lista de fin a inicio
    public void mostrarFinInicio() {
        NodoDoble recorrer = fin;
        System.out.println();
        if (!IsEmpty()) {
            String flecha = "<=>";
            while (recorrer != null) {
                flecha = flecha + "[" + recorrer.dato + "]<=>";
                recorrer = recorrer.anterior;
            }

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

    //Funcion eliminar al inicio
    public void eliminarInicio() {
        tamaño--;
        int dato = (int) inicio.dato;
        if (inicio == fin) { //Si no hay ningun nodo o hay unicamente uno
            inicio = fin = null;
            JOptionPane.showMessageDialog(null, "No hay nodos\n"
                    + "Tamaño de la lista: " + this.tamaño,
                    "Lista vacia",
                    JOptionPane.INFORMATION_MESSAGE);
        } else {
            inicio = inicio.siguiente;
            inicio.anterior = null;
            JOptionPane.showMessageDialog(null, "El elemento eliminado es: "
                    + dato,
                    "Eliminando nodo del inicio",
                    JOptionPane.INFORMATION_MESSAGE);
        }
    }

    //Funcion eliminar al final
    public void eliminarFinal() {
        tamaño--;
        int dato = (int) fin.dato;
        if (inicio == fin) { //Si no hay ningun nodo o hay unicamente uno
            inicio = fin = null;
            JOptionPane.showMessageDialog(null, "No hay nodos\n"
                    + "Tamaño de la lista: " + this.tamaño,
                    "Lista vacia",
                    JOptionPane.INFORMATION_MESSAGE);
        } else {
            fin = fin.anterior;
            fin.siguiente = null;
            JOptionPane.showMessageDialog(null, "El elemento eliminado es: "
                    + dato,
                    "Eliminando nodo del final",
                    JOptionPane.INFORMATION_MESSAGE);
        }
    }

    //Funcion para eliminar cualquier nodo
    public void eliminarCualquiera(T elemento) {

        tamaño--;
        if (inicio == fin && inicio.dato == elemento) { //solo hay un elemento y coincide con el buscado
            inicio = null;
            fin = null;
        } else {

            if (inicio.dato == elemento) { //si el elemento a borrar es el primero de la lista
                inicio = inicio.siguiente;
                inicio.anterior = null;
            } else {
                if (fin.dato == elemento) { //si el elemento a borrar es el ultimo de la fila
                    fin = fin.anterior;
                    fin.siguiente = null;
                } else {
                    //partimos en la busqueda desde el principio 
                    //pero tambien lo podiamos hacer desde el final .. que para eso es enlazada
                    NodoDoble borrar = inicio;

                    //apuntamos con aux al nodo que queremos borrar
                    while (borrar.dato != elemento) {
                        borrar = borrar.siguiente;
                    }

                    //ya estamos apuntando al puntero que queremos borrar
                    //ahora debemos acoplar los punteros que se quedan ligando sus punteros
                    //para eso partimos del aux como referencia
                    borrar.anterior.siguiente = borrar.siguiente;
                    borrar.siguiente.anterior = borrar.anterior;
                }
            }
        }

    }

    //Funcion eliminar los ultimos 3 nodos
    public void eliminar3Finales() {

        int contador = 0;

        if (tamañoLista() > 3) {

            while (!IsEmpty() && contador < 3) {
                fin = fin.anterior;
                fin.siguiente = null;
                contador++;
                tamaño--;
            }

            JOptionPane.showMessageDialog(null, "Se han eliminado los 3 ultimos elementos de la lista ",
                    "Eliminando nodos del final",
                    JOptionPane.INFORMATION_MESSAGE);

        } else if (tamañoLista() == 3) {
            vaciar();
            JOptionPane.showMessageDialog(null, "Se han eliminado los 3 ultimos elementos de la lista ",
                    "Eliminando nodos del final",
                    JOptionPane.INFORMATION_MESSAGE);
        } else if (tamañoLista() < 3) {
            mostrarInicioFin();
            JOptionPane.showMessageDialog(null, "La lista es muy pequeña para "
                    + "eliminar 3 elementos\n"
                    + "Porfavor agrege mas elementos",
                    "Error",
                    JOptionPane.INFORMATION_MESSAGE);
        }
    }

}
