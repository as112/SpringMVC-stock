package com.example.stock.repo;

import com.example.stock.models.Product;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface ProductRepository extends CrudRepository<Product, Long> {

    @Query(value = "select * from product t where t.description = ?1", nativeQuery = true)
    Optional<Product> findByDescription(String description);
}