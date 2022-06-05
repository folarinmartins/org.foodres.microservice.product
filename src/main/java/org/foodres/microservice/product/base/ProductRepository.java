package org.foodres.microservice.product.base;

import org.springframework.data.repository.CrudRepository;;

public interface ProductRepository extends CrudRepository<Product, Long> {

}
