package com.mabaya.repository;

import com.mabaya.model.Product;
import com.mabaya.model.ProductCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.Repository;

import java.util.List;

/**
 * @author Daniil Tyshchenko
 * @version 0.0.1
 * @since 0.0.1
 */
public interface ProductRepository extends JpaRepository<Product, Long> {

    List<Product> findAllByCategory(ProductCategory category);

}
