package com.duoc.deepwallet.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class UsuarioPerfilDTO {
    
    private Integer id;

    @NotBlank
    private String nombreUsuario;

    @NotBlank
    @Email
    private String email;
}
