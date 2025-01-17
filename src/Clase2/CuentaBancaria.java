/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clase2;

/**
 *
 * @author Luis
 */
public class CuentaBancaria implements EspecificacionCuentaBancaria {
    private int balance;
    
    // Constructor
    public CuentaBancaria(int balance) {
        this.balance = balance;
    }
    
    public CuentaBancaria(){
        balance=0;
    }
    public void depositar(int monto){
        balance=balance+monto;
    }
    public boolean retirar(int monto){
        if (monto<=balance){
        balance=balance-monto;
        return true;
        }else{
            return false;
        }
    }
    public int getbalance(){
        return balance;
    }
    
    
}
