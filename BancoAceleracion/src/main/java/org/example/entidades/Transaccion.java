package org.example.entidades;

import lombok.*;
import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString

public abstract class Transaccion {

    private Cuenta cuentaOrigen;
    private String sucursalCueOrigen;
    private Cuenta cuentaDestino;
    private String sucursalCueDes;
    private Date fecha;
}
