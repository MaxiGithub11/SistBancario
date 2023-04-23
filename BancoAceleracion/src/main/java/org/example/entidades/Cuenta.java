package org.example.entidades;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString

public class Cuenta {

    private String CBU;
    private Sucursal sucursal;
    private Usuario usuario;
    private double saldo;

}
