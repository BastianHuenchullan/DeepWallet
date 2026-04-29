package com.duoc.deepwallet.controller;

import com.duoc.deepwallet.model.Ingreso;
import com.duoc.deepwallet.service.IngresoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/ingresos")
public class IngresoController {

    @Autowired
    private IngresoService ingresoService;

    @GetMapping
    public ResponseEntity<List<Ingreso>> listarIngresos() {
        return ResponseEntity.ok(ingresoService.getIngresos());
    }

    @PostMapping
    public ResponseEntity<Ingreso> agregarIngreso(@Valid @RequestBody Ingreso ingreso) {
        return ResponseEntity.status(HttpStatus.CREATED).body(ingresoService.saveIngreso(ingreso));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Ingreso> buscarIngreso(@PathVariable int id) {
        Ingreso ingreso = ingresoService.getIngresoId(id);
        if (ingreso == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(ingreso);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Ingreso> actualizarIngreso(@PathVariable int id, @Valid @RequestBody Ingreso ingreso) {
        ingreso.setId(id);
        Ingreso actualizado = ingresoService.updateIngreso(ingreso);
        if (actualizado == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(actualizado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarIngreso(@PathVariable int id) {
        ingresoService.deleteIngreso(id);
        return ResponseEntity.noContent().build();
    }
}