package com.duoc.deepwallet.deepwallet.model;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "categoria_gastos")
public class CategoriaGasto {
    
    @OneToMany(mappedBy = "id_gasto")
    private List<Gasto> gastos;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_categoriagasto;

    @NotBlank
    private String nombre_categoria;
}