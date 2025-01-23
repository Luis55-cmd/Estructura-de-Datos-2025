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
public class main {

    public static void main(String[] args) {
        // TODO code application logic here
        ListaCircular milista = new ListaCircular();
        int opcion = 0;
        int usuarioinput;
        do {
            try {
                opcion = Integer.parseInt(JOptionPane.showInputDialog(null,
                        "1. Agregar un nodo inicio\n"
                        + "2. Agregar un nodo final\n"
                        + "3. Mostrar la lista\n"
                        + "4. Salir\n", "Menu de opciones",
                        JOptionPane.INFORMATION_MESSAGE));

                switch (opcion) {

                    case 1:
                        usuarioinput = Integer.parseInt(JOptionPane.showInputDialog(null,
                                "Ingresa el elemento del nodo",
                                "Agregando al inicio", JOptionPane.INFORMATION_MESSAGE));
                        milista.agregarInicio(usuarioinput);
                        break;

                    case 2:
                        usuarioinput = Integer.parseInt(JOptionPane.showInputDialog(null,
                                "Ingresa el elemento del nodo",
                                "Agregando al inicio", JOptionPane.INFORMATION_MESSAGE));
                        milista.agregarFinal(usuarioinput);

                        break;

                    case 3:
                        milista.mostrarLista();
                        break;
                    case 4:
                        JOptionPane.showMessageDialog(null,
                                "Aplicacion finalizada", "Fin",
                                JOptionPane.INFORMATION_MESSAGE);
                        break;
                    default:
                        JOptionPane.showMessageDialog(null,
                                "La opcion no esta en el menu", "Error",
                                JOptionPane.INFORMATION_MESSAGE);
                }
            } catch (NumberFormatException n) {
                JOptionPane.showMessageDialog(null, "Error" + n.getMessage());

            }

        } while (opcion != 4);
    }
}
