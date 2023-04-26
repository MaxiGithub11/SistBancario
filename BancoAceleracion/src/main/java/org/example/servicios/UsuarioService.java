package org.example.servicios;

import org.example.entidades.Usuario;

import java.util.ArrayList;

public class UsuarioService {

    private ArrayList<Usuario> usuarios = new ArrayList<>();

    public Usuario crearUsuario(String nombre, String dni){

        Usuario usuario = new Usuario(new ArrayList<>(), nombre, dni);

        usuarios.add(usuario);

        return usuario;
    }

    public void mostrarUsuarios (){
        System.out.println(usuarios);
    }
    public ArrayList<Usuario> returnUsuarios(){

        return usuarios;
    }
}
