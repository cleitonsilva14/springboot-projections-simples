package com.api.estudos.springproductapiprojections.projections;

import java.math.BigDecimal;

public interface ProductProjection {

    Long getCode();
    String getName();
    BigDecimal getPrice();

}
