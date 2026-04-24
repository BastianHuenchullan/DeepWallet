package com.duoc.deepwallet.deepwallet.repository;

import com.duoc.deepwallet.deepwallet.model.CategoriaIngreso;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoriaIngresoRepository extends JpaRepository<CategoriaIngreso, Integer> {
}