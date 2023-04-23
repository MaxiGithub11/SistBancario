package org.example.servicios;

import org.example.entidades.Cuenta;

public class CuentaService {

    public Cuenta crearCuenta(){

        return new Cuenta();
    }

    public void depositar(Cuenta cuenta, double monto){

        mostrarSaldo(cuenta);
        cuenta.setSaldo(cuenta.getSaldo() + monto);
        System.out.println("Se deposito correctamente $" + monto);
        mostrarSaldo(cuenta);
    }

    public void retirar(Cuenta cuenta, double monto){

        mostrarSaldo(cuenta);
        if(validarSaldo(cuenta, monto)){
            cuenta.setSaldo(cuenta.getSaldo() - monto);
            System.out.println("Se extrajo correctamente $" + monto);
        } else {
            System.out.println("Saldo insuficiente para realizar la operacion");
        }
        mostrarSaldo(cuenta);
    }

    public void transferir(Cuenta cuentaOrigen, Cuenta cuentaDestino, double monto){
        System.out.println("--Cuenta Origen--");
        mostrarSaldo(cuentaOrigen);
        System.out.println("--Cuenta Destino--");
        mostrarSaldo(cuentaDestino);

        if(validarSaldo(cuentaOrigen, monto)){
            cuentaOrigen.setSaldo(cuentaOrigen.getSaldo() - monto); // descontarSaldo()
            cuentaDestino.setSaldo(cuentaDestino.getSaldo() + monto); // agregarSaldo()
            System.out.println("Se transfirio correctamente $" + monto);
        } else {
            System.out.println("Saldo insuficiente para realizar la operacion");
        }

        System.out.println("--Cuenta Origen--");
        mostrarSaldo(cuentaOrigen);
        System.out.println("--Cuenta Destino--");
        mostrarSaldo(cuentaDestino);
    }

    public boolean validarSaldo(Cuenta cuenta, double monto){

        return cuenta.getSaldo() >= monto;
    }

    public void mostrarSaldo(Cuenta cuenta){
        System.out.println("------ Saldo actual: $" + cuenta.getSaldo() + " ------");
    }
}
