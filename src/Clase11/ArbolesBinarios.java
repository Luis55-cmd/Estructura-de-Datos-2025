/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clase11;

/**
 *
 * @author Luis
 */
public class ArbolesBinarios {

    private Nodo root;

    public ArbolesBinarios() {
        this.root = null;
    }

    public Nodo getRoot() {
        return root;
    }

    public void setRoot(Nodo root) {
        this.root = root;
    }

    public boolean IsEmpty() {
        return root == null;

    }

    public void Empty() {
        root = null;

    }

    public Nodo SearchPadre(Nodo root, String padre) {
        Nodo encontrado = null;
        if (root.getData() == padre) { //Cuando hay 1 elemento
            return root;
        }
        if (root.getLeft() != null && encontrado == null) {
            encontrado = SearchPadre(root.getLeft(), padre);

        }
        if (root.getRight() != null && encontrado == null) {
            encontrado = SearchPadre(root.getRight(), padre);

        }
        return encontrado;
    }

    public void AgregarNodo(String hijo, String padre, String side) {
        Nodo nodohijo = new Nodo(hijo);
        if (IsEmpty()) {
            root = nodohijo;
        } else {
            Nodo nodopadre = SearchPadre(root, padre);
            if (nodopadre == null) {
                System.out.println("El padre no existe");
            } else if (side == "left" && nodopadre.getLeft() == null) {
                nodopadre.setLeft(nodohijo);
            } else if (side == "right" && nodopadre.getRight() == null) {
                nodopadre.setRight(nodohijo);
            } else {
                System.out.println("Ambos hijos estan llenos, no se puede agregar");
            }
        }
    }

    //Sobrecarga de metodos
    public String PreOrder() {

        return PreOrder(root, "");
    }

    //route es el string donde tengo el recorrido
    private String PreOrder(Nodo root, String route) {
        route += root.getData()+",";
        if (root.getLeft() != null) {
            route = PreOrder(root.getLeft(), route);

        }
        if (root.getRight() != null) {
            route = PreOrder(root.getRight(), route);

        }
        return route;
    }

    public String InOrder() {

        return InOrder(root, "");
    }

    private String InOrder(Nodo root, String route) {

        if (root.getLeft() != null) {
            route = InOrder(root.getLeft(), route);

        }
        route += root.getData()+",";
        if (root.getRight() != null) {
            route = InOrder(root.getRight(), route);

        }
        return route;
    }

    public String PostOrder() {

        return PostOrder(root, "");
    }

    private String PostOrder(Nodo root, String route) {

        if (root.getLeft() != null) {
            route = PostOrder(root.getLeft(), route);

        }

        if (root.getRight() != null) {
            route = PostOrder(root.getRight(), route);

        }
        route += root.getData()+",";
        return route;
    }

}
