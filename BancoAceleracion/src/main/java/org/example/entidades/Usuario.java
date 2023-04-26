package org.example.entidades;

import lombok.*;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter

public class Usuario {

    private List<Cuenta> cuentas;
    private String nombre;
    private String dni;

    @Override
    public String toString() {
        return "Usuario{" +
                "cuentas=" + cuentas +
                ", nombre='" + nombre + '\'' +
                ", dni='" + dni + '\'' +
                '}';
    }
}