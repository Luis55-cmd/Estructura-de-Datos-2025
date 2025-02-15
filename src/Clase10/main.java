/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clase10;

/**
 *
 * @author Luis
 */
public class main {

    public static void main(String[] args) {

        Cola micola = new Cola();
        micola.Encolar(1);
        micola.Encolar(5);
        micola.Encolar(2);
        micola.Encolar(3);
        micola.OrdenarRecursivo(micola);
        
        micola.Colear2(micola, 0, 4);
        
        
        micola.BuscarElemento(micola, 6);
        micola.MostrarCola();

        /*
        Cola micola = new Cola();
        Cola copia = new Cola();
        micola.Encolar(1);
        micola.Encolar(2);
        micola.Encolar(3);
        micola.Encolar(4);
        micola.CopiarColaIterativa(micola, copia);
        micola.Colear(micola, 0);
        micola.MostrarCola();
        System.out.println("");
        copia.MostrarCola();
         */

 /*
        Cola micola = new Cola();
        micola.Encolar(1);
        micola.Encolar(2);
        micola.Encolar(3);
        micola.Encolar(4);
        micola.MostrarCola();
        micola.Desencolar();
        System.out.println("");
        micola.MostrarCola();
        
         */

 /*
        Cola micola = new Cola();
        micola.Encolar(3);
        micola.Encolar(4);
        micola.Encolar(1);
        micola.Encolar(2);
        
        
        
        
        
        micola.MostrarCola();
        micola.OrdenarRecursivo(micola);
        System.out.println("");
        micola.MostrarCola();
         */
 /*
        Cola micola = new Cola();
        micola.Encolar(1);
        micola.Encolar(2);
        micola.Encolar(2);
        micola.Encolar(3);
        micola.MostrarCola();
        micola.EliminarDuplicados();
        System.out.println("");
        micola.MostrarCola();
         */
    }

}
