/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clase11;

/**
 *
 * @author Luis
 */
class NodoBinarioBusqueda {

    public NodoBinarioBusqueda hijoIzq;
    public NodoBinarioBusqueda hijoDer;
    public Object info;

    public NodoBinarioBusqueda(Object info) {
        this.hijoIzq = null;
        this.hijoDer = null;
        this.info = info;
    }
}

public class ArbolBinarioBusqueda {

    public NodoBinarioBusqueda root;

    public ArbolBinarioBusqueda() {
        root = null;
    }

    public NodoBinarioBusqueda HijoIzquierdo(NodoBinarioBusqueda root) {
        return root.hijoIzq;
    }

    public NodoBinarioBusqueda HijoDerecho(NodoBinarioBusqueda root) {
        return root.hijoDer;
    }

    public boolean IsEmpty(NodoBinarioBusqueda n) {
        return n == null;
    }

    //Funcion cualquiera que queremos que haga
    public void Visitar(NodoBinarioBusqueda root) {
        System.out.print(root.info + ",");

    }

    //r,i,d
    public void PreOrder(NodoBinarioBusqueda root) {
        if (root != null) {
            Visitar(root);
            PreOrder(root.hijoIzq);
            PreOrder(root.hijoDer);
        }
    }

    public void DispararPreOrder() {
        PreOrder(root);
    }

    /*
    Todo lo siguiente no sirve
     */
    //x el elemento del nodo que voy a buscar y root la raiz del arbol
    public NodoBinarioBusqueda Buscar(int x, NodoBinarioBusqueda root) {
        if (IsEmpty(root)) {
            return null;

        } else {

            if (x < (int) root.info) {
                return Buscar(x, HijoIzquierdo(root));
            } else {
                if (x > (int) root.info) {
                    return Buscar(x, HijoDerecho(root));

                } else {
                    return root;
                }
            }

            /*
            if ((int) root.info == x) {
                return root;
            } else {
                if ((int) root.info > x) {
                    Buscar(x, HijoIzquierdo(root));
                } else {
                    Buscar(x, HijoDerecho(root));
                }
            }*/
        }

    }

    public boolean DispararBuscar(Object x) {
        return Buscar((int) x, root) != null;

    }

    public NodoBinarioBusqueda BuscarIterativo(NodoBinarioBusqueda root, Object x) {
        boolean encontrado = false;
        while (!encontrado && !IsEmpty(root)) {
            if (root.info == x) {
                encontrado = true;
            } else {
                if ((int) root.info > (int) x) {
                    root = root.hijoIzq;

                } else {
                    root = root.hijoDer;
                }
            }
        }
        if (encontrado) {
            return root;
        } else {
            return null;
        }
    }

    public void DispararInsertar(Object x) {
        Insertar(root, x);
    }
//este no funciona
    //x el elemento del nodo que voy a insertar y root la raiz del arbol

    public void Insertar(NodoBinarioBusqueda root, Object x) {
        NodoBinarioBusqueda nuevo = new NodoBinarioBusqueda(x);
        if (IsEmpty(root)) {
            this.root = nuevo;

        } else {
            if ((int) root.info > (int) x) {
                Insertar(root.hijoIzq, x);
            } else {
                Insertar(root.hijoDer, x);
            }
        }
    }

    public void InsertarIterativo(Object x) {
        NodoBinarioBusqueda nuevo = new NodoBinarioBusqueda(x);

        if (IsEmpty(root)) {
            root = nuevo;

        } else {
            NodoBinarioBusqueda aux = root;
            NodoBinarioBusqueda padre;
            while (true) {
                padre = aux;
                //String
                //if (x.compareTo((String) aux.info) <= 0) 
                if ((int) aux.info > (int) x) {
                    aux = aux.hijoIzq;
                    if (aux == null) {
                        padre.hijoIzq = nuevo;

                        return;
                    }

                } else {
                    aux = aux.hijoDer;
                    if (aux == null) {
                        padre.hijoDer = nuevo;

                        return;
                    }
                }
            }
        }

    }

    public void DispararEliminar(Object x) {
        Eliminar(root, x);
    }
//este no funciona

    public void Eliminar(NodoBinarioBusqueda root, Object x) {
        NodoBinarioBusqueda aux;
        if (IsEmpty(root)) {
            System.out.println("No existe el elemento que se quiere eliminar");
        } else {
            if ((int) x < (int) root.info) {
                Eliminar(HijoIzquierdo(root), x);

            } else {
                if ((int) x > (int) root.info) {
                    Eliminar(HijoDerecho(root), x);
                } else {
                    if (root.hijoIzq == null) {
                        aux = root;
                        root = root.hijoDer;
                    } else {
                        if (root.hijoDer == null) {
                            aux = root;
                            root = root.hijoIzq;
                        } else {
                            aux = BuscarMinimo(root.hijoIzq);
                            root.info = aux.info;
                            Eliminar(root.hijoDer, root.info);
                        }
                    }
                }
            }
        }
    }
    //Se reemplaza con el menor del árbol derecho, el menor de los mayores

    public NodoBinarioBusqueda BuscarMinimo(NodoBinarioBusqueda root) {
        if (root.hijoIzq != null) {
            return BuscarMinimo(root.hijoIzq);
        }
        return root;
    }

    public static void main(String[] args) {
        ArbolBinarioBusqueda ABB = new ArbolBinarioBusqueda();

        ABB.InsertarIterativo(4);
        ABB.InsertarIterativo(8);
        ABB.InsertarIterativo(1);
        ABB.InsertarIterativo(9);
        ABB.InsertarIterativo(7);

        ABB.DispararPreOrder();
        System.out.println("");
        System.out.println(ABB.DispararBuscar(99));
        //ABB.DispararEliminar(8);
        ABB.DispararInsertar(10);
        System.out.println("");
        ABB.DispararPreOrder();
    }

}
