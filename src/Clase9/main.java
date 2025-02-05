/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clase9;

import Clase9.Pila;

/**
 *
 * @author Luis
 */
public class main {

    public static void main(String[] args) {
        Pila mipila = new Pila();
        mipila.agregarfinal(3);
        mipila.agregarfinal(2);
        mipila.agregarfinal(1);
        System.out.println("\nLista original:");
        mipila.mostrarpila();
        System.out.println("-----------");
        System.out.println("Se elimino el: " + mipila.pop());
        mipila.mostrarpila();
        System.out.println("-----------\nLista invertida:");
        mipila.voltear(mipila);
        System.out.println("-----------\nLista copiada:");
        Pila b = mipila.copiar();
        b.mostrarpila();
        System.out.println("-----------\nLista original:");
        mipila.mostrarpila();
        System.out.println("-----------\nLista copiada invertida:");
        Pila c = mipila.copiarinvertida();
        c.mostrarpila();
        System.out.println("-----------\nLista original:");
        mipila.mostrarpila();
        System.out.println("-----------\nAgregar al final: ");
        mipila.agregarfinal(0);
        mipila.agregarfinal(-1);
        mipila.agregarfinal(-2);
        mipila.mostrarpila();

    }

}
