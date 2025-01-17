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
public class main{

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Lista lista_nueva=new Lista();
        int opcion=0,input_usuario;
        do{
            try{
                opcion=Integer.parseInt(JOptionPane.showInputDialog(null,
                        "1. Agregar un elemento al inicio de la lista\n2. Mostrar los datos de la lista\n"
                            +"3. Salir","Menu de Opciones",3));
                switch(opcion){
                    case 1:
                        try{
                            input_usuario=Integer.parseInt(JOptionPane.showInputDialog(null,
                                    "Ingresa el elemento:","Insertando al inicio",3));
          
                            //agregando al nodo
                            lista_nueva.agregar_al_inicio(input_usuario);
                        
                        }catch(NumberFormatException n){
                            JOptionPane.showMessageDialog(null, "Error"+n.getMessage());
                                    
                        }
                        
                        
                        
                        break;
                    case 2:
                        lista_nueva.mostrar_lista();
                        
                        break;
                        
                    case 3:
                        break;
                    default:
                        JOptionPane.showMessageDialog(null, "Opcion incorrecta");
                }
                
            }catch(Exception e){
                JOptionPane.showMessageDialog(null, "Error"+e.getMessage());
            }
        }while(opcion!=3);
        
    }
}

