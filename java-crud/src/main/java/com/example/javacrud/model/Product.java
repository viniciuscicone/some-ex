package com.example.javacrud.model;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "Entidade que representa um produto")
public class Product {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(description = "ID do produto", example = "1")
    private Long id;
    
    @NotBlank(message = "Nome é obrigatório")
    @Schema(description = "Nome do produto", example = "Smartphone")
    private String name;
    
    @Schema(description = "Descrição do produto", example = "Um smartphone moderno")
    private String description;
    
    @Positive(message = "Preço deve ser maior que zero")
    @Schema(description = "Preço do produto", example = "999.99")
    private BigDecimal price;
    
    @Schema(description = "Quantidade em estoque", example = "10")
    private Integer quantity;
} 