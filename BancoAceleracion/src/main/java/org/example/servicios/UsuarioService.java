package org.example.servicios;

import org.example.entidades.Cuenta;
import org.example.entidades.Usuario;

import java.util.ArrayList;
import java.util.List;

public class UsuarioService {

    public Usuario crearUsuario(String nombre, String dni){

        return new Usuario(new ArrayList<>(), nombre, dni);
    }
}
