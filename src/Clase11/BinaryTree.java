package Clase11;

class Node {

    private int data;
    private Node left;
    private Node right;

    public Node(int ddata) {
        this.data = ddata;
        this.left = null;
        this.right = null;
    }

    public void displayNode(Node n) {
        System.out.print(n.data + " ");
    }

    public int get_info() {
        return this.data;
    }

    public void Set_info(int data) {
        this.data = data;
    }

    public Node Left_child() {
        return this.left;
    }

    public Node Right_child() {
        return this.right;
    }

    public void Set_Left_child(Node n) {
        this.left = n;
    }

    public void Set_Right_child(Node n) {
        this.right = n;
    }

}

public class BinaryTree {

    Node root;

    public BinaryTree() {
        this.root = null;
    }

    public boolean its_empty(Node n) {
        return n == null;
    }

    public Node getRoot() {
        return root;
    }

    public Node find(Node n, int key) {
        Node result = null;
        if (n == null) {
            return null;
        }
        if (n.get_info() == key) {
            return n;
        }
        if (n.Left_child() != null) {
            result = find(n.Left_child(), key);
        }
        if (result == null) {
            result = find(n.Right_child(), key);
        }
        return result;
    }

    public int getheight(Node root) {
        if (root == null) {
            return 0;
        }
        return Math.max(getheight(root.Left_child()), getheight(root.Right_child())) + 1;
    }

    public void printTree(Node n) {
        if (n == null) {
            return;
        }
        printTree(n.Left_child());
        n.displayNode(n);
        printTree(n.Right_child());
    }

    public void PreOrder(Node n) {

        if (n == null) {
            return;
        }
        n.displayNode(n);
        PreOrder(n.Left_child());
        PreOrder(n.Right_child());
    }

    public void InOrder(Node n) {

        if (n == null) {
            return;
        }
        InOrder(n.Left_child());
        n.displayNode(n);
        InOrder(n.Right_child());
    }

    public void PostOrder(Node n) {

        if (n == null) {
            return;
        }
        PostOrder(n.Left_child());
        PostOrder(n.Right_child());
        n.displayNode(n);
    }

    /**
     * Insercion recursiva. Solo inserta valores no repetidos.
     *
     * @param clave
     * @param ABB
     * @return
     */
    public boolean Insert_recur(int clave, Node ABB) {
        if (its_empty(ABB)) {
            ABB = new Node(clave);
            return true;
        } else {
            if (clave == ABB.get_info()) {
                return false;
            } else {
                if (clave < ABB.get_info()) {
                    if (this.its_empty(ABB.Left_child())) {
                        ABB.Set_Left_child(new Node(clave));
                        return true;
                    } else {
                        return Insert_recur(clave, ABB.Left_child());
                    }
                } else {
                    if (this.its_empty(ABB.Right_child())) {
                        ABB.Set_Right_child(new Node(clave));
                        return true;
                    } else {
                        return Insert_recur(clave, ABB.Right_child());
                    }
                }

            }
        }
    }

    /**
     * Precondicion: el nodo a eliminar, debe existir en el arbol.
     *
     * @param Elem
     * @param ABB
     * @return
     */
    public Node Delete(int Elem, Node ABB) {
        Node resp = ABB;
        if (Elem < ABB.get_info()) {
            ABB.Set_Left_child(Delete(Elem, ABB.Left_child()));
        } else {
            if (Elem > ABB.get_info()) {
                ABB.Set_Right_child(Delete(Elem, ABB.Right_child()));
            } else {
                if (ABB.Left_child() != null && ABB.Right_child() != null) {
                    Node temp = ABB;
                    Node Max_Izq = Max(ABB.Left_child());
                    ABB.Set_info(Max_Izq.get_info());
                    temp.Set_Left_child(Delete(Max_Izq.get_info(), temp.Left_child()));
                } else {
                    if (ABB.Left_child() != null) {
                        resp = ABB.Left_child();
                    } else {
                        if (ABB.Right_child() != null) {
                            resp = ABB.Right_child();
                        } else {
                            resp = null;
                        }
                    }
                }
            }
        }
        return resp;
    }

    public Node Max(Node n) {
        if (n.Right_child() == null) {
            return n;
        } else {
            return Max(n.Right_child());
        }
    }

    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();

        // Insertar elementos en el árbol
        tree.root = new Node(50);
        tree.Insert_recur(30, tree.getRoot());
        tree.Insert_recur(70, tree.getRoot());
        tree.Insert_recur(20, tree.getRoot());
        tree.Insert_recur(40, tree.getRoot());
        tree.Insert_recur(60, tree.getRoot());
        tree.Insert_recur(80, tree.getRoot());

        // Imprimir en orden
        System.out.println("Recorrido InOrder:");
        tree.InOrder(tree.getRoot());
        System.out.println();

        // Buscar un nodo
        int searchKey = 40;
        Node foundNode = tree.find(tree.getRoot(), searchKey);
        if (foundNode != null) {
            System.out.println("Elemento " + searchKey + " encontrado en el árbol.");
        } else {
            System.out.println("Elemento " + searchKey + " no encontrado en el árbol.");
        }

        // Eliminar un nodo
        System.out.println("Eliminando 30 del árbol...");
        tree.root = tree.Delete(30, tree.getRoot());

        // Imprimir en orden después de eliminar
        System.out.println("Recorrido InOrder después de eliminar 30:");
        tree.InOrder(tree.getRoot());
        System.out.println();

        // Obtener la altura del árbol
        System.out.println("Altura del árbol: " + tree.getheight(tree.getRoot()));
    }
}
