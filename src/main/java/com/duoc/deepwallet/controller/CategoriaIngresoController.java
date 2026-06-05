package com.duoc.deepwallet.controller;

import com.duoc.deepwallet.model.CategoriaIngreso;
import com.duoc.deepwallet.service.CategoriaIngresoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/categorias-ingresos")
public class CategoriaIngresoController {

    @Autowired
    private CategoriaIngresoService categoriaIngresoService;

    @GetMapping
    public ResponseEntity<List<CategoriaIngreso>> listarCategoriasIngresos() {
        System.out.println("Obteniendo todas las Categorias de Ingresos.");
        return ResponseEntity.ok(categoriaIngresoService.getCategoriasIngresos());
    }

    @PostMapping("/registro")
    public ResponseEntity<CategoriaIngreso> agregarCategoriaIngreso(@Valid @RequestBody CategoriaIngreso categoriaIngreso) {
        System.out.println("Agregando una Categoria de Ingreso.");
        return ResponseEntity.status(HttpStatus.CREATED).body(categoriaIngresoService.saveCategoriaIngreso(categoriaIngreso));
    }

    @GetMapping("/{id}")
    public ResponseEntity<CategoriaIngreso> buscarCategoriaIngreso(@PathVariable int id) {
        CategoriaIngreso categoria = categoriaIngresoService.getCategoriaIngresoId(id);
        if (categoria == null) {
            System.out.println("No se ha encontrado la categoria de ingreso con la id " + id + ".");
            return ResponseEntity.notFound().build();
        }
        System.out.println("La categoria de ingreso con la id " + id + " fue encontrada.");
        return ResponseEntity.ok(categoria);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CategoriaIngreso> actualizarCategoriaIngreso(@PathVariable int id, @Valid @RequestBody CategoriaIngreso categoriaIngreso) {
        categoriaIngreso.setId(id);
        CategoriaIngreso actualizado = categoriaIngresoService.updateCategoriaIngreso(categoriaIngreso);
        if (actualizado == null) {
            System.out.println("No se ha encontrado la categoria de ingreso con la id " + id + ".");
            return ResponseEntity.notFound().build();
        }
        System.out.println("La categoria de ingreso con la id " + id + " fue actualizada.");
        return ResponseEntity.ok(actualizado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarCategoriaIngreso(@PathVariable int id) {
        categoriaIngresoService.deleteCategoriaIngreso(id);
        System.out.println("La categoria de ingreso con la id " + id + " ha sido eliminada.");
        return ResponseEntity.noContent().build();
    }
}