package com.duoc.deepwallet.controller;

import com.duoc.deepwallet.model.CategoriaGasto;
import com.duoc.deepwallet.service.CategoriaGastoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/categorias-gastos")
public class CategoriaGastoController {

    @Autowired
    private CategoriaGastoService categoriaGastoService;

    @GetMapping
    public ResponseEntity<List<CategoriaGasto>> listarCategoriasGastos() {
        System.out.println("Obteniendo todas las Categorias de Gastos.");
        return ResponseEntity.ok(categoriaGastoService.getCategoriasGastos());
    }

    @PostMapping("/registro")
    public ResponseEntity<CategoriaGasto> agregarCategoriaGasto(@Valid @RequestBody CategoriaGasto categoriaGasto) {
        System.out.println("Agregando una Categoria de Gasto.");
        return ResponseEntity.status(HttpStatus.CREATED).body(categoriaGastoService.saveCategoriaGasto(categoriaGasto));
    }

    @GetMapping("/{id}")
    public ResponseEntity<CategoriaGasto> buscarCategoriaGasto(@PathVariable int id) {
        CategoriaGasto categoria = categoriaGastoService.getCategoriaGastoId(id);
        if (categoria == null) {
            System.out.println("No se ha encontrado la categoria de gasto con la id " + id + ".");
            return ResponseEntity.notFound().build();
        }
        System.out.println("La categoria de gasto con la id " + id + " fue encontrada.");
        return ResponseEntity.ok(categoria);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CategoriaGasto> actualizarCategoriaGasto(@PathVariable int id, @Valid @RequestBody CategoriaGasto categoriaGasto) {
        categoriaGasto.setId(id);
        CategoriaGasto actualizado = categoriaGastoService.updateCategoriaGasto(categoriaGasto);
        if (actualizado == null) {
            System.out.println("No se ha encontrado la categoria de gasto con la id " + id + ".");
            return ResponseEntity.notFound().build();
        }
        System.out.println("La categoria de gasto con la id " + id + " fue actualizada.");
        return ResponseEntity.ok(actualizado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarCategoriaGasto(@PathVariable int id) {
        categoriaGastoService.deleteCategoriaGasto(id);
        System.out.println("La categoria de gasto con la id " + id + " ha sido eliminada.");
        return ResponseEntity.noContent().build();
    }
}