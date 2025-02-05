/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clase9;

/**
 *
 * @author Luis
 */
public class PilaArray {

    
    
    private String[] array;

    //muestra los elementos
    public PilaArray() {

        array = new String[5];

    }

    public String[] getArray() {
        return array;
    }

    

    //agrega un elemento si hay espacio
    public boolean push(String x) {
        int cantidad_nulos = 0;
        int posicion_libre = 0;
        for (int i = 0; i < getArray().length; i++) {
            if (getArray()[i] == null) {
                cantidad_nulos++;
                posicion_libre = i;
            }

        }
        if (cantidad_nulos > 0) {
            this.array[posicion_libre] = x;
            return true;
        } else {
            return false;
        }
    }

    //elimina el ultimo elemento si existiera
    public boolean pop() {
        int cantidad_nulos = 0;
        int posicion_salir = -1;
        for (int i = 0; i < getArray().length; i++) {
            if (getArray()[i] == null) {
                cantidad_nulos++;

            } else {
                if (posicion_salir == -1) {
                    posicion_salir = i;

                }
            }
        }
        if (cantidad_nulos == getArray().length) {
            return false;
        } else {
            this.array[posicion_salir] = null;
            return true;
        }
    }

    //vaciar pila
    public void vaciar() {
        for (int i = 0; i < getArray().length; i++) {
            this.array[i] = null;
        }
    }

    public String print() {
        String msg = "";
        int vuelta = 0;
        for (int i = 0; i < getArray().length; i++) {
            if (getArray()[i] != null) {
                vuelta++;
                if (vuelta == 1) {
                    msg = msg + "\n" + vuelta + ". " + getArray()[i] + "-> Cima";

                } else {
                    msg = msg + "\n" + vuelta + ". " + getArray()[i];
                }
            }
        }
        if (vuelta == 0) {
            msg = msg + "\nNo hay elementos";
        }
        if (vuelta > 0) {
            msg = msg + "-> Fondo";
        }
        if (vuelta == getArray().length) {
            msg = msg + "Sobrecargado";
        }
        return msg;

    }
    
     
}
