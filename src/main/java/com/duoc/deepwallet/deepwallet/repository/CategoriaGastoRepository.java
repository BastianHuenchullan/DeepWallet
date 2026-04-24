package com.duoc.deepwallet.deepwallet.repository;

import com.duoc.deepwallet.deepwallet.model.CategoriaGasto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoriaGastoRepository extends JpaRepository<CategoriaGasto, Integer> {
}