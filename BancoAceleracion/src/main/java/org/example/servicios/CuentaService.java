package org.example.servicios;

import org.example.entidades.Cuenta;
import org.example.entidades.Sucursal;
import org.example.entidades.Usuario;
import org.example.enums.TipoCuenta;

import java.util.ArrayList;
import java.util.Scanner;

public class CuentaService {

    UsuarioService usuarioService = new UsuarioService();
    Scanner input = new Scanner (System.in);

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

    public void menu(ArrayList<Usuario> usuarios){

        double cantidad = 0;
        int opcion = 0;
        boolean encontrado = false;

        System.out.println("Ingrese su DNI");
        String dni = input.next();

        for (Usuario usuario : usuarios) {
            if (usuario.getDni().equals(dni)){

                encontrado = true;
                String cbuCuenta = "";

                System.out.println("Que accion desea realizar? \n" +
                                    "1) Depositar \n" +
                                    "2) Retirar \n" +
                                    "3) Transferir" );

                opcion = input.nextInt();

                switch (opcion){
                    case 1:
                        System.out.println("Ingrese CBU de la cuenta a la que desea depositar");
                        System.out.println(usuario.getCuentas());
                        cbuCuenta = input.next();
                        for (Cuenta cuenta : usuario.getCuentas()){
                            if(cuenta.getCBU().equals(cbuCuenta)){
                                System.out.println("Cuanto desea depositar?");
                                cantidad = input.nextDouble();
                                depositar(cuenta, cantidad);
                            }
                        }
                        break;
                    case 2:
                        System.out.println("Ingrese CBU de la cuenta de la que desea retirar");
                        System.out.println(usuario.getCuentas());
                        cbuCuenta = input.next();
                        for (Cuenta cuenta : usuario.getCuentas()){
                            if(cuenta.getCBU().equals(cbuCuenta)){
                                System.out.println("Cuanto desea retirar?");
                                cantidad = input.nextDouble();
                                retirar(cuenta, cantidad);
                            }
                        }
                        break;
                    case 3:
                        System.out.println("Ingrese CBU de la cuenta de la que desea transferir");
                        System.out.println(usuario.getCuentas());
                        cbuCuenta = input.next();
                        for (Cuenta cuenta : usuario.getCuentas()){
                            if(cuenta.getCBU().equals(cbuCuenta)){

                                System.out.println("Ingrese CBU de la cuenta destino");
                                String cbuDestino = input.next();

                                for (Usuario usuarioDestino : usuarios){
                                    for (Cuenta cuentaDestino : usuarioDestino.getCuentas()){
                                        if(cuentaDestino.getCBU().equals(cbuDestino)){
                                            System.out.println("Ingrese monto a transferir");
                                            cantidad = input.nextDouble();
                                            transferir(cuenta, cuentaDestino, cantidad);
                                        }
                                    }
                                }
                            }
                        }
                        break;
                    default:
                        System.out.println("Opcion incorrecta");
                }
            }
        }
        if (!encontrado){
            System.out.println("No se encuentra usuario con ese dni");
        }
    }

    private boolean validarSaldo(Cuenta cuenta, double monto){

        return cuenta.getSaldo() >= monto;
    }

    private void mostrarSaldo(Cuenta cuenta){
        System.out.println("------ Saldo actual: $" + cuenta.getSaldo() + " ------");
    }

    private void mostrarSaldos(Cuenta cuentaOrigen, Cuenta cuentaDestino){

        System.out.println("--Cuenta Origen--");
        mostrarSaldo(cuentaOrigen);
        System.out.println("--Cuenta Destino--");
        mostrarSaldo(cuentaDestino);
    }
}
