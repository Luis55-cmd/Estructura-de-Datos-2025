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
public class main {

    public static void main(String[] args) {
        // TODO code application logic here
        ListaDoble milista = new ListaDoble();
        int opcion = 0;
        int usuarioinput;
        do {
            try {
                opcion = Integer.parseInt(JOptionPane.showInputDialog(null,
                        "1. Agregar un nodo al inicio\n"
                        + "2. Agregar un nodo al final\n"
                        + "3. Mostrar la lista de inicio a fin\n"
                        + "4. Mostrar la lista de fin a inicio\n"
                        + "5. Eliminar un nodo al inicio\n"
                        + "6. Eliminar un nodo al final\n"
                        + "7. Eliminar un nodo cualquiera\n"
                        + "8. Eliminar los ultimos 3 nodos\n"
                        + "9. Salir\n", "Menu de opciones",
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
                                "Agregando al final", JOptionPane.INFORMATION_MESSAGE));
                        milista.agregarFinal(usuarioinput);
                        break;
                    case 3:
                        milista.mostrarInicioFin();
                        break;
                    case 4:
                        milista.mostrarFinInicio();
                        break;

                    case 5:
                        if (!milista.IsEmpty()) {
                            milista.eliminarInicio();
                        } else {
                            JOptionPane.showMessageDialog(null, "No hay nodos\n"
                                    + "Tamaño de la lista: " + milista.tamañoLista(),
                                    "Lista vacia",
                                    JOptionPane.INFORMATION_MESSAGE);
                        }
                        break;
                    case 6:
                        if (!milista.IsEmpty()) {
                            milista.eliminarFinal();
                        } else {
                            JOptionPane.showMessageDialog(null, "No hay nodos\n"
                                    + "Tamaño de la lista: " + milista.tamañoLista(),
                                    "Lista vacia",
                                    JOptionPane.INFORMATION_MESSAGE);
                        }

                        break;
                    case 7:
                        if (!milista.IsEmpty()) {
                            milista.mostrarInicioFin();
                            usuarioinput = Integer.parseInt(JOptionPane.showInputDialog(null,
                                    "Ingresa el elemento del nodo",
                                    "Eliminar", JOptionPane.INFORMATION_MESSAGE));

                            if (milista.estaEnLista(usuarioinput)) {
                                milista.eliminarCualquiera(usuarioinput);
                                JOptionPane.showMessageDialog(null, "El elemento eliminado es: "
                                        + usuarioinput,
                                        "Eliminando nodo del final",
                                        JOptionPane.INFORMATION_MESSAGE);

                            } else {
                                JOptionPane.showMessageDialog(null, "El elemento que quieres borrar: "
                                        + usuarioinput+"\nNo esta en la lista",
                                        "No encontrado",
                                        JOptionPane.INFORMATION_MESSAGE);
                                
                            }
                        } else {
                            JOptionPane.showMessageDialog(null, "No hay nodos\n"
                                    + "Tamaño de la lista: " + milista.tamañoLista(),
                                    "Lista vacia",
                                    JOptionPane.INFORMATION_MESSAGE);
                        }
                        break;
                        
                    case 8:
                        milista.eliminar3Finales();
                        break;
                        
                    case 9:
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

        } while (opcion != 9);
    }
}
