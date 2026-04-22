package com.duoc.deepwallet.deepwallet.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "gastos")
public class Gasto {

    @ManyToOne  
    private CategoriaGasto categoriaGasto;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_gasto;

    @NotNull
    private Integer valor;

    @NotBlank
    private String descripcion;
}