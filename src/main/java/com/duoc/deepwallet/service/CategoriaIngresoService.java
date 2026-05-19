package com.duoc.deepwallet.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.duoc.deepwallet.model.CategoriaIngreso;
import com.duoc.deepwallet.repository.CategoriaIngresoRepository;

@Service
public class CategoriaIngresoService {

    @Autowired
    private CategoriaIngresoRepository categoriaIngresoRepository;

    public List<CategoriaIngreso> getCategoriasIngresos() {
        return categoriaIngresoRepository.findAll();
    }

    public CategoriaIngreso saveCategoriaIngreso(CategoriaIngreso categoriaIngreso) {
        return categoriaIngresoRepository.save(categoriaIngreso);
    }

    public CategoriaIngreso getCategoriaIngresoId(int id) {
        return categoriaIngresoRepository.findById(id).orElse(null);
    }

    public CategoriaIngreso updateCategoriaIngreso(CategoriaIngreso categoriaIngreso) {
        if (categoriaIngreso.getId_categoriaingreso() == null || !categoriaIngresoRepository.existsById(categoriaIngreso.getId_categoriaingreso())) {
            return null;
        }
        return categoriaIngresoRepository.save(categoriaIngreso);
    }

    public void deleteCategoriaIngreso(int id) {
        categoriaIngresoRepository.deleteById(id);
    }
}