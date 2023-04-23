package org.example;

import org.example.entidades.Cuenta;
import org.example.entidades.Usuario;
import org.example.servicios.CuentaService;
import org.example.servicios.UsuarioService;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        UsuarioService UsuarioServ = new UsuarioService();
        CuentaService CuentaServ = new CuentaService();

        List<Cuenta> cuentas1 = new ArrayList<Cuenta>();
        List<Cuenta> cuentas2 = new ArrayList<Cuenta>();

        // Creacion de cuentas
        Cuenta cuenta1 = CuentaServ.crearCuenta();
        Cuenta cuenta2 = CuentaServ.crearCuenta();

        Cuenta cuenta3 = CuentaServ.crearCuenta();
        Cuenta cuenta4 = CuentaServ.crearCuenta();

        // Carga de cuentas a las listas "cuentas1" y "cuentas2"
        cuentas1.add(cuenta1);
        cuentas1.add(cuenta2);

        cuentas2.add(cuenta3);
        cuentas2.add(cuenta4);

        // Creacion de usuarios
        Usuario usuario1 = UsuarioServ.crearUsuario(cuentas1,"pepe", "34789123");
        Usuario usuario2 = UsuarioServ.crearUsuario(cuentas2,"fede", "21754323");

        // Realizar transacciones

        // Deposito
        System.out.println("---depositos---");
        CuentaServ.depositar(usuario1.getCuentas().get(0), 100);
        CuentaServ.depositar(usuario2.getCuentas().get(0), 100);

        // Retiro
        System.out.println("---retiros---");
        CuentaServ.retirar(usuario1.getCuentas().get(0), 150);
        CuentaServ.retirar(usuario2.getCuentas().get(0), 100);

        //Transferencia
        System.out.println("---transferencias---");
        CuentaServ.transferir(usuario1.getCuentas().get(0), usuario2.getCuentas().get(0), 200);
        CuentaServ.transferir(usuario1.getCuentas().get(0), usuario2.getCuentas().get(0), 50);
    }
}