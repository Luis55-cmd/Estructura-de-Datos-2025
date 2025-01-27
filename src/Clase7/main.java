/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clase7;

/**
 *
 * @author Luis
 */
public class main {

    public static void main(String[] args) {
        //Analisis de algoritmos
        /*
        asig=asignacion
        comp=comparaciones
        incre=incrementos
        sum=suma
        T(n) es el tiempo de ejecucion de un algoritmo
        
        -Complejidad:
        
        1.producto.c --> 1producto+1asig=2 T(n)
        2.suma.c --> 1asig+1asig+(n+1)comp+nincre+n(1sum+1asig)=4n+3 T(n)
        3.incremento.c --> 1asig+1asig+(n+1)comp+nincre+n(1asig+(n+1)comp+nincre+n(1incre))=3n^2+4n+3 T(n)
        
        lo mejor es empezar de adentro hacia afuera
        
        -Tiempos de ejecucion (microsegundos):
        
        Tamaño n=10:
        Producto=342, Suma=31, Incremento=Asignacion=Comparacion=1
        1.producto.c --> 1*342+1*1=343 microsegundos
        2.suma.c --> 1*1+1*1+n*1+1*1+n*1+n*31+n*1=3+34n=3+34*10=3+340=343 microsegundos
        3.incremento.c --> incrementos:2n^2+n, asignaciones:n+2, comparaciones: n^2+2n+1
        =1*(2n^2+n+n+2+n^2+2n+1)=3n^2+4n+3=3*(10^2)+4*(10)+3=343 microsegundos
        
        Propiedades de big O
        Si un algoritmo tiene un tiempo de ejecución de
        T(n)=5n^2+3n+7 , su complejidad se expresa como O(n^2)
        las constantes 5, 3, y 7 se ignoran y las constantes n menores tambien
        Si un algoritmo ejecuta dos operaciones en la misma funcion,
        gana la de mayor n
        
        Dominancia jerárquica: El crecimiento de las funciones tiene un orden jerárquico. 
        Por ejemplo: 1<log⁡n<n<nlog⁡n<n^2<n^3<2^n<n!.
        
        Si un algoritmo tiene un tiempo de ejecución de T(n)=n+log⁡n, 
        su complejidad se expresa como O(n), 
        porque n crece más rápido que logn cuando n→∞.
        El tiempo total es:
        T(n)=O(n)+O(n^2)+O(log⁡n).
        Dado que n^2 domina, la complejidad del algoritmo es O(n^2).
        
        O(1): Tiempo constante (ej. acceder al primer elemento de un arreglo).
        O(log⁡n): Crece lentamente (ej. búsqueda binaria).
        O(n): Crece linealmente (ej. recorrer un arreglo una vez).
        O(n2): Crece cuadráticamente (ej. doble bucle anidado).
        
        ∈
        f(n)=n^2+2=O(n^2+2)=O(n^2)
        O(n^2+2)⊆ O(n^2)
        
         */

        Funciones de una Lista Simplemente Enlazada
    

    :
        
    //Funcion para saber si la lista esta vacia
    //El tiempo de ejecución: O(1), Complejidad constante
    //El número total de operaciones en función de n es:
    //1 comp = 1
    public boolean IsEmpty() {
        return pFirst == null; //1 comparacion
    }

    //Funcion vaciar lista
    //El tiempo de ejecución: O(2)=O(1), Complejidad constante
    //El número total de operaciones en función de n es:
    //1 asig + 1 asig = 2
    public void Vaciar() {
        this.pFirst = null; //1 asignacion
        this.size = 0;      //1 asignacion
    }

    //Funcion agregar al final
    //El tiempo de ejecución: O(5)=O(1), Complejidad constante
    //El número total de operaciones en función de n es:
    // 1 asig + 1 asig + 1 asig + 1 asig + 1 increm = 5
    public void AgregarAlFinal(T dato) {
        Nodo nuevo = new Nodo(dato);    //1 asignacion
        if (!IsEmpty()) {               // O(1)
            this.pLast.pNext = nuevo;   //1 asignacion
            this.pLast = nuevo;         //1 asignacion
        } else {
            this.pFirst = this.pLast = nuevo; // 1 asignacion
        }
        this.size++;                    //1 incremento
    }

    //Funcion agregar un nodo al inicio
    //El tiempo de ejecución: O(4)=O(1), Complejidad constante
    //El número total de operaciones en función de n es:
    // 1 asig + 1 asig + 1 asig + 1 increm = 4
    public void AgregarAlInicio(T dato) {
        Nodo nuevo = new Nodo(dato);
        if (!IsEmpty()) {                   // O(1)
            nuevo.pNext = this.pFirst;      //1 asignacion
            this.pFirst = nuevo;            //1 asignacion
        } else {
            this.pFirst = this.pLast = nuevo; //1 asignacion
        }
        this.size++;                        //1 incremento
    }

    //Funcion eliminar un nodo al inicio
    //El tiempo de ejecución: O(2)=O(1), Complejidad constante
    //El número total de operaciones en función de n es:
    // 1 asig + 1 decre = 2
    public void EliminarAlInicio() {
        if (!IsEmpty()) {                   // O(1)
            System.out.println("Se ha eliminado el " + pFirst.dato);
            pFirst = pFirst.pNext;          //1 asignacion
            size--;                         //1 decremento
        }
    }

    //Funcion eliminar un nodo al final
    //El tiempo de ejecución: O(2n+4)=O(n), Complejidad lineal
    //El número total de operaciones en función de n es:
    // 1 comp + 1 asig + (n-1) comp + n*(1 asig) + 1 asig + 1 asig + 1 decre = 2n+4 
    public void EliminarAlFinal() {
        if (!IsEmpty()) {                   // O(1)
            System.out.println("Se ha eliminado el " + pLast.dato);
            if (this.pFirst == this.pLast) {    //1 comparacion
                Vaciar();                   // O(1)
            } else {
                Nodo aux = this.pFirst;     //1 asignacion
                while (aux.pNext != this.pLast) { //n-1 comparacion
                    aux = aux.pNext;        //1 asignacion n veces
                }
                aux.pNext = null;           //1 asignacion
                this.pLast = aux;           //1 asignacion
                this.size--;                //1 decremento
            }
        }
    }

    //Funcion mostrar lista
    //El tiempo de ejecución: O(2n+1)=O(n), Complejidad lineal
    //El número total de operaciones en función de n es:
    //1 asig + (n) comp + n*(1 asig) = 2n+1
    public void MostrarLista() {
        Nodo recorrer = pFirst;             //1 asignacion
        System.out.print("Tamaño de la lista: " + this.size);
        System.out.println();
        if (!IsEmpty()) {                   // O(1)
            while (recorrer != null) {      //n comparacion
                System.out.print("[" + recorrer.dato + "]---->");
                recorrer = recorrer.pNext;  //1 asignacion n veces
            }
            System.out.println("null");
        } else {
            System.out.println("[]");
        }
    }
    
    /*
    //El número total de operaciones en función de n es: 3n+2
            for(int i=0;i<size;i++){      1asig,n+1comp,ninc
                sout(dato);             
                aux=aux.pNext;              1asig * nveces       
            }
    */
    

}
}
