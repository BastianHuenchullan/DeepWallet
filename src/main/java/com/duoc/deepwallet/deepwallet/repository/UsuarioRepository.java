package com.duoc.deepwallet.deepwallet.repository;

import com.duoc.deepwallet.deepwallet.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {
}