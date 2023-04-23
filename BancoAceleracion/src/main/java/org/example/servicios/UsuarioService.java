package org.example.servicios;

import org.example.entidades.Cuenta;
import org.example.entidades.Usuario;

import java.util.List;

public class UsuarioService {

    public Usuario crearUsuario(List<Cuenta> cuentas, String nombre, String dni){

        return new Usuario(cuentas, nombre, dni);
    }
}
