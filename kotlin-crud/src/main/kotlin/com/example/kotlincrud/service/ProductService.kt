package com.example.kotlincrud.service

import com.example.kotlincrud.model.Product
import com.example.kotlincrud.repository.ProductRepository
import jakarta.persistence.EntityNotFoundException
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class ProductService(private val productRepository: ProductRepository) {

    fun findAll(): List<Product> = productRepository.findAll()

    fun findById(id: Long): Product = productRepository.findById(id)
        .orElseThrow { EntityNotFoundException("Produto não encontrado com ID: $id") }

    @Transactional
    fun save(product: Product): Product = productRepository.save(product)

    @Transactional
    fun update(id: Long, product: Product): Product {
        findById(id) // Verifica se existe
        return productRepository.save(product.copy(id = id))
    }

    @Transactional
    fun delete(id: Long) {
        val product = findById(id)
        productRepository.delete(product)
    }
} 