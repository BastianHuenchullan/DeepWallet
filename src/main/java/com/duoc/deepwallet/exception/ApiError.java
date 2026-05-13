package com.duoc.deepwallet.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class ApiError {
    private int codigo;
    private String mensaje;
    private String detalle;
}
