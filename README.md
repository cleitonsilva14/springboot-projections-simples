# springboot-projections-simples

ProductProjection.java
```java 

package com.api.estudos.springproductapiprojections.projections;

import java.math.BigDecimal;

public interface ProductProjection {

    Long getCode();
    String getName();
    BigDecimal getPrice();

}


```


ProductRepository.java
```java 

@Repository
public interface ProductRepository extends JpaRepository<Product, UUID> {
    
    @Query("SELECT p.code AS code, p.name AS name, p.price AS price FROM Product p")
    List<ProductProjection> findNameAndPrice();

    List<ProductProjection> findByPriceGreaterThan(BigDecimal price);

}

```

ProductService.java
```java 

public List<ProductProjection> findAllNameAndPrice(){
    logger.info("Buscando apenas name e price de todos os Product");
    return productRepository.findNameAndPrice();
}

public List<ProductProjection> findByPriceGreaterThan(BigDecimal price){
    logger.info("Buscando apenas name e price de todos os Product");
    return productRepository.findByPriceGreaterThan(price);
}

```


ProductController.java
```java 

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

```

