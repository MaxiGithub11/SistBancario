package org.example.entidades;

import lombok.*;
import org.example.enums.TipoCuenta;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter

public class Cuenta {

    private String CBU;
    private Sucursal sucursal;
    private Usuario usuario;
    private double saldo;
    private TipoCuenta tipoCuenta;

    @Override
    public String toString() {
        return "Cuenta{" +
                "CBU='" + CBU + '\'' +
                ", sucursal=" + sucursal +
                ", saldo=" + saldo +
                ", tipoCuenta=" + tipoCuenta +
                '}';
    }
}
