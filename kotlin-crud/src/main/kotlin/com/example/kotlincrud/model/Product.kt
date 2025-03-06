package com.example.kotlincrud.model

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.Positive
import java.math.BigDecimal

@Entity
data class Product(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,

    @field:NotBlank(message = "Nome é obrigatório")
    val name: String,

    val description: String? = null,

    @field:Positive(message = "Preço deve ser maior que zero")
    val price: BigDecimal,

    val quantity: Int? = null
) 