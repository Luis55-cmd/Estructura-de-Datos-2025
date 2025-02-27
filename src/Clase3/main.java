/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clase3;

/**
 *
 * @author Luis
 */
import javax.swing.JOptionPane;

public class main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Lista listaNueva = new Lista();
        int opcion = 0, inputUsuario;
        do {
            try {
                opcion = Integer.parseInt(JOptionPane.showInputDialog(null,
                        "1. Insertar un elemento al inicio de la lista"
                        + "\n2. Insertar un elemento al final de la lista"
                        + "\n3. Mostrar los datos de la lista"
                        + "\n4. Vaciar la lista"
                        + "\n5. Buscar un elemento de la lista"
                        + "\n6. Eliminar un elemento al inicio de la lista"
                        + "\n7. Eliminar un elemento al final de la lista"
                        + "\n8. Eliminar un elemento especifico de la lista"
                        + "\n9. Salir", "Menu de Opciones", 3));
                switch (opcion) {
                    case 1:
                        try {
                            /*
                            inputUsuario=Integer.parseInt(JOptionPane.showInputDialog(null,
                                    "Ingresa el elemento:","Insertando al inicio",3));
          
                            //agregando al nodo
                            listaNueva.AgregarAlInicio(inputUsuario);
                             */
                            
                            listaNueva.agregarEnOrden(5);
                            listaNueva.agregarEnOrden(1);
                            listaNueva.agregarEnOrden(7);
                            listaNueva.agregarEnOrden(2);

                        } catch (NumberFormatException n) {
                            JOptionPane.showMessageDialog(null, "Error" + n.getMessage());

                        }

                        break;
                    case 2:
                        try {
                            inputUsuario = Integer.parseInt(JOptionPane.showInputDialog(null,
                                    "Ingresa el elemento:", "Insertando al final", 3));

                            //agregando al nodo
                            listaNueva.AgregarAlFinal(inputUsuario);

                        } catch (NumberFormatException a) {
                            JOptionPane.showMessageDialog(null, "Error" + a.getMessage());

                        }

                        break;

                    case 3:

                        listaNueva.MostrarLista();
                        System.out.println();
                        break;
                    case 4:
                        listaNueva.Vaciar();
                        System.out.println("La lista se ha vaciado correctamente");
                        listaNueva.MostrarLista();
                        break;
                    case 5:
                        try {
                            inputUsuario = Integer.parseInt(JOptionPane.showInputDialog(null,
                                    "Ingresa el elemento:", "Buscando", 3));

                            if (listaNueva.Buscar(inputUsuario)) {
                                System.out.println("El valor " + inputUsuario + " si se encuentra en la lista.");
                            } else {
                                System.out.println("El valor " + inputUsuario + " no se encontró en la lista.");
                            }

                        } catch (NumberFormatException a) {
                            JOptionPane.showMessageDialog(null, "Error" + a.getMessage());

                        }
                        break;

                    case 6:
                        listaNueva.EliminarAlInicio();

                        break;

                    case 7:
                        listaNueva.EliminarAlFinal();
                        break;
                    case 8:
                        try {
                            inputUsuario = Integer.parseInt(JOptionPane.showInputDialog(null,
                                    "Ingresa el elemento:", "Buscando", JOptionPane.INFORMATION_MESSAGE));

                            listaNueva.EliminarEspecifico(inputUsuario);
                            JOptionPane.showMessageDialog(null, "Se ha eliminado el " + inputUsuario);

                        } catch (NumberFormatException b) {
                            JOptionPane.showMessageDialog(null, "Error" + b.getMessage());

                        }

                        break;
                    case 9:
                        break;

                    default:
                        JOptionPane.showMessageDialog(null, "Opcion incorrecta");
                }

            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Error" + e.getMessage());
            }
        } while (opcion != 9);

    }
}
