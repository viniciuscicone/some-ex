package com.example.kotlincrud.controller

import com.example.kotlincrud.model.Product
import com.example.kotlincrud.service.ProductService
import jakarta.validation.Valid
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/products")
class ProductController(private val productService: ProductService) {

    @GetMapping
    fun findAll(): ResponseEntity<List<Product>> =
        ResponseEntity.ok(productService.findAll())

    @GetMapping("/{id}")
    fun findById(@PathVariable id: Long): ResponseEntity<Product> =
        ResponseEntity.ok(productService.findById(id))

    @PostMapping
    fun create(@Valid @RequestBody product: Product): ResponseEntity<Product> =
        ResponseEntity.status(HttpStatus.CREATED)
            .body(productService.save(product))

    @PutMapping("/{id}")
    fun update(
        @PathVariable id: Long,
        @Valid @RequestBody product: Product
    ): ResponseEntity<Product> =
        ResponseEntity.ok(productService.update(id, product))

    @DeleteMapping("/{id}")
    fun delete(@PathVariable id: Long): ResponseEntity<Unit> {
        productService.delete(id)
        return ResponseEntity.noContent().build()
    }
} 