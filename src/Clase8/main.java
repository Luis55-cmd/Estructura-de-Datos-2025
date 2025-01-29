/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clase8;

/**
 *
 * @author Luis
 */
public class main {

    public static void main(String[] args) {

        /*
        El profesor no dejo tarea esta clase
        
         */
 /*
1-        //Complejidad de un bucle simple. O(1)
        int c=5;
        for (int i = 1; i <= c; i++) {
            System.out.println(i);
        }
        //El bucle se ejecuta hasta que i supera c, es decir:
        //i=k>5
        //O(5)
        
         */
 /*
2-        //Bucle con “n” iteraciones e incremento/decremento constante: O(n)
        int c=2; //constante cualquiera
        int n=5;
        for (int i = 1; i <=n; i=i+c) {
            System.out.println(i);
        }
        //El bucle se ejecuta hasta que i supera n, es decir:
        //i=k>n
        //O(n)
        
        for (int i = n; i >0; i=i-c) {
            System.out.println(i);
        }
        //El bucle se ejecuta hasta que i no supere o alcanze a 0, es decir:
        //i=n<=0
        //O(n)

         */
 /*
3-        //Bucle que itera“C*N” veces: O(n) 
        int n=2;
        for (int i = 1; i <=3*n; i=i+1) {
            System.out.println(i);
        }
        //El bucle se ejecuta hasta que i supera 3*n, es decir:
        //i=k>3n
        //O(3n)
         */
 /*
4-        //Bucle con controlado por dos variables: O(n)
        int n=5;
        int l=0,r=n-1;
        while (l<=r) {            
            if (true) {
                l=l+1;
            } else {
                r=r-1;
            }
        }
        //O(n-1)
        //l=i,r=n-1
        //for(int i=0; l<=n-1; i++)
         */
 /*
5-        //Bucle que incrementa/decrementa en un factor constante O(log n)
        int n=5;
        for (int i = 1; i <n; i=i*2) {
            System.out.println(i);
        }
        //El bucle se ejecuta hasta que i alcanza o supera n, es decir:
        //i=2^k≥n
        //k=log2​n despejando k
        //O(log2n)
        
        int n=6;
        for (int i = n; i >0; i=i/2) {
            System.out.println(i);
        }
        //El bucle se ejecuta hasta que i ≤ 0, es decir:
        //i=n≤0
        //k=log2​n despejando k
        //O(log2n)
         */
 /*
6-        //Bucles anidados. Bucle Interno con O(n log n)       
         
        int n = 2;
        for (int i = 1; i <= n; i++) {    //O(n)
            for (int j = 1; j < n; j = j * 2) {     // O(log n)
                System.out.println(i + " y " + j);
            }
        }
        //Al ser anidados 
        //O(n)*O(log n)
         */
 /*
7-        //Bucles consecutivos O(m+n)       
         
        int m = 5, n = 6;
        for (int i = 0; i < m; i = i + 1) {     //O(m)
            System.out.println(i);
        }
        for (int i = 0; i < n; i = i + 1) {     //O(n)
            System.out.println(i);
        }
        //Al ser consecutivos 
        //O(m)+O(n)
         */
 /*
8-        //Dos bucles anidados O(n^2)
         
         
        int n = 2;
        for (int i = 0; i < n; i++) {    //O(n)
            for (int j = 0; j < n; j++) {     // O(n)
                System.out.println(i + " y " + j);
            }
        }
 
        for (int i = 0; i < n; i++) {    //O(n)
            for (int j = i+1; j < n; j++) {     // O(n)
                System.out.println(i + " y " + j);
            }
        }
        //Al ser anidados doble 
        //O(n)*O(n)
         */
 /*
9-        //Bucles combinados O(m*n)
 
 
        int n = 10;
        int m = 5;

        // Primer bucle O(n)
        for (int i = 0; i < n; i = i + 1) {
            // Algunas expresiones O(1)
            System.out.println("Iteración del primer bucle: " + i);
        }

        // Segundo bucle anidado O(n * m)
        for (int i = 0; i < n; i = i + 1) {
            for (int j = 0; j < m; j = j + 1) {
                // Algunas expresiones O(1)
                System.out.println("Iteración del segundo bucle: i=" + i + ", j=" + j);
            }
        }

        // Tercer bucle O(n)
        for (int k = 0; k < n; k = k + 1) {
            // Algunas expresiones O(1)
            System.out.println("Iteración del tercer bucle: " + k);
        }
 
        //Al ser combinados
        //O(n)+O(m*n)+ O(n) 
         */
 /*
 10-        //Tres bucles anidados O(m*n^2)
         
        int m = 5; // Puedes cambiar el valor de m
        int n = 10; // Puedes cambiar el valor de n

        // Bucle anidado con tres niveles
        for (int i = 0; i < m; i = i + 1) {
            for (int j = 0; j < n; j = j + 1) {
                for (int k = 0; k < n; k = k + 1) {
                    // Algunas expresiones O(1)
                    System.out.println("Iteración: i=" + i + ", j=" + j + ", k=" + k);
                }
            }
        }
        //Al ser triple anidados
        //O(n)*O(m)* O(n) 
         */
    }
}
