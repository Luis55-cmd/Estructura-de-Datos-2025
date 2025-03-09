/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clase11;

/**
 *
 * @author Luis
 */
class NodoBinario {

    //atributos
    private NodoBinario left;
    private NodoBinario right;
    private String data;

    //constructor
    public NodoBinario(String data) {
        this.left = null;
        this.right = null;
        this.data = data;
    }

    //funciones
    public NodoBinario getLeft() {
        return left;
    }

    public void setLeft(NodoBinario left) {
        this.left = left;
    }

    public NodoBinario getRight() {
        return right;
    }

    public void setRight(NodoBinario right) {
        this.right = right;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

}

public class ArbolBinario {

    //atributos
    private NodoBinario root;

    //constructor
    public ArbolBinario() {
        this.root = null;
    }

    //funciones
    public NodoBinario getRoot() {
        return root;
    }

    public void setRoot(NodoBinario root) {
        this.root = root;
    }

    public boolean IsEmpty() {
        return root == null;

    }

    public void Empty() {
        root = null;

    }

    public NodoBinario SearchPadre(NodoBinario root, String padre) {
        NodoBinario encontrado = null;
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
        NodoBinario nodohijo = new NodoBinario(hijo);
        if (IsEmpty()) {
            root = nodohijo;
        } else {
            NodoBinario nodopadre = SearchPadre(root, padre);
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
    private String PreOrder(NodoBinario root, String route) {
        route += root.getData() + ",";
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

    private String InOrder(NodoBinario root, String route) {

        if (root.getLeft() != null) {
            route = InOrder(root.getLeft(), route);

        }
        route += root.getData() + ",";
        if (root.getRight() != null) {
            route = InOrder(root.getRight(), route);

        }
        return route;
    }

    public String PostOrder() {

        return PostOrder(root, "");
    }

    private String PostOrder(NodoBinario root, String route) {

        if (root.getLeft() != null) {
            route = PostOrder(root.getLeft(), route);

        }

        if (root.getRight() != null) {
            route = PostOrder(root.getRight(), route);

        }
        route += root.getData() + ",";
        return route;
    }

    public static void main(String[] args) {

        ArbolBinario AB = new ArbolBinario();
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

    }
}
