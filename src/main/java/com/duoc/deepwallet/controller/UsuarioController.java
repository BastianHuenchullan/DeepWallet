package com.duoc.deepwallet.controller;

import com.duoc.deepwallet.dto.UsuarioPerfilDto;
import com.duoc.deepwallet.model.Usuario;
import com.duoc.deepwallet.service.UsuarioService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping
    public ResponseEntity<List<Usuario>> listarUsuarios() {
        System.out.println("Obteniendo todos los usuarios.");
        return ResponseEntity.ok(usuarioService.getUsuarios());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Usuario> buscarUsuario(@PathVariable int id) {
        Usuario usuario = usuarioService.getUsuarioId(id);
    if (usuario == null) {
            System.out.println("No se ha encontrado el usuario con la id " + id + ".");
            return ResponseEntity.notFound().build();
        }
        System.out.println("El usuario con la id " + id + " fue encontrado.");
        return ResponseEntity.ok(usuario);
    }

    @PostMapping("/registro")
    public ResponseEntity<Usuario> registrarUsuario(@Valid @RequestBody Usuario usuario) {
        System.out.println("Agregando un usuario.");
        return ResponseEntity.status(HttpStatus.CREATED).body(usuarioService.saveUsuario(usuario));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Usuario> actualizarUsuario(@PathVariable int id, @Valid @RequestBody Usuario usuario) {
        usuario.setId(id);
        Usuario usuarioActualizado = usuarioService.updateUsuario(usuario);
        if (usuarioActualizado == null) {
            System.out.println("No se ha encontrado el usuario con la id " + id + ".");
            return ResponseEntity.notFound().build();
        }
        System.out.println("El usuario con la id " + id + " fue actualizado.");
        return ResponseEntity.ok(usuarioActualizado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarUsuario(@PathVariable int id) {
        usuarioService.deleteUsuario(id);
        System.out.println("El usuario con la id " + id + " ha sido eliminado.");
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}/perfil")
    public ResponseEntity<UsuarioPerfilDto> obtenerPerfilUsuario(@PathVariable int id) {
        Usuario usuario = usuarioService.getUsuarioId(id);
        if (usuario == null) {
            System.out.println("No se ha encontrado el usuario con la id " + id + ".");
            return ResponseEntity.notFound().build();
        }

        UsuarioPerfilDto dto = new UsuarioPerfilDto(
            usuario.getId(), 
            usuario.getNombre(), 
            usuario.getSaldo()
        );
        System.out.println("Perfil DTO del usuario " + id + " enviado correctamente.");
        return ResponseEntity.ok(dto);
    }
}