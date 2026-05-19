package com.duoc.deepwallet.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.duoc.deepwallet.model.Gasto;
import com.duoc.deepwallet.repository.GastoRepository;

@Service
public class GastoService {

    @Autowired
    private GastoRepository gastoRepository;

    public List<Gasto> getGastos() {
        return gastoRepository.findAll();
    }

    public Gasto saveGasto(Gasto gasto) {
        return gastoRepository.save(gasto);
    }

    public Gasto getGastoId(int id) {
        return gastoRepository.findById(id).orElse(null);
    }

    public Gasto updateGasto(Gasto gasto) {
        if (gasto.getId() == null || !gastoRepository.existsById(gasto.getId())) {
            return null;
        }
        return gastoRepository.save(gasto);
    }

    public void deleteGasto(int id) {
        gastoRepository.deleteById(id);
    }
}