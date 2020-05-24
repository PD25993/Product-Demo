package com.springboot.productdemo.web.repositories;

import java.util.List;
import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springboot.productdemo.web.models.Category;
import com.springboot.productdemo.web.models.Product;

@Repository
public interface ICategoryRepository extends JpaRepository<Category, Integer>{
	//List<Category> findByProducts(Set<Product> products);
	
}
