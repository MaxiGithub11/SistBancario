package org.example.servicios;

import org.example.entidades.Sucursal;

public class SucursalService {

    UsuarioService usuarioService = new UsuarioService();

    public Sucursal crearSucursal(String pais, String provincia, String ciudad, String direccion){

        return new Sucursal(pais, provincia, ciudad, direccion);
    }
}
