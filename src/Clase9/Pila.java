/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clase9;

/**
 *
 * @author Luis
 */
public class Pila {

    Nodo cima;
    int n;//tamaño de la pila

    public Pila() {
        this.cima = null;
        this.n = 0;
    }

    public boolean IsEmpty() {
        return cima == null;
    }

    public void Vaciar() {
        while (!IsEmpty()) {
            pop();
        }
    }

    //Agregar al inicio
    public void push(Object num) {

        Nodo nuevo = new Nodo(num);
        if (!IsEmpty()) {
            nuevo.pNext = cima;
            cima = nuevo;
        } else {
            cima = nuevo;
        }

        n++;
    }

    //Eliminar al inicio
    public Object pop() {
        if (!IsEmpty()) {
            cima = cima.pNext;
            n--;
        } else {
            System.out.println("Pila vacia");
        }
        return null;
    }

    //Muestra la pila de fin a inicio
    public void mostrarpila() {
        if (!IsEmpty()) {
            int elem = (Integer) cima.dato;
            pop();
            System.out.println(elem);
            mostrarpila();
            push(elem);
        }

    }

    public void copiarrecursiva(Pila origen, Pila copia) {
        int elemento;
        if (!IsEmpty()) {
            elemento = (Integer) cima.dato;
            origen.pop();
            copiarrecursiva(origen, copia);
            origen.push(elemento);
            copia.push(elemento);

        }
    }

    public void copiarinvertidarecursiva(Pila origen, Pila copia) {
        int elemento;
        if (!IsEmpty()) {
            elemento = (Integer) cima.dato;
            origen.pop();
            copia.push(elemento);
            copiarinvertidarecursiva(origen, copia);
            origen.push(elemento);

        }
    }

    public void sumergirrecursiva(Pila p, int x) {
        int elemento;
        if (!IsEmpty()) {
            elemento = (Integer) cima.dato;
            p.pop();
            sumergirrecursiva(p, x);
            p.push(elemento);
        } else {
            p.push(x);
        }
    }

    //Funcion para voltear una pila
    public void voltear(Pila original) {
        Pila copia = new Pila();
        Nodo aux = original.cima;
        while (aux != null) {
            copia.push((Integer) aux.dato);
            aux = aux.pNext;
        }
        copia.mostrarpila();

    }

    //Funcion para copiar una pila //Pila b = mipila.copiar();
    public Pila copiar() {
        Pila auxiliar = new Pila();
        Pila copia = new Pila();

        // Paso 1: Pasar los elementos a una pila auxiliar para invertir el orden
        while (!this.IsEmpty()) {
            auxiliar.push(this.pop());

        }

        // Paso 2: Restaurar la pila original y copiarla a la nueva
        while (!auxiliar.IsEmpty()) {
            int dato = (Integer) auxiliar.pop();
            push(dato);
            copia.push(dato);
        }
        return copia;
    }

    //Funcion para copiar una pila invertida
    public Pila copiarinvertida() {
        Pila invertida = new Pila();
        Nodo actual = cima;

        // Simplemente vamos apilando los elementos en la nueva pila
        while (actual != null) {
            invertida.push((Integer) actual.dato);
            actual = actual.pNext;
        }

        return invertida;
    }

    //Funcion para agregar un elemento al final de la pila
    public void agregarfinal(int num) { //3--2--1--null
        Nodo nuevo = new Nodo(num, null);
        Nodo aux = cima;
        if (!IsEmpty()) {
            while (aux != null) {
                if (aux.pNext == null) {
                    aux.pNext = nuevo;
                    nuevo.pNext = null;
                }
                aux = aux.pNext;
            }
        } else {
            cima = nuevo;
        }

    }

    //De forma recursivo
    /*
     public void agregarfinal(int num,Pila p)
    p.pop() //ida
    agregarfinal(int num,Pila p)
    p.push() //vuelta
    
     */
    //Eliminar al inicio
    public Nodo pop2() {
        if (!IsEmpty()) {
            Nodo temp = cima;
            cima = temp.pNext;

            n--;
            return temp;

        } else {
            System.out.println("Pila vacia");
        }
        return null;
    }

    /*Comprobrar que la pila Q es subpila de P
    Pila normal: p= a,b,c
    Pila sombrero: q= a,b
     */
    public String sombrero(Pila p, Pila q) {
        String result = "";
        if (q.IsEmpty()) {
            return "Q es sombrero de P";
        } else if (q.n >= p.n) {
            return "Q no es sombrero de P";
        } else {
            Nodo auxQ = q.pop2();
            Nodo auxP = p.pop2();
            if (auxQ.dato == auxP.dato) {
                result = sombrero(p, q);

            } else {
                return "Q no es sombrero de P";
            }
            q.push((Integer) auxQ.dato);
            p.push((Integer) auxP.dato);
            return result;
        }
    }

    //Consigue la suma de todos los elementos de una pila recursivamente
    public int sumaRecursiva(Pila p) {
        int contador = 0;
        if (!IsEmpty()) {
            Nodo aux = p.pop2();
            contador += (Integer) aux.dato;
            contador += sumaRecursiva(p);
            p.push((Integer) aux.dato);
            return contador;
        } else {
            return 0;
        }
    }

    public boolean verificarParentesis(String p) {
        Pila abiertos = new Pila();
        for (int i = 0; i < p.length(); i++) {
            char c = p.charAt(i);
            if (c == '(' || c == '[' || c == '{') {
                abiertos.push(c);
            } else {
                char a = (char) abiertos.cima.dato;
                if (a == '(' && c == ')' || a == '[' && c == ']' || a == '{' && c == '}') {
                    abiertos.pop();
                }
            }
        }
        return abiertos.IsEmpty();
    }

    public void EliminarMedio(Pila stack, int n, int current) {
        if (stack.IsEmpty() || current == n) {
            return;
        }
        int dato = (Integer) stack.cima.dato;
        stack.pop();
        EliminarMedio(stack, n, current+1);
        if (current != n / 2) {
            
            stack.push(dato);
        }

    }

}
