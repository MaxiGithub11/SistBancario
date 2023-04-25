package org.example.servicios;

import org.example.entidades.Cuenta;
import org.example.entidades.Sucursal;
import org.example.entidades.Usuario;
import org.example.enums.TipoCuenta;

public class CuentaService {

    public Cuenta crearCuenta(String CBU, Sucursal sucursal, Usuario usuario, double saldo, TipoCuenta tipoCuenta){

        return new Cuenta(CBU, sucursal, usuario, saldo, tipoCuenta);
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
            System.out.println("Quiso retirar $" + monto + " Y el saldo es insuficiente para realizar la operacion");
        }

        mostrarSaldo(cuenta);
    }

    public void transferir(Cuenta cuentaOrigen, Cuenta cuentaDestino, double monto){

        mostrarSaldos(cuentaOrigen, cuentaDestino);

        if(validarSaldo(cuentaOrigen, monto)){
            cuentaOrigen.setSaldo(cuentaOrigen.getSaldo() - monto); // descontarSaldo()
            cuentaDestino.setSaldo(cuentaDestino.getSaldo() + monto); // agregarSaldo()
            System.out.println("Se transfirio correctamente $" + monto);
        } else {
            System.out.println("Se quiso transferir $" + monto + " y el saldo es insuficiente para realizar la operacion");
        }

        mostrarSaldos(cuentaOrigen, cuentaDestino);
    }

    public boolean validarSaldo(Cuenta cuenta, double monto){

        return cuenta.getSaldo() >= monto;
    }

    public void mostrarSaldo(Cuenta cuenta){
        System.out.println("------ Saldo actual: $" + cuenta.getSaldo() + " ------");
    }

    public void mostrarSaldos(Cuenta cuentaOrigen, Cuenta cuentaDestino){

        System.out.println("--Cuenta Origen--");
        mostrarSaldo(cuentaOrigen);
        System.out.println("--Cuenta Destino--");
        mostrarSaldo(cuentaDestino);
    }
}
