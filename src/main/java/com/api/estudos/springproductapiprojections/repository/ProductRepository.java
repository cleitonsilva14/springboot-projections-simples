package com.api.estudos.springproductapiprojections.repository;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.api.estudos.springproductapiprojections.model.Product;
import com.api.estudos.springproductapiprojections.projections.ProductProjection;
import java.math.BigDecimal;


@Repository
public interface ProductRepository extends JpaRepository<Product, UUID> {
    
    @Query("SELECT p.code AS code, p.name AS name, p.price AS price FROM Product p")
    List<ProductProjection> findNameAndPrice();

    List<ProductProjection> findByPriceGreaterThan(BigDecimal price);

}
