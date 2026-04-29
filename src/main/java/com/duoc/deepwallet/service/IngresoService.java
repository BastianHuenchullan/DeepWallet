package com.duoc.deepwallet.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.duoc.deepwallet.model.Ingreso;
import com.duoc.deepwallet.repository.IngresoRepository;


@Service
public class IngresoService {
    
    @Autowired
    private IngresoRepository ingresoRepository;

    public List<Ingreso> getIngresos() {
        return ingresoRepository.findAll();
    }

    public Ingreso saveIngreso(Ingreso ingreso) {
        return ingresoRepository.save(ingreso);
    }

    public Ingreso getIngresoId(int id) {
        return ingresoRepository.findById(id).orElse(null);
    }

    public Ingreso updateIngreso(Ingreso ingreso) {
        if (ingreso.getId() == null || !ingresoRepository.existsById(ingreso.getId())) {
            return null;
        }
        return ingresoRepository.save(ingreso);
    }

    public void deleteIngreso(int id) {
        ingresoRepository.deleteById(id);
    }

}
