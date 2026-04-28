package com.duoc.deepwallet.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.duoc.deepwallet.model.CategoriaGasto;

@Repository
public interface CategoriaGastoRepository extends JpaRepository<CategoriaGasto, Integer> {
}