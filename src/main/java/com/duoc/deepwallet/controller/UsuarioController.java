package com.duoc.deepwallet.controller;

import com.duoc.deepwallet.dto.UsuarioPerfilDto;
import com.duoc.deepwallet.dto.UsuarioRegistroDto;
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
        return ResponseEntity.ok(usuarioService.getUsuarios());
    }

    @PostMapping("/registro")
    public ResponseEntity<UsuarioPerfilDto> registrarUsuario(@Valid @RequestBody UsuarioRegistroDto registroDto) {
        Usuario usuario = new Usuario();
        usuario.setNombre(registroDto.getNombreUsuario());
        usuario.setEmail(registroDto.getEmail());
        usuario.setPassword(registroDto.getPassword());
        
        Usuario guardado = usuarioService.saveUsuario(usuario);
        
        UsuarioPerfilDto perfil = new UsuarioPerfilDto(
            guardado.getId(), 
            guardado.getNombre(), 
            guardado.getEmail()
        );
        
        return ResponseEntity.status(HttpStatus.CREATED).body(perfil);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Usuario> buscarUsuario(@PathVariable int id) {
        Usuario usuario = usuarioService.getUsuarioId(id);
        if (usuario == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(usuario);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Usuario> actualizarUsuario(@PathVariable int id, @Valid @RequestBody Usuario usuario) {
        usuario.setId(id);
        Usuario actualizado = usuarioService.updateUsuario(usuario);
        if (actualizado == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(actualizado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarUsuario(@PathVariable int id) {
        usuarioService.deleteUsuario(id);
        return ResponseEntity.noContent().build();
    }
    
}