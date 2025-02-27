/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clase11;

/**
 *
 * @author Luis
 */
public class main {

    public static void main(String[] args) {
        
        ArbolesBinarios AB=new ArbolesBinarios();
        AB.AgregarNodo("5", null, null);
        AB.AgregarNodo("2", "5", "left");
        AB.AgregarNodo("9", "5", "right");
        AB.AgregarNodo("1", "2", "left");
        AB.AgregarNodo("3", "2", "right");
        AB.AgregarNodo("4", "3", "right");
        AB.AgregarNodo("7", "9", "left");
        AB.AgregarNodo("11", "9", "right");
        AB.AgregarNodo("6", "7", "left");
        AB.AgregarNodo("8", "7", "right");
        AB.AgregarNodo("10", "11", "left");
        AB.AgregarNodo("12", "11", "right");
        
        
        System.out.println("Preorder:");
        System.out.println(AB.PreOrder());
        System.out.println("Postorder:");
        System.out.println(AB.PostOrder());
        System.out.println("Inorder:");
        System.out.println(AB.InOrder());
        
        
        
        
        
        
        
        
        
        
        /*
        Nivel/Profundida de un arbol: se mide a partir de la raiz
        Altura de un arbol: se mide a partir de la hojas (Hacer el truquito visto en clase)
        Tipos de arboles: General, Binario,Binario de busqueda
        Recorridos de arboles: Dado el arbol hacer el recorrido o dado el recorrido hacer el arbol
        Preorder:R,HI,HD
        Inorder:HI,R,HD
        Postorder:HI,HD,R
        Arboles Binarios:
        -Max numero de nodos por nivel "n"
        Nivel n: Max nodos=2^n
        -Max numero de nodos por altura "h"
        Altura n: Max nodos=2^(h+1)-1
        -Numero de hojas=nodos con 2hijos+1
        En Arboles binarios o de busqueda suele pasar que el inorder
        sea ascendente, es decir "1,2,3..."
        
        
        
        */
       

    }
}
