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
        System.out.println("Obteniendo todos los Ingresos.");
        return ResponseEntity.ok(ingresoService.getIngresos());
    }

    @PostMapping
    public ResponseEntity<Ingreso> agregarIngreso(@Valid @RequestBody Ingreso ingreso) {
        System.out.println("Agregando un Ingreso.");
        return ResponseEntity.status(HttpStatus.CREATED).body(ingresoService.saveIngreso(ingreso));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Ingreso> buscarIngreso(@PathVariable int id) {
        Ingreso ingreso = ingresoService.getIngresoId(id);
        if (ingreso == null) {
            System.out.println("No se ha encontrado el ingreso con la id " + id + ".");
            return ResponseEntity.notFound().build();
        }
        System.out.println("El ingreso con la id " + id + " fue encontrado.");
        return ResponseEntity.ok(ingreso);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Ingreso> actualizarIngreso(@PathVariable int id, @Valid @RequestBody Ingreso ingreso) {
        ingreso.setId(id);
        Ingreso actualizado = ingresoService.updateIngreso(ingreso);
        if (actualizado == null) {
            System.out.println("No se ha encontrado el ingreso con la id " + id + ".");
            return ResponseEntity.notFound().build();
        }
        System.out.println("El ingreso con la id " + id + " fue actualizado.");
        return ResponseEntity.ok(actualizado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarIngreso(@PathVariable int id) {
        ingresoService.deleteIngreso(id);
        System.out.println("El ingreso con la id " + id + " ha sido eliminado.");
        return ResponseEntity.noContent().build();
    }
}