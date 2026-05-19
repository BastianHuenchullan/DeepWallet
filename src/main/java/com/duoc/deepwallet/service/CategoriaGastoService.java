package com.duoc.deepwallet.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.duoc.deepwallet.model.CategoriaGasto;
import com.duoc.deepwallet.repository.CategoriaGastoRepository;

@Service
public class CategoriaGastoService {

    @Autowired
    private CategoriaGastoRepository categoriaGastoRepository;

    public List<CategoriaGasto> getCategoriasGastos() {
        return categoriaGastoRepository.findAll();
    }

    public CategoriaGasto saveCategoriaGasto(CategoriaGasto categoriaGasto) {
        return categoriaGastoRepository.save(categoriaGasto);
    }

    public CategoriaGasto getCategoriaGastoId(int id) {
        return categoriaGastoRepository.findById(id).orElse(null);
    }

    public CategoriaGasto updateCategoriaGasto(CategoriaGasto categoriaGasto) {
        if (categoriaGasto.getId_categoriagasto() == null || !categoriaGastoRepository.existsById(categoriaGasto.getId_categoriagasto())) {
            return null;
        }
        return categoriaGastoRepository.save(categoriaGasto);
    }

    public void deleteCategoriaGasto(int id) {
        categoriaGastoRepository.deleteById(id);
    }
}