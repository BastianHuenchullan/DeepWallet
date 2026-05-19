package com.duoc.deepwallet.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class UsuarioPerfilDto {
    
    private Integer id;
    private String nombreUsuario;
    private Integer saldo;
}
