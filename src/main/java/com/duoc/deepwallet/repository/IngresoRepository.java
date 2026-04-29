package com.duoc.deepwallet.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.duoc.deepwallet.model.Ingreso;

@Repository
public interface IngresoRepository extends JpaRepository<Ingreso, Integer> {
}