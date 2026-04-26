package com.api.estudos.springproductapiprojections.service;

import java.math.BigDecimal;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.api.estudos.springproductapiprojections.model.Product;
import com.api.estudos.springproductapiprojections.projections.ProductProjection;
import com.api.estudos.springproductapiprojections.repository.ProductRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProductService {
    
    private final Logger logger = LoggerFactory.getLogger(ProductService.class);

    private final ProductRepository productRepository;

    public List<Product> findAll(){
        logger.info("Buscando todos os Product");
        return productRepository.findAll();
    }

    public Product save(Product product){
        logger.info("Salvando novo Product");
        return productRepository.save(product);
    }

    public List<Product> saveAll(List<Product> products){
        logger.info("Salvando uma lista de Product");
        return productRepository.saveAll(products);
    }


    public List<ProductProjection> findAllNameAndPrice(){
        logger.info("Buscando apenas name e price de todos os Product");
        return productRepository.findNameAndPrice();
    }

    public List<ProductProjection> findByPriceGreaterThan(BigDecimal price){
        logger.info("Buscando apenas name e price de todos os Product");
        return productRepository.findByPriceGreaterThan(price);
    }


}
