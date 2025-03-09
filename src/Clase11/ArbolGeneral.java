/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clase11;

/**
 *
 * @author Luis
 */
class NodoGeneral {

    //atributos
    public Object info;
    public NodoGeneral hijoIzq;
    public NodoGeneral hermanoDer;

    //constructor
    public NodoGeneral(Object info) {
        this.hijoIzq = null;
        this.hermanoDer = null;
        this.info = info;
    }

}

public class ArbolGeneral {
    //atributos

    public NodoGeneral root;

    //constructor
    public ArbolGeneral() {
        this.root = null;
    }

    //funciones
    //Recorridos
    public void PreOrder(NodoGeneral root) {
        if (root != null) {
            Visitar(root);
            PreOrder(root.hijoIzq);
            PreOrder(root.hermanoDer);
        }
    }

    public void PreOrder2(NodoGeneral n) {
        NodoGeneral temp;
        if (n != null) {
            Visitar(n);
            temp = n.hijoIzq;
            while (temp != null) {
                PreOrder2(temp);
                temp = temp.hermanoDer;

            }
        }
    }

    public void InOrder(NodoGeneral n) {
        NodoGeneral temp;
        if (n != null) {

            temp = n.hijoIzq;
            InOrder(temp);
            Visitar(n);
            while (temp != null) {

                temp = temp.hermanoDer;
                InOrder(temp);

            }
        }
    }

    

    public void PostOrder(NodoGeneral n) {
        NodoGeneral temp;
        if (n != null) {

            temp = n.hijoIzq;

            while (temp != null) {

                PostOrder(temp);
                temp = temp.hermanoDer;

            }
            Visitar(n);
        }
    }

    //Funcion cualquiera que queremos que haga
    public void Visitar(NodoGeneral root) {
        System.out.print(root.info + ",");

    }

    public static void main(String[] args) {

        ArbolGeneral AG = new ArbolGeneral();
        NodoGeneral root = new NodoGeneral("a");
        NodoGeneral nodo1 = new NodoGeneral("b");
        NodoGeneral nodo2 = new NodoGeneral("c");
        NodoGeneral nodo3 = new NodoGeneral("d");
        NodoGeneral nodo4 = new NodoGeneral("e");
        NodoGeneral nodo5 = new NodoGeneral("f");
        NodoGeneral nodo6 = new NodoGeneral("g");
        root.hijoIzq = nodo1;
        nodo1.hermanoDer = nodo2;
        nodo2.hermanoDer = nodo3;
        nodo2.hijoIzq = nodo4;
        nodo4.hermanoDer = nodo5;
        nodo5.hijoIzq = nodo6;

        System.out.println("PreOrder:");
        AG.PreOrder(root);
        System.out.println("");
        System.out.println("PreOrder2:");
        AG.PreOrder2(root);
        System.out.println("");
        System.out.println("InOrder:");
        AG.InOrder(root);
        System.out.println("");
        System.out.println("PostOrder:");
        AG.PostOrder(root);
        System.out.println("");
        

    }
}
