package com.duoc.deepwallet.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.duoc.deepwallet.model.PerfilUsuario;

@Repository
public interface PerfilUsuarioRepository extends JpaRepository<PerfilUsuario, Integer> {
}