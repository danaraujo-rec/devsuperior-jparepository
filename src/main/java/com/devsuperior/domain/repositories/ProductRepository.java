package com.devsuperior.domain.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.devsuperior.domain.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Long>{

}
