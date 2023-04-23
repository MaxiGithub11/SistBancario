package org.example.entidades;

import lombok.*;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString

public class Usuario {

    private List<Cuenta> cuentas;
    private String nombre;
    private String dni;

}
