package com.duoc.deepwallet.controller;

import com.duoc.deepwallet.dto.UsuarioPerfilDto;
import com.duoc.deepwallet.model.PerfilUsuario;
import com.duoc.deepwallet.service.PerfilUsuarioService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/perfil-usuarios")
public class PerfilUsuarioController {

    @Autowired
    private PerfilUsuarioService perfilUsuarioService;

    @GetMapping
    public ResponseEntity<List<PerfilUsuario>> listarPerfilUsuarios() {
        System.out.println("Obteniendo todos los perfiles de usuarios.");
        return ResponseEntity.ok(perfilUsuarioService.getPerfilUsuarios());
    }

    @GetMapping("/{id}")
    public ResponseEntity<PerfilUsuario> buscarPerfilUsuario(@PathVariable int id) {
        PerfilUsuario perfilUsuario = perfilUsuarioService.getPerfilUsuarioId(id);
    if (perfilUsuario == null) {
            System.out.println("No se ha encontrado el perfil de usuario con la id " + id + ".");
            return ResponseEntity.notFound().build();
        }
        System.out.println("El perfil del usuario con la id " + id + " fue encontrado.");
        return ResponseEntity.ok(perfilUsuario);
    }

    @PostMapping("/registro")
    public ResponseEntity<PerfilUsuario> registrarPerfilUsuario(@Valid @RequestBody PerfilUsuario perfilUsuario) {
        System.out.println("Agregando un perfil de usuario.");
        return ResponseEntity.status(HttpStatus.CREATED).body(perfilUsuarioService.savePerfilUsuario(perfilUsuario));
    }

    @PutMapping("/{id}")
    public ResponseEntity<PerfilUsuario> actualizarPerfilUsuario(@PathVariable int id, @Valid @RequestBody PerfilUsuario perfilUsuario) {
        perfilUsuario.setId(id);
        PerfilUsuario perfilUsuarioActualizado = perfilUsuarioService.updatePerfilUsuario(perfilUsuario);
        if (perfilUsuarioActualizado == null) {
            System.out.println("No se ha encontrado el perfil de usuario con la id " + id + ".");
            return ResponseEntity.notFound().build();
        }
        System.out.println("El perfil de usuario con la id " + id + " fue actualizado.");
        return ResponseEntity.ok(perfilUsuarioActualizado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarPerfilUsuario(@PathVariable int id) {
        perfilUsuarioService.deletePerfilUsuario(id);
        System.out.println("El perfil de usuario con la id " + id + " ha sido eliminado.");
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}/info")
    public ResponseEntity<UsuarioPerfilDto> obtenerPerfilUsuario(@PathVariable int id) {
        PerfilUsuario perfilUsuario = perfilUsuarioService.getPerfilUsuarioId(id);
        if (perfilUsuario == null) {
            System.out.println("No se ha encontrado el perfil de usuario con la id " + id + ".");
            return ResponseEntity.notFound().build();
        }

        UsuarioPerfilDto dto = new UsuarioPerfilDto(
            perfilUsuario.getId(), 
            perfilUsuario.getNombre(), 
            perfilUsuario.getSaldo()
        );
        
        System.out.println("Perfil DTO del usuario " + id + " enviado correctamente.");
        return ResponseEntity.ok(dto);
    }
}