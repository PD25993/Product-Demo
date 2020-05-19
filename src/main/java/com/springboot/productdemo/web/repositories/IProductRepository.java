package com.springboot.productdemo.web.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springboot.productdemo.web.models.Product;

@Repository
public interface IProductRepository extends JpaRepository<Product, Integer>{

}
