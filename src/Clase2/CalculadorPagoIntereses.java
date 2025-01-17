/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clase2;

/**
 *
 * @author Luis
 */
public class CalculadorPagoIntereses {
    private EspecificacionCuentaBancaria cuenta;
    public CalculadorPagoIntereses(EspecificacionCuentaBancaria lacuenta){
        cuenta=lacuenta;
    }
    public void HacerPagoIntereses(int cantidad){
        boolean ok=cuenta.retirar(cantidad);
        if (ok){
            System.out.println("Pago realizado: "+cantidad);
            
        }else{
            System.out.println("Error");
        }
    }
    
}
