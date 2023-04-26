package org.example.entidades;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter

public class Sucursal {

    private String pais;
    private String provincia;
    private String ciudad;
    private String direccion;

    @Override
    public String toString() {
        return "Sucursal{" +
                "pais='" + pais + '\'' +
                ", provincia='" + provincia + '\'' +
                ", ciudad='" + ciudad + '\'' +
                ", direccion='" + direccion + '\'' +
                '}';
    }
}
