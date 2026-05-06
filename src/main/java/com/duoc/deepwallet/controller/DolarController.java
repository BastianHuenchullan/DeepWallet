package com.duoc.deepwallet.controller;

import com.duoc.deepwallet.dto.ValorDolarDto;
import com.duoc.deepwallet.service.DolarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/dolar")
public class DolarController {

    @Autowired
    private DolarService dolarService;

    @GetMapping
    public ResponseEntity<ValorDolarDto> dolar() {

        ValorDolarDto resultado = dolarService.obtenerDolar();
        System.out.println("Valor del Dolar a CLP obtenido.");
        return ResponseEntity.ok(resultado);
    }
}