package com.duoc.deepwallet.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.duoc.deepwallet.model.PerfilUsuario;
import com.duoc.deepwallet.repository.PerfilUsuarioRepository;

@Service
public class PerfilUsuarioService {
    
    @Autowired
    private PerfilUsuarioRepository perfilUsuarioRepository;

    public List<PerfilUsuario> getPerfilUsuarios() {
        return perfilUsuarioRepository.findAll();
    }

    public PerfilUsuario savePerfilUsuario(PerfilUsuario perfilUsuario) {
        return perfilUsuarioRepository.save(perfilUsuario);
    }

    public PerfilUsuario getPerfilUsuarioId(int id) {
        return perfilUsuarioRepository.findById(id).orElse(null);
    }

    public PerfilUsuario updatePerfilUsuario(PerfilUsuario perfilUsuario) {
        if (perfilUsuario.getId() == null || !perfilUsuarioRepository.existsById(perfilUsuario.getId())) {
            return null;
        }
        return perfilUsuarioRepository.save(perfilUsuario);
    }

    public void deletePerfilUsuario(int id) {
        perfilUsuarioRepository.deleteById(id);
    }
}