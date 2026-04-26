
package com.api.estudos.springproductapiprojections.controller;

import java.math.BigDecimal;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.api.estudos.springproductapiprojections.model.Product;
import com.api.estudos.springproductapiprojections.projections.ProductProjection;
import com.api.estudos.springproductapiprojections.service.ProductService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/product")
@RequiredArgsConstructor
public class ProductController {

    private final Logger logger = LoggerFactory.getLogger(ProductController.class);

    private final ProductService productService;

    @GetMapping
    public ResponseEntity<List<Product>> findAll() {
        return ResponseEntity
            .status(HttpStatus.OK)
            .body(productService.findAll());
    }

    @GetMapping("/name/price")
    public ResponseEntity<List<ProductProjection>> findAllNameAndPrice() {
        return ResponseEntity
            .status(HttpStatus.OK)
            .body(productService.findAllNameAndPrice());
    }

    @GetMapping("/search")
    public ResponseEntity<List<ProductProjection>> findByPriceGreaterThan(@RequestParam BigDecimal price) {
        return ResponseEntity
            .status(HttpStatus.OK)
            .body(productService.findByPriceGreaterThan(price));
    }
    

    @PostMapping
    public ResponseEntity<List<Product>> saveProduct(@RequestBody List<Product> products) {
        logger.info("Recebendo uma lista de Products={}", products.toString());

        return ResponseEntity
            .status(HttpStatus.CREATED)
            .body(productService.saveAll(products));
    }
    
}
