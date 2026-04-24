package com.duoc.deepwallet.deepwallet.repository;

import com.duoc.deepwallet.deepwallet.model.Gasto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GastoRepository extends JpaRepository<Gasto, Integer> {
}