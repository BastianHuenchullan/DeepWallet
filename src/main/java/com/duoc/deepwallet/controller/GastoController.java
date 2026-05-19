package com.duoc.deepwallet.controller;

import com.duoc.deepwallet.model.Gasto;
import com.duoc.deepwallet.service.GastoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/gastos")
public class GastoController {

    @Autowired
    private GastoService gastoService;

    @GetMapping
    public ResponseEntity<List<Gasto>> listarGastos() {
        System.out.println("Obteniendo todos los Gastos.");
        return ResponseEntity.ok(gastoService.getGastos());
    }

    @PostMapping
    public ResponseEntity<Gasto> agregarGasto(@Valid @RequestBody Gasto gasto) {
        System.out.println("Agregando un Gasto.");
        return ResponseEntity.status(HttpStatus.CREATED).body(gastoService.saveGasto(gasto));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Gasto> buscarGasto(@PathVariable int id) {
        Gasto gasto = gastoService.getGastoId(id);
        if (gasto == null) {
            System.out.println("No se ha encontrado el gasto con la id " + id + ".");
            return ResponseEntity.notFound().build();
        }
        System.out.println("El gasto con la id " + id + " fue encontrado.");
        return ResponseEntity.ok(gasto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Gasto> actualizarGasto(@PathVariable int id, @Valid @RequestBody Gasto gasto) {
        gasto.setId(id);
        Gasto actualizado = gastoService.updateGasto(gasto);
        if (actualizado == null) {
            System.out.println("No se ha encontrado el gasto con la id " + id + ".");
            return ResponseEntity.notFound().build();
        }
        System.out.println("El gasto con la id " + id + " fue actualizado.");
        return ResponseEntity.ok(actualizado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarGasto(@PathVariable int id) {
        gastoService.deleteGasto(id);
        System.out.println("El gasto con la id " + id + " ha sido eliminado.");
        return ResponseEntity.noContent().build();
    }
}