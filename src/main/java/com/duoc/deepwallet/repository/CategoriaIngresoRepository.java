package com.duoc.deepwallet.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.duoc.deepwallet.model.CategoriaIngreso;

@Repository
public interface CategoriaIngresoRepository extends JpaRepository<CategoriaIngreso, Integer> {
}