package org.example;

import org.example.entidades.Cuenta;
import org.example.entidades.Sucursal;
import org.example.entidades.Usuario;
import org.example.enums.TipoCuenta;
import org.example.servicios.CuentaService;
import org.example.servicios.SucursalService;
import org.example.servicios.UsuarioService;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        UsuarioService usuarioService = new UsuarioService();
        CuentaService cuentaService = new CuentaService();
        SucursalService sucursalService = new SucursalService();


        // Creacion de sucursales
        Sucursal sucursal1 = sucursalService.crearSucursal("Argentina", "Buenos Aires", "Palermo", "San Martin 123");
        Sucursal sucursal2 = sucursalService.crearSucursal("Argentina", "Cordoba", "Villa Maria", "Obispo Trejo 321");

        // Creacion de usuarios
        Usuario usuario1 = usuarioService.crearUsuario("pepe", "123");
        Usuario usuario2 = usuarioService.crearUsuario("fede", "321");

        // Creacion de cuentas
        Cuenta cuenta1 = cuentaService.crearCuenta("81023981", sucursal1, usuario1, 500, TipoCuenta.CUENTA_AHORRO);
        Cuenta cuenta2 = cuentaService.crearCuenta("23423423", sucursal2, usuario1, 500, TipoCuenta.CUENTA_CORRIENTE);

        Cuenta cuenta3 = cuentaService.crearCuenta("23455123", sucursal1, usuario2, 500, TipoCuenta.CUENTA_CORRIENTE);
        Cuenta cuenta4 = cuentaService.crearCuenta("56756434", sucursal2, usuario2, 500, TipoCuenta.CUENTA_AHORRO);

        // Carga de cuentas a las listas "cuentas1" y "cuentas2"

        List<Cuenta> cuentas1 = new ArrayList<>();
        List<Cuenta> cuentas2 = new ArrayList<>();

        cuentas1.add(cuenta1);
        cuentas1.add(cuenta2);

        cuentas2.add(cuenta3);
        cuentas2.add(cuenta4);

        // Carga de cuentas a usuarios
        usuario1.setCuentas(cuentas1);
        usuario2.setCuentas(cuentas2);

        /*// Realizar transacciones

        // Deposito
        System.out.println("---depositos---");
        cuentaService.depositar(usuario1.getCuentas().get(0), 100);
        System.out.println();
        cuentaService.depositar(usuario2.getCuentas().get(0), 100);
        System.out.println();

        // Retiro
        System.out.println("---retiros---");
        cuentaService.retirar(usuario1.getCuentas().get(0), 150);
        System.out.println();
        cuentaService.retirar(usuario2.getCuentas().get(0), 100);
        System.out.println();

        //Transferencia
        System.out.println("---transferencias---");
        cuentaService.transferir(usuario1.getCuentas().get(0), usuario2.getCuentas().get(0), 200);
        System.out.println();
        cuentaService.transferir(usuario1.getCuentas().get(0), usuario2.getCuentas().get(0), 50); */

        //System.out.println(usuarioService.returnUsuarios());

        cuentaService.menu(usuarioService.returnUsuarios());

    }
}