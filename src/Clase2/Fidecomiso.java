/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clase2;

/**
 *
 * @author Luis
 */
public class Fidecomiso implements EspecificacionCuentaBancaria {
    private int balance;


    // Constructor por defecto
    public Fidecomiso() {
        this.balance = 0;
        
    }

    // Constructor con balance inicial
    public Fidecomiso(int balanceInicial) {
        this.balance = Math.max(balanceInicial, 0); // Balance no negativo
        
    }

    // Método para depositar fondos en el fideicomiso
    @Override
    public void depositar(int monto) {
        if (monto > 0) {
            balance += monto;
        } else {
            throw new IllegalArgumentException("El monto a depositar debe ser positivo.");
        }
    }

    // Método para retirar fondos del fideicomiso
    @Override
    public boolean retirar(int monto) {
        if (monto > 0 && monto <= balance) {
            balance -= monto;
            return true;
        } else {
            return false; // No se puede retirar más de lo disponible o un monto no válido
        }
    }

    // Método para obtener el balance actual
    public int getBalance() {
        return balance;
    }



}